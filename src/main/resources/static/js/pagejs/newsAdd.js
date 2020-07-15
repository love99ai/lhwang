layui.use(['form','layer','layedit','laydate','upload'],function(){
    var form = layui.form
        layer = parent.layer === undefined ? layui.layer : top.layer,
        laypage = layui.laypage,
        upload = layui.upload,
        layedit = layui.layedit,
        laydate = layui.laydate,
        $ = layui.jquery;

    //用于同步编辑器内容到textarea
    layedit.sync(editIndex);

    // //上传缩略图
    upload.render({
        elem: '.thumbBox',
        url: '/admin/uploadImg',
        method : "post",  //此处是为了演示之用，实际使用中请将此删除，默认用post方式提交
        done: function(res, index, upload){
            // var num = parseInt(4*Math.random());  //生成0-4的随机数，随机显示一个头像信息
            $('.thumbImg').attr('src',res.url);
            $('.thumbBox').css("background","#fff");
        }
    });


    form.verify({
        newsName : function(val){
            if(val == ''){
                return "文章标题不能为空";
            }
        },
        // content : function(val){
        //     if(val == ''){
        //         return "文章内容不能为空";
        //     }
        // }
    })
    var urlPath = "/admin/newsAdd";
    if ($("#newsId").val()!==""){
        urlPath = "/admin/newsUpdate";
    }
    form.on("submit(addNews)",function(data){
        //截取文章内容中的一部分文字放入文章摘要
        var abstract = layedit.getText(editIndex).substring(0,50);
        //弹出loading
        var index = top.layer.msg('数据提交中，请稍候',{icon: 16,time:false,shade:0.8});
        // 实际使用时的提交信息
        $.ajax({
            type:"POST",
            url:urlPath,
            contentType: "application/json;charset=UTF-8",
            data:JSON.stringify({
                id: $("#newsId").val(),
                newstitle: $(".newsName").val(),  //任务标题
                newsdesc: $(".abstract").val(),  //任务摘要
                newscontent: layedit.getContent(editIndex).split('<audio controls="controls" style="display: none;"></audio>')[0],  //任务内容
                newsimg : $(".thumbImg").attr("src"),  //缩略图
            }),
            dataType:"json",
            success:function(result) {
                //......
                var jsonData  =  JSON.parse( JSON.stringify(result) );
                layer.msg(jsonData.msg,{
                    time:3000
                });
                top.layer.close(index);
                layer.closeAll("iframe");
                //刷新父页面
                parent.location.reload();
            },
            error:function(result) {
                //......
                layer.msg("操作失败",{
                    time:3000
                });
            }
        });

        return false;
    })

    //预览
    form.on("submit(look)",function(){
        layer.alert("此功能需要前台展示，实际开发中传入对应的必要参数进行文章内容页面访问");
        return false;
    })

    //创建一个编辑器
    var editIndex = layedit.build('news_content',{
        height : 535,
        uploadImage : {
            url: '/admin/uploadImgEdit',
        }
    });

})