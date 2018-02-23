//package com.leqienglish.service.impl;
//
//import com.leqienglish.dao.CatalogDao;
//import com.leqienglish.service.CatalogServiceI;
//import com.leqigame.entity.Catalog;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
///**
// * Created by zhuqing on 2017/10/15.
// */
//@Service
//public class CatalogService implements CatalogServiceI {
//    @Autowired
//    private CatalogDao catalogDao;
//    public Long saveCatalog(Catalog catalog) {
//        return catalogDao.saveCatalog(catalog);
//    }
//
//    public List<Catalog> findCatalogsByUserId(Long userId) {
//        return catalogDao.findCatalogsByUserId(userId);
//    }
//}
