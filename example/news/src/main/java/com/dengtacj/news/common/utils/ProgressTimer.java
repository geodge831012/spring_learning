package com.dengtacj.news.common.utils;

public class ProgressTimer {
    private long startTime = System.currentTimeMillis();
    public long elapse() {
        return System.currentTimeMillis() - startTime;
    }
}
