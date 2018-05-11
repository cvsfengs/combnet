package com.comb.user.controller;

import com.google.gson.Gson;
import com.comb.commons.utils.excel.demo.ExcelContainerImpl;
import com.comb.commons.utils.excel.original.OriginalExcel;
import com.comb.commons.utils.excel.pojo.BasicCapabilityInfo;
import com.comb.commons.utils.excel.pojo.ExcelReaderPOJO;
import com.comb.commons.utils.excel.pojo.ExcelSheetDemoPojo;
import com.comb.commons.utils.file.FileUtil;
import com.comb.commons.utils.result.DefaultViewResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.util.List;
import java.util.Map;

/**
 * 文件上传
 */
@Controller
@RequestMapping("/user")
public class UploadDataController {


    @RequestMapping("upload")
    public void login(HttpServletRequest request,HttpServletResponse response){
        File file = FileUtil.toFile(request);
        OriginalExcel<ExcelSheetDemoPojo> originalExcel = new ExcelContainerImpl();
        ExcelReaderPOJO excelreader = new ExcelReaderPOJO();
        excelreader.setSheetIndex(0);
        excelreader.setFileName(file);
        Map<Integer, List<ExcelSheetDemoPojo>> integerListMap = originalExcel.originalExcelReader(excelreader);
        Gson gson = new Gson();
        System.out.println(gson.toJson(integerListMap));
        BasicCapabilityInfo excelInfo = originalExcel.getExcelInfo();
        System.out.println("获取size"+integerListMap.get(0).size());
        System.out.println(excelInfo.getTaskTime());
        long l1 = System.currentTimeMillis();
        DefaultViewResult.defaultResult(response, "success");
    }
}
