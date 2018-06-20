/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xyz.tobebetter.service.english;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.tobebetter.dao.SegmentDao;
import xyz.tobebetter.entity.Message;
import xyz.tobebetter.entity.english.Segment;
import xyz.tobebetter.util.MessageUtil;

/**
 *
 * @author zhuqing
 */
@Service
public class SegmentService<T extends Segment> implements SegmentServiceI<T> {

    @Autowired
    private SegmentDao<T> segmentDao;

    @Override
    public SegmentDao<T> getBaseDao() {
        return segmentDao;
    }

    @Override
    public Message findByContentId(String contentId) {
        T segment = (T) new Segment();
        segment.setContentId(contentId);
        return this.find(segment);
    }


   

}
