package com.comb.commons.utils.analysis;

import java.io.File;

/**
 * Created by Administrator on 2016/9/20.
 */
public class Main
{
    public static void main(String[] args) {
        //
        String in = "E:\\urm_log";
        String out = "E:\\.txt";
        String keyWord = "远程口" ;
        AnalysisFile analysisFile = new AnalysisFile();
        File inFile = new File(in);
        File outFile = new File(out);
        analysisFile.analysisFile(keyWord,inFile,outFile);
    }

}
