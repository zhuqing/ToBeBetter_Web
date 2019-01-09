package xyz.tobebetter.service.user;


import xyz.tobebetter.dao.user.UserDao;
import xyz.tobebetter.dao.user.UserHeartedDao;
import xyz.tobebetter.entity.Message;
import xyz.tobebetter.entity.user.User;
import xyz.tobebetter.entity.user.UserHearted;
import xyz.tobebetter.service.BaseServiceI;

/**
 * Created by zhuqing on 2017/7/21.
 */
public interface UserHeartedServiceI extends BaseServiceI<UserHearted,UserHeartedDao<UserHearted>>{

    Message findByUserIdAndType(String userId,Integer type);

    Message findByUserIdAndTargetId(String userId,String targetId);
}
