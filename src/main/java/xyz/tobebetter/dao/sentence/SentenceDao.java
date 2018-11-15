/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xyz.tobebetter.dao.sentence;

import java.util.List;
import xyz.tobebetter.dao.BaseDao;
import xyz.tobebetter.entity.english.sentence.Sentence;


/**
 *
 * @author zhuleqi
 */
public interface SentenceDao <T extends Sentence> extends BaseDao<T>{

    public List<T> findByWordId(String wordId) throws Exception;
    public List<T> findByShortWordId(String shortWordId) throws Exception;

    public List<T> findByText(T t) throws Exception;
}
