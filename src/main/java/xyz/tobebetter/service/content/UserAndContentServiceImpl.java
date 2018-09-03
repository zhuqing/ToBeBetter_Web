package xyz.tobebetter.service.content;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.tobebetter.dao.content.UserAndContentDao;
import xyz.tobebetter.entity.Consistent;
import xyz.tobebetter.entity.Message;
import xyz.tobebetter.entity.user.content.UserAndContent;
import xyz.tobebetter.util.MessageUtil;

import java.util.List;

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
        userAndContent.setStatus(Consistent.SUCCESS);
        return this.find(userAndContent);
    }

    @Override
    public Message remove(String userId, String contentId) {
        UserAndContent userAndContent = new UserAndContent();
        userAndContent.setUserId(userId);
        userAndContent.setContentId(contentId);
        try {
            List<UserAndContent> userAndContentList = this.getBaseDao().findByEntity(userAndContent);
            if(userAndContentList == null || userAndContentList.isEmpty()){
                return MessageUtil.createErrorMessage("没找到数据");
            }

            userAndContent = userAndContentList.get(0);

            userAndContent.setStatus(Consistent.DELETE);
            this.getBaseDao().updateStatusById(userAndContent);
            return MessageUtil.createSuccessMessage();
        } catch (Exception e) {
            e.printStackTrace();
            return MessageUtil.createErrorMessage(e.getMessage());
        }

    }

    @Override
    public Message updatePrecent(String userId, String contentId, Integer precent) {
        UserAndContent userAndContent = new UserAndContent();
        userAndContent.setContentId(contentId);
        userAndContent.setUserId(userId);

        try {
            List<UserAndContent> userAndContentList = this.getBaseDao().findByEntity(userAndContent);

            if(userAndContentList == null|| userAndContentList.isEmpty()){
                return MessageUtil.createErrorMessage("没有数据");
            }

            userAndContent = userAndContentList.get(0);
            userAndContent.setFinishedPercent(precent);
            this.getBaseDao().update(userAndContent);
            return MessageUtil.createSuccessMessage(userAndContent);
        } catch (Exception e) {
            e.printStackTrace();
            return MessageUtil.createErrorMessage(e.getMessage());
        }

    }


}
