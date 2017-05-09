package cn.edu.cumt.ec.dao;

import java.util.List;

import cn.edu.cumt.ec.entity.Guitar;

public interface GuitarDao {
	public List<Guitar> getAllGuitars(String type);

}
