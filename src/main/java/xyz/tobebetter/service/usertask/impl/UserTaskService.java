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
public class UserTaskService<T extends UserTask, D extends UserTaskDao<T>> implements UserTaskServiceI<T, D> {

    @Autowired
    private UserTaskDao<T> userTaskDao;

    @Override
    public D getBaseDao() {
        return (D) userTaskDao;
    }

}
