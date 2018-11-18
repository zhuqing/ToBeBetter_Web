package xyz.tobebetter.service.english.shortword.shortwordandword;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.tobebetter.dao.english.ShortWordAndWordDao;

/**
 * Created by zhuleqi on 2018/11/17.
 */
@Service
public class ShortWordAndWordServiceImpl implements ShortWordAndWordServiceI {

    @Autowired
    private ShortWordAndWordDao shortWordAndWordDao;

    @Override
    public ShortWordAndWordDao getBaseDao() {
        return shortWordAndWordDao;
    }
}
