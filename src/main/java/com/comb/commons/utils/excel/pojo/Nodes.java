package com.comb.commons.utils.excel.pojo;

import com.comb.commons.utils.excel.cst.ExcelCST;

/**
 * Created by ycfeng on 2016/9/1.
 * 节点信息相关类
 */
public class Nodes {
    /**
     * 一共多少列,默认十列
     */
    private Integer CellCountNum = ExcelCST.COUNT_CELL_NUM;

    public Integer getCellCountNum() {
        return CellCountNum;
    }

    public void setCellCountNum(Integer cellCountNum) {
        CellCountNum = cellCountNum;
    }
}
