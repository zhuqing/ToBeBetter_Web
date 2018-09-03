package xyz.tobebetter.service.segment;



import xyz.tobebetter.dao.segment.UserAndSegmentDao;
import xyz.tobebetter.entity.Message;
import xyz.tobebetter.entity.english.word.user.UserAndSegment;
import xyz.tobebetter.service.BaseServiceI;

/**
 * Created by zhuleqi on 2018/8/31.
 */
public interface UserAndSegmentServiceI<T extends UserAndSegment,D extends UserAndSegmentDao<T>> extends BaseServiceI<T,D> {

    public Message findByContentIdAndUserId(String contentId,String userId);
}
