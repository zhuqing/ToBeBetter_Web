/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xyz.tobebetter.dao.english;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import xyz.tobebetter.dao.BaseDao;
import xyz.tobebetter.entity.word.Word;


/**
 *
 * @author zhuqing
 * @param <T>
 */
public interface WordDao<T extends Word> extends BaseDao<T> {

    /**
     * 根据单词查找数据
     *
     * @param word
     * @return
     */
    T findByword(String word) throws Exception;

    List<T> findByUserId(String userId) throws Exception;

    List<T> findByContentId(String contentId) throws Exception;

    List<T> findBySegmentId(String contentId) throws Exception;

    List<T> findByUserIdAndContentId(@Param("userId") String userId, @Param("contentId") String contentId) throws Exception;

    List<T> findByUserIdAndWordId(@Param("userId") String userId, @Param("wordId") String wordId) throws Exception;
}
