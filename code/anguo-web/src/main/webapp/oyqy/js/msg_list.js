//var jsondata = [{
//	fromnickname:'amy',
//	city:'呼伦贝尔',
//	dosamething:'骑马',
//	fromsex:1,
//	tonickname:"王小土",
//	tosex:1,
//	ismyliked: false,
//	likednum: 10
//}, {
//	fromnickname:'amy',
//	city:'呼伦贝尔',
//	dosamething:'骑马',
//	fromsex:2,
//	tonickname:"王小土",
//	tosex:2,
//	ismyliked: false,
//	likednum: 101
//}];//列表示例数据

//显示列表
function  showlist(data,id){
	var list="";
	data.forEach(function(item){
		list= list + "<div class='dv_rows'><div class='div_otherhead'>";
		if(item.fromsex=='1')
			list = list+"<img src='oyqy/images/head_boy.png' style='width: 100%;height: 100%;' /></div>";
		else
			list = list+"<img src='oyqy/images/head_girl.png' style='width: 100%;height: 100%;' /></div>";
		
		list = list+"<div class='div_othermsg'>"+item.tonickname+" 想和 "+item.fromnickname+" 去"+item.city+item.dosamething+"</div><div class='div_like'>";
		
		if(item.ismyliked==1){
			list = list+"<img src='oyqy/images/liked.png' style='width: 80%;height: 50%;'/ onclick='unlike("+item.id+")'></div>";
			list = list+"<label class='label_likednum'>"+item.likednum+"</label></div><br/>";
		}
		else{
			list = list+"<img src='oyqy/images/like.png' style='width: 80%;height: 50%;'/ onclick='like("+item.id+")'></div>";
			list = list+"<label class='label_likenum'>"+item.likednum+"</label></div><br/>";
		}
			
	});
	
	var dv_list = document.getElementById(id);
	dv_list.innerHTML = list;
}


