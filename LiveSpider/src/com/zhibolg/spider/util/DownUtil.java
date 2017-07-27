package com.zhibolg.spider.util;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import com.zhibolg.spider.model.Game;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class DownUtil {

	/*
	 * 获取全部网站HTML
	 */
	public static String getHtml(String url) {

		CloseableHttpClient httpclient = HttpClients.createDefault();
		HttpGet httpget = new HttpGet(url);

		CloseableHttpResponse response = null;
		String content = null;
		try {
			response = httpclient.execute(httpget);
			HttpEntity entity = response.getEntity();
			content = EntityUtils.toString(entity, "utf-8");
			response.close();
		} catch (Exception e) {
			System.out.println(e);
		}

		return content;
	}

	/*
	 * 获取斗鱼的直播间
	 */
	public static List<Game> getDouYu(String zurl, int index) {
		List<Game> list = new ArrayList<Game>();
		list.clear();
		String html = DownUtil.getHtml(zurl);
		if (html == null) {
			return null;
		}
		Document doc = Jsoup.parse(html);
		html = null;
		// name
		Elements name = doc.select(".play-list-link .mes .dy-name").select(".ellipsis").select(".fl");
		// title
		Elements title = doc.select(".play-list-link");
		// url
		Elements url = doc.select(".play-list-link");
		// img
		Elements img = doc.select(".play-list-link .imgbox img");
		// num
		Elements num = doc.select(".play-list-link .mes .dy-num").select(".fr");

		int count = 50;

		if (name.size() < 49) {
			count = name.size();
		}

		for (int i = 0; i < count; i++) {
			Game game = new Game();
			game.setName(name.get(i).text());
			game.setTitle(title.get(i).attr("title"));
			game.setUrl("https://www.douyu.com" + url.get(i).attr("href"));
			game.setImg(img.get(i).attr("data-original"));
			game.setIndex(index);
			game.setNum(DownUtil.getNum(num.get(i).text()));
			list.add(game);
			game = null;
		}
		return list;
	}

	/*
	 * 获取熊猫的直播间
	 */
	public static List<Game> getPanda(String zurl, int index) {

		List<Game> list = new ArrayList<Game>();
		list.clear();
		String html = DownUtil.getHtml(zurl);
		if (html == null) {
			return null;
		}
		Document doc = Jsoup.parse(html);
		// name
		Elements name = doc.select(".video-list-item-wrap .video-info .video-nickname");
		// title
		Elements title = doc.select(".video-list-item-wrap .video-title");
		// url
		Elements url = doc.select(".video-list-item-wrap");
		// img
		Elements img = doc.select(".video-list-item-wrap .video-cover .video-img").select(".video-img-lazy");
		// num
		Elements num = doc.select(".video-list-item-wrap .video-info .video-number");

		int count = 50;

		if (name.size() < 49) {
			count = name.size();
		}

		for (int i = 0; i < count; i++) {
			Game game = new Game();
			game.setName(name.get(i).text());
			game.setTitle(title.get(i).attr("title"));
			game.setUrl("http://www.panda.tv" + url.get(i).attr("href"));
			game.setImg(img.get(i).attr("data-original"));
			game.setIndex(index);
			game.setNum(DownUtil.getNum(num.get(i).text()));
			System.out.println(num.get(i).text());
			list.add(game);
			game = null;
		}

		return list;
	}

	/*
	 * 获得虎牙直播间
	 */
	public static List<Game> getHuYa(String zurl, int index) {

		List<Game> list = new ArrayList<Game>();
		list.clear();
		String html = DownUtil.getHtml(zurl);
		if (html == null) {
			return null;
		}

		Document doc = Jsoup.parse(html);
		html = null;
		// name
		Elements name = doc.select(".game-live-item .txt .nick");
		// title
		Elements title = doc.select(".game-live-item .title").select(".new-clickstat");
		// url
		Elements url = doc.select(".game-live-item .title").select(".new-clickstat");
		// img
		Elements img = doc.select(".game-live-item .pic");
		// num
		Elements num = doc.select(".game-live-item .txt .js-num");

		int count = 50;

		if (name.size() < 49) {
			count = name.size();
		}

		for (int i = 0; i < count; i++) {
			Game game = new Game();
			game.setName(name.get(i).text());
			game.setTitle(title.get(i).text());
			game.setUrl(url.get(i).attr("href"));
			game.setImg(img.get(i).attr("data-original"));
			game.setIndex(index);
			game.setNum(DownUtil.getNum(num.get(i).text()));
			list.add(game);
			game = null;

		}

		return list;
	}

	/*
	 * 全民
	 */
	public static List<Game> getQuanMing(String zurl, int index) {

		List<Game> list = new ArrayList<Game>();
		list.clear();
		String html = DownUtil.getHtml(zurl);
		if (html == null) {
			return null;
		}

		JSONObject jsonObject = JSONObject.fromObject(html);
		JSONArray json = jsonObject.getJSONArray("data");
		html = null;
		int count = 50;

		if (json.size() < 49) {
			count = json.size();
		}

		for (int i = 0; i < count; i++) {
			Game game = new Game();
			game.setName(json.getJSONObject(i).getString("nick"));
			game.setTitle(json.getJSONObject(i).getString("title"));
			game.setUrl("http://www.quanmin.tv/" + json.getJSONObject(i).getString("no"));
			game.setImg(json.getJSONObject(i).getString("thumb"));
			game.setIndex(index);
			String num = json.getJSONObject(i).getString("view");
			game.setNum(DownUtil.getNum(num));
			list.add(game);
			game = null;
		}

		return list;
	}

	/*
	 * 火猫直播间
	 */
	public static List<Game> getHuoMao(String zurl, int index) {

		List<Game> list = new ArrayList<Game>();
		list.clear();
		String html = DownUtil.getHtml(zurl);
		if (html == null) {
			return null;
		}

		JSONObject jSONObject = JSONObject.fromObject(html);
		JSONObject object = (JSONObject) jSONObject.get("data");
		JSONArray json = object.getJSONArray("channelList");
		html = null;
		int count = 50;

		if (json.size() < 49) {
			count = json.size();
		}
		for (int i = 0; i < count; i++) {
			Game game = new Game();
			game.setName(json.getJSONObject(i).getString("username"));
			game.setTitle(json.getJSONObject(i).getString("channel"));
			game.setUrl("https://www.huomao.com/" + json.getJSONObject(i).getString("room_number"));
			game.setImg(json.getJSONObject(i).getString("image"));
			game.setIndex(index);
			String num = json.getJSONObject(i).getString("views");
			game.setNum(DownUtil.getNum(num));
			list.add(game);
			game = null;
		}

		return list;
	}

	/*
	 * 龙珠直播间
	 */
	public static List<Game> getLongZhu(String zurl, int index) {

		List<Game> list = new ArrayList<Game>();
		list.clear();
		String html = DownUtil.getHtml(zurl);
		if (html == null) {
			return null;
		}

		Document doc = Jsoup.parse(html);
		html = null;

		// name
		Elements name = doc.select(".livecard .livecard-modal .livecard-modal-username");
		// title
		Elements title = doc.select(".livecard .listcard-caption");
		// url
		Elements url = doc.select(".livecard");
		// img
		Elements img = doc.select(".livecard .livecard-thumb");
		// num
		Elements num = doc.select(".livecard .livecard-meta .livecard-meta-item").select(".livecard-meta-views")
				.select(".livecard-meta-item-text");

		int count = 50;

		if (name.size() < 49) {
			count = name.size();
		}

		for (int i = 0; i < count; i++) {
			Game game = new Game();
			game.setName(name.get(i).text());
			game.setTitle(title.get(i).text());
			game.setUrl(url.get(i).attr("href"));
			game.setImg(img.get(i).attr("src"));
			game.setIndex(index);
			game.setNum(DownUtil.getNum(num.get(i).text()));
			list.add(game);
			game = null;
		}

		return list;
	}

	/*
	 * 战旗直播间
	 */
	public static List<Game> getZhanQi(String zurl, int index) {

		List<Game> list = new ArrayList<Game>();
		list.clear();
		String html = DownUtil.getHtml(zurl);
		if (html == null) {
			return null;
		}

		JSONObject object = JSONObject.fromObject(html);
		JSONObject o = (JSONObject) object.get("data");
		JSONArray json = o.getJSONArray("rooms");
		int count = 50;
		if (json.size() < 49) {
			count = json.size();
		}
		for (int i = 0; i < count; i++) {
			Game game = new Game();
			game.setName(json.getJSONObject(i).getString("nickname"));
			game.setTitle(json.getJSONObject(i).getString("title"));
			game.setUrl("https://www.zhanqi.tv" + json.getJSONObject(i).getString("url"));
			game.setImg(json.getJSONObject(i).getString("spic"));
			game.setIndex(index);
			game.setNum(DownUtil.getNum(json.getJSONObject(i).getString("online")));
			list.add(game);
			game = null;
		}

		return list;
	}

	/**
	 * @param numStr
	 * @return 返回一个人气 int 类型
	 */
	public static int getNum(String numStr) {
		System.out.println(numStr);
		String s = "";
		String s1 = numStr.replace("人", "");
		String s2 = s1.replace(",", "");
		if (s2.contains("万")) {
			s = s2.replace("万", "");
			s = (int) (Float.parseFloat(s) * 10000) + "";
		}else{
			s = s2;
		}
		String regEx = "[^0-9]";
		Pattern p = Pattern.compile(regEx);
		Matcher m = p.matcher(s);
		return Integer.parseInt(m.replaceAll("").trim());
	}

}
