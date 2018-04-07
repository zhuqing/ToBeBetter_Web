/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xyz.tobebetter.dao.english;

import java.util.List;
import xyz.tobebetter.dao.BaseDao;
import xyz.tobebetter.entity.english.Word;

/**
 *
 * @author zhuqing
 * @param <T>
 */
public interface WordDao<T extends Word> extends BaseDao<T> {
    public List<T> findWordsByContentId(String contentId);
}
