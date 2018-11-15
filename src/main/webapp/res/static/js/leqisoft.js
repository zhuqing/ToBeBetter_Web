/**
 * Created by zhuleqi on 2018/11/10.
 */

var HOST = "http://localhost:8080"

/**
 * 打开下载app的界面
 */
function openDownloadApp() {
    layer.open({
        type: 1
        ,offset: 'r' //具体配置参考：offset参数项
        ,content: '<div style="padding: 20px 80px;">' +
        '' +
        '' +
        '' +
        '</div>'

        ,shade: 0 //不显示遮罩
        ,yes: function(){
            layer.closeAll();
        }
    });
}

/**
 * 获取url上的参数值
 *
 * @param name
 * @returns
 */
function getURLValue(name)

{

    var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)");

    var r = window.location.search.substr(1).match(reg);

    if (r != null)
        return unescape(r[2]);
    return null;

}

/**
 *当前时间-发布时间是否在during范围内
 * @param l
 * @param during
 * @returns {boolean}
 */
function isIn(lunchTime, during) {
    var  currentDate = new Date()
    return currentDate.getTime() - lunchTime < during
}



/**
 * =========================================
 * Created by simon on 2016/4/22.
 */
//扩展Date的format方法
Date.prototype.format = function (format) {
    var o = {
        "M+": this.getMonth() + 1,
        "d+": this.getDate(),
        "h+": this.getHours(),
        "m+": this.getMinutes(),
        "s+": this.getSeconds(),
        "q+": Math.floor((this.getMonth() + 3) / 3),
        "S": this.getMilliseconds()
    }
    if (/(y+)/.test(format)) {
        format = format.replace(RegExp.$1, (this.getFullYear() + "").substr(4 - RegExp.$1.length));
    }
    for (var k in o) {
        if (new RegExp("(" + k + ")").test(format)) {
            format = format.replace(RegExp.$1, RegExp.$1.length == 1 ? o[k] : ("00" + o[k]).substr(("" + o[k]).length));
        }
    }
    return format;
}
/**
 *转换日期对象为日期字符串
 * @param date 日期对象
 * @param isFull 是否为完整的日期数据,
 * 为true时, 格式如"2000-03-05 01:05:04"
 * 为false时, 格式如 "2000-03-05"
 * @return 符合要求的日期字符串
 */
function getSmpFormatDate(date, isFull) {
    var pattern = "";
    if (isFull == true || isFull == undefined) {
        pattern = "yyyy-MM-dd hh:mm:ss";
    } else {
        pattern = "yyyy-MM-dd";
    }
    return getFormatDate(date, pattern);
}
/**
 *转换当前日期对象为日期字符串
 * @param date 日期对象
 * @param isFull 是否为完整的日期数据,
 * 为true时, 格式如"2000-03-05 01:05:04"
 * 为false时, 格式如 "2000-03-05"
 * @return 符合要求的日期字符串
 */
function getSmpFormatNowDate(isFull) {
    return getSmpFormatDate(new Date(), isFull);
}
/**
 *转换long值为日期字符串
 * @param l long值
 * @param isFull 是否为完整的日期数据,
 * 为true时, 格式如"2000-03-05 01:05:04"
 * 为false时, 格式如 "2000-03-05"
 * @return 符合要求的日期字符串
 */
function getSmpFormatDateByLong(l, isFull) {
    return getSmpFormatDate(new Date(l), isFull);
}
/**
 *转换long值为日期字符串
 * @param l long值
 * @param pattern 格式字符串,例如：yyyy-MM-dd hh:mm:ss
 * @return 符合要求的日期字符串
 */
function getFormatDateByLong(l, pattern) {
    return getFormatDate(new Date(l), pattern);
}
/**
 *转换日期对象为日期字符串
 * @param l long值
 * @param pattern 格式字符串,例如：yyyy-MM-dd hh:mm:ss
 * @return 符合要求的日期字符串
 */
function getFormatDate(date, pattern) {
    if (date == undefined) {
        date = new Date();
    }
    if (pattern == undefined) {
        pattern = "yyyy-MM-dd hh:mm:ss";
    }
    return date.format(pattern);
}

/**
 *
 */
function createWordItem($,word) {
    var root = $("<div class='layui-row layui-col-space3'></div>")


    var wordNode = $("<div class='layui-col-md4'><p><span style='font-size: 18px;font-weight: bold'><a>"+word.word+"</a></span></p></div>")
    var pround = $("<div class='layui-col-md4'></div>")

    if (word.phAm === ''){
       pround.append($("<span style='font-size: 14px;font-weight: bold'><a>TTS</a></span><"))
   }else{
        pround.append($("<span style='font-size: 16px;'>美<a>["+word.phAm+"]</a></span><span style='font-size: 16px;'> 英<a>["+word.phAm+"]</a></span>"))
   }

    var mean = $("<div class='layui-col-md4'></div>")
    addMeans($,word.means,mean)

    root.append(wordNode, pround,mean)

    return root
}

function addMeans($,meansStr , root) {
   var meanArr =  $.parseJSON(meansStr)
    for (var i = 0 ; i < meanArr.length ;i++){
       var mean = meanArr[i]

        var meanRoot = $("<p></p>")

        meanRoot.append($("<span>"+ mean.part+"</span>"))

        var meansArr = mean.means
        var meansSS = ""
        for (var j = 0 ; j <meansArr.length ; j++){
            meansSS += meansArr[j]+";"
        }

        meansSS = meansSS.substring(0,meansSS.length-1)
        meanRoot.append($("<span>"+ meansSS+"</span>"))
        root.append(meanRoot)

    }
}
