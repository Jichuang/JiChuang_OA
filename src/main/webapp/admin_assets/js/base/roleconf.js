var RoleTable = function () {

    var initTeamType = function () {

    }


    var initTable1 = function () {

        /* 格式化下拉栏菜单 */
        function fnFormatDetails(oTable, nTr) {
            var aData = oTable.fnGetData(nTr);
            var sOut = '<table>';
            sOut += '<tr><td>其他信息</td><td> </td></tr>';
            sOut += '<tr><td>权限描述:</td><td>' + aData[1] + '</td></tr>';
            sOut += '<tr><td>权限状态:</td><td>' + aData[2] + '</td></tr>';
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
    }


    var handleAddNewRoleEvent = function () {
        var data = {
            addNewRoleDes: $("#addNewRoleDes").val()
        }
        $.ajax({
            url: basePath + 'base/role.hopedo',
            type: 'POST',
            data: (data),
            dataType: 'json',
            success: function (data) {
                var status = data.returnState;
                if (status == "OK") {
                    toast.success("权限添加成功");
                    $("#addNewRoleModal").modal('hide');
                    handleReloadEvent();
                } else {
                    toast.error(data.returnMsg);
                }
            }
        });
    }

    var showAddNewRoleModalEvent = function () {
        var $modal = $('#addNewRoleModal');
        $modal.modal();
    }

    var showEditRoleModal = function (id) {
        var $modal = $('#updateRoleModal');
        $modal.modal();
        $.ajax({
            url: "base/" + id + "/role.hopedo",
            dataType: "json",
            type: "GET",
            async: false,
            success: function (data) {
                var status = data.returnState;
                if (status == "OK") {
                    toast.success("查询成功");
                    var role = data.returnData.role;
                    $("#editRoleId").text(role.roleId);
                    $("#updateRoleDes").val(role.des);
                    $("#updateRoleStatus").val(role.status);
                } else {
                    toast.error(data.returnMsg);
                }
            }
        })
    }

    var handleUpdateRoleEvent = function () {
        var id = $("#editRoleId").text();
        var data = {
            des: $("#updateRoleDes").val(),
            status: $("#updateRoleStatus").val()
        }
        $.ajax({
            url: "base/" + id + "/role.hopedo",
            dataType: "json",
            type: "PUT",
            data: (data),
            async: false,
            success: function (data) {
                var status = data.returnState;
                if (status == "OK") {
                    toast.info(data.returnMsg);
                    $('#updateRoleModal').modal('hide')
                    handleReloadEvent();
                } else {
                    toast.error(data.returnMsg);
                }
            }
        })
    }

    var showDeleteConfirmModalEvent = function () {
        $("#confrimModal").modal();
    }

    var handleDeleteRoleEvent = function () {
        var id = $("#editRoleId").text();
        $.ajax({
            url: "base/" + id + "/role.hopedo",
            dataType: "json",
            type: "DELETE",
            async: false,
            success: function (data) {
                var status = data.returnState;
                if (status == "OK") {
                    toast.success(data.returnMsg);
                    $('#confrimModal').modal('hide');
                    $('#updateRoleModal').modal('hide');
                    handleReloadEvent();
                } else {
                    toast.error(data.returnMsg);
                }
            }
        })
    }

    var handleReloadEvent = function () {
        var table = $("#datatable").dataTable();
        $.ajax({
            url: "base/role.hopedo",
            dataType: "json",
            type: "GET",
            async: false,
            success: function (data) {
                var status = data.returnState;
                if (status == "OK") {
                    toast.info(data.returnMsg);
                    table.fnClearTable();
                    var list = eval(data.returnData.roleList);
                    for (var i = 0; i < list.length; i++) {
                        var line1 = '<span class="row-details row-details-close"></span><span hidden = "hidden">'
                            + list[i].info
                            + '</span>';
                        var line2 = list[i].roleId;
                        var line4 = list[i].des;
                        var line5 = list[i].status;
                        var line7 = '<a class="edit" id="edit'
                            + list[i].roleId
                            + '"><button class="btn btn-xs blue" id="editRole"> <i class="icon-edit"> ' +
                            '<span style="font-family: Microsoft Yahei;">编辑权限信息</span></i> </button></a>';
                        table.fnAddData([ line1, line2, line4, line5, line7 ]);
                    }
                } else {
                    toast.error(data.returnMsg);
                }
            }
        })
    }

    var handle2EditRoleEvent = function (e) {
        var id = (e[0].id).split("edit")[1];
        showEditRoleModal(id);
    }

    $("#addNewRole").on("click", function () {
        showAddNewRoleModalEvent();
    });

    $("#addNewRoleButton").on("click", function () {
        handleAddNewRoleEvent();
    });


    $("#reloadRoleTable").on("click", function () {
        handleReloadEvent();
    });

    $("#datatable").on("click", "a.edit", function () {
        handle2EditRoleEvent($(this));
    });

    $("#updateRoleButton").on("click", function () {
        handleUpdateRoleEvent();
    });

    $("#deleteRoleButton").on("click", function () {
        showDeleteConfirmModalEvent();
    });

    $("#confirm").on("click", function () {
        handleDeleteRoleEvent();
    });

    return {
        // main function to initiate the module
        init: function () {
            if (!jQuery().dataTable) {
                return;
            }
            initTable1();
            handleReloadEvent();

        }

    };
}();