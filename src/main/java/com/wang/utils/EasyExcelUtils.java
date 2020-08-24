package com.wang.utils;
import com.alibaba.excel.EasyExcel;
import com.wang.entitys.BookEntity;
import com.wang.entitys.ColumnData;
import java.util.ArrayList;
import java.util.List;

/**
 * @author wangzg
 * @date 2020/8/24
 */
public class EasyExcelUtils {

    public static void simpleWrite(List<BookEntity> bookEntityList) {
        String fileName = "D:\\devEnv\\JsoupTest\\bookList" + System.currentTimeMillis() + ".xlsx";
        EasyExcel.write(fileName, ColumnData.class).sheet("书本详情").doWrite(data(bookEntityList));
        System.out.println("excel文件生成完毕...");
    }
    private static List<ColumnData> data(List<BookEntity> bookEntityList) {
        List<ColumnData> list = new ArrayList<>();
        bookEntityList.forEach(b -> {
            ColumnData data = ColumnData.builder()
                    .bookName(b.getBookName())
                    .starsCount(b.getStarsCount())
                    .author(b.getBookDetailInfo().getAuthor())
                    .bookImgUrl(b.getBookImgUrl())
                    .description(b.getDescription())
                    .price(b.getBookDetailInfo().getPrice())
                    .build();
            list.add(data);
        });
        return list;
    }
}
