/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xyz.tobebetter.service.english;

import com.leqienglish.util.task.LQExecutors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.tobebetter.dao.SegmentDao;
import xyz.tobebetter.dao.user.UserHeartedDao;
import xyz.tobebetter.entity.Consistent;
import xyz.tobebetter.entity.Message;
import xyz.tobebetter.entity.english.Segment;
import xyz.tobebetter.entity.user.UserHearted;
import xyz.tobebetter.service.user.UserHeartedServiceI;
import xyz.tobebetter.util.MessageUtil;

import java.util.List;

/**
 *
 * @author zhuqing
 */
@Service
public class SegmentService<T extends Segment> implements SegmentServiceI<T> {

    @Autowired
    private SegmentDao<T> segmentDao;

    @Autowired
    private UserHeartedServiceI userHeartedServiceI;

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

    @Override
    public Message findByContentId(String contentId, int status) {
        T segment = (T) new Segment();
        segment.setContentId(contentId);
        segment.setStatus(status);
        return this.find(segment);
    }

    @Override
    public Message awesome(String id, String userId) {
        try {
            List<T> contents = this.getBaseDao().findById(id);
            if(contents == null || contents.isEmpty()){
                return MessageUtil.createErrorMessage("没找到数据");
            }

            T content = contents.get(0);

            if(content.getAwesomeNum() == null){
                content.setAwesomeNum(1);
            }else{
                content.setAwesomeNum(content.getAwesomeNum()+1);
            }

            this.getBaseDao().update(content);

            LQExecutors.getSingleThreadExecutor().execute(()->{
                UserHearted userHearted = new UserHearted();
                userHearted.setTargetId(content.getId());
                userHearted.setUserId(userId);
                userHearted.setType(Consistent.CONTENT_TYPE_SEGMENT);
                try {
                   userHeartedServiceI.insert(userHearted);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });

            return MessageUtil.createSuccessMessage(id);

        } catch (Exception e) {
            e.printStackTrace();
            return MessageUtil.createErrorMessage(e.getMessage());
        }

    }

}
