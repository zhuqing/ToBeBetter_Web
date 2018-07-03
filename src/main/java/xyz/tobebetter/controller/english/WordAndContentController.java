/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xyz.tobebetter.controller.english;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import xyz.tobebetter.dao.english.WordAndContentDao;
import xyz.tobebetter.dao.english.WordDao;
import xyz.tobebetter.entity.Message;
import xyz.tobebetter.entity.english.Word;
import xyz.tobebetter.entity.english.WordAndContent;
import xyz.tobebetter.service.english.WordServiceI;
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
}
