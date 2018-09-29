/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xyz.tobebetter.controller.word;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import xyz.tobebetter.dao.english.UserAndWordDao;
import xyz.tobebetter.dao.english.WordDao;
import xyz.tobebetter.entity.Message;
import xyz.tobebetter.entity.user.word.UserAndWord;

import xyz.tobebetter.entity.word.Word;
import xyz.tobebetter.service.english.WordServiceI;
import xyz.tobebetter.service.english.userword.UserAndWordServiceI;

/**
 *
 * @author zhuqing
 */
@Controller
@RequestMapping("/userAndWord")
public class UserAndWordController {
    
    @Autowired
    private UserAndWordServiceI<UserAndWord, UserAndWordDao<UserAndWord>> userAndWordServiceI;
    
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public @ResponseBody
    Message create(@RequestBody UserAndWord propose) {
        return userAndWordServiceI.create(propose);
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public @ResponseBody
    Message update(@RequestBody UserAndWord propose) {
        return userAndWordServiceI.update(propose);
    }



    @RequestMapping(value = "/findByUserAndWord", method = RequestMethod.GET)
    public @ResponseBody
    Message findByUserAndWord(@RequestParam  String userId , @RequestParam String wordId) {
        return userAndWordServiceI.findByUserAndWord(userId,wordId);
    }

    @RequestMapping(value = "/insertAllByContentId", method = RequestMethod.POST)
    public @ResponseBody
    Message insertAllByContentId(@RequestParam  String contentId,@RequestParam String userId) {
        return userAndWordServiceI.insertAllByContentId(contentId,userId);
    }
    @RequestMapping(value = "/insertAllBySegmentId", method = RequestMethod.POST)
    public @ResponseBody
    Message insertAllBySegmentId(@RequestParam  String segmentId,@RequestParam String userId) {
        return userAndWordServiceI.insertAllBySegmentId(segmentId,userId);
    }

    @RequestMapping(value = "/insertByWordId", method = RequestMethod.POST)
    public @ResponseBody
    Message insertByWordId(@RequestParam  String wordId,@RequestParam String userId) {
        return userAndWordServiceI.insertByWordId(wordId,userId);
    }

    @RequestMapping(value = "/increamReciteCount", method = RequestMethod.PUT)
    public @ResponseBody
    Message increamReciteCount(@RequestParam  String wordId,@RequestParam String userId) {
        return userAndWordServiceI.increamReciteCount(wordId,userId);
    }
}
