/**
 * Created by zhuleqi on 2018/11/10.
 */

var HOST = "http://www.leqienglish.com"
var TIME_OUT = 6000
//var HOST = "http://192.168.43.9:8080"

/**
 * 打开下载app的界面
 */
function openDownloadApp() {
    // layer.open({
    //     type: 1
    //     ,offset: 'r' //具体配置参考：offset参数项
    //     ,content: '<div style="padding: 20px 80px;">' +
    //     '' +
    //     '' +
    //     '' +
    //     '</div>'
    //
    //     ,shade: 0 //不显示遮罩
    //     ,yes: function(){
    //         layer.closeAll();
    //     }
    // });
}

function browserRedirect() {
    var sUserAgent = navigator.userAgent.toLowerCase();
    var bIsIpad = sUserAgent.match(/ipad/i) == "ipad";
    var bIsIphoneOs = sUserAgent.match(/iphone os/i) == "iphone os";
    var bIsMidp = sUserAgent.match(/midp/i) == "midp";
    var bIsUc7 = sUserAgent.match(/rv:1.2.3.4/i) == "rv:1.2.3.4";
    var bIsUc = sUserAgent.match(/ucweb/i) == "ucweb";
    var bIsAndroid = sUserAgent.match(/android/i) == "android";
    var bIsCE = sUserAgent.match(/windows ce/i) == "windows ce";
    var bIsWM = sUserAgent.match(/windows mobile/i) == "windows mobile";
    if (bIsAndroid){
        return "android"
    }

    if (bIsIphoneOs){
        return "iphone"
    }

    return "other"
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


    var wordNode = $("<div class='layui-col-md4'><p><span style='font-size: 18px;font-weight: bold'><a href='/html/word/wordInfo.html?id="+word.id+"&word="+word.word+"'>"+word.word+"</a></span></p></div>")
    var pround = $("<div class='layui-col-md8'></div>")

    pround.append(createProuncePane($,word))

    var mean = $("<div class='layui-col-md5'></div>")
    pround.append("<p/>")
    addMeans($,word.means,pround)

    root.append(wordNode, pround)

    return root
}

function createImageAudio($, word) {

}

function createAudio($,contry, path , prod) {
   return "<span style='font-size: 16px;'>"+contry+"<a onclick='playAudio(\""+path+"\");return false;'>["+prod+"]</a><input type='image' style='CURSOR: hand' alt='play' height='20px' onclick='playAudio(\""+path+"\");return false;' src='/res/static/images/play/play.png'></input></span>"
}

function createProuncePane($,word) {
    if (word.phAm === ''){
        return $("<span style='font-size: 14px;font-weight: bold'><input type='image' style='max-height: 20px;max-width: 20px' onclick='playAudio(\""+word.ttsAudioPath+"\");return false' src='/res/static/images/play/play.png'></input></span>")
    }else{
        return  $(createAudio($,"美",word.amAudionPath,word.phAm)+"&nbsp;&nbsp;&nbsp;"+createAudio($,"英",word.enAudioPath,word.phEn) )
    }
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


function hiddenDownloadNode($) {
    var currentBrowser = browserRedirect()

           if (currentBrowser === "android" || currentBrowser === "iphone" ) {
               $("#downloadPane").hide()
               $("#phonedownloadPane").show()

               return
           }







    //  $("#downloadBottom").hide()
}


function playAudio(path) {
    var player = $("#wordAudio")[0]
    if (!player.paused){
        player.pause()
    }
    var httpPath = "/file/download?path="+path
    $("#wordAudio").attr("src",httpPath)
    player.play()

}

function downloadApp() {

    var currentBrowser = browserRedirect()
    if (currentBrowser === "iphone") {
        downloadIOSApp()
        return;
    }

    if(currentBrowser === "android")
    {
        if (is_weixn()){
            //layer.alert('weixin', {icon: 5});
            window.location.href = HOST + "/html/share/phonedownload.html";
            return;
        }

    }

    downloadAndroid();
}

function downloadAndroid() {
    window.location.href = HOST + "/version/findNewestFileByType?type=400#mp.weixin.qq.com";
}

function downloadIOSApp() {
    window.location.href = "https://itunes.apple.com/us/app/%E4%B9%90%E5%85%B6%E8%8B%B1%E8%AF%AD/id1441370618"
}

function is_weixn(){
    var ua = navigator.userAgent.toLowerCase();
    if(ua.match(/MicroMessenger/i)=="micromessenger") {
        return true;
    } else {
        return false;
    }
}

