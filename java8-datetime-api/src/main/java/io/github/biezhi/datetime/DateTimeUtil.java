package io.github.biezhi.datetime;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @Author duhongming
 * @Email 19919902414@189.cn
 * @Date 2018/5/20 18:16
 */
public class DateTimeUtil {

    public String getNowByDate(){
        return LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    }

    public String getNowByDateTime(){
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss"));
    }

    @Test
    public void test(){
        System.out.println("getNowByDate = " + getNowByDate());
        System.out.println("getNowByDateTime = " + getNowByDateTime());
    }
}