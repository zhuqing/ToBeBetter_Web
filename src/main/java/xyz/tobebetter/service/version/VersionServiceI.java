package xyz.tobebetter.service.version;

import xyz.tobebetter.dao.version.VersionDao;
import xyz.tobebetter.entity.Message;
import xyz.tobebetter.service.BaseServiceI;
import xyz.tobebetter.version.Version;

/**
 * Created by zhuleqi on 2018/8/28.
 */
public interface VersionServiceI<T extends Version> extends BaseServiceI<T,VersionDao<T>> {

    public Message findByType(Integer type);

    public Message findNewestByType(Integer type);
}
