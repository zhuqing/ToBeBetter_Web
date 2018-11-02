package xyz.tobebetter.dao.english;



import org.w3c.dom.stylesheets.LinkStyle;
import xyz.tobebetter.dao.BaseDao;
import xyz.tobebetter.entity.english.sentence.Sentence;
import xyz.tobebetter.entity.english.sentence.SentenceAndWord;

import java.util.List;

/**
 * Created by zhuleqi on 2018/10/31.
 */
public interface SentenceAndWordDao<T extends SentenceAndWord> extends BaseDao<T> {
    List<T> findByWordId(String wordId) throws Exception;
    List<T> findBySentenceId(String sentenceId) throws Exception;
}
