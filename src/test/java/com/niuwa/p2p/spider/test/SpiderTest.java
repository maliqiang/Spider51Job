package com.niuwa.p2p.spider.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.niuwa.p2p.entity.CompanyInfo;
import com.niuwa.p2p.entity.DetailDescInfo;
import com.niuwa.p2p.entity.KeyWordSearchRsp;
import com.niuwa.p2p.spider.dao.impl.CompanyInfoDao;
import com.niuwa.p2p.spider.dao.impl.DetailInfoRspDao;
import com.niuwa.p2p.spider.dao.impl.KeyWordSerachRspDao;
import com.niuwa.p2p.spider.util.SpiderHtmlUtil;
/**
 * 爬取数据测试类
 * @author maliqiang
 * @since 2017年1月11日
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath*:applicationContext.xml"})
public class SpiderTest {
	
	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private CompanyInfoDao infoDao;
	@Autowired
	private KeyWordSerachRspDao searchRspDao;
	@Autowired
	private DetailInfoRspDao detailDao;
	@Autowired
	private SpiderHtmlUtil spiderUtil;
	
	/**
	 * 分步测试
	 * @throws Exception
	 */
	@Test
	public void testSpider() throws Exception{
		/**
		 * eg.:
		 * 百度在线网络技术
		 * 美团点评
		 * 上海易宝软件有限公司
		 * 深圳市腾讯计算机系统有限公司
		 */
		String keyWord = "上海易宝软件有限公司";
		/**
		 * 根据关键字查询职位
		 */
		String rsp = SpiderHtmlUtil.requestUrlByKeyWord(keyWord );
		KeyWordSearchRsp searchRsp = new KeyWordSearchRsp(rsp);
		searchRspDao.insert(searchRsp);
		/**
		 * 获取职位搜索结果页url
		 */
		String href = SpiderHtmlUtil.getDesInfoUrl(rsp);
		/**
		 * 打开职位搜索结果页
		 */
		String info = SpiderHtmlUtil.requestUrl(href);
		DetailDescInfo descInfo = new DetailDescInfo(href,info);
		detailDao.insert(descInfo);
		/**
		 * 获取公司人数、类型、所属行业等信息
		 */
		String type = SpiderHtmlUtil.getCompanyKeyWord(info);
		if(type==null){
			log.error("获取公司详情页出错！");
			return;
		}
		String temp[] = type.split("\\|");
		CompanyInfo res = new CompanyInfo(temp[1], temp[0], temp[2],temp[3]);
		infoDao.insert(res);
        System.out.println("DONE!");  
    }  
	
	/**
	 * 根据公司名称获取详细信息
	 * @throws Exception
	 */
	@Test
	public void getCompanyInfo() throws Exception{
		String keyWord = "深圳市腾讯计算机系统有限公司";
		CompanyInfo info = spiderUtil.getCompanyInfo(keyWord);
		log.info(info.toString());
	}
	
}
