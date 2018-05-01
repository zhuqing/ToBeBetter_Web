/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xyz.tobebetter.service.english;

import java.io.File;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.tobebetter.dao.ContentDao;
import xyz.tobebetter.entity.Message;
import xyz.tobebetter.entity.english.Content;
import xyz.tobebetter.util.FileUtil;
import xyz.tobebetter.util.MessageUtil;

/**
 *
 * @author zhuqing
 */
@Service
public class ContentServiceImpl<T extends Content, D extends ContentDao<T>> implements ContentServiceI<T, D> {

    private final static int STATUS_LAUNCH = 1;

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

    @Override
    public Message updateToLunch(String id) {
        try {
            this.contentDao.updateStatus(STATUS_LAUNCH, id);
        } catch (Exception ex) {
            Logger.getLogger(ContentServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            return MessageUtil.createErrorMessage(null);
        }

        return MessageUtil.createSuccessMessage(null);
    }

    @Override
    public String findImagePath(String id) {
        try {
            T content = (T) this.contentDao.findById(id);
            return FileUtil.appRootPath() + File.separator + content.getImagePath();
        } catch (Exception ex) {
            Logger.getLogger(ContentServiceImpl.class.getName()).log(Level.SEVERE, null, ex);

        }

        return null;
    }

    @Override
    public String findAudioPath(String id) {
        try {
            T content = (T) this.contentDao.findById(id);
            return FileUtil.appRootPath() + File.separator + content.getAudioPath();
        } catch (Exception ex) {
            Logger.getLogger(ContentServiceImpl.class.getName()).log(Level.SEVERE, null, ex);

        }

        return null;
    }

    @Override
    public Message findNews(String update) {
        try {
            List<T> ts = this.contentDao.findNews(Long.valueOf(update));
            return this.toMessage(ts);
        } catch (Exception ex) {
            Logger.getLogger(ContentServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            return MessageUtil.createErrorMessage(ex.getMessage(), null);
        }
    }

}
