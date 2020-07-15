layui.use(['form','layer','jquery'],function(){
    var form = layui.form,
        layer = parent.layer === undefined ? layui.layer : top.layer
        $ = layui.jquery;


    $(".loginBody .seraph").click(function(){
        layer.msg("这只是做个样式，至于功能，你见过哪个后台能这样登录的？还是老老实实的找管理员去注册吧",{
            time:5000
        });
    })

    //登录按钮
    form.on("submit(login)",function(data){
        $(this).text("登录中...").attr("disabled","disabled").addClass("layui-disabled");
        setTimeout(function(){
            $.ajax({
                type:"POST",
                url:"/admin/login",
                data:{userName:$('#userName').val(),password:$('#password').val()},
                dataType:"json",
                success:function(result) {
                    //......
                    var jsonData  =  JSON.parse( JSON.stringify(result) );
                    layer.msg(jsonData.msg,{
                        time:3000
                    });
                    //登录成功
                    if(jsonData.code === 200 ){
                        location.href = "/admin/index"
                    }else {
                        $('#loginBtn').text("登录").removeAttr("disabled").removeClass("layui-disabled");
                    }

                },
                error:function(result) {
                    //......
                    layer.msg("操作失败",{
                        time:3000
                    });
                    $('#loginBtn').text("登录").removeAttr("disabled").removeClass("layui-disabled");
                }
            })


            // $('#loginFrom').submit();
        },1000);
        return false;
    })

    //表单输入效果
    $(".loginBody .input-item").click(function(e){
        e.stopPropagation();
        $(this).addClass("layui-input-focus").find(".layui-input").focus();
    })
    $(".loginBody .layui-form-item .layui-input").focus(function(){
        $(this).parent().addClass("layui-input-focus");
    })
    $(".loginBody .layui-form-item .layui-input").blur(function(){
        $(this).parent().removeClass("layui-input-focus");
        if($(this).val() != ''){
            $(this).parent().addClass("layui-input-active");
        }else{
            $(this).parent().removeClass("layui-input-active");
        }
    })
})
