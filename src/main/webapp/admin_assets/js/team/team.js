var Team = function () {

    var newdes = CKEDITOR.replace('newDes')
    var editdes = CKEDITOR.replace("_des");

    var newData = {
        name: $("#title").val(),
        des: newdes.getData(),
        teamType: $("teamType").val()
    }

    var editData = {

        title: $("#_title").val(),
        des: editdes.getData(),
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
        newdes.insertHtml("<img src='" + path + "'>");
    }

    var handleRefreshData = function () {
        newData.name = $("#title").val();
        newData.des = newdes.getData();
        newData.teamType = $("#teamType").val();
        editData.title = $("#_title").val();
        editData.des = editdes.getData();
        editData.teamType = $("#_teamType").val()
    }
    /**
     * 创建新项目组
     * @param button
     */
    var handleAddTeam = function () {
        handleRefreshData();
        $.ajax({
            url: 'team.hopedo',
            type: 'POST',
            dataType: 'json',
            data: (newData),
            success: function (data) {
                var status = data.returnState;
                if (status == "OK") {
                    toast.success(data.returnMsg);
                    $("#addTeamButton").hide();
                    setTimeout(function () {
                        window.location.href = "../team/conf.hopedo";
                    }, 2000)

                } else {
                    toast.error(data.returnMsg);
                }
            },
            error: function (data) {
                toast.error(data);
            }

        });

    }

    var handleRefreshTeamType = function () {

        var teamTypeSelection = $("#teamType");
        teamTypeSelection.empty();
        $.ajax({
            url: 'teamType.hopedo',
            type: 'GET',
            dataType: 'json',
            success: function (data) {
                var status = data.returnState;
                if (status == "OK") {
                    toast.success("项目组类型刷新成功");
                    var teamTypeList = data.returnData.teamTypeList;
                    for (var i = 0; i < teamTypeList.length; i++) {
                        teamTypeSelection.append('<option value="' + teamTypeList[i].teamTypeId + '">' + teamTypeList[i].name + '</option>');
                    }
                } else {
                    toast.error(data.returnMsg);
                }
            },
            error: function (data) {
                toast.error(data);
            }

        });
    }

    $("#addTeamButton").live("click", function () {
        handleRefreshData();
        handleAddTeam();
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
            handleRefreshTeamType();
        }
    };

}();