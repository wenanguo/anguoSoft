var jsondata = [{
	sex: '男',
	value: '王小土想和AMY去日本看樱花',
	ismyliked: false,
	likednum: 10
}, {
	sex: '女',
	value: '文安国想和AMY去泰国做spa',
	ismyliked: true,
	likednum: 444
}, {
	sex: '男',
	value: '李国想和AMY去泰国见人妖',
	ismyliked: false,
	likednum: 444
}];//列表示例数据

//显示列表
function  showlist(data){
	var list="";
	data.forEach(function(item){
		list= list + "<div class='dv_rows'><div class='div_otherhead'>";
		if(item.sex=='男')
			list = list+"<img src='oyqy/images/head_boy.png' style='width: 100%;height: 100%;' /></div>";
		else
			list = list+"<img src='oyqy/images/head_girl.png' style='width: 100%;height: 100%;' /></div>";
		
		list = list+"<div class='div_othermsg'>"+item.value+"</div><div class='div_like'>";
		
		if(item.ismyliked){
			list = list+"<img src='oyqy/images/liked.png' style='width: 80%;height: 50%;'/></div>";
			list = list+"<label class='label_likednum'>"+item.likednum+"</label></div><br/>";
		}
		else{
			list = list+"<img src='oyqy/images/like.png' style='width: 80%;height: 50%;'/></div>";
			list = list+"<label class='label_likenum'>"+item.likednum+"</label></div><br/>";
		}
			
	});
	
	var dv_list = document.getElementById("dv_list");
	dv_list.innerHTML = list;
	
	console.log("数据加载完成");
}