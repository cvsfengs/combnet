package com.comb.commons.utils.excel.pojo;

import com.comb.commons.utils.excel.cst.ExcelCST;

import java.io.File;

/**
 * excel 读
 */
public class ExcelReaderPOJO implements ExcelPOJO {
    /**
     * 文件路径
     */
    private File fileName;
    /**
     * 返回结果集类型
     */
    @Deprecated
    private Class clazz;
    /**
     * 当前sheet索引
     */
    private Integer sheetIndex ;
    /**
     * 从第几行开始读取
     */
    private Integer readIndex = ExcelCST.READINDEX;

    public Integer getReadIndex() {
        return readIndex;
    }

    public void setReadIndex(Integer readIndex) {
        this.readIndex = readIndex;
    }

    public File getFileName() {
        return fileName;
    }

    public void setFileName(File fileName) {
        this.fileName = fileName;
    }

    public Class getClazz() {
        return clazz;
    }

    public void setClazz(Class clazz) {
        this.clazz = clazz;
    }

    public Integer getSheetIndex() {
        return sheetIndex;
    }

    public void setSheetIndex(Integer sheetIndex) {
        this.sheetIndex = sheetIndex;
    }
}
