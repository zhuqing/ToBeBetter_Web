/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xyz.tobebetter.dao.content;

import xyz.tobebetter.dao.BaseDao;
import xyz.tobebetter.entity.content.WordAndContent;


/**
 *
 * @author zhuqing
 * @param <T>
 */
public interface WordAndContentDao<T extends WordAndContent> extends BaseDao<T> {

   public void deleteByWordIdAndContentId(WordAndContent wordAndContent) throws Exception;
}
