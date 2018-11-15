/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xyz.tobebetter.service.english.shortword;



import xyz.tobebetter.dao.english.ShortWordDao;
import xyz.tobebetter.entity.Message;
import xyz.tobebetter.entity.english.shortword.ShortWord;
import xyz.tobebetter.service.BaseServiceI;

/**
 *
 * @author zhuleqi
 */
public interface ShortWordServiceI extends BaseServiceI<ShortWord,ShortWordDao>{
    public Message findByText(String text , Integer page , Integer pageSize);

    public Message findBySegmentId(String segmentId);
    public Message findByContentId(String contentId);
}
