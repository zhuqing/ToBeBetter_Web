package xyz.tobebetter.service.english.shortword.ShortWordAndSentence;


import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.tobebetter.dao.english.ShortWordAndSentenceDao;
import xyz.tobebetter.entity.Message;
import xyz.tobebetter.entity.english.shortword.ShortWordAndSentenceVO;
import xyz.tobebetter.util.MessageUtil;
import xyz.tobebetter.util.WebConsistent;

import java.util.List;

/**
 * Created by zhuleqi on 2018/11/13.
 */
@Service
public class ShortWordAndSentenceServiceImpl implements ShortWordAndSentenceServiceI {

    @Autowired
    private ShortWordAndSentenceDao shortWordAndSentenceDao;

    @Override
    public ShortWordAndSentenceDao getBaseDao() {
        return this.shortWordAndSentenceDao;
    }


    @Override
    public Message findByShortWordId(String id, Integer page, Integer pageSize) {
        if(page == null){
            page = 1;
        }

        if(pageSize == null){
            pageSize = WebConsistent.PAGE_SIZE;
        }

        PageHelper.startPage(page,pageSize);

        try {
            List<ShortWordAndSentenceVO> shortWordAndSentenceVOList = this.getBaseDao().findByShortWordId(id);
            return MessageUtil.createMessage("ok", shortWordAndSentenceVOList.toArray());
        } catch (Exception e) {
            e.printStackTrace();
            return MessageUtil.createErrorMessage(e.getMessage());
        }

    }
}
