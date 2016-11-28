$(function(){
	/**
	 * 科目下拉加载处理
	 */
	$('#subjectId').combobox({   
	    url:'goeSubject/comboxlist.htm',   
	    valueField:'id',   
	    textField:'text',
	    value : '====请选择科目====',
    	onChange:function(newValue,oldValue){  
    		siClassidId=newValue;
    		loadClass(newValue);  
        }  
	}); 
});


/**
 * 通过科目过滤章节
 */
function loadClass(subjectid) {
	var urlStr='goeTopicClass/listAll.htm';
		urlStr=urlStr+'?subjectId='+ subjectid+'&topicType=1';
	
		console.log(urlStr);
		
	$('#topicClassId').combobox({   
		url : urlStr,
	    valueField:'id',   
	    textField:'title',
	    value : '====请选择章节===='
	}); 
}


