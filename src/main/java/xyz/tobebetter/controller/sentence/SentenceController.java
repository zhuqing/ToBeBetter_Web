package xyz.tobebetter.controller.sentence;

import org.springframework.web.bind.annotation.*;
import xyz.tobebetter.controller.*;
import com.leqienglish.util.file.FileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import xyz.tobebetter.entity.Message;
import xyz.tobebetter.entity.english.Segment;
import xyz.tobebetter.entity.english.sentence.Sentence;
import xyz.tobebetter.service.english.sentence.SentenceServiceI;
import xyz.tobebetter.util.MessageUtil;

/**
 * 客户端检测服务端是否链接
 * Created by zhuleqi on 2018/10/25.
 */
@Controller
@RequestMapping("/sentence")
public class SentenceController  {
    
    @Autowired
    private SentenceServiceI sentenceServiceI;
      /*
     * 根据文件路径下载文件
     * @param path
     * @param request
     * @param response
     * @throws Exception
     */

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public @ResponseBody Message create(@RequestBody Sentence sentence) {
        return this.sentenceServiceI.create(sentence);
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public @ResponseBody
    Message update(@RequestBody Sentence propose) {
        return sentenceServiceI.update(propose);
    }



    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public @ResponseBody Message delete(@RequestParam String  id) {
        return this.sentenceServiceI.delete(id);
    }


    @RequestMapping(value = "/findByWordId", method = RequestMethod.GET)
    public @ResponseBody Message findByWordId(@RequestParam String wordId,@RequestParam(required = false) Integer page , @RequestParam(required = false) Integer pageSize) {
        return this.sentenceServiceI.findByWordId(wordId, page, pageSize);
    }

    @RequestMapping(value = "/findByShortWordId", method = RequestMethod.GET)
    public @ResponseBody Message findByShortWordId(@RequestParam String shortWordId,@RequestParam(required = false) Integer page , @RequestParam(required = false) Integer pageSize) {
        return this.sentenceServiceI.findByShortWordId(shortWordId, page, pageSize);
    }
    @RequestMapping(value = "/findByText", method = RequestMethod.GET)
    public @ResponseBody
    Message findByText(@RequestParam String text, @RequestParam(required = false) Integer page , @RequestParam(required = false) Integer pageSize){
        return this.sentenceServiceI.findByText(text,page,pageSize);
    }

}
