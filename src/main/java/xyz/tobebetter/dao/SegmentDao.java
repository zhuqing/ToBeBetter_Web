/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xyz.tobebetter.dao;

import xyz.tobebetter.entity.english.Segment;
import xyz.tobebetter.entity.english.word.user.UserAndSegment;


/**
 *
 * @author zhuqing
 * @param <T>
 */
public interface SegmentDao<T extends Segment> extends BaseDao<T> {
    public long countBy(T t) throws  Exception;
}
