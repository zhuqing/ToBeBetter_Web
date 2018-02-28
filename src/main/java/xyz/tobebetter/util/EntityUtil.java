package xyz.tobebetter.util;

import xyz.tobebetter.entity.Entity;

import java.util.UUID;

/**
 * Created by zhuqing on 2017/10/15.
 */
public class EntityUtil {

    public static <T extends Entity> T initEnity(T entity) {
        entity.setCreateDate(System.currentTimeMillis());
        if(entity.getStatus()==null){
             entity.setStatus(0);
        }
      
        entity.setId(createEntityId());
        reSetUpdateDate(entity);
        return entity;
    }

    public static <T extends Entity> void reSetUpdateDate(T entity) {
        entity.setUpdateDate(System.currentTimeMillis());
    }

    public static String createEntityId() {
        return UUID.randomUUID().toString() + "-" + System.currentTimeMillis();
    }

}
