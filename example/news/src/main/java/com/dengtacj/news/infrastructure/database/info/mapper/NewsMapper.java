package com.dengtacj.news.infrastructure.database.info.mapper;

import com.dengtacj.news.infrastructure.database.info.dataobject.*;
//import com.jarvis.cache.annotation.Cache;
//import com.jarvis.cache.annotation.Magic;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Administrator on 2019/9/24 0024.
 */

@Mapper
public interface NewsMapper {

    /**
     * 通过ID获取资讯详情
     * @param newsId
     * @return
     */
    public List<NewsInfoDO> listEventInfo(String eventId);

}
