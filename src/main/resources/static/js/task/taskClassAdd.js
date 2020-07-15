layui.use(['form','layer','layedit','laydate','upload'],function(){
    var form = layui.form
        layer = parent.layer === undefined ? layui.layer : top.layer,
        laypage = layui.laypage,
        upload = layui.upload,
        layedit = layui.layedit,
        laydate = layui.laydate,
        $ = layui.jquery;


    form.verify({
        newsName : function(val){
            if(val == ''){
                return "类别名不能为空";
            }
        },
        // content : function(val){
        //     if(val == ''){
        //         return "任务内容不能为空";
        //     }
        // }
    })
    form.on("submit(addNews)",function(data){
        //截取任务内容中的一部分文字放入任务摘要
        // var abstract = layedit.getText(editIndex).substring(0,50);
        //弹出loading
        var index = top.layer.msg('数据提交中，请稍候',{icon: 16,time:false,shade:0.8});



        var urlPath = "/admin/taskClassAdd";
        if ($("#taskClassId").val()!==""){
            urlPath = "/admin/taskClassUpdate";
        }
        // 实际使用时的提交信息
        $.ajax({
            type:"POST",
            url:urlPath,
            contentType: "application/json;charset=UTF-8",
            data:JSON.stringify({
                id: $("#taskClassId").val(),
                classname: $(".newsName").val(),  //任务标题
            }),
            dataType:"json",
            success:function(result) {
                //......
                // var jsonData  =  JSON.parse( JSON.stringify(result) );
                layer.msg("操作成功",{
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

    })






})