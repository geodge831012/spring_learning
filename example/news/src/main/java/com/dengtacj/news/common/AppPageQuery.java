package com.dengtacj.news.common;

/**
 * Created by Administrator on 2019/9/24 0024.
 */

public class AppPageQuery {
    /**
     * 拉取方向。0-新消息 1-老消息
     */
    private int direction = 1;

    /**
     * 起始ID，首次拉取时填空
     */
    private String startId = "";


    public int getDirection() {
        return direction;
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }

    public String getStartId() {
        return startId;
    }

    public void setStartId(String startId) {
        this.startId = startId;
    }
}
