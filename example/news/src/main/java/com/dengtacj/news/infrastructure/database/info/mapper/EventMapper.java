package com.dengtacj.news.infrastructure.database.info.mapper;

import com.dengtacj.news.infrastructure.database.info.dataobject.*;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created by Administrator on 2019/10/14 0014.
 */

@Mapper
public interface EventMapper {

    /**
     * 查询事件列表
     * @return
     */
    public List<EventInfoDO> listEventInfo();

    /**
     * 查询事件对应的标签
     * @return
     */
    public List<EventKeywordDO> listKeywordInfo();


}
