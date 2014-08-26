

// 弹出居中窗体
function openCenterWindow(windowName, width, height) {

	window
			.open(
					'about:blank',
					windowName,
					'width='
							+ (width)
							+ 'px,height='
							+ (height)
							+ 'px,top='
							+ (screen.availHeight - height)
							/ 2
							+ 'px,left='
							+ (screen.availWidth - width)
							/ 2
							+ 'px,toolbar=no, menubar=no,location=no, status=no, scrollbars=yes, resizable=yes')
			.focus();
}

// 弹出居中窗体
function openCenterWindowByUrl(url, windowName, width, height) {

	window
			.open(
					url,
					windowName,
					'width='
							+ (width)
							+ 'px,height='
							+ (height)
							+ 'px,top='
							+ (screen.availHeight - height)
							/ 2
							+ 'px,left='
							+ (screen.availWidth - width)
							/ 2
							+ 'px,toolbar=no, menubar=no,location=no, status=no, scrollbars=yes, resizable=yes')
			.focus();
}

// 弹出居中窗体
function openModalWindow(url, windowName, width, height) {

	window.showModalDialog(url, windowName, 'dialogWidth:' + (width)
					+ 'px;dialogHeight:' + (height) + 'px;center:yes;');
}

/**
 * 显示进度条
 */
function openProgress() {
	$.messager.progress({
				msg : '请稍候,正在提交数据...'
			});
	$("body>div.messager-window>div.messager-body").css("width", "276");
}

/**
 * 关闭进度条
 */
function closeProgress() {
	$.messager.progress('close');
}

String.prototype.replaceAll = function(s1, s2) {
	return this.replace(new RegExp(s1, "gm"), s2);
};



// 弹出右下角提示框
function showRMsg(msg) {

	$.messager.show({
				title : '提示',
				msg : msg,
				timeout : 5000,
				showType : 'slide'
			});
}

/**
 * 扩展jquery easeui 键盘操作
 */

$.extend($.fn.datagrid.methods, {
	keyCtr : function(jq) {
		return jq.each(function() {
			var grid = $(this);
			grid.datagrid('getPanel').panel('panel').attr('tabindex', 1).bind(
					'keydown', function(e) {
						switch (e.keyCode) {
							case 38 : // up
								var selected = grid.datagrid('getSelected');
								if (selected) {
									var index = grid.datagrid('getRowIndex',
											selected);
									grid.datagrid('unselectAll');
									grid.datagrid('selectRow', index - 1);
								} else {
									var rows = grid.datagrid('getRows');
									grid.datagrid('selectRow', rows.length - 1);
								}
								break;
							case 40 : // down
								var selected = grid.datagrid('getSelected');
								if (selected) {
									var index = grid.datagrid('getRowIndex',
											selected);
									grid.datagrid('unselectAll');

									grid.datagrid('selectRow', index + 1);
								} else {
									grid.datagrid('selectRow', 0);
								}
								break;
						}
					});
		});
	}
});

/**
 * json工具
 */
var JsonUtil = (function() {
	return {
		/**
		 * 获取json中的单个值
		 */
		getValue : function(jsonObject, name) {
			var value = "";
			$.each(jsonObject, function(n, v) {
						if (name == n) {
							value = v;
							return false;
						}
					});
			return value;
		},
		/**
		 * 获取json数组对象中属性名为name，值为value对象，如有多个只返回第一个对象
		 */
		getArrObj : function(jsonArr, name, value) {
			var value;
			$.each(jsonArr, function(n, v) {
						if (JsonUtil.getValue(v, name) == value) {
							value = v;
							return false;
						}

					});
			return value;
		},
		/**
		 * 获取json中的name 以数组形式返回
		 */
		getNames : function(jsonObject) {
			var names = [];
			$.each(jsonObject, function(n, v) {
						names.push(n);
					});
			return names;
		},
		/**
		 * 创建json对象
		 */
		createJsonObject : function() {
			this.jsonObectArr = [];
		}

	}

})();

