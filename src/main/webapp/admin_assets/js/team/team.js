var Team = function () {

    var basePath = function () {
        var url = window.location + "";
        var h = url.split("//");
        var x = h[1].split("/");
        return h[0] + "//" + window.location.host + "/" + x[1] + "/";
    }();
    var newDes = CKEDITOR.replace('newDes')
    var image = $("#image").val();
    var member_teamList = "";
    var objId = {
        id: "",
        type: 0
    };
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

    function handleMultiFileUpload(oldTbody, newTbody, dataName) {
        var oldImages = oldTbody.children();
        var newImages = newTbody.children();
        var returnJSON = "[";
        for (var i = 0; i < oldImages.length; i++) {
            var imageInfo = ($(oldImages[i]).data(dataName));
            returnJSON += imageInfo;
            if (i < oldImages.length - 1) {
                returnJSON += ",";
            }
        }
        if (oldImages.length > 0 && newImages.length > 0) {
            returnJSON += ",";
        }
        for (var i = 0; i < newImages.length; i++) {
            var imageInfo = ($(newImages[i]).data(dataName));
            returnJSON += imageInfo;
            if (i < newImages.length - 1) {
                returnJSON += ",";
            }
        }
        returnJSON += "]";
        return returnJSON;
    }

    function initEditImage(targetTable, imageStr) {
        targetTable.empty();
        var tableItem = "";
        var imageList = JSON.parse(imageStr);
        for (var i = 0; i < imageList.length; i++) {
            var imageInfo = {
                originName: imageList[i].originName,
                size: imageList[i].size,
                path: imageList[i].path
            }
            tableItem +=
                '<tr class="template-upload fade in" data-imageinfo =\' ' + JSON.stringify(imageInfo) + ' \'> ' +
                '<td> <span class="preview"><img src="' + imageInfo.path + '"  width="80px;" height="60px;"/></span> </td> ' +
                '<td> <p class="name">' + imageInfo.originName + '</p> </td> ' +
                '<td> <p class="size">' + imageInfo.size + '</p> ' +
                '<button class="btn green" disabled=""> <i class="icon-ok"></i><span>上传成功</span> </button></td> ' +
                '<td><span class="btn red deleteImage"><i class="icon-trash"></i>删除</span></td>' +
                '</tr>';
        }
        targetTable.append(tableItem);
    }

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
                error: function (data) {
                    toast.error(data);
                }

            })
        },
        deleteImage: function (table) {
            table.parent().parent().remove();
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
            newData.image = handleMultiFileUpload($(".oldFiles"), $(".completeFiles"), "imageinfo");
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
        memberNameQuery: function () {
            var memberName = {key: $("#memberNameQuery").val()};
            if (memberName == undefined || memberName == "") {
                return;
            }
            $.ajax({
                url: basePath + 'member/memberNameQuery.hopedo',
                type: 'POST',
                contentType: 'application/json',
                data: JSON.stringify(memberName),
                success: function (data) {
                    if (globalFunction.returnResult(data, undefined, false)) {
                        var list = data.returnData.memberList;
                        var memberNameList = new Array(list.length);
                        for (var i = 0; i < list.length; i++) {
                            var item = {
                                value: list[i].name + '-' + list[i].username,
                                data: list[i]
                            }
                            memberNameList[i] = item;
                        }
                        $('#memberNameQuery').autocomplete({
                            lookup: memberNameList,
                            onSelect: function (suggestion) {
                                $("#memberNameQuery").val("");
                                $("#memberModal").modal();
                                $("#founder").hide();
                                $("#memberName").text(suggestion.data.name);
                                $("#memberUsername").text(suggestion.data.username);
                                $("#memberStatus").text(suggestion.data.status);
                                $("#memberDate").text(suggestion.data.date);
                                $("#memberId").text(suggestion.data.memberId);
                                $("#updateMemberButton").hide();
                                $("#deleteMemberButton").hide();
                            }
                        });

                    }
                }
            });


        },
        refreshMemberOfTeam: function () {
            $("#memberTable").empty();
            $("#founder").hide();
            var teamId = $("#teamId").text();
            $.ajax({
                url: basePath + 'team/' + teamId + '/queryMember.hopedo',
                type: 'GET',
                contentType: 'application/json',
                success: function (data) {
                    if (globalFunction.returnResult(data)) {
                        var list = data.returnData.list;
                        member_teamList = list;
                        var str = "";
                        for (var i = 0; i < list.length; i++) {
                            var id = list[i].id;
                            var memberName = list[i].memberId.name;
                            var memberAccount = list[i].memberId.username;
                            var status = list[i].status;
                            str += '<tr>' +
                            ' <td class="highlight"> <div class="success"></div> <a href="#">' + memberName + '</a> </td> ' +
                            '<td class="hidden-xs">' + memberAccount + '</td> ' +
                            '<td>' + status + '</td> ' +
                            '<td><a href="javascript:;" class="btn teamMemberEdit default btn-xs purple" data-objectid = "' + id +
                            '"><i class="icon-edit"></i>编辑</a></td> </tr>';
                        }
                        $("#memberTable").append(str);
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
                        $("#oldTeamName").text(team.name);
                        newData.name = $("#title").val(team.name);
                        newData.des = newDes.setData(team.des);
                        newData.teamTypeId.teamTypeId = $("#teamType").find(team.teamTypeId.name).attr("selected", "selected");
                        $("#teamName").text(team.name);
                        $("#_teamType").text(team.teamTypeId.name);
                        initEditImage($(".oldFiles"), team.image);
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
            newData.image = handleMultiFileUpload($(".oldFiles"), $(".completeFiles"), "imageinfo");
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
                        '<td><span class="btn red deleteImage"><i class="icon-trash"></i>删除</span></td>' +
                        '</tr>';
                    if (globalFunction.returnResult(result, "", false)) {
                        $(".files").empty();
                        $(".completeFiles").append(tableItem);
                    }
                }
            });
            App.initUniform('.fileupload-toggle-checkbox');
        },
        inviteMember: function () {
            var data = {
                teamId: $("#teamId").text(),
                memberId: $("#memberId").text(),
                status: $("#memberRole").val()
            }
            $.ajax({
                url: basePath + "/team/invite.hopedo",
                type: "POST",
                dataType: "json",
                data: (data),
                success: function (data) {
                    if (globalFunction.returnResult(data)) {
                        $("#memberModal").modal('hide');
                        TeamService.refreshMemberOfTeam();
                    }
                }
            });
        },
        showInviteUpdate: function (button) {
            $("#memberModal").modal();
            $("#addMemberButton").hide();
            var id = button.data("objectid");
            objId.id = id;
            for (var i = 0; i < member_teamList.length; i++) {
                if (id == member_teamList[i].id) {
                    var memberId = member_teamList[i].memberId;
                    $("#memberName").text(memberId.name);
                    $("#memberUsername").text(memberId.username);
                    $("#memberStatus").text(memberId.status);
                    $("#memberDate").text(memberId.date);
                    $("#memberId").text(memberId.memberId);
                    if (member_teamList[i].status == globalConstant.FOUNDER) {
                        $("#founder").show();
                        $("#memberRole").hide();
                        $("#addMemberButton").hide();
                        $("#updateMemberButton").hide();
                        $("#deleteMemberButton").hide();
                        objId.type = 1;
                    }
                    else {
                        objId.type = 0;
                        $("#founder").hide();
                        $("#memberRole").show();
                        $("#updateMemberButton").show();
                        $("#deleteMemberButton").show();
                        $("#memberRole").val(member_teamList[i].status);
                    }
                    break;
                }
            }
        },
        updateInviteMember: function () {
            if (objId.type == 1) {
                toast.error("创建者权限禁止修改");
                return;
            }
            var data = {
                id: objId.id,
                teamId: $("#teamId").text(),
                memberId: $("#memberId").text(),
                status: $("#memberRole").val()
            }
            $.ajax({
                url: basePath + "/team/invite.hopedo",
                type: "PUT",
                dataType: "json",
                data: (data),
                success: function (data) {
                    if (globalFunction.returnResult(data)) {
                        $("#memberModal").modal('hide');
                        TeamService.refreshMemberOfTeam();
                    }
                }
            });
        },
        deleteInviteMember: function () {
            if (objId.type == 1) {
                toast.error("创建者权限禁止修改");
                return;
            }
            var data = {
                id: objId.id,
                status: $("#memberRole").val()
            }
            $.ajax({
                url: basePath + "/team/invite.hopedo",
                type: "DELETE",
                dataType: "json",
                data: (data),
                success: function (data) {
                    if (globalFunction.returnResult(data)) {
                        $("#memberModal").modal('hide');
                        TeamService.refreshMemberOfTeam();
                    }
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
        $("#deleteTeam").live("click", function () {
            TeamService.deleteTeam();
        })
        $("#refreshTeam").on("click", function () {
            TeamService.refreshTeam();
        });
        $("#imageTable .deleteImage").live("click", function () {
            TeamService.deleteImage($(this));
        })
        $("ul li .insertImage").live("click", function () {
            var path = $(this).parent().first().children(".imagePath").text();
            TeamService.image2Text(path, newDes);
        });
        $("#memberNameQuery").on("focus", function () {
            TeamService.memberNameQuery();
        })
        $("#addMemberButton").on("click", function () {
            TeamService.inviteMember();
        })
        $("#updateMemberButton").on("click", function () {
            TeamService.updateInviteMember();
        })
        $("#deleteMemberButton").on("click", function () {
            TeamService.deleteInviteMember();
        })
        $("#memberTable").on("click", "a.teamMemberEdit", function () {
            TeamService.showInviteUpdate($(this));
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
            TeamService.refreshMemberOfTeam();
        },
        refreshTeamTypeForAdd: function () {
            TeamService.refreshTeamType($("#teamType"));
        }
    };

}
();