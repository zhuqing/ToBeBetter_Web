/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xyz.tobebetter.service.english.recitewordconfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.tobebetter.dao.english.ReciteWordConfigDao;
import xyz.tobebetter.entity.Message;
import xyz.tobebetter.entity.word.ReciteWordConfig;
import xyz.tobebetter.util.MessageUtil;

import java.util.List;

/**
 *
 * @author zhuleqi
 */
@Service
public class ReciteWordConfigServiceImpl implements ReciteWordConfigServiceI{

    @Autowired
    private ReciteWordConfigDao<ReciteWordConfig> reciteWordConfigDao;
    
    @Override
    public ReciteWordConfigDao<ReciteWordConfig> getBaseDao() {
        return reciteWordConfigDao;
    }

    /**
     * 根据用户ID查找用户背诵单词的配置，如果没有就新创建
     * @param userId
     * @return
     */
    @Override
    public Message findByUserId(String userId) {

        try {
            ReciteWordConfig reciteWordConfig = this.queryByUserId(userId);

            if(reciteWordConfig  == null){
                reciteWordConfig = new ReciteWordConfig();
                reciteWordConfig.setUserId(userId);
                reciteWordConfig.setReciteNumberPerDay(10);
                reciteWordConfig.setMyWordsNumber(0);
                reciteWordConfig.setHasReciteNumber(0);
                reciteWordConfig = this.insert(reciteWordConfig);
            }
            return this.toMessage(reciteWordConfig);

        } catch (Exception e) {
            e.printStackTrace();
            return MessageUtil.createErrorMessage(e.getMessage());
        }
    }

    private ReciteWordConfig queryByUserId(String userId) throws Exception {
        ReciteWordConfig reciteWordConfig = new ReciteWordConfig();
        reciteWordConfig.setReciteNumberPerDay(null);
        reciteWordConfig.setUserId(userId);


            List<ReciteWordConfig> reciteWordConfigList = this.reciteWordConfigDao.findByEntity(reciteWordConfig);
            if(reciteWordConfigList == null || reciteWordConfigList.isEmpty()){
                return null;
            }else{
                return reciteWordConfigList.get(0);
            }



    }

    @Override
    public Message updateReciteNumberPerDay(String userId, Integer number) {
        try {
            ReciteWordConfig reciteWordConfig = this.queryByUserId(userId);
            if(reciteWordConfig == null){
                return MessageUtil.createErrorMessage("没有找到ReciteWordConfig:userId="+userId);
            }

            reciteWordConfig.setReciteNumberPerDay(number);
            this.getBaseDao().update(reciteWordConfig);
            return MessageUtil.createSuccessMessage();
        } catch (Exception e) {
            e.printStackTrace();
            return MessageUtil.createErrorMessage(e.getMessage());
        }
    }

    @Override
    public Message updateMyWordsNumber(String userId, Integer number) {
        try {
            ReciteWordConfig reciteWordConfig = this.queryByUserId(userId);
            if(reciteWordConfig == null){
                return MessageUtil.createErrorMessage("没有找到ReciteWordConfig:userId="+userId);
            }

            reciteWordConfig.setMyWordsNumber(number);
            this.getBaseDao().update(reciteWordConfig);
            return MessageUtil.createSuccessMessage();
        } catch (Exception e) {
            e.printStackTrace();
            return MessageUtil.createErrorMessage(e.getMessage());
        }
    }

    @Override
    public Message updateHasReciteNumber(String userId, Integer number) {
        try {
            ReciteWordConfig reciteWordConfig = this.queryByUserId(userId);
            if(reciteWordConfig == null){
                return MessageUtil.createErrorMessage("没有找到ReciteWordConfig:userId="+userId);
            }

            reciteWordConfig.setHasReciteNumber(number);
            this.getBaseDao().update(reciteWordConfig);
            return MessageUtil.createSuccessMessage();
        } catch (Exception e) {
            e.printStackTrace();
            return MessageUtil.createErrorMessage(e.getMessage());
        }
    }

}
