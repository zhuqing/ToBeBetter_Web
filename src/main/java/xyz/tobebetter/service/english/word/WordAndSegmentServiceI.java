/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xyz.tobebetter.service.english.word;

import org.springframework.stereotype.Service;
import xyz.tobebetter.dao.english.WordAndContentDao;
import xyz.tobebetter.dao.english.WordAndSegmentDao;

import xyz.tobebetter.entity.Message;

import xyz.tobebetter.entity.english.segment.WordAndSegment;
import xyz.tobebetter.service.BaseServiceI;

/**
 *
 * @author zhuleqi
 */

public interface WordAndSegmentServiceI<T extends WordAndSegment, D extends WordAndSegmentDao<T>> extends BaseServiceI<T, D> {

    public Message deleteByWordIdAndContentIdAndIndex(String wordId,String contentId,int index);

    public Message findBySegmentId(String segmentId);

    public Message findByWordIdAndContentIdAndIndex(String wordId,String contentId,int index);
}
