/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xyz.tobebetter.service.content;


import xyz.tobebetter.dao.content.ContentDao;
import xyz.tobebetter.entity.Message;
import xyz.tobebetter.entity.english.Content;
import xyz.tobebetter.service.BaseServiceI;

/**
 *
 * @author zhuqing
 * @param <T>
 */
public interface ContentServiceI<T extends Content> extends BaseServiceI<T, ContentDao<T>> {

    public Message findLastOne();

    public Message findNews(String update);


    public Message recommendContents(String userId);



    public String findImagePath(String id);

    public String findAudioPath(String id);

    public Message findContentByCatalogId(String catalogId, Integer page, Integer pageSize);

    public Message findContentByParentId(String parentId, Integer page, Integer pageSize);


    public Message findContentsByCatalogIdAndTitle(String catalogId , String title);



}
