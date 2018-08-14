package xyz.tobebetter.service.content;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.tobebetter.dao.english.ContentAndCatalogDao;
import xyz.tobebetter.entity.Message;
import xyz.tobebetter.entity.english.content.ContentAndCatalog;
import xyz.tobebetter.util.MessageUtil;

import java.util.List;

/**
 * Created by zhuleqi on 2018/8/14.
 */
@Service
public class ContentAndCatalogServiceImpl<T extends ContentAndCatalog,D extends  ContentAndCatalogDao<T>> implements  ContentAndCatalogServiceI<T,D> {

    @Autowired
    private ContentAndCatalogDao<T> contentAndCatalogDao;

    @Override
    public Message findByContentId(String contentId) {
        try {
            List<T> ts = this.getBaseDao().findByContentId(contentId);
            return this.toMessage(ts);
        } catch (Exception e) {
            e.printStackTrace();
            return MessageUtil.createErrorMessage(e.getMessage());
        }
    }


    @Override
    public D getBaseDao() {
        return (D) contentAndCatalogDao;
    }
}
