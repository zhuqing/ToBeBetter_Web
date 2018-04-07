/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xyz.tobebetter.controller.usertask;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import xyz.tobebetter.dao.UserTaskDao;
import xyz.tobebetter.entity.Message;
import xyz.tobebetter.entity.Propose;
import xyz.tobebetter.entity.User;
import xyz.tobebetter.entity.UserTask;
import xyz.tobebetter.service.usertask.UserTaskServiceI;


/**
 *
 * @author zhuqing
 */
@Controller
@RequestMapping("/userTask")
public class UserTaskController {

    @Autowired
    private UserTaskServiceI<UserTask,UserTaskDao<UserTask>> userTaskService;

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public @ResponseBody
    Message create(@RequestBody UserTask userTask)  {
        return this.userTaskService.create(userTask);

    }

    @RequestMapping(value = "/findById/{id}", method = RequestMethod.GET)
    public @ResponseBody
    Message create(@PathVariable String userTaskId) {
        return this.userTaskService.findById(userTaskId);
    }

}
