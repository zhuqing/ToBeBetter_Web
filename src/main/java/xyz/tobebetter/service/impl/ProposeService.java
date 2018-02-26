package xyz.tobebetter.service.impl;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.tobebetter.dao.ProposeDao;
import xyz.tobebetter.entity.Message;
import xyz.tobebetter.entity.Propose;
import xyz.tobebetter.service.ProposeServiceI;
import xyz.tobebetter.util.EntityUtil;
import xyz.tobebetter.util.MessageUtil;

import java.util.List;

/**
 * Created by zhuleqi on 2018/2/23.
 */
@Service
public class ProposeService implements ProposeServiceI {
    @Autowired
    private ProposeDao proposeDao;
    public Message create(String connect, String message) {
        Propose propose = EntityUtil.initEnity(new Propose());
        propose.setConnect(connect);
        propose.setMessage(message);
        try {
            proposeDao.create(propose);
            return MessageUtil.createMessage(Message.SUCCESS,"ok",null);
        }catch (Exception ex){
            ex.printStackTrace();

        }
        return MessageUtil.createMessage(Message.ERROR,"error",null);


    }

    public Message delete(String id) {
       proposeDao.delete(id);
        return MessageUtil.createMessage(Message.SUCCESS,"ok",null);


    }

    public Message findAll() {
        List<Propose> proposeList = proposeDao.findAll();
        return MessageUtil.createMessage(Message.SUCCESS,"ok",proposeList);
    }

}
