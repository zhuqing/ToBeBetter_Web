package xyz.tobebetter.dao.version;

import xyz.tobebetter.dao.BaseDao;
import xyz.tobebetter.version.Version;

/**
 * Created by zhuleqi on 2018/8/28.
 */
public interface VersionDao<T extends Version> extends BaseDao<T> {
    public Version findNewest(Version version) throws Exception;
}
