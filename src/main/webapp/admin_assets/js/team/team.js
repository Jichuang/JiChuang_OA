var Team = function () {

    var newData = {
        title: $("#title").val(),
        des: $("#des").val(),
        teamType: $("teamType").val()
    }

    var editData = {

        title: $("#_title").val(),
        des: $("#_des").val(),
        teamType: $("#_teamType").val()
    }

    var image = $("#image").val();

    var handleUploadImage = function () {

        $.ajaxFileUpload({
            url: '../baseAjax/uploadImage.hopedo',
            type: 'post',
            secureuri: false, //一般设置为false
            fileElementId: 'image', // 上传文件的id名 不能够添加# 因为它自带前缀
            dataType: 'json', //返回值类型，一般设置为json、application/json
            elementIds: 'image', //传递参数到服务器
            success: function (data) {
                var data = eval(data);
                var status = data.returnState;
                console.log(data.returnData.path);
                if (status == "OK") {
                    toast.success(data.returnMsg);
                } else {
                    toast.error(data.returnMsg);
                }


            },
            error: function (data, status, e) {
                toast.error(e);
            }

        })


    }

    var handleAddTeam = function () {

    }

    $("#updateImageButton").on("click", function () {
        handleUploadImage();
    });


    return {
        init: function () {
            toast.info("进入项目组编辑");
        }
    };

}();