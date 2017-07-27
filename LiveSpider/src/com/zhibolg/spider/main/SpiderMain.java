package com.zhibolg.spider.main;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.TimerTask;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import com.zhibolg.spider.model.Game;
import com.zhibolg.spider.service.GameService;
import com.zhibolg.spider.util.DownUtil;

public class SpiderMain {

	public static void main(String[] args) {
		Time.time();
	}

	public static class Time {
		public static int DOTA = 1;
		public static int LOL = 2;
		public static int DNF = 3;
		public static int CS = 4;
		public static int LUSHI = 5;
		public static int SHOUWANG = 6;
		public static int MEINV = 7;
		public static int ZHUJI = 8;
		public static int JUEDI = 9;
		
		public static void time() {
			final TimerTask dota = new TimerTask() {

				@Override
				public void run() {
					try {
						GameService gameService = GameService.getService();
						
						List<Game> gameList = new ArrayList<>();
						gameList.addAll(DownUtil.getDouYu("https://www.douyu.com/directory/game/DOTA2",DOTA));
						gameList.addAll(DownUtil.getZhanQi("https://www.zhanqi.tv/api/static/v2.1/game/live/10/30/1.json",DOTA));
						gameList.addAll(DownUtil.getHuYa("http://www.huya.com/g/7",DOTA));
						gameList.addAll(DownUtil.getPanda("http://www.panda.tv/cate/dota2",DOTA));
						gameList.addAll(DownUtil.getHuoMao("https://www.huomao.com/channels/channel.json?page=1&page_size=120&game_url_rule=dota2",DOTA));
						gameList.addAll(DownUtil.getLongZhu("http://longzhu.com/channels/dota2",DOTA));
						gameList.addAll(DownUtil.getQuanMing("http://www.quanmin.tv/json/categories/dota2/list.json",DOTA));
						
						//删除数据库中直播列表
						Game game = new Game();
						game.setIndex(DOTA);
						gameService.delete(game);
						
						//插入新数据
						gameService.add(gameList);
					} catch (Exception e) {
						System.out.println(e);
					}
				}
			};
			
			final TimerTask lol = new TimerTask() {

				@Override
				public void run() {
					try {
						GameService gameService = GameService.getService();
						
						List<Game> gameList = new ArrayList<>();
						gameList.addAll(DownUtil.getDouYu("https://www.douyu.com/directory/game/LOL",LOL));
						gameList.addAll(DownUtil.getZhanQi("https://www.zhanqi.tv/api/static/v2.1/game/live/6/30/1.json",LOL));
						gameList.addAll(DownUtil.getHuYa("http://www.huya.com/g/lol",LOL));
						gameList.addAll(DownUtil.getPanda("https://www.panda.tv/cate/lol",LOL));
						gameList.addAll(DownUtil.getHuoMao("https://www.huomao.com/channels/channel.json?page=1&game_url_rule=lol",LOL));
						gameList.addAll(DownUtil.getLongZhu("http://longzhu.com/channels/lol?from=figame",LOL));
						gameList.addAll(DownUtil.getQuanMing("http://www.quanmin.tv/json/categories/lol/list.json",LOL));
						
						//删除数据库中直播列表
						Game game = new Game();
						game.setIndex(LOL);
						gameService.delete(game);
						
						//插入新数据
						gameService.add(gameList);
					} catch (Exception e) {
						System.out.println(e);
					}
				}
			};
			

			final TimerTask dnf = new TimerTask() {

				@Override
				public void run() {
					try {
						GameService gameService = GameService.getService();
						
						List<Game> gameList = new ArrayList<>();
						gameList.addAll(DownUtil.getDouYu("https://www.douyu.com/directory/game/DNF",DNF));
						gameList.addAll(DownUtil.getZhanQi("https://www.zhanqi.tv/api/static/v2.1/game/live/22/30/1.json",DNF));
						gameList.addAll(DownUtil.getHuYa("http://www.huya.com/g/dnf",DNF));
						gameList.addAll(DownUtil.getPanda("https://www.panda.tv/cate/dnf",DNF));
						gameList.addAll(DownUtil.getHuoMao("https://www.huomao.com/channels/channel.json?page=1&game_url_rule=dnf",DNF));
						gameList.addAll(DownUtil.getLongZhu("http://longzhu.com/channels/dnf?from=figame",DNF));
						gameList.addAll(DownUtil.getQuanMing("http://www.quanmin.tv/json/categories/dnf/list.json",DNF));
						
						//删除数据库中直播列表
						Game game = new Game();
						game.setIndex(DNF);
						gameService.delete(game);
						
						//插入新数据
						gameService.add(gameList);
					} catch (Exception e) {
						System.out.println(e);
					}
				}
			};
			

			final TimerTask cs = new TimerTask() {

				@Override
				public void run() {
					try {
						GameService gameService = GameService.getService();
						
						List<Game> gameList = new ArrayList<>();
						gameList.addAll(DownUtil.getDouYu("https://www.douyu.com/directory/game/cs",CS));
						gameList.addAll(DownUtil.getHuYa("http://www.huya.com/g/cs",CS));
						gameList.addAll(DownUtil.getPanda("https://www.panda.tv/cate/csgo",CS));
						gameList.addAll(DownUtil.getHuoMao("https://www.huomao.com/channels/channel.json?page=1&game_url_rule=CSGO",CS));
						gameList.addAll(DownUtil.getLongZhu("http://longzhu.com/channels/csgo",CS));
						gameList.addAll(DownUtil.getQuanMing("http://www.quanmin.tv/json/categories/csgo/list.json",CS));
						
						//删除数据库中直播列表
						Game game = new Game();
						game.setIndex(CS);
						gameService.delete(game);
						
						//插入新数据
						gameService.add(gameList);
					} catch (Exception e) {
						System.out.println(e);
					}
				}
			};


			final TimerTask luShi = new TimerTask() {

				@Override
				public void run() {
					try {
						GameService gameService = GameService.getService();
						
						List<Game> gameList = new ArrayList<>();
						gameList.addAll(DownUtil.getDouYu("https://www.douyu.com/directory/game/How",LUSHI));
						gameList.addAll(DownUtil.getZhanQi("https://www.zhanqi.tv/api/static/v2.1/game/live/9/30/1.json",LUSHI));
						gameList.addAll(DownUtil.getHuYa("http://www.huya.com/g/393",LUSHI));
						gameList.addAll(DownUtil.getPanda("http://www.panda.tv/cate/hearthstone",LUSHI));
						gameList.addAll(DownUtil.getQuanMing("http://www.quanmin.tv/json/categories/hearthstone/list.json",LUSHI));
						
						//删除数据库中直播列表
						Game game = new Game();
						game.setIndex(LUSHI);
						gameService.delete(game);
						
						//插入新数据
						gameService.add(gameList);
					} catch (Exception e) {
						System.out.println(e);
					}
				}
			};
			
			

			final TimerTask shouWang = new TimerTask() {

				@Override
				public void run() {
					try {
						GameService gameService = GameService.getService();
						
						List<Game> gameList = new ArrayList<>();
						gameList.addAll(DownUtil.getDouYu("https://www.douyu.com/directory/game/Overwatch",SHOUWANG));
						gameList.addAll(DownUtil.getZhanQi("https://www.zhanqi.tv/api/static/v2.1/game/live/82/30/1.json",SHOUWANG));
						gameList.addAll(DownUtil.getHuYa("http://www.huya.com/g/2174",SHOUWANG));
						gameList.addAll(DownUtil.getPanda("http://www.panda.tv/cate/overwatch",SHOUWANG));
						gameList.addAll(DownUtil.getHuoMao("https://www.huomao.com/channels/channel.json?page=1&page_size=120&game_url_rule=Overwatch",SHOUWANG));
						gameList.addAll(DownUtil.getLongZhu("http://longzhu.com/channels/ow?from=left",SHOUWANG));
						gameList.addAll(DownUtil.getQuanMing("http://www.quanmin.tv/json/categories/overwatch/list.json",SHOUWANG));
						
						//删除数据库中直播列表
						Game game = new Game();
						game.setIndex(SHOUWANG);
						gameService.delete(game);
						
						//插入新数据
						gameService.add(gameList);
					} catch (Exception e) {
						System.out.println(e);
					}
				}
			};
			

			final TimerTask meiNv = new TimerTask() {

				@Override
				public void run() {
					try {
						GameService gameService = GameService.getService();
						
						List<Game> gameList = new ArrayList<>();
						gameList.addAll(DownUtil.getDouYu("https://www.douyu.com/directory/game/yz",MEINV));
						gameList.addAll(DownUtil.getDouYu("https://www.douyu.com/directory/game/xx",MEINV));
						gameList.addAll(DownUtil.getDouYu("https://www.douyu.com/directory/game/ecy",MEINV));
						gameList.addAll(DownUtil.getZhanQi("https://www.zhanqi.tv/api/static/v2.1/game/live/65/30/1.json",MEINV));
						gameList.addAll(DownUtil.getHuYa("http://www.huya.com/g/xingxiu",MEINV));
						gameList.addAll(DownUtil.getPanda("https://www.panda.tv/cate/yzdr",MEINV));
						gameList.addAll(DownUtil.getHuoMao("https://www.huomao.com/channels/channel.json?page=1&game_url_rule=ylxx",MEINV));
						gameList.addAll(DownUtil.getLongZhu("http://longzhu.com/channels/hwzb?from=figame",MEINV));
//						gameList.addAll(DownUtil.getQuanMing("http://www.quanmin.tv/json/categories/overwatch/list.json",MEINV));
						
						//删除数据库中直播列表
						Game game = new Game();
						game.setIndex(MEINV);
						gameService.delete(game);
						
						//插入新数据
						gameService.add(gameList);
					} catch (Exception e) {
						System.out.println(e);
					}
				}
			};
			

			final TimerTask zhuJi = new TimerTask() {

				@Override
				public void run() {
					try {
						GameService gameService = GameService.getService();
						
						List<Game> gameList = new ArrayList<>();
						gameList.addAll(DownUtil.getDouYu("https://www.douyu.com/directory/game/TVgame",ZHUJI));
						gameList.addAll(DownUtil.getHuYa("http://www.huya.com/g/1964",ZHUJI));
						gameList.addAll(DownUtil.getPanda("http://www.panda.tv/cate/zhuji",ZHUJI));
						gameList.addAll(DownUtil.getLongZhu("http://longzhu.com/channels/djzjjj?from=left",ZHUJI));
						gameList.addAll(DownUtil.getQuanMing("http://www.quanmin.tv/json/categories/tvgame/list.json",ZHUJI));
						
						//删除数据库中直播列表
						Game game = new Game();
						game.setIndex(ZHUJI);
						gameService.delete(game);
						
						//插入新数据
						gameService.add(gameList);
					} catch (Exception e) {
						System.out.println(e);
					}
				}
			};
			
			

			final TimerTask jueDi = new TimerTask() {

				@Override
				public void run() {
					try {
						GameService gameService = GameService.getService();
						
						List<Game> gameList = new ArrayList<>();
						gameList.addAll(DownUtil.getDouYu("https://www.douyu.com/directory/game/jdqs",JUEDI));
						gameList.addAll(DownUtil.getDouYu("https://www.douyu.com/directory/game/TSQS",JUEDI));
						gameList.addAll(DownUtil.getZhanQi("https://www.zhanqi.tv/api/static/v2.1/game/live/106/30/1.json",JUEDI));
						gameList.addAll(DownUtil.getHuYa("http://www.huya.com/g/2793",JUEDI));
						gameList.addAll(DownUtil.getHuYa("http://www.huya.com/g/1902",JUEDI));
						gameList.addAll(DownUtil.getPanda("https://www.panda.tv/cate/pubg",JUEDI));
						gameList.addAll(DownUtil.getPanda("https://www.panda.tv/cate/ttts",JUEDI));
						gameList.addAll(DownUtil.getHuoMao("https://www.huomao.com/channels/channel.json?page=1&game_url_rule=battlegrounds",JUEDI));
						gameList.addAll(DownUtil.getLongZhu("http://longzhu.com/channels/h1z1",JUEDI));
						gameList.addAll(DownUtil.getLongZhu("http://longzhu.com/channels/jdqs?from=left",JUEDI));
						gameList.addAll(DownUtil.getQuanMing("http://www.quanmin.tv/json/categories/sanbingzhiwang/list.json",JUEDI));
						
						//删除数据库中直播列表
						Game game = new Game();
						game.setIndex(JUEDI);
						gameService.delete(game);
						
						//插入新数据
						gameService.add(gameList);
					} catch (Exception e) {
						System.out.println(e);
					}
				}
			};
			

			

			ScheduledExecutorService pool = Executors.newScheduledThreadPool(16);
			pool.scheduleAtFixedRate(dota, 0, 200000, TimeUnit.MILLISECONDS);
			pool.scheduleAtFixedRate(lol, 0, 200000, TimeUnit.MILLISECONDS);
			pool.scheduleAtFixedRate(dnf, 0, 200000, TimeUnit.MILLISECONDS);
			pool.scheduleAtFixedRate(cs, 0, 200000, TimeUnit.MILLISECONDS);
			pool.scheduleAtFixedRate(luShi, 0, 200000, TimeUnit.MILLISECONDS);
			pool.scheduleAtFixedRate(shouWang, 0, 200000, TimeUnit.MILLISECONDS);
			pool.scheduleAtFixedRate(meiNv, 0, 200000, TimeUnit.MILLISECONDS);
			pool.scheduleAtFixedRate(zhuJi, 0, 200000, TimeUnit.MILLISECONDS);
			pool.scheduleAtFixedRate(jueDi, 0, 200000, TimeUnit.MILLISECONDS);

		}
	}
}
