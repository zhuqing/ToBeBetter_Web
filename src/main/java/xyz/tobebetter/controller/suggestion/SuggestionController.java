package xyz.tobebetter.controller.suggestion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
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


}
