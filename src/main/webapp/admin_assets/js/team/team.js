var basePath = function () {
    var url = window.location + "";
    var h = url.split("//");
    var x = h[1].split("/");
    return h[0] + "//" + window.location.host + "/" + x[1] + "/";
}();

var Team = function () {

    var newdes = CKEDITOR.replace('newDes')
    var editdes = CKEDITOR.replace("_des");
    var editTeam = null;

    var newData = {
        name: $("#title").val(),
        des: newdes.getData(),
        teamType: $("teamType").val()
    }

    var editData = {
        teamId: $("#teamId").text(),
        name: $("#_title").val(),
        des: editdes.getData(),
        teamType: $("#_teamType").val()
    }


    var image = $("#image").val();

    var handleUploadImage = function (id, name, imagesUl) {

        $.ajaxFileUpload({
            url: basePath + '/baseAjax/uploadImage.hopedo',
            type: 'post',
            secureuri: false, //一般设置为false
            fileElementId: id, // 上传文件的id名 不能够添加# 因为它自带前缀
            dataType: 'json', //返回值类型，一般设置为json、application/json
            elementIds: name, //传递参数到服务器
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

    var handleInsertImage2TextArea = function (path, des) {
        des.insertHtml("<img src='" + path + "'>");
    }

    var handleRefreshData = function () {
        newData.name = $("#title").val();
        newData.des = newdes.getData();
        newData.teamType = $("#teamType").val();
        editData.teamId = $("#teamId").text();
        editData.name = $("#_title").val();
        editData.des = editdes.getData();
        editData.teamType = $("#_teamType").val()
    }
    /**
     * 创建新项目组
     * @param button
     */
    var handleAddTeam = function () {
        $.ajax({
            url: basePath + 'team.hopedo',
            type: 'POST',
            dataType: 'json',
            data: (newData),
            success: function (data) {
                var status = data.returnState;
                if (status == "OK") {
                    toast.success(data.returnMsg);
                    $("#addTeamButton").hide();
                    setTimeout(function () {
                        window.location.href = basePath + "/team/conf.hopedo";
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

    var handleRefreshTeamType = function (teamTypeSelection) {

        teamTypeSelection.empty();
        $.ajax({
            url: basePath + 'teamType.hopedo',
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

    /**
     * 在页面内刷新项目组信息
     */
    var handleTeamRefresh = function () {
        var teamId = $("#teamId").text();
        var data = {
            teamId: teamId
        }
        $.ajax({
            url: basePath + 'team/' + teamId + '.hopedo',
            type: 'GET',
            data: (data),
            dataType: 'json',
            success: function (data) {
                var status = data.returnState;
                if (status == "OK") {
                    toast.info("项目组信息获取成功，准备修改");
                    var team = data.returnData.team;
                    editTeam = team;
                    $("#oldTeamName").text(team.name);
                    editData.name = $("#_title").val(team.name);
                    editData.des = editdes.setData(team.des);
                    editData.teamType = $("#_teamType").find(team.teamTypeId.name).attr("selected", "selected");
                } else {
                    toast.error(data.returnMsg);
                }
            }
        });
    }

    /**
     * 删除项目组
     */
    var handleDeleteTeam = function () {
        var $modal = $('#deleteModal');
        $modal.modal();
        $("#deleteTeamButton").on("click", function () {
            var putTeamName = $("#deleteTeamName").val();
            var oldTeamName = $("#oldTeamName").text();
            if (putTeamName != oldTeamName) {
                toast.error("项目组名称不匹配");
            }
            else {
                $.ajax({
                    url: basePath + 'team/' + $("#teamId").text() + '.hopedo',
                    type: 'DELETE',
                    dataType: 'json',
                    success: function (data) {
                        var status = data.returnState;
                        if (status == "OK") {
                            toast.success("项目组删除成功");
                            setTimeout(function () {
                                window.location.href = basePath + "/team/conf.hopedo";
                            }, 1000)

                        } else {
                            toast.error(data.returnMsg);
                        }
                    }
                });
            }
        });
    }

    var json2form = function (jsonString) {
        var dataString = "";
        for (var e in jsonString) {
            dataString += e + "=" + jsonString[e] + "&";
        }
        return dataString.substring(0, dataString.length - 1);
    }


    /**
     * 执行更新操作
     */
    var handleUpdateTeam = function () {
        console.log(editData);
        $.ajax({
            url: basePath + 'team.hopedo',
            type: 'PUT',
            data: (editData),
            dataType: 'JSON',
            success: function (data) {
                var status = data.returnState;
                if (status == "OK") {
                    toast.success(data.returnMsg);
                    $("#updateTeamButton").hide();
                    setTimeout(function () {
                        window.location.href = basePath + "/team/conf.hopedo";
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


    $("#updateTeamButton").on("click", function () {
        handleRefreshData();
        handleUpdateTeam();
    })
    $("#addTeamButton").live("click", function () {
        handleRefreshData();
        handleAddTeam();
    })
    $("#updateImageButton").on("click", function () {
        handleUploadImage("image", "image", $("#images"));
    });
    $("#_updateImageButton").on("click", function () {
        handleUploadImage("_image", "image", $("#_images"));
    });
    $("#deleteTeam").live("click", function () {
        handleDeleteTeam();
    })
    $("#refreshTeam").on("click", function () {
        handleTeamRefresh();
    })


    $("ul li .insertImage").live("click", function () {
        var path = $(this).parent().first().children(".imagePath").text();
        handleInsertImage2TextArea(path, newdes);
        handleInsertImage2TextArea(path, editdes);
    })


    return {
        init: function () {
            toast.info("进入项目组编辑");
        },
        refresh: function () {
            handleRefreshTeamType($("#_teamType"));
            handleTeamRefresh();
        },
        refreshTeamTypeForAdd: function () {
            handleRefreshTeamType($("#teamType"));
        }
    };

}();