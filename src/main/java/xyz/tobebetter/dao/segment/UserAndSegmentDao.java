package xyz.tobebetter.dao.segment;


import xyz.tobebetter.dao.BaseDao;
import xyz.tobebetter.entity.english.word.user.UserAndSegment;

/**
 * Created by zhuleqi on 2018/8/31.
 */
public interface UserAndSegmentDao<T extends UserAndSegment> extends BaseDao<T>{
    public Long countBy(T t) throws  Exception;
}
