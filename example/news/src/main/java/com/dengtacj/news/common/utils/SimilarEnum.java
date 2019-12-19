package com.dengtacj.news.common.utils;

/**
 * @author LC
 * @date 2018/5/21
 */
public enum SimilarEnum {

    /**
     * 0：10分钟 ， 1：30分钟
     */
    ZERO(1, 5),
    ONE(2, 3);



    SimilarEnum(Integer code, Integer message) {
        this.code = code;
        this.message = message;
    }

    private Integer code;

    private Integer message;

    public static Integer getMessageSc(Integer code) {
        for (SimilarEnum item : SimilarEnum.values()) {
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
 