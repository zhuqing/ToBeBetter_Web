/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xyz.tobebetter.service.english;

import xyz.tobebetter.dao.ContentDao;
import xyz.tobebetter.entity.Message;
import xyz.tobebetter.entity.english.Content;
import xyz.tobebetter.service.BaseServiceI;

/**
 *
 * @author zhuqing
 * @param <T>
 */
public interface ContentServiceI<T extends Content, D extends ContentDao<T>> extends BaseServiceI<T, D> {

    public Message findLastOne();

    public Message findNews(String update);

    public Message updateToLunch(String id);

    public String findImagePath(String id);

    public String findAudioPath(String id);

    /**
     * 提交图片文件
     *
     * @param contentId
     * @param imagePath
     * @return
     */
    public Message updateImagePath(String contentId, String imagePath);

    /**
     * 提交音频文件
     *
     * @param contentId
     * @param imagePath
     * @return
     */
    public Message updateAudioPath(String contentId, String imagePath);
}
