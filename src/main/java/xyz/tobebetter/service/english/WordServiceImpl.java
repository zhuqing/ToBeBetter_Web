/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xyz.tobebetter.service.english;

import org.springframework.stereotype.Service;
import xyz.tobebetter.dao.english.WordDao;
import xyz.tobebetter.entity.english.Word;

/**
 *
 * @author zhuqing
 */
@Service
public class WordServiceImpl<T extends Word,D extends WordDao<T>> implements WordServiceI<T,D>{

    @Override
    public D getBaseDao() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   
    
}
