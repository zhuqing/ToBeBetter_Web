/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xyz.tobebetter.service.english;

import xyz.tobebetter.dao.english.WordDao;
import xyz.tobebetter.entity.english.Word;
import xyz.tobebetter.service.BaseServiceI;

/**
 *
 * @author zhuqing
 */
public interface WordServiceI<T extends Word,D extends WordDao<T>> extends BaseServiceI<T,D>{
    
}
