var PostTable = function () {


    var roleList = null;
    var postRoleIds = null;

    var postService = {
        init: function () {
            postService.initTable();
            postService.reloadTable();
            postService.initSelect2();
            postService.refreshRole();
        },
        initTable: function () {
            /* 格式化下拉栏菜单 */
            function fnFormatDetails(oTable, nTr) {
                var aData = oTable.fnGetData(nTr);
                var sOut = '<table>';
                sOut += '<tr><td>其他信息</td><td> </td></tr>';
                sOut += '<tr><td>职位名称:</td><td>' + aData[1] + '</td></tr>';
                sOut += '<tr><td>职位状态:</td><td>' + aData[2] + '</td></tr>';
                sOut += '</table>';
                return sOut;
            }

            var nCloneTh = document.createElement('th');
            var nCloneTd = document.createElement('td');
            nCloneTd.innerHTML = '<span class="row-details row-details-close"></span>';
            $('#datatable thead tr').each(function () {
                this.insertBefore(nCloneTh, this.childNodes[0]);
            });
            $('#datatable tbody tr').each(function () {
                this.insertBefore(nCloneTd.cloneNode(true), this.childNodes[0]);
            });
            /*
             * 列排序
             */
            var oTable = $('#datatable').dataTable({
                "aoColumnDefs": [
                    {
                        "bSortable": false,
                        "aTargets": [ 0 ]
                    }
                ],
                "aaSorting": [
                    [ 1, 'asc' ]
                ],
                "aLengthMenu": [
                    [ 5, 15, 20, -1 ],
                    [ 5, 15, 20, "All" ]
                ],
                "iDisplayLength": 10
            });
            jQuery('#datatable_wrapper .dataTables_filter input').addClass(
                "form-control input-small");
            jQuery('#datatable_wrapper .dataTables_length select').addClass(
                "form-control input-small");
            jQuery('#datatable_wrapper .dataTables_length select').select2();
            $('#datatable').on('click', ' tbody td .row-details',
                function () {
                    var nTr = $(this).parents('tr')[0];
                    if (oTable.fnIsOpen(nTr)) {
                        $(this).addClass("row-details-close").removeClass(
                            "row-details-open");
                        oTable.fnClose(nTr);
                    } else {
                        $(this).addClass("row-details-open").removeClass(
                            "row-details-close");
                        oTable.fnOpen(nTr, fnFormatDetails(oTable, nTr),
                            'details');
                    }
                });
        },
        reloadTable: function () {
            var table = $("#datatable").dataTable();
            $.ajax({
                url: "base/post.hopedo",
                dataType: "json",
                type: "GET",
                async: false,
                success: function (data) {
                    var status = data.returnState;
                    if (status == "OK") {
                        toast.info(data.returnMsg);
                        table.fnClearTable();
                        var list = eval(data.returnData.postList);
                        for (var i = 0; i < list.length; i++) {
                            var line1 = '<span class="row-details row-details-close"></span><span hidden = "hidden">'
                                + list[i].info
                                + '</span>';
                            var line2 = list[i].postId;
                            var line4 = list[i].des;
                            var line5 = list[i].status;
                            var line7 = '<a class="edit" id="edit'
                                + list[i].postId
                                + '"><button class="btn btn-xs blue" id="editTeam"> <i class="icon-edit">' +
                                ' <span style="font-family: Microsoft Yahei;">编辑职位信息</span></i> </button></a>';
                            table.fnAddData([ line1, line2, line4, line5, line7 ]);
                        }
                    } else {
                        toast.error(data.returnMsg);
                    }
                }
            })
        },
        updatePost: function () {
            var id = $("#editPostId").text();
            var data = {
                des: $("#updatePostDes").val(),
                status: $("#updatePostStatus").val(),
                //这个是新权限 new
                roleList: $("#updateRolePost").val(),
                //这个是这个用户原有的权限 old
                postRoleIds: postRoleIds
            }
            if (data.roleList == null || data.roleList == "") {
                toast.error("至少要有一个权限")
            } else {
                data.roleList = data.roleList.toString();
                $.ajax({
                    url: "base/" + id + "/post.hopedo",
                    dataType: "json",
                    type: "PUT",
                    data: (data),
                    async: false,
                    success: function (data) {
                        var status = data.returnState;
                        if (status == "OK") {
                            toast.info("职位修改成功");
                            postService.reloadTable();
                            $('#updatePostModal').modal('hide')
                            postRoleIds = null;
                        } else {
                            toast.error(data.returnMsg);
                        }
                    }
                })
            }
        },
        showAddNewPostModal: function () {
            var $modal = $('#addNewPostModal');
            $modal.modal();
        },
        addPost: function () {
            var data = {
                addNewPostDes: $("#addNewPostDes").val(),
                addNewPostRoles: $("#addNewPostRoles").val().toString()
            }
            $.ajax({
                url: basePath + 'base/post.hopedo',
                type: 'POST',
                data: (data),
                dataType: 'json',
                success: function (data) {
                    var status = data.returnState;
                    if (status == "OK") {
                        toast.success("职位添加成功");
                        $("#addNewPostModal").modal('hide');
                        postService.reloadTable();
                    } else {
                        toast.error(data.returnMsg);
                    }
                }
            });
        },
        initSelect2: function () {

            $('#addNewPostRoles').select2({
                placeholder: "请选择该职位拥有的权限",
                allowClear: true
            });

            function movieFormatResult(movie) {
                var markup = "<table class='movie-result'><tr>";
                if (movie.posters !== undefined && movie.posters.thumbnail !== undefined) {
                    markup += "<td valign='top'><img src='" + movie.posters.thumbnail + "'/></td>";
                }
                markup += "<td valign='top'><h5>" + movie.title + "</h5>";
                if (movie.critics_consensus !== undefined) {
                    markup += "<div class='movie-synopsis'>" + movie.critics_consensus + "</div>";
                } else if (movie.synopsis !== undefined) {
                    markup += "<div class='movie-synopsis'>" + movie.synopsis + "</div>";
                }
                markup += "</td></tr></table>"
                return markup;
            }

            function movieFormatSelection(movie) {
                return movie.title;
            }
        },
        refreshRole: function () {
            var data = {
                status: "normal"
            };
            var adminRoles = $("#adminRoles");
            var writeRoles = $("#writeRoles");
            var readRoles = $("#readRoles");
            $.ajax({
                url: "base/role.hopedo",
                dataType: "json",
                data: (data),
                type: "GET",
                async: false,
                success: function (data) {
                    var status = data.returnState;
                    if (status == "OK") {
                        //toast.success("权限刷新成功");
                        var list = eval(data.returnData.roleList);
                        roleList = list;
                        for (var i = 0; i < list.length; i++) {
                            var roleType = list[i].type;
                            var roleId = list[i].roleId;
                            var des = list[i].des;
                            if (roleType == "管理员权限") {
                                adminRoles.append("<option value = " + roleId + ">" + des + "</option>");
                            }
                            if (roleType == "读写权限") {
                                writeRoles.append("<option value = " + roleId + ">" + des + "</option>");
                            }
                            if (roleType == "只读权限") {
                                readRoles.append("<option value = " + roleId + ">" + des + "</option>");
                            }
                        }

                    } else {
                        toast.error(data.returnMsg);
                    }
                }
            })
        },
        showEditModal: function (e) {
            var id = (e[0].id).split("edit")[1];
            var $modal = $('#updatePostModal');
            $modal.modal();
            $.ajax({
                url: "base/" + id + "/post.hopedo",
                dataType: "json",
                type: "GET",
                async: false,
                success: function (data) {
                    var status = data.returnState;
                    if (status == "OK") {
                        //toast.success("查询成功");
                        var post = data.returnData.post;
                        var postRoleList = data.returnData.roleList;
                        $("#editPostId").text(post.postId);
                        $("#updatePostDes").val(post.des);
                        var roleIds = "";
                        for (var i = 0; i < postRoleList.length; i++) {
                            roleIds += postRoleList[i][0];
                            if (i < postRoleList.length - 1) {
                                roleIds += ",";
                            }
                        }
                        //这个是这个用户原有的权限
                        postRoleIds = roleIds;
                        if (roleList == null) {
                            postService.refreshRole();
                        }
                        $("#_adminRoles").remove("option");
                        $("#_writeRoles").remove("option");
                        $("#_readRoles").remove("option");
                        for (var i = 0; i < roleList.length; i++) {
                            var roleType = roleList[i].type;
                            var selected = "";
                            var roleId = roleList[i].roleId;
                            if (roleIds.indexOf(roleId) != -1) {
                                selected = "selected = 'selected'";
                            }
                            var des = roleList[i].des;
                            $("#_adminRoles").attr("label", "1、\u7BA1\u7406\u5458\u6743\u9650");
                            $("#_writeRoles").attr("label", "2、\u8BFB\u5199\u6743\u9650");
                            $("#_readRoles").attr("label", "3、\u53EA\u8BFB\u6743\u9650");
                            if (roleType == "管理员权限") {
                                $("#_adminRoles").append("<option value = " + roleId + " " + selected + " >" + des + "</option>");
                            }
                            if (roleType == "读写权限") {
                                $("#_writeRoles").append("<option value = " + roleId + " " + selected + ">" + des + "</option>");
                            }
                            if (roleType == "只读权限") {
                                $("#_readRoles").append("<option value = " + roleId + " " + selected + ">" + des + "</option>");
                            }
                        }
                        $('#updateRolePost').multiSelect({
                            selectableOptgroup: true
                        });
                        $("#updatePostStatus").val(post.status);
                    } else {
                        toast.error(data.returnMsg);
                    }
                }
            })
        },
        deleteConfirm: function () {
            $("#confrimModal").modal();
        },
        deletePost: function () {
            var id = $("#editPostId").text();
            $.ajax({
                url: "base/" + id + "/post.hopedo",
                dataType: "json",
                type: "DELETE",
                async: false,
                success: function (data) {
                    var status = data.returnState;
                    if (status == "OK") {
                        toast.success(data.returnMsg);
                        $('#confrimModal').modal('hide');
                        $('#updatePostModal').modal('hide');
                        postService.reloadTable();
                    } else {
                        toast.error(data.returnMsg);
                    }
                }
            })
        }

    }

    var handleEvents = function () {
        $("#addNewPost").on("click", function () {
            postService.showAddNewPostModal();
        });
        $("#addNewPostButton").on("click", function () {
            postService.addPost();
        });
        $("#reloadPostTable").on("click", function () {
            postService.reloadTable();
        });
        $("#datatable").on("click", "a.edit", function () {
            postService.showEditModal($(this));
        });
        $("#updatePostButton").on("click", function () {
            postService.updatePost();
        });
        $("#deletePostButton").on("click", function () {
            postService.deleteConfirm();
        });
        $("#confirm").on("click", function () {
            postService.deletePost();
        });
    }


    return {
        init: function () {
            if (!jQuery().dataTable) {
                return;
            }
            postService.init();
            handleEvents();
        }
    };
}();