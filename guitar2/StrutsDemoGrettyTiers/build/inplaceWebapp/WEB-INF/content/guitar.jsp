<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>guitar store</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/easyui/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/easyui/themes/icon.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/easyui/jquery.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/easyui/jquery.easyui.mobile.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/easyui/easyloader.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/easyui/locale/easyui-lang-zh_CN.js"></script>
<script>
//全局变量
var builder=null;
var model=null;
var type=null;
var backWood=null;
var topWood=null;
$(function() {
	$('#dg').datagrid({       
		pageNumber: 1,
	    url: "${pageContext.request.contextPath}/getAllGuitars",
	    rownumbers:true,
	    fitColumns:true,
	    singleSelect:true,
	    height:650,
	    toolbar:[
		 			{
						text:'Builder:<input id="builderInput" name="builderhidden">'	
			 		},	
					{
						text:'Type：<input id="typeInput" name="typehidden">'
					},
					{
						text:'backWood：<input id="backWoodInput" name="backWoodhidden">'
					},
					{
						text:'topWood：<input id="topWoodInput" name="topWoodhidden">'
					}
	 			],
	 			
	    columns:[[  
	              {field:'serialNumber',title:'serialNumber',width:100} ,
	              {field:'price',title:'price',width:100}, 
	              {field:'builder',title:'builder',width:100},
	              {field:'model',title:'model',width:100},
	              {field:'type',title:'type',width:100},
	              {field:'backWood',title:'backWood',width:100},
	              {field:'topWood',title:'topWood',width:100}
	    ]]
	});

    $('#builderInput').combobox({    
        url:'${pageContext.request.contextPath}/json/builder.json',    
        valueField:'id',    
        textField:'text',
        onSelect: function(){
        	builder=$('#builderInput').combobox('getValue');
        	query();
		}
    });
    $('#typeInput').combobox({    
        url:'${pageContext.request.contextPath}/json/type.json',    
        valueField:'id',    
        textField:'text',
        onSelect: function(){
        	type=$('#typeInput').combobox('getValue');
        	query();
		}
    });
    $('#backWoodInput').combobox({    
        url:'${pageContext.request.contextPath}/json/wood.json',    
        valueField:'id',    
        textField:'text',
        onSelect: function(){
        	backWood=$('#backWoodInput').combobox('getValue');
        	query();
		}
    });
    $('#topWoodInput').combobox({    
        url:'${pageContext.request.contextPath}/json/wood.json',    
        valueField:'id',    
        textField:'text',
        onSelect: function(){
        	topWood=$('#topWoodInput').combobox('getValue');
        	query();
		}
    });

})

	function query(){
		$('#dg').datagrid('options').url='${pageContext.request.contextPath}/getAllGuitars';
		$('#dg').datagrid('load',{
			builder:builder,
			type:type,
			backWood:backWood,
			model:"Stratocastor",
			topWood:topWood
		});
	}
</script>
</head>
<body>
	<input id="builderhidden" type="hidden">
	<input id="typehidden" type="hidden">
	<input id="backWoodhidden" type="hidden">
	<input id="topWoodhidden" type="hidden">
	<table id="dg"></table>
</body>
</html>