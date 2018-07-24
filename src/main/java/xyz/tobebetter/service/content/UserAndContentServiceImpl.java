package xyz.tobebetter.service.content;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.tobebetter.dao.content.UserAndContentDao;
import xyz.tobebetter.entity.Message;
import xyz.tobebetter.entity.user.content.UserAndContent;

/**
 * Created by zhuleqi on 2018/7/22.
 */
@Service
public class UserAndContentServiceImpl implements UserAndContentServiceI<UserAndContent,UserAndContentDao<UserAndContent>> {
   @Autowired
   public UserAndContentDao<UserAndContent> userAndContentDao;
    @Override
    public UserAndContentDao<UserAndContent> getBaseDao() {
        return this.userAndContentDao;
    }

    @Override
    public Message findByUserId(String userId) {
        UserAndContent userAndContent = new UserAndContent();
        userAndContent.setUserId(userId);
        return this.find(userAndContent);
    }

   
}
