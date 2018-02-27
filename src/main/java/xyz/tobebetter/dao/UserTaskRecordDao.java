/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xyz.tobebetter.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import xyz.tobebetter.entity.Page;
import xyz.tobebetter.entity.UserTaskRecord;

/**
 *
 * @author zhuqing
 */
public interface UserTaskRecordDao<T extends UserTaskRecord> extends BaseDao<T> {

    public List<T> findByUserId(@Param("userId") String userId,@Param("page") Page page) throws Exception;

    public List<T> findByUserTaskId(@Param("userTaskId") String userTaskId,@Param("page") Page page)  throws Exception;
}
