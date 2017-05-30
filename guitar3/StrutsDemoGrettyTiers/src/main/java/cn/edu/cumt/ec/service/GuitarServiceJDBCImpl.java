package cn.edu.cumt.ec.service;

import java.sql.SQLException;
import java.util.List;

import cn.edu.cumt.ec.dao.DataAccess;
import cn.edu.cumt.ec.dao.GuitarDao;
import cn.edu.cumt.ec.entity.Guitar;
import cn.edu.cumt.ec.entity.Inventory;
import cn.edu.cumt.ec.entity.Type;


public class GuitarServiceJDBCImpl implements GuitarService{
	GuitarDao guitarDao=DataAccess.CreateGuitarDao();
	public Inventory getInventory() throws SQLException { 
		Inventory inventory=new Inventory();
		List<Guitar> list=guitarDao.getAllGuitars();
		for(Guitar g:list){
			inventory.addGuitar(g.getSerialNumber(),g.getPrice(),g.getSpec());
		}
		return inventory;
	}
	 public void addGuitar(Guitar guitar) throws SQLException {
		 guitarDao.addGuitar(guitar);
	 }
	 
	 public void deleteGuitar(String serialNumber ) throws SQLException{
		 guitarDao.deleteGuitar(serialNumber );
	 }

	
}
