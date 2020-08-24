package com.wang.entitys;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

/**
 * @author wangzg
 * @date 2020/8/24
 */
@Data
@Builder
@ToString
public class BookDetailInfo {

    private String author;
    private String authorUrl;
    private String price;
}
