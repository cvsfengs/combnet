/**
 * Created by ycfeng on 2016/9/27.
 */
var LOGIN = {
    requestURL:{
        login:"/user/login.do" ,
        locationHref:"/static/common/index.html"
    },
    is_hide:function(){
        $(".alert").animate({"top":"-40%"}, 300);
    },
    is_show:function(){
        $(".alert").show().animate({"top":"45%"}, 300);
    },
    doLogin:function(){
        var email =  $("#email").val();
        var password= $("#password").val();
        if(email == '' || password =='')
        {
            $("#ts").html("用户名或密码不能为空~");
            LOGIN.is_show();
            return false;
        }
        $.ajax({
            url:this.requestURL.login,
            type:'post',
            async:true,
            cache:false,
            dataType:'json',
            data:{
                email:email,
                password:password
            },
            success: function (data) {
                if(data.status==-10001){
                    $("#ts").html("用户名或密码错误");
                    LOGIN.is_show();
                }if(data.status==10001){
                    window.location.href=LOGIN.requestURL.locationHref;
                }
            },
            error:function(data){
                $("#ts").html("用户名或密码错误");
                LOGIN.is_show();
            }
        });
    },
    keyBlur:function(){
        $("#password").focus(function(){
            $(".softkeys").show();
        });/*.blur(function(){
            $(".softkeys").hide();
        });*/
    },
    bindKeyBoard:function(){
        $('.softkeys').softkeys({
            target : $('.softkeys').data('target'),
            layout : [
                [
                    ['`','~'],
                    ['1','!'],
                    ['2','@'],
                    ['3','#'],
                    ['4','$'],
                    ['5','%'],
                    ['6','^'],
                    ['7','&amp;'],
                    ['8','*'],
                    ['9','('],
                    ['0',')'],
                    ['-', '_'],
                    ['=','+'],
                    'delete'
                ],
                [
                    'q','w','e','r','t','y','u','i','o','p',
                    ['[','{'],
                    [']','}']
                ],
                [
                    'capslock',
                    'a','s','d','f','g','h','j','k','l',
                    [';',':'],
                    ["'",'&quot;'],
                    ['\\','|']
                ],
                [
                    'shift',
                    'z','x','c','v','b','n','m',
                    [',','&lt;'],
                    ['.','&gt;'],
                    ['/','?'],
                    ['@']
                ]
            ]
        });
    }
}
$(function(){
    $(".connect p").eq(0).animate({"left":"0%"}, 600);
    $(".connect p").eq(1).animate({"left":"0%"}, 400);
    LOGIN.bindKeyBoard();
    LOGIN.keyBlur();
    $(".softkeys").hide();
})






















