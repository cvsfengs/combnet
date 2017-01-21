package com.comb.upload.controller;

        import com.comb.commons.utils.result.DefaultViewResult;
        import org.apache.commons.lang.time.DateFormatUtils;
        import org.springframework.stereotype.Controller;
        import org.springframework.web.bind.annotation.RequestMapping;
        import org.springframework.web.multipart.MultipartFile;
        import org.springframework.web.multipart.MultipartHttpServletRequest;

        import javax.servlet.http.HttpServletRequest;
        import javax.servlet.http.HttpServletResponse;
        import java.io.File;
        import java.io.IOException;
        import java.util.HashMap;
        import java.util.Map;
        import java.util.Set;

/**
 * Created by ycfeng on 2016/9/26.
 */
@Controller
@RequestMapping("/upload")
public class UploadController {
//    @Autowired
//    private UploadService uploadService;
    @RequestMapping("doUpload")
    public void doUpload(HttpServletRequest request,HttpServletResponse response){
        //获取服务器项目路径
        String imgPath = request.getSession().getServletContext().getRealPath("/")+"static/imgs/";
       // String imgPath = new  File(new File(realPath).getParent()).getParent()+"/src/main/webapp/static/imgs/";;
        String date = DateFormatUtils.format(System.currentTimeMillis(), "yyyy-MM-dd");
        //上传目录全路径,无则创建
        //String file =realPath+"\\"+date;
        String file =imgPath+date;
        File newfile = new File(file);
        if(!newfile.exists())
        {
            newfile.mkdirs();
            System.out.println("目录不存在,创建目录成功===>"+file);
        }
        MultipartHttpServletRequest mrequst = (MultipartHttpServletRequest) request;
        Map<String, MultipartFile> fileMap = mrequst.getFileMap();
        Set<String> keySet = fileMap.keySet();
        //替换上传文件前缀
        String pre = null;
        //上传文件后缀
        String suf = null;
        //旧文件前缀
        String oldPreString = null;
        //状态
        int status = 0 ;
        Map<String,String> imgs = new HashMap<String, String>();
        for (String key : keySet)
        {
            //获取原文件全名称
            String originalFilename = fileMap.get(key).getOriginalFilename();
            oldPreString = originalFilename.split("\\.")[0];
            //新名称前缀
            pre = DateFormatUtils.format(System.currentTimeMillis(),"yyyyMMddHHmmss");
            //新文件后缀
            suf = originalFilename.substring(originalFilename.indexOf("."));
            MultipartFile multipartFile = fileMap.get(key);
            //界面对象
            //条件对象
            //	tag.setInBanchID(inBranchId);
            try {
                multipartFile.transferTo(new File(file+"\\"+pre+suf));
            } catch (IllegalStateException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println("保存路径===>"+file+"/"+pre+suf);
            imgs.put("img", "/xcore/static/imgs/"+date+"/"+pre +suf);
        }

        DefaultViewResult.defaultResult(response,imgs);
    }
/*
    @RequestMapping("doUpload")
    public void doUpload(HttpServletRequest request,HttpServletResponse response){
        Map<String,InputStream> mapFile = FileUtil.toInputStream(request);
        Set<String> keySet = mapFile.keySet();
        for (String key : keySet) {
            InputStream is = mapFile.get(key);
            String webStaticPath = SysUtil.getWebPath(request)+"static\\img\\";
            FileUtil.copyTO(is,webStaticPath+key);
        }
        DefaultViewResult.defaultResult(response,mapFile);
    }
*/
}
