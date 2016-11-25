var city;
var dosamething;
window.onload = function init() {
	
	//setimg("http://img1.imgtn.bdimg.com/it/u=2579000413,48637368&fm=21&gp=0.jpg");
	//setIWant("韩MM");
	//setList(jsondata); //显示列表数据，使用时请按格式设置json串
	
	loadtravel();
	
	
	
	initcityclick();
}

///**
// * 将数据提交到后台
// */
//function commitgogog(cityname,doaiai){
//	//???
//}




/**马上走起
function  nowgo(){
	var cityname = city.value;
	var doaiai = dosamething.value;
	
	if(ifnull(cityname)){
		alert("选择一个想去的地方吧！")
		return;
	}
	
	if(ifnull(doaiai)){
		alert("你俩想去做啥呢，可以选一个喔！")
		return;
	}
	
	//后台提交代码
	//？？？？？？？？？？？？？？
	commitgogog(cityname,doaiai);
	$$$("page1").style.display="none";
	showresult(cityname,doaiai);
	$$$("page3").style.display="block";
}
*/


/**
 * 设置我的头像
 */
function setimg(imageurl){
	$$$("img_head").src=imageurl;
}

/**
 * 设置我想和谁去
 */
function setIWant(who){
	$$$("labal_talk").innerHTML="我想和"+who+"去";
	$$$("label_lang").innerHTML="其他小伙伴也想和"+who+"一起浪";
	$$$("label_otherwant").innerHTML="其他小伙伴也想和"+who+"一起浪";
}

/**
 * 设置列表 数据
 */
function setList(data){
	showlist(data,"dv_list");
	showlist(data,"dv_page3_list");
}


/**根据选择的城市和要去干啥显示结果*/
function showresult(city,doaiai){
	var html="";
	if(city =="成都" && doaiai=="吃火锅"){
		html="<img src='oyqy/images/face/face4.png' style='width: 50%;' />"
	}else if(city =="呼伦贝尔" && doaiai=="骑马"){
		html="<img src='oyqy/images/face/face5.png' style='width: 50%;' />"
	}else if(city =="东莞" && doaiai=="看AV"){
		html="<img src='oyqy/images/face/face6.png' style='width: 50%;' />"
	}else if(city =="斐济" && doaiai=="看日出"){
		html="<img src='oyqy/images/face/face7.png' style='width: 50%;' />"
	}else if(city =="特罗姆瑟" && doaiai=="看极光"){
		html="<img src='oyqy/images/face/face8.png' style='width: 50%;' />"
	}else if(city =="埃及" && doaiai=="泡温泉"){
		html="<img src='oyqy/images/face/face9.png' style='width: 50%;' />"
	}else if(city =="希腊" && doaiai=="做马杀鸡"){
		html="<img src='oyqy/images/face/face10.png' style='width: 50%;' />"
	}else if(city =="拉斯维加斯" && doaiai=="求婚"){
		html="<img src='oyqy/images/face/face11.png' style='width: 50%;' />"
	}else{
		
		var rand = parseInt(Math.random()*3)+1;
		if(rand>4) rand=3;
		html="<img src='oyqy/images/face/face"+rand+".png' style='width: 50%;' />"
	}
	
	$$$("div_page3_top").innerHTML = html;
	
	
	$$$("play").onclick=function(){
		$$$("share").style.display="block";
	}
	$$$("share").onclick=function(){
		$$$("share").style.display="none";
	}
}




//初始化对象
function initcityclick(){
	city = document.getElementById("city");
	dosamething = document.getElementById("dosamething");
	//var gogo = document.getElementById("button_go");
	var page1 = document.getElementById("div_page1");
	var page2 = document.getElementById("div_page2");
	//gogo.onclick=function(){
	//	nowgo();
	//}
	
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
		$$$("page1").style.display="none";
		$$$("page3").style.display="none";
		$$$("page2").style.display="block";
		$$$("div_button_bottom").style.display="none";
	}
}



