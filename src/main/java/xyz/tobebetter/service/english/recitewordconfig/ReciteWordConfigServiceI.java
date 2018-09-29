/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xyz.tobebetter.service.english.recitewordconfig;


import xyz.tobebetter.dao.english.ReciteWordConfigDao;
import xyz.tobebetter.entity.Message;
import xyz.tobebetter.entity.word.ReciteWordConfig;
import xyz.tobebetter.service.BaseServiceI;

/**
 *
 * @author zhuleqi
 */
public interface ReciteWordConfigServiceI extends BaseServiceI<ReciteWordConfig, ReciteWordConfigDao<ReciteWordConfig>>{
    public Message findByUserId(String userId);

    public Message updateReciteNumberPerDay(String userId , Integer number);

    public Message updateMyWordsNumber(String userId , Integer number);

    public Message updateHasReciteNumber(String userId , Integer number);

}
