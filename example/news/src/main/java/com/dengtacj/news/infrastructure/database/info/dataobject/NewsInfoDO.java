package com.dengtacj.news.infrastructure.database.info.dataobject;

import lombok.Data;

/**
 * Created by Administrator on 2019/9/24 0024.
 */

@Data
public class NewsInfoDO {
    String  sNewsId;
    String  sKeyword = "";
    String  sNewsTitle = "";
}
