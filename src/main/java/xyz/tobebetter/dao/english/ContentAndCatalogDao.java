package xyz.tobebetter.dao.english;


import xyz.tobebetter.dao.BaseDao;
import xyz.tobebetter.entity.english.Catalog;
import xyz.tobebetter.entity.english.content.ContentAndCatalog;

import java.util.List;

/**
 * Created by zhuleqi on 2018/8/14.
 */
public interface ContentAndCatalogDao<T extends ContentAndCatalog> extends BaseDao<T> {
    List<T> findByContentId(String contentId) throws Exception;
}
