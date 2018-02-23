//package com.leqienglish.service;
//
//import com.leqigame.entity.User;
//
//import java.util.List;
//
///**
// * Created by zhuqing on 2017/7/21.
// */
//public interface UserServiceI {
//
//
//
//    User findUser(Long id);
//    /**
//     * 新增用户
//     * @param user
//     * @return
//     */
//    public Long addUser(User user);
//
//    /**
//     * 删除用户
//     * @param id
//     * @return
//     */
//    public User deleteUser(Long id);
//
//    /**
//     * 更新用户
//     * @param user
//     * @return
//     */
//    public User updateUserName(Long id , String name);
//
//    /**
//     * 获取所有的User
//     * @return
//     */
//    public List<User> get();
//
//    /**
//     * 分页获取用户列表
//     * @param page
//     * @param pageSize
//     * @return
//     */
//    public List<User> get(Integer page,Integer pageSize);
//
//    public Long getCount();
//
//    public User findUser(String value);
//
//    public User findUserByName(String userName);
//
//    public User findUserByEmail(String email);
//}
