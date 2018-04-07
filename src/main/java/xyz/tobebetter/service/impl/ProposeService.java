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
public class ProposeService<T extends Propose,D extends ProposeDao<T>> implements ProposeServiceI<T,D> {

    @Autowired
    private ProposeDao<T> proposeDao;

    @Override
    public D getBaseDao() {
       return (D) proposeDao;
    }


}
