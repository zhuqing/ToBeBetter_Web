package xyz.tobebetter.service.suggestion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.tobebetter.dao.suggestion.SuggestionDao;

/**
 * Created by zhuleqi on 2018/8/8.
 */
@Service
public class SuggestionServiceImpl implements SuggestionServiceI {

    @Autowired
    private SuggestionDao suggestionDao;

    @Override
    public SuggestionDao getBaseDao() {
        return suggestionDao;
    }
}
