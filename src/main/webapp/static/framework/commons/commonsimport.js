var Commons = {

    CONSTANT : {
        jquery:"jquery-1.6.2.js",
        sysHost:"localhost"
    },
    EASYUI:{
        easyuicss:"easyui.css",
        easyuiicon:"icon.css",
        easyuicolor:"color.css",
        easyuidemocss:"demo.css",
        easyuijquery:"jquery.easyui.min.js"
    },
    importEasyUI:function(){
        var easyuiCSS = [
                            Commons.EASYUI.easyuicss,
                            Commons.EASYUI.easyuiicon,
                            Commons.EASYUI.easyuicolor,
                            Commons.EASYUI.easyuidemocss
                        ];
        var easyuiJS = [
            Commons.CONSTANT.jquery,
            Commons.EASYUI.easyuijquery
        ];
        for(var src in easyuiCSS){
            var node = document.createElement("link");
                node.rel="stylesheet";
                node.type = "text/css";
                node.href = src;
            document.getElementsByTagName("head")[0].appendChild(node);

        }
        for(var src in easyuiJS){
            var node = document.createElement("script");
            node.type = "text/javascript";
            node.src = src;
            document.getElementsByTagName("head")[0].appendChild(node);

        }
    }

}
window.onload=function(){
    Commons.importEasyUI();
}



































