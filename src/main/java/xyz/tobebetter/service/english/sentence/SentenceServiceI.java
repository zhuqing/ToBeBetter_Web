/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xyz.tobebetter.service.english.sentence;

import xyz.tobebetter.dao.sentence.SentenceDao;
import xyz.tobebetter.entity.Message;
import xyz.tobebetter.entity.english.sentence.Sentence;
import xyz.tobebetter.service.BaseServiceI;

/**
 *
 * @author zhuleqi
 */
public interface SentenceServiceI  extends BaseServiceI<Sentence,SentenceDao<Sentence>>{
    /**
     * 根据wordId 查找句子
     * @param wordId
     * @param page
     * @param pageSize
     * @return 
     */
    public Message findByWordId(String wordId ,Integer page , Integer pageSize);

    /**
     * 根据shortWordId 查找句子
     * @param shortWordId
     * @param page
     * @param pageSize
     * @return
     */
    public Message findByShortWordId(String shortWordId ,Integer page , Integer pageSize);
    
    /**
     * 根据text 模糊查找单词
     * @param text
     * @param page
     * @param pageSize
     * @return 
     */
    public Message findByText(String text ,Integer page , Integer pageSize);
    
    
}
