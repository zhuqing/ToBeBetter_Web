/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xyz.tobebetter.service.usertaskrecord;

import org.springframework.stereotype.Service;
import xyz.tobebetter.dao.UserTaskDao;
import xyz.tobebetter.dao.UserTaskRecordDao;
import xyz.tobebetter.entity.Message;
import xyz.tobebetter.entity.Page;
import xyz.tobebetter.entity.UserTaskRecord;
import xyz.tobebetter.service.BaseServiceI;

/**
 *
 * @author zhuqing
 */
@Service
public interface UserTaskRecordServiceI<T extends UserTaskRecord,D extends UserTaskRecordDao<T>> extends BaseServiceI<T,D> {
    
    public Message findByUserId(String userId,Page page);

    public Message findByUserTaskId(String userTaskId, Page page);
}