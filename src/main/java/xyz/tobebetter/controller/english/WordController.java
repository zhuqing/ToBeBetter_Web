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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import xyz.tobebetter.dao.english.WordDao;
import xyz.tobebetter.entity.Message;
import xyz.tobebetter.entity.Propose;
import xyz.tobebetter.entity.english.Word;
import xyz.tobebetter.service.english.WordServiceI;

/**
 *
 * @author zhuqing
 */
@Controller
@RequestMapping("/english/word")
public class WordController {

    @Autowired
    private WordServiceI<Word,WordDao<Word>> wordService;

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public @ResponseBody
    Message create(@RequestBody Word propose) {
        return wordService.create(propose);
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

}
