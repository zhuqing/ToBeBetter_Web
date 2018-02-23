//package com.leqienglish.controller;
//
//
//
//import com.leqienglish.service.UserServiceI;
//import xyz.tobebetter.util.MessageUtil;
//import com.leqigame.entity.Message;
//import com.leqigame.entity.User;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//import java.util.Objects;
//
//
///**
// * Created by zhuqing on 2017/7/21.
// */
//@Controller
//@RequestMapping("/user")
//public class UserController {
//
//    @Autowired
//    private UserServiceI userServiceI;
//
//    @RequestMapping(value="/addUser",method=RequestMethod.POST)
//    public  @ResponseBody User addUser(@RequestParam("name") String name,@RequestParam("email") String email,@RequestParam("password") String password){
//        User user = new User();
//        user.setEmail(email);
//        user.setName(name);
//        user.setPassword(password);
//        user.setUpdateDate(System.currentTimeMillis());
//        user.setCreateDate(System.currentTimeMillis());
//        userServiceI.addUser(user);
//        return user;
//    }
//
//    @RequestMapping(value = "/findUserById/{id}", method = RequestMethod.GET)
//    public  @ResponseBody  User findUserById(@PathVariable Long id) {
//        return userServiceI.findUser(id);
//    }
//
//    @RequestMapping(value = "update/{id}/{name}",method = RequestMethod.PUT)
//    public @ResponseBody User updateUserName(@PathVariable Long id,@PathVariable String name){
//        return userServiceI.updateUserName(id,name);
//    }
//
//    @RequestMapping(value = "get",method = RequestMethod.GET)
//    public @ResponseBody List<User> get(){
//        return userServiceI.get();
//    }
//
//    @RequestMapping(value = "get/{page}/{pageSize}")
//    public @ResponseBody List<User> get(@PathVariable  Integer page,@PathVariable Integer pageSize){
//        return userServiceI.get(page,pageSize);
//    }
//
//    @RequestMapping(value = "hasUser")
//    public @ResponseBody Message hasUser(@RequestParam("userName") String userName){
//        User user = this.userServiceI.findUserByName(userName);
//        Message message = new Message();
//        if(user == null){
//             message.setMsg("ok");
//        }else{
//            message.setMsg("error");
//        }
//
//        return message;
//    }
//
//    @RequestMapping("count")
//    public @ResponseBody Long getCount(){
//        return userServiceI.getCount();
//    }
//
//    @RequestMapping("findUser/{value}")
//    public @ResponseBody User findUser(@PathVariable String value){
//        return userServiceI.findUser(value);
//    }
//    @RequestMapping("login")
//    public @ResponseBody Message<User> login(@RequestParam("value") String value,@RequestParam("password") String password){
//
//        User user = null;
//        if(value.contains("@")){
//            user = this.userServiceI.findUserByEmail(value);
//        }else{
//            user = this.userServiceI.findUserByName(value);
//        }
//
//        if(user == null){
//            return MessageUtil.createMessage("0","没找到用户",user);
//        }
//
//        if(Objects.equals(password,user.getPassword())){
//
//            return MessageUtil.createMessage("1","登录成功",user);
//        }
//
//        return MessageUtil.createMessage("0","登录失败",new User());
//    }
//}
