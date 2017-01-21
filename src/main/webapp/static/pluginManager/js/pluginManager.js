/**
 * Created by ycfeng on 2016/9/27.
 */
var fun=function(data){
    return '<a href="javascript:void(0);" onclick="PLUGIN_MANAGER.jump(\''+data.href+'\');">'+data.desc+'</a></br>';
   // return '<a href="' + data.href + '" onclick="PLUGIN_MANAGER.jump(\''+data.href+'\');">'+data.desc+'</a></br>';
}
var PLUGIN_MANAGER = {
    requestURL:{
        getPluginList:"/xcore/pluginManager/getPluginList.do"
    },
    getPluginList:function(){
        $.ajax({
            url:this.requestURL.getPluginList,
            type:'post',
            async:true,
            cache:false,
            dataType:'json',
            data:{},
            success: function (data) {
                var menuList = data.menuList ;
                var result = PLUGIN_MANAGER.parse(data);
                document.getElementById("content").innerHTML=result;
            },
            error:function(data){

            }
        });
    },
    jump:function(href){
        $("#link").attr("src",href);
            //
            //$.ajax({
            //    async:false,
            //    url : href,
            //    success : function(result){
            //        $("#hiddenRealm").html();
            //        $("#hiddenRealm").html(result);
            //        var title = $("#hiddenRealm title").html();
            //        console.info(title);
            //    }
            //});
    }
    ,
    fun:function(){

    },
    tpl:function(){
        var tpl = '{@each pluginList as pl,index}' +
                        '${pl|pluginList}'+
                  '{@/each}';
        return tpl;
    },
    register:function(){
    },
    parse:function(data){
        var tpl = '{@each pluginList as pl,index}' +
                        '$${pl|pluginLists}' +
                    '{@/each}';
        juicer.register("pluginLists",fun);
        var temp = juicer(tpl,data);
        return temp ;
    }
}
$(function(){
    PLUGIN_MANAGER.getPluginList();
})





































