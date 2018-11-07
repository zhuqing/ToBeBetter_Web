/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xyz.tobebetter.service.english;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.logging.Level;
import java.util.logging.Logger;


import com.github.pagehelper.PageHelper;
import com.leqienglish.util.tran.iciba.ICIBATranslateUtil;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import xyz.tobebetter.dao.english.WordDao;
import xyz.tobebetter.entity.Message;

import xyz.tobebetter.entity.word.Word;
import xyz.tobebetter.util.EntityUtil;
import xyz.tobebetter.util.LoadWordUtil;
import xyz.tobebetter.util.MessageUtil;
import xyz.tobebetter.util.WebConsistent;

/**
 *
 * @author zhuqing
 */
@Service
public class WordServiceImpl<T extends Word, D extends WordDao<T>> implements WordServiceI<T, D> {

    @Autowired
    private WordDao<T> wordDao;

    // @Autowired
    // private ContentWordUserRelationshipDao<ContentWordUserRelationship> contentWordUserRelationshipDao;
    @Override
    public D getBaseDao() {
        return (D) this.wordDao;
    }

    @Override
    public Message findByWord(String word) {
        T worde = (T) new Word();
        worde.setWord(word);
        try {
            List<T> ts = this.getBaseDao().findByEntity(worde);
            if(ts == null || ts.isEmpty()){
                return this.loadWord(word);
            }
            return this.toMessage(ts.get(0));
        } catch (Exception ex) {
            Logger.getLogger(WordServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            return MessageUtil.createErrorMessage(ex.getMessage(), null);
        }

    }

    private Message loadWord(String word) throws Exception {
        String wordinfo = ICIBATranslateUtil.transResult(word.toLowerCase());

        System.err.println(wordinfo);
        T newWord = (T) Word.icibaJsontoWord(wordinfo);

        if(newWord==null || newWord.getWord() == null || newWord.getWord().isEmpty()){
            throw new Exception("没有找到单词");
        }

       String path =  LoadWordUtil.load(newWord.getAmAudionPath(),word,"am");
        newWord.setAmAudionPath(path);

        path =  LoadWordUtil.load(newWord.getEnAudioPath(),word,"en");
        newWord.setEnAudioPath(path);

        path =  LoadWordUtil.load(newWord.getTtsAudioPath(),word,"tts");
        newWord.setTtsAudioPath(path);

        return this.create(newWord);
    }

    @Override
    @Transactional
    public Message create(T t, String contentId, String userId) {
//        try {
//            EntityUtil.initEnity(t);
//            if (this.findById(t.getId()) != null) {
//                EntityUtil.initEnity(t);
//            }
//            this.getBaseDao().create(t);
//
//            ContentWordUserRelationship ship = ContentWordUserRelationship.create(contentId, userId, t.getId());
//
//            EntityUtil.initEnity(ship);
//            if (this.contentWordUserRelationshipDao.findById(ship.getId()) != null) {
//                EntityUtil.initEnity(ship);
//            }
//            this.contentWordUserRelationshipDao.create(ship);
//
//            return MessageUtil.createSuccessMessage();
//            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//        } catch (Exception ex) {
//            Logger.getLogger(WordServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
//
//            return MessageUtil.createErrorMessage(ex.getMessage());
//        }
        return null;
    }

    @Override
    public Message findByUserId(String userId) {
        try {
            return this.toMessage(this.wordDao.findByUserId(userId));
        } catch (Exception ex) {
            Logger.getLogger(WordServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            return MessageUtil.createErrorMessage(ex.getMessage());
        }
    }

    @Override
    public Message findByContentId(String contentId) {
        try {
            return this.toMessage(this.wordDao.findByContentId(contentId));
        } catch (Exception ex) {
            Logger.getLogger(WordServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            return MessageUtil.createErrorMessage(ex.getMessage());
        }
    }

    @Override
    public Message findBySegmentId(String segmentId) {
        try {
            List<T> ts = this.getBaseDao().findBySegmentId(segmentId);
            return this.toMessage(ts);
        } catch (Exception ex) {
            Logger.getLogger(WordServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            return MessageUtil.createErrorMessage(ex.getMessage());
        }
    }

    @Override
    public Message findByUserIdAndContentId(String userId, String contentId) {
        try {
            return this.toMessage(this.wordDao.findByUserIdAndContentId(userId, contentId));
        } catch (Exception ex) {
            Logger.getLogger(WordServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            return MessageUtil.createErrorMessage(ex.getMessage());
        }
    }

    @Override
    public Message findByUserIdAndWordId(String userId, String wordId) {
        try {
            return this.toMessage(this.wordDao.findByUserIdAndWordId(userId, wordId));
        } catch (Exception ex) {
            Logger.getLogger(WordServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            return MessageUtil.createErrorMessage(ex.getMessage());
        }
    }

    @Override
    public Message search(String word ,Integer page,Integer pageSize) {
        if(page == null){
            page = 1;
        }

        if(pageSize == null){
            pageSize = WebConsistent.PAGE_SIZE;
        }
        PageHelper.startPage(page,pageSize);
        try {
            return this.toMessage(this.getBaseDao().search(word));
        } catch (Exception e) {
            e.printStackTrace();
            return MessageUtil.createErrorMessage(e.getMessage());
        }


    }

    @Override
    public Message findRecitingByUserId(String userId) {
         try {
            return this.toMessage(this.wordDao.findRecitingByUserId(userId));
        } catch (Exception ex) {
            Logger.getLogger(WordServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            return MessageUtil.createErrorMessage(ex.getMessage());
        }
    }

    @Override
    public Message findUnReciteByUserId(String userId) {
         try {
            return this.toMessage(this.wordDao.findUnReciteByUserId(userId));
        } catch (Exception ex) {
            Logger.getLogger(WordServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            return MessageUtil.createErrorMessage(ex.getMessage());
        }
    }

    @Override
    public Message findHasReciteByUserId(String userId) {
          try {
            return this.toMessage(this.wordDao.findHasReciteByUserId(userId));
        } catch (Exception ex) {
            Logger.getLogger(WordServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            return MessageUtil.createErrorMessage(ex.getMessage());
        }
    }

    @Override
    public Message findMyReciteByUserId(String userId, Integer number) {
        PageHelper.startPage(1, number);
        try {
            List<T> ts = this.wordDao.findMyReciteWordByUserId(userId);
            if(ts!= null ){
                return this.toMessage(ts);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return MessageUtil.createErrorMessage(e.getMessage());
        }
        return MessageUtil.createErrorMessage("");
    }
}
