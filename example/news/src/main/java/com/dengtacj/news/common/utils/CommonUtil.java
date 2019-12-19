package com.dengtacj.news.common.utils;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class CommonUtil {

    public static int calSemilar(Integer nows,Integer maxs,Integer mins){

        BigDecimal now =  new BigDecimal(nows);
        BigDecimal max =  new BigDecimal(maxs);
        BigDecimal min =  new BigDecimal(mins);
        BigDecimal weight =  new BigDecimal(100);
        int num = 0;
        if((!max.equals(min)) && max.equals(now)  ){
            num = SimilarAvgEnum.ZERO.getCode();
        }else if(max.equals(min)){
            num = SimilarAvgEnum.TWO.getCode();
        }else{
            BigDecimal numSc =  (now.subtract(min)).divide((max.subtract(min)),2,BigDecimal.ROUND_HALF_DOWN).multiply(weight);
            num = numSc.intValue();
        }

        int similar = 1;

        if(num<= SimilarAvgEnum.ZERO.getCode()&&num>SimilarAvgEnum.ONE.getCode()){
            similar = SimilarAvgEnum.getMessageSc(SimilarAvgEnum.ZERO.getCode());
        }

        if(num<= SimilarAvgEnum.ONE.getCode()&&num>SimilarAvgEnum.TWO.getCode()){
            similar = SimilarAvgEnum.getMessageSc(SimilarAvgEnum.ONE.getCode());
        }
        if(num<= SimilarAvgEnum.TWO.getCode()&&num>SimilarAvgEnum.THREE.getCode()){
            similar = SimilarAvgEnum.getMessageSc(SimilarAvgEnum.TWO.getCode());
        }
        if(num<= SimilarAvgEnum.THREE.getCode()&&num>SimilarAvgEnum.FOUR.getCode()){
            similar = SimilarAvgEnum.getMessageSc(SimilarAvgEnum.THREE.getCode());
        }

        if(num<= SimilarAvgEnum.FOUR.getCode()){
            similar = SimilarAvgEnum.getMessageSc(SimilarAvgEnum.FOUR.getCode());
        }

        return similar;
    }

    /**
     * 将5分制转换为100分制
     */
    public static int convertScore(int srcScore, int beta) {
        int retVal = 0;
        int i=1;
        for (FiveToPercentEnum item : FiveToPercentEnum.values()) {
            if(i == srcScore) {
                retVal = beta % (item.getMax() - item.getMin() + 1) + item.getMin();
            }
            i++;
        }
        return retVal;
    }

    /**
     * 检查字符串是否都是有数字组成
     */
    public static boolean isNumeric(String str) {
        Pattern pattern = Pattern.compile("[0-9]*");
        return pattern.matcher(str).matches();
    }

    public static String escapJson(String s) {
        return s.replaceAll("\"", "\\\\\"");
    }

    private static final String regEx_script = "<script[^>]*?>[\\s\\S]*?<\\/script>"; // 定义script的正则表达式
    private static final String regEx_style = "<style[^>]*?>[\\s\\S]*?<\\/style>"; // 定义style的正则表达式
    private static final String regEx_html = "<[^>]+>"; // 定义HTML标签的正则表达式
    private static final String regEx_space = "\\s*|\t|\r|\n";//定义空格回车换行符

    public static String delHTMLTag(String htmlStr)
    {
        Pattern p_script = Pattern.compile(regEx_script, Pattern.CASE_INSENSITIVE);
        Matcher m_script = p_script.matcher(htmlStr);
        htmlStr = m_script.replaceAll(""); // 过滤script标签

        Pattern p_style = Pattern.compile(regEx_style, Pattern.CASE_INSENSITIVE);
        Matcher m_style = p_style.matcher(htmlStr);
        htmlStr = m_style.replaceAll(""); // 过滤style标签

//        Pattern p_html = Pattern.compile(regEx_html, Pattern.CASE_INSENSITIVE);
//        Matcher m_html = p_html.matcher(htmlStr);
//        htmlStr = m_html.replaceAll(""); // 过滤html标签
//
//        Pattern p_space = Pattern.compile(regEx_space, Pattern.CASE_INSENSITIVE);
//        Matcher m_space = p_space.matcher(htmlStr);
//        htmlStr = m_space.replaceAll(""); // 过滤空格回车标签
        return htmlStr.trim(); // 返回文本字符串
    }

}
