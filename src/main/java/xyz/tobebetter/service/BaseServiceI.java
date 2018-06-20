/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xyz.tobebetter.service;

import com.github.pagehelper.PageHelper;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import xyz.tobebetter.dao.BaseDao;
import xyz.tobebetter.entity.Entity;
import xyz.tobebetter.entity.Message;
import xyz.tobebetter.entity.Page;
import xyz.tobebetter.service.english.ContentServiceImpl;
import xyz.tobebetter.service.user.impl.UserService;
import xyz.tobebetter.util.EntityUtil;
import xyz.tobebetter.util.MessageUtil;
import xyz.tobebetter.util.data.MessageData;
import xyz.tobebetter.util.data.StatusData;

/**
 *
 * @author zhuqing
 */
public interface BaseServiceI<T extends Entity, D extends BaseDao<T>> {

    public D getBaseDao();

    /**
     * 根据实体查找
     *
     * @param t
     * @param page
     * @param pageSize
     * @return
     */
    public default Message find(T t, int page, int pageSize) {
        com.github.pagehelper.Page p = PageHelper.startPage(page, pageSize, true);
        try {
            List<T> ts = this.getBaseDao().findByEntity(t);
            return this.toMessage(ts, page, p.getPages());
        } catch (Exception ex) {
            Logger.getLogger(ContentServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            return MessageUtil.createErrorMessage(ex.getMessage(), null);
        }
    }

    public default Message find(T t) {
        try {
            List<T> ts = this.getBaseDao().findByEntity(t);
            return this.toMessage(ts);
        } catch (Exception ex) {
            Logger.getLogger(ContentServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            return MessageUtil.createErrorMessage(ex.getMessage(), null);
        }
    }

    public default Message getCount() {
        Long count = null;
        try {
            count = this.getBaseDao().getCount();
        } catch (Exception ex) {
            Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
            return MessageUtil.createErrorMessage(ex.getMessage(), null);
        }
        return MessageUtil.createSuccessMessage(count);
    }

    public default Message create(T t) {
        try {
            EntityUtil.initEnity(t);
            if (this.findById(t.getId()) != null) {
                EntityUtil.initEnity(t);
            }
            this.getBaseDao().create(t);
        } catch (Exception ex) {
            Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
            return MessageUtil.createErrorMessage(ex.getMessage(), null);
        }

        return this.toMessage(t);
    }

    public default Message delete(String id) {
        T user = null;
        try {
            user = this.getBaseDao().findById(id);
            if (user == null) {
                return MessageUtil.createErrorMessage(MessageData.NOT_FIND_ENTITY + ":" + id, null);
            }
            user.setStatus(StatusData.DELETE);
            this.getBaseDao().update(user);

        } catch (Exception ex) {
            Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
            return MessageUtil.createErrorMessage(ex.getMessage(), null);
        }

        return this.toMessage(user);
    }

    public default Message findAll() {
        List<T> ts = null;
        try {
            ts = this.getBaseDao().findAll();
        } catch (Exception ex) {
            Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
            MessageUtil.createErrorMessage(ex.getMessage(), null);
        }

        return this.toMessage(ts);
    }

    public default Message findById(String id) {
        T t = null;
        try {
            t = this.getBaseDao().findById(id);
        } catch (Exception ex) {
            Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
            MessageUtil.createErrorMessage(ex.getMessage(), null);
        }

        return this.toMessage(t);
    }

    public default Message find(Page page) {
        List<T> ts = null;
        try {
            ts = this.getBaseDao().find(page);
        } catch (Exception ex) {
            Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
            MessageUtil.createErrorMessage(ex.getMessage(), null);
        }

        return this.toMessage(ts);
    }

    public default Message update(T t) {
        try {
            this.getBaseDao().update(t);
        } catch (Exception ex) {
            Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
            MessageUtil.createErrorMessage(ex.getMessage(), null);
        }
        return this.toMessage(t);
    }

    public default Message toMessage(List<T> utrs) {
        if (utrs != null) {
            return MessageUtil.createMessage("ok", utrs.toArray());
        }
        return MessageUtil.createErrorMessage(null);
    }

    public default Message toMessage(List<T> utrs, int page, int totalPage) {
        if (utrs != null) {
            return MessageUtil.createMessage("ok", utrs.toArray(), page, totalPage);
        }
        return MessageUtil.createErrorMessage(null);
    }

    public default Message toMessage(T t) {
        if (t != null) {
            return MessageUtil.createMessage("ok", t);
        }
        return MessageUtil.createErrorMessage(null);
    }
}
