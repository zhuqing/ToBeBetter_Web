package xyz.tobebetter.controller.todo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import xyz.tobebetter.entity.Message;
import xyz.tobebetter.entity.todo.TodoItem;
import xyz.tobebetter.entity.todo.UserTodo;
import xyz.tobebetter.service.todo.TodoItemServiceI;
import xyz.tobebetter.service.todo.UserTodoServiceI;

/**
 * Created by zhuleqi on 2018/12/14.
 */
@Controller
@RequestMapping("/userTodo")
public class UserTodoController {
    @Autowired
    private UserTodoServiceI userTodoServiceI;
      /*
     * 根据文件路径下载文件
     * @param path
     * @param request
     * @param response
     * @throws Exception
     */

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public @ResponseBody
    Message create(@RequestBody UserTodo userTodo) {
        return this.userTodoServiceI.create(userTodo);
    }


    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public @ResponseBody Message delete(@RequestParam String  id) {
        return this.userTodoServiceI.delete(id);
    }


}
