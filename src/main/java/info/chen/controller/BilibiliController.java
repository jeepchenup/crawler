package info.chen.controller;

import com.alibaba.fastjson.JSONObject;
import info.chen.bean.ReturnMessage;
import info.chen.constant.HTTPStatusConstant;
import info.chen.service.BilibiliService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

/**
 * @author Edison Chen
 * @Date 2019-07-04
 */
@RestController
@RequestMapping("/bilibili")
public class BilibiliController {

    @Autowired
    private BilibiliService bilibiliService;

    @GetMapping("/rank/info")
    public ReturnMessage getRank() {
        ReturnMessage message = new ReturnMessage();
        JSONObject rankInfos = null;
        try {
            rankInfos = bilibiliService.getRankInfo();
        } catch (IOException e) {
            message.setHttpStatus(HTTPStatusConstant.INNER_ERROR);
            message.setMessage("解析 www.bilibili.com 失败");
            e.printStackTrace();
        }

        message.setHttpStatus(HTTPStatusConstant.SUCCESS);
        message.setResults(rankInfos);

        return message;
    }

}
