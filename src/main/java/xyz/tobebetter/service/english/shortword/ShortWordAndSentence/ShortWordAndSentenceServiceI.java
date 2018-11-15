package xyz.tobebetter.service.english.shortword.ShortWordAndSentence;


import xyz.tobebetter.dao.english.ShortWordAndSentenceDao;
import xyz.tobebetter.entity.Message;
import xyz.tobebetter.entity.english.shortword.ShortWordAndSentence;
import xyz.tobebetter.service.BaseServiceI;

/**
 * Created by zhuleqi on 2018/11/13.
 */
public interface ShortWordAndSentenceServiceI extends BaseServiceI<ShortWordAndSentence,ShortWordAndSentenceDao> {

    public Message findByShortWordId(String id,Integer page,Integer pageSize);
}
