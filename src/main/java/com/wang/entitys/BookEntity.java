package com.wang.entitys;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

/**
 * @author wangzg
 * @date 2020/8/23
 */
@Data
@Builder
@ToString
public class BookEntity {

    private String id;
    private String bookName;
    private String starsCount;
    private String author;
    private String bookImgUrl;
//    private String price;
    private String detailPageUrl;
    private String description;
    private BookDetailInfo bookDetailInfo;
}
