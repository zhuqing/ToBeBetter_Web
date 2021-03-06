package xyz.tobebetter.controller.user;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
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


    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public @ResponseBody
    Message delete(@RequestParam  String id, String password) {

        return this.userService.delete(id);
    }

    @RequestMapping(value = "/regist", method = RequestMethod.POST)
    public @ResponseBody
    Message regist(@RequestBody User user) {

        return this.userService.regist(user);
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public @ResponseBody
    Message login(@RequestParam String userName, @RequestParam String password) {
        return this.userService.login(userName,password);
    }



    @RequestMapping(value = "/findUserByOtherSysId", method = RequestMethod.GET)
    public @ResponseBody
    Message findUserByOtherSysId(@RequestParam String otherSysId) {
        return this.userService.findUserByOtherSysId(otherSysId);
    }



    @RequestMapping(value = "/findByUserName", method = RequestMethod.GET)
    public @ResponseBody
    Message findByUserNamee(@RequestParam String userName, @RequestParam String password,@RequestParam(required = false)Integer page, @RequestParam(required = false)Integer pageSize) {
        return this.userService.findByUserName(userName,page,pageSize);
    }


    @RequestMapping(value = "/findUserByType", method = RequestMethod.GET)
    public @ResponseBody
    Message findUserByType(@RequestParam Integer type,@RequestParam(required = false)Integer page,@RequestParam(required = false)Integer pageSize) {
        return this.userService.findUserByType(type, page, pageSize);
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

    @RequestMapping(value = "/findById", method = RequestMethod.GET)
    public @ResponseBody
    Message findById(@RequestParam String id) {
        return this.userService.findById(id);
    }
}
