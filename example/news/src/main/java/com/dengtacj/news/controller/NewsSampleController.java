package com.dengtacj.news.controller;

import com.dengtacj.news.client.api.*;
import com.dengtacj.news.client.dto.*;
import com.dengtacj.news.client.dto.clientobject.*;
import com.dengtacj.news.common.MultiResponse;
import com.dengtacj.news.common.SingleResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Administrator on 2019/9/24 0024.
 */
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class NewsSampleController {

    @Autowired
    DateEventServiceI dateEventService;

    @PostMapping(value = "/event/v1/date_event")
    public MultiResponse<DateEventCO>   listDateEvent(@RequestBody DateEventListQry req){
//        log.info("NewsSampleController req.direction=" + req.getDirection());
//        log.info("NewsSampleController req.startId=" + req.getStartId());
        return dateEventService.listDateEventQry(req);
    }

}
