package com.dengtacj.news.common.utils;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;
import java.text.DecimalFormat;

/**
 * Created by Administrator on 2019/10/11 0011.
 */

public class CustomerDoubleSerialize extends JsonSerializer<Double> {
    private DecimalFormat df = new DecimalFormat("0.00");
    @Override
    public void serialize(Double arg0, JsonGenerator arg1, SerializerProvider arg2) throws IOException {
        if(arg0 != null) {
            arg1.writeString(df.format(arg0));
        }
    }
}
