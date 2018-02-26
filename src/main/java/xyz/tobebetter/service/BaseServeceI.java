/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xyz.tobebetter.service;

import java.util.List;
import xyz.tobebetter.entity.Page;

/**
 *
 * @author zhuqing
 */
public interface BaseServeceI<T> {
    public T create(T t);

    public T delete(String id);

    public List<T> findAll();

    public T findById(String id);

    public List<T> find(Page page);
}
