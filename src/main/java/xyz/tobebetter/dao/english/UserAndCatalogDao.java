/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xyz.tobebetter.dao.english;

import java.util.List;
import xyz.tobebetter.dao.BaseDao;

/**
 *
 * @author zhuqing
 */
public interface UserAndCatalogDao<T> extends BaseDao<T> {

    List<T> findUserAndCatalogByUserId(String userId) throws Exception;

    List<T> findUserAndCatalogByCatalogId(String catalogId) throws Exception;
}
