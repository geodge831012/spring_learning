package com.dengtacj.news;

import com.alibaba.fastjson.JSON;
import com.dengtacj.news.common.utils.ProgressTimer;
import com.dengtacj.news.repository.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;

/**
 * Created by Administrator on 2019/10/23 0023.
 */

@Slf4j
@Component
public class ApplicationReadyEventListener implements ApplicationListener<ApplicationReadyEvent>, Ordered {

    /**
     * 该事件表示application初始化完成，可以准备接收请求,执行该函数
     * @param applicationReadyEvent
     */
    @Override
    public void onApplicationEvent(ApplicationReadyEvent applicationReadyEvent) {
        ProgressTimer timer = new ProgressTimer();
        ConfigurableApplicationContext context = applicationReadyEvent.getApplicationContext();

        try {
            // 初始化DateEvent
            DateEventRepository dateEventRepository = context.getBean(DateEventRepository.class);
            dateEventRepository.init();

            int iResult = dateEventRepository.getResult();
            log.info("iResult:" + iResult);

        } catch (Exception e) {
            log.error("exception:" , e);
        }

        log.info("================ApplicationReadyEvent:" + timer.elapse() + "=========================");
    }

    @Override
    public int getOrder() {
        return Ordered.LOWEST_PRECEDENCE;
    }
}
