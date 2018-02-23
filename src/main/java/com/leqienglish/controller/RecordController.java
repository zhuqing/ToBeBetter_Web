//package com.leqienglish.controller;
//
//import com.leqienglish.service.ContentServiceI;
//import xyz.tobebetter.util.MessageUtil;
//import com.leqigame.entity.Content;
//import com.leqigame.entity.Message;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.*;
//
///**
// * Created by zhuqing on 2017/7/26.
// * content.type=3 用户记录
// * contentType  =1 文本
// * contentType = 2 图片
// * * contentType = 3 视频
// * contentType = 4 音频
// */
//@Controller
//@RequestMapping("record")
//public class RecordController {
//
//    @Autowired
//    private ContentServiceI contentServiceI;
//
//    @RequestMapping(value = "/saveRecord", method = RequestMethod.POST)
//    public @ResponseBody
//    Message saveRecord(@RequestBody Content content) {
//        content.setType(3 + "");
//        Long id = -1L;
//        if (content.getId() != null) {
//            id = contentServiceI.saveContent(content);
//        } else {
//            id = contentServiceI.updateContent(content);
//        }
//
//        return MessageUtil.createSuccessMessage(id);
//
//    }
//}
