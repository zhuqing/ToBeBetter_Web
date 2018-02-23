//package xyz.tobebetter.service.impl;
//
//
//
//
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import xyz.tobebetter.dao.UserDao;
//import xyz.tobebetter.entity.Page;
//import xyz.tobebetter.entity.User;
//import xyz.tobebetter.service.UserServiceI;
//
//import java.util.List;
//
///**
// * Created by zhuqing on 2017/7/21.
// */
//@Service
//public class UserService implements UserServiceI {
//    @Autowired
//    private UserDao userDao;
//    public User findUser(Long id) {
//        return userDao.findUser(id);
//    }
//
//    public Long addUser(User user) {
//        return userDao.addUser(user);
//    }
//
//    public User deleteUser(Long id) {
//        return null;
//    }
//
//    public User updateUserName(Long id, String name) {
//        User user = this.userDao.findUser(id);
//        user.setName(name);
//        this.userDao.updateUser(user);
//        return user;
//    }
//
//    public List<User> get() {
//        return this.userDao.get();
//    }
//
//    public List<User> get(Integer page, Integer pageSize) {
//        Page pageP = new Page();
//        pageP.setPage(page);
//        pageP.setPageSize(pageSize);
//        return this.userDao.getByPage(pageP);
//    }
//
//    public Long getCount() {
//        return this.userDao.getCount();
//    }
//
//    public User findUser(String value) {
//        if(value.contains("@")){
//            return this.userDao.findUserByEmail(value);
//        }
//        return null;
//    }
//
//    public User findUserByName(String userName) {
//        return this.userDao.findUserByName(userName);
//    }
//
//    public User findUserByEmail(String email) {
//        return this.userDao.findUserByEmail(email);
//    }
//
//
//}
