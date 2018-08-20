/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xyz.tobebetter.service.english.userword;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.tobebetter.dao.content.WordAndContentDao;
import xyz.tobebetter.dao.english.UserAndWordDao;
import xyz.tobebetter.entity.Message;
import xyz.tobebetter.entity.content.WordAndContent;
import xyz.tobebetter.entity.user.word.UserAndWord;
import xyz.tobebetter.service.english.word.WordAndContentServiceI;
import xyz.tobebetter.service.user.UserServiceImpl;
import xyz.tobebetter.util.MessageUtil;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author zhuleqi
 */
@Service
public class UserAndWordServiceImpl<T extends UserAndWord, D extends UserAndWordDao<T>> implements  UserAndWordServiceI<T,D>{

    @Autowired
    private UserAndWordDao<T> userAndWordDao;
    @Override
    public D getBaseDao() {
        return (D) userAndWordDao;
    }

}
