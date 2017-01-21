package ucmapi.generator;

import ucmapi.generator.wiki.cst.WikiGeneratorCst;
import ucmapi.generator.wiki.pojo.BaseWikiPojo;
import ucmapi.generator.wiki.table.WikiGenerator;
import ucmapi.generator.wiki.temp.ActivityVO;

/**
 * Created by ycfeng on 2016/8/31.
 *   时间有限,这种生成wiki的方法并不是太理想
 * 1.采用注解方式,有点过于反复操作
 * 2.解决办法可以用正则进行模板匹配,进行输出变量的替换
 * 3.或者用framework进行模板生成,但是framework我又不是太熟
 */
public class WikiGeneratorTest {

    public static void main(String[] args) {
        /**
         * 可以用正则来进行注解替换
         */
        BaseWikiPojo pojo = new BaseWikiPojo();
            pojo.setRequestType(null);
            pojo.setResponseType(null);
            pojo.setUrl("/action/vrms/getOutOrderList");
        //WikiGenerator.createLayout(pojo, WikiGeneratorCst.outPutSrc);
        WikiGenerator.getTable(Object.class,WikiGeneratorCst.outPutSrc);
    }

}
