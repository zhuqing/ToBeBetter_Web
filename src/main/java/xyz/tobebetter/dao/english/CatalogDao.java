/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xyz.tobebetter.dao.english;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import xyz.tobebetter.dao.BaseDao;
import xyz.tobebetter.entity.Page;
import xyz.tobebetter.entity.english.Catalog;

/**
 *
 * @author zhuqing
 */
public interface CatalogDao<T extends Catalog> extends BaseDao<T>{
        /**
     * 获取分类的子分类
     * @param parentId
     * @return 
     */
    List<T> getCatalogByParentId(String parentId) throws Exception;
    
    List<T> getCatalogByUserId(@Param("userId") String userId,@Param("type") Integer type) throws Exception;
    
    List<T> getCatalog(Catalog catalog) throws Exception;

    public List<T> findByContentId(String contentId) throws Exception;

    // List<T> getCatalogByType(@Param("type") Integer type , @Param("page") Page page) throws Exception;
}
