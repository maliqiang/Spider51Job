package com.niuwa.p2p.spider.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.niuwa.p2p.entity.KeyWordSearchRsp;
/**
 * 保存关键字搜索结果
 * @author maliqiang
 * @since 2017年1月11日
 * @version 1.0
 *
 */
@Repository
public class KeyWordSerachRspDao extends BaseDaoImpl<KeyWordSearchRsp>{

	@Override
	public Class<?> getClz() {
		// TODO Auto-generated method stub
		return super.getClz();
	}

	@Override
	public void checkDB() {
		// TODO Auto-generated method stub
		super.checkDB();
	}

	@Override
	public void createCollection(KeyWordSearchRsp t) {
		// TODO Auto-generated method stub
		super.createCollection(t);
	}

	@Override
	public List<KeyWordSearchRsp> findList(int skip, int limit) {
		// TODO Auto-generated method stub
		return super.findList(skip, limit);
	}

	@Override
	public KeyWordSearchRsp findOne(String property, Object value) {
		// TODO Auto-generated method stub
		return super.findOne(property, value);
	}

	@Override
	public void insert(KeyWordSearchRsp t) {
		// TODO Auto-generated method stub
		super.insert(t);
	}

	@Override
	public void update(KeyWordSearchRsp t) {
		// TODO Auto-generated method stub
		super.update(t);
	}

	@Override
	public List<KeyWordSearchRsp> findListByCondition(String property,
			Object value) {
		// TODO Auto-generated method stub
		return super.findListByCondition(property, value);
	}

}
