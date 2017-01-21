package com.comb.commons.utils.excel.demo;

import com.comb.commons.utils.excel.container.ExcelContainer;
import com.comb.commons.utils.excel.pojo.ShenZhouCRMExcelDemo;
import org.apache.poi.ss.usermodel.Row;

/**
 * Created by ycfeng on 2016/9/2.
 */
public class ExcelContainerImpl extends ExcelContainer {
    @Override
    public Object absOver(Row row) {
//        //
//        ExcelSheetDemoPojo excelSheetDemoPojo = new ExcelSheetDemoPojo();
//        //第几个cell
//        Cell cell0 = row.getCell(0);
//        String stringCellValue0 = cell0.getStringCellValue();
//        excelSheetDemoPojo.setSimpleString(stringCellValue0);
//        Cell cell1 = row.getCell(1);
//        Double simpleDouble = cell1.getNumericCellValue();
//        excelSheetDemoPojo.setSimpleDouble(simpleDouble);
//        Cell cell2 = row.getCell(2);
//        Boolean simpleBoolean = cell2.getBooleanCellValue();
//        excelSheetDemoPojo.setSimpleBoolean(simpleBoolean);
        ShenZhouCRMExcelDemo crm = new ShenZhouCRMExcelDemo();
        crm.setMemberCode(row.getCell(0).getStringCellValue());
        crm.setMemberName(row.getCell(1).getStringCellValue());
        //crm.setMemberMobile(row.getCell(2).getStringCellValue());
        crm.setMemberLevel(row.getCell(3).getStringCellValue());
        crm.setMsgChannel(row.getCell(4).getStringCellValue());
        crm.setQiankelaiyuan(row.getCell(5).getStringCellValue());
        //crm.setMemberCode(row.getCell(6).getStringCellValue());
        //crm.setMemberCode(row.getCell(7).getStringCellValue());
        crm.setFirstDate(row.getCell(8).getStringCellValue());
        crm.setNextDate(row.getCell(9).getStringCellValue());
        crm.setPreTime(row.getCell(10).getStringCellValue());
        crm.setByStore(row.getCell(11).getStringCellValue());
    return crm;
    }
}
