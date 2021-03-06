/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xyz.tobebetter.service.english.word;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.tobebetter.dao.content.WordAndContentDao;
import xyz.tobebetter.entity.Message;

import xyz.tobebetter.service.user.UserServiceImpl;
import xyz.tobebetter.util.MessageUtil;

import java.util.logging.Level;
import java.util.logging.Logger;
import xyz.tobebetter.entity.content.WordAndContent;

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

    public  Message delete(String id) {

        try {

            this.getBaseDao().delete(id);

        } catch (Exception ex) {
            Logger.getLogger(UserServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            return MessageUtil.createErrorMessage(ex.getMessage(), null);
        }

        return MessageUtil.createSuccessMessage(id);
    }

    @Override
    public Message deleteByWordIdAndContentId(String wordId, String contentId) {
        WordAndContent wordAndContent = new WordAndContent();
        wordAndContent.setWordId(wordId);
        wordAndContent.setContentId(contentId);
        try {
            this.wordAndContentDao.deleteByWordIdAndContentId(wordAndContent);
        } catch (Exception e) {
            e.printStackTrace();
            return MessageUtil.createErrorMessage(e.getMessage());
        }
        return MessageUtil.createSuccessMessage();
    }
}
