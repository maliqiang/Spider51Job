package com.niuwa.p2p.spider.dao.impl;

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
	public void insert(KeyWordSearchRsp t) {
		// TODO Auto-generated method stub
		super.insert(t);
	}


}
