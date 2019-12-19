package com.dengtacj.news.repository;

import com.dengtacj.news.client.dto.clientobject.*;
import com.dengtacj.news.common.utils.CommonUtil;
import com.dengtacj.news.common.utils.DateUtil;
import com.dengtacj.news.common.utils.ProgressTimer;
import com.dengtacj.news.common.utils.SimilarEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import com.dengtacj.news.infrastructure.database.info.dataobject.*;
import com.dengtacj.news.infrastructure.database.info.mapper.*;

import java.util.*;

/**
 * Created by Administrator on 2019/10/14 0014.
 */

@Slf4j
@Component
public class DateEventRepository {

    @Autowired
    EventMapper eventMapper;

    /**
     * key: 事件id
     * value: 事件标题
     */
    public int init() {
        return 0;
    }

    public  int getResult() {

        List<EventInfoDO> eventInfoList = eventMapper.listEventInfo();

        log.info("eventInfoList.size:" + eventInfoList.size());

        for (int i = 0; i < eventInfoList.size(); i++) {
            //EventInfoDO e = (EventInfoDO)eventInfoList.get(i);
            EventInfoDO e = eventInfoList.get(i);

            //log.info("------------------DateEventRepository-----------------------");
            log.info(e.getEventId());

            log.info(e.getEventId() + ":" + e.getEventTitle() + ":" + e.getNewsNum() + ":" + e.getEventHot() + ":" + e.getCreateTime());
        }

        return 110;
    }

}
