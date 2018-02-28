package xyz.tobebetter.dao;

import xyz.tobebetter.entity.User;

/**
 * Created by zhuqing on 2017/7/21.
 */
public interface UserDao<T extends User> extends BaseDao<T> {

    public T findUserByOtherSysId(String otherSysId) throws Exception;

    public T findUserByEmail(String email) throws Exception;

    public T findUserByName(String name) throws Exception;
    
    public T findUserByPhoneName(String phoneName) throws Exception;
}
