package xyz.tobebetter.service.recommend;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.tobebetter.dao.english.CatalogDao;
import xyz.tobebetter.entity.Consistent;
import xyz.tobebetter.entity.Message;
import xyz.tobebetter.entity.english.Catalog;
import xyz.tobebetter.entity.english.Content;
import xyz.tobebetter.service.content.ContentServiceI;
import xyz.tobebetter.service.english.book.CatalogServiceI;

/**
 * Created by zhuleqi on 2018/7/13.
 */
@Service
public class RecommendServiceImpl implements RecommendServiceI{


    @Autowired
    private CatalogServiceI<Catalog,CatalogDao<Catalog>> catalogService;
    @Autowired
    private ContentServiceI<Content> contentServiceI;
    @Override
    public Message recommendBook(String userId) {
        Catalog catalog = new Catalog();
        catalog.setType(Consistent.BOOK_TYPE);
        return this.catalogService.find(catalog);
    }

    @Override
    public Message recommendArticle(String userId) {
        Content content = new Content();

        return this.contentServiceI.find(content);
    }
}
