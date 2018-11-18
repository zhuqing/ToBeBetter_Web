/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xyz.tobebetter.dao.english;

import org.apache.commons.fileupload.util.LimitedInputStream;
import xyz.tobebetter.dao.BaseDao;
import xyz.tobebetter.entity.english.shortword.ShortWord;

import java.util.List;

/**
 *
 * @author zhuleqi
 */
public interface ShortWordDao extends BaseDao<ShortWord> {
    public List<ShortWord> findByText(String text) throws Exception;
    List<ShortWord> findBySegmentId(String segmentId) throws Exception;
    List<ShortWord> findByContentId(String contentId) throws Exception;
    List<ShortWord> findByWordId(String wordId) throws Exception;
}
