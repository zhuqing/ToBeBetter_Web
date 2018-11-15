package xyz.tobebetter.dao.english;


import xyz.tobebetter.dao.BaseDao;
import xyz.tobebetter.entity.english.shortword.ShortWordAndSentence;
import xyz.tobebetter.entity.english.shortword.ShortWordAndSentenceVO;

import java.util.List;

/**
 * Created by zhuleqi on 2018/11/13.
 */
public interface ShortWordAndSentenceDao extends BaseDao<ShortWordAndSentence> {

    public List<ShortWordAndSentenceVO> findByShortWordId(String shortWordId) throws Exception;
}
