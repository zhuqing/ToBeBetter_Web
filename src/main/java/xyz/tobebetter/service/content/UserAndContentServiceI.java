package xyz.tobebetter.service.content;


import org.springframework.web.bind.annotation.RequestParam;
import xyz.tobebetter.dao.content.UserAndContentDao;
import xyz.tobebetter.entity.Message;
import xyz.tobebetter.entity.user.content.UserAndContent;
import xyz.tobebetter.service.BaseServiceI;

/**
 * Created by zhuleqi on 2018/7/22.
 */
public interface UserAndContentServiceI<T extends UserAndContent,D extends UserAndContentDao<T>> extends BaseServiceI<T,D>{
    public Message findByUserId(String userId);

    public Message remove(String userId,String contentId);

    public Message updatePrecent( String userId,  String contentId , Integer precent);

}
