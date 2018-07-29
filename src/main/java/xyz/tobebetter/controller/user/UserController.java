package xyz.tobebetter.controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import xyz.tobebetter.dao.user.UserDao;
import xyz.tobebetter.entity.Consistent;
import xyz.tobebetter.entity.Message;
import xyz.tobebetter.entity.user.User;

import xyz.tobebetter.service.user.UserServiceI;

/**
 * Created by zhuleqi on 2018/2/23.
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserServiceI<User,UserDao<User>> userService;

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public @ResponseBody
    Message create(@RequestBody User user) {

        return this.userService.create(user);
    }

    @RequestMapping(value = "/getCount", method = RequestMethod.GET)
    public @ResponseBody
    Message getCount() {
        return this.userService.getCount();
    }

    @RequestMapping(value = "/findUserByOtherSysId/{otherSysId}", method = RequestMethod.GET)
    public @ResponseBody
    Message findUserByOtherSysId(@PathVariable String otherSysId) {
        return this.userService.findUserByOtherSysId(otherSysId);
    }

    @RequestMapping(value = "/findUserByEmail/{email}", method = RequestMethod.GET)
    public @ResponseBody
    Message findUserByEmail(@PathVariable String email) {
        return this.userService.findUserByEmail(email);
    }

    @RequestMapping(value = "/findUserByName/{name}", method = RequestMethod.GET)
    public @ResponseBody
    Message findUserByName(@PathVariable String name) {
        return this.userService.findUserByName(name);
    }

    @RequestMapping(value = "/findUserByPhoneName/{phoneName}", method = RequestMethod.GET)
    public @ResponseBody
    Message findUserByPhoneName(@PathVariable String phoneName) {
        return this.userService.findUserByPhoneName(phoneName);
    }
}
