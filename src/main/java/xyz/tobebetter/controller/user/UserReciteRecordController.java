package xyz.tobebetter.controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import xyz.tobebetter.entity.Message;
import xyz.tobebetter.entity.user.recite.UserReciteRecord;
import xyz.tobebetter.service.user.UserReciteRecordServiceI;

/**
 * Created by zhuleqi on 2018/7/21.
 */
@Controller
@RequestMapping("/userReciteRecord")
public class UserReciteRecordController  {

    @Autowired
    private UserReciteRecordServiceI userReciteRecordSercviceI;

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public @ResponseBody
    Message create(@RequestBody UserReciteRecord propose) {
        return userReciteRecordSercviceI.create(propose);
    }

    @RequestMapping(value = "/findByUserId", method = RequestMethod.GET)
    public @ResponseBody
    Message findByUserId(@RequestParam String userId) {
        return userReciteRecordSercviceI.findByUserId(userId);
    }


    @RequestMapping(value = "/updateReciteMinutes", method = RequestMethod.PUT)
    public @ResponseBody
    Message updateReciteMinutes(@RequestParam String id, @RequestParam int minutes) {
        return userReciteRecordSercviceI.updateReciteMinutes(id,minutes);
    }

}
