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
import xyz.tobebetter.dao.english.WordDao;
import xyz.tobebetter.entity.Message;

import xyz.tobebetter.entity.word.Word;
import xyz.tobebetter.service.english.WordServiceI;

/**
 *
 * @author zhuqing
 */
@Controller
@RequestMapping("/english/word")
public class WordController {
    
    @Autowired
    private WordServiceI<Word, WordDao<Word>> wordService;
    
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public @ResponseBody
    Message create(@RequestBody Word propose) {
        return wordService.create(propose);
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public @ResponseBody
    Message update(@RequestBody Word propose) {
        return wordService.update(propose);
    }
    
    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public @ResponseBody
    Message delete(@RequestParam("id") String id) {
        return wordService.delete(id);
    }
    
    @RequestMapping(value = "/findAll", method = RequestMethod.GET)
    public @ResponseBody
    Message findAll() {
        return wordService.findAll();
    }
    
    @RequestMapping(value = "/findByWord", method = RequestMethod.GET)
    public @ResponseBody
    Message findByWord(@RequestParam("word") String word) {
        return wordService.findByWord(word);
    }


    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public @ResponseBody
    Message search(@RequestParam("word") String word,@RequestParam(required = false) Integer page , @RequestParam(required = false) Integer pageSize) {
        return wordService.search(word,page,pageSize);
    }


    @RequestMapping(value = "/findByUserId", method = RequestMethod.GET)
    public @ResponseBody
    Message findByUserId(@RequestParam("userId") String userId,@RequestParam(required = false)Integer page, @RequestParam(required = false)Integer pageSize) {
        return wordService.findByUserId(userId,page,pageSize);
    }
    
    
    @RequestMapping(value = "/findRecitingByUserId", method = RequestMethod.GET)
    public @ResponseBody
    Message findRecitingByUserId(@RequestParam("userId") String userId,@RequestParam(required = false)Integer page, @RequestParam(required = false)Integer pageSize) {
        return wordService.findRecitingByUserId(userId,page,pageSize);
    }


    @RequestMapping(value = "/findMyReciteByUserIdAndNumber", method = RequestMethod.GET)
    public @ResponseBody
    Message findMyReciteByUserIdAndNumber(String userId , Integer number) {
        return wordService.findMyReciteByUserId(userId, number);
    }

    
    @RequestMapping(value = "/findHasReciteByUserId", method = RequestMethod.GET)
    public @ResponseBody
    Message findHasReciteByUserId(@RequestParam("userId") String userId) {
        return wordService.findHasReciteByUserId(userId);
    }
    
    
    @RequestMapping(value = "/findUnReciteByUserId", method = RequestMethod.GET)
    public @ResponseBody
    Message findUnReciteByUserId(@RequestParam("userId") String userId) {
        return wordService.findUnReciteByUserId(userId);
    }
    
     @RequestMapping(value = "/findByContentId", method = RequestMethod.GET)
    public @ResponseBody
    Message findByContentId( @RequestParam("contentId") String contentId) {
        return wordService.findByContentId(contentId);
    }

    @RequestMapping(value = "/findByUserIdAndContentId", method = RequestMethod.GET)
    public @ResponseBody
    Message findByUserIdAndContentId(@RequestParam("userId") String userId, @RequestParam("contentId") String contentId) {
        return wordService.findByUserIdAndContentId(userId, contentId);
    }
    
     @RequestMapping(value = "/findByUserIdAndWordId", method = RequestMethod.GET)
    public @ResponseBody
    Message findByUserIdAndWordId(@RequestParam("userId") String userId, @RequestParam("wordId") String wordId) {
        return wordService.findByUserIdAndWordId(userId, wordId);
    }

    @RequestMapping(value = "/findByShortWordId", method = RequestMethod.GET)
    public @ResponseBody
    Message findByShortWordId( @RequestParam String shortWordId) {
        return wordService.findByShortWordId(shortWordId);
    }
    @RequestMapping(value = "/findBySegmentId", method = RequestMethod.GET)
    public @ResponseBody
    Message findBySegmentId( @RequestParam String segmentId) {
        return wordService.findBySegmentId(segmentId);
    }
}
