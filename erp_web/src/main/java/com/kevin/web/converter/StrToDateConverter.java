package com.kevin.web.converter;

import org.springframework.core.convert.converter.Converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by IntelliJ IDEA.
 * User: kevin
 * Date: 2018/6/4
 */
public class StrToDateConverter implements Converter<String, Date> {
    @Override
    public Date convert(String source) {
        try {
            Date date = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").parse(source);
            return date;
        } catch (ParseException e) {
            try {
                Date date = new SimpleDateFormat("yyyy-MM-dd").parse(source);
            } catch (ParseException e1) {
                e1.printStackTrace();
            }
        }
        return null;
    }
}
