package ucmapi.generator;

import ucmapi.generator.code.SimpleGeneratorCode;
import ucmapi.generator.code.pojo.ClazzInfo;

/**
 * Created by ycfeng on 2016/8/30.
 * 投机取巧:简单代码生成
 */
public class CodeSimpleGeneratorTest {


    public static void main(String[] args) {
        SimpleGeneratorCode simpleGeneratorCode = new SimpleGeneratorCode();
        ClazzInfo info = new ClazzInfo();
        info.setClazzName("FinApproveVehicleAdapter");
        info.setApiUrl("/action/fcar/finApproveVehicleAdapter");
        info.setResponseType("ResultObject<Object>");
        info.setRequestType("Object");
        boolean b = simpleGeneratorCode.writeCode(info);
    }
}
