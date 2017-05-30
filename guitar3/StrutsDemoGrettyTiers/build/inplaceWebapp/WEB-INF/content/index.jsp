<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>guitar room</title>
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
	    url: "${pageContext.request.contextPath}/searchGuitar",
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
					},
					{
						iconCls : 'icon-add',
						text : 'add',
						id:'addtool',
						handler : function() {
								$('#addbtn').show();
								$('#editbtn').hide();
								$('#win').window('open');
							}
						},{
							iconCls : 'icon-remove',
							text : 'delete',
							id:'deletetool',
							handler : function() {
									var row = $('#dg').datagrid('getSelected');
									if (row) {
										$.messager.confirm('选择是否删除','您确定要删除该吉他吗?',function(fn) {
											if(fn==true){
												$.post('${pageContext.request.contextPath}/deleteGuitar',{serialNumber:row.serialNumber},function(message){
													$.messager.alert('提示',message); 
													$('#dg').datagrid('reload');
												});
											}
										});
									} 
									else {
										$.messager.alert('提示','请先选择要删除的行');
									}
							}
						}
	 			],
	 			frozenColumns: [[
	 		                    { field: 'ck', checkbox: true }
	 		                    //,{ title: 'ID', field: 'ID', width: 80, sortable: true }
	 		                ]],
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

    $('#builderName').combobox({    
        url:'${pageContext.request.contextPath}/json/builder.json',    
        valueField:'id',    
        textField:'text'
    });
    $('#typeName').combobox({    
        url:'${pageContext.request.contextPath}/json/type.json',    
        valueField:'id',    
        textField:'text'
    });
    $('#backWoodName').combobox({    
        url:'${pageContext.request.contextPath}/json/wood.json',    
        valueField:'id',    
        textField:'text'
    });
    $('#topWoodName').combobox({    
        url:'${pageContext.request.contextPath}/json/wood.json',    
        valueField:'id',    
        textField:'text'
    });
    $('#addbtn').bind('click', function(){    
		$('#form').form('submit', {
			url:"${pageContext.request.contextPath}/addGuitar",
			success: function(message){
				$.messager.alert('提示',message); 
				$('#dg').datagrid('reload');
				$('#win').window('close');
				$('#form').form('reset');
			}
		});
    });

})
	function query(){
		$('#dg').datagrid('options').url='${pageContext.request.contextPath}/searchGuitar';
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
	
	<div id="win" class="easyui-window" title="add guitar" closed="true" style="width: 500px; height: 400px; padding: 5px;">
		<br />
	 <div style="padding: 20px 40px 40px 80px;">
		<form id="form" method="post">
			<div style="margin-left: 10px;">
				<div id="dlg-buttons" style="text-align:center">
					 <table cellpadding="3" style="text-align:center;">
	        		<tr>
	        			<td style="color:red">*</td>
	              		<td>serialNumber:</td>
	              		<td><input id="serialNumber" name="serialNumber" type="text" class="txt01" /></td>
	            	</tr>
	        		<tr>
	        			<td style="color:red">*</td>
	             		<td>builder：</td>
	              		<td><input id="builderName" name="builder" type="text" class="txt01" /></td>
	            	</tr>
	            	<tr>
	             		<td style="color:red">*</td>
	             		<td>model：</td>
	              		<td><input id="modelName" name="model" type="text" class="txt01" /></td>
	            	</tr>
	            	<tr>
	             		<td style="color:red">*</td>
	             		<td>type：</td>
	              		<td><input id="typeName" name="type" type="text" class="txt01" /></td>
	            	</tr>
	            	<tr>
	             		<td style="color:red">*</td>
	             		<td>backWood：</td>
	              		<td><input id="backWoodName" name="backWood" type="text" class="txt01" /></td>
	            	</tr>
	            	<tr>
	             		<td style="color:red">*</td>
	             		<td>topWood：</td>
	              		<td><input id="topWoodName" name="topWood" type="text" class="txt01" /></td>
	            	</tr>
	            	
	      		</table>					
					 
					 </br></br>
					 <a id="addbtn" class="easyui-linkbutton" iconCls="icon-ok" >确认添加</a>
			</div>
			</div>
			
		</form>
		</div>
	</div>
</body>
</html>