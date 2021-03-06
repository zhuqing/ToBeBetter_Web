package xyz.tobebetter.controller.content;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import xyz.tobebetter.dao.content.UserAndContentDao;
import xyz.tobebetter.entity.Message;
import xyz.tobebetter.entity.english.Content;
import xyz.tobebetter.entity.user.content.UserAndContent;
import xyz.tobebetter.service.content.UserAndContentServiceI;

/**
 * Created by zhuleqi on 2018/7/17.
 */
@Controller
@RequestMapping("/userAndContent")
public class UserAndContentController {

    @Autowired
    private UserAndContentServiceI<UserAndContent,UserAndContentDao<UserAndContent>> userAndContentServiceI;

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public @ResponseBody
    Message create(@RequestBody UserAndContent propose) {
        return this.userAndContentServiceI.create(propose);
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public @ResponseBody
    Message update(@RequestBody UserAndContent propose) {
        return this.userAndContentServiceI.update(propose);
    }

    @RequestMapping(value = "/findByUserId", method = RequestMethod.GET)
    public @ResponseBody
    Message findByUserId(@RequestParam String userId) {
        return this.userAndContentServiceI.findByUserId(userId);
    }

    @RequestMapping(value = "/remove", method = RequestMethod.PUT)
    public @ResponseBody
    Message remove(String userId,String contentId) {
        return this.userAndContentServiceI.remove(userId,contentId);
    }

    @RequestMapping(value = "/updatePrecent", method = RequestMethod.PUT)
    public @ResponseBody
    Message updatePrecent(@RequestParam String userId, @RequestParam String contentId , @RequestParam Integer precent) {
        return this.userAndContentServiceI.updatePrecent(userId,contentId,precent);
    }

    @RequestMapping(value = "/findById", method = RequestMethod.GET)
    public @ResponseBody
    Message findById(@RequestParam String id) {
        return this.userAndContentServiceI.findById(id);
    }

}
