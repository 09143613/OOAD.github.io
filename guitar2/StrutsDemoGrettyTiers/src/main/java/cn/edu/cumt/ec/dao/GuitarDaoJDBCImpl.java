package cn.edu.cumt.ec.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.edu.cumt.ec.dbutil.DbUtil;
import cn.edu.cumt.ec.entity.Builder;
import cn.edu.cumt.ec.entity.Guitar;
import cn.edu.cumt.ec.entity.GuitarSpec;
import cn.edu.cumt.ec.entity.Type;
import cn.edu.cumt.ec.entity.Wood;
public class GuitarDaoJDBCImpl implements GuitarDao{

	@Override
	public List<Guitar> getAllGuitars() {
		// TODO Auto-generated method stub
		ResultSet rs=DbUtil.executeQuery("select * from guitar",new Object[]{});
		List<Guitar> guitarsList=new ArrayList<Guitar>();
		try{
			while(rs.next()){
				GuitarSpec spec = new GuitarSpec(Builder.valueOf(rs.getString(3)),
						                        rs.getString(4),Type.valueOf(rs.getString(5)),
						                        Wood.valueOf(rs.getString(6)),Wood.valueOf(rs.getString(7)));
				
//				guitars.setType(rs.getString(1));
//				guitars.setBuilder(rs.getString(2));
//				guitars.setModel(rs.getString(3));
//				guitars.setPrice(rs.getDouble(4));
//				guitars.setBackWood(rs.getString(5));
//				guitars.setTopWood(rs.getString(6));
//				guitars.setSerialNumber(rs.getString(7));
				Guitar guitar = new Guitar(rs.getString(1),rs.getDouble(2),spec);
				guitarsList.add(guitar);
				
		
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		return guitarsList;
	}
}
