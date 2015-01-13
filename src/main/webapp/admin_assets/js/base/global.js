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

var globalFunction = {

    returnResult: function (data, message) {
        var messageNull = message == "" || message == undefined;
        if (data.returnState == "OK") {
            toast.success(messageNull ? data.returnMsg : message);
            return true;
        } else {
            toast.success(messageNull ? data.returnMsg : message);
            return false;
        }
    }
}
