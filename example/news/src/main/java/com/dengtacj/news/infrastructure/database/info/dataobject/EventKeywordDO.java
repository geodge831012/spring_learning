package com.dengtacj.news.infrastructure.database.info.dataobject;

import lombok.Data;

import java.math.BigDecimal;

/**
 * Created by Administrator on 2019/10/15 0015.
 */

@Data
public class EventKeywordDO {
    /**
     * 事件uuid
     */
    //private Long eventId;
    /**
     * 事件关键字
     */
    //private String keyword;
    /**
     * 本关键字的tfidf值最大值
     */
    //private BigDecimal weight;
    /**
     * 本关键字类型,0-未知,1-主关键词,2-副关键词
     */
    //private Integer type;

    int     iEventId;
    String  sKeyword;
    float   fWeight;
    int     iType;
}
