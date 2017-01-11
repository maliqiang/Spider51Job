package com.niuwa.p2p.entity;

/**
 * 关键字查询返回结果
 * 
 * @author maliqiang
 * @since 2017年1月11日
 * @version 1.0
 */
public class KeyWordSearchRsp {
	/* 关键字查询返回结果（职位列表） */
	private String searchByKeyWordRspInfo;

	
	public KeyWordSearchRsp(String searchByKeyWordRspInfo) {
		this.searchByKeyWordRspInfo = searchByKeyWordRspInfo;
	}
	

	public KeyWordSearchRsp() {
	}


	public String getSearchRspInfo() {
		return searchByKeyWordRspInfo;
	}

	public void setSearchRspInfo(String searchRspInfo) {
		this.searchByKeyWordRspInfo = searchRspInfo;
	}

}
