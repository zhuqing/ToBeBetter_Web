package xyz.tobebetter.service.todo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.tobebetter.dao.todo.UserTodoDao;

/**
 * Created by zhuleqi on 2018/12/14.
 */
@Service
public class UserTodoServiceImpl implements UserTodoServiceI {
    @Autowired
    private UserTodoDao userTodoDao;
    @Override
    public UserTodoDao getBaseDao() {
        return this.userTodoDao;
    }
}
