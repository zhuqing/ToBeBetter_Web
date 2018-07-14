package xyz.tobebetter.service.recommend;


import xyz.tobebetter.entity.Message;

/**
 * Created by zhuleqi on 2018/7/13.
 */
public interface RecommendServiceI {
    public Message recommendBook(String userId);

    public Message recommendArticle(String userId);
}
