package com.wang.entitys;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Builder;
import lombok.Data;

/**
 * @author wangzg
 * @date 2020/8/24
 */
@Data
@Builder
public class ColumnData {

    @ExcelProperty("书名称")
    private String bookName;

    @ExcelProperty("评分")
    private String starsCount;

    @ExcelProperty("作者")
    private String author;

    @ExcelProperty("封面图片")
    private String bookImgUrl;

    @ExcelProperty("简介")
    private String description;

    @ExcelProperty("单价")
    private String price;
}
