package xyz.tobebetter.service.english.sentence;


import xyz.tobebetter.dao.english.SentenceAndWordDao;
import xyz.tobebetter.entity.Message;
import xyz.tobebetter.entity.english.sentence.SentenceAndWord;
import xyz.tobebetter.service.BaseServiceI;

/**
 * Created by zhuleqi on 2018/10/31.
 */
public interface SentenceAndWordServiceI extends BaseServiceI<SentenceAndWord, SentenceAndWordDao<SentenceAndWord>> {

    /**
     * 根据单词ID查找句子
     * @param wordId
     * @param page
     * @param pageSize
     * @return
     */
    Message findByWordId(String wordId, Integer page, Integer pageSize);

    /**
     * 根据单词ID查找相关句子
     * @param sentenceId
     * @param page
     * @param pageSize
     * @return
     */
    Message findBySentenceId(String sentenceId, Integer page, Integer pageSize);
}
