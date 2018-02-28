/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xyz.tobebetter.service;

import java.util.List;
import xyz.tobebetter.entity.Message;
import xyz.tobebetter.entity.Page;
import xyz.tobebetter.util.MessageUtil;

/**
 *
 * @author zhuqing
 */
public interface BaseServiceI<T> {

    public Message create(T t);

    public Message delete(String id);

    public Message findAll();

    public Message findById(String id);

    public Message find(Page page);
    
    public Message update(T t);

    public default Message toMessage(List<T> utrs) {
        if (utrs != null) {
            return MessageUtil.createMessage("ok", utrs.toArray());
        }
        return MessageUtil.createErrorMessage(null);
    }
    
     public default Message toMessage(T t) {
        if (t != null) {
            return MessageUtil.createMessage("ok", t);
        }
        return MessageUtil.createErrorMessage(null);
    }
}
