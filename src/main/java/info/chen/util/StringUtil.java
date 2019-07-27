package info.chen.util;

import info.chen.constant.UnitConstant;

/**
 * 字符串工具类
 * @author Edison Chen
 * @Date 2019-07-07
 */
public class StringUtil {

    /**
     * 去除目标字符串开头的字符
     * @author Edison Chen
     * @date   2019-07-07
     * @param targetString 处理的目标字符串
     * @param character    比对的字符
     * @return
     */
    public static String trimByCharacter(String targetString, String character) {
        if (targetString.indexOf(character) != -1) {
            return targetString.substring(character.length(), targetString.length());
        } else {
            return targetString;
        }
    }

    public static String convertToNum(String targetString, String character) {
        if (targetString.indexOf(character) != -1) {
            return String.valueOf(Double.parseDouble(targetString.substring(0, targetString.length() - 1)) * UnitConstant.TEN_THSOUSAND);
        }
        return targetString;
    }

}
