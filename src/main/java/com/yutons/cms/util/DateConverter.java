package com.yutons.cms.util;



import org.springframework.core.convert.converter.Converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author yutons
 * @desc
 * @date 2017/11/3 11:09
 */
public class DateConverter implements Converter<String, Date> {
    @Override
    public Date convert(String stringDate) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        if (stringDate.length()<=10){
            simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
        }
        try {
            return simpleDateFormat.parse(stringDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }
}
