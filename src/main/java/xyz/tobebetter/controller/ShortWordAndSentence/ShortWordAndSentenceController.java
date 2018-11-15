package xyz.tobebetter.controller.ShortWordAndSentence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import xyz.tobebetter.entity.Message;
import xyz.tobebetter.entity.english.shortword.ShortWord;
import xyz.tobebetter.entity.english.shortword.ShortWordAndSentence;
import xyz.tobebetter.service.english.shortword.ShortWordAndSentence.ShortWordAndSentenceServiceI;

/**
 * Created by zhuleqi on 2018/11/13.
 */
@Controller
@RequestMapping("/shortWordAndSentence")
public class ShortWordAndSentenceController {
    @Autowired
    private ShortWordAndSentenceServiceI shortWordAndSentenceServiceI;


    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public @ResponseBody
    Message create(@RequestBody ShortWordAndSentence sentence) {
        return this.shortWordAndSentenceServiceI.create(sentence);
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public @ResponseBody
    Message update(@RequestBody ShortWordAndSentence  propose) {
        return shortWordAndSentenceServiceI.update(propose);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public @ResponseBody Message delete(@RequestParam String  id) {
        return this.shortWordAndSentenceServiceI.delete(id);
    }

    @RequestMapping(value = "/findByShortWordId", method = RequestMethod.GET)
    public @ResponseBody Message findByText(@RequestParam String  shortWordId,@RequestParam(required = false) Integer page,@RequestParam(required = false)   Integer  pageSize){
        return this.shortWordAndSentenceServiceI.findByShortWordId(shortWordId,page,pageSize);
    }

}
