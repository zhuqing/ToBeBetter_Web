package xyz.tobebetter.dao;



import xyz.tobebetter.entity.Propose;

import java.util.List;

/**
 * Created by zhuleqi on 2018/2/23.
 */
public interface ProposeDao {
    public void create(Propose propose);
    public void delete(String id);
    public List<Propose> findAll();
}
