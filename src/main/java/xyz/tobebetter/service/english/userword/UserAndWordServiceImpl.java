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
import xyz.tobebetter.entity.Consistent;
import xyz.tobebetter.entity.Message;
import xyz.tobebetter.entity.user.word.UserAndWord;
import xyz.tobebetter.entity.word.Word;
import xyz.tobebetter.util.EntityUtil;
import xyz.tobebetter.util.MessageUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

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
    public Message insertByWordId(String wordId, String userId) {
        T userAndWord = (T) new UserAndWord();
        userAndWord.setUserId(userId);
        userAndWord.setWordId(wordId);
        userAndWord.setType(0);
        userAndWord.setReciteCount(0);
        EntityUtil.initEnity(userAndWord);
        try {
            this.getBaseDao().create(userAndWord);
            return this.toMessage(userAndWord);
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
            return MessageUtil.createErrorMessage(e.getMessage()+"\tsegmentId:"+segmentId+"\tuserId:"+userId);
        }
    }

    @Override
    public Message increamReciteCount(String wordId, String userId) {
        T userAndWord = (T) new UserAndWord();
        userAndWord.setUserId(userId);
        userAndWord.setWordId(wordId);
        try {
            List<T> datas = this.userAndWordDao.findByEntity(userAndWord);
            if(datas == null || datas.isEmpty()){
                return MessageUtil.createErrorMessage("没有加载到数据");
            }

            userAndWord = datas.get(0);
            if(userAndWord.getReciteCount() == null){
                userAndWord.setReciteCount(0);
            }
            userAndWord.setReciteCount(userAndWord.getReciteCount()+1);
            this.userAndWordDao.update(userAndWord);
            return MessageUtil.createSuccessMessage();
        } catch (Exception e) {
            e.printStackTrace();
            return MessageUtil.createErrorMessage(e.getMessage());
        }

    }

    @Override
    public Message update2Recited(String wordId, String userId) {

        return updateType(wordId,userId,2);

    }

    @Override
    public Message update2UnRecited(String wordId, String userId) {
       return updateType(wordId,userId,0);
    }

    @Override
    public Message allMyWordsCount(String userId) {
        try {
           Long count =  this.getBaseDao().allMyWordsCount(userId);
           return MessageUtil.createSuccessMessage(count);
        } catch (Exception e) {
            e.printStackTrace();
            return MessageUtil.createSuccessMessage(e.getMessage());
        }

    }

    @Override
    public Message hasRecitedWordsCount(String userId) {
        try {
            Long count =  this.getBaseDao().hasRecitedWordsCount(userId);
            return MessageUtil.createSuccessMessage(count);
        } catch (Exception e) {
            e.printStackTrace();
            return MessageUtil.createSuccessMessage(e.getMessage());
        }
    }



    private Message updateType(String wordId, String userId,Integer type){
        try {
            T userAndWord = this.getT(wordId, userId);

            userAndWord.setType(type);

            this.getBaseDao().update(userAndWord);
            return MessageUtil.createSuccessMessage();
        } catch (Exception e) {
            e.printStackTrace();
            return MessageUtil.createErrorMessage(e.getMessage()+" wordId="+wordId+" userId="+userId);
        }
    }

    private T getT(String wordId,String userId) throws Exception {
        T userAndWord = (T) new UserAndWord();
        userAndWord.setUserId(userId);
        userAndWord.setWordId(wordId);

            List<T> userAndWords = this.getBaseDao().findByEntity(userAndWord);
            if(userAndWords == null || userAndWords.isEmpty()){
               throw new Exception("没有找到数据");
            }

           return userAndWords.get(0);

    }

    private void save(List<Word> wordList, String userId) throws Exception {
        if (wordList == null || wordList.isEmpty()) {
            throw  new Exception("没有数据");
        }
        
        List<Word> hasSaved = this.wordDao.findByUserId(userId);
        Set<String> wordIds = hasSaved.stream().map((w)->w.getId()).collect(Collectors.toSet());

        List<T> userAndWordList = new ArrayList<>(wordList.size());

        for (Word word : wordList) {
            if(wordIds.contains(word.getId())){
                continue;
            }
            wordIds.add(word.getId());
            T userAndWord = (T) new UserAndWord();
            userAndWord.setUserId(userId);
            userAndWord.setWordId(word.getId());
            EntityUtil.initEnity(userAndWord);
            userAndWordList.add(userAndWord);
        }
        
        if(userAndWordList.isEmpty()){
            return;
        }

        this.getBaseDao().saveList(userAndWordList);
    }
}
