package com.dengtacj.news.common;

import java.util.Collection;

/**
 * Response with batch record to return,
 * usually use in page query or conditional query
 * <p/>
 * Created by Danny.Lee on 2017/11/1.
 */
public class MultiResponse<T> extends Response {

    private int total;

    private boolean haveMore;

    private Collection<T> data;

    public static <T> MultiResponse<T> of(Collection<T> data, boolean haveMore, int total) {
        MultiResponse<T> multiResponse = new MultiResponse<>();
        multiResponse.setSuccess(true);
        multiResponse.setData(data);
        multiResponse.setTotal(total);
        multiResponse.setHaveMore(haveMore);
        return multiResponse;
    }

    public static <T> MultiResponse<T> ofWithoutTotal(Collection<T> data) {
        return of(data,false, 0);
    }

    
    public int getTotal() {
        return total;
    }

    
    public void setTotal(int total) {
        this.total = total;
    }

    
    public Collection<T> getData() {
        return data;
    }

    
    public void setData(Collection<T> data) {
        this.data = data;
    }

    public boolean isHaveMore() {
        return haveMore;
    }

    public void setHaveMore(boolean haveMore) {
        this.haveMore = haveMore;
    }

    public static MultiResponse buildFailure(String errCode, String errMessage) {
        MultiResponse response = new MultiResponse();
        response.setSuccess(false);
        response.setErrCode(errCode);
        response.setErrMessage(errMessage);
        return response;
    }

    public static MultiResponse buildFailure(ErrorCodeI errCode) {
        MultiResponse response = new MultiResponse();
        response.setSuccess(false);
        response.setErrCode(errCode.getErrCode());
        response.setErrMessage(errCode.getErrDesc());
        return response;
    }


    public static MultiResponse buildSuccess(){
        MultiResponse response = new MultiResponse();
        response.setSuccess(true);
        return response;
    }

}
