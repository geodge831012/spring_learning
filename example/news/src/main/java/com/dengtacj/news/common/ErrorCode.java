package com.dengtacj.news.common;

public enum ErrorCode implements ErrorCodeI {

    E_Node_requestParamError ("-1", "请求参数错误"),
    E_Node_notExistError ("-2", "请求数据不存在"),
    E_Node_unknownError ("-99", "未知错误");

    private final String errCode;
    private final String errDesc;

    private ErrorCode(String errCode, String errDesc) {
        this.errCode = errCode;
        this.errDesc = errDesc;
    }

    @Override
    public String getErrCode() {
        return errCode;
    }

    @Override
    public String getErrDesc() {
        return errDesc;
    }
}