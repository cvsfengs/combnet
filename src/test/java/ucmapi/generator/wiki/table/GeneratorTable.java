package ucmapi.generator.wiki.table;

import org.apache.commons.lang.SystemUtils;
import ucmapi.generator.wiki.wikiannoation.ReflectAnnotation;
import ucmapi.generator.wiki.pojo.BaseWikiPojo;

import java.io.*;
import java.lang.reflect.Field;

/**
 * Created by ycfeng on 2016/8/30.
 */
public class GeneratorTable<Req,Rep> {

    //private static StringBuffer sb = new StringBuffer();

    private static String file = SystemUtils.getUserDir().getPath()+"\\src\\test\\resources\\tablecommons.txt";
    /**
     * 初始化table表格
     */
    public String initTable(Class clazz,BaseWikiPojo<Req,Rep> baseWikiPojo){
        /**
         * 获取声明的参数
         */
        Field[] paramFileds = clazz.getDeclaredFields();
        StringBuffer sb = new StringBuffer();
        sb.append("<div class=\"table-wrap\">\n" +
                "  <table class=\"confluenceTable tablesorter\">");
        sb.append(this.readTableFromRes(new File(file)));
        sb.append("<tbody>");
        for (Field paramName  : paramFileds) {
            sb.append("<tr>");
            /**
             * 列属性名称
             */
            String cell = paramName.getName();
            /**
             * 列属性简称
             */
            String paramTypeName = paramName.getType().getSimpleName();
            /**
             * 获取当前属性注解标记名称
             */
            ReflectAnnotation annotation = paramName.getAnnotation(ReflectAnnotation.class);
            /**
             * 获取标记值
             */
            String value = annotation.val();
            sb.append(this.stickTd(cell)).append(this.stickTd(paramTypeName)).
                    append(this.stickTd(value)).append(this.stickTd("")).
                    append(this.stickTd(baseWikiPojo.getIsLogin())).
                    append(this.stickTd("")).append(this.stickTd(String.valueOf(baseWikiPojo.getApiVersion())))
                    .append(this.stickTd(baseWikiPojo.getAppVersion())).append(this.stickTd("")).append(this.stickTd(""));
            sb.append("</tr>");
        }
        sb.append("</tbody>");
        sb.append("</table>");
        sb.append("</div>");

        return sb.toString() ;
    }
    public String paramTable(Class clazz){
        /**
         * 获取声明的参数
         */
        Field[] paramFileds = clazz.getDeclaredFields();
        StringBuffer sb = new StringBuffer();
        sb.append("<div class=\"table-wrap\">\n" +
                "  <table class=\"confluenceTable tablesorter\">");
        sb.append(this.readTableFromRes(new File(file)));
        sb.append("<tbody>");
        for (Field paramName  : paramFileds) {
            sb.append("<tr>");
            /**
             * 列属性名称
             */
            String cell = paramName.getName();
            /**
             * 列属性简称
             */
            String paramTypeName = paramName.getType().getSimpleName();
            /**
             * 获取当前属性注解标记名称
             */
            ReflectAnnotation annotation = paramName.getAnnotation(ReflectAnnotation.class);
            /**
             * 获取标记值
             */
            String value = annotation.val();
            sb.append(this.stickTd(cell)).append(this.stickTd(paramTypeName)).
                    append(this.stickTd(value)).append(this.stickTd("")).
                    append(this.stickTd("")).
                    append(this.stickTd("")).append(this.stickTd(""))
                    .append(this.stickTd("")).append(this.stickTd("")).append(this.stickTd(""));
            sb.append("</tr>");
        }
        sb.append("</tbody>");
        sb.append("</table>");
        sb.append("</div>");

        return sb.toString() ;
    }
    /**
     * 从配置文件读取固有的一些相似代码
     */
    private String readTableFromRes(File file){
        StringBuffer sb = new StringBuffer();
        BufferedReader reader = null;
        try {
            System.out.println("以行为单位读取文件内容，一次读一整行：");
            reader = new BufferedReader(new FileReader(file));
            String tempString = null;
            int line = 1;
            // 一次读入一行，直到读入null为文件结束
            while ((tempString = reader.readLine()) != null) {
                // 显示行号
                sb.append(tempString.trim());
                line++;
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e1) {
                }
            }
        }
        return sb.toString() ;
    }

    /**
     * 包裹粘连表格
     */
    private String stickTd(String var){
        return "<td colspan=\"1\" class=\"confluenceTd\">"+var+"</td>";
    }

    /**
     * 包裹粘连tr td
     */
    protected String stickTr(String desc,String val){
        String msg = "<tr>\n" +
                "      <th class=\"confluenceTh\">"+desc+"</th>\n" +
                "      <td class=\"confluenceTd\">\n" +val+
                "      </td>\n" +
                "    </tr>" ;


        return msg ;
    }
//    public static void main(String[] args) {
//        GeneratorTable generatorTable = new GeneratorTable();
//        System.out.println(generatorTable.readTableFromRes(new File(file)));
//    }
}
