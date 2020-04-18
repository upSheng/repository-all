package com.chs;

import com.alibaba.fastjson.JSONObject;
import com.chs.element.CommentHelp;
import com.chs.util.CsvUtil;
import com.chs.util.DateUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author : HongSheng.Chen
 * @date : 2020/4/17 18:47
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {Application.class})// 指定启动类
public class Post {

    @Autowired
    private CommentHelp commentHelp;

    private static final String START_TIME = "2020-04-10 08:00:00";
    private static final String END_TIME = "2020-04-13 08:00:00";
    private static final String CONTENT_FILE_PATH = "d:/test.csv";
    private static final String UUID_FILE_PATH = "d:/uuid.csv";

    @Test
    public void post() {

        List<String[]> datas = CsvUtil.getDataList(CONTENT_FILE_PATH);
        List<String[]> uuids = CsvUtil.getDataList(UUID_FILE_PATH);
        Long start = DateUtil.getLong(START_TIME);
        Long end = DateUtil.getLong(END_TIME);

        for (int i = 1; i < datas.size(); i++) {//去首行
            String[] data = datas.get(i);
            String gameId = data[0];
            String score = data[1];
            String content = data[2];
            String replya = data[3];
            String replyb = data[4];
            String replyc = data[5];
            String replyd = data[6];

            Map<String, String> params = new HashMap<>();
            params.put("moduleType", "GAME");
            params.put("resourceId", gameId);
            params.put("uuid", commentHelp.getRandomUUid(uuids));
            params.put("content", content);
            params.put("score", score);

            //评论
            JSONObject result = commentHelp.comment(params, start, end);
            Integer code = result.getInteger("return_code");
            if (code.equals(200)) {

                //评论成功
                String commentId = result.getString("data");
                Long createTime = result.getLong("createTime");

                params.put("isOfficial", "false");
                params.put("repliedId", "");
                params.put("repliedUuid", "");
                params.put("repliedName", "");
                params.put("commentId", commentId);

                //回复1
                params.put("uuid", commentHelp.getRandomUUid(uuids));
                params.put("content", replya);
                commentHelp.reply(params, createTime, end);

                //回复2
                params.put("uuid", commentHelp.getRandomUUid(uuids));
                params.put("content", replyb);
                commentHelp.reply(params, createTime, end);

                //回复3
                params.put("uuid", commentHelp.getRandomUUid(uuids));
                params.put("content", replyc);
                commentHelp.reply(params, createTime, end);

                //回4
                params.put("uuid", commentHelp.getRandomUUid(uuids));
                params.put("content", replyd);
                commentHelp.reply(params, createTime, end);

            } else {
                System.out.println(result.toJSONString());
                return;
            }

        }

    }


}
