/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xyz.tobebetter.service.english.book;

import java.util.List;
import xyz.tobebetter.entity.english.Catalog;
import xyz.tobebetter.service.BaseServiceI;
import xyz.tobebetter.dao.english.CatalogDao;
import xyz.tobebetter.entity.Message;

/**
 *
 * @author zhuqing
 */
public interface CatalogServiceI<T extends Catalog, D extends CatalogDao<T>> extends BaseServiceI<T, D> {

    /**
     * 获取分类的子分类
     *
     * @param parentId
     * @return
     */
    Message getCatalogByParentId(String parentId);
    
      /**
     * 获取分类的子分类
     *
     * @param parentId
     * @param page
     * @param pageSize
     * @return
     */
    Message getCatalogByParentId(String parentId,int page,int pageSize);


    /**
     * 获取分类，根据分类类型
     *
     * @param type
     * @param pageSize
     * @param page
     * @return
     */
    Message getCatalogByType(int type, int pageSize, int page);

    Message getBookByUserId(String userId);

    Message getAllCatalogsByType(int type);
    Message getAllLunchedCatalogsByType(int type);

    public Message findByContentId(String contentId);
}
