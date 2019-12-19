package com.dengtacj.news.common.utils;

/**
 * Created by Administrator on 2019/10/21 0021.
 */

public enum  FiveToPercentEnum {
    ONE(30, 40),
    TWO(41, 55),
    THREE(56, 70),
    FOUR(85, 71),
    FIVE(86, 99);

    FiveToPercentEnum(Integer min, Integer max) {
        this.min = min;
        this.max = max;
    }

    private Integer min;

    private Integer max;

    public Integer getMin() {
        return min;
    }

    public Integer getMax() {
        return max;
    }
}
