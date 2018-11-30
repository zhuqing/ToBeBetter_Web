/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xyz.tobebetter.dao.content;

import java.util.List;



import org.apache.ibatis.annotations.Param;
import xyz.tobebetter.dao.BaseDao;
import xyz.tobebetter.entity.Message;
import xyz.tobebetter.entity.Page;
import xyz.tobebetter.entity.english.Content;
import xyz.tobebetter.entity.english.content.ReciteContentVO;
import xyz.tobebetter.entity.user.content.UserAndContent;

/**
 *
 * @author zhuqing
 */
public interface ContentDao<T extends Content> extends BaseDao<T> {



    @Override
    public void create(Content t) throws Exception;

    /**
     * 更加单词获取单词相关的Content
     *
     * @param wordId
     * @param page
     * @return
     */
    public List<T> findContentsByWordId(@Param("wordId") String wordId, @Param("page") Page page);

    /**
     * 获取最新的Content
     *
     * @return
     */
    public T findLastOne();

    public List<T> findNews(Long updateDate) throws Exception;

    public List<T> findByTitle(Content content) throws Exception;



    public List<T> findByCatalogId(Content content) throws Exception;


    public List<T> findByCatalogIdAndTitle(Content content) throws Exception;


    public List<T> recommendContents(String userId) throws Exception;


}
