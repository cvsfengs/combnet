/**
 * Created by ycfeng on 2016/9/27.
 */
//$(function() {
//    $('#uploadify').uploadify({
//        'swf'      : '../../framework/uploadify/uploadify.swf',    //指定上传控件的主体文件
//        'uploader' : '/xcore/upload/doUpload.do',//指定服务器端上传处理文件
//        'buttonText':'上传',
//        'fileSizeLimit':10,//上传队列最大限制
//        'method':'post',    //上传方法
//        'multi':true,      //设置值为false时，一次只能选中一个文件
//        'removeTimeout':1,//设置上传完成后从上传队列中移除的时间（单位：秒）
//        'uploadLimit':10,//定义允许的最大上传数量。,
//        'auto':false ,//设置auto为true，当文件被添加至上传队列时，将会自动上传。
//        onUploadSuccess: function(file, data, response) {
//            console.info(file);
//            console.info(data);
//            console.info(response);
//        }
//    });
//});
/**
 * @type {{CST: {URL: {swf: string, uploader: string}, BindId: {id: string}}, doUpload: Function}}
 */
var UPLOAD = {
    CST:{
        URL:{
            swf:'../framework/uploadify/uploadify.swf',
            uploader:'/xcore/upload/doUpload.do'
        },
        Bind:{
            id:'#uploadify'
        },
        buttonText:{
            text:'上传'
        }
    },
    /**
     * 通用文件上传
     */
    commonUpload:function(){
        $(UPLOAD.CST.Bind.id).uploadify({
            'swf'      : UPLOAD.CST.URL.swf,    //指定上传控件的主体文件
            'uploader' : UPLOAD.CST.URL.uploader,//指定服务器端上传处理文件
            'buttonText':UPLOAD.CST.buttonText.text,
            'fileSizeLimit':'20MB',//上传队列最大限制
            'fileTypeExts': '*.gif; *.jpg; *.png; *.jpeg;*.bmp;*.swf;', //*.psd; *.wps; *.doc; *.dot; *.docx; *.rar; *.zip; *.pdf; *.xls; *.xlsx; *.xlt; *.xlsm; *.dif; *.txt; *.ppt; *.pot; *.dpt; *.pps',
            'method':'post',    //上传方法
            'multi':true,      //设置值为false时，一次只能选中一个文件
            'removeTimeout':1,//设置上传完成后从上传队列中移除的时间（单位：秒）
            'uploadLimit':500,//定义允许的最大上传数量。,
            'auto':false ,//设置auto为true，当文件被添加至上传队列时，将会自动上传。
            onUploadSuccess: function(file, data, response) {
                console.info(file);
                console.info(data);
                var obj = $.parseJSON(data);
                var path = obj.img;
                $("#imgId").attr('src',path);
                console.info(response);
            }
        });
    },
    /**
     * 迷你版文件上传
     */
    doUpload:function(obj){
        if(obj.requestUrl==null||obj.bindTag==null) {
           alert("必要参数[requestUrl,bindTag]不可为空");
           return;
        }
        $(obj.bindTag).uploadify({
            'swf'      : UPLOAD.CST.URL.swf,    //指定上传控件的主体文件
            'uploader' : obj.requestUrl,//指定服务器端上传处理文件
            'buttonText':'测试',
            'fileSizeLimit':500,//上传队列最大限制
            'method':'post',    //上传方法
            'multi':true,      //设置值为false时，一次只能选中一个文件
            'removeTimeout':1,//设置上传完成后从上传队列中移除的时间（单位：秒）
            'uploadLimit':10,//定义允许的最大上传数量。,
            'auto':true ,//设置auto为true，当文件被添加至上传队列时，将会自动上传。
            onUploadSuccess: function(file, data, response) {
                console.info(file);
                console.info(data);
                console.info(response);
            }
        });
    }
}
$(function () {
    UPLOAD.commonUpload();
})