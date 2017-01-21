/**
 * Created by ycfeng on 2016/10/8.
 */

var SITECOLLECTMANAGER = {
    requestURL:{
        site_update:"/xcore/siteCollectManager/collectUpdate.do" ,
        site_remove:"/xcore/siteCollectManager/menuRemove.do",
        site_modify:"/xcore/siteCollectManager/saveParentMenu.do",
        site_search:"/xcore/siteCollectManager/getAllParentMenu.do"
    },
    defaultCst:{
        //新增
        add:"add",
        update:"update"
    },

    /*************布局*********************/
    layOut: {
        site_open:function(){
            $("#type").val("add");
            $('#addSite').window('open');
        },
        //数据更新
        site_update:function(){
            var url;
            var obj = new Object();
            obj.content = $("#content").val();
            obj.isUse = $("#isUse").val();
            obj.url = $("#url").val();
            if($("#type").val()==SITECOLLECTMANAGER.defaultCst.add){
                obj.type = SITECOLLECTMANAGER.defaultCst.add;
            }else if($("#type").val()==SITECOLLECTMANAGER.defaultCst.update){
                obj.type = SITECOLLECTMANAGER.defaultCst.update;
                obj.collectId = $("#collectId").val();
            }
            /**
             * 新增
             */
            $.ajax({
                url:SITECOLLECTMANAGER.requestURL.site_update,
                type:'post',
                async:true,
                cache:false,
                //  dataType:'json',//预期服务器返回的数据类型,如果不指定，jQuery 将自动根据 HTTP 包 MIME 信息来智能判断
                data:{
                    obj:JSON.stringify(obj)
                },
                success: function (data) {
                    $.messager.alert("",'新增菜单成功');
                    $('#add').window('close');
                    window.location.reload();

                }
                ,
                error:function(data){
                    alert("保存菜单居然失败了")
                }
            })
        },
        /**
         * 站点详情
         */
        site_detail:function(){

        }
    }
}
$(function () {
    $('#addSite').window('closed');
})

