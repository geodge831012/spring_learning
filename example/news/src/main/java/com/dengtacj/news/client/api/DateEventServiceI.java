package com.dengtacj.news.client.api;

import com.dengtacj.news.client.dto.clientobject.DateEventCO;
import com.dengtacj.news.client.dto.DateEventListQry;
import com.dengtacj.news.common.MultiResponse;

/**
 * Created by Administrator on 2019/10/14 0014.
 */

public interface DateEventServiceI {
    /**
     * 获取事件列表
     * @return
     */
    public MultiResponse<DateEventCO> listDateEventQry(DateEventListQry req);

}
