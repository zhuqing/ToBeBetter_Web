package xyz.tobebetter.controller.user;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import xyz.tobebetter.dao.user.UserDao;
import xyz.tobebetter.entity.Message;
import xyz.tobebetter.entity.user.User;
import xyz.tobebetter.entity.user.UserHearted;
import xyz.tobebetter.service.user.UserHeartedServiceI;
import xyz.tobebetter.service.user.UserServiceI;

/**
 * Created by zhuleqi on 2018/2/23.
 */
@Controller
@RequestMapping("/userHearted")
public class UserHeartedController {

    @Autowired
    private UserHeartedServiceI userHeartedServiceI;

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public @ResponseBody
    Message create(@RequestBody UserHearted userHearted) {
        return userHeartedServiceI.create(userHearted);
    }


    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public @ResponseBody
    Message delete(@RequestParam  String id) {

        return this.userHeartedServiceI.delete(id);
    }




    @RequestMapping(value = "/findByUserIdAndType", method = RequestMethod.GET)
    public @ResponseBody
    Message findByUserIdAndType(@RequestParam String userId,@RequestParam Integer type) {
        return this.userHeartedServiceI.findByUserIdAndType(userId, type);
    }



    @RequestMapping(value = "/findByUserIdAndTargetId", method = RequestMethod.GET)
    public @ResponseBody
    Message findByUserIdAndTargetId(@RequestParam String userId,@RequestParam String targetId){
        return this.userHeartedServiceI.findByUserIdAndTargetId(userId, targetId);
    }

}
