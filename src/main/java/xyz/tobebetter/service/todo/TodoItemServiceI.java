package xyz.tobebetter.service.todo;



import xyz.tobebetter.dao.todo.TodoItemDao;
import xyz.tobebetter.entity.Message;
import xyz.tobebetter.entity.todo.TodoItem;
import xyz.tobebetter.service.BaseServiceI;

/**
 * Created by zhuleqi on 2018/12/14.
 */
public interface TodoItemServiceI extends BaseServiceI<TodoItem,TodoItemDao>{

    public Message findByUserId(String userId);

    public Message findByUserIdAndExcuteDate(String userId , Long excuteDate);
}
