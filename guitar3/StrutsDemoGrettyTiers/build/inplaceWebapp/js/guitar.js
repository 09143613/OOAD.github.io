var builder;
var model;
var type;
var backWood;
var topWood;
$(function() {
	$('#dg').datagrid({       
		pageNumber: 1,
	    url: "${pageContext.request.contextPath}/searchGuitar",
	    rownumbers:true,
	    fitColumns:true,
	    singleSelect:true,
	    height:650,
	    toolbar:[{
					iconCls : 'icon-add',
					text : '增加',
					id:'addtool',
					handler : function() {
							$('#addbtn').show();
							$('#editbtn').hide();
							$('#win').window('open');
						}
					},{
						iconCls : 'icon-remove',
						text : '删除',
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
					},
		 			{
						text:'制作者:<input id="builderInput" name="builderhidden">'	
			 		},	
					{
						text:'类型：<input id="typeInput" name="typehidden">'
					},
					{
						text:'背部材料：<input id="backWoodInput" name="backWoodhidden">'
					},
					{
						text:'顶部材料：<input id="topWoodInput" name="topWoodhidden">'
					}
	 			],
	    columns:[[  
	              {field:'serialNumber',title:'吉他编号',width:100} ,
	              {field:'price',title:'吉他价格',width:100}, 
	              {field:'builder',title:'制作者',width:100},
	              {field:'model',title:'吉他模型',width:100},
	              {field:'type',title:'吉他类型',width:100},
	              {field:'backWood',title:'背部材料',width:100},
	              {field:'topWood',title:'顶部材料',width:100}
	    ]]
	});
	//查询下拉框设置
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
    //增加下拉框设置

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

	//查询函数
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