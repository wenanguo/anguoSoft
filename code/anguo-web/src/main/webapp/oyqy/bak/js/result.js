window.onload = function init() {
	$$$("down").onclick = function() {
		window.location.href = "down.html";
	}
	showlist(jsondata); //显示列表数据，使用时请按格式设置json串
	
	//显示头像
	var url=window.location.href;
	url = decodeURI(url)
	var city = GetQueryString("city");
	var doaiai = GetQueryString("doaiai");
	var html="";
	if(city =="成都" && doaiai=="吃火锅"){
		html="<img src='images/face/face4.png' style='width: 50%;' />"
	}else if(city =="呼伦贝尔" && doaiai=="骑马"){
		html="<img src='images/face/face5.png' style='width: 50%;' />"
	}else if(city =="东莞" && doaiai=="看AV"){
		html="<img src='images/face/face6.png' style='width: 50%;' />"
	}else if(city =="斐济" && doaiai=="看日出"){
		html="<img src='images/face/face7.png' style='width: 50%;' />"
	}else if(city =="特罗姆瑟" && doaiai=="看极光"){
		html="<img src='images/face/face8.png' style='width: 50%;' />"
	}else if(city =="埃及" && doaiai=="泡温泉"){
		html="<img src='images/face/face9.png' style='width: 50%;' />"
	}else if(city =="希腊" && doaiai=="做马杀鸡"){
		html="<img src='images/face/face10.png' style='width: 50%;' />"
	}else if(city =="拉斯维加斯" && doaiai=="求婚"){
		html="<img src='images/face/face11.png' style='width: 50%;' />"
	}else{
		var rand = parseInt(Math.random()*3)+1;
		if(rand>4) rand=3;
		html="<img src='images/face/face"+rand+".png' style='width: 50%;' />"
	}
	
	$$$("div_top").innerHTML = html;
	
	
	$$$("play").onclick=function(){
		$$$("share").style.display="block";
	}
	$$$("share").onclick=function(){
		$$$("share").style.display="none";
	}
}

function GetQueryString(name) {  
    var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)", "i");  
    var url=window.location.href;
	url = decodeURI(url)
	
    var r = decodeURI(window.location.search).substr(1).match(reg);  //获取url中"?"符后的字符串并正则匹配
    var context = "";  
    if (r != null)  
         context = r[2];  
    reg = null;  
    r = null;  
    return context == null || context == "" || context == "undefined" ? "" : context;  
}
