/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xyz.tobebetter.service.english.sentence;

import com.github.pagehelper.PageHelper;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.tobebetter.dao.sentence.SentenceDao;
import xyz.tobebetter.entity.Message;
import xyz.tobebetter.entity.english.sentence.Sentence;
import xyz.tobebetter.util.MessageUtil;
import xyz.tobebetter.util.WebConsistent;

@Service
public class SentenceServiceImpl implements SentenceServiceI {
    
    @Autowired
    private SentenceDao<Sentence> sentenceDao;

    @Override
    public SentenceDao<Sentence> getBaseDao() {
        return this.sentenceDao;
    }

    @Override
    public Message findByWordId(String wordId, Integer page, Integer pageSize) {
        if(page == null){
            page = 1;
        }
        
        if(pageSize == null){
            pageSize = WebConsistent.PAGE_SIZE;
        }
       PageHelper.startPage(page, pageSize);
       
        try {
            List<Sentence> ts = this.getBaseDao().findByWordId(wordId);
            return this.toMessage(ts);
        } catch (Exception ex) {
            Logger.getLogger(SentenceServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            return MessageUtil.createErrorMessage(ex.getMessage());
        }
       
    }

    @Override
    public Message findByShortWordId(String shortWordId, Integer page, Integer pageSize) {
        if(page == null){
            page = 1;
        }

        if(pageSize == null){
            pageSize = WebConsistent.PAGE_SIZE;
        }
        PageHelper.startPage(page, pageSize);

        return this.toMessage(()->{
            return this.getBaseDao().findByShortWordId(shortWordId);
        });
    }

    @Override
    public Message findByText(String text, Integer page, Integer pageSize) {
        if(page == null){
            page = 1;
        }
        
        if(pageSize == null){
            pageSize = WebConsistent.PAGE_SIZE;
        }
        PageHelper.startPage(page, pageSize);
         try {
             text = java.net.URLDecoder.decode(text, "UTF-8");
             Sentence sentence = new Sentence();
             sentence.setChinese(text);
             sentence.setEnglish(text);
            List<Sentence> ts = this.getBaseDao().findByText(sentence);
            return this.toMessage(ts);
        } catch (Exception ex) {
            Logger.getLogger(SentenceServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            return MessageUtil.createErrorMessage(ex.getMessage());
        }
    }
    
}
