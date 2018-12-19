package xyz.tobebetter.service.todo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.tobebetter.dao.todo.TodoItemDao;
import xyz.tobebetter.entity.Message;
import xyz.tobebetter.entity.todo.TodoItem;
import xyz.tobebetter.entity.todo.UserTodo;

/**
 * Created by zhuleqi on 2018/12/14.
 */
@Service
public class TodoItemServiceImpl implements TodoItemServiceI {

    @Autowired
    private TodoItemDao todoItemDao;
    @Override
    public TodoItemDao getBaseDao() {
        return this.todoItemDao;
    }

    @Override
    public Message findByUserId(String userId) {

        return this.toMessage(()->{
            TodoItem todoItem = new TodoItem();
            todoItem.setUserId(userId);
            return todoItemDao.findByEntity(todoItem);

        });
    }

    @Override
    public Message findByUserIdAndExcuteDate(String userId, Long excuteDate) {
        return this.toMessage(()->{
             UserTodo userTodo = new UserTodo();
            userTodo.setUserId(userId);
            userTodo.setExcuteDate(excuteDate);
            return todoItemDao.findByUserIdAndExcuteDate(userTodo);

        });
    }
}
