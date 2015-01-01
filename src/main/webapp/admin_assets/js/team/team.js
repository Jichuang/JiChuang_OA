var Team = function () {

    var basePath = function () {
        var url = window.location + "";
        var h = url.split("//");
        var x = h[1].split("/");
        return h[0] + "//" + window.location.host + "/" + x[1] + "/";
    }();
    var newDes = CKEDITOR.replace('newdes')
    var editDes = CKEDITOR.replace("_des");
    var editTeam = null;
    var newData = {
        name: $("#title").val(),
        des: newDes.getData(),
        teamType: $("teamType").val()
    }
    var editData = {
        teamId: $("#teamId").text(),
        name: $("#_title").val(),
        des: editDes.getData(),
        teamType: $("#_teamType").val()
    }
    var image = $("#image").val();
    var TeamService = {
        uploadImage: function (id, name, imagesUl) {
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
                    if (status == "OK") {
                        toast.success(data.returnMsg);
                        imagesUl.append('<br/> <li>文件名 <span class="divider">:</span><span class = "imagePath"> '
                            + data.returnData.path + ' ' +
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
        },
        image2Text: function (path, des) {
            des.insertHtml("<img src='" + path + "'>");
        },
        refreshTeamData: function () {
            newData.name = $("#title").val();
            newData.des = newDes.getData();
            newData.teamType = $("#teamType").val();
            editData.teamId = $("#teamId").text();
            editData.name = $("#_title").val();
            editData.des = editDes.getData();
            editData.teamType = $("#_teamType").val()
        },
        addTeam: function () {
            TeamService.refreshTeamData();
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
        },
        refreshTeamType: function (teamTypeSelection) {
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
                            teamTypeSelection.append('<option value="' + teamTypeList[i].teamTypeId + '">'
                                + teamTypeList[i].name + '</option>');
                        }
                    } else {
                        toast.error(data.returnMsg);
                    }
                },
                error: function (data) {
                    toast.error(data);
                }
            });
        },
        refreshTeam: function () {
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
                        editData.des = editDes.setData(team.des);
                        editData.teamType = $("#_teamType").find(team.teamTypeId.name).attr("selected", "selected");
                    } else {
                        toast.error(data.returnMsg);
                    }
                }
            });
        },
        deleteTeam: function () {
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
        },
        updateTeam: function () {
            TeamService.refreshTeamData();
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
    }

    var handleEvent = function () {
        $("#updateTeamButton").on("click", function () {
            TeamService.updateTeam();
        })
        $("#addTeamButton").live("click", function () {
            TeamService.addTeam();
        })
        $("#updateImageButton").on("click", function () {
            TeamService.uploadImage("image", "image", $("#images"));
        });
        $("#_updateImageButton").on("click", function () {
            TeamService.uploadImage("_image", "image", $("#_images"));
        });
        $("#deleteTeam").live("click", function () {
            TeamService.deleteTeam();
        })
        $("#refreshTeam").on("click", function () {
            TeamService.refreshTeam();
        });
        $("ul li .insertImage").live("click", function () {
            var path = $(this).parent().first().children(".imagePath").text();
            TeamService.image2Text(path, newDes);
            TeamService.image2Text(path, editDes);
        });
    }

    return {
        init: function () {
            handleEvent();
        },
        refresh: function () {
            TeamService.refreshTeamType($("#_teamType"));
            TeamService.refreshTeam();
        },
        refreshTeamTypeForAdd: function () {
            TeamService.refreshTeamType($("#teamType"));
        }
    };

}();