package com.zhibolg.spider.test;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.zhibolg.spider.model.Game;
import com.zhibolg.spider.service.GameService;
import com.zhibolg.spider.util.MyBatisUtil;

public class TestGameService {
	private GameService gameService = GameService.getService();

	@Test
	public void findlist() throws IOException {
		Game game = new Game();
		List<Game> list = gameService.findList(game);
		System.out.println(list.size());
	}
	
	@Test
	public void add(){
		List<Game> list = new ArrayList<>();
		Game game = new Game();
		game.setImg("1");
		game.setIndex(1);
		game.setName("1");
		game.setNum(1);
		game.setTitle("1");
		game.setUrl("1");
		list.add(game);
		list.add(game);
		list.add(game);
		list.add(game);
		list.add(game);
		list.add(game);
		list.add(game);
		list.add(game);
		gameService.add(list);
	}
	
	@Test
	public void delete(){
		Game game = new Game();
		gameService.delete(game);
	}
}
