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
public class UserTaskRecordServiceImpl<T extends UserTaskRecord,D extends UserTaskRecordDao<T>> implements UserTaskRecordServiceI<T,D> {

    @Autowired
    private UserTaskRecordDao<T> userTaskRecordDao;

   

    @Override
    public Message findByUserId(String userId, Page page) {
        List<T> utrs = null;
        try {
            utrs = this.userTaskRecordDao.findByUserId(userId, page);
        } catch (Exception ex) {
            Logger.getLogger(UserTaskRecordServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            return MessageUtil.createErrorMessage(ex.getMessage(), null);
        }
        return toMessage(utrs);

    }

    @Override
    public Message findByUserTaskId(String userTaskId, Page page) {
        List<T> utrs = null;
        try {
            utrs = this.userTaskRecordDao.findByUserTaskId(userTaskId, page);
        } catch (Exception ex) {
            Logger.getLogger(UserTaskRecordServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            return MessageUtil.createErrorMessage(ex.getMessage(), new UserTaskRecord[0]);
        }
        return toMessage(utrs);
    }

   

    @Override
    public D getBaseDao() {
        return (D) userTaskRecordDao;
    }

}
