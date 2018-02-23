//package xyz.tobebetter.dao;
//
//import com.leqienglish.model.Page;
//import xyz.tobebetter.entity.User;
//
//
//import java.util.List;
//
///**
// * Created by zhuqing on 2017/7/21.
// */
//public interface UserDao {
//    /**
//     * 查找用户
//     * @param id
//     * @return
//     */
//    public User findUser(Long id);
//
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
//    public User updateUser(User user);
//
//    public List<User> get();
//
//    public List<User> getByPage(Page page);
//
//    /**
//     * 获取用户数量
//     * @return
//     */
//    public Long getCount();
//
//    public User findUserByEmail(String email);
//    public User findUserByName(String name);
//
//
//
//}
