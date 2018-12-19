/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xyz.tobebetter.dao.todo;


import xyz.tobebetter.dao.BaseDao;
import xyz.tobebetter.entity.todo.TodoItem;
import xyz.tobebetter.entity.todo.UserTodo;

import java.util.List;

/**
 *
 * @author zhuleqi
 */
public interface TodoItemDao extends BaseDao<TodoItem>{

    public List<TodoItem> findByUserIdAndExcuteDate(UserTodo userTodo);
}
