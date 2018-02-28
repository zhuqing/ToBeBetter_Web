package xyz.tobebetter.controller.user;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import xyz.tobebetter.entity.Message;
import xyz.tobebetter.entity.User;

/**
 * Created by zhuleqi on 2018/2/23.
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @RequestMapping(value="/createUser",method= RequestMethod.POST)
    public  @ResponseBody Message createUser(@RequestBody User user){

        return null;
    }
}
