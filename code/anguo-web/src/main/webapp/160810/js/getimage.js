$(function() {
	        function toFixed2(num) {
	            return parseFloat(+num.toFixed(2));
	        }
			
	        $('#cancleBtn').on('click', function() {
	            $("#showEdit").fadeOut();
	            $('#div_head').fadeIn();
	        });
	
	        $('#confirmBtn').on('click', function() {
	            $("#showEdit").fadeOut();
	
	            var $image = $('#report > img');
	            var dataURL = $image.cropper("getCroppedCanvas");
	            var imgurl = dataURL.toDataURL("image/jpeg", 0.5);
	            $("#div_head > label > img").attr("src", imgurl);


				$("#p0607 > img").attr("src", imgurl);
				$("#p0705 > img").attr("src", imgurl);
				
				$("#fromheadimgurl").val(imgurl);

				
				
				
				//显示图层
				$("#loaddiv").show();

            	
				
            	$.post('http://lb.teamyy.cn/encounterr-web/xyCampaign/create.htm', $('#bd').serializeArray(), function(response){
            		
            		
            		if(response.code==1601){
        				//隐藏图层
        				$("#loaddiv").hide();
        				//alert(response.msg);

        				}else if(response.code==1602){
        				//alert(response.msg);
        				//隐藏图层
        				$("#loaddiv").hide();

        				}else{
        				alert('网络出现问题了!');
        				//隐藏图层
        				$("#loaddiv").hide();
        				}
            		
            		
            	});
            	
				
				
				

	            $('#div_head').fadeIn();
	
	        });
	
	        function cutImg() {
	            $('#div_head').fadeOut();
	            $("#showEdit").fadeIn();
	            var $image = $('#report > img');
	            $image.cropper({
	                aspectRatio: 1 / 1,
	                autoCropArea: 0.7,
	                strict: true,
	                guides: false,
	                center: true,
	                highlight: false,
	                dragCrop: false,
	                cropBoxMovable: false,
	                cropBoxResizable: false,
	                zoom: -0.2,
	                checkImageOrigin: true,
	                background: false,
	                minContainerHeight: 400,
	                minContainerWidth: 300
	            });
	        }
	
	        function doFinish(startTimestamp, sSize, rst) {
	            var finishTimestamp = (new Date()).valueOf();
	            var elapsedTime = (finishTimestamp - startTimestamp);
	            //$('#elapsedTime').text('压缩耗时： ' + elapsedTime + 'ms');
	
	            var sourceSize = toFixed2(sSize / 1024),
	                resultSize = toFixed2(rst.base64Len / 1024),
	                scale = parseInt(100 - (resultSize / sourceSize * 100));
	            $("#report").html('<img src="' + rst.base64 + '" style="width: 100%;height:100%">');
	            cutImg();
	        }
	
	        $('#image').on('change', function() {

	            var startTimestamp = (new Date()).valueOf();
	            var that = this;
	            lrz(this.files[0], {
	                    width: 800,
	                    height: 800,
	                    quality: 0.7
	                })
	                .then(function(rst) {
	                    //console.log(rst);
	                    doFinish(startTimestamp, that.files[0].size, rst);
	                    return rst;
	                })
	                .then(function(rst) {
	                    // 这里该上传给后端啦
	                    // 伪代码：ajax(rst.base64)..
	                	
	                	
	                	
						
	                    return rst;
	                })
	                .then(function(rst) {
	                    // 如果您需要，一直then下去都行
	                    // 因为是Promise对象，可以很方便组织代码 \(^o^)/~
	                })
	                .catch(function(err) {
	                    // 万一出错了，这里可以捕捉到错误信息
	                    // 而且以上的then都不会执行
	
	                    alert(err);
	                })
	                .always(function() {
	                    // 不管是成功失败，这里都会执行
	                });
	        });
	
	    });