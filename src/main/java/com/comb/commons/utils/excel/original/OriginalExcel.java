package com.comb.commons.utils.excel.original;

import com.comb.commons.utils.excel.pojo.BasicCapabilityInfo;
import com.comb.commons.utils.excel.pojo.ExcelReaderPOJO;
import com.comb.commons.utils.excel.pojo.ExcelWriterPOJO;

import java.util.List;
import java.util.Map;

/**
 */
public interface OriginalExcel <T>{
    /**
     * 进行原始的excel读取
     */
    public Map<Integer,List<T>> originalExcelReader(ExcelReaderPOJO readerPOJO);

    /**
     * 从第几个cell index 进行读取
     */
    public Map<Integer,List<T>> originalExcelReaderByReadIndex(ExcelReaderPOJO readerPOJO);

    /**
     * 原始excel写入
     */
    public Object originalExcelWriter(ExcelWriterPOJO readerPOJO);

    /**
     * 获取excel一次操作所耗性能
     */
    public BasicCapabilityInfo getExcelInfo();

}
