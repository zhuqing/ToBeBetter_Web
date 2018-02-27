/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xyz.tobebetter.service;

import java.util.List;
import xyz.tobebetter.entity.Message;
import xyz.tobebetter.entity.Page;
import xyz.tobebetter.entity.UserTaskRecord;
import xyz.tobebetter.util.MessageUtil;

/**
 *
 * @author zhuqing
 */
public interface BaseServeceI<T> {

    public Message<T> create(T t);

    public Message<T> delete(String id);

    public Message<T[]> findAll();

    public Message<T> findById(String id);

    public Message<T[]> find(Page page);

    public default Message<T[]> toMessage(List<T> utrs) {
        if (utrs != null) {
            return MessageUtil.createMessage("ok", utrs.toArray());
        }
        return MessageUtil.createErrorMessage(null);
    }
    
     public default Message<T> toMessage(T t) {
        if (t != null) {
            return MessageUtil.createMessage("ok", t);
        }
        return MessageUtil.createErrorMessage(null);
    }
}
