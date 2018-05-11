package ucmapi.generator.code;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.SystemUtils;
import ucmapi.generator.code.cst.GeneratorCst;
import ucmapi.generator.code.pojo.ClazzInfo;

import java.io.*;

/**
 * Created by on 2016/8/30.
 */
public class SimpleGeneratorCode extends GeneratorFile{
    /**
     * 获取当前项目所在路径
     */
    private static String PROJECT_DIR = SystemUtils.getUserDir().getPath();

    /**
     * 写code
     */
    public boolean writeCode(ClazzInfo info){

        try {
            OutputStream os  = null ;
            String packageSrc = info.getPackageSrc();
            String packPath = packageSrc.replace(";", "").replace(".","\\")+"\\";
            String file = PROJECT_DIR+ GeneratorCst.DEFAULT_PREFFIX+packPath+info.getClazzName()+ GeneratorCst.SUFFIX;

            if(super.fileNotExistCreate(file)) {
               os = new FileOutputStream(new File(file));
            }
            String code = super.generatorCoding(info);
            IOUtils.write(code, os);
            System.out.println(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false ;
    }

}
