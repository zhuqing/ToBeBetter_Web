package xyz.tobebetter.service.english.sentence;

import com.github.pagehelper.PageHelper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.tobebetter.dao.english.SentenceAndWordDao;
import xyz.tobebetter.entity.Message;
import xyz.tobebetter.entity.english.sentence.SentenceAndWord;
import xyz.tobebetter.util.MessageUtil;
import xyz.tobebetter.util.WebConsistent;

/**
 * Created by zhuleqi on 2018/10/31.
 */
@Service
public class SentenceAndWordServiceImpl implements SentenceAndWordServiceI {

    @Autowired
    private SentenceAndWordDao<SentenceAndWord> sentenceAndWordDao;

    @Override
    public SentenceAndWordDao<SentenceAndWord> getBaseDao() {
        return this.sentenceAndWordDao;
    }

    @Override
    public Message findByWordId(String wordId, Integer page, Integer pageSize) {

        if(page == null){
            page = 1;
        }

        if(pageSize == null){
            pageSize = WebConsistent.PAGE_SIZE;
        }

        PageHelper.startPage(page,pageSize);

        try {
            SentenceAndWord sentenceAndWord = new SentenceAndWord();
            sentenceAndWord.setWordId(wordId);
            return this.toMessage(this.getBaseDao().findByEntity(sentenceAndWord));
        } catch (Exception e) {
            e.printStackTrace();
            return MessageUtil.createErrorMessage(e.getMessage());
        }

    }

    @Override
    public Message findBySentenceId(String sentenceId, Integer page, Integer pageSize) {
        if(page == null){
            page = 1;
        }

        if(pageSize == null){
            pageSize = WebConsistent.PAGE_SIZE;
        }

        PageHelper.startPage(page,pageSize);

        try {
            SentenceAndWord sentenceAndWord = new SentenceAndWord();
            sentenceAndWord.setSentenceId(sentenceId);
            return this.toMessage(this.getBaseDao().findByEntity(sentenceAndWord));
        } catch (Exception e) {
            e.printStackTrace();
            return MessageUtil.createErrorMessage(e.getMessage());
        }
    }
}
