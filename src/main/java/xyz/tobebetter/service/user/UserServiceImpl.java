package xyz.tobebetter.service.user;

import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import xyz.tobebetter.dao.user.UserDao;
import xyz.tobebetter.dao.user.UserReciteRecordDao;
import xyz.tobebetter.entity.Consistent;
import xyz.tobebetter.entity.Entity;
import xyz.tobebetter.entity.Message;
import xyz.tobebetter.entity.user.User;
import xyz.tobebetter.entity.user.recite.UserReciteRecord;
import xyz.tobebetter.service.user.UserServiceI;
import xyz.tobebetter.util.EntityUtil;
import xyz.tobebetter.util.LoadUserImage;
import xyz.tobebetter.util.MessageUtil;
import xyz.tobebetter.util.WebConsistent;

/**
 * Created by zhuqing on 2017/7/21.
 *
 * @param <T>
 */
@Service
public class UserServiceImpl<T extends User, D extends UserDao<T>> implements UserServiceI<T, D> {

    @Autowired
    private UserDao<T> userDao;

    @Autowired
    private UserReciteRecordDao<UserReciteRecord> userReciteRecordDao;

    @Override
    public Message create(T t) {

        try {
            t.setStatus(Consistent.USER_TEMP_STATUS);
            t.setCreateDate(System.currentTimeMillis());
            t.setUpdateDate(System.currentTimeMillis());
            this.getBaseDao().create(t);
            this.createUserReciteRecord(t);

            return this.toMessage(t);
        } catch (Exception e) {
            e.printStackTrace();

            return MessageUtil.createErrorMessage(e.getMessage());
        }
    }

    private void createUserReciteRecord(T user){
        UserReciteRecord userReciteRecord = new UserReciteRecord();
        userReciteRecord.setLearnDay(1L);
        userReciteRecord.setLearnTime(0L);
        userReciteRecord.setUserId(user.getId());
        EntityUtil.initEnity(userReciteRecord);

        try {
            this.userReciteRecordDao.create(userReciteRecord);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Message regist(T user) {


        user.setStatus(Consistent.REGIST_USER);
        EntityUtil.initEnity(user);
        LoadUserImage.loadImage(user);
        user.setVipLastData((System.currentTimeMillis()+3*30*24*60*1000)+"");
        try {
            List<T> users = this.getBaseDao().findById(user.getId());

            if(users!=null||users.isEmpty()){

                this.getBaseDao().create(user);
                return MessageUtil.createSuccessMessage(user);
            }else{
                return this.regist(user);
            }


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
        T user = (T) new User();
        user.setOtherSysId(otherSysId);
        try {
            List<T> ts = this.userDao.findByEntity(user);
            if(ts == null || ts.isEmpty()){
                return MessageUtil.createErrorMessage(otherSysId);
            }

            return MessageUtil.createSuccessMessage(ts.get(0));
        } catch (Exception ex) {
            Logger.getLogger(UserServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            return MessageUtil.createErrorMessage(ex.getMessage(), null);
        }
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
    public Message findByUserName(String userName, Integer page, Integer pageSize) {
      this.setPage(page, pageSize);
        return this.toMessage(()->{
            return getBaseDao().findByUserName(userName);
        });
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
    public Message findUserByType(Integer type, Integer page, Integer pageSize) {
        if(page == null){
            page = 1 ;
        }

        if(pageSize == null){
            pageSize = WebConsistent.PAGE_SIZE;
        }
        PageHelper.startPage(page,pageSize);
        T user = (T) new User();
        user.setType(type);

        try {
            List<T> ts = this.getBaseDao().findByEntity(user);
            return this.toMessage(ts);
        } catch (Exception e) {
            e.printStackTrace();
            return MessageUtil.createErrorMessage(e.getMessage());
        }

    }

    @Override
    public D getBaseDao() {
        return (D) this.userDao;
    }

}
