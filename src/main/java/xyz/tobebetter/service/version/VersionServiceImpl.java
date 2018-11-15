package xyz.tobebetter.service.version;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.tobebetter.dao.version.VersionDao;
import xyz.tobebetter.entity.Message;
import xyz.tobebetter.util.MessageUtil;
import xyz.tobebetter.version.Version;

/**
 * Created by zhuleqi on 2018/8/28.
 */
@Service
public class VersionServiceImpl implements VersionServiceI<Version> {

    @Autowired
    private VersionDao<Version> versionDao;

    @Override
    public VersionDao<Version> getBaseDao() {
        return versionDao;
    }

    @Override
    public Message findByType(Integer type) {
        Version version = new Version();
        version.setType(type);
        return this.find(version);
    }

    @Override
    public Message findNewestByType(Integer type) {
        Version version = new Version();
        version.setType(type);
        try {
            version = this.getBaseDao().findNewest(version);
            return this.toMessage(version);
        } catch (Exception e) {
            e.printStackTrace();
            return MessageUtil.createErrorMessage(e.getMessage());
        }

    }

    @Override
    public Version findNewestVersionByType(Integer type) {
        Version version = new Version();
        version.setType(type);
        try {
            version = this.getBaseDao().findNewest(version);
            return version;
        } catch (Exception e) {
            e.printStackTrace();

        }
        return null;
    }


}
