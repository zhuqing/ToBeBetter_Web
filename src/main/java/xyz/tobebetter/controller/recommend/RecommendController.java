package xyz.tobebetter.controller.recommend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import xyz.tobebetter.entity.Message;
import xyz.tobebetter.service.recommend.RecommendServiceI;

/**
 * Created by zhuleqi on 2018/7/13.
 */
@Controller
@RequestMapping("/recommend")
public class RecommendController {
    @Autowired
    private RecommendServiceI recommendServiceI;

    @RequestMapping(value = "/recommendBook", method = RequestMethod.GET)
    public @ResponseBody
    Message recommendBook(@RequestParam("userId") String userId) {
        return this.recommendServiceI.recommendBook(userId);
    }

    @RequestMapping(value = "/recommendArticle", method = RequestMethod.GET)
    public @ResponseBody
    Message recommendArticle(@RequestParam("userId") String userId) {
        return this.recommendServiceI.recommendArticle(userId);
    }
}
