/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xyz.tobebetter.service.usertask;

import xyz.tobebetter.dao.UserTaskDao;
import xyz.tobebetter.entity.UserTask;
import xyz.tobebetter.service.BaseServiceI;

/**
 *
 * @author zhuqing
 */
public interface UserTaskServiceI<T extends UserTask,D extends UserTaskDao<T>> extends BaseServiceI<T,D> {


}
