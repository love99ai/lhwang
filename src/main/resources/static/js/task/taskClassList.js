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
        url : '/admin/taskClassList',
        cellMinWidth : 95,
        page : true,
        height : "full-125",
        where:{
            title:$(".searchVal").val(),
        },
        limit : 10,
        limits : [10,15,20,25],
        id : "newsListTable",
        cols : [[
            {type: "checkbox", fixed:"left", width:50},
            {field: 'id', title: 'ID', width:60, align:"center"},
            // {field: 'taskimg', title: '图标', align: "left", sort: false,
            //     templet:function (d) { return '<div><img src='+d.taskimg+'></div>' } },
            {field: 'classname', title: '类别名', width:350},
            // {field: 'taskdesc', title: '任务描述', align:'center'},
            // {field: 'className', title: '任务类型', align:'center'},
            // {field: 'releasetime', title: '发布时间', align:'center'},
            // {field: 'createtime', title: '创建时间', align:'center'},
            // {field: 'taskprice', title: '任务单价', align:'center', templet:function(d){
            //     return '<span class="layui-red">￥'+d.taskprice+'</span>'
            // }},
            // // {field: 'taskstate', title: '发布状态',  align:'center',templet:"#taskState"},
            // // {field: 'newsLook', title: '浏览权限', align:'center'},
            // {field: 'taskState', title: '是否开启', align:'center', templet:function(d){
            //     if(d.taskstate == 2){
            //         return '<span class="layui-blue">等待审核</span>'
            //     }else  if(d.taskstate == 1) {
            //         return '<input type="checkbox" name="taskState" lay-filter="taskState" value="'+d.id+'" lay-skin="switch" lay-text="是|否" checked>'
            //     }else {
            //         return '<input type="checkbox" name="taskState" lay-filter="taskState" lay-skin="switch" value="'+d.id+'" lay-text="是|否" >'
            //     }
            // }},

            {title: '操作', width:170, templet:'#newsListBar',fixed:"right",align:"center"}
        ]]
    });

    //修改任务状态
    form.on('switch(taskState)', function(data){
        var index = layer.msg('修改中，请稍候',{icon: 16,time:false,shade:0.8});
        var state = data.elem.checked ? 1 :0;
        $.ajax({
            type:"POST",
            url:"/admin/updateTaskState",
            data:{taskid:data.value,taskState:state},
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

    //添加文章
    function addNews(edit){

        var title="添加类别";
        if (edit){
            title = "编辑类别"
        }
        var index = layui.layer.open({
            title : title,
            type : 2,
            skin: 'layui-layer-rim', //加上边框
            area: ['300px', '160px'], //宽高
            content : "/admin/taskClassAddInit",
            success : function(layero, index){
                var body = layui.layer.getChildFrame('body', index);
                if(edit){
                    body.find("#taskClassId").val(edit.id);
                    body.find(".newsName").val(edit.classname);
                    form.render();
                }
                // setTimeout(function(){
                //     layui.layer.tips('点击此处返回任务列表', '.layui-layer-setwin .layui-layer-close', {
                //         tips: 3
                //     });
                // },500)
            }
        })
        layui.layer.restore(index);
        //改变窗口大小时，重置弹窗的宽高，防止超出可视区域（如F12调出debug的操作）
        $(window).on("resize",function(){
            layui.layer.restore(index);
        })
    }
    $(".addNews_btn").click(function(){
        addNews();
    })



    //列表操作
    table.on('tool(newsList)', function(obj){
        var layEvent = obj.event,
            data = obj.data;

        if(layEvent === 'edit'){ //编辑
            addNews(data);
        } else if(layEvent === 'del'){ //删除
            layer.confirm('确定删除此分类？',{icon:3, title:'提示信息'},function(index){
                $.post("/admin/taskClassDel",{
                    taskClassId : data.id  //将需要删除的newsId作为参数传入
                },function(data){
                    tableIns.reload();
                    layer.close(index);
                })
            });
        } else if(layEvent === 'look'){ //预览
            layer.alert("此功能需要前台展示，实际开发中传入对应的必要参数进行文章内容页面访问")
        }
    });

})