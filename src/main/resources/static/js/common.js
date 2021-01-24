/**
 * create by harvey on 2020-12-23
 * 对jquery的post、get请求再次封装
 * 定义公共js方法：
 */
function myPost(url, data, successBack) {
	myAjax(url, data, 'post', successBack);
}

function myGet(url, data, successBack) {
	myAjax(url, data, 'get', successBack);
}

function myAjax(url, data, requestType, successBack){
	var requestHeader = getRequestHeader();
	$.ajax({
		type:requestType,
		url: url,
		cache:false,
		dataType:'json',
		data:JSON.stringify(data),
		headers:requestHeader,
		success:function(result){
			if (result.code == 200){
				successBack(result);
			} else if (result.code == 602){
				// 刷新token，刷新成功后重新发起请求
				refreshToken(function(){
					myAjax(url, data, requestType, successBack);
				});
			}else{
				alert(result.message);
			}
		},
		error:function(ex){
			alert('系统异常，请联系管理员！');
		}
	});
}

function getRequestHeader(){
	var header = {
		'token':getToken()
	}
	return header;
}

function getToken(){
	return localStorage.getItem('token');
}

function getRefreshToken(){
	return localStorage.getItem('refreshToken');
}

function setToken(data){
	localStorage.setItem('token', data);
}

function setRefreshToken(data){
	localStorage.setItem('refreshToken', data);
}

function refreshToken(callBack){
	var data = {
		'token':getToken(),
		'refreshToken':getRefreshToken()
	};
	
	$.ajax({
		type:'post',
		url: 'refresh/token',
		cache:false,
		dataType:'json',
		data:JSON.stringify(data),
		success:function(result){
			if (result.code == 200){
				setToken(result.data.token);
				setRefreshToken(result.data.refreshToken);
				callBack();
			} else {
				// 刷新token失败，则跳转到登录页
				window.location.href= window.location.pathname;
			}
		},
		error:function(ex){
			alert('系统异常，请联系管理员！');
		}
	});
}