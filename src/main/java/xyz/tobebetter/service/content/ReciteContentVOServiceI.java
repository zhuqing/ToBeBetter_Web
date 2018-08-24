package xyz.tobebetter.service.content;


import xyz.tobebetter.dao.content.ReciteContentVODao;
import xyz.tobebetter.entity.Message;
import xyz.tobebetter.entity.english.content.ReciteContentVO;
import xyz.tobebetter.service.BaseServiceI;

/**
 * Created by zhuleqi on 2018/7/24.
 */
public interface ReciteContentVOServiceI extends BaseServiceI<ReciteContentVO,ReciteContentVODao<ReciteContentVO>> {
    /**
     *  找到用户正在背诵的Contents
     * @param userId
     * @return
     */
    public Message findUserReciting(String userId);

    /**
     *  找到用户正在背诵的Contents
     * @param userId
     * @return
     */
    public Message findUserReciting(String userId, String contentId);


    /**
     *  找到用户正在背诵的Contents
     * @param userId
     * @return
     */
    public Message findUserRecited(String userId);


    /**
     *  找到用户正在背诵的Contents
     * @param userId
     * @return
     */
    public Message findUserRecited(String userId, String contentId);

}
