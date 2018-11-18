package xyz.tobebetter.controller.shortword;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import xyz.tobebetter.entity.Message;
import xyz.tobebetter.entity.english.shortword.ShortWord;
import xyz.tobebetter.entity.english.shortword.ShortWordAndWord;
import xyz.tobebetter.service.english.shortword.shortwordandword.ShortWordAndWordServiceI;

/**
 * Created by zhuleqi on 2018/11/17.
 */
@Controller
@RequestMapping("/shortWordAndWord")
public class ShortWordAndWordController {
    @Autowired
    private ShortWordAndWordServiceI shortWordAndWordServiceI;


    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public @ResponseBody
    Message create(@RequestBody ShortWordAndWord sentence) {
        return this.shortWordAndWordServiceI.create(sentence);
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public @ResponseBody
    Message update(@RequestBody ShortWordAndWord  propose) {
        return shortWordAndWordServiceI.update(propose);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public @ResponseBody Message delete(@RequestParam String  id) {
        return this.shortWordAndWordServiceI.delete(id);
    }


}
