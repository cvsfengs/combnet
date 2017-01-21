/**
 * Created by Administrator on 2016/7/30.
 */

var COMMON = {
    requestURL:{
        initRequest:"/xcore/base/getCity.do" ,
        locationHref:"static/common/index.html",
        saveMenu:"/xcore/base/saveParentMenu.do",
        getAllParentMenu:"/xcore/base/getAllParentMenu.do",
        addMenu:"addMenu.html"
    },
    dynamicCst:{

    },
/*************代码重构*********************/
    layOut:{
        //系统菜单初始化
        sysMenu_init:function(){
            $.ajax({
                url:COMMON.requestURL.getAllParentMenu,
                data:{},
                dataType:'json',
                success:function(data){
                    var obj = new Object();
                    for(var i =0 ;i<data.length;i++){
                        obj.href  = data[i].link ;
                        obj.title = data[i].pName ;
                        COMMON.layOut.sysMenu_add(obj);
                    }
                },
                error:function(data){

                }
            })
        },
        //系统菜单选中
        sysMenu_select:function(){

        },
        //系统菜单添加
        sysMenu_add:function(args){
            var obj = new Object();
                obj.title = args.title ;
                obj.href = args.href ;
            $("#parentMenu").accordion('add',{
                title:obj.title,
                content:"<div style='padding:10px'><a href='#' title='"+obj.title+"' id='"+obj.href+"' onclick=COMMON.func.sysTabButtonAdd(this) class='easyui-linkbutton' >"+obj.title+"</a><br></div>"
            });
        },
        //系统菜单修改
        sysMenu_modify:function(){

        }

    },
    /**
     * 系统功能菜单dataGrid
     */
    sysDataGrid:{
        //打开功能菜单添加面板
        openMenuAdd:function(){
            $('#addFunMenu').window('open');
        },
        //添加
        menuAdd:function(){
            $('#addFunMenu').window('open');
            var pName = $("#pName").val();
            var isUse = $("#isUse").val();
            var link = $("#link").val();
            var menuDesc = $("#menuDesc").val();
            $.ajax({
                url:COMMON.requestURL.saveParentMenu,
                type:'post',
                async:true,
                cache:false,
                //  dataType:'json',//预期服务器返回的数据类型,如果不指定，jQuery 将自动根据 HTTP 包 MIME 信息来智能判断
                data:{
                    pName:pName,
                    isUse:isUse,
                    link:link ,
                    menuDesc:menuDesc
                },
                success: function (data) {
                    $.messager.alert("",'新增菜单成功');
                    $('#addFunMenu').window('close');
                    window.location.reload();

                }
                ,
                error:function(data){
                    alert("保存菜单居然失败了")
                }
            })
        },
        menuCancel:function(){
            alert("取消保存")
        }
    },
    //系统功能
    func:{
        //系统功能添加
        sysTabButtonAdd: function (args) {
            $("#easytabs").tabs('add',{
                title:$(args).attr("title"),
                //href:$(args).attr("id"),
                content:"<iframe src="+$(args).attr("id")+" width='100%' height='100%'></iframe>",
                closable:true
            });
        }
    },
    //菜单管理
    menuManager:function(){
        var obj = new Object();
            obj.title = '菜单管理' ;
            obj.href = '../menuManager/index.html' ;
        COMMON.func.sysTabButtonAdd(obj);
    }
}
$(function(){
    $('#win').window('close');
    //初始化左侧菜单栏
    COMMON.layOut.sysMenu_init();
})






