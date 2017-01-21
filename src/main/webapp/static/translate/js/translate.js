/**
 * Created by yc.feng on 2016/9/23.
 */

var TRANSLATE = {

    requestURL:{
        TRANSLATE:"/xcore/language/doTranslate.do"
    },
    getValue:function(id){
        return $("#"+id).combobox('getValue');
    },
    doTranslate: function () {
        var fromId = TRANSLATE.getValue("fromId");
        var toId = TRANSLATE.getValue("toId");
        var fromValue = $("#fromValue").val();
        $.ajax({
            url:TRANSLATE.requestURL.TRANSLATE,
            type:'post',
            async:true,
            cache:false,
            data:{
                fromId:fromId,
                fromValue:fromValue,
                toId:toId
            },
            success: function (data) {
                $("#toValue").val(data.dst);
            },
            error:function(data){
                alert("参数解析错误")
            }
        })
    }
}




















