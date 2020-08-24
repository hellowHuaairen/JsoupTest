package com.wang.utils;
import com.wang.entitys.BookDetailInfo;
import com.wang.entitys.BookEntity;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author wangzg
 * @date 2020/8/23
 */
public class BookInfoUtils {

    public static List<BookEntity> getBookInfoList(String url) throws IOException {
        List<BookEntity>  bookEntities=new ArrayList<>();
        Document doc = Jsoup.connect(url).get();
        Elements liDiv = doc.select("#content > div > div.article > ul > li");
        for (Element li : liDiv) {
            Elements urls = li.select("a[href]");
            Elements imgUrl = li.select("a > img");
            Elements bookName = li.select(" div > h2 > a");
            Elements starsCount = li.select(" div > p.rating > span.font-small.color-lightgray");
            Elements author = li.select("div > p.color-gray");
            Elements description = li.select(" div > p.detail");

            String bookDetailUrl = urls.get(0).attr("href");
            BookDetailInfo detailInfo = getDetailInfo(bookDetailUrl);
            BookEntity bookEntity = BookEntity.builder()
                    .detailPageUrl(bookDetailUrl)
                    .bookImgUrl(imgUrl.attr("src"))
                    .bookName(bookName.html())
                    .starsCount(starsCount.html())
                    .author(author.text())
                    .bookDetailInfo(detailInfo)
                    .description(description.html())
                    .build();
//            System.out.println(bookEntity);
            bookEntities.add(bookEntity);
        }
        return bookEntities;
    }
    /**
     *
     * @param detailUrl
     * @return
     * @throws IOException
     */
    public static BookDetailInfo getDetailInfo(String detailUrl)throws IOException{

        Document doc = Jsoup.connect(detailUrl).get();
        Elements content = doc.select("body");

        Elements price = content.select("#buyinfo-printed > ul.bs.current-version-list > li:nth-child(2) > div.cell.price-btn-wrapper > div.cell.impression_track_mod_buyinfo > div.cell.price-wrapper > a > span");
        Elements author = content.select("#info > span:nth-child(1) > a");
        BookDetailInfo bookDetailInfo = BookDetailInfo.builder()
                .author(author.html())
                .authorUrl(author.attr("href"))
                .price(price.html())
                .build();
        return bookDetailInfo;
    }
}
