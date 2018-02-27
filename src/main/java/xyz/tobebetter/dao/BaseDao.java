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

    public List<T> findAll() throws Exception;

    public T findById(String id) throws Exception;

    public List<T> find(Page page) throws Exception;
}
