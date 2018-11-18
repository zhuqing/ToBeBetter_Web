package xyz.tobebetter.controller.shortword;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import xyz.tobebetter.entity.Message;
import xyz.tobebetter.entity.english.Content;
import xyz.tobebetter.entity.english.sentence.Sentence;
import xyz.tobebetter.entity.english.shortword.ShortWord;
import xyz.tobebetter.service.english.shortword.ShortWordServiceI;

/**
 * Created by zhuleqi on 2018/11/12.
 */
@Controller
@RequestMapping("/shortWord")
public class ShortWordController {
    
    @Autowired
    private ShortWordServiceI shortWordServiceI;
    
    
    
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public @ResponseBody Message create(@RequestBody ShortWord sentence) {
        return this.shortWordServiceI.create(sentence);
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public @ResponseBody
    Message update(@RequestBody ShortWord  propose) {
        return shortWordServiceI.update(propose);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public @ResponseBody Message delete(@RequestParam String  id) {
        return this.shortWordServiceI.delete(id);
    }
    
    
     @RequestMapping(value = "/findByText", method = RequestMethod.GET)
    public @ResponseBody Message findByText(@RequestParam String  text,@RequestParam(required = false) Integer page,@RequestParam(required = false)   Integer  pageSize){
         return this.shortWordServiceI.findByText(text, page, pageSize);
    }


    @RequestMapping(value = "/findBySegmentId", method = RequestMethod.GET)
    public @ResponseBody Message findBySegmentId(@RequestParam String  segmentId){
        return this.shortWordServiceI.findBySegmentId(segmentId);
    }

    @RequestMapping(value = "/findByContentId", method = RequestMethod.GET)
    public @ResponseBody Message findByContentId(@RequestParam String  contentId){
        return this.shortWordServiceI.findByContentId(contentId);
    }


    @RequestMapping(value = "/findByWordId", method = RequestMethod.GET)
    public @ResponseBody Message findByWordId(@RequestParam String  wordId){
        return this.shortWordServiceI.findByWordId(wordId);
    }
}
