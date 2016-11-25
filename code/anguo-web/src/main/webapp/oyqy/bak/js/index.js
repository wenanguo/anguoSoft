var city;
var dosamething;
window.onload = function init() {
	showlist(jsondata); //显示列表数据，使用时请按格式设置json串
	initcityclick();
}

///**马上走起*/
//function  nowgo(){
//	var cityname = city.value;
//	var doaiai = dosamething.value;
//	
//	if(ifnull(cityname)){
//		alert("选择一个想去的地方吧！")
//		return;
//	}
//	
//	if(ifnull(doaiai)){
//		alert("你俩想去做啥呢，可以选一个喔！")
//		return;
//	}
//	
//	//后台提交代码
//	//？？？？？？？？？？？？？？
////	var url ="result.html?city=" + cityname + "&doaiai=" + doaiai;
////	url = encodeURI(url);
////	window.location.href = url;
//	submitForm();
//}

//初始化对象
function initcityclick(){
	city = document.getElementById("city");
	dosamething = document.getElementById("dosamething");
	//var gogo = document.getElementById("button_go");
	var page1 = document.getElementById("div_page1");
	var page2 = document.getElementById("div_page2");
//	gogo.onclick=function(){
//		nowgo();
//	}
	
	city.onclick=function(){
		page1.style.display="";
		page2.style.display="none";
	}
	
	dosamething.onclick=function(){
		page2.style.display="";
		page1.style.display="none";
	}
	
	$$$("city1").onclick=function(){
		city.value=this.innerHTML;
		dosamething.value = "吃火锅";
	}
	$$$("city2").onclick=function(){
		city.value=this.innerHTML;
		dosamething.value = "骑马";
	}
	$$$("city3").onclick=function(){
		city.value=this.innerHTML;
		dosamething.value = "看AV";
	}
	
	$$$("city4").onclick=function(){
		city.value=this.innerHTML;
		dosamething.value = "看日出";
	}
	
	$$$("city5").onclick=function(){
		city.value=this.innerHTML;
		dosamething.value = "泡温泉";
	}
	$$$("city6").onclick=function(){
		city.value=this.innerHTML;
		dosamething.value = "看极光";
	}
	$$$("city7").onclick=function(){
		city.value=this.innerHTML;
		dosamething.value = "做马杀鸡";
	}
	$$$("city8").onclick=function(){
		city.value=this.innerHTML;
		dosamething.value = "求婚";
	}
	
	$$$("event1").onclick=function(){
		dosamething.value=this.innerHTML;
	}
	$$$("event2").onclick=function(){
		dosamething.value=this.innerHTML;
	}
	$$$("event3").onclick=function(){
		dosamething.value=this.innerHTML;
	}
	
	$$$("event4").onclick=function(){
		dosamething.value=this.innerHTML;
	}
	
	$$$("event5").onclick=function(){
		dosamething.value=this.innerHTML;
	}
	$$$("event6").onclick=function(){
		dosamething.value=this.innerHTML;
	}
	$$$("event7").onclick=function(){
		dosamething.value=this.innerHTML;
	}
	$$$("event8").onclick=function(){
		dosamething.value=this.innerHTML;
	}
	
	$$$("play").onclick=function(){
		$$$("share").style.display="block";
	}
	$$$("share").onclick=function(){
		$$$("share").style.display="none";
	}


	$$$("down").onclick=function(){
		window.location.href="down.html";
	}

}



