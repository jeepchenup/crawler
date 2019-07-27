package info.chen.bean;

import com.alibaba.fastjson.JSONObject;

/**
 * 统一返回给前端格式
 * @author Edison Chen
 * @Date 2019-07-07
 */
public class ReturnMessage {

    /**
     * @description 请求结果状态
     * @author Edison Chen
     * @date 2019-07-07
     */
    private String httpStatus;
    /**
     * @description 返回说明
     * @author Edison Chen
     * @date 2019-07-07
     */
    private String message;
    /**
     * @description 结果
     * @author      Edison Chen
     * @date        2019-07-07
     */
    private JSONObject results;

    public String getHttpStatus() {
        return httpStatus;
    }

    public void setHttpStatus(String httpStatus) {
        this.httpStatus = httpStatus;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public JSONObject getResults() {
        return results;
    }

    public void setResults(JSONObject results) {
        this.results = results;
    }
}
