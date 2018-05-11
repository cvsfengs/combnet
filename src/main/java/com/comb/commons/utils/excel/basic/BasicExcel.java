package com.comb.commons.utils.excel.basic;

import com.comb.commons.utils.excel.cst.ExcelCST;
import com.comb.commons.utils.file.FileUtil;
import com.comb.exceptions.CommonsException;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.*;
import java.util.*;

/**
 * 获取一些excel常用源
 */
public abstract class BasicExcel<T> {
    /**
     * 获取excel工作薄
     */
    private static  ThreadLocal<Workbook> threadLocal = new ThreadLocal<Workbook>();

    /**
     * 用户自定义类
     */
    public abstract T absOver(Row row);

    /**
     * 获取工作薄
     */
    public static Integer lastRowNum ;
    public Workbook getWorkbook(File filePath) {
        if(!FileUtil.isFile(filePath)){
            throw new CommonsException("文件不存在!"+filePath);
        }
        try {
            Workbook workbook ;
            InputStream is = new FileInputStream(filePath);
            String suffix = FileUtil.getSuffix(filePath);
            if(suffix.equals(ExcelCST.EXTENSION_XLS)){
                workbook = new HSSFWorkbook(is);
                threadLocal.set(workbook);
                is.close();
                return workbook ;
            }else if(suffix.equals(ExcelCST.EXTENSION_XLSX)){
                workbook = new XSSFWorkbook(is);
                threadLocal.set(workbook);
                is.close();
                return workbook ;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null ;
    }
    /**
     * 获取对应sheet
     * T 返回类型
     * @return key:当前sheet索引,value:数据集合
     */
    public Map<Integer, List<T>> getNodesOnSheet(Integer sheetIndex) {
        if (sheetIndex == null) {
            return null;
        }
        Workbook workbook = threadLocal.get();
        Map<Integer, List<T>> rs = new HashMap<Integer, List<T>>();
        Sheet sheet = workbook.getSheetAt(sheetIndex);
        //获取最后一行
        lastRowNum = sheet.getLastRowNum();
        List<T> tempList = new ArrayList<T>();
        //TODO 这里可以优化成多线程读取
        for (int i = 0; i <= lastRowNum; i++) {
            Row row = sheet.getRow(i);//当前行,可认为每一行都是一个对象
            tempList.add(this.absOver(row)); //自定义列,只关心对象的存储
        }
        rs.put(sheetIndex, tempList);
        //清除本地线程
        this.destoryThread(threadLocal);
        return rs;
    }

    /**
     *
     * @param readIndex 从第几行开始读取
     * @param sheetIndex 第几个sheet页
     */
    public Map<Integer, List<T>> getNodesOnSheet(Integer readIndex,Integer sheetIndex) {
        if (sheetIndex == null||readIndex==null||readIndex<0) {
            return null;
        }
        Workbook workbook = threadLocal.get();
        Map<Integer, List<T>> rs = new HashMap<Integer, List<T>>();
        Sheet sheet = workbook.getSheetAt(sheetIndex);
        //获取最后一行
        int lastRowNum = sheet.getLastRowNum();
        List<T> tempList = new ArrayList<T>();
        //TODO 这里可以优化成多线程读取
        for (int i = readIndex; i <= lastRowNum; i++) {
            Row row = sheet.getRow(i);//当前行,可认为每一行都是一个对象
            tempList.add(this.absOver(row)); //自定义列,只关心对象的存储

        }
        rs.put(sheetIndex, tempList);
        //清除本地线程
        this.destoryThread(threadLocal);
        return rs;
    }

    /**
     * 销毁线程
     */
    private void destoryThread(ThreadLocal thread){
        try{
            System.out.println("开始清除本地线程!");
            thread.remove();
            System.out.println("清除本地的线程成功!");
        }catch (Exception e){
            System.out.println("无语,清除本地线程居然失败了.....");
            this.destoryThread(thread);
        }
    }
    /*************既然已经有高度自定义的行列属性下面方法就不太需要了************************/
    /**
     * excel表格每一行认为是一个对象
     * 将每一行进行对象的转换
     */
    @Deprecated
    public void rowToObject(){

    }

    /**
     * excel属性管理判断excel是什么属性
     */
    @Deprecated
    public void excelAttributeOperator(){

    }

}
