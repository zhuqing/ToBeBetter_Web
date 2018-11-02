package xyz.tobebetter.controller.sentence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import xyz.tobebetter.entity.Message;
import xyz.tobebetter.entity.english.sentence.Sentence;
import xyz.tobebetter.entity.english.sentence.SentenceAndWord;
import xyz.tobebetter.service.english.sentence.SentenceAndWordServiceI;
import xyz.tobebetter.service.english.sentence.SentenceServiceI;

/**
 * 客户端检测服务端是否链接
 * Created by zhuleqi on 2018/10/25.
 */
@Controller
@RequestMapping("/sentenceAndWord")
public class SentenceAndWordController {
    
    @Autowired
    private SentenceAndWordServiceI sentenceAndWordServiceI;
      /*
     * 根据文件路径下载文件
     * @param path
     * @param request
     * @param response
     * @throws Exception
     */

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public @ResponseBody Message create(@RequestBody SentenceAndWord sentence) {
        return this.sentenceAndWordServiceI.create(sentence);
    }


    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public @ResponseBody Message delete(@RequestParam String  id) {
        return this.sentenceAndWordServiceI.delete(id);
    }


    @RequestMapping(value = "/findByWordId", method = RequestMethod.GET)
    public @ResponseBody Message findByWordId(@RequestParam String wordId,@RequestParam(required = false) Integer page , @RequestParam(required = false) Integer pageSize) {
        return this.sentenceAndWordServiceI.findByWordId(wordId, page, pageSize);
    }

    @RequestMapping(value = "/findBySentenceId", method = RequestMethod.GET)
    public @ResponseBody Message findBySentenceId(@RequestParam String sentenceId,@RequestParam(required = false) Integer page , @RequestParam(required = false) Integer pageSize) {
        return this.sentenceAndWordServiceI.findBySentenceId(sentenceId, page, pageSize);
    }
//
//    @RequestMapping(value = "/findByText", method = RequestMethod.GET)
//    public @ResponseBody
//    Message findByText(@RequestParam String text, @RequestParam(required = false) Integer page , @RequestParam(required = false) Integer pageSize){
//        return this.sentenceServiceI.findByText(text,page,pageSize);
//    }

}
