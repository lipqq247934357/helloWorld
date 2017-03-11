/**
 * TT v1.0 twotiger utils
 * 
 * @descript 不涉及视图,不依赖Jquery 每个方法都要有注释:作者、描述
 */
var TT = TT || {};

Date.parseBigInt = function(timestamp) {
	var t = new Date();
	timestamp += "";
	var aa = "year_4,month_2,day_2,hours_2,minutes_2,seconds_2,microseconds_3";
	var bb = [];
	var s = 0;
	for (var i = 0; i < aa.split(",").length; i++) {
		var tt = aa.split(",")[i].split("_");
		bb[tt[0]] = parseInt(timestamp.substr(s, parseInt(tt[1])))
		s += parseInt(tt[1]);
	}
	return new Date(bb['year'], bb['month'] - 1, bb['day'], bb['hours'],
			bb['minutes'], bb['seconds'], bb['microseconds']);
}

// 对Date的扩展，将 Date 转化为指定格式的String
// 月(M)、日(d)、小时(h)、分(m)、秒(s)、季度(q) 可以用 1-2 个占位符，
// 年(y)可以用 1-4 个占位符，毫秒(S)只能用 1 个占位符(是 1-3 位的数字)
// 例子：
// (new Date()).Format("yyyy-MM-dd hh:mm:ss.S") ==> 2006-07-02 08:09:04.423
// (new Date()).Format("yyyy-M-d h:m:s.S") ==> 2006-7-2 8:9:4.18
Date.prototype.Format = function(fmt) { // author: meizz
	var o = {
		"M+" : this.getMonth() + 1, // 月份
		"d+" : this.getDate(), // 日
		"h+" : this.getHours(), // 小时
		"m+" : this.getMinutes(), // 分
		"s+" : this.getSeconds(), // 秒
		"q+" : Math.floor((this.getMonth() + 3) / 3), // 季度
		"S" : this.getMilliseconds()
	// 毫秒
	};
	if (/(y+)/.test(fmt))
		fmt = fmt.replace(RegExp.$1, (this.getFullYear() + "")
				.substr(4 - RegExp.$1.length));
	for ( var k in o)
		if (new RegExp("(" + k + ")").test(fmt))
			fmt = fmt.replace(RegExp.$1, (RegExp.$1.length == 1) ? (o[k])
					: (("00" + o[k]).substr(("" + o[k]).length)));
	return fmt;
}

/**
  *+-------------------------------------------------  
  *| 帐号格式化
  *| 格式为：1234 5678 9012 3456   
  *-------------------------------------------------- 
  */
TT.formatCardNo = function(value) {
	if (value == "" || value == null || value == undefined) {
		return "";
	}
	var account = new String(value);
	account = account.substring(0, 29); /* 帐号的总数, 包括空格在内 */
	var reg = /\s{1,}/g;
	var card_ = "";
	// 去除空格
	value = account.replace(reg, "");
	for (var i = 0; i < value.length; i++) {
		if (i % 4 == 3) {
			card_ = card_ + value.charAt(i) + " ";
		} else {
			card_ = card_ + value.charAt(i);
		}
	}
	return card_;
}

/**
 *+-------------------------------------------------  
 *| 帐号格式化
 *| 格式为：1234 **** **** 3456   
 *-------------------------------------------------- 
 */
TT.formatHideCardNo = function(value) {
	if (value == "" || value == null || value == undefined) {
		return "";
	}
	var head4=value.substr(0,4);
	var back4=value.substr(value.length-4);
	var str=head4+"********"+back4;
	
	return TT.formatCardNo(str);
}

/**
 * 判断是手机还是pc
 */
TT.mobileDetect=function(){
	var href=window.location.href;
	var protocol=window.location.protocol;
	var host=window.location.host;
	var port=window.location.port;
	var pathname=window.location.pathname;
	var search=window.location.search;
	
	console.log(" href:"+href+";protocol:"+protocol+";host:"+host+";port:"+port+";pathname:"+pathname+";search:"+search);
	//平台、设备和操作系统
    var system ={
        win : false,
        mac : false,
        xll : false
    };
    //检测平台
    var p = navigator.platform;
    system.win = p.indexOf("Win") == 0;
    system.mac = p.indexOf("Mac") == 0;
    system.x11 = (p == "X11") || (p.indexOf("Linux") == 0);
    //跳转语句
    if(!system.win&&!system.mac&&!system.xll){
    	window.location.href=PAGE.baseURL+"touch/";
    }
}

