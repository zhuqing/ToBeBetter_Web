/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xyz.tobebetter.service.english.userword;

import xyz.tobebetter.dao.english.UserAndWordDao;

import xyz.tobebetter.entity.user.word.UserAndWord;

import xyz.tobebetter.service.BaseServiceI;

/**
 *
 * @author zhuleqi
 */

public interface UserAndWordServiceI<T extends UserAndWord, D extends UserAndWordDao<T>> extends BaseServiceI<T, D> {

}
