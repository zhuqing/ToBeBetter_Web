/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xyz.tobebetter.controller.usertaskrecord;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import xyz.tobebetter.dao.UserTaskRecordDao;
import xyz.tobebetter.entity.Message;
import xyz.tobebetter.entity.Page;
import xyz.tobebetter.entity.UserTask;
import xyz.tobebetter.entity.UserTaskRecord;
import xyz.tobebetter.service.usertask.UserTaskServiceI;
import xyz.tobebetter.service.usertaskrecord.UserTaskRecordServiceI;
import xyz.tobebetter.util.MessageUtil;

/**
 *
 * @author zhuqing
 */
@Controller
@RequestMapping("/userTaskRecord")
public class UserTaskRecordController {

    @Autowired
    private UserTaskRecordServiceI<UserTaskRecord,UserTaskRecordDao<UserTaskRecord>> userTaskRecordService;

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public @ResponseBody
    Message create(@RequestBody UserTaskRecord userTask) {
        return this.userTaskRecordService.create(userTask);
    }

    @RequestMapping(value = "/findById/{id}", method = RequestMethod.GET)
    public @ResponseBody
    Message create(@PathVariable String id) {
        return this.userTaskRecordService.findById(id);
    }

    @RequestMapping(value = "/findByUserId/{userId}/{page}/{pageSize}", method = RequestMethod.GET)
    public @ResponseBody
    Message findByUserId(@PathVariable String userId, @PathVariable int page, @PathVariable int pageSize) {
        Page p = new Page(page, pageSize);
        return this.userTaskRecordService.findByUserId(userId, p);
    }

    @RequestMapping(value = "/findByUserTaskId/{userTaskId}/{page}/{pageSize}", method = RequestMethod.GET)
    public @ResponseBody
    Message findByUserTaskId(@PathVariable String userTaskId, @PathVariable int page, @PathVariable int pageSize) {
        Page p = new Page(page, pageSize);
        return this.userTaskRecordService.findByUserTaskId(userTaskId, p);
    }
}
