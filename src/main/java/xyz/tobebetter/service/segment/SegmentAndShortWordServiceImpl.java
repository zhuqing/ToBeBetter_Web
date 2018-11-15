package xyz.tobebetter.service.segment;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.tobebetter.dao.english.SegmentAndShortWordDao;
import xyz.tobebetter.entity.Message;
import xyz.tobebetter.entity.english.shortword.SegmentAndShortWord;

/**
 * Created by zhuleqi on 2018/11/14.
 */
@Service
public class SegmentAndShortWordServiceImpl implements SegmentAndShortWordServiceI {

    @Autowired
    private SegmentAndShortWordDao segmentAndShortWordDao;
    @Override
    public SegmentAndShortWordDao getBaseDao() {
        return this.segmentAndShortWordDao;
    }

    @Override
    public Message findBySegmentId(String segmentId) {
        SegmentAndShortWord segmentAndShortWord = new SegmentAndShortWord();
        segmentAndShortWord.setSegmentId(segmentId);


        return this.find(segmentAndShortWord);
    }
}
