package com.comb.commons.utils.excel.container;

import com.comb.commons.utils.excel.basic.BasicExcel;
import com.comb.commons.utils.excel.original.OriginalExcel;
import com.comb.commons.utils.excel.pojo.BasicCapabilityInfo;
import com.comb.commons.utils.excel.pojo.ExcelReaderPOJO;
import com.comb.commons.utils.excel.pojo.ExcelWriterPOJO;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * Created by ycfeng on 2016/9/1.
 */
public abstract class ExcelContainer<T> extends BasicExcel implements OriginalExcel<T>{
    public  BasicCapabilityInfo info = new BasicCapabilityInfo();
    /**
     * threadLocal 时间记录关键key
     */
    private static ThreadLocal<String> timeKey = new ThreadLocal<String>();
    /**
     * 根据时间获取相应value
     */
    private static ThreadLocal<Map<String,Long>> timeValue = new ThreadLocal<Map<String, Long>>();

    @Override
    public Map<Integer,List<T>> originalExcelReader(ExcelReaderPOJO readerPOJO) {
      //  Workbook workbook = super.getWorkbook(readerPOJO.getFileName());
        String key = UUID.randomUUID().toString();
        timeKey.set(key);
        Map<String,Long> mkey = new HashMap<String, Long>();
        mkey.put(timeKey.get(),System.currentTimeMillis());
        timeValue.set(mkey);
        //获取sheet 所有对象节点,并转成对象
        Map<Integer,List<T>> nodesOnSheet = (Map<Integer,List<T>>)super.getNodesOnSheet(readerPOJO.getSheetIndex());
        String endKey = timeKey.get();
        Map<String, Long> endMap = timeValue.get();
        Long endTime = endMap.get(endKey);
        info.setTaskTime(System.currentTimeMillis()-endTime);
        return nodesOnSheet;
    }
    @Override
    public Map<Integer,List<T>> originalExcelReaderByReadIndex(ExcelReaderPOJO readerPOJO) {
      //  Workbook workbook = super.getWorkbook(readerPOJO.getFileName());
        String key = UUID.randomUUID().toString();
        timeKey.set(key);
        Map<String,Long> mkey = new HashMap<String, Long>();
        mkey.put(timeKey.get(),System.currentTimeMillis());
        timeValue.set(mkey);
        //获取sheet 所有对象节点,并转成对象
        Map<Integer,List<T>> nodesOnSheet = (Map<Integer,List<T>>)super.getNodesOnSheet(readerPOJO.getReadIndex(),readerPOJO.getSheetIndex());
        String endKey = timeKey.get();
        Map<String, Long> endMap = timeValue.get();
        Long endTime = endMap.get(endKey);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        info.setTaskTime(System.currentTimeMillis()-endTime);
        return nodesOnSheet;
    }


    @Override
    public Object originalExcelWriter(ExcelWriterPOJO readerPOJO) {
        return null;
    }
    @Override
    public BasicCapabilityInfo getExcelInfo() {
        return info;
    }
}
