/**
 * Created by Administrator on 2016/7/30.
 */

var MENU = {
    requestURL:{
        menu_update:"/xcore/menu/menuUpdate.do" ,
        menu_remove:"/xcore/menu/menuRemove.do",
        menu_modify:"/xcore/base/saveParentMenu.do",
        menu_search:"/xcore/base/getAllParentMenu.do"
    },
    defaultCst:{
        //新增
        add:"add",
        update:"update"
    },

/*************布局*********************/
    layOut: {
        menu_open:function(){
            $("#type").val("add");
            $('#addMenu').window('open');
        },
        //数据更新
        menu_update:function(){
            var url;
            var obj = new Object();
                obj.pName = $("#pName").val();
                obj.isUse = $("#isUse").val();
                obj.link = $("#link").val();
                obj.menuDesc = $("#menuDesc").val();
            if($("#type").val()==MENU.defaultCst.add){
                obj.type = MENU.defaultCst.add;
            }else if($("#type").val()==MENU.defaultCst.update){
                obj.type = MENU.defaultCst.update;
                obj.pId = $("#pId").val();
            }
            $.ajax({
                url:MENU.requestURL.menu_update,
                type:'post',
                async:true,
                cache:false,
                //  dataType:'json',//预期服务器返回的数据类型,如果不指定，jQuery 将自动根据 HTTP 包 MIME 信息来智能判断
                data:{
                    //pName:pName,
                    //isUse:isUse,
                    //link:link ,
                    //menuDesc:menuDesc
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
        //删
        menu_remove:function(){
           var row = $("#menuGrid").datagrid('getSelected');
            if (row){
                //$.messager.alert('Info', row.pId);
                $.ajax({
                    url:MENU.requestURL.menu_remove,
                    type:'post',
                    async:true,
                    cache:false,
                    //  dataType:'json',//预期服务器返回的数据类型,如果不指定，jQuery 将自动根据 HTTP 包 MIME 信息来智能判断
                    data:{
                        menuId:row.pId
                    },
                    success: function (data) {
                        $.messager.alert("",'删除成功');
                        //dataGrid - Reload
                        $("#menuGrid").datagrid("reload");
                        //window.location.reload();
                    }
                    ,
                    error:function(data){
                        alert("删除菜单居然失败了")
                    }
                })
            }
        },
        //改
        menu_modify:function(){
            //获取选中的一行
            var row = $("#menuGrid").datagrid('getSelected');
            if (row){
                //菜单id
                $("#pId").val(row.pId);
                $("#type").val("update");
                $("#pName").val(row.pName);
                $("#link").val(row.link);
                $("#menuDesc").val(row.menuDesc);
                $('#addMenu').window('open');
            }
        },
        //查
        menu_search:function(){

        }
    }
}
$(function () {
    $('#addMenu').window('closed');
})



