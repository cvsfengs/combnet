/**
 * Created by ycfeng on 2016/7/29.
 * 用户模块相关js代码
 */

var USER = {
    /**
     * 用户模块相关请求url
     */
    requestURL:{
        login:"user/login.do" ,
        locationHref:"static/common/index.html"
    },
    /**
     *用户登录
     */
    login:function(){
       var email =  $("#email").val();
       var password= $("#password").val();
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
                window.location.href=USER.requestURL.locationHref;
            }
            ,
            error:function(data){
                alert("用户名或密码错误")
            }

        })
        $('#userForm').form('submit');
    },
    /**
     * 登录框重置
     */
    pswdReset: function () {
        $('#userForm').form('clear');
    }

}
$(function(){
    window.location.href="static/login/index.html";
})