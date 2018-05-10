/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xyz.tobebetter.entity.english;

import xyz.tobebetter.entity.Entity;

/**
 * 用户订阅分类的关系实体
 *
 * @author zhuqing
 */
public class UserAndBook extends Entity {

    /**
     * 正在背诵
     */
    public final static Integer RECITING_STATUS = 1;

    /**
     * 背诵完成
     */
    public final static Integer OVER_STATUS = 10;
            
    private String userId;
    private String bookId;
}
