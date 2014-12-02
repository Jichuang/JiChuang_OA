/**
 * Created by Zhaopeng-Rabook on 14-12-2.
 */
var MemberConf = function () {
    /**
     * 用于刷新当前页面的成员对象的信息
     * 要塞的东西有很多 首先id们
     * 1、name
     * 2、email
     * 3、shortInfo
     * 4、website
     * 5、country
     * 6、birth
     * 7、postSmall
     * 8、roleSmall
     * 9、post
     * 10、role
     * 11、status
     * 12、messageTable
     * 13、taskTable
     * 14、updateName
     * 15、updatePhoneNumber
     * 16、updateSex
     * 17、updateShortInfo
     * 18、updateInfo
     * 19、nowPassword
     * 20、newPassword
     * 21、confrimPassword
     * 22、teamTable
     */
    var memberData = {
        name: $("#name"),
        email: $("#email"),
        shortInfo: $("#shortInfo"),
        website: $("#website"),
        country: $("#country"),
        birth: $("#birth"),
        postSmall: $("#postSmall"),
        roleSmall: $("#roleSmall"),
        post: $("#post"),
        role: $("#role"),
        status: $("#status"),
        messageTable: $("#messageTable"),
        taskTable: $("#taskTable"),
        updateName: $("#updateName"),
        updatePhoneNumber: $("updatePhoneNumber"),
        updateSex: $("#updateSex"),
        updateShortInfo: $("#updateShortInfo"),
        updateInfo: $("#updateInfo"),
        nowPassword: $("#nowPassword"),
        newPassword: $("#newPassword"),
        confrimPassword: $("#confrimPassword"),
        teamTable: $("#teamTable")
    }

    var handleRefresh = function () {
        $.ajax({
            url: "member/" + id + ".hopedo",
            dataType: "json",
            type: "GET",
            data: (data),
            async: false,
            success: function (data) {
                var status = data.returnState;
                if (status == "OK") {
                    toast.success(data.returnMsg);
                    //TODO:接下来向各个控件里面塞东西了
                    var ajaxMember = data.returnData.ajaxMember;
                    memberData.name.text(ajaxMember.name);
                } else {
                    toast.error(data.returnMsg);
                }
            }
        })
    }

    return {
        init: function () {
            handleRefresh();
        }
    };


}