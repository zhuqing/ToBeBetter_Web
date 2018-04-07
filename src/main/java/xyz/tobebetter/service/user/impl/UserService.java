package xyz.tobebetter.service.user.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import xyz.tobebetter.dao.UserDao;
import xyz.tobebetter.entity.Message;
import xyz.tobebetter.entity.Page;
import xyz.tobebetter.entity.User;
import xyz.tobebetter.service.user.UserServiceI;
import xyz.tobebetter.util.EntityUtil;
import xyz.tobebetter.util.MessageUtil;
import xyz.tobebetter.util.data.MessageData;
import xyz.tobebetter.util.data.StatusData;

/**
 * Created by zhuqing on 2017/7/21.
 * @param <T>
 */
@Service
public class UserService<T extends User,D extends UserDao<T>> implements UserServiceI<T,D> {

    @Autowired
    private UserDao<T> userDao;

    

    @Override
    public Message findUserByOtherSysId(String otherSysId) {
        T t = null;
        try {
            t = this.userDao.findUserByOtherSysId(otherSysId);
        } catch (Exception ex) {
            Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
            MessageUtil.createErrorMessage(ex.getMessage(), null);
        }

        return this.toMessage(t);
    }

    @Override
    public Message findUserByEmail(String email) {
        T t = null;
        try {
            t = this.userDao.findUserByOtherSysId(email);
        } catch (Exception ex) {
            Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
            MessageUtil.createErrorMessage(ex.getMessage(), null);
        }

        return this.toMessage(t);
    }

    @Override
    public Message findUserByName(String name) {
        T t = null;
        try {
            t = this.userDao.findUserByOtherSysId(name);
        } catch (Exception ex) {
            Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
            MessageUtil.createErrorMessage(ex.getMessage(), null);
        }

        return this.toMessage(t);
    }

    @Override
    public Message findUserByPhoneName(String phoneName) {
        T t = null;
        try {
            t = this.userDao.findUserByOtherSysId(phoneName);
        } catch (Exception ex) {
            Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
            MessageUtil.createErrorMessage(ex.getMessage(), null);
        }

        return this.toMessage(t);
    }

    @Override
    public D getBaseDao() {
        return (D) this.userDao;
    }

}
