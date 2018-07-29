package xyz.tobebetter.service.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.logging.Level;
import java.util.logging.Logger;
import xyz.tobebetter.dao.user.UserDao;
import xyz.tobebetter.entity.Consistent;
import xyz.tobebetter.entity.Entity;
import xyz.tobebetter.entity.Message;
import xyz.tobebetter.entity.user.User;
import xyz.tobebetter.service.user.UserServiceI;
import xyz.tobebetter.util.EntityUtil;
import xyz.tobebetter.util.MessageUtil;

/**
 * Created by zhuqing on 2017/7/21.
 * @param <T>
 */
@Service
public class UserServiceImpl<T extends User,D extends UserDao<T>> implements UserServiceI<T,D> {

    @Autowired
    private UserDao<T> userDao;

    @Override
    public Message create(T t){

        try {
            t.setStatus(Consistent.SUCCESS);
            t.setCreateDate(System.currentTimeMillis());
            t.setUpdateDate(System.currentTimeMillis());
            this.getBaseDao().create(t);
            return this.toMessage(t);
        } catch (Exception e) {
            e.printStackTrace();

            return MessageUtil.createErrorMessage(e.getMessage());
        }
    }

    @Override
    public Message findUserByOtherSysId(String otherSysId) {
        T t = null;
        try {
            t = this.userDao.findUserByOtherSysId(otherSysId);
        } catch (Exception ex) {
            Logger.getLogger(UserServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(UserServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(UserServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(UserServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            MessageUtil.createErrorMessage(ex.getMessage(), null);
        }

        return this.toMessage(t);
    }

    @Override
    public D getBaseDao() {
        return (D) this.userDao;
    }

}
