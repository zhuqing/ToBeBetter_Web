//package com.leqienglish.controller;
//
//import com.leqienglish.service.CatalogServiceI;
//import xyz.tobebetter.util.EntityUtil;
//import xyz.tobebetter.util.MessageUtil;
//import com.leqigame.entity.Catalog;
//import com.leqigame.entity.Message;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.*;
//
///**
// * Created by zhuqing on 2017/10/15.
// */
//@Controller
//@RequestMapping("/catalog")
//public class CatalogController {
//    @Autowired
//    private CatalogServiceI catalogServiceI;
//
//    @RequestMapping(value = "/saveCatalog",method = RequestMethod.POST)
//    public @ResponseBody Message saveCatalog(@RequestBody Catalog catalog){
//        EntityUtil.setDate(catalog);
//        return MessageUtil.createSuccessMessage(catalogServiceI.saveCatalog(catalog));
//    }
//
//    @RequestMapping(value = "/findCatalogsByUserId/{userId}",method = RequestMethod.GET)
//    public @ResponseBody Message findCatalogsByUserId(@PathVariable Long userId){
//
//         return MessageUtil.createSuccessMessage(catalogServiceI.findCatalogsByUserId(userId));
//    }
//}
