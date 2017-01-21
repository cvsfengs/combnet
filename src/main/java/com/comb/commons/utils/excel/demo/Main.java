package com.comb.commons.utils.excel.demo;

import com.google.gson.Gson;
import com.comb.commons.utils.excel.original.OriginalExcel;
import com.comb.commons.utils.excel.pojo.BasicCapabilityInfo;
import com.comb.commons.utils.excel.pojo.ExcelReaderPOJO;
import com.comb.commons.utils.excel.pojo.ShenZhouCRMExcelDemo;

import java.io.File;
import java.util.List;
import java.util.Map;

/**
 * Created by ycfeng on 2016/9/2.
 */
public class Main {

    public static void main(String[] args) {
        long l = System.currentTimeMillis();
        OriginalExcel<ShenZhouCRMExcelDemo> originalExcel = new ExcelContainerImpl();
        ExcelReaderPOJO excelreader = new ExcelReaderPOJO();
        excelreader.setSheetIndex(0);
        excelreader.setReadIndex(0);
        excelreader.setFileName(new File("F:\\新建 Microsoft Excel 2007 工作表.xlsx"));
        Map<Integer, List<ShenZhouCRMExcelDemo>> integerListMap = originalExcel.originalExcelReaderByReadIndex(excelreader);
        Gson gson = new Gson();
        long dangqian = System.currentTimeMillis();
        System.out.println("------>"+dangqian);
        System.out.println(gson.toJson(integerListMap));
        System.out.println(System.currentTimeMillis()-dangqian);
        BasicCapabilityInfo excelInfo = originalExcel.getExcelInfo();
        System.out.println("获取size"+integerListMap.get(excelreader.getSheetIndex()).size());
        System.out.println("消耗时间-----》》》》"+excelInfo.getTaskTime());
      //  System.out.println("消耗时间-----》》》》"+ ExcelContainer.info.getTaskTime());
        long l1 = System.currentTimeMillis();
        System.out.println("共消耗了:"+(l1-l));
    }
}
