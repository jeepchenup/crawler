package info.chen.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import info.chen.business.BilibiliInfo;
import info.chen.service.BilibiliService;
import org.springframework.stereotype.Service;

import java.io.IOException;

/**
 * @author Edison Chen
 * @Date 2019-07-04
 */
@Service
public class BilibiliServiceImpl implements BilibiliService {

    @Override
    public JSONObject getRankInfo() throws IOException {

        JSONArray rankInfo = BilibiliInfo.getInstance().getRank();

        JSONObject result = new JSONObject();
        result.put("rankInfo", rankInfo);
        return result;
    }
}