/**
 * 浏览器识别
 */
TT.sys = {
	versions : function() {
		var u = navigator.userAgent, app = navigator.appVersion;
		return {
			trident : u.indexOf('Trident') > -1, // IE内核
			presto : u.indexOf('Presto') > -1, // opera内核
			webKit : u.indexOf('AppleWebKit') > -1, // 苹果、谷歌内核
			gecko : u.indexOf('Gecko') > -1 && u.indexOf('KHTML') == -1,// 火狐内核
			mobile : !!u.match(/AppleWebKit.*Mobile.*/), // 是否为移动终端
			ios : !!u.match(/\(i[^;]+;( U;)? CPU.+Mac OS X/), // ios终端
			android : u.indexOf('Android') > -1 || u.indexOf('Linux') > -1, // android终端或者uc浏览器
			iPhone : u.indexOf('iPhone') > -1, // 是否为iPhone或者QQHD浏览器
			iPad : u.indexOf('iPad') > -1, // 是否iPad
			webApp : u.indexOf('Safari') == -1, // 是否web应该程序，没有头部与底部
			weixin : u.indexOf('MicroMessenger') > -1, // 是否微信 （2015-01-22新增）
			qq : u.match(/\sQQ/i) == " qq" // 是否QQ
		};
	}(),
	language : (navigator.browserLanguage || navigator.language).toLowerCase()
}

// 是否微信浏览器
TT.isWeixin = function() {
	var ua = navigator.userAgent.toLowerCase();
	if (ua.match(/MicroMessenger/i) == "micromessenger") {
		return true;
	} else {
		return false;
	}
}
/**
 * 常用正则
 */
TT.Regex = {
	name : [ /^[a-zA-Z]([a-zA-Z0-9_]){5,19}$/, "6-20位，可使用字母、数字、下划线，需以字母开头" ],
	pwd : [ /^[A-Za-z0-9\^$\.\+\*_@!#%&amp;~=-]{8,32}$/,
			"密码只能为 8 - 32 位数字，字母及常用符号组成" ],
	phone : [ /^(13[0-9]|15[012356789]|17[0678]|18[0-9]|14[57])[0-9]{8}$/,
			"请输入正确手机号" ],
	email : [ /^([-_A-Za-z0-9\.]+)@([_A-Za-z0-9]+\.)+[A-Za-z0-9]{2,3}$/,
			"请输入正确的邮箱" ]
}
/**
 * 四舍五入
 * 
 * @author dongzj
 * @param v:值；e:保留位数
 * @return
 */
TT.round = function(v, e) {
	var t = 1;
	for (; e > 0; t *= 10, e--)
		;
	for (; e < 0; t /= 10, e++)
		;
	return Math.round(v * t) / t;
};

/**
 * 金额转大写
 * 
 * @author dongzj
 * @param num:小写金额
 * @return
 */
TT.upperAmount = function(num) {
	var strOutput = "";
	var strUnit = '仟佰拾亿仟佰拾万仟佰拾元角分';
	num += "00";
	var intPos = num.indexOf('.');
	if (intPos >= 0)
		num = num.substring(0, intPos) + num.substr(intPos + 1, 2);
	strUnit = strUnit.substr(strUnit.length - num.length);
	for (var i = 0; i < num.length; i++)
		strOutput += '零壹贰叁肆伍陆柒捌玖'.substr(num.substr(i, 1), 1)
				+ strUnit.substr(i, 1);
	return strOutput.replace(/零角零分$/, '整').replace(/零[仟佰拾]/g, '零').replace(
			/零{2,}/g, '零').replace(/零([亿|万])/g, '$1').replace(/零+元/, '元')
			.replace(/亿零{0,3}万/, '亿').replace(/^元/, "零元");
};

/**
 * 获取随机范围内整数
 * 
 * @author dongzj
 * @param min:最小值；max:最大值
 * @return
 */
TT.random = function(min, max) {
	var c = max - min + 1;
	return Math.floor(Math.random() * c + min);
}


/**
 * 获取url地址参数
 * 
 * @author dongzj
 * @param name:参数名称
 * @return
 */
TT.getQueryString = function(name) {
	var reg = new RegExp('(^|&)' + name + '=([^&]*)(&|$)', 'i');
	var r = window.location.search.substr(1).match(reg);
	if (r != null) {
		return unescape(r[2]);
	}
	return null;
}

/**
 * 获取浏览器窗口大小
 * 
 * @author dongzj
 * @param null
 * @return json
 */
TT.getWinSize = function() {
	var winWidth = 0;
	var winHeight = 0;
	// 获取窗口宽度
	if (window.innerWidth)
		winWidth = window.innerWidth;
	else if ((document.body) && (document.body.clientWidth))
		winWidth = document.body.clientWidth;
	// 获取窗口高度
	if (window.innerHeight)
		winHeight = window.innerHeight;
	else if ((document.body) && (document.body.clientHeight))
		winHeight = document.body.clientHeight;
	// 通过深入Document内部对body进行检测，获取窗口大小
	if (document.documentElement && document.documentElement.clientHeight
			&& document.documentElement.clientWidth) {
		winHeight = document.documentElement.clientHeight;
		winWidth = document.documentElement.clientWidth;
	}
	return {
		x : winWidth,
		y : winHeight
	};
}

/**
 * 设置cookie
 * 
 * @author dongzj
 * @param c_name:名称；value:值；expiredays：有效时间天数
 * @return json
 */
TT.setCookie = function(c_name, value, expiredays) {
	var exdate = new Date();
	exdate.setDate(exdate.getDate() + expiredays);
	document.cookie = c_name + "=" + escape(value)
			+ ((expiredays == null) ? ";path=/;" : ";path=/;expires=" + exdate.toGMTString());
}

/**
 * 设置cookie(有效期秒数)
 * 
 * @author dongzj
 * @param c_name:名称；value:值；expiredays：有效时间秒数
 * @return json
 */
TT.setCookieMilliseconds = function(c_name, value, milliseconds) {
	var exdate = new Date();
	exdate.setTime(exdate.getTime() + milliseconds);
	document.cookie = c_name + "=" + escape(value)
			+ (";path=/;expires=" + exdate.toGMTString())
}

/**
 * 获取cookie
 * 
 * @author dongzj
 * @param c_name:名称
 * @return json
 */
TT.getCookie = function(name) {
	var value = "";
	var cookie = ";" + document.cookie.replace(/;\s+/g, ";") + ";"
	var pos = cookie.indexOf(";" + name + "=");
	if (pos > -1) {
		var start = cookie.indexOf("=", pos);
		var end = cookie.indexOf(";", start);
		value = unescape(cookie.substring(start + 1, end));
	}
	return value;
}
/**
 * @constructor
 * @name.TT.indexOf
 * @param {Array}
 *            array
 * @param {All}
 *            value
 * @returns {Number} -1 \Number
 */
TT.indexOf = function(array, value) {
	var result = -1;
	for (var i = 0; i < array.length; i++) {
		if (array[i] == value) {
			result = i;
			break;
		} else {
			result = -1;
		}
	}
	return result;
}
/**
 * @name TT.del
 * @param {Array}
 *            array
 * @param {Object}
 *            value
 * @see 删除数组(array)里面 值 为 value 的对象
 */
TT.del = function(array, value) {
	var result;
	for (var i = 0; i < array.length; i++) {
		if (array[i] == value) {
			result = i;
			break;
		} else {
			result = -1;
		}
	}
	if (result >= 0) {
		return array.slice(0, result).concat(
				array.slice(result + 1, array.length));
	}
	return array;
}
/**
 * @constructor
 * @name TT.isEmpty
 * @param {All}
 *            obj 主体
 * @return {Boolean} true/false
 */
TT.isEmpty = function(obj) {
	return obj === null || typeof obj === 'undefined' || obj === 0
			|| obj === false || obj === ''
			|| (typeof obj.length === 'number' && obj.length === 0);
};



TT.isBlank = function (obj) {
	return obj.replace(/\s/g, "")=="";
};

/**
 * 获取两个日期相差几个月
 * 
 * @author dongzj
 * @param st:开始时间；et：结束时间
 * @return
 */
TT.getdifMonth = function(st, et) {
	var m1 = parseInt(st.split("-")[0]) * 12
			+ parseInt(st.split("-")[1].replace(/^0+/, ""));
	var m2 = parseInt(et.split("-")[0]) * 12
			+ parseInt(et.split("-")[1].replace(/^0+/, ""));
	return m2 - m1;
}

/**
 * 获取增加几天后的日期
 * 
 * @author dongzj
 * @param date:日期；days：天数
 * @return
 */
TT.addDate = function(date, days) {
	var objD = new Date(date);
	objD.setDate(objD.getDate() + days);

	var yy = objD.getFullYear();
	var MM = objD.getMonth() + 1;
	if (MM < 10)
		MM = '0' + MM;
	var dd = objD.getDate();
	if (dd < 10)
		dd = '0' + dd;
	var hh = objD.getHours();
	if (hh < 10)
		hh = '0' + hh;
	var mm = objD.getMinutes();
	if (mm < 10)
		mm = '0' + mm;
	var ss = objD.getSeconds();
	if (ss < 10)
		ss = '0' + ss;

	return yy + '-' + MM + '-' + dd + " " + hh + ":" + mm + ":" + ss;

}
/**
 * js日期格式化为yyyy-MM-dd
 */
TT.dateFormat = function(date) {
	var date = new Date(date);
	var year = date.getFullYear();
	var month = (date.getMonth() + 1).toString();
	var day = (date.getDate()).toString();
	if (month.length == 1) {
		month = "0" + month;
	}
	if (day.length == 1) {
		day = "0" + day;
	}
	return year + "-" + month + "-" + day;
}
/**
 * 获取下个月的日期
 */
TT.getNextMonth = function(st, date) {
	var nddate = new Date(date);
	var stdate = new Date(st);
	var y = nddate.getFullYear();
	var m = nddate.getMonth() + 1;
	var d = stdate.getDate();
	var ny, nm, nd;

	// 月份
	if (m == 12) {
		ny = y + 1;
		nm = 1;
	} else {
		ny = y;
		nm = m + 1;
	}
	// 天
	if (d == 31) {
		nd = getCountDays(ny, nm);
	} else if (d == 30 || d == 29) {
		if (nm == 2 && isLeapYear(ny)) {
			nd = 29;
		} else if (nm == 2) {
			nd = 28;
		} else {
			nd = d;
		}
	} else {
		nd = d;
	}

	if (nm <= 9)
		nm = "0" + nm;
	if (nd <= 9)
		nd = "0" + nd;
	var cdate = ny + "-" + nm + "-" + nd;

	return cdate;

}
/**
 * 计算两个日期相差多少天
 */
TT.getDifDays = function(stime, etime) {
	var strSeparator = "-";
	var oDate1;
	var oDate2;
	var iDays;
	oDate1 = stime.split(strSeparator);
	oDate2 = etime.split(strSeparator);
	var strDateS = new Date(oDate1[0] + "-" + oDate1[1] + "-" + oDate1[2]);
	var strDateE = new Date(oDate2[0] + "-" + oDate2[1] + "-" + oDate2[2]);
	iDays = parseInt(Math.abs(strDateS - strDateE) / 1000 / 60 / 60 / 24)// 把相差的毫秒数转换为天数
	return iDays;

}

/**
 * 余额全部投资
 * 
 */
TT.investAll = function(obj) {
	obj = obj || {
		min : 0,
		max : 0,
		avaliable : 0,
		remainder : 0
	};
	var real = 0, max = obj.max > 0 ? (obj.remainder > obj.max ? obj.max
			: obj.remainder) : obj.remainder, min = obj.min > 0 ? (obj.remainder < obj.min ? obj.remainder
			: obj.min)
			: 0;
	if (obj.avaliable >= max) {
		real = max;
	}
	if (obj.avaliable < max && obj.avaliable >= min) {
		real = obj.avaliable;
	}
	return real;
}
/**
 * 判断闰年代码
 */
TT.isLeapYear = function(year) {
	if (((year % 4) == 0) && ((year % 100) != 0) || ((year % 400) == 0)) {
		return (true);
	} else {
		return (false);
	}
}
/**
 * 获取每月多少天
 */
TT.getCountDays = function(year, month) {
	var curDate = new Date();
	curDate.setYear(year);
	curDate.setMonth(month);
	curDate.setDate(0);
	return curDate.getDate();
}
/**
 * 格式化数字千分位逗号分割
 */
TT.formatNumberRgx = function(num) {
	var parts = num.toString().split(".");
	parts[0] = parts[0].replace(/\B(?=(\d{3})+(?!\d))/g, ",");
	return parts.join(".");
};
/**
 * 格式化数字千分位逗号分割(可限制小数位保留位数)
 * s  金额
 * n  保留位数
 */
TT.formatNumber = function(s, n) { 
	n = n > 0 && n <= 20 ? n : 2; 
	s = parseFloat((s + "").replace(/[^\d\.-]/g, "")).toFixed(n) + ""; 
	var l = s.split(".")[0].split("").reverse(), r = s.split(".")[1]; 
	t = ""; 
	for (i = 0; i < l.length; i++) { 
	t += l[i] + ((i + 1) % 3 == 0 && (i + 1) != l.length ? "," : ""); 
	} 
	return t.split("").reverse().join("") + "." + r; 
} 
/**
 * 收益计算器
 */
TT.calculator = {
	run : function(obj) {
		var shouyi = {
			totalInt : 0
		};
		switch (obj.type) {
		case 3:
			shouyi = this.等额本息(obj);
			break;
		default:
			shouyi = this.一次性还款(obj);
			break;
		}
		return shouyi;
	},
	一次性还款 : function(obj) {
		var r = {};
		obj = obj || {
			amount : 0,
			stime : new Date(),
			peroid : 0,
			yield : 0
		};
		// 本金
		r.cap = obj.amount;
		// 总收益
		r.totalInt = (obj.amount * obj.yield / 365 * obj.peroid).toFixed(2);
		// 结束时间
		r.etime = new Date(obj.stime);
		r.etime.setDate(r.etime.getDate() + obj.peroid + 2);
		r.list = [];
		r.list.push({
			time : r.etime,
			cap : obj.amount,
			int : (obj.amount * obj.yield / 365 * obj.peroid).toFixed(2)
		});
		return r;
	},
	每月还息到期还本 : function(obj) {
		var r = {};
		obj = obj || {
			amount : 0,
			stime : new Date(),
			peroid : 0,
			yield : 0
		};
		var time = new Date(obj.stime), allInt = 0;
		var t = new Date(time);
		// t.setMonth(t.getMonth()+obj.peroid);
		t.setDate(t.getDate() + 1 + obj.peroid + 1);
		var p = parseInt(Math.abs(time - t) / 1000 / 60 / 60 / 24);
		// 本金
		r.cap = obj.amount;
		// 总收益
		r.totalInt = (obj.amount * obj.yield / 365 * p).toFixed(2);
		// 结束时间
		r.etime = new Date(obj.stime);
		// r.etime.setMonth(r.etime.getMonth()+obj.peroid);
		r.etime.setDate(r.etime.getDate() + obj.peroid + 2);
		r.list = [];
		var m = obj.peroid;
		var t2 = new Date(time);
		t2.setDate(t2.getDate() + 2)
		for (var d = 0; d < p;) {
			t2.setMonth(t2.getMonth() + 1);
			var days = parseInt(Math.abs(time - t2) / 1000 / 60 / 60 / 24);
			if (d + days >= p) {
				days = p - d;
			}
			d += days;
			time.setDate(time.getDate() + days);
			if (m == 1) {
				// 最后一笔
				r.list.push({
					time : new Date(time),
					cap : obj.amount,
					int : (r.totalInt - allInt).toFixed(2)
				});
			} else {
				allInt += parseFloat((obj.amount * obj.yield / 365 * days)
						.toFixed(2));
				r.list.push({
					time : new Date(time),
					cap : 0,
					int : (obj.amount * obj.yield / 365 * days).toFixed(2)
				});
			}
			m--;
		}
		return r;
	},
	等额本息 : function(obj) {
		obj = obj || {
			amount : 0,
			stime : new Date(),
			peroid : 0,
			yield : 0
		};
		var amount = obj.amount;
		var time = new Date(obj.stime);
		var endTime = new Date(time);
		endTime.setDate(time.getDate() + obj.peroid + 2);
		var step = TT.getdifMonth(TT.dateFormat(obj.stime), TT
				.dateFormat(endTime));
		n = Math.pow((1 + obj.yield / 12), step) * (obj.yield / 12) * amount
				/ (Math.pow((1 + obj.yield / 12), step) - 1);
		var allInt = 0, allCap = 0, data = [], r = {}, time = new Date(
				obj.stime);
		time.setDate(time.getDate() + 2);
		for (var i = 1; i <= step; i++) {
			var cap = 0, int = 0;
			if (i == step) {// 最后一期实际收益
				cap = (obj.amount - parseFloat(allCap)).toFixed(2);
				int = (n * step - parseFloat(allCap) - cap - parseFloat(allInt))
						.toFixed(2);
				time = new Date(endTime);
			} else {
				int = amount * (obj.yield / 12);
				int = int.toFixed(2);
				cap = n - int;
				cap = cap.toFixed(2);
				amount -= cap;
				time.setMonth(time.getMonth() + 1);
			}
			allInt += parseFloat(int);
			allCap += parseFloat(cap);

			data.push({
				"cap" : cap,
				"liveCap" : (obj.amount - allCap),
				"int" : int,
				"time" : new Date(time)
			});
		}
		r["list"] = data;
		r["totalInt"] = allInt.toFixed(2);
		r["cap"] = allCap;
		r["per"] = n.toFixed(2);
		return r;
	}
}
//js加法
TT.myAdd=function(arg1, arg2) {
    var r1, r2, m;
    try { r1 = arg1.toString().split(".")[1].length } catch (e) { r1 = 0 }
    try { r2 = arg2.toString().split(".")[1].length } catch (e) { r2 = 0 }
    m = Math.pow(10, Math.max(r1, r2))
    return (arg1 * m + arg2 * m) / m
};
//js减法
TT.mySub=function(arg1, arg2) {
    var r1, r2, m, n;
    try { r1 = arg1.toString().split(".")[1].length } catch (e) { r1 = 0 }
    try { r2 = arg2.toString().split(".")[1].length } catch (e) { r2 = 0 }
    m = Math.pow(10, Math.max(r1, r2));
    //last modify by deeka
    //动态控制精度长度
    n = (r1 >= r2) ? r1 : r2;
    return ((arg1 * m - arg2 * m) / m).toFixed(n);
};
//js乘法
TT.myMul=function(arg1, arg2) {
    var m = 0, s1 = arg1.toString(), s2 = arg2.toString();
    try { m += s1.split(".")[1].length } catch (e) { }
    try { m += s2.split(".")[1].length } catch (e) { }
    return Number(s1.replace(".", "")) * Number(s2.replace(".", "")) / Math.pow(10, m)
};
//js除法
TT.myDiv=function(arg1, arg2) {
    var t1 = 0, t2 = 0, r1, r2;
    try { t1 = arg1.toString().split(".")[1].length } catch (e) { }
    try { t2 = arg2.toString().split(".")[1].length } catch (e) { }
    with (Math) {
        r1 = Number(arg1.toString().replace(".", ""))
        r2 = Number(arg2.toString().replace(".", ""))
        return (r1 / r2) * pow(10, t2 - t1);
    }
};

