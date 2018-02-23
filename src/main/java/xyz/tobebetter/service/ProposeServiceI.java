package xyz.tobebetter.service;



import xyz.tobebetter.entity.Message;

/**
 * Created by zhuleqi on 2018/2/23.
 */
public interface ProposeServiceI {
    public Message create(String connect , String message);
    public Message delete(String id);
    public Message findAll();
}
