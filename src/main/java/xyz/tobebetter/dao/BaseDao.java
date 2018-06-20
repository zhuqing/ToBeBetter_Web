/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xyz.tobebetter.dao;

import java.util.List;
import xyz.tobebetter.entity.Page;

/**
 *
 * @author zhuqing
 */
public interface BaseDao<T> {

    public void create(T t) throws Exception;

    public void delete(String id) throws Exception;

    public void update(T t) throws Exception;

    public List<T> findAll() throws Exception;

    public T findById(String id) throws Exception;

    public List<T> find(Page page) throws Exception;

    /**
     * 根据实体生成查询条件
     * @param t
     * @return
     * @throws Exception 
     */
    public List<T> findByEntity(T t) throws Exception;

    public Long getCount() throws Exception;
    
    public void updateStatusById(T t) throws Exception;
}
