/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xyz.tobebetter.service.english.book;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.tobebetter.dao.english.CatalogDao;
import xyz.tobebetter.entity.Message;
import xyz.tobebetter.entity.english.Catalog;


@Service
public class CatalogServiceImpl<T extends Catalog, D extends CatalogDao<T>> implements CatalogServiceI<T, D> {

    @Autowired
    private CatalogDao catalogDao;

    @Override
    public D getBaseDao() {
        return (D) this.catalogDao;
    }

    @Override
    public Message getCatalogByParentId(String parentId) {
        Catalog catalog = new Catalog();
        catalog.setParentId(parentId);
        return this.find((T) catalog, 1, 1000);
    }

    @Override
    public Message getCatalogByType(int type, int pageSize, int page) {
        Catalog catalog = new Catalog();
        catalog.setType(type);
        return this.find((T) catalog, page, pageSize);

    }

    @Override
    public Message getBookByUserId(String userId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Message getCatalogByParentId(String parentId, int page, int pageSize) {
        Catalog catalog = new Catalog();
        catalog.setParentId(parentId);
        return this.find((T) catalog, page, pageSize);
    }

}
