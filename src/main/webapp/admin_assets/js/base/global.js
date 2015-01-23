/**
 * Created by Zhaopeng-Rabook on 14-12-23.
 */
/**
 * 首先是全局的地址
 */
var basePath = function () {
    var url = window.location + "";
    var h = url.split("//");
    var x = h[1].split("/");
    return h[0] + "//" + window.location.host + "/" + x[1] + "/";
}();

var globalConstant = {

    FOUNDER: "创建者",
    READER:"只读",
    WRITER:"读写"
}

var globalFunction = {

    returnResult: function (data, message, binding) {
        var messageNull = message == "" || message == undefined;
        if (data.returnState == "OK") {
            if (binding != false)
                toast.success(messageNull ? data.returnMsg : message);
            return true;
        } else {
            if (binding != false)
                toast.success(messageNull ? data.returnMsg : message);
            return false;
        }
    }
}
