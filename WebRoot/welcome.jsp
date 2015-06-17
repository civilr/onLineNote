<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!-- 导入Struts 2的标签库 -->
<%@taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta HTTP-EQUIV="pragma" CONTENT="no-cache">
<meta HTTP-EQUIV="Cache-Control" CONTENT="no-cache, must-revalidate">
<meta HTTP-EQUIV="expires" CONTENT="0">
<title>欢迎界面</title>
<link rel="stylesheet" type="text/css" href="ext/resources/css/ext-all.css" />
<script type="text/javascript" src="ext/adapter/ext/ext-base.js"></script>
<script type="text/javascript" src="ext/ext-all.js"></script>
<script type="text/javascript" src="js/common.js"></script>
<script type="text/javascript">
Ext.onReady(function()
{
//查询区内容设置
var queryPanel = new Ext.form.FormPanel({
		labelAlign:	'center',
		layout:'column',
		region:'north',
		border: false,
		title:'笔记添加',
		labelWidth:130,
		frame:true,
		height:600,
		reader:new Ext.data.JsonReader({},[
        {name: 'note_date', type: 'string'},
        {name: 'note_kind', type: 'string'},
        {name: 'note_label', type: 'string'},
        {name: 'note_title', type: 'string'},
        {name: 'note_content', type: 'string'},
	      {name: 'note_remark', type: 'string'},
	      {name: 'note_id', type: 'string'}
    ]),
		items : [{
							columnWidth : 1,
							layout : 'form',
							border : false,
							items : [createFileText("note_date","日期",20,getFomatDate())]
						},
						{
							columnWidth : 1,
							layout : 'form',
							border : false,
							items : [createFileText("note_kind","分类",20)]
						},{
							columnWidth : 1,
							layout : 'form',
							border : false,
							items : [createComboBox('note_label',"标签")]
						},{
							columnWidth : 1,
							layout : 'form',
							border : false,
							items : [createFileText("note_title","题目",200)]
						},{
							columnWidth : 1,
							layout : 'form',
							border : false,
							items : [createHtmlEditor("note_content","笔记内容")]
						},{
							columnWidth : 1,
							layout : 'form',
							border : false,
							items : [createTextArea("note_remark","笔记备注")]
						},{
							columnWidth : 1,
							layout : 'form',
							border : false,
							items : [createHiddenText("note_id",'')]
						}]
		});
//按钮提交
var btn = createSubmitButton('提交','确认提交笔记？','AddNote.action',queryPanel);

//一个panel设置
var onePanel = new Ext.Panel({
		region:'center',
		autoScroll:true,
		items:[queryPanel,btn]
	});

//主内容区域
var mainPanel = new Ext.Panel({
		region:'center',
		title:'笔记信息',
		split:true,
		border:true,
		layout:'border',
		items:[onePanel]
	});

//树形panel
var treePanel = new Ext.Panel({
    contentEl: 'tree',
		autoScroll:true,
		border:false,
		items:[createTree('GetTreeInfoAction.action','选择日期',queryPanel)]
	});
	
//日期区域
var dataPanel = new Ext.Panel({
		region:'west',
		title:'日期',
		split:true,
		border:true,
		items:[treePanel]
	});


//formPanel
var formPanel = new Ext.form.FormPanel({
		layout:'column',
		border: false,
		frame:true,
		items : [{
							columnWidth : 1,
							layout : 'form',
							border : false,
							items : [createFileText("note_serch","内容查询",200)]
						}]
		});

//gridPanel
var gridStore = createStore('GetNodeInfoByContent.action',['note_id','note_title','note_label']);


var serchBtn = createSerchButton('查询',gridStore,formPanel);

var cm = new Ext.grid.ColumnModel([{header:'ID',dataIndex:'note_id',width:60,sortable: true},{header:'题目',dataIndex:'note_title',width:60,sortable: true},{header:'标签',dataIndex:'note_label',width:60,sortable: true}]);

var gridinfoPanel = createGridPanel(gridStore,cm,queryPanel);


//查询panel
var gridPanel = new Ext.Panel({
		autoScroll:true,
		border:false,
		items:[formPanel,serchBtn,gridinfoPanel]
	});
	
	
//查询区域
var serchPanel = new Ext.Panel({
		region:'west',
		title:'内容',
		split:true,
		border:true,
		items:[gridPanel]
	});
//总布局
var viewport = new Ext.Viewport({
layout:'border',
items:[
{region:'north',html:'<p align="center">欢迎使用onLineNote </p><p align="right"><input type="button" value="退出系统" onClick="Logout()"></p>',height:50},
{region:'south',html:'<p align="right">Copyright2015@zhenmei-tech.All Rights Reserved.</p>',height:50},
{region:'east',html:'搜索功能开发中。。。',title:'网页搜索',width:150,split:true,collapsible:true},
{region:'west',layout:'accordion',layoutConfig:{titileCollapse:true,animate:true,activeOnTop:false},items:[dataPanel,serchPanel],title:'分类查看',width:150,split:true,collapsible:true},
mainPanel
]
});

});

//退出
function Logout()
{
     document.forms[0].action = "Logout.action";
     document.forms[0].submit();
}

</script>
</head>
<body>
<form name="form">
<div id="tree"></div>
</form>
</body>
</html>