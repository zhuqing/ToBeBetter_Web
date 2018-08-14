package xyz.tobebetter.service.content;

import xyz.tobebetter.dao.BaseDao;
import xyz.tobebetter.dao.english.ContentAndCatalogDao;
import xyz.tobebetter.entity.Entity;
import xyz.tobebetter.entity.Message;
import xyz.tobebetter.entity.english.content.ContentAndCatalog;
import xyz.tobebetter.service.BaseServiceI;

/**
 * Created by zhuleqi on 2018/8/14.
 */
public interface ContentAndCatalogServiceI<T extends ContentAndCatalog,D extends ContentAndCatalogDao<T>> extends BaseServiceI<T,D> {
     Message findByContentId(String contentId);
}
