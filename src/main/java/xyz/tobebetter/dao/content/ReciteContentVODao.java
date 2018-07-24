package xyz.tobebetter.dao.content;

import xyz.tobebetter.dao.BaseDao;
import xyz.tobebetter.entity.english.content.ReciteContentVO;
import xyz.tobebetter.entity.user.content.UserAndContent;

import java.util.List;

/**
 * Created by zhuleqi on 2018/7/24.
 */
public interface ReciteContentVODao< T extends ReciteContentVO>  extends BaseDao<T> {
    /**
     *  找到用户正在背诵的Contents
     * @return
     */
    public List<ReciteContentVO> findUserReciting(UserAndContent userAndContent) throws Exception;


    /**
     *  找到用户正在背诵的Contents
     * @return
     */
    public List<ReciteContentVO> findUserRecited(UserAndContent userAndContent) throws Exception;
}
