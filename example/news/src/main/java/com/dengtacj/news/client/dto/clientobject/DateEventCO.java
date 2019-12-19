package com.dengtacj.news.client.dto.clientobject;

import lombok.Data;

import java.util.List;

/**
 * Created by Administrator on 2019/10/14 0014.
 */

@Data
public class DateEventCO {
    /**
     * 事件ID
     */
    String sDate;
    /**
     * 标签列表
     */
    List<String> listEvent;
}
