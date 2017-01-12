package com.niuwa.p2p.spider.dao;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;
/**
 * mongodb操作接口
 * @author maliqiang
 * @since 2017年1月11日
 * @param <T>
 */
@Transactional  
public interface BaseMongoDao<T> {  
	public void checkDB();
    public void createCollection(T t);  
  
    public List<T> findList(int skip, int limit);  
  
    public List<T> findListByCondition(String property,Object value);  
  
    public void insert(T t);  
  
    public void update(T t);
    
	T findOne(String property, Object value);
  
}  