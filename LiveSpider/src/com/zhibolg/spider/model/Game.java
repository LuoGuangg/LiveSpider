package com.zhibolg.spider.model;

public class Game {
	private int id;
	private String name; // 主播名称
	private String title; // 直播间标题
	private String url; // 直播地址
	private String img; // 封面图片地址
	private int num; // 当前人气
	private int index; // 游戏分类

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	@Override
	public String toString() {
		return "GameEntity [id=" + id + ", name=" + name + ", title=" + title + ", url=" + url + ", img=" + img
				+ ", num=" + num + ", index=" + index + "]";
	}
}
