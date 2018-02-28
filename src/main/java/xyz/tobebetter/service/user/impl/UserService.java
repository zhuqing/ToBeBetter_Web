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
 */
@Service
public class UserService<T extends User> implements UserServiceI<T> {

    @Autowired
    private UserDao<T> userDao;

    @Override
    public Message getCount() {
        Long count = null;
        try {
            count = this.userDao.getCount();
        } catch (Exception ex) {
            Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
            return MessageUtil.createErrorMessage(ex.getMessage(), null);
        }
        return MessageUtil.createSuccessMessage(count);
    }

    @Override
    public Message create(T t) {
        try {
            EntityUtil.initEnity(t);
            if (this.findById(t.getId()) != null) {
                EntityUtil.initEnity(t);
            }
            this.userDao.create(t);
        } catch (Exception ex) {
            Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
            return MessageUtil.createErrorMessage(ex.getMessage(), null);
        }

        return this.toMessage(t);
    }

    @Override
    public Message delete(String id) {
        T user = null;
        try {
            user = this.userDao.findById(id);
            if (user == null) {
                return MessageUtil.createErrorMessage(MessageData.NOT_FIND_ENTITY + ":" + id, null);
            }
            user.setStatus(StatusData.DELETE);
            this.userDao.update(user);

        } catch (Exception ex) {
            Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
            return MessageUtil.createErrorMessage(ex.getMessage(), null);
        }

        return this.toMessage(user);
    }

    @Override
    public Message findAll() {
        List<T> ts = null;
        try {
            ts = this.userDao.findAll();
        } catch (Exception ex) {
            Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
            MessageUtil.createErrorMessage(ex.getMessage(), null);
        }

        return this.toMessage(ts);
    }

    @Override
    public Message findById(String id) {
        T t = null;
        try {
            t = this.userDao.findById(id);
        } catch (Exception ex) {
            Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
            MessageUtil.createErrorMessage(ex.getMessage(), null);
        }

        return this.toMessage(t);
    }

    @Override
    public Message find(Page page) {
        List<T> ts = null;
        try {
            ts = this.userDao.find(page);
        } catch (Exception ex) {
            Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
            MessageUtil.createErrorMessage(ex.getMessage(), null);
        }

        return this.toMessage(ts);
    }

    @Override
    public Message update(T t) {
        try {
            this.userDao.update(t);
        } catch (Exception ex) {
            Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
            MessageUtil.createErrorMessage(ex.getMessage(), null);
        }
        return this.toMessage(t);
    }

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

}
