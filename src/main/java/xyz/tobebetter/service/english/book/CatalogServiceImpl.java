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
import xyz.tobebetter.util.MessageUtil;

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
        try {
            List<T> items = this.catalogDao.getCatalogByParentId(parentId);

            return this.toMessage(items);
        } catch (Exception ex) {
            Logger.getLogger(CatalogServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            return MessageUtil.createErrorMessage(ex.getMessage());
        }
    }

    @Override
    public Message getCatalogByType(Catalog catalog, int pageSize, int page) {
        //String 
        Page<T> p = PageHelper.startPage(page, pageSize, true);

        try {
            List<T> catalogs = this.catalogDao.getCatalog(catalog);

            return this.toMessage(catalogs);
        } catch (Exception ex) {
            Logger.getLogger(CatalogServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            return MessageUtil.createErrorMessage(ex.getMessage());
        }

    }

    @Override
    public Message getBookByUserId(String userId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
