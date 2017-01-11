package com.niuwa.p2p.entity;
/**
 * 公司详情介绍
 * @author maliqiang
 * @since 2017年1月11日
 * @version 1.0
 */
public class DetailDescInfo {
	private String url;
	/* 公司详细描述 */
	private String DetailDescOfCompany;

	public DetailDescInfo(String url,String detailDescOfCompany) {
		this.url =url;
		this.DetailDescOfCompany = detailDescOfCompany;
	}

	
	public String getUrl() {
		return url;
	}


	public void setUrl(String url) {
		this.url = url;
	}


	public DetailDescInfo() {
	}

	public String getDetailDescOfCompany() {
		return DetailDescOfCompany;
	}

	public void setDetailDescOfCompany(String detailDescOfCompany) {
		DetailDescOfCompany = detailDescOfCompany;
	}
	
	
}
