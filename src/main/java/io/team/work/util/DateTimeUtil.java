package io.team.work.util;

import java.text.SimpleDateFormat;

/**
 * 时间格式转换工具类.
 *
 * @author Tomoto
 * <p>
 * 2020/12/9 14:21
 */
public class DateTimeUtil {
    // 精确到年月日
    public static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");

    // 精确到时分秒
    public static final SimpleDateFormat DATE_TIME_FORMAT = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
}
