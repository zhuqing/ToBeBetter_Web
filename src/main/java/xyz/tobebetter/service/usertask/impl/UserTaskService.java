/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xyz.tobebetter.service.usertask.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.tobebetter.dao.UserTaskDao;
import xyz.tobebetter.entity.Page;
import xyz.tobebetter.entity.UserTask;
import xyz.tobebetter.service.usertask.UserTaskServiceI;
import xyz.tobebetter.util.EntityUtil;

/**
 *
 * @author zhuqing
 */
@Service
public class UserTaskService<T extends UserTask> implements UserTaskServiceI<T> {

    @Autowired
    private UserTaskDao<T> userTaskDao;

    public T create(T t) {
        EntityUtil.initEnity(t);
        this.userTaskDao.create(t);
        return t;
    }

    public T delete(String id) {
        T t = this.findById(id);
        if (t != null) {
            this.userTaskDao.delete(id);
        }

        return t;

    }

    public List<T> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public T findById(String id) {
        return this.userTaskDao.findById(id);
    }

    public List<T> find(Page page) {
       return this.userTaskDao.find(page);
    }

}
