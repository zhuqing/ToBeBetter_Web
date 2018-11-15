package xyz.tobebetter.service.segment;


import xyz.tobebetter.dao.english.SegmentAndShortWordDao;
import xyz.tobebetter.entity.Message;
import xyz.tobebetter.entity.english.shortword.SegmentAndShortWord;
import xyz.tobebetter.service.BaseServiceI;

/**
 * Created by zhuleqi on 2018/11/14.
 */
public interface SegmentAndShortWordServiceI extends BaseServiceI<SegmentAndShortWord,SegmentAndShortWordDao> {
    public Message findBySegmentId(String segmentId);
}
