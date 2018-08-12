package xyz.tobebetter.service.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
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
 *
 * @param <T>
 */
@Service
public class UserServiceImpl<T extends User, D extends UserDao<T>> implements UserServiceI<T, D> {

    @Autowired
    private UserDao<T> userDao;

    @Override
    public Message create(T t) {

        try {
            t.setStatus(Consistent.USER_TEMP_STATUS);
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
    public Message regist(T user) {
        user.setStatus(Consistent.REGIST_USER);
        user.setVipLastData((System.currentTimeMillis()+3*30*24*60*1000)+"");
        try {
            if (user.getId() == null || user.getId().isEmpty()) {
                user.setId(EntityUtil.createEntityId());
                this.getBaseDao().create(user);
            } else {

                this.getBaseDao().update(user);

            }

            return MessageUtil.createSuccessMessage(user);

        } catch (Exception e) {
            e.printStackTrace();
            return MessageUtil.createErrorMessage(e.getMessage());
        }

    }

    @Override
    public Message login(String userName, String password) {
        T user = (T) new User();
        if(userName.contains("@")){
            user.setEmail(userName);
        }else{
            user.setName(userName);
        }

        try {
            List<T> ts = this.getBaseDao().findByEntity(user);
            if(ts == null || ts.isEmpty()){
                return MessageUtil.createErrorMessage("没找到用户");
            }

            if(ts.size()>1){
                return MessageUtil.createErrorMessage("找到多个用户");
            }

            return this.toMessage(ts.get(0));
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
