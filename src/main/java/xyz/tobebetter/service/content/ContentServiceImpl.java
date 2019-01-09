/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xyz.tobebetter.service.content;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.github.pagehelper.PageHelper;
import com.leqienglish.util.file.FileUtil;

import com.leqienglish.util.task.LQExecutors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.tobebetter.dao.content.ContentDao;
import xyz.tobebetter.dao.user.UserHeartedDao;
import xyz.tobebetter.entity.Consistent;
import xyz.tobebetter.entity.Message;
import xyz.tobebetter.entity.english.Content;

import xyz.tobebetter.entity.user.UserHearted;
import xyz.tobebetter.entity.user.content.UserAndContent;
import xyz.tobebetter.service.user.UserHeartedServiceI;
import xyz.tobebetter.util.MessageUtil;

/**
 * @author zhuqing
 */
@Service
public class ContentServiceImpl<T extends Content> implements ContentServiceI<T> {

    private final static int STATUS_LAUNCH = 1;

    @Autowired
    private ContentDao<T> contentDao;

    @Autowired
    private UserHeartedServiceI userHeartedServiceI;


    @Override
    public ContentDao<T> getBaseDao() {
        return contentDao;
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
    public String findImagePath(String id) {
        try {
            T content = (T) this.contentDao.findById(id);
            return FileUtil.getInstence().appRootPath() + File.separator + content.getImagePath();
        } catch (Exception ex) {
            Logger.getLogger(ContentServiceImpl.class.getName()).log(Level.SEVERE, null, ex);

        }

        return null;
    }

    @Override
    public String findAudioPath(String id) {
        try {
            T content = (T) this.contentDao.findById(id);
            return FileUtil.getInstence().appRootPath() + File.separator + content.getAudioPath();
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

    @Override
    public Message recommendContents(String userId) {
        try {
            List<T> ts = this.getBaseDao().recommendContents(userId);
            return this.toMessage(ts);
        } catch (Exception e) {
            e.printStackTrace();
            return MessageUtil.createErrorMessage(e.getMessage(), null);
        }
    }

    @Override
    public Message awesome(String id, String userId) {
        try {
            List<T> contents = this.getBaseDao().findById(id);
            if(contents == null || contents.isEmpty()){
                return MessageUtil.createErrorMessage("没找到数据");
            }

            T content = contents.get(0);

            if(content.getAwesomeNum() == null){
                content.setAwesomeNum(1L);
            }else{
                content.setAwesomeNum(content.getAwesomeNum()+1L);
            }

            this.getBaseDao().update(content);

            LQExecutors.getSingleThreadExecutor().execute(()->{
                UserHearted userHearted = new UserHearted();
                userHearted.setTargetId(content.getId());
                userHearted.setUserId(userId);
                userHearted.setType(Consistent.CONTENT_TYPE_CONTENT);
                try {
                    userHeartedServiceI.insert(userHearted);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });

            return MessageUtil.createSuccessMessage(id);

        } catch (Exception e) {
            e.printStackTrace();
            return MessageUtil.createErrorMessage(e.getMessage());
        }

    }

    @Override
    public Message readNum(String id) {
        try {
            List<T> contents = this.getBaseDao().findById(id);
            if(contents == null || contents.isEmpty()){
                return MessageUtil.createErrorMessage("没找到数据");
            }

            T content = contents.get(0);

            if(content.getReadNum() == null){
                content.setReadNum(1L);
            }else{
                content.setReadNum(content.getReadNum()+1L);
            }

            this.getBaseDao().update(content);
            return MessageUtil.createSuccessMessage(id);

        } catch (Exception e) {
            e.printStackTrace();
            return MessageUtil.createErrorMessage(e.getMessage());
        }
    }


    @Override
    public Message findContentByParentId(String parentId, Integer page, Integer pageSize) {
        Content content = new Content();
        content.setParentId(parentId);
        return this.find((T) content, page, pageSize);
    }

    @Override
    public Message findContentsByCatalogIdAndTitle(String catalogId, String title,Integer page, Integer pageSize) {
        if(page == null){
            page = 1 ;
        }

        if(pageSize == null){
            pageSize = 10;
        }

        try {
            title= URLDecoder.decode(title, "utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        PageHelper.startPage(page,pageSize);
        try {
            Content content = new Content();
            content.setTitle(title);
            content.setCatalogId(catalogId);
            List<T> ts = null;

            if(content.getCatalogId()== null && content.getTitle() == null){
                ts = this.getBaseDao().findAll();
            }else if (content.getCatalogId()== null || content.getCatalogId().isEmpty()) {
                ts = this.getBaseDao().findByTitle(content);
            } else if(content.getTitle() == null || content.getTitle().isEmpty()) {
                ts = this.getBaseDao().findByCatalogId(content);
            }else{
                ts = this.getBaseDao().findByCatalogIdAndTitle(content);
            }

            return this.toMessage(ts);
        } catch (Exception e) {
            e.printStackTrace();
            return MessageUtil.createErrorMessage(e.getMessage());
        }

    }

    @Override
    public Message findByUserId(String userId) {
        return this.toMessage(()->{
            return getBaseDao().findByUserId(userId);
        });
    }


    @Override
    public Message findContentByCatalogId(String catalogId, Integer page, Integer pageSize) {
        Content content = new Content();
        content.setCatalogId(catalogId);
        return this.find((T) content, page, pageSize);
    }


}
