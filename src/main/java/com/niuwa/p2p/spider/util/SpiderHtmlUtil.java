package com.niuwa.p2p.spider.util;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import sun.util.logging.resources.logging;

import com.niuwa.p2p.entity.CompanyInfo;



/**
 * 爬取html页面工具
 * @author maliqiang
 * @since 2017年1月9日
 */
public class SpiderHtmlUtil {
	public static Logger log = LoggerFactory.getLogger(SpiderHtmlUtil.class);

	/**
	 * 根据url已get方式获取数据
	 * @param keyWord
	 * @return
	 * @throws Exception 
	 */
	public static String requestUrlByKeyWord(String keyWord) throws Exception {
		String postUrl = "http://search.51job.com/list/000000,000000,0000,00,9,99,"
				+ keyWord
				+ ",1,1.html?lang=c&stype=1&postchannel=0000&workyear=99&cotype=99&degreefrom=99&jobterm=99&companysize=99&lonlat=0,0&radius=-1&ord_field=0&confirmdate=9&fromType=&dibiaoid=0&address=&line=&specialarea=00&from=&welfare=";
		StringBuffer rsp = new StringBuffer();
		try {
			// postUrl = URLEncoder.encode(postUrl, encodeing);
			// postUrl = URLEncoder.encode(postUrl, encodeing);
			URL url = new URL(postUrl);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setDoOutput(true);
			conn.setRequestMethod("GET");
			BufferedReader in = new BufferedReader(new InputStreamReader(
					conn.getInputStream(), "GBK"));
			String line;
			while ((line = in.readLine()) != null) {
				rsp.append(line);
			}
			in.close();

			} catch (Exception e) {
				log.error("根据关键字查询职位出错，请核对后再次查询...");
				throw new Exception("未找到："+keyWord+"相关信息！请修改关键字后再次搜索");
		}

		return rsp.toString().replace("charset=gbk", "charset=UTF-8");

	}
	
	/**
	 * 访问url
	 * @param reqUrl
	 * @return
	 * @throws Exception
	 */
	public static String requestUrl(String reqUrl) throws Exception {
		StringBuffer rsp = new StringBuffer();
		try {
			// postUrl = URLEncoder.encode(postUrl, encodeing);
			// postUrl = URLEncoder.encode(postUrl, encodeing);
			URL url = new URL(reqUrl);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setDoOutput(true);
			conn.setRequestMethod("GET");
			BufferedReader in = new BufferedReader(new InputStreamReader(
					conn.getInputStream(), "GBK"));
			String line;
			while ((line = in.readLine()) != null) {
				rsp.append(line);
			}
			in.close();

			} catch (Exception e) {
				log.error("查询失败...");
				throw new Exception("查询失败："+e.getMessage());
		}

		return rsp.toString().replace("charset=gb2312", "charset=UTF-8");

	}
	/**
	 * 打开职位搜索结果页
	 * @param html
	 */
	public static String getDesInfoUrl(String html) {
		Document doc = Jsoup.parse(html);
		Elements content = doc.getElementsByClass("dw_table");
		Element first = content.first();
		Element link = null;
		String href = "";
		if(first!=null){
			Element el = first.getElementsByClass("el").get(1);
			link = el.getElementsByTag("a").get(1);
		}
//		Element title = doc.getElementsByClass("el title").first();
		if(link!=null){
			href = link.attr("href");
		}
		log.info("即将跳转至："+href);
		return href;
	}
	
	/**
	 * 获取公司要素
	 * @param html
	 * @return
	 */
	public static String getCompanyKeyWord(String html){
		Document doc = Jsoup.parse(html);
		Element name = doc.select("body > div.tCompanyPage > div.tCompany_center.clearfix > div.tHeader.tHCop > div > h1").first();
		if(name==null){
			log.error("获取公司信息失败：可能是该公司有定制页面");
			return null;
		}
		Element element = doc.select("body > div.tCompanyPage > div.tCompany_center.clearfix > div.tHeader.tHCop > div > p").first();
		if(element==null){
			log.error("获取公司信息失败：可能是该公司有定制页面");
			return null;
		}
		return name.text().trim()+"|"+element.text().trim();
	}
	
	/**
	 * 获取公司类型、人数、行业信息
	 * @param keyWord
	 * @return
	 * @throws Exception 
	 */
	public static CompanyInfo getCompanyInfo(String keyWord) throws Exception{
		/**
		 * 根据关键字查询职位
		 */
		String rsp = requestUrlByKeyWord(keyWord);
//		template.save(rsp, "queryResult");
		/**
		 * 获取职位搜索结果页url
		 */
		String href = getDesInfoUrl(rsp);
		/**
		 * 打开职位搜索结果页
		 */
		String info = requestUrl(href);
//		System.out.println(info);
//		template.save(info, "companyInfo");
		String type = getCompanyKeyWord(info);
		String temp[] = type.split("\\|");
		CompanyInfo res = new CompanyInfo(temp[0], temp[1], temp[2],temp[3]);
		return res;
		
	}
}
