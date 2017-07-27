package com.zhibolg.spider.test;

import java.util.List;

import org.junit.Test;

import com.zhibolg.spider.model.Game;
import com.zhibolg.spider.service.GameService;
import com.zhibolg.spider.util.DownUtil;

public class TestDownUtil {

	@Test
	public void getHtml() {
		String html = DownUtil.getHtml("https://www.baidu.com/");
		System.out.println(html);
	}

	@Test
	public void getDouYu() {
		List<Game> list = DownUtil.getDouYu("https://www.douyu.com/directory/game/CSGO", 1);
		System.out.println(list.size());
	}

	@Test
	public void getPanda() {
		List<Game> list = DownUtil.getPanda("http://www.panda.tv/cate/csgo", 1);
		for(Game g:list){
			System.out.println(g.getNum());
		}
	}

	@Test
	public void getHuYa() {
		List<Game> list = DownUtil.getHuYa("http://www.huya.com/g/862", 1);
		for(Game g:list){
			System.out.println(g.getNum());
		}
	}

	@Test
	public void getQuanMing() {
		List<Game> list = DownUtil.getQuanMing("http://www.quanmin.tv/json/categories/csgo/list.json", 1);
		for(Game g:list){
			System.out.println(g.getNum());
		}
	}

	@Test
	public void getHuoMao() {
		List<Game> list = DownUtil
				.getHuoMao("https://www.huomao.com/channels/channel.json?page=1&game_url_rule=dota2", 1);
		for(Game g:list){
			System.out.println(g.getNum());
		}

	}

	@Test
	public void getLongZhu() {
		List<Game> list = DownUtil.getLongZhu("http://longzhu.com/channels/dnf?from=figame", 1);
		System.out.println(list.size());
	}

	@Test
	public void getZhanQi() {
		List<Game> list = DownUtil.getZhanQi("https://www.zhanqi.tv/api/static/v2.1/game/live/115/30/1.json", 1);
		System.out.println(list.size());
	}
	
	@Test
	public void getNum(){
		System.out.println(DownUtil.getNum("2.2万人"));
	}
}
