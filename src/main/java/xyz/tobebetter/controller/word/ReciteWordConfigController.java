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

import xyz.tobebetter.entity.word.ReciteWordConfig;
import xyz.tobebetter.entity.word.Word;
import xyz.tobebetter.service.english.WordServiceI;
import xyz.tobebetter.service.english.recitewordconfig.ReciteWordConfigServiceI;

/**
 *
 * @author zhuqing
 */
@Controller
@RequestMapping("/reciteWordConfig")
public class ReciteWordConfigController {
    
    @Autowired
    private ReciteWordConfigServiceI reciteWordConfigServiceI;
    
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public @ResponseBody
    Message create(@RequestBody ReciteWordConfig propose) {
        return reciteWordConfigServiceI.create(propose);
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public @ResponseBody
    Message update(@RequestBody ReciteWordConfig propose) {
        return reciteWordConfigServiceI.update(propose);
    }
    
    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public @ResponseBody
    Message delete(@RequestParam("id") String id) {
        return reciteWordConfigServiceI.delete(id);
    }
    
    @RequestMapping(value = "/findAll", method = RequestMethod.GET)
    public @ResponseBody
    Message findAll() {
        return reciteWordConfigServiceI.findAll();
    }

    
    @RequestMapping(value = "/findByUserId", method = RequestMethod.GET)
    public @ResponseBody
    Message findRecitingByUserId(@RequestParam("userId") String userId) {
        return reciteWordConfigServiceI.findByUserId(userId);
    }

    @RequestMapping(value = "/updateReciteNumberPerDay", method = RequestMethod.PUT)
    public @ResponseBody
    Message updateReciteNumberPerDay(@RequestParam String userId, @RequestParam Integer number) {
        return reciteWordConfigServiceI.updateReciteNumberPerDay(userId,number);
    }

    @RequestMapping(value = "/addHasReciteNumber", method = RequestMethod.PUT)
    public @ResponseBody
    Message addHasReciteNumber(@RequestParam String userId, @RequestParam Integer number) {
        return reciteWordConfigServiceI.addHasReciteNumber(userId,number);
    }

    @RequestMapping(value = "/updateMyWordsNumber", method = RequestMethod.PUT)
    public @ResponseBody
    Message updateMyWordsNumber(@RequestParam String userId, @RequestParam Integer number) {
        return reciteWordConfigServiceI.updateMyWordsNumber(userId, number);
    }
    

}
