package xyz.tobebetter.service.segment;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.tobebetter.dao.segment.UserAndSegmentDao;
import xyz.tobebetter.entity.Message;
import xyz.tobebetter.entity.english.word.user.UserAndSegment;

/**
 * Created by zhuleqi on 2018/8/31.
 */
@Service
public class UserAndSegmentServiceImpl implements UserAndSegmentServiceI<UserAndSegment,UserAndSegmentDao<UserAndSegment>> {
    @Autowired
    private  UserAndSegmentDao<UserAndSegment> userAndSegmentDao;

    @Override
    public UserAndSegmentDao<UserAndSegment> getBaseDao() {
        return userAndSegmentDao;
    }

    @Override
    public Message findByContentId(String contentId) {
        UserAndSegment userAndSegment = new UserAndSegment();
        userAndSegment.setContentId(contentId);
        return this.find(userAndSegment);
    }
}
