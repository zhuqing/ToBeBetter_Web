package xyz.tobebetter.service.content;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.tobebetter.dao.content.ReciteContentVODao;
import xyz.tobebetter.entity.Message;
import xyz.tobebetter.entity.english.content.ReciteContentVO;
import xyz.tobebetter.entity.user.content.UserAndContent;
import xyz.tobebetter.util.MessageUtil;

import java.util.List;

/**
 * Created by zhuleqi on 2018/7/24.
 */
@Service
public class ReciteContentVOServiceImpl implements ReciteContentVOServiceI {
    @Autowired
    private ReciteContentVODao<ReciteContentVO> reciteContentVODao;

    @Override
    public ReciteContentVODao<ReciteContentVO> getBaseDao() {
        return this.reciteContentVODao;
    }

    @Override
    public Message findUserReciting(String userId) {
        UserAndContent userAndContent = new UserAndContent();
        userAndContent.setUserId(userId);
        userAndContent.setFinishedPercent(100);
        try {
            List<ReciteContentVO> contents = this.getBaseDao().findUserReciting(userAndContent);
            return this.toMessage(contents);
        } catch (Exception e) {
            e.printStackTrace();
            return MessageUtil.createErrorMessage(e.getMessage());
        }

    }

    @Override
    public Message findUserRecited(String userId) {
        UserAndContent userAndContent = new UserAndContent();
        userAndContent.setUserId(userId);
        userAndContent.setFinishedPercent(100);
        try {
            List<ReciteContentVO> contents = this.getBaseDao().findUserRecited(userAndContent);
            return this.toMessage(contents);
        } catch (Exception e) {
            e.printStackTrace();
            return MessageUtil.createErrorMessage(e.getMessage());
        }
    }
}
