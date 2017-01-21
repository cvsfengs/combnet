package ucmapi.generator.code.cst;

/**
 * Created by ycfeng on 2016/8/30.
 */
public class GeneratorCst {
    /**
     * 默认文件后缀
     */
    public static String SUFFIX = ".java";
    /**
     * 包
     */
    public static String PACKAGE = "package ";
    /**
     * 导入
     */
    public static String IMPORT = "import ";
    //   public static String DEFAULT_PACKAGE_NAME = "\\src\\main\\java\\com\\xuser\\commons\\utils\\codes\\test\\;" ;
    /**
     * 默认包路径
     */
    public static String DEFAULT_PACKAGE_NAME = "com.uc.mapi.fcar.adapters;";

    public static String DEFAULT_PREFFIX = "\\src\\main\\java\\";
    /**
     * 默认serverid
     */
    public static String DEFAULT_SERVER_ID = "emptyServiceCom";
    /**
     * 默认导入包
     */
    public static String DEFAULT_COMMONABSTRACTADAPTER = "com.uc.mapi.adapter.CommonAbstractAdapter;\n";
    public static String DEFAULT_INANN = "com.uc.mapi.intercepts.base.InAnn;\n";
    public static String DEFAULT_SANFROIDCHECKLOGIN = "com.uc.mapi.intercepts.sandroid.SAndroidCheckLoginIntercept;\n";
    public static String DEFAULT_VERSIONCHECK = "com.uc.mapi.intercepts.sandroid.VersionIntercept;\n";
    public static String DEFAULT_RESULT = "com.uc.ucBase.common.resultUtil.ResultObject;\n";
    public static String DEFAULT_REQUESTCONTEXT = "com.zuche.baseModules.openAPI.core.context.RequestContext;\n";
    public static String DEFAULT_LOGGER = "org.slf4j.Logger;\n";
    public static String DEFAULT_ADAPTERDESC = "com.zuche.baseModules.openAPI.annotation.AdapterDesc;\n";
    public static String DEFAULT_EXCEPTION = "com.uc.mapi.intercepts.common.ExceptionIntercept;\n";
    public static String DEFAULT_LOGGERFACTORY = "org.slf4j.LoggerFactory;\n";

}
