/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xyz.tobebetter.service.english.shortword;



import com.github.pagehelper.PageHelper;
import com.sun.mail.util.LineOutputStream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.tobebetter.dao.english.ShortWordDao;
import xyz.tobebetter.entity.Message;
import xyz.tobebetter.entity.english.shortword.ShortWord;
import xyz.tobebetter.util.MessageUtil;
import xyz.tobebetter.util.WebConsistent;

import java.util.List;

/**
 *
 * @author zhuleqi
 */
@Service
public class ShortWordServiceImpl implements ShortWordServiceI{

    @Autowired
    private ShortWordDao shortWordDao;
    @Override
    public ShortWordDao getBaseDao() {
      return this.shortWordDao; 
    }

    @Override
    public Message findByText(String text, Integer page, Integer pageSize) {
        if(page == null){
            page = 1;
        }

        if(pageSize == null){
            pageSize = WebConsistent.PAGE_SIZE;
        }

        PageHelper.startPage(page,pageSize);

        try {
            text = java.net.URLDecoder.decode(text, "UTF-8");
            List<ShortWord> shortWords = this.getBaseDao().findByText(text);
            return this.toMessage(shortWords);
        } catch (Exception e) {
            e.printStackTrace();
            return MessageUtil.createErrorMessage(e.getMessage());
        }

    }

    @Override
    public Message findBySegmentId(String segmentId) {
       return this.toMessage(()->{
               return this.getBaseDao().findBySegmentId(segmentId);
       });
    }

    @Override
    public Message findByContentId(String contentId) {
        return this.toMessage(()->{
            return this.getBaseDao().findByContentId(contentId);
        });
    }

    @Override
    public Message findByWordId(String wordId) {
        return this.toMessage(()->{
            return this.getBaseDao().findByWordId(wordId);
        });
    }

    @Override
    public Message findByWord(String word) {
        return this.toMessage(()->{
           String wordS = java.net.URLDecoder.decode(word, "UTF-8");

            ShortWord shortWord = new ShortWord();
            shortWord.setWord(wordS);
            return this.getBaseDao().findByEntity(shortWord);
        });
    }
}
