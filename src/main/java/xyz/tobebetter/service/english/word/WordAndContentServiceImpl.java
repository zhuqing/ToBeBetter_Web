/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xyz.tobebetter.service.english.word;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.tobebetter.dao.english.WordAndContentDao;
import xyz.tobebetter.entity.english.WordAndContent;

/**
 *
 * @author zhuleqi
 */
@Service
public class WordAndContentServiceImpl<T extends WordAndContent, D extends WordAndContentDao<T>> implements WordAndContentServiceI<T,D>{

    @Autowired
    private WordAndContentDao wordAndContentDao;
    @Override
    public D getBaseDao() {
        return (D) wordAndContentDao;
    }
    
}
