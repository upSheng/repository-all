package com.chs;

import com.alibaba.fastjson.JSONObject;
import com.chs.element.CommentHelp;
import com.chs.entity.CommentData;
import com.chs.repository.CommentDataRepository;
import com.chs.util.CsvUtil;
import com.chs.util.DateUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.StringUtils;

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

    @Autowired
    private CommentDataRepository commentDataRepository;

    private static final String START_TIME = "2020-04-10 08:00:00";
    private static final String END_TIME = "2020-04-13 08:00:00";
    private static final String CONTENT_FILE_PATH = "d:/data.xlsx";
    private static final String UUID_FILE_PATH = "d:/uuid.xlsx";

    @Test
    public void post() {

        //读取数据库评论
        Page<CommentData> pa = commentDataRepository.findAll(PageRequest.of(0, 500));
        List<CommentData> datas = pa.getContent();
        //从excel获取uuid
        List<List<String>> uuids = CsvUtil.getExcelUuid(UUID_FILE_PATH);
        Long start = DateUtil.getLong(START_TIME);
        Long end = DateUtil.getLong(END_TIME);

        for (int i = 0; i < datas.size(); i++) {
            CommentData data = datas.get(i);
            String resourceId = data.getResourceId();
            if (StringUtils.isEmpty(resourceId)) {
                //防止空数据
                continue;
            }
            String score = data.getScore();
            String content = data.getContent();
            Map<String, String> params = new HashMap<>();
            params.put("moduleType", "GAME");
            params.put("resourceId", resourceId);
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
                String replya = data.getReplya();
                if (!StringUtils.isEmpty(replya)) {
                    params.put("uuid", commentHelp.getRandomUUid(uuids));
                    params.put("content", replya);
                    commentHelp.reply(params, createTime, end);
                }

                //回复2
                String replyb = data.getReplyb();
                if (!StringUtils.isEmpty(replyb)) {
                    params.put("uuid", commentHelp.getRandomUUid(uuids));
                    params.put("content", replyb);
                    commentHelp.reply(params, createTime, end);
                }
                //回复3
                String replyc = data.getReplyc();
                if (!StringUtils.isEmpty(replyc)) {
                    params.put("uuid", commentHelp.getRandomUUid(uuids));
                    params.put("content", replyc);
                    commentHelp.reply(params, createTime, end);
                }
                //回复4
                String replyd = data.getReplyd();
                if (!StringUtils.isEmpty(replyd)) {
                    params.put("uuid", commentHelp.getRandomUUid(uuids));
                    params.put("content", replyd);
                    commentHelp.reply(params, createTime, end);
                }

                //成功就删除
                commentDataRepository.delete(data);

            } else {
                //更新失败原因
                data.setResult(result.toJSONString());
                commentDataRepository.save(data);
            }

        }

    }

    /**
     * 删除评论 和回复
     */
    @Test
    public void delCommentAndReply() {
        commentHelp.delCommentAndReply();
    }


    /**
     * 存excel数据进数据库
     */
    @Test
    public void loadData() {
        commentHelp.loadData(CONTENT_FILE_PATH);
    }


}
