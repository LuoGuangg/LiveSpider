package com.zhibolg.spider.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.zhibolg.spider.dao.GameDao;
import com.zhibolg.spider.model.Game;
import com.zhibolg.spider.util.MyBatisUtil;

public class GameService implements GameDao {

	private String myBatis = "com.zhibolg.spider.dao.GameDao.";
	
	private static GameService gameService = new GameService();
	private GameService() {
	}
	
	public static GameService getService(){
		return gameService;
	}

	@Override
	public List<Game> findList(Game game) {
		List<Game> list = new ArrayList<>();
		SqlSession session = MyBatisUtil.getSqlSession().openSession();
		String s = myBatis+"findList";
		list = session.selectList(s, game);
		session.close();
		return list;
	}

	@Override
	public void add(List<Game> list) {
		SqlSession session = MyBatisUtil.getSqlSession().openSession();
		String s = myBatis+"add";
		session.insert(s,list);
		
		//提交事务
		session.commit();
		session.close();
	}

	@Override
	public void delete(Game game) {
		SqlSession session = MyBatisUtil.getSqlSession().openSession();
		String s = myBatis+"delete";
		session.insert(s,game);
		
		//提交事务
		session.commit();
		session.close();
	}
}
