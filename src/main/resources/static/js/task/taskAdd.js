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

    //格式化时间
    function filterTime(val){
        if(val < 10){
            return "0" + val;
        }else{
            return val;
        }
    }
    //定时发布
    var time = new Date();
    var submitTime = time.getFullYear()+'-'+filterTime(time.getMonth()+1)+'-'+filterTime(time.getDate())+' '+filterTime(time.getHours())+':'+filterTime(time.getMinutes())+':'+filterTime(time.getSeconds());
    laydate.render({
        elem: '#release',
        type: 'datetime',
        trigger : "click",
        done : function(value, date, endDate){
            submitTime = value;
        }
    });
    form.on("radio(release)",function(data){
        if(data.elem.title == "定时发布"){
            $(".releaseDate").removeClass("layui-hide");
            $(".releaseDate #release").attr("lay-verify","required");
        }else{
            $(".releaseDate").addClass("layui-hide");
            $(".releaseDate #release").removeAttr("lay-verify");
            submitTime = time.getFullYear()+'-'+(time.getMonth()+1)+'-'+time.getDate()+' '+time.getHours()+':'+time.getMinutes()+':'+time.getSeconds();
        }
    });

    form.on("radio(openness)",function(data){
        if(data.elem.title == "限制"){
            $(".releaseNum").removeClass("layui-hide");
            $(".releaseNum #releaseNum").attr("lay-verify","required");
        }else{
            $(".releaseNum").addClass("layui-hide");
            $(".releaseNum #releaseNum").removeAttr("lay-verify");
            // submitTime = time.getFullYear()+'-'+(time.getMonth()+1)+'-'+time.getDate()+' '+time.getHours()+':'+time.getMinutes()+':'+time.getSeconds();
        }
    });

    form.verify({
        newsName : function(val){
            if(val == ''){
                return "任务标题不能为空";
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

        var obj = document.getElementsByName("taskClass");
        var check_val = [];
        for(var k in obj){
            if(obj[k].checked)
                check_val.push(obj[k].value);
        }

        var urlPath = "/admin/taskAdd";
        if ($("#taskId").val()!==""){
            urlPath = "/admin/updateTask";
        }
        // 实际使用时的提交信息
        $.ajax({
            type:"POST",
            url:urlPath,
            contentType: "application/json;charset=UTF-8",
            data:JSON.stringify({
                id: $("#taskId").val(),
                tasktitle: $(".newsName").val(),  //任务标题
                taskdesc: $(".abstract").val(),  //任务摘要
                taskcontent: layedit.getContent(editIndex).split('<audio controls="controls" style="display: none;"></audio>')[0],  //任务内容
                taskimg : $(".thumbImg").attr("src"),  //缩略图
                taskclassid: check_val.toString(),    //任务分类
                releasetime: submitTime,    //发布时间
                isnum : $('input:radio[name="openness"]:checked').val()==1 , //是否限制个数
                tasknum:  $("#releaseNum").val(),
                taskprice:  $("#taskPrice").val(),
                taskurl:  $("#taskUrl").val(),
                // taststate: $("#taskState").val(),
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

    })


    //预览
    form.on("submit(look)",function(){
        layer.alert("此功能需要前台展示，实际开发中传入对应的必要参数进行任务内容页面访问");
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