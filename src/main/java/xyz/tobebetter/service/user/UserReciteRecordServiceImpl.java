package xyz.tobebetter.service.user;

import com.leqienglish.util.date.DateTimeUtil;
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
           List<UserReciteRecord> userReciteRecords = this.getBaseDao().findById(id);
            if (userReciteRecords == null|| userReciteRecords.isEmpty()) {
                return MessageUtil.createErrorMessage("没有找到UserReciteRecord");
            }

            UserReciteRecord userReciteRecord = userReciteRecords.get(0);


            userReciteRecord.setLearnTime(userReciteRecord.getLearnTime() + minutes);

            userReciteRecord.setUpdateDate(System.currentTimeMillis());
            if(!DateTimeUtil.isSameDate(System.currentTimeMillis(),userReciteRecord.getUpdateDate())){
                userReciteRecord.setLearnDay(1+userReciteRecord.getLearnDay());
            }
            this.getBaseDao().update(userReciteRecord);

            return this.toMessage(userReciteRecord);
        } catch (Exception e) {
            e.printStackTrace();
            return MessageUtil.createErrorMessage(e.getMessage());
        }

    }

    @Override
    public Message updateDays(String id) {
        try {
            List<UserReciteRecord> userReciteRecords = this.getBaseDao().findById(id);
            if (userReciteRecords == null|| userReciteRecords.isEmpty()) {
                return MessageUtil.createErrorMessage("没有找到UserReciteRecord");
            }

            UserReciteRecord userReciteRecord = userReciteRecords.get(0);


            userReciteRecord.setUpdateDate(System.currentTimeMillis());
            if(!DateTimeUtil.isSameDate(System.currentTimeMillis(),userReciteRecord.getUpdateDate())){
                userReciteRecord.setLearnDay(1+userReciteRecord.getLearnDay());
            }
            this.getBaseDao().update(userReciteRecord);

            return this.toMessage(userReciteRecord);
        } catch (Exception e) {
            e.printStackTrace();
            return MessageUtil.createErrorMessage(e.getMessage());
        }

    }

    @Override
    public Message findByUserId(String userId) {
        UserReciteRecord userReciteRecord1 = new UserReciteRecord();
        userReciteRecord1.setUserId(userId);
        try {
            List<UserReciteRecord> userReciteRecords = this.getBaseDao().findByEntity(userReciteRecord1);
            if(userReciteRecords==null || userReciteRecords.isEmpty()){
                userReciteRecord1.setLearnTime(0L);
                userReciteRecord1.setLearnDay(1L);
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
