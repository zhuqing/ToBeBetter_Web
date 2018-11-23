/**
 * Created by zhuleqi on 2018/11/22.
 */
function initWeiXinAudion(path) {
    $('.weixinAudio').weixinAudio({
        autoplay: false,
        src: '/file/download?path=' + path,
        currentTimeChange: function (time) {
            for (var i = 0; i < englishArray.length; i++) {
                var startTime = englishArray[i].startTime
                var endTime = englishArray[i].endTime
                var node = englishArray[i].node

                if (time >= startTime && time <= endTime) {
                    node.css("color", "red")
                } else {
                    node.css("color", "black")
                }
            }
        }
    });
}

//加载Content下的所有
function loadSegments($, id) {
    $.ajax({
        timeout: TIME_OUT, //超时时间设置，单位毫秒
        url: "/segment/findById?id=" + id,
        type: "GET",
        success: function (data) {
            var segment = $.parseJSON(data.data)

            $("#title").append($("<a href='#'>" + segment.title + "</a>"))
            if (isIn(segment.updateDate, 1000 * 60 * 60)) {
                $("#lunchDate").append($("<span>刚刚</span>"))
            } else {
                $("#lunchDate").append($("<span>" + getSmpFormatDateByLong(segment.updateDate, true) + "</span>"))
            }

            $("#audioTitle").text(segment.title)
            initWeiXinAudion(segment.audioPath)
            splitContent($, segment.content)
            layer.closeAll('loading');

            // var length =  englishArray[englishArray.length-1].endTime - englishArray[0].startTime
            // var sencends = length/1000
            // var min = sencends/60
            // var sencend = sencends%60
            // $("#audio_length").text(min+"."+sencend)
            //openDownloadApp()
        },
        error: function (data) {
            layer.alert('sorry,请过会从新加载', {icon: 5});
            //openDownloadApp()
        }
    })
}

function loadShortWord($, id) {
    $.ajax({
        timeout: TIME_OUT, //超时时间设置，单位毫秒
        url: "/shortWord/findBySegmentId?segmentId=" + id,
        type: "GET",
        success: function (data) {
            var shortWords = $.parseJSON(data.data)

            showShortWord(shortWords)

        },

    })
}

function showShortWord(shortWords) {
    for (var i = 0; i < shortWords.length; i++) {
        var shortWord = shortWords[i]
        var shortWordRoot = $(" <div class='layui-row'></div>")
        var title = $("<p ><span style='font-size: 18px;font-weight: bold'>" + (i + 1) + "." + shortWord.word + "</span></p>")
        var info = $("<p ><span style='font-size: 14px;color:dimgray'>" + shortWord.info + "</span></p>")
        shortWordRoot.append(title, info)
        loadSentence(shortWord.id, shortWordRoot)
        $("#shortWordContainer").append(shortWordRoot)
    }
}

function loadSentence(shortWordId, node) {
    $.ajax({
        timeout: TIME_OUT, //超时时间设置，单位毫秒
        url: "/sentence/findByShortWordId?shortWordId=" + shortWordId,
        type: "GET",
        success: function (data) {
            var sentences = $.parseJSON(data.data)


            for (var i = 0; i < sentences.length; i++) {
                var sen = sentences[i]
                var english = $("<p ><span style='font-size: 14px'>" + sen.english + "</span></p>")
                var chinese = $("<p ><span style='font-size: 12px ; color: dimgray'>" + sen.chinese + "</span></p>")
                node.append(english, chinese);
            }

        },

    })
}

function loadWords($, segmentId) {
    $.ajax({
        timeout: 4000, //超时时间设置，单位毫秒
        url: "/english/word/findBySegmentId?segmentId=" + segmentId,
        type: "GET",
        success: function (data) {
            var sentences = $.parseJSON(data.data)


            for (var i = 0; i < sentences.length; i++) {
                var word = sentences[i]
                $("#wordContainer").append(createWordItem($, word));
            }

        },

    })
}
/**
 *   public static final String SLIP_TIME_AND_TEXT = "-->";
 public static final String SLIP_START_AND_END = "==>";
 public static final String SLIP_EN_AND_CH = ">::<";
 public static final String SLIP_END = "<=====>";
 public static final String SLIP_SENTENCE = "\n";
 * @param $
 * @param english
 * @param chinish
 * @returns {*|jQuery|HTMLElement}
 */

function splitContent($, content) {
    var arr = content.split("\n")
    englishArray = Array(arr.length)
    for (var i = 0; i < arr.length; i++) {
        var scentence = arr[i]
        var subarr = scentence.split(">::<");
        var ch = ""
        if (subarr.length == 2) {
            ch = subarr[1]
        }

        var english = subarr[0]
        var endsubarr = english.split("-->")
        var startTime = 0
        var endTime = 0
        if (endsubarr.length == 2) {
            english = endsubarr[1]
            var text = endsubarr[0]
            var startAndEndTimeArr = text.split("==>")

            if (startAndEndTimeArr.length == 2) {
                startTime = startAndEndTimeArr[0]
                endTime = startAndEndTimeArr[1]
            }

        } else {
            english = ""
        }

        var title = $("<p ><span style='font-size: 18px'>" + english + "</span></p>")
        var chinese = $("<p><span style='font-size: 13px;color: dimgrey'>" + ch + "</span></p>")

        englishArray[i] = {
            node: title,
            startTime: startTime,
            endTime: endTime

        }
        $("#container").append(title, chinese)
    }


}