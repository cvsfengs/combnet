package ucmapi.generator.wiki.table;

import ucmapi.generator.wiki.pojo.BaseWikiPojo;

/**
 * Created on 2016/8/30.
 * 这样定义并不是一种好的实现方式,可以采用正则来匹配当前页面所有注释,IO流进行输入输出是将注解替换掉
 * 但是实现起来又比较别扭,实现过一小点,但是又给放弃了
 */
public class WikiGenerator {

     private static LayoutCreater creater = new LayoutCreater();
    /**
     * 创建布局表格
     */
    public static void createLayout(BaseWikiPojo baseWikiPojo){
        creater.createLayout(baseWikiPojo);
        System.out.println("输出表格成功");
    }

    /**
     * 获取一个表格实例
     */
    public static void getTable(Class clazz){
        creater.getTable(clazz);
        System.out.println("获取一个表格实例成功");
    }
    public static void createLayout(BaseWikiPojo baseWikiPojo,String file){
        creater.createLayout(baseWikiPojo,file);
        System.out.println("输出表格成功");
    }

    /**
     * 获取一个表格实例
     */
    public static void getTable(Class clazz,String file){
        creater.getTable(clazz,file);
        System.out.println("获取一个表格实例成功");
    }

}
