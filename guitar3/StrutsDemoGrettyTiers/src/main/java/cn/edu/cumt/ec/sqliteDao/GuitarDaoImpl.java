package cn.edu.cumt.ec.sqliteDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import cn.edu.cumt.ec.dao.GuitarDao;
import cn.edu.cumt.ec.dbutil.DbUtil;
import cn.edu.cumt.ec.entity.Builder;
import cn.edu.cumt.ec.entity.Guitar;
import cn.edu.cumt.ec.entity.GuitarSpec;
import cn.edu.cumt.ec.entity.Type;
import cn.edu.cumt.ec.entity.Wood;



public class GuitarDaoImpl implements GuitarDao{
	@Override
	public List<Guitar> getAllGuitars() throws SQLException {
		Connection Conn = DbUtil.getSqliteConnection();
		String sql = "select * from guitar";
		List<Guitar> guitars = new LinkedList<Guitar>();		
		PreparedStatement pstmt =(PreparedStatement) Conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();		
		while(rs.next()){
			GuitarSpec guitarSpec=new GuitarSpec(Builder.valueOf(rs.getString(3)),
							rs.getString(4),Type.valueOf(rs.getString(5)),
							Wood.valueOf(rs.getString(6)),Wood.valueOf(rs.getString(7)));
			Guitar guitar = new Guitar(rs.getString(1),rs.getDouble(2),guitarSpec);
			guitars.add(guitar);
		}
		if(rs != null){
				rs.close();
			}
		
		pstmt.close();
		Conn.close();
		return guitars;
	}
	@Override
	public void addGuitar(Guitar guitar) throws SQLException {
		Connection Conn = DbUtil.getSqliteConnection();
		String sql = "INSERT INTO guitar (seriaNumber,price,builder,model,type,backWood,topWood) VALUES ("+guitar.getSerialNumber()+","+guitar.getPrice()+",'"+guitar.getSpec().getBuilder().toString()+"','"+guitar.getSpec().getModel().toString()+"','"+guitar.getSpec().getType().toString()+"','"+guitar.getSpec().getBackWood().toString()+"','"+guitar.getSpec().getTopWood().toString()+"')";
		PreparedStatement stmt = Conn.prepareStatement(sql);
		stmt.executeUpdate();	
		
		stmt.close();
		Conn.close();
		
	}
	@Override
	public void deleteGuitar(String serialNumber ) throws SQLException {
		Connection Conn = DbUtil.getSqliteConnection();	
		String sql = "DELETE FROM guitar WHERE seriaNumber="+serialNumber;
		PreparedStatement stmt = Conn.prepareStatement(sql);
		stmt.executeUpdate();	
		stmt.close();
		Conn.close();
		
	}

}
