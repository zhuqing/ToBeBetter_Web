/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xyz.tobebetter.service.english;

import java.util.List;
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

    /**
     * 先从数据库中加载，没有从其他地方加载
     * @param word
     * @return
     */
    Message findByWord(String word);

    Message create(T word, String contentId, String userId);

    Message findByUserId(String userId);
    
    Message findByContentId(String contentId);

    Message findBySegmentId(String segmentId);


    Message findByShortWordId(String shortWordId);


    Message findByUserIdAndContentId(String userId, String contentId);
    
    Message findByUserIdAndWordId(String userId,String wordId);

    Message search(String word,Integer page,Integer pageSize);
    
    
    
    /**
     * 获取正在背诵的单词
     * @param userId
     * @return
     * @throws Exception 
     */
    Message findRecitingByUserId(String userId) ;

    /**
     * 获取未背诵的单词
     * @param userId
     * @return
     * @throws Exception 
     */
    Message findUnReciteByUserId(String userId) ;

    /**
     * 获取已经背诵的单词
     * @param userId
     * @return
     * @throws Exception 
     */
    Message findHasReciteByUserId(String userId) ;

    /**
     * 获取要背诵的单词
     * @param userId
     * @param number
     * @return
     */
    Message findMyReciteByUserId(String userId , Integer number);



}
