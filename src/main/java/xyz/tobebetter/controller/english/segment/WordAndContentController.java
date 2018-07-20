/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xyz.tobebetter.controller.english.segment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import xyz.tobebetter.dao.content.WordAndContentDao;
import xyz.tobebetter.entity.Message;
import xyz.tobebetter.entity.content.WordAndContent;

import xyz.tobebetter.service.english.word.WordAndContentServiceI;

/**
 *
 * @author zhuleqi
 */
@Controller
@RequestMapping("/english/wordandcontent")
public class WordAndContentController {
     @Autowired
    private WordAndContentServiceI<WordAndContent, WordAndContentDao<WordAndContent>> wordAndContentServiceI;
    
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public @ResponseBody
    Message create(@RequestBody WordAndContent propose) {
        return wordAndContentServiceI.create(propose);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public @ResponseBody
    Message delete(@RequestParam("id") String id) {
        return this.wordAndContentServiceI.delete(id);
    }

    @RequestMapping(value = "/deleteByWordIdAndContentId", method = RequestMethod.DELETE)
    public @ResponseBody
    Message deleteByWordIdAndContentId(@RequestParam("wordId") String wordId,@RequestParam("contentId") String contentId) {
        return this.wordAndContentServiceI.deleteByWordIdAndContentId(wordId,contentId);
    }
}
