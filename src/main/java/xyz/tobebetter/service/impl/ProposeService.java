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
import java.util.logging.Level;
import java.util.logging.Logger;
import xyz.tobebetter.entity.Page;

/**
 * Propse Created by zhuleqi on 2018/2/23.
 */
@Service
public class ProposeService<T extends Propose> implements ProposeServiceI<T> {

    @Autowired
    private ProposeDao<T> proposeDao;

    @Override
    public Message<T> create(T t) {
        t = EntityUtil.initEnity(t);

        try {
            proposeDao.create(t);

        } catch (Exception ex) {
            ex.printStackTrace();
            return MessageUtil.createErrorMessage(ex.getMessage(), t);

        }
        return MessageUtil.createMessage(Message.SUCCESS, "ok", t);
    }

    @Override
    public Message<T> delete(String id) {
        T t = null;
        try {
            t = this.proposeDao.findById(id);
            if (t == null) {
                return MessageUtil.createErrorMessage("没有找到要删除的数据", id);
            }
            proposeDao.delete(id);
        } catch (Exception ex) {
            Logger.getLogger(ProposeService.class.getName()).log(Level.SEVERE, null, ex);
            return MessageUtil.createErrorMessage(ex.getMessage(), id);
        }
        return this.toMessage(t);

    }

    @Override
    public Message<T[]> findAll() {
        List<T> proposeList = null;
        try {
            proposeList = proposeDao.findAll();
        } catch (Exception ex) {
            Logger.getLogger(ProposeService.class.getName()).log(Level.SEVERE, null, ex);
            return MessageUtil.createErrorMessage(ex.getMessage(), null);
        }
        return this.toMessage(proposeList);
    }

    @Override
    public Message<T> findById(String id) {
        T t = null;
        try {
            t = this.proposeDao.findById(id);
        } catch (Exception ex) {
            Logger.getLogger(ProposeService.class.getName()).log(Level.SEVERE, null, ex);
            return MessageUtil.createErrorMessage(ex.getMessage(), null);
        }

        return this.toMessage(t);
    }

    @Override
    public Message<T[]> find(Page page) {
        List<T> proposeList = null;
        try {
            proposeList = proposeDao.find(page);
        } catch (Exception ex) {
            Logger.getLogger(ProposeService.class.getName()).log(Level.SEVERE, null, ex);
            return MessageUtil.createErrorMessage(ex.getMessage(), null);
        }
        return this.toMessage(proposeList);
    }

}
