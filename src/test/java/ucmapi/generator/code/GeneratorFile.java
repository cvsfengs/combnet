package ucmapi.generator.code;


import ucmapi.generator.code.cst.GeneratorCst;
import ucmapi.generator.code.pojo.ClazzInfo;
import ucmapi.generator.wiki.cst.WikiGeneratorCst;

import java.io.*;

/**
 * Created by ycfeng on 2016/8/30.
 */
public class GeneratorFile {

   public static String packageSuffix = GeneratorCst.PACKAGE ;
   public static String importSuffix = GeneratorCst.IMPORT ;

    /**
     * 组装代码
     */
    public String generatorCoding(ClazzInfo info){
        String head = this.codeHead(info);
        String body = this.codeBody(info);
        return head+body;
    }

    /**
     * 文件头
     * 简单生成常用代码,通用代码,省的总写
     */
    public String codeHead(ClazzInfo info){
        StringBuffer importDesc = new StringBuffer();
        importDesc.append(packageSuffix).append(info.getPackageSrc()+"\n").//包路径
                append(importSuffix).append(GeneratorCst.DEFAULT_COMMONABSTRACTADAPTER).//
                append(importSuffix).append(GeneratorCst.DEFAULT_INANN).//
                append(importSuffix).append(GeneratorCst.DEFAULT_SANFROIDCHECKLOGIN).//
                append(importSuffix).append(GeneratorCst.DEFAULT_VERSIONCHECK).//
                append(importSuffix).append(GeneratorCst.DEFAULT_RESULT).//
                append(importSuffix).append(GeneratorCst.DEFAULT_REQUESTCONTEXT).//
                append(importSuffix).append(GeneratorCst.DEFAULT_LOGGER).//
                append(importSuffix).append(GeneratorCst.DEFAULT_LOGGER).//
                append(importSuffix).append(GeneratorCst.DEFAULT_ADAPTERDESC).//
                append(importSuffix).append(GeneratorCst.DEFAULT_EXCEPTION).//
                append(importSuffix).append(GeneratorCst.DEFAULT_LOGGERFACTORY).//
                append("\n").append("\n");//
        return importDesc.toString();
    }

    /**
     * 文件体
     * 格式化代码,简单生成常用代码
     */
    public String codeBody(ClazzInfo info){
        StringBuffer str = new StringBuffer();
        str.append("@AdapterDesc(id =\"").append(info.getApiUrl() + "\"").append(",serviceId = \""+info.getServerId()).append("\")").append("\n")
            .append("@InAnn(clazz = {ExceptionIntercept.class, VersionIntercept.class, SAndroidCheckLoginIntercept.class})\n")
            .append("public class ").append(info.getClazzName()).append(" extends CommonAbstractAdapter<").append(info.getResponseType())
            .append(",").append(info.getRequestType()).append("> {\n\n")
            .append("\t Logger LOGGER = LoggerFactory.getLogger(").append(info.getClazzName()).append(".class);").append("\n\n")
            .append("\t@Override\n")
            .append("\t public ").append(info.getResponseType()).append(" execute() {")
            .append("\n\n")
            .append("\t\treturn null ;\n")
            .append("\t}\n")
            .append("}");
        return str.toString();
    }


    /**
     * 文件目录不存在则创建
     */
    public boolean fileNotExistCreate(String src){
        File file = new File(src);
        if(!file.getParentFile().exists()){
            try {
                file.getParentFile().mkdirs();
                file.createNewFile();
                return true ;
            } catch (IOException e) {
                System.out.println("文件创建失败,或不为文件:"+file.getPath()+"\n"+e);
                return false ;

            }
        }
        return true ;
    }
}
