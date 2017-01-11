package com.niuwa.p2p.spider.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.niuwa.p2p.entity.CompanyInfo;
/**
 * 公司信息操作实现
 * @author maliqiang
 * @since 2017年1月11日
 * @version 1.0
 *
 */
@Repository
public class CompanyInfoDao extends BaseDaoImpl<CompanyInfo> {

	@Override
	public Class<?> getClz() {
		return super.getClz();
	}

	@Override
	public void checkDB() {
		// TODO Auto-generated method stub
		super.checkDB();
	}

	@Override
	public void createCollection(CompanyInfo t) {
		// TODO Auto-generated method stub
		super.createCollection(t);
	}

	@Override
	public List<CompanyInfo> findList(int skip, int limit) {
		// TODO Auto-generated method stub
		return super.findList(skip, limit);
	}

	@Override
	public CompanyInfo findOne(String property, Object value) {
		// TODO Auto-generated method stub
		return super.findOne(property, value);
	}

	@Override
	public void insert(CompanyInfo t) {
		// TODO Auto-generated method stub
		super.insert(t);
	}

	@Override
	public void update(CompanyInfo t) {
		// TODO Auto-generated method stub
		super.update(t);
	}

	@Override
	public List<CompanyInfo> findListByCondition(String property, Object value) {
		// TODO Auto-generated method stub
		return super.findListByCondition(property, value);
	}
	
}
