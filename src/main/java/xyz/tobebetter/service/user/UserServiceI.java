package xyz.tobebetter.service.user;




import xyz.tobebetter.entity.user.User;

import java.util.List;
import xyz.tobebetter.dao.user.UserDao;
import xyz.tobebetter.entity.Message;
import xyz.tobebetter.service.BaseServiceI;

/**
 * Created by zhuqing on 2017/7/21.
 */
public interface UserServiceI<T extends User,D extends UserDao<T>> extends BaseServiceI<T,D>{



    public Message regist(T user);

    public Message login(String userName, String password);


    public Message findUserByOtherSysId(String otherSysId);

    public Message findUserByEmail(String email);

    public Message findUserByName(String name);

    public Message findUserByPhoneName(String phoneName);

    public Message findUserByType(Integer type , Integer page ,Integer pageSize);
}
