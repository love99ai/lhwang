layui.use(['form','layer','laydate','table','laytpl'],function(){
    var form = layui.form,
        layer = parent.layer === undefined ? layui.layer : top.layer,
        $ = layui.jquery,
        laydate = layui.laydate,
        laytpl = layui.laytpl,
        table = layui.table;

    //新闻列表
    var tableIns = table.render({
        elem: '#newsList',
        url : '/admin/newsList',
        cellMinWidth : 95,
        page : true,
        height : "full-125",
        limit : 20,
        limits : [10,15,20,25],
        id : "newsListTable",
        where:{
            title:$(".searchVal").val(),
        },
        cols : [[
            {type: "checkbox", fixed:"left", width:50},
            {field: 'id', title: 'ID', width:60, align:"center"},
            {field: 'newsimg', title: '图标', align: "left", sort: false,
                templet:function (d) { return '<div><img src='+d.newsimg+'></div>' } },
            {field: 'newstitle', title: '文章标题', width:350},
            {field: 'newsdesc', title: '描述', align:'center'},
            {field: 'newstime', title: '创建时间', align:'center'},
            {field: 'isopen', title: '是否发布', align:'center', templet:function(d){
                if(d.isopen){
                    return '<input type="checkbox" name="newsTop" lay-filter="newsTop" value="'+d.id+'"  lay-skin="switch" lay-text="是|否"  checked>'
                }else {
                    return '<input type="checkbox" name="newsTop" lay-filter="newsTop" value="'+d.id+'"  lay-skin="switch" lay-text="是|否"  >'
                }

            }},

            {title: '操作', width:170, templet:'#newsListBar',fixed:"right",align:"center"}
        ]]
    });

    //是否置顶
    form.on('switch(newsTop)', function(data){
        var index = layer.msg('修改中，请稍候',{icon: 16,time:false,shade:0.8});
        $.ajax({
            type:"POST",
            url:"/admin/updateNewsOpen",
            data:{newsId:data.value,isOpen: data.elem.checked },
            dataType:"json",
            success:function(result) {
                layer.close(index);
                layer.msg("操作成功",{
                    time:3000
                });
            },
            error:function(result) {
                //......
                layer.close(index);
                layer.msg("操作失败",{
                    time:3000
                });
                // data.elem.prop('')
            }
        })
    })

    //搜索【此功能需要后台配合，所以暂时没有动态效果演示】
    $(".search_btn").on("click",function(){
        if($(".searchVal").val() != ''){
            table.reload("newsListTable",{
                page: {
                    curr: 1 //重新从第 1 页开始
                },
                where: {
                    key: $(".searchVal").val()  //搜索的关键字
                }
            })
        }else{
            layer.msg("请输入搜索的内容");
        }
    });

    //添加任务
    function addNews(edit){
        var title="添加文章";
        if (edit){
            title = "编辑文章"
        }
        var index = layui.layer.open({
            title : title,
            type : 2,
            content : "/admin/newsAddInit",
            success : function(layero, index){
                var body = layui.layer.getChildFrame('body', index);
                if(edit){
                    body.find("#newsId").val(edit.id);
                    body.find(".newsName").val(edit.newstitle);
                    body.find(".abstract").val(edit.newsdesc);
                    body.find(".thumbImg").attr("src",edit.newsimg);
                    body.find("#news_content").val(edit.newscontent);
                    form.render();
                }
                setTimeout(function(){
                    layui.layer.tips('点击此处返回任务列表', '.layui-layer-setwin .layui-layer-close', {
                        tips: 3
                    });
                },500)
            }
        })
        layui.layer.full(index);
        //改变窗口大小时，重置弹窗的宽高，防止超出可视区域（如F12调出debug的操作）
        $(window).on("resize",function(){
            layui.layer.full(index);
        })
    }
    $(".addNews_btn").click(function(){
        addNews();
    })

    //批量删除
    $(".delAll_btn").click(function(){
        var checkStatus = table.checkStatus('newsListTable'),
            data = checkStatus.data,
            newsId = [];
        if(data.length > 0) {
            for (var i in data) {
                newsId.push(data[i].id);
            }
            layer.confirm('确定删除选中的任务？', {icon: 3, title: '提示信息'}, function (index) {
                $.get("/admin/newsDel",{
                    newsIds : newsId.toString()  //将需要删除的newsId作为参数传入
                },function(data){
                tableIns.reload();
                layer.close(index);
                })
            })
        }else{
            layer.msg("请选择需要删除的任务");
        }
    })

    //列表操作
    table.on('tool(newsList)', function(obj){
        var layEvent = obj.event,
            data = obj.data;

        if(layEvent === 'edit'){ //编辑
            addNews(data);
        } else if(layEvent === 'del'){ //删除
            layer.confirm('确定删除此任务？',{icon:3, title:'提示信息'},function(index){
                $.get("/admin/newsDel",{
                    newsIds : data.id  //将需要删除的newsId作为参数传入
                },function(data){
                    tableIns.reload();
                    layer.close(index);
                })
            });
        } else if(layEvent === 'look'){ //预览
            layer.alert("此功能需要前台展示，实际开发中传入对应的必要参数进行任务内容页面访问")
        }
    });

})