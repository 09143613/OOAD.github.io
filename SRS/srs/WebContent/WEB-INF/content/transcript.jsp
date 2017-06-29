<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/easyui/themes/default/easyui.css">   
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/easyui/themes/icon.css">   
<script type="text/javascript" src="${pageContext.request.contextPath}/easyui/jquery.min.js"></script>   
<script type="text/javascript" src="${pageContext.request.contextPath}/easyui/jquery.easyui.min.js"></script>  
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-form.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/json2.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/easyui/locale/easyui-lang-zh_CN.js"></script>
<title>成绩查询</title>
<script>
$(function(){
	 $('#transcript').datagrid({    
		    url:'${pageContext.request.contextPath}/queryTranscript',  
		    fitColumns:true,	
           	fit:true,			
            nowrap:false,
            striped:true,		
			singleSelect:true,	
            height:150,
		    columns:[[    
		        {field:'name',title:'课程名称',width:150,align:'center'},    
		        {field:'grade',title:'成绩',width:150,align:'center'} ,
		        {field:'time',title:'上课时间',width:150,align:'center'} ,
		        {field:'credits',title:'绩点',width:150,align:'center'} 
		    ]]
		}); 
	})
</script>
</head>
<body>
<table id="transcript"></table>
</body>
</html>