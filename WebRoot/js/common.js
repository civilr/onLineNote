/*-----------创建函数start------------------*/

//定义文本框
function createFileText(v_id,v_filelabel,v_maxlength,v_emptyText){
var tField = new Ext.form.TextField({
fieldLabel:v_filelabel,
id:v_id,
maxLength:v_maxlength,
allowBlank:false,
emptyText:v_emptyText
});
return tField;
};

//定义下拉框
function createComboBox(v_enumfield,v_fieldLable){
var store = new Ext.data.Store({
		proxy: new Ext.data.HttpProxy({url:'GetEnumAction.action'}),
        reader: new Ext.data.ArrayReader({},
        [{name:'value'},
        {name:'text'}
        ])
    });
store.load({params:{enumfield:v_enumfield}});
var combo = new Ext.form.ComboBox({
id:v_enumfield,
store: store,
emptyText:'请选择',
fieldLabel:v_fieldLable,
mode:'local',
triggerAction:'all',
valueField:'value',
displayField:'text',
allowBlank:false
});
return combo;
};
//定义在线编辑器
function createHtmlEditor(v_id,v_fieldLabel){
var field = new Ext.form.HtmlEditor({
	id:v_id,
	fieldLabel:v_fieldLabel,
	enableAlignments :false,  
  enableColors: true,  
  enableFont : false,  
  enableFontSize: true,  
  enableFormat: true,  
  enableLinks: true,  
  enableLists : false,  
  enableSourceEdit: true,
  allowBlank:false
	});
	
	return field;
};
//定义多行文本框
function createTextArea(v_id,v_fieldLabel){
	var texarea = new Ext.form.TextArea({
	fieldLabel: v_fieldLabel,
  id: v_id,
  labelSepartor: "：",
  labelWidth: 60,
  width: 230,
  allowBlank:false
		});
	return texarea;	
};
//定义提交按钮
function createSubmitButton(v_btnName,v_btnConfirm,v_url,form1)
{
var btn = new Ext.Button({
		text:v_btnName,
		width:80,
		handler : function(){
			 Ext.MessageBox.confirm( "请确认", v_btnConfirm, function(button,text){
if(button=='yes'){
        Ext.Ajax.request({
				url: v_url,
				waitMsg: '正在处理,请稍后.....',
				success: function(request){
					var message = request.responseText;
					form1.form.findField('note_id').setValue(''); //提交成功后清空id值
					form1.getForm().reset();//清空form
					Ext.Msg.alert('提示',message);
					},
				failure: function(){
					Ext.Msg.alert('错误','系统异常！');   
				},
				params:form1.form.getValues()
				});
      }else{
			return;
		}  
})
			}
	});
return btn;
};

//定义树
function createTree(v_dataUrl,v_rootStr,v_form1)
{
	
	var tree = new Ext.tree.TreePanel({
        el: 'tree',
        loader: new Ext.tree.TreeLoader({dataUrl: v_dataUrl})
    });

    var root = new Ext.tree.AsyncTreeNode({id:'0',text:v_rootStr});

    tree.setRootNode(root);
    tree.render();

    root.expand();
    
    tree.on("click",function(node,event){
    	
    	v_form1.getForm().load({url:'GetNoteInfo.action?node='+node.id});
    	
    	});
    	
     tree.on("collapsenode",function(node,event){
    	
    	node.reload();
    	
    	});
    return tree;
	
};

//定义隐藏文本框
function createHiddenText(v_name,v_value)
{
	var hiddenfield = new Ext.form.Hidden({
            name: v_name,
            value: v_value
      });
  return hiddenfield;
};

//定义grid
function createGridPanel(v_store,v_cm,v_form)
{
var grid = new Ext.grid.GridPanel({
        autoHeight:true,
        autoScroll:true,
        store: v_store,
        cm: v_cm,
        listeners:{ 
                'rowdblclick' : function(grid, rowIndex, e){
                v_form.getForm().load({url:'GetNoteInfo.action?node='+v_store.getAt(rowIndex).data["note_id"]});
             } 
         }
    });
return grid;
};

//定义store
function createStore(v_url,v_field_arr)
{
	var store = new Ext.data.Store({
		proxy: new Ext.data.HttpProxy({url:v_url}),
    reader: new Ext.data.JsonReader({
            root: 'rows',
            fields:v_field_arr
        })
    });
    
    return store;
};

//定义cm
function createCm(v_field_arr)
{
var cm = new Ext.grid.ColumnModel(v_field_arr);

return cm;
};


//定义查询按钮
function createSerchButton(v_btnName,v_store,v_form)
{
var btn = new Ext.Button({
		text:v_btnName,
		width:80,
		handler : function(){
			v_store.load({params:{param:v_form.getForm().findField('note_serch').getValue()}});
			}
	});
return btn;
};

/*-----------创建函数end------------------*/

/*-----------功能函数start------------------*/

//日期处理函数使用，小于两位数字补充0开头
function addZero(v_str)
{
	var local_str = v_str.toString();
	
  if(local_str.length<2)
  {
    return 	"0"+local_str;
  }else{
  	return local_str;
  }
};

//获得格式化当前日期
function getFomatDate()
{

var myDate = new Date();

return myDate.getFullYear()+"-"+addZero(myDate.getMonth()+1)+"-"+addZero(myDate.getDate())+" "+addZero(myDate.getHours())+":"+addZero(myDate.getMinutes())+":"+addZero(myDate.getSeconds());

};
/*-----------功能函数end------------------*/