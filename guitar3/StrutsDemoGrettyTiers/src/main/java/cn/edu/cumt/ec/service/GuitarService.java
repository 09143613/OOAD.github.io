package cn.edu.cumt.ec.service;
import java.sql.SQLException;
import java.util.List;
import cn.edu.cumt.ec.dao.GuitarDao;
import cn.edu.cumt.ec.entity.Guitar;
import cn.edu.cumt.ec.entity.Inventory;
import cn.edu.cumt.ec.entity.Type;


public interface GuitarService {
//	public GuitarService(){
//		super();
//	}
//	private GuitarDao guitarDao=new GuitarDaoJDBCImpl();
//
	public Inventory getInventory() throws SQLException;
	public void addGuitar(Guitar guitar) throws SQLException;
	public void deleteGuitar(String serialNumber) throws SQLException;
	
}
