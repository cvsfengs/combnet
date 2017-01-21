/**
 * Created by ycfeng on 2017/1/20.
 */
var PROXY = {
    getApiList:function(){
        $.ajax({
            url: "/combnet/apiProxy/getApiList.do",
            type: 'post',
            async: true,
            cache: false,
            //  dataType:'json',//预期服务器返回的数据类型,如果不指定，jQuery 将自动根据 HTTP 包 MIME 信息来智能判断
            data: {
                // requestType: requestType
            },
            success: function (data) {
                $("#show").val(JSON.stringify(data));
            },
            error: function (data) {
            }
        })
    },
    getVersionIpMenu:function(){
        $.ajax({
            url: "/combnet/apiProxy/getVersionIpMenu.do",
            type: 'post',
            async: true,
            cache: false,
            //  dataType:'json',//预期服务器返回的数据类型,如果不指定，jQuery 将自动根据 HTTP 包 MIME 信息来智能判断
            data: {
                //requestType: requestType
            },
            success: function (data) {
                $("#show").val(JSON.stringify(data));
            },
            error: function (data) {
            }
        })
    },
    doProxy:function(){
        $.ajax({
            url: "/combnet/apiProxy/doProxy.do",
            type: 'post',
            async: true,
            cache: false,
            //  dataType:'json',//预期服务器返回的数据类型,如果不指定，jQuery 将自动根据 HTTP 包 MIME 信息来智能判断
            data: {
                cid: $("#cid").val()
            },
            success: function (data) {
                $("#show").val(JSON.stringify(data));
            },
            error: function (data) {
            }
        })
    }


}
