package info.chen.util;

import org.jsoup.Connection;
import org.jsoup.Jsoup;

/**
 * @author Edison Chen
 * @Date 2019-06-30
 */
public class HTTPClientUtil {

    /**
     * @description 获取解析地址连接
     * @author      Edison Chen
     * @date        2019-06-30
     */
    public static Connection getConnection(String url) {
        return Jsoup.connect(url);
    }
}
