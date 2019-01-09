/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xyz.tobebetter.service.english;

import xyz.tobebetter.dao.SegmentDao;
import xyz.tobebetter.entity.Message;
import xyz.tobebetter.entity.english.Segment;
import xyz.tobebetter.service.BaseServiceI;

/**
 *
 * @author zhuqing
 */
public interface SegmentServiceI<T extends Segment> extends BaseServiceI<T, SegmentDao<T>> {

    public Message findByContentId(String contentId);

    public Message findByContentId(String contentId, int status);

    public Message awesome(String id,String userId);

}
