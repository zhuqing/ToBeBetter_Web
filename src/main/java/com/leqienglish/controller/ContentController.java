//package com.leqienglish.controller;
//
//import com.leqienglish.model.Page;
//import com.leqienglish.service.ContentServiceI;
//import xyz.tobebetter.util.EntityUtil;
//import xyz.tobebetter.util.MessageUtil;
//import com.leqigame.entity.Content;
//import com.leqigame.entity.Message;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.*;
//import org.springframework.web.multipart.MultipartFile;
//
//import javax.servlet.http.HttpServletRequest;
//import java.io.File;
//import java.util.List;
//
///**
// * Created by zhuqing on 2017/8/24.
// */
//@Controller
//@RequestMapping("/content")
//public class ContentController {
//
//    @Autowired
//    private ContentServiceI contentServiceI;
//
//    @RequestMapping(value="/saveContent",method= RequestMethod.POST)
//    public @ResponseBody Message saveContent( @RequestBody Content artical){
//        EntityUtil.setDate(artical);
//             Long contentId = this.contentServiceI.saveContent(artical);
//             return  MessageUtil.createMessage("1","ok",contentId);
//    }
//
//
//
//    @RequestMapping(value="/getContents/{page}/{pageSize}",method= RequestMethod.GET)
//    public @ResponseBody Message getContents(@PathVariable Integer page,@PathVariable Integer pageSize){
//
//        List<Content> contents = this.contentServiceI.getContents(new Page(page,pageSize));
//        return MessageUtil.createSuccessMessage(contents);
//    }
//
//    @RequestMapping(value="/getContentByUserId",method= RequestMethod.GET)
//    public @ResponseBody Message getContentByUserId(@RequestParam("userId") Long userId){
//        List<Content> contents = this.contentServiceI.findContentByUser(userId);
//
//        return MessageUtil.createMessage("1","ok",contents);
//    }
//
//    @RequestMapping(value="/getContentById/{id}",method= RequestMethod.GET)
//    public @ResponseBody Message getContentById( @PathVariable Long id){
//        return MessageUtil.createSuccessMessage(contentServiceI.findContentById(id));
//    }
//
//    @RequestMapping(value = "/getContentByType/{type}/{page}/{pageSize}",method = RequestMethod.GET)
//    public List<Content> getContentByType(Integer type,Integer page,Integer pageSize){
//        Page p = new Page();
//        p.setPageSize(pageSize);
//        p.setPage(page);
//
//        return contentServiceI.findContentByType(type,p);
//    }
//    @RequestMapping(value = "/getContentByUserIdAndCatalogId/{userId}/{catalogId}",method = RequestMethod.PUT)
//    public @ResponseBody Message getContentByUserIdAndCatalogId( @PathVariable Long userId,@PathVariable Long catalogId){
//        List<Content> contents = this.contentServiceI.findContentByUserIdCatalogId(userId,catalogId);
//        return MessageUtil.createSuccessMessage(contents);
//    }
//
//    @RequestMapping(value = "/getOnlyContentById/{id}",method = RequestMethod.GET)
//    public @ResponseBody Message getOnlyContentById(@PathVariable Long id){
//        return MessageUtil.createSuccessMessage("");
//    }
//
//    @RequestMapping(value = "/upload",method = RequestMethod.POST)
//    public Message upload(@RequestParam(value = "file", required = false) MultipartFile file, HttpServletRequest request) {
//
//        System.out.println("开始:");
//        String path = System.getProperty("USER_HOME");
//         path = path+"/";
//        String fileName = file.getOriginalFilename();
//        System.out.println(path);
//        File targetFile = new File(path, fileName);
//        if(!targetFile.exists()){
//            targetFile.mkdirs();
//        }
//
//        //保存
//        try {
//            file.transferTo(targetFile);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        Message msg = new Message();
//        msg.setMsg("ok");
//
//        return msg;
//    }
//}
