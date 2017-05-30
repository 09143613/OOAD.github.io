package cn.edu.cumt.ec.dao;

import java.sql.SQLException;
import java.util.List;

import cn.edu.cumt.ec.entity.Guitar;

public interface GuitarDao {
	 List<Guitar> getAllGuitars()throws SQLException;
	 public void addGuitar(Guitar guitar) throws SQLException;
	 public void deleteGuitar(String serialNumber) throws SQLException;

}
