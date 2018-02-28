/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xyz.tobebetter.service.usertask.impl;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.tobebetter.dao.UserTaskDao;
import xyz.tobebetter.entity.Message;
import xyz.tobebetter.entity.Page;
import xyz.tobebetter.entity.UserTask;
import xyz.tobebetter.service.usertask.UserTaskServiceI;
import xyz.tobebetter.util.EntityUtil;
import xyz.tobebetter.util.MessageUtil;

/**
 *
 * @author zhuqing
 * @param <T>
 */
@Service
public class UserTaskService<T extends UserTask> implements UserTaskServiceI<T> {

    @Autowired
    private UserTaskDao<T> userTaskDao;

    @Override
    public Message create(T t) {
        EntityUtil.initEnity(t);
        try {
            this.userTaskDao.create(t);
        } catch (Exception ex) {
            Logger.getLogger(UserTaskService.class.getName()).log(Level.SEVERE, null, ex);
            return MessageUtil.createErrorMessage(ex.getMessage(),t);
        }
        return MessageUtil.createSuccessMessage(t);
    }

    @Override
    public Message delete(String id) {
        T t = null;
        try {
            t = this.userTaskDao.findById(id);
            if (t != null) {
                this.userTaskDao.delete(id);
            }
        } catch (Exception ex) {
            Logger.getLogger(UserTaskService.class.getName()).log(Level.SEVERE, null, ex);
            return MessageUtil.createErrorMessage(ex.getMessage(),t);
        }

        return MessageUtil.createSuccessMessage(t);

    }

    public Message findAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Message findById(String id) {
        T t = null;
        try {
            t = this.userTaskDao.findById(id);
        } catch (Exception ex) {
            Logger.getLogger(UserTaskService.class.getName()).log(Level.SEVERE, null, ex);
            return MessageUtil.createErrorMessage(t);
        }
        return MessageUtil.createSuccessMessage(t);
    }

    public Message find(Page page) {
        List<T> ts = null;
        try {
            ts = this.userTaskDao.find(page);
        } catch (Exception ex) {
            Logger.getLogger(UserTaskService.class.getName()).log(Level.SEVERE, null, ex);
            return MessageUtil.createErrorMessage(ts);
        }

        return this.toMessage(ts);
    }

    @Override
    public Message update(T t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
