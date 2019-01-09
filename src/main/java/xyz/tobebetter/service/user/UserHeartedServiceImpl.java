package xyz.tobebetter.service.user;

import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.tobebetter.dao.user.UserDao;
import xyz.tobebetter.dao.user.UserHeartedDao;
import xyz.tobebetter.dao.user.UserReciteRecordDao;
import xyz.tobebetter.entity.Consistent;
import xyz.tobebetter.entity.Message;
import xyz.tobebetter.entity.user.User;
import xyz.tobebetter.entity.user.UserHearted;
import xyz.tobebetter.entity.user.recite.UserReciteRecord;
import xyz.tobebetter.util.EntityUtil;
import xyz.tobebetter.util.LoadUserImage;
import xyz.tobebetter.util.MessageUtil;
import xyz.tobebetter.util.WebConsistent;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by zhuqing on 2017/7/21.
 *
 */
@Service
public class UserHeartedServiceImpl implements UserHeartedServiceI{

    @Autowired
    private UserHeartedDao<UserHearted> userHeartedDao;

    @Autowired
    private UserReciteRecordDao<UserReciteRecord> userReciteRecordDao;


    @Override
    public Message findByUserIdAndType(String userId, Integer type) {

        return toMessage(()->{
            UserHearted userHearted = new UserHearted();
            userHearted.setUserId(userId);
            userHearted.setType(type);
            return userHeartedDao.findByEntity(userHearted);
        });
    }

    @Override
    public Message findByUserIdAndTargetId(String userId, String targetId) {
        return toMessage(()->{
            UserHearted userHearted = new UserHearted();
            userHearted.setUserId(userId);
            userHearted.setTargetId(targetId);
            return userHeartedDao.findByEntity(userHearted);
        });
    }

    @Override
    public UserHeartedDao<UserHearted> getBaseDao() {
        return this.userHeartedDao;
    }
}
