package ucmapi.generator.wiki.table;

import org.apache.commons.io.IOUtils;
import ucmapi.generator.code.GeneratorFile;
import ucmapi.generator.wiki.cst.WikiGeneratorCst;
import ucmapi.generator.wiki.pojo.BaseWikiPojo;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by ycfeng on 2016/8/30.
 * 布局组件穿件 创建者
 */
public class LayoutCreater extends GeneratorTable{

    private static GeneratorFile generatorFile = new GeneratorFile();
    /**
     * 创建布局
     */
    public String createLayout(BaseWikiPojo baseWikiPojo){
        StringBuffer sb = new StringBuffer();
        sb.append(super.stickTr("请求地址", baseWikiPojo.getUrl()));
        sb.append(super.stickTr("请求方式",baseWikiPojo.gethTTPType()));
        sb.append(super.stickTr("是否需要登录", baseWikiPojo.getIsLogin()));
        /**
         * 请求参数
         */
        Class requestType = baseWikiPojo.getRequestType();
        String request = super.initTable(requestType, baseWikiPojo);
        sb.append(super.stickTr("请求参数",request));
        sb.append(super.stickTr("请求示例",baseWikiPojo.getUrl()));
        /**
         * 响应参数
         */
        Class responseType = baseWikiPojo.getResponseType();
        String response = super.initTable(responseType, baseWikiPojo);
        sb.append(super.stickTr("响应参数", response));
        return sb.toString();
    }
    public String createLayout(BaseWikiPojo baseWikiPojo,String outFile){

        boolean b = generatorFile.fileNotExistCreate(outFile);
        System.out.println("创建目录成功:"+outFile);
        StringBuffer sb = new StringBuffer();
        sb.append("<table class=\"confluenceTable\">").append(WikiGeneratorCst.nextLine).append(WikiGeneratorCst.suojin).append("<tbody>");
        sb.append(WikiGeneratorCst.nextLine).append(WikiGeneratorCst.suojin).append(WikiGeneratorCst.suojin);
        sb.append(super.stickTr("请求地址", baseWikiPojo.getUrl()));
        sb.append(super.stickTr("请求方式",baseWikiPojo.gethTTPType()));
        sb.append(super.stickTr("是否需要登录", baseWikiPojo.getIsLogin()));
        /**
         * 请求参数
         */
        Class requestType = baseWikiPojo.getRequestType();
        String request = super.initTable(requestType, baseWikiPojo);
        sb.append(super.stickTr("请求参数",request));
        sb.append(super.stickTr("请求示例",baseWikiPojo.getUrl()));
        /**
         * 响应参数
         */
        Class responseType = baseWikiPojo.getResponseType();
        String response = super.initTable(responseType, baseWikiPojo);
        sb.append(super.stickTr("响应参数", response));
        sb.append("</tbody>").append("</table>");
        try {
            IOUtils.write(sb.toString(),new FileOutputStream(new File(outFile)));
            System.out.println("创建表格到指定目的源:"+outFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }

    /**
     * 返回一个table实例表格
     */
    public String getTable(Class clazz,String outFile){
        String paramTable = super.paramTable(clazz);
        boolean b = generatorFile.fileNotExistCreate(outFile);
        System.out.println("创建路径成功");
        try {
            IOUtils.write(paramTable,new FileOutputStream(new File(outFile)));
            System.out.println("创建表格到指定目的源:"+outFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return paramTable;
    }
    public String getTable(Class clazz){
        return super.paramTable(clazz);
    }

}
