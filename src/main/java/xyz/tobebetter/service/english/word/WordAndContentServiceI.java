/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xyz.tobebetter.service.english.word;

import org.springframework.stereotype.Service;
import xyz.tobebetter.dao.content.WordAndContentDao;

import xyz.tobebetter.entity.Message;
import xyz.tobebetter.entity.content.WordAndContent;

import xyz.tobebetter.service.BaseServiceI;

/**
 *
 * @author zhuleqi
 */

public interface WordAndContentServiceI<T extends WordAndContent, D extends WordAndContentDao<T>> extends BaseServiceI<T, D> {

    public Message deleteByWordIdAndContentId(String wordId,String contentId);
}
