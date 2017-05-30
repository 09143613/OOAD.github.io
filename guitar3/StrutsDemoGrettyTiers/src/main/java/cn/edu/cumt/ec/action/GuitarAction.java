package cn.edu.cumt.ec.action;


import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.ActionSupport;
import cn.edu.cumt.ec.entity.Builder;
import cn.edu.cumt.ec.entity.Guitar;
import cn.edu.cumt.ec.entity.GuitarSpec;
import cn.edu.cumt.ec.entity.Inventory;
import cn.edu.cumt.ec.entity.Type;
import cn.edu.cumt.ec.entity.Wood;
import cn.edu.cumt.ec.service.GuitarService;
import cn.edu.cumt.ec.service.GuitarServiceJDBCImpl;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class GuitarAction extends ActionSupport{
	GuitarService guitarSearchService=new GuitarServiceJDBCImpl();	 
	@SuppressWarnings("unchecked")
	public String search() throws Exception{			
		    Inventory inventory= guitarSearchService.getInventory();
			List<Guitar> macthingGuitars=inventory.search(new GuitarSpec(builder,model,type,backWood,topWood));
			JSONArray array=new JSONArray();
			for(Guitar g:macthingGuitars){
				 JSONObject json=new JSONObject();
				 json.put("serialNumber",g.getSerialNumber());
				 json.put("price",g.getPrice());
				 json.put("builder",g.getSpec().getBuilder());
				 json.put("model",g.getSpec().getModel());
				 json.put("type",g.getSpec().getType());
				 json.put("backWood",g.getSpec().getBackWood());
				 json.put("topWood",g.getSpec().getTopWood());
				 array.add(json);
		}
		out().print(array);
		out().flush(); 
		out().close();
		return null;
	}
	
	public String add() throws IOException{
		out();
		String message="";
		
		try{
			Guitar guitar=new Guitar(serialNumber,price,new GuitarSpec(builder,model,type,backWood,topWood));
			guitarSearchService.addGuitar(guitar);
			message="Good,add guitar success";
		}
		catch(Exception e){
			message="Sorry,maybe this guitar is bad!";
		}
		out().print(message);
	    out().flush(); 
	    out().close();      
		return null;
	}

	public String delete() throws IOException, SQLException{
		out();
		guitarSearchService.deleteGuitar(serialNumber);
		String message="delete success";
		out().print(message);
		out().flush(); 
		out().close();
		return null;
		
	}
		public PrintWriter out()throws IOException{
			HttpServletResponse response=ServletActionContext.getResponse();  
	        response.setContentType("text/html");  
	        response.setContentType("text/plain; charset=utf-8");
	        PrintWriter out= response.getWriter();
	        return out;
		}
	
	private String serialNumber;
	private double price;
	private Builder builder; 
	private String model;
	private Type type;
	private Wood backWood;
	private Wood topWood;
	public String getSerialNumber() {
		return serialNumber;
	}
	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}

	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}		
	public Builder getBuilder() {
		return builder;
	}
	public void setBuilder(Builder builder) {
		this.builder = builder;
	}
	public Type getType() {
		return type;
	}
	public void setType(Type type) {
		this.type = type;
	}
	public Wood getBackWood() {
		return backWood;
	}
	public void setBackWood(Wood backWood) {
		this.backWood = backWood;
	}
	public Wood getTopWood() {
		return topWood;
	}
	public void setTopWood(Wood topWood) {
		this.topWood = topWood;
	}

}
