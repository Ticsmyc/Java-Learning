package com.lc.dao;

import java.util.List;

import com.lc.pojo.Flower;

public interface FlowerDao {
	
	
	/**
	 * 查询全部
	 * @return
	 */
	List<Flower> selAll();
	
	
	/**
	 * 新增
	 * @param flower
	 * @return
	 */
	int insFlower(Flower flower);
	
}
