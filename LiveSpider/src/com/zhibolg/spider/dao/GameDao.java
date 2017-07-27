package com.zhibolg.spider.dao;

import java.util.List;


import com.zhibolg.spider.model.Game;

public interface GameDao {
	
	/*
	 * 查询直播间列表
	 */
	public List<Game> findList(Game game);
	
	/*
	 * 批量插入
	 */
	public void add(List<Game> list);
	
	/*
	 * 批量删除
	 */
	public void delete(Game game);
}
