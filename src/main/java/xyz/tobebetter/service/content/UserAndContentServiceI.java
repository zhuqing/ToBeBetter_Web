package xyz.tobebetter.service.content;

import xyz.tobebetter.dao.content.UserAndContentDao;
import xyz.tobebetter.entity.user.content.UserAndContent;
import xyz.tobebetter.service.BaseServiceI;

/**
 * Created by zhuleqi on 2018/7/22.
 */
public interface UserAndContentServiceI<T extends UserAndContent,D extends UserAndContentDao<UserAndContent>> extends BaseServiceI<T,D>{

}
