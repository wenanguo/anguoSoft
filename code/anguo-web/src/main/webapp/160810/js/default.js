
var isTouch=false;

//定时器
var timer1;

$(document).ready(function() {

	
	//var audio = document.getElementById('audio_play');
	//audio.play(); // audio will play in iOS before 4.2.1
	
	//$("#p0902 > img").attr("src",$("#fromheadimgurl").val());
    //PageTransitions.moveJdPage(4);

	
	if(($("#p0903 img").attr("src")==null)||($("#p0903 img").attr("src")=="")){
		
		displayDiv(0);
		
	}
	
	
	  


});


function displayDiv(nextPage){

    if(nextPage==0){

        $('#p0901').hide();
        $('#p0102').addClass('animated bounce infinite');


        setTimeout(function(){
            PageTransitions.moveJdPage(1);
        },3000);

        setTimeout(function(){
            PageTransitions.moveJdPage(2);
        },7000);

        setTimeout(function(){
            PageTransitions.moveJdPage(3);
        },10000);

        setTimeout(function(){
            PageTransitions.moveJdPage(4);
        },15000);


    }

    if(nextPage==1){


        $('.copy img').show();

        playMusic("cheer.mp3",false);


        $('#p0204').addClass('animated bounceInLeft');
        $('#p0205').addClass('animated bounceInRight');
        setTimeout(function(){
            $('#p0204').removeClass('animated bounceInLeft');

            $('#p0204').css("animation-delay","0s");
            $('#p0204').css("-webkit-animation-delay","0s");

            $('#p0204').addClass('animated pulse infinite');



            $('#p0205').removeClass('animated bounceInRight');

            $('#p0205').css("animation-delay","0.5s");
            $('#p0205').css("-webkit-animation-delay","0.5s");

            $('#p0205').addClass('animated pulse infinite');

        },2500);

        $('#p0202').addClass('animated bounceInUp');
        $('#p0203').addClass('animated bounceInUp');
        setTimeout(function(){
            $('#p0203').removeClass('animated bounceInUp');
            $('#p0203').addClass('animated flash infinite');
        },1000);



    }

    if(nextPage==2) {

        playMusic("snow.mp3", false);
    }

    if(nextPage==3){

        playMusic("song.mp3",false);

        $('#p0401').addClass('animated bounceInRight');


        $('#p0402').addClass('animated bounceInUp');
        $('#p0403').addClass('animated bounceInUp');
        setTimeout(function(){
            $('#p0403').removeClass('animated bounceInUp');
            $('#p0403').addClass('animated flash infinite');
        },2000);



    }



    if(nextPage==5){

        timer1 = setInterval("timer()",1000);

        FastClick.attach(document.body);

        $('#p0603').addClass('animated flash infinite');
    }

    if(nextPage==6){



            playMusic("cheer.mp3",false);


        $('#p0704').addClass('animated bounceInRight');

    }

}


var endTime=2000;
function timer()
{

    endTime = endTime - 1 ;


    if (endTime < 10) {
        endTime= "0" + endTime;
    }

    document.getElementById("p0608").innerHTML = endTime + "秒";
    if(endTime<=0){

        clearInterval(timer1);
        PageTransitions.moveJdPage(6);
    }

}


//提交按钮动作
function submitAction(openid,action){


	try{

		$.post('http://lb.teamyy.cn/encounterr-web/xyCampaignAction/create.htm', "openid="+openid+"&action="+action, function(response){

			

		});


	}
	catch(e)
	{

		
		console.log(e);


	}finally {


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

//切换音乐
function playMusic(musicName,loop){



    $('#mc_play audio').get(0).pause();

    $($('#mc_play audio').get(0)).attr("src",musicName);

    if(loop==false){
        $($('#mc_play audio').get(0)).removeAttr("loop");
    }else{
        $($('#mc_play audio').get(0)).attr("loop","");
    }



    var audio = document.getElementById('audio_play');
    audio.play(); // audio will play in iOS before 4.2.1

}
