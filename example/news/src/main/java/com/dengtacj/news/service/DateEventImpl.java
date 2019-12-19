package com.dengtacj.news.service;

import com.dengtacj.news.client.api.*;
import com.dengtacj.news.client.dto.*;
import com.dengtacj.news.client.dto.clientobject.*;
import com.dengtacj.news.common.MultiResponse;
import com.dengtacj.news.repository.DateEventRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2019/10/14 0014.
 */

@Slf4j
@Service
public class DateEventImpl implements DateEventServiceI {

    @Autowired
    DateEventRepository dateEventRepository;

    /**
     * 获取事件列表
     * @return
     */
    @Override
    public MultiResponse<DateEventCO> listDateEventQry(DateEventListQry req) {
        //List<DateEventCO> dateEventList = dateEventRepository.getDateEventList();

        log.info("DateEventImpl req.direction=" + req.getDirection());
        log.info("DateEventImpl req.startId=" + req.getStartId());

        MultiResponse multiResponse = new MultiResponse();

        return multiResponse;
    }

}
