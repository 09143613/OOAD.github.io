package cn.edu.cumt.ec.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.edu.cumt.ec.dbutil.DbUtil;

import cn.edu.cumt.ec.entity.Guitar;
public class GuitarDaoJDBCImpl implements GuitarDao{

	@Override
	public List<Guitar> getAllGuitars(String type) {
		// TODO Auto-generated method stub
		ResultSet rs=DbUtil.executeQuery("select * from guitar where type=?",new Object[]{type});
		List<Guitar> guitarsList=new ArrayList<Guitar>();
		try{
			while(rs.next()){
				Guitar guitars = new Guitar();
				
				guitars.setType(rs.getString(1));
				guitars.setBuilder(rs.getString(2));
				guitars.setModel(rs.getString(3));
				guitars.setPrice(rs.getDouble(4));
				guitars.setBackWood(rs.getString(5));
				guitars.setTopWood(rs.getString(6));
				guitars.setSerialNumber(rs.getString(7));
				
				guitarsList.add(guitars);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		return guitarsList;
	}
}
