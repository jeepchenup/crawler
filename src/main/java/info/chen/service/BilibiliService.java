package info.chen.service;

import com.alibaba.fastjson.JSONObject;

import java.io.IOException;

/**
 * @description Blibili服务类
 * @author      Edison Chen
 * @date        2019-07-04
 */
public interface BilibiliService {

    /**
     * @description 获取排名信息
     * @author      Edison Chen
     * @date        2019-07-04
     */
    JSONObject getRankInfo() throws IOException;

}
