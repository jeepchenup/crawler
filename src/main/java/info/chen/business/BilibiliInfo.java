package info.chen.business;

import com.alibaba.fastjson.JSONArray;
import info.chen.constant.CharactersConstant;
import info.chen.constant.UnitConstant;
import info.chen.util.HTTPClientUtil;
import info.chen.util.StringUtil;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Edison Chen
 * @date 2019-06-30
 */
public class BilibiliInfo {

    private static final String URL = "https://www.bilibili.com";
    private static final String RANK_URL = "https://www.bilibili.com/ranking";

    private BilibiliInfo() {}

    private static class BilibiliInfoHolder {
        private static final BilibiliInfo INSTANCE = new BilibiliInfo();
    }

    public static BilibiliInfo getInstance() {
        return BilibiliInfoHolder.INSTANCE;
    }

    /**
     * @description 获取B站频道种类
     * @author      Edison Chen
     * @date        2019-06-30
     */
    public void findChannel() throws IOException {
        Document document = HTTPClientUtil.getConnection(URL).get();

        Elements elementsByTag = document.getElementById("primary_menu").getElementsByTag("li");
        elementsByTag.forEach(element -> {
            System.out.println(element);
        });
    }

    /**
     * @description 获取排名
     * @author      Edison Chen
     * @date        2019-06-30
     */
    public JSONArray getRank() throws IOException {
        Document document = HTTPClientUtil.getConnection(RANK_URL).get();

        JSONArray results = new JSONArray();

        Elements rankItems = document.select("div[class=rank-list-wrap] li[class=rank-item]");

        if (rankItems != null) {
            rankItems.forEach(rankItem -> {
                Map<String, String> rankInfo = new HashMap<String, String>();
                // 排名
                rankInfo.put("排名", rankItem.select("div[class=num]").text());
                Elements videoLinkElement = rankItem.select("div[class=info] a");
                //影片地址
                rankInfo.put("视频地址", StringUtil.trimByCharacter(videoLinkElement.attr("href"), CharactersConstant.DOUBLE_DIAGNAL));
                //标题
                rankInfo.put("标题", videoLinkElement.text());
                Elements rankDetails = rankItem.select("div[class=detail] span[class=data-box]");
                //播放量
                rankInfo.put("播放量", StringUtil.convertToNum(rankDetails.get(0).text(), UnitConstant.TEN_THSOUSAND_ZH));

                //评论量
                rankInfo.put("评论量", StringUtil.convertToNum(rankDetails.get(1).text(), UnitConstant.TEN_THSOUSAND_ZH));
                //作者名
                rankInfo.put("作者", rankDetails.get(2).text());
                // 综合评分
                rankInfo.put("综合评分", rankItem.select("div[class=pts] div").text());

                if (!rankInfo.isEmpty()) {
                    results.add(rankInfo);
                }
            });
        }

        return results;
    }

}