/**
 * 创建json的nam和value的名值对字符串
 */
JsonUtil.createJsonObject.prototype.createJsonStr = function(name, value) {
	if (typeof value == 'string') {
		this.jsonObectArr.push("\"" + name + "\":" + "\"" + value + "\"");
	} else {
		this.jsonObectArr.push("\"" + name + "\":" + value);
	}
}

/**
 * 获取json对象
 */
JsonUtil.createJsonObject.prototype.getJson = function() {
	var str = "{" + this.jsonObectArr.join(',') + "}";
	return $.parseJSON(str);
}

/**
 * 权限检查，有权限访问返回true，无权限访问返回false
 */
function checkAuthority(btnArr, name, value) {

	var val = JsonUtil.getArrObj(btnArr, name, value).disabled;

	if (val == false) {
		return true;
	} else {

		return false;
	}

}

/**
 * 状态显示函数
 */
function stateFormat(value) {
	switch (value) {
		case 103 :
			return '<font style="color:red">审核中</font>';
			break;
		case 104 :
			return '<font style="color:red">停用</font>';
			break;
		case 100 :
			return '<font style="color:green">正常</font>';
			break;
		case 105 :
			return '<font style="color:red">审核中</font>';
			break;

		case 121 :
			return '<font style="color:red">新增审核中</font>';
			break;
		case 122 :
			return '<font style="color:red">修改审核中</font>';
			break;
		case 123 :
			return '<font style="color:black">删除审核中</font>';
			break;
		case 124 :
			return '<font style="color:blue">新增审核未通过</font>';
			break;
		case 125 :
			return '<font style="color:black">修改审核未通过</font>';
			break;
		case 126 :
			return '<font style="color:black">删除审核未通过</font>';
			break;
		case 127 :
			return '<font style="color:black">新增审核通过</font>';
			break;
		case 128 :
			return '<font style="color:black">修改审核通过</font>';
			break;
		case 129 :
			return '<font style="color:black">删除审核通过/font>';
			break;
		case 141 :
			return '<font style="color:green">推荐成功</font>';
			break;
		case 142 :
			return '<font style="color:red">推荐失败</font>';
			break;

		case 151 :
			return '<font style="color:black">新增</font>';
			break;
		case 152 :
			return '<font style="color:red">已下发</font>';
			break;
		case 153 :
			return '<font style="color:green">核销成功</font>';
			break;
		case 154 :
			return '<font style="color:red">核销失败</font>';
			break;
		case 155 :
			return '<font style="color:red">未下发</font>';
			break;
		case 161 :
			return '<font style="color:red">未审核</font>';
			break;
		case 162 :
			return '<font style="color:green">待发送</font>';
			break;
		case 163 :
			return '<font style="color:green">已发送</font>';
			break;
		case 164 :
			return '<font style="color:red">取消发送</font>';
			break;
		case 165 :
			return '<font style="color:red">发送错误</font>';
			break;
		case 166 :
			return '<font style="color:red">已过期</font>';
			break;
		case 169 :
			return '<font style="color:red">发送失败</font>';
			break;

		default :
			return '<font style="color:red">其他</font>';

	}


}

/**
 * 字符串截断显示函数
 * 
 * @param str
 *            源字符串
 * @param len
 *            显示长度
 * @returns
 */
function ellipsis(str, len) {
	if (str != null && str.length > len) {
		return str.substring(0, len) + "...";
	} else {
		return str;
	}
}

/**
 * 求百分比
 * 
 * @param num
 *            占比数
 * @param zong
 *            总数
 * @returns {String}
 */
function getPercent(num, zong) {
	return Math.round(parseFloat(num) / parseFloat(zong) * 10000) / 100.00
			+ "%";
}

