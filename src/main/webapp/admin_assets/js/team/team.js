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

    var imagesUl = $("#images");


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
                    imagesUl.append('<br/> <li>文件名 <span class="divider">:</span><span class = "imagePath"> ' + data.returnData.path + ' ' +
                        '</span><a href="javascript:;" class = "insertImage">[插入到文本域中]</a><br/>');
                }
                else {
                    toast.error(data.returnMsg);
                }
            },
            error: function (data, status, e) {
                toast.error(e);
            }

        })
    }

    var handleInsertImage2TextArea = function (path) {
        CKEDITOR.instances.content.insertHtml("<img src='" + path + "'>");
    }


    var handleAddTeam = function (button) {

        $.ajax({
            url: 'team.hopedo',
            type: 'post',
            dataType: 'json',
            data: (newData),
            success: function (data) {
                var status = data.returnState;
                if (status == "OK") {
                    toast.success(data.returnMsg);
                    button.hide();
                    window.location.href = "../team/conf.hopedo";
                } else {
                    toast.error(data.returnMsg);
                }
            },
            error: function (data) {
                toast.error(data);
            }

        });

    }

    $("#addTeamButton").on("click", function () {
        handleAddTeam($(this))
    })


    $("#updateImageButton").on("click", function () {
        handleUploadImage();
    });

    $("ul li .insertImage").live("click", function () {
        var path = $(this).parent().first().children(".imagePath").text();
        handleInsertImage2TextArea(path);
    })


    return {
        init: function () {
            toast.info("进入项目组编辑");
        }
    };

}();