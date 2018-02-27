/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xyz.tobebetter.service.usertaskrecord.impl;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.tobebetter.dao.UserTaskRecordDao;
import xyz.tobebetter.entity.Message;
import xyz.tobebetter.entity.Page;
import xyz.tobebetter.entity.UserTaskRecord;
import xyz.tobebetter.service.usertaskrecord.UserTaskRecordServiceI;
import xyz.tobebetter.util.EntityUtil;
import xyz.tobebetter.util.MessageUtil;

/**
 *
 * @author zhuqing
 */
@Service
public class UserTaskRecordServiceImpl<T extends UserTaskRecord> implements UserTaskRecordServiceI<T> {

    @Autowired
    private UserTaskRecordDao<T> userTaskRecordDao;

    public Message<T> create(T t) {
        
        try {
            EntityUtil.initEnity(t);
            this.userTaskRecordDao.create(t);
        } catch (Exception ex) {
            Logger.getLogger(UserTaskRecordServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
             return MessageUtil.createErrorMessage(ex.getMessage(), null);
        }

        return this.toMessage(t);
    }

    public Message<T> delete(String id) {
        T utr = null;
        try {
            utr = this.userTaskRecordDao.findById(id);
            if (utr != null) {
                this.userTaskRecordDao.delete(id);
            }else{
                 return MessageUtil.createErrorMessage("没有找到要删除的数据："+id, null);
            }

        } catch (Exception ex) {
            Logger.getLogger(UserTaskRecordServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            return MessageUtil.createErrorMessage(ex.getMessage(), null);
        }

        return this.toMessage(utr);
    }

    public Message<T[]> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Message<T> findById(String id) {
        T t = null;
        try {
            t = this.userTaskRecordDao.findById(id);
        } catch (Exception ex) {
            Logger.getLogger(UserTaskRecordServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
             return MessageUtil.createErrorMessage(ex.getMessage(), null);
        }

        return null;
    }

    public Message<T[]> find(Page page) {
        List<T> ts = null;
        try {
            ts = this.userTaskRecordDao.find(page);
        } catch (Exception ex) {
            Logger.getLogger(UserTaskRecordServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            return MessageUtil.createErrorMessage(ex.getMessage(), null);
        }
        return toMessage(ts);
    }

    public Message<T[]> findByUserId(String userId, Page page) {
        List<T> utrs = null;
        try {
            utrs = this.userTaskRecordDao.findByUserId(userId, page);
        } catch (Exception ex) {
            Logger.getLogger(UserTaskRecordServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            return MessageUtil.createErrorMessage(ex.getMessage(), null);
        }
        return toMessage(utrs);

    }

    public Message<T[]> findByUserTaskId(String userTaskId, Page page) {
        List<T> utrs = null;
        try {
            utrs = this.userTaskRecordDao.findByUserTaskId(userTaskId, page);
        } catch (Exception ex) {
            Logger.getLogger(UserTaskRecordServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            return MessageUtil.createErrorMessage(ex.getMessage(), new UserTaskRecord[0]);
        }
        return toMessage(utrs);
    }

}
