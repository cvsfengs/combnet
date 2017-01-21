package com.comb.commons.utils.analysis;

import java.io.File;

/**
 * Created by Administrator on 2016/9/20.
 */
public class Main
{
    public static void main(String[] args) {
        //
        String in = "E:\\uccrm_log";
        String out = "E:\\uccrm_log.txt";
        String keyWord = "远程开始调用获取客户意向接口" ;
        AnalysisFile analysisFile = new AnalysisFile();
        File inFile = new File(in);
        File outFile = new File(out);
        analysisFile.analysisFile(keyWord,inFile,outFile);
    }

}
