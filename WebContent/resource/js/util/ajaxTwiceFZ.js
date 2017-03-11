
/**
 * 
 * 需求：
 * 		1.将加锁逻辑封装
 * 		2.将路径参数化，添加随机串
 * 		3.将处理方法作为参数传入
 * 
 * 思路：
 * 		1.加锁逻辑目前我的解决思路是将整个代码封装成对象，不然方法是没有办法进行状态控制的
 * 		2.剩下的两个问题我觉得直接通过传参和回调皆可以解决
 * 
 * 		这里又引入了一个问题：如何将这段代码在活动每次使用的时候都可以直接引入呢？
 * 		1.将它作为jquery类的一个对象
 * 		2.将它通过requirejs抛出
 * 
 * 		目前采用第一种方式尝试一下
 * 
 * 		又遇到了另外一个问题：如何让每个jquery对象在触发的时候执行这个方法呢？
 * 		解决办法：让每个触发ajax的按钮分配一个单独的ajaxTwiceFZ对象(此处就是对象)
 * 
 * 		如何将整个插件引入页面呢？
 *		直接在页面引入就行
 *
 *		目前存在的问题：1.每个页面的所有ajax请求都使用一把锁
 *					   2.不能修改lock锁的状态	
 *
 *		新增传参:增加data数据。
 *
 *		小知识：为什么不能修改lock的状态呢？
 *		     答：因为第一次给that赋值是lock的false值，他是基本类型，不是引用类型，只有是引用类型，就是that对象的时候赋值为引用类型的指针，才可以修改数据。
 *
 *		每个页面的ajax都使用一把锁也是可行的
 *
 *		使用例子：
 *		$("#redBag").on("click",function(){
 *	    $.ajaxTwiceFZ.ajaxTwiceFZ("act/award_17_2_1",function(data){//200
 *		});
});
 *
 */
$.extend({
	ajaxTwiceFZ:{
		lock : true,
		ajaxTwiceFZ:function(url,data,done,fail,error){
			if(this.lock){
				this.lock = !this.lock;
				var that = this.lock;
				$.ajax({
					url : PAGE.baseURL + "act/"+url+"?date=" + new Date().getTime(),
					type : 'POST',
					async : false,
					dataType : 'json',
					success : function(data) {
						var code = data.code;
						if (code == 200) {
							done(data);
							that = true;
						}else{
							if(fail==null){
								alert(data.msg);
							}else{
								fail(data);
							}
							that = true;
						}
					},
					error : function(data) {
						if(error==null){
							alert(data.msg);
						}else{
							error(data);
						}
						that = true;
					}
				});
			}
		}
	}
});

//ajax二次封装的更新版

/**
 * 
 * 需求：
 * 		1.实现参数可传递需求
 * 		2.实现传递的参数可以是中文
 * 		3.去掉对状态进行判断的啰嗦lock作为成员变量，改为采用window对象的初始化参数作为锁
 * 
 */
$.extend({ajaxTwiceFZ:function(url,param,done,fail,error){
			param.date = new Date().getTime();
			window.TTlplecfz = window.TTlplecfz === undefined ? true:window.TTlplecfz;
			if(window.TTlplecfz){
				window.TTlplecfz = false;
				$.ajax({
					url : url,
					type : 'POST',
					async : false,
					dataType : 'json',
					data:param,
					success : function(data) {
						var code = data.code;
						if (code == 200) {
							done(data);
						}else{
							(fail===null||fail===undefined)?alert(data.msg):fail(data);
						}
						window.TTlplecfz = true;
					},
					error : function(data) {
						(error===null || error===undefined)?alert(data.msg):error(data);
						window.TTlplecfz = true;
					}
				});
			}
		}
});



/**
 * 两只老虎正式版
 */

$.extend({ajaxTwiceFZ:function(url,param,done,fail,error){
	param.date = new Date().getTime();
	window.TTlplecfz = window.TTlplecfz === undefined ? true:window.TTlplecfz;
	if(window.TTlplecfz){
		window.TTlplecfz = false;
		$.ajax({
			url : url,
			type : 'POST',
			async : false,
			dataType : 'json',
			data:param,
			success : function(data) {
				var code = data.code;
				if (code == 200) {
					done(data);
				}else{
					(fail===null||fail===undefined)?alert(data.msg === undefined ? data.codeDesc : data.msg):fail(data);
				}
				window.TTlplecfz = true;
			},
			error : function(data) {
				(error===null || error===undefined)?alert(data.msg === undefined ? data.codeDesc : data.msg):error(data);
				window.TTlplecfz = true;
			}
		});
	}
}
});
