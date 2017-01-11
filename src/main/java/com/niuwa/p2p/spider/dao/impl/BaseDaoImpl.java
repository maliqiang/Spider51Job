package com.niuwa.p2p.spider.dao.impl;

import java.lang.reflect.ParameterizedType;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.domain.Sort.Order;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import com.mongodb.DB;
import com.niuwa.p2p.spider.dao.BaseMongoDao;

@Repository  
public class BaseDaoImpl<T> implements BaseMongoDao<T> {  
  
    public static final Logger logger = LoggerFactory.getLogger(BaseDaoImpl.class);  
    
    @Autowired  
    private MongoTemplate mongoTemplate;  
    private Class<?> clz;
	
	public Class<?> getClz() {
		if(clz==null) {
			//获取泛型的Class对象
			clz =  (Class<?>) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[0];
		}
		return clz;
	}
    @Override  
    public void checkDB() {  
        Set<String> colls = this.mongoTemplate.getCollectionNames();  
        for (String coll : colls) {  
            logger.info("CollectionName=" + coll);  
        }  
        DB db = this.mongoTemplate.getDb();  
        logger.info("db=" + db.toString());  
    }  
  
    @Override  
    public void createCollection(T t) {  
        if (!this.mongoTemplate.collectionExists(t.getClass())) {  
            this.mongoTemplate.createCollection(t.getClass());  
        }  
    }  
  
    @SuppressWarnings("unchecked")
	@Override  
    public List<T> findList(int skip, int limit) {  
        Query query = new Query();  
        query.with(new Sort(new Order(Direction.ASC, "_id")));  
        query.skip(skip).limit(limit);  
        return (List<T>) this.mongoTemplate.find(query,getClz());  
    }  
  
   
    @SuppressWarnings("unchecked")
	@Override  
    public T findOne(String property,Object value) {  
        Query query = new Query();  
        query.addCriteria(new Criteria(property).is(value));  
        return (T) this.mongoTemplate.findOne(query,  getClz());  
    }  
  
    @Override  
    public void insert(T t) {  
        this.mongoTemplate.insert(t);  
  
    }  
  
    @Override  
    public void update(T t) {  
        Query query = new Query();  
//        query.addCriteria(new Criteria("_id").is(entity.getId()));  
        Update update = new Update();  
       
        this.mongoTemplate.updateFirst(query, update,  getClz());  
  
    }
    
	@SuppressWarnings("unchecked")
	@Override
	public List<T> findListByCondition(String property, Object value) {
		// TODO Auto-generated method stub
		Query query = new Query();  
        query.addCriteria(new Criteria(property).is(value));  
		return (List<T>) this.mongoTemplate.find(query, getClz());
	}
}  