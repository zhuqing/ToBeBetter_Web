package xyz.tobebetter.controller.suggestion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import xyz.tobebetter.entity.Message;
import xyz.tobebetter.entity.english.Catalog;
import xyz.tobebetter.entity.suggestion.Suggestion;
import xyz.tobebetter.service.recommend.RecommendServiceI;
import xyz.tobebetter.service.suggestion.SuggestionServiceI;

/**
 * Created by zhuleqi on 2018/8/8.
 */

@Controller
@RequestMapping("/suggestion")
public class SuggestionController {
    @Autowired
    private SuggestionServiceI suggestionServiceI;

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public @ResponseBody
    Message create(@RequestBody Suggestion suggestion) {
        return suggestionServiceI.create(suggestion);
    }

    @RequestMapping(value = "/findAll", method = RequestMethod.GET)
    public @ResponseBody
    Message findAll() {
        return this.suggestionServiceI.findAll();
    }

}
