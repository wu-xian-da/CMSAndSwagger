package com.yutons.cms.util;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author yutons
 * @desc
 * @date 2017/11/6 17:13
 */
public class DateSerializer extends JsonSerializer<Date> {
    @Override
    public void serialize(Date value, JsonGenerator jgen, SerializerProvider provider)
            throws IOException,JsonProcessingException {
        //1.定义日期转换对象
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //2.转换日期为指定格式的字符串
        String formattedDate = formatter.format(value);
        //3.以json格式输入字符串
        jgen.writeString(formattedDate);
    }
}
