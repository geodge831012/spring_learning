package com.dengtacj.news.common.utils;

import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Method;
import java.util.*;

@Slf4j
    public class PageUtil<T> {
    // 拉取数据的方向
    private static final int DIRECTION_NEW = 0; //新消息(从最新消息到sStartId)
    private static final int DIRECTION_OLD = 1; //老消息 (从sStartId到最老的消息)
    private static final int DIRECTION_NEW_FROM_START_ID_ = 2; //新消息（从sStartId到最新消息）


    // 返回参数
    private boolean haveMore = true;
    private int iTotal = 0;

    public boolean isHaveMore() {
        return haveMore;
    }

    public int getiTotal() {
        return iTotal;
    }

    /**
     * preCondition: 列表是按照从新到旧排列
     *
     * @param className 数据列表中的数据的class
     * @param methodName 获取元素ID的方法名称
     * @param dataList 全部的数据列表
     * @param iDirection 拉取方向。0-新消息(从最新消息到sStartId) 1-老消息 2-新消息（从当前消息到最新消息）
     * @param sStartId 起始消息ID，首次拉取时填空
     * @param iPageSize 每次拉取的最大数量
     *
     * @return 获取的数据列表
     * iStatus 0-全部拉取完；1-有更多数据，若此时iDirection=0，表示返回的列表跟终端缓存列表有断层，则终端要清空本地缓存
     * iTotal 数据总条数
     */
    public List<T> getCurrentPageByApp(String className, String methodName, List<T> dataList, int iDirection,
                                       String sStartId, int iPageSize){
        this.iTotal = dataList.size();
        List<T> retList = new ArrayList<>();
        int count = 0;
        try {
            // 拉取老数据，从开始ID向后拉取
            if (iDirection == DIRECTION_OLD) {
                Boolean start = false;
                if (sStartId.isEmpty()){
                    start = true;
                }
                int i = 0;
                for(T data : dataList) {
                    if (start) {
                        if (count < iPageSize) {
                            retList.add(data);
                            count++;
                        } else {
                            break;
                        }
                    }
                    // 调用方法获取
                    Class classT = Class.forName(className);      //获取类
                    Method methodT = classT.getMethod(methodName); //获取函数
                    String id = (String) methodT.invoke(data);
                    if (!start && sStartId.equals(id)) {
                        start = true;
                    }
                    i++;
                }
                if (i >= dataList.size()) {
                    this.haveMore = false;
                }

                // 拉取新数据从最新数据开始拉取，直到达最大数量，或到达sStartId
            } else if (iDirection == DIRECTION_NEW) {
                Boolean end = false;
                int i = 0;
                for(T data : dataList) {
                    // 调用方法获取ID
                    Class classT = Class.forName(className);      //获取类
                    Method methodT = classT.getMethod(methodName); //获取函数
                    String id = (String) methodT.invoke(data);
                    if (sStartId.equals(id)) {
                        this.haveMore = false;
                        break;
                    }
                    if (!end) {
                        if (count < iPageSize) {
                            retList.add(data);
                            count++;
                        } else {
                            break;
                        }
                    }
                    i++;
                }
                if (i >= dataList.size()) {
                    this.haveMore = false;
                }
            } else if (iDirection == DIRECTION_NEW_FROM_START_ID_) {
                Boolean start = false;
                if (sStartId.isEmpty()){
                    start = true;
                }
                int i = dataList.size() - 1;


                ListIterator<T> li;// 获得ListIterator对象
                for (li = dataList.listIterator(); li.hasNext();) {// 将游标定位到列表结尾
                    li.next();
                }
                for (; li.hasPrevious();) {
                    T data = li.previous();
                    if (start) {
                        if (count < iPageSize) {
                            retList.add(0, data);
                            count++;
                        } else {
                            break;
                        }
                    }
                    // 调用方法获取
                    Class classT = Class.forName(className);      //获取对应类
                    Method methodT = classT.getMethod(methodName); //获取classT中的pointEvent(int arg)函数
                    String id = (String) methodT.invoke(data);
                    if (!start && sStartId.equals(id)) {
                        start = true;
                    }
                }
                if (i < 0) {
                    this.haveMore = false;
                }
            }
        } catch (Exception e){
            log.info("getCurrentPageByApp", e);
        }
        return retList;
    }

    /**
     * @param dataList 全部的数据列表
     * @param iCurrPage 当前页号
     * @param iPageSize 每次拉取的最大数量
     *
     * @return 获取的数据列表
     * iStatus 0-全部拉取完；1-有更多数据
     * iTotal 数据总条数
     */
    public List<T> getCurrentPageByWeb(List<T> dataList, int iCurrPage, int iPageSize){
        this.iTotal = dataList.size();
        List<T> retList = new LinkedList<>();
        int count = 0;
        int startIdx = iPageSize * (iCurrPage - 1);
        try {
            int i = startIdx;
            for(T data : dataList) {
                if (count < iPageSize) {
                    retList.add(data);
                    count++;
                } else {
                    break;
                }
            }
            if (i >= dataList.size()) {
                this.haveMore = false;
            }
        } catch (Exception e){
            log.info("getCurrentPageByWeb", e);
        }
        return retList;
    }






//    public static void main(String[] args) throws Exception {
//        testInvok<Log> test = new testInvok<Log>();
//        Vector<Log> dataList = new Vector<Log>();
//        dataList.add(new Log("a"));
//        dataList.add(new Log("b"));
//        dataList.add(new Log("c"));
//        dataList.add(new Log("d"));
//
////        Vector<Log> curList = test.getCurrentPageByApp(Log.class.getName(), "getLogId", dataList, DIRECTION_OLD, "b",3);
//        Vector<Log> curList = test.getCurrentPageByWeb(dataList, 1, 2);
//        for (Log cur : curList) {
//            System.out.println(cur.logId);
//        }
//        System.out.println("iStatus: " + test.getiStatus());
//        System.out.println("iTotal: " + test.getiTotal());
//
//    }
}

//public class Log{
//    public String logId;
//
//    public Log(String logId){
//        this.logId = logId;
//    }
//    public void setLogId(String logId) {
//        this.logId = logId;
//    }
//    public String getLogId() {
//        return this.logId;
//    }
//}