
var isTouch=false;

$(document).ready(function() {


    $("#p103").html((subtext($("#fromnickname").val())+"的黑历史"));

    $("#p202").html((subtext($("#fromnickname").val())+"的黑历史"));


     loadis();
    
     loadHistory();
    
     
     



});


function  showlist(data,id){
	var list="<table width='100%' border='0'>";
	data.forEach(function(item){
		list= list + "<tr><td width='5%' style='padding-top: 10%;'></td><td width='15%'>";

		list = list+"<img src='images/2/4_"+item.tosex+".png' style='width: 70%;height: auto;'></td>";

		list = list+"<td  width='60%' >某某曾和 "+item.fromnickname+" 在"+item.city+item.dosamething+"</td>";
		
		if((item.ismyliked==0) && (item.likednum>0)){
			
			list = list+"<td id='"+item.id+"yjimg' width='10%'><img src='images/1/5.png' style='width: 100%;height: auto;' onclick='like("+item.id+")'></td><td id='"+item.id+"num' width='10%'><div  style='font-size: 0.4em;'>+"+item.likednum+"</div></td>";
			
		}else if((item.ismyliked==0) ){
			
			list = list+"<td id='"+item.id+"yjimg' width='10%'><img src='images/1/5.png' style='width: 100%;height: auto;' onclick='like("+item.id+")'></td><td id='"+item.id+"num' width='10%'><div  style='font-size: 0.4em;'></div></td>";
			
		}
		else{
			
			list = list+"<td id='"+item.id+"yjimg' width='10%'><img src='images/1/6.png' style='width: 100%;height: auto;' onclick='unlike("+item.id+")'></td><td id='"+item.id+"num' width='10%'><div style='font-size: 0.4em;'>+"+item.likednum+"</div></td>";
		}
			
	});
	
	var dv_list = document.getElementById(id);
	dv_list.innerHTML = list;
	
	console.log("数据载入");
	setTimeout(function(){
		myScroll.refresh();	
		console.log("刷新滚动");
	},1000)
	
}

function displayDiv(nextPage){

    if(nextPage==0){

        ////应用播放
        //var audio = document.getElementById('audio_play');
        //audio.play();


    }

    if(nextPage==1){



    }

    if(nextPage==2){




    }

}


//进度条
function remindload(loadpercent) {
    var text=""
    if (loadpercent>15) {



    }
}
var i = 0;
function loadover() {

    //时间控制
    var maxInt=20;

    if (i > 100) { //当大于100%时消失进度条

       // $('#loadtext').fadeIn("slow");//加载完毕提示
       $('#loadbg').fadeOut(1000);

        displayDiv(0);
        return;
    }
    if (i <= 100) { //百分比计数，延迟加载


        setTimeout("loadover()", maxInt);
        remindload(i);
        i=i+1;
    }
}


function getVendorPrefix() {
    // 使用body是为了避免在还需要传入元素
    var body = document.body || document.documentElement,
        style = body.style,
        vendor = ['webkit', 'khtml', 'moz', 'ms', 'o'],
        i = 0;

    while (i < vendor.length) {
        // 此处进行判断是否有对应的内核前缀
        if (typeof style[vendor[i] + 'Transition'] === 'string') {
            return vendor[i];
        }
        i++;
    }
}
