<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>

<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />


<link href="style/bootstrap.min.css" type="text/css" rel="stylesheet"/>
<!--js-->
<script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
<script type="text/javascript" src="js/jquery-2.2.3.min.js" language="javascript"></script>
<script type="text/javascript" src="js/demo.js" language="javascript"></script>
<title>guitar store</title>

</head>

<body>
   <form method="post" Action="getAllGuitars">		    	
		
		     <table id="cartTable" class="table table-border" >
			    <thead>
			      <tr>			      			         
			        <th width="100px">Builder：
			          <form role="form">
					    <select class="form-control">
					        
					      <option>FENDER</option>
					      <option>MARTIN</option>
					      <option>GIBSON</option>
					      <option>COLLINGS</option>
					      <option>OLSON</option>
					      <option>RYAN</option>
					      <option>PRS</option>
					      <option>ANY</option>
					    </select>
					 </form>
				   </th>
				   <th width="100px">Type：
			          <form role="form">
					    <select class="form-control">   
					      <option>ACOUSTIC</option>
					      <option>ELECTRIC</option>					      
					    </select>
					 </form>
				   </th>
				   <th width="100px">BackWood：
			          <form role="form">
					    <select class="form-control">   
					      <option>INDIAN_ROSEWOOD</option>
					      <option>BRAZILIAN_ROSEWOOD</option>
					      <option>MAHOGANY</option>
					      <option>MAPLE</option>
					      <option>COCOBOLO</option>
					      <option>CEDAR</option>
					      <option>ADIRONDACK</option>
					      <option>ALDER</option>
					      <option>SITKA</option>
					    </select>
					 </form>
				   </th>
				   <th width="100px">TopWood：
			          <form role="form">
					    <select class="form-control">   
					      <option>INDIAN_ROSEWOOD</option>
					      <option>BRAZILIAN_ROSEWOOD</option>
					      <option>MAHOGANY</option>
					      <option>MAPLE</option>
					      <option>COCOBOLO</option>
					      <option>CEDAR</option>
					      <option>ADIRONDACK</option>
					      <option>ALDER</option>
					      <option>SITKA</option>
					    </select>					   		
					 </form>
				  <th width="100px">
				    <input class="btn btn-default" type="submit" value="提交">
				  </th>  
				   </th>
				   	 	   				   			     			      
			      </tr>
			      

			    </thead>
			    <tr>
			    	<th width="100px">SerialNumber</th>			    	
			        <th width="100px">Price</th>
			        <th width="100px">Builder</th>
			        <th width="100px">Model</th>
			        <th width="100px">Type</th>

			        <th width="100px">BackWood</th>

			        <th width="100px">TopWood</th>

			        
			      </tr>

			    <tbody>			   			    

			     <s:iterator value="#request.macthingGuitars" id="cart">			        			      

			      <tr>			        

			        <td> <span><s:property value="#cart.serialNumber"></s:property></span></td>			        
			        <td><s:property value="#cart.price"></s:property></td>
			        <td><s:property value="#cart.builder"></s:property></td>
			        <td><s:property value="#cart.model"></s:property></td>
			        <td><s:property value="#cart.type"></s:property></td>			         
			         <td><s:property value="#cart.backWood"></s:property></td>

			         <td><s:property value="#cart.topWood"></s:property></td>

			       

			        

			      </tr>

			    </s:iterator>

			    

			    </tbody>

			  </table>

		    </form>


<!--jquery-->
<script type="text/javascript" src="js/jquery-2.2.3.min.js" language="javascript"></script>
<script src="js/bootstrap.min.js"></script>

</body>
</html>
    