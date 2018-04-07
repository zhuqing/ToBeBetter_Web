package xyz.tobebetter.service;



import xyz.tobebetter.dao.ProposeDao;
import xyz.tobebetter.entity.Propose;

/**
 * Created by zhuleqi on 2018/2/23.
 */
public interface ProposeServiceI<T extends Propose,D extends ProposeDao<T>> extends BaseServiceI<T,D>{
   
}
