package io.renren.common.utils;

import java.text.DecimalFormat;

/**
 * @author zhaoxiubin
 * create-time 2023-12-26 13:01
 * description 字符串处理
 **/

public class StrUtils {
    public static String strToTwoDecimal(String input){
        return strToDecimal(input, "0.00");
    }

    public static String strToDecimal(String input, String format){
        double number = Double.parseDouble(input);
        DecimalFormat df = new DecimalFormat(format);
        String result = df.format(number);
        return result;
    }
}
