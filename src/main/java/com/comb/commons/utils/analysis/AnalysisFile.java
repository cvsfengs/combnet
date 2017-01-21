package com.comb.commons.utils.analysis;


import com.comb.commons.utils.property.PropertyUtil;

import java.io.*;

/**
 * Created by Administrator on 2016/9/20.
 * 文件分析工具类
 */
public class AnalysisFile {

    private AnalysisPoJo poJo;

    public AnalysisFile(){
        this.poJo=new AnalysisPoJo();
    }
    /**
     * 文件分析
     * @param keyWord 目标串
     * @param inFile 待分析文件
     * @param outFile 分析过后文件传输位置
     */
    public void analysisFile(String keyWord,File inFile,File outFile){
        try {
            String analysisLine = PropertyUtil.getValueByKey("analysisLine");
            int analysis = Integer.parseInt(analysisLine);
            poJo.setAnalysisTime(System.currentTimeMillis());//进行起始时间分析赋值
            poJo.setTarget(outFile);
            String line =  "" ;
            BufferedReader bf = new BufferedReader(new FileReader(inFile));
            BufferedWriter bw = new BufferedWriter(new FileWriter(outFile));
            int i = -1;
            while ((line=bf.readLine())!=null){
                if(line.contains(keyWord)){
                    bw.write(line+"\n");
                    i++;
                }else if(i<=analysis&&i>-1){
                    bw.write(line+"\n");
                    i++;
                }else if(i>=analysis){
                    i=-1;
                }
            }
            bw.close();
            bf.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public AnalysisPoJo getPoJo() {
        return poJo;
    }

    /**
     *  是否进行系统退出
     */
    public void exit(){
        System.out.println("系统退出了");
            System.exit(0);
    }

}