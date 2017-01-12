package com.niuwa.p2p.spider.test;

import com.niuwa.p2p.entity.CompanyInfo;

public class SingleTon {
	private CompanyInfo info = null;
	
	public synchronized CompanyInfo getInstance(){
		if(info==null){
			info = new CompanyInfo("test", null, null, null);
		}
		return info;
		
	}
	
	public static void main(String[] args) {
		
	}
}
