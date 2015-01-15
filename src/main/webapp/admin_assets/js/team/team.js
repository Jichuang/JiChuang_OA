var Team = function () {

    var basePath = function () {
        var url = window.location + "";
        var h = url.split("//");
        var x = h[1].split("/");
        return h[0] + "//" + window.location.host + "/" + x[1] + "/";
    }();
    var newDes = CKEDITOR.replace('newDes')
    var editTeam = null;
    var newData = {
        teamId: "",
        name: $("#title").val(),
        des: newDes.getData(),
        teamTypeId: {
            teamTypeId: $("#teamTypeId")
        },
        //注意 这里需要添加image的信息
        image: ""
    }
    var image = $("#image").val();

    function handleMutliFileUpload(Tbody, dataName) {
        var images = Tbody.children();
        var returnJSON = "[";
        for (var i = 0; i < images.length; i++) {
            var imageInfo = ($(images[i]).data(dataName));
            returnJSON += imageInfo;
            if (i < images.length - 1) {
                returnJSON += ",";
            }
        }
        returnJSON += "]";
        return returnJSON;
    }

    var TeamService = {
        uploadImage: function (id, name, imagesUl) {
            $.ajaxFileUpload({
                url: basePath + '/baseAjax/uploadImage.hopedo',
                type: 'post',
                secureuri: false, //一般设置为false
                fileElementId: id, // 上传文件的id名 不能够添加# 因为它自带前缀
                contentType: 'application/json', //返回值类型，一般设置为json、application/json
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
            newData.teamId = $("#teamId").text();
            newData.teamTypeId.teamTypeId = $("#teamType").val();
        },
        addTeam: function () {
            TeamService.refreshTeamData();
            newData.image = handleMutliFileUpload($(".completeFiles"), "imageinfo");
            $.ajax({
                url: basePath + 'team.hopedo',
                type: 'POST',
                contentType: 'application/json',
                data: JSON.stringify(newData),
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
                contentType: 'application/json',
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
                contentType: 'application/json',
                success: function (data) {
                    var status = data.returnState;
                    if (status == "OK") {
                        toast.info("项目组信息获取成功，准备修改");
                        var team = data.returnData.team;
                        editTeam = team;
                        $("#oldTeamName").text(team.name);
                        newData.name = $("#title").val(team.name);
                        newData.des = newDes.setData(team.des);
                        newData.teamTypeId.teamTypeId = $("#teamType").find(team.teamTypeId.name).attr("selected", "selected");
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
                        contentType: 'application/json',
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
            newData.image = handleMutliFileUpload($(".completeFiles"), "imageinfo");
            console.log(newData);
            $.ajax({
                url: basePath + 'team.hopedo',
                type: 'PUT',
                contentType: 'application/json',
                data: JSON.stringify(newData),
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
        },
        initMultiUpload: function () {
            $('#fileupload').fileupload({
                url: 'baseAjax/multiUpload.hopedo',
                done: function (e, data) {
                    var result = data.result;
                    var uploadFile = result.returnData;
                    var img = new Image();
                    img.src = uploadFile.path;
                    var imageInfo = {
                        originName: uploadFile.originName,
                        size: uploadFile.size,
                        path: uploadFile.path
                    }
                    var tableItem =
                        '<tr class="template-upload fade in" data-imageinfo =\' ' + JSON.stringify(imageInfo) + ' \'> ' +
                        '<td> <span class="preview"><img src="' + uploadFile.path + '"  width="80px;" height="60px;"/></span> </td> ' +
                        '<td> <p class="name">' + uploadFile.originName + '</p> </td> ' +
                        '<td> <p class="size">' + uploadFile.size + '</p> ' +
                        '<button class="btn green" disabled=""> <i class="icon-ok"></i><span>上传成功</span> </button></td> ' +
                        '<td> <button class="btn red" disabled=""> <i class="icon-trash"></i><span>删除</span> </button> </td>' +
                        '</tr>';
                    if (globalFunction.returnResult(result, "", false)) {
                        $(".files").empty();
                        $(".completeFiles").append(tableItem);
                    }
                }
            });
            App.initUniform('.fileupload-toggle-checkbox');
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
        $("#deleteTeam").live("click", function () {
            TeamService.deleteTeam();
        })
        $("#refreshTeam").on("click", function () {
            TeamService.refreshTeam();
        });
        $("ul li .insertImage").live("click", function () {
            var path = $(this).parent().first().children(".imagePath").text();
            TeamService.image2Text(path, newDes);
        });
    }

    return {
        init: function () {
            $("#teamLi").attr("class", "active");
            var isEdit = $("#isEdit").text();
            $(".page-title").text("");
            if (isEdit == "1") {
                //编辑模式
                $(".page-title").append("编辑现有项目组 <small>Edit Exist Team</small>");
                $("#typeTitle").append("Edit Exist Team");
                $("#boxColor").attr("class", "portlet box red")
                $("#addTeamButton").hide();
                Team.refresh();
            } else {
                //添加模式
                $("#deleteTeamLi").hide();
                $(".page-title").append("创建新项目组 <small>Create New Team</small>");
                $("#typeTitle").append("Create New Team");
                $("#updateTeamButton").hide();
                Team.refreshTeamTypeForAdd();
            }
            TeamService.initMultiUpload();
            handleEvent();
        },
        refresh: function () {
            TeamService.refreshTeamType($("#teamType"));
            TeamService.refreshTeam();
        },
        refreshTeamTypeForAdd: function () {
            TeamService.refreshTeamType($("#teamType"));
        }
    };

}();