package com.dengtacj.news.common.utils;

/**
 * @author LC
 * @date 2018/5/21
 */
public enum SimilarAvgEnum {

    /**
     * 0：10分钟 ， 1：30分钟
     */
    ZERO(100, 5),
    ONE(80, 4),
    TWO(60, 3),
    THREE(40, 2),
    FOUR(20, 1);



    SimilarAvgEnum(Integer code, Integer message) {
        this.code = code;
        this.message = message;
    }

    private Integer code;

    private Integer message;

    public static Integer getMessageSc(Integer code) {
        for (SimilarAvgEnum item : SimilarAvgEnum.values()) {
            if (item.code.equals(code) )
                return item.message;
        }
        return 1;
    }


    public Integer getCode() {
        return code;
    }


    public Integer getMessage() {
        return message;
    }


}
 