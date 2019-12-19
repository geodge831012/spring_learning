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
import org.springframework.scheduling.annotation.Scheduled;

import com.dengtacj.news.infrastructure.database.info.dataobject.*;
import com.dengtacj.news.infrastructure.database.info.mapper.*;

import java.util.*;
import java.text.SimpleDateFormat;

/**
 * Created by geodgechen on 2019/12/19.
 * load news info from DB to Redis
 */

@Slf4j
@Component
public class LoadNewsInfoRepository {

    @Autowired
    EventMapper eventMapper;

    /**
     * 初始化
     */
    public int init() {
        return 0;
    }

    @Scheduled(cron="0/5 * * * * ? ")   //每5秒执行一次
    public void cronLoadNewsInfo() {

//        List<EventInfoDO> eventInfoList = eventMapper.listEventInfo();
//
//        log.info("eventInfoList.size:" + eventInfoList.size());
//
//        for (int i = 0; i < eventInfoList.size(); i++) {
//            //EventInfoDO e = (EventInfoDO)eventInfoList.get(i);
//            EventInfoDO e = eventInfoList.get(i);
//
//            //log.info("------------------DateEventRepository-----------------------");
//            log.info(e.getEventId());
//
//            log.info(e.getEventId() + ":" + e.getEventTitle() + ":" + e.getNewsNum() + ":" + e.getEventHot() + ":" + e.getCreateTime());
//        }
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        // new Date()为获取当前系统时间
        log.info(df.format(new Date()) + " cronLoadNewsInfo...");
    }

}
