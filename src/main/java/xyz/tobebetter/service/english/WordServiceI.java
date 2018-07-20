/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xyz.tobebetter.service.english;

import xyz.tobebetter.dao.english.WordDao;
import xyz.tobebetter.entity.Message;
import xyz.tobebetter.entity.word.Word;

import xyz.tobebetter.service.BaseServiceI;

/**
 *
 * @author zhuqing
 * @param <T>
 * @param <D>
 */
public interface WordServiceI<T extends Word, D extends WordDao<T>> extends BaseServiceI<T, D> {

    Message findByWord(String word);

    Message create(T word, String contentId, String userId);

    Message findByUserId(String userId);
    
    Message findByContentId(String contentId);

    Message findByUserIdAndContentId(String userId, String contentId);
    
    Message findByUserIdAndWordId(String userId,String wordId);
}
