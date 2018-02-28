package xyz.tobebetter.service.user;



import xyz.tobebetter.entity.User;

import java.util.List;
import xyz.tobebetter.entity.Message;
import xyz.tobebetter.service.BaseServiceI;

/**
 * Created by zhuqing on 2017/7/21.
 */
public interface UserServiceI<T extends User> extends BaseServiceI<T>{



    public Message getCount();


    public Message findUserByOtherSysId(String otherSysId);

    public Message findUserByEmail(String email);

    public Message findUserByName(String name);

    public Message findUserByPhoneName(String phoneName);
}
