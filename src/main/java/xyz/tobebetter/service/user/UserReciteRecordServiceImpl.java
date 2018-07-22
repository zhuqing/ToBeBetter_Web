package xyz.tobebetter.service.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.tobebetter.dao.user.UserReciteRecordDao;
import xyz.tobebetter.entity.Message;
import xyz.tobebetter.entity.user.recite.UserReciteRecord;
import xyz.tobebetter.util.MessageUtil;

import java.util.List;

/**
 * Created by zhuleqi on 2018/7/22.
 */
@Service
public class UserReciteRecordServiceImpl implements UserReciteRecordServiceI<UserReciteRecord, UserReciteRecordDao<UserReciteRecord>> {
    @Autowired
    private UserReciteRecordDao<UserReciteRecord> userReciteRecordDao;

    @Override
    public Message updateReciteMinutes(String id, int minutes) {
        try {
            UserReciteRecord userReciteRecord = this.getBaseDao().findById(id);
            if (userReciteRecord == null) {
                return MessageUtil.createErrorMessage("没有找到UserReciteRecord");
            }

            UserReciteRecord userReciteRecord1 = new UserReciteRecord();
            userReciteRecord1.setId(id);
            userReciteRecord1.setLearnTime(userReciteRecord.getLearnTime() + minutes);
            this.getBaseDao().update(userReciteRecord1);

            return this.toMessage(userReciteRecord1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Message findByUserId(String userId) {
        UserReciteRecord userReciteRecord1 = new UserReciteRecord();
        userReciteRecord1.setUserId(userId);
        try {
            List<UserReciteRecord> userReciteRecords = this.getBaseDao().findByEntity(userReciteRecord1);
            if(userReciteRecords==null || userReciteRecords.isEmpty()){
                userReciteRecord1.setLearnTime(1300L);
                userReciteRecord1= this.insert(userReciteRecord1);

            }else {
                userReciteRecord1 = userReciteRecords.get(0);
            }

        } catch (Exception e) {
            e.printStackTrace();
            return MessageUtil.createErrorMessage(e.getMessage());
        }
        return this.toMessage(userReciteRecord1);
    }

    @Override
    public UserReciteRecordDao<UserReciteRecord> getBaseDao() {
        return this.userReciteRecordDao;
    }
}
