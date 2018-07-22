package xyz.tobebetter.service.user;

import xyz.tobebetter.dao.user.UserReciteRecordDao;
import xyz.tobebetter.entity.Message;
import xyz.tobebetter.entity.user.recite.UserReciteRecord;
import xyz.tobebetter.service.BaseServiceI;

/**
 * Created by zhuleqi on 2018/7/22.
 */
public interface UserReciteRecordServiceI<T extends UserReciteRecord,D extends UserReciteRecordDao<T>> extends BaseServiceI<T,D>{

    public Message updateReciteMinutes(String id, int minites);

    public Message findByUserId(String userId);

}
