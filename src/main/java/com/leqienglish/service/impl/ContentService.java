//package com.leqienglish.service.impl;
//
//import com.leqienglish.dao.ContentDao;
//import com.leqienglish.model.Page;
//import com.leqienglish.service.ContentServiceI;
//import xyz.tobebetter.util.EntityUtil;
//import com.leqigame.entity.Content;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
///**
// * Created by zhuqing on 2017/8/24.
// */
//@Service
//public class ContentService implements ContentServiceI {
//    @Autowired
//    private ContentDao contentDao;
//
//    public List<Content> findContentByUserIdCatalogId(Long userId, Long catalogId) {
//        Map<String,Long> map = new HashMap();
//        map.put("userId",userId);
//        map.put("catalogId",catalogId);
//        return contentDao.findContentByUserIdCatalogId(map);
//    }
//
//    @Override
//    public List<Content> getContents(Page page) {
//        return this.contentDao.getContents(page);
//    }
//
//    public Content findContentById(Long id) {
//        return contentDao.findContentById(id);
//    }
//
//    @Override
//    public List<Content> findContentByUser(Long userId) {
//        return contentDao.findContentByUserId(userId);
//    }
//
//    @Override
//    public Long saveContent(Content content) {
//        return this.contentDao.saveContent(content);
//    }
//
//    public Long updateContent(Content content) {
//        EntityUtil.reSetUpdateDate(content);
//        return this.contentDao.updateContent(content);
//    }
//
//    public List<Content> findContentByType(Integer type, Page page) {
//        Map<String,Object> map = new HashMap<String,Object>();
//        map.put("type",type);
//        map.put("startIndex",page.getStartIndex());
//        map.put("size",page.getPageSize());
//        return null;
//    }
//
//    public List<Content> getContentByUserId(Long userId) {
//        return null;
//    }
//}
