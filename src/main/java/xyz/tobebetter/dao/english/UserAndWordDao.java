/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xyz.tobebetter.dao.english;

import java.util.List;



import xyz.tobebetter.dao.BaseDao;
import xyz.tobebetter.entity.user.word.UserAndWord;



/**
 *
 * @author zhuqing
 * @param <T>
 */
public interface UserAndWordDao<T extends UserAndWord> extends BaseDao<T> {


    public void saveList(List<T> userAndWordList) throws  Exception;

    public Long allMyWordsCount(String userId) throws Exception;

    public Long hasRecitedWordsCount(String userId) throws Exception;
}
