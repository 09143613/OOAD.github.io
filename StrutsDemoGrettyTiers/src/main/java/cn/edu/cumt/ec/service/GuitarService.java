package cn.edu.cumt.ec.service;
import java.util.List;
import cn.edu.cumt.ec.dao.GuitarDao;
import cn.edu.cumt.ec.dao.GuitarDaoJDBCImpl;
import cn.edu.cumt.ec.entity.Guitar;

public class GuitarService {
	public GuitarService(){
		super();
	}
	private GuitarDao guitarDao=new GuitarDaoJDBCImpl();

	public void setGuitarDao(GuitarDao guitarDao) {
		this.guitarDao = guitarDao;
	}
	public GuitarService(GuitarDao guitarDao){
		this.guitarDao = guitarDao;
	}
	public List<Guitar> getAllGuitars(String type){
		return guitarDao.getAllGuitars(type);
	}
}
