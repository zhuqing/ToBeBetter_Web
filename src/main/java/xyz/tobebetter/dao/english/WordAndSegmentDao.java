/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xyz.tobebetter.dao.english;


import org.apache.commons.fileupload.util.LimitedInputStream;
import xyz.tobebetter.dao.BaseDao;
import xyz.tobebetter.entity.english.segment.WordAndSegment;

import java.util.List;


/**
 *
 * @author zhuqing
 * @param <T>
 */
public interface WordAndSegmentDao<T extends WordAndSegment> extends BaseDao<T> {

   public void deleteByWordIdAndSegmentIdAndIndex(WordAndSegment wordAndSegment) throws Exception;
   public List<T> findByWordId(String wordId) throws Exception;
}
