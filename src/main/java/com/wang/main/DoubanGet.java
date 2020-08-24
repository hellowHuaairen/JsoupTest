package com.wang.main;
import com.wang.utils.BookInfoUtils;
import com.wang.utils.EasyExcelUtils;


import java.io.IOException;

/**
 * @author wangzg
 * @date 2020/8/23
 */
public class DoubanGet {
    public static void main(String[] args) throws IOException {
        String url = "https://book.douban.com/latest?icn=index-latestbook-all";
        EasyExcelUtils.simpleWrite(BookInfoUtils.getBookInfoList(url));
    }

}
