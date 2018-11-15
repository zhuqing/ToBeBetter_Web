/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xyz.tobebetter.service.english.word;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.tobebetter.dao.english.WordAndSegmentDao;
import xyz.tobebetter.entity.Message;
import xyz.tobebetter.entity.english.segment.WordAndSegment;
import xyz.tobebetter.util.MessageUtil;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author zhuleqi
 * @param <T>
 */
@Service
public class WordAndSegmentServiceImpl<T extends WordAndSegment, D extends WordAndSegmentDao<T>> implements WordAndSegmentServiceI<T,D>{

    @Autowired
    private WordAndSegmentDao<T> wordAndSegmentDao;
    @Override
    public D getBaseDao() {
        return (D) wordAndSegmentDao;
    }


   

    @Override
    public Message deleteByWordIdAndContentIdAndIndex(String wordId, String contentId, int index) {
      WordAndSegment ws = new WordAndSegment();
      ws.setSegmentId(contentId);
      ws.setScentenceIndex(index);
      ws.setWordId(wordId);
        try {
            this.wordAndSegmentDao.deleteByWordIdAndSegmentIdAndIndex(ws);
        } catch (Exception ex) {
            Logger.getLogger(WordAndSegmentServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
         return MessageUtil.createErrorMessage(ex.getMessage());
        }
        return MessageUtil.createSuccessMessage();
    }

    @Override
    public Message findBySegmentId(String segmentId) {
        T ws = (T) new WordAndSegment();
        ws.setSegmentId(segmentId);
        return this.find(ws);
    }

    @Override
    public Message findByContentId(String contentId) {
        T ws = (T) new WordAndSegment();
        ws.setContentId(contentId);
        return this.find(ws);
    }

    @Override
    public Message findByWordId(String wordId) {
        try {
            List<T> ts =  this.getBaseDao().findByWordId(wordId);

            return this.toMessage(ts);
        } catch (Exception e) {
            e.printStackTrace();
            return MessageUtil.createErrorMessage(e.getMessage());
        }

    }

    @Override
    public Message findByWordIdAndContentIdAndIndex(String wordId, String segmentId, int index) {
        T ws = (T) new WordAndSegment();
        ws.setSegmentId(segmentId);
        ws.setWordId(wordId);
        ws.setScentenceIndex(index);
        return this.find(ws);
    }
}
