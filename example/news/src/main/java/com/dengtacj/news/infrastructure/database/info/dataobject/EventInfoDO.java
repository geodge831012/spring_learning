package com.dengtacj.news.infrastructure.database.info.dataobject;

import lombok.Data;

/**
 * Created by Administrator on 2019/10/14 0014.
 */

@Data
public class EventInfoDO {
    public String  eventId;
    public String  eventTitle;
    public int     newsNum;
    public int     eventHot;
    public String  createTime;
}
