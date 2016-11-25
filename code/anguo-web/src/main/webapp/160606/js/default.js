
var isTouch=false;

$(document).ready(function() {



});



/**
 * 获得设备信息
 * @returns true为移动设备，false为PC
 */
function getDeviceInfoByBrower() {
    var sUserAgent = navigator.userAgent.toLowerCase();
    var bIsIpad = sUserAgent.match(/ipad/i) == "ipad";
    var bIsIphoneOs = sUserAgent.match(/iphone os/i) == "iphone os";
    var bIsMidp = sUserAgent.match(/midp/i) == "midp";
    var bIsUc7 = sUserAgent.match(/rv:1.2.3.4/i) == "rv:1.2.3.4";
    var bIsUc = sUserAgent.match(/ucweb/i) == "ucweb";
    var bIsAndroid = sUserAgent.match(/android/i) == "android";
    var bIsCE = sUserAgent.match(/windows ce/i) == "windows ce";
    var bIsWM = sUserAgent.match(/windows mobile/i) == "windows mobile";

    if (bIsIpad || bIsIphoneOs || bIsMidp || bIsUc7 || bIsUc || bIsAndroid || bIsCE || bIsWM) {
        return true;
    } else {
        return false;
    }
}


/**
 * 获得设备信息
 * @returns true为移动设备，false为PC
 */
function getDeviceInfoByWidth() {
   var _w = document.documentElement.clientWidth;

    if (_w<640) {
        return true;
    } else {
        return false;
    }
}



function displayDiv(nextPage){

    if(nextPage==0){

        //应用播放
        var audio = document.getElementById('audio_play');
        audio.play();

        $('#p102').addClass('animated f102 infinite');
        //$('#p103').addClass('animated flash infinite');

        $('#p105').addClass('animated f101 infinite');
        $('#p106').addClass('animated f101 infinite');

        $('#p110').addClass('animated f101 infinite');
        $('#p111').addClass('animated f101 infinite');
        $('#p112').addClass('animated f101 infinite');
        $('#p113').addClass('animated f101 infinite');
        $('#p114').addClass('animated f101 infinite');



    }

    if(nextPage==1){

        $('#p201').addClass('animated pulse infinite');

        $('#p2021').addClass('animated f2021 infinite');
        $('#p2022').addClass('animated f2021 infinite');
        $('#p2023').addClass('animated f2021 infinite');

    }

    if(nextPage==2){

        $('#p3011').addClass('animated f101 infinite');
        $('#p3012').addClass('animated f101 infinite');

        $('#p3013').addClass('animated f101 infinite');
        $('#p3014').addClass('animated f101 infinite');

        $('#p3071').addClass('animated f101 infinite');
        $('#p3072').addClass('animated f101 infinite');
        //$('#p302').addClass('animated fadeInUp');
        //$('#p303').addClass('animated fadeInUp');


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
