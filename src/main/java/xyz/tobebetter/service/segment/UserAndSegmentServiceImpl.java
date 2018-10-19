package xyz.tobebetter.service.segment;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.tobebetter.dao.SegmentDao;
import xyz.tobebetter.dao.content.UserAndContentDao;
import xyz.tobebetter.dao.segment.UserAndSegmentDao;
import xyz.tobebetter.entity.Message;
import xyz.tobebetter.entity.english.Segment;
import xyz.tobebetter.entity.english.word.user.UserAndSegment;
import xyz.tobebetter.entity.user.content.UserAndContent;
import xyz.tobebetter.service.content.UserAndContentServiceI;



/**
 * Created by zhuleqi on 2018/8/31.
 */
@Service
public class UserAndSegmentServiceImpl implements UserAndSegmentServiceI<UserAndSegment,UserAndSegmentDao<UserAndSegment>> {
    @Autowired
    private  UserAndSegmentDao<UserAndSegment> userAndSegmentDao;

    @Autowired
    private UserAndContentServiceI<UserAndContent,UserAndContentDao<UserAndContent>> userAndContentServiceI;

    @Autowired
    private SegmentDao<Segment> segmentDao;
    @Override
    public UserAndSegmentDao<UserAndSegment> getBaseDao() {
        return userAndSegmentDao;
    }


    @Override
    public Message findByContentIdAndUserId(String contentId, String userId) {
        UserAndSegment userAndSegment = new UserAndSegment();
        userAndSegment.setContentId(contentId);
        userAndSegment.setUserId(userId);


        return this.find(userAndSegment);
    }

    @Override
    public Message add(UserAndSegment userAndSegment) {
       Message message =  this.create(userAndSegment);

       if(message.getStatus() == Message.ERROR){
           return message;
       }

        UserAndSegment  conditionUS= new UserAndSegment();
        conditionUS.setContentId(userAndSegment.getContentId());
        conditionUS.setUserId(userAndSegment.getUserId());

        Segment segment = new Segment();
        segment.setContentId(userAndSegment.getContentId());

        try {
            long has = this.getBaseDao().countBy(conditionUS);
            long total = this.segmentDao.countBy(segment);

            int perscent = ((int)(100*has*1.0/total));

            this.userAndContentServiceI.updatePrecent(userAndSegment.getUserId(),userAndSegment.getContentId(),perscent);
        } catch (Exception e) {
            e.printStackTrace();
        }


        return message;
    }
}
