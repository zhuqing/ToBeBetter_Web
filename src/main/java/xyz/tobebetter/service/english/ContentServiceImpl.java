/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xyz.tobebetter.service.english;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.tobebetter.dao.ContentDao;
import xyz.tobebetter.entity.Message;
import xyz.tobebetter.entity.english.Content;
import xyz.tobebetter.util.MessageUtil;

/**
 *
 * @author zhuqing
 */
@Service
public class ContentServiceImpl<T extends Content, D extends ContentDao<T>> implements ContentServiceI<T, D> {

    @Autowired
    private ContentDao contentDao;

    @Override
    public Message updateImagePath(String contentId, String imagePath) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Message updateAudioPath(String contentId, String imagePath) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public D getBaseDao() {
        return (D) contentDao;
    }

    @Override
    public Message findLastOne() {
        T content = this.getBaseDao().findLastOne();
        if (content == null) {
            return MessageUtil.createErrorMessage(null);
        }
        return this.toMessage(content);
    }

}
