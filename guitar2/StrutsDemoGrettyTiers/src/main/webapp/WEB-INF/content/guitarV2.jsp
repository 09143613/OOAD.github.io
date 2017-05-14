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
						text:'Builder:<input id="input1" name="hidden1">'	
			 		},	
					{
						text:'Type：<input id="input2" name="hidden2">'
					},
					{
						text:'backWood：<input id="input3" name="hidden3">'
					},
					{
						text:'topWood：<input id="input4" name="hidden4">'
					}
	 			],
	 			
	    columns:[[ 
				  {field:'serialNumber',title:'serialNumber',width:50} ,
				  {field:'price',title:'price',width:50}, 
				  {field:'builder',title:'builder',width:50},
	              {field:'model',title:'model',width:50},
	              {field:'type',title:'type',width:50},
	              {field:'backWood',title:'backWood',width:50},	              
	              {field:'topWood',title:'topWood',width:50}
	    ]]
	});

    $('#input1').combobox({    
        url:'${pageContext.request.contextPath}/json/builder.json', 
        width:90,
        valueField:'id',    
        textField:'text',
        onSelect: function(){
        	builder=$('#input1').combobox('getValue');
        	query();
		}
    });
    $('#input2').combobox({    
        url:'${pageContext.request.contextPath}/json/type.json',    
        width:90,
        valueField:'id',    
        textField:'text',
        onSelect: function(){
        	type=$('#input2').combobox('getValue');
        	query();
		}
    });
    $('#input3').combobox({    
        url:'${pageContext.request.contextPath}/json/wood.json', 
        width:90,   
        valueField:'id',    
        textField:'text',
        onSelect: function(){
        	backWood=$('#input3').combobox('getValue');
        	query();
		}
    });
    $('#input4').combobox({    
        url:'${pageContext.request.contextPath}/json/wood.json', 
        width:90,   
        valueField:'id',    
        textField:'text',
        onSelect: function(){
        	topWood=$('#input4').combobox('getValue');
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
	<input id="hidden1" type="hidden">
	<input id="hidden2" type="hidden">
	<input id="hidden3" type="hidden">
	<input id="hidden4" type="hidden">
	<table id="dg"></table>
</body>
</html>