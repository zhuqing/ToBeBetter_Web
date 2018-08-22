/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xyz.tobebetter.service.english.userword;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.tobebetter.dao.english.UserAndWordDao;
import xyz.tobebetter.dao.english.WordDao;
import xyz.tobebetter.entity.Message;
import xyz.tobebetter.entity.user.word.UserAndWord;
import xyz.tobebetter.entity.word.Word;
import xyz.tobebetter.util.EntityUtil;
import xyz.tobebetter.util.MessageUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhuleqi
 */
@Service
public class UserAndWordServiceImpl<T extends UserAndWord, D extends UserAndWordDao<T>> implements UserAndWordServiceI<T, D> {

    @Autowired
    private UserAndWordDao<T> userAndWordDao;
    @Autowired
    private WordDao<Word> wordDao;

    @Override
    public D getBaseDao() {
        return (D) userAndWordDao;
    }

    @Override
    public Message findByUserAndWord(String userId, String wordId) {
        T userAndWord = (T) new UserAndWord();
        userAndWord.setUserId(userId);
        userAndWord.setWordId(wordId);
        return this.find(userAndWord);
    }

    @Override
    public Message insertAllByContentId(String contentId, String userId) {
        try {
            List<Word> wordList = wordDao.findByContentId(contentId);
            save(wordList,userId);
            return MessageUtil.createSuccessMessage("success");

        } catch (Exception e) {
            e.printStackTrace();
            return MessageUtil.createErrorMessage(e.getMessage());
        }

    }

    @Override
    public Message insertAllBySegmentId(String segmentId, String userId) {
        try {
            List<Word> wordList = wordDao.findBySegmentId(segmentId);
            save(wordList,userId);
            return MessageUtil.createSuccessMessage("success");

        } catch (Exception e) {
            e.printStackTrace();
            return MessageUtil.createErrorMessage(e.getMessage());
        }
    }

    private void save(List<Word> wordList, String userId) throws Exception {
        if (wordList == null || wordList.isEmpty()) {
            throw  new Exception("没有数据");
        }

        List<T> userAndWordList = new ArrayList<>(wordList.size());
        for (Word word : wordList) {
            T userAndWord = (T) new UserAndWord();
            userAndWord.setUserId(userId);
            userAndWord.setWordId(word.getId());
            EntityUtil.initEnity(userAndWord);
            userAndWordList.add(userAndWord);
        }

        this.getBaseDao().saveList(userAndWordList);
    }
}
