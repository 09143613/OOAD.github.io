package cn.edu.cumt.ec.service;

import java.util.List;

import cn.edu.cumt.ec.dao.GuitarDao;
import cn.edu.cumt.ec.entity.Guitar;
import cn.edu.cumt.ec.entity.Type;


public class GuitarServiceJDBCImpl implements GuitarService{
	private GuitarDao guitarDao;
	@Override
	public void setGuitarDao(GuitarDao guitarDao) {
		// TODO Auto-generated method stub
		this.guitarDao =guitarDao;
	}

	@Override
	public List<Guitar> getAllGuitars() {
		// TODO Auto-generated method stub
		return guitarDao.getAllGuitars();
	}

	
}