/**
 * 创建文件上传控件
 * 
 * @param fileInputId
 *            表单id
 * @param rootPath
 *            跟路径
 * @param onUploadSuccessCallback
 *            上传成功后回调函数
 * @param fileTypeExts
 *            文件类型
 * @param fileTypeDesc
 *            文件说明
 * @param fileSizeLimit
 *            文件限制大小
 */
function createFileUpload(fileInputId, rootPath, onUploadSuccessCallback,
		fileTypeExts, fileTypeDesc, fileSizeLimit) {
	$("#" + fileInputId).uploadify({

		'langFile' : rootPath + 'resources/uploader/chlang.js',
		'swf' : rootPath + 'resources/uploader/uploadify.swf',
		'uploader' : rootPath + 'fileupload',
		'buttonImage' : rootPath + 'resources/uploader/file.png',
		'cancelImg' : rootPath + 'resources/uploader/cancel.png',
		'debug' : true,
		'height' : 23,
		'width' : 76,
		'removeCompleted' : true,
		'requeueErrors' : true,
		'itemTemplate' : '</r>',
		// 'fileSizeLimit' : fileSizeLimit,
		'fileTypeDesc' : fileTypeDesc,
		'fileTypeExts' : fileTypeExts,
		'onCancel' : function(file) {
			// alert('The file ' + file.name + ' was cancelled.');
		},
		'onClearQueue' : function(queueItemCount) {
			// alert(queueItemCount + ' file(s) were removed from the queue');
		},
		'onDestroy' : function() {
			// alert('I am getting destroyed!');
		},
		'onDialogClose' : function(queueData) {
			// alert(queueData.filesQueued + ' files were queued of ' +
			// queueData.filesSelected + ' selected files. There are ' +
			// queueData.queueLength + ' total files in the queue.');
		},
		'onDialogOpen' : function() {
			// $('#message_box').html('The file dialog box was opened...');
		},
		'onDisable' : function() {
			// alert('You have disabled Uploadify!');
		},
		'onEnable' : function() {
			// alert('You can use Uploadify again.');
		},
		'onFallback' : function() {
			// alert('Flash was not detected.');
		},
		'onInit' : function(instance) {
			// alert('The queue ID is ' + instance.settings.queueID);
		},
		'onQueueComplete' : function(queueData) {
			// alert(queueData.uploadsSuccessful + ' files were successfully
			// uploaded.');
		},
		'onSelect' : function(file) {
			// alert('The file ' + file.name + ' was added to the queue.');
		},
		'onSelectError' : function() {
			// alert('The file ' + file.name + ' returned an error and was not
			// added to the queue.');
		},
		'onSWFReady' : function() {
			// alert('The Flash file is ready to go.');
		},
		'onUploadComplete' : function(file) {
			// alert('The file ' + file.name + ' finished processing.');
		},
		'onUploadError' : function(file, errorCode, errorMsg, errorString) {
			// alert('The file ' + file.name + ' could not be uploaded: ' +
			// errorString);
		},
		'onUploadProgress' : function(file, bytesUploaded, bytesTotal,
				totalBytesUploaded, totalBytesTotal) {
			// $('#progress').html(totalBytesUploaded + ' bytes uploaded of ' +
			// totalBytesTotal + ' bytes.');
		},
		'onUploadStart' : function(file) {
			// alert('Starting to upload ' + file.name);
		},
		'onUploadSuccess' : onUploadSuccessCallback,

		'onUploadStart' : function(file) {
//			console.info(file);
			// alert(fileSizeLimit.substring(0,fileSizeLimit.length-2));
			if ((file.size / 1024) > fileSizeLimit.substring(0,
					fileSizeLimit.length - 2)) {
				$.messager.show({
							title : '提示',
							msg : '文件大小不可以超过：' + fileSizeLimit,
							showType : 'slide'
						});
				$("#" + fileInputId).uploadify('cancel');
			}

		}
	});

}

