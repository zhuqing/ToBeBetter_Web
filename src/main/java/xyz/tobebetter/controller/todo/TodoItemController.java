package xyz.tobebetter.controller.todo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import xyz.tobebetter.entity.Message;
import xyz.tobebetter.entity.english.sentence.SentenceAndWord;
import xyz.tobebetter.entity.todo.TodoItem;
import xyz.tobebetter.service.english.sentence.SentenceAndWordServiceI;
import xyz.tobebetter.service.todo.TodoItemServiceI;

/**
 * Created by zhuleqi on 2018/12/14.
 */
@Controller
@RequestMapping("/todoItem")
public class TodoItemController {
    @Autowired
    private TodoItemServiceI todoItemServiceI;
      /*
     * 根据文件路径下载文件
     * @param path
     * @param request
     * @param response
     * @throws Exception
     */

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public @ResponseBody
    Message create(@RequestBody TodoItem todoItem) {
        return this.todoItemServiceI.create(todoItem);
    }


    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public @ResponseBody Message delete(@RequestParam String  id) {
        return this.todoItemServiceI.delete(id);
    }

    @RequestMapping(value = "/findByUserIdAndExcuteDate", method = RequestMethod.GET)
    public @ResponseBody Message findByUserIdAndExcuteDate(@RequestParam String  userId,@RequestParam Long excuteDate) {
        return this.todoItemServiceI.findByUserIdAndExcuteDate(userId,excuteDate);
    }


}
