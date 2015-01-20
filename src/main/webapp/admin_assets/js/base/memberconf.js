var MemberTable = function () {

    var basePath = function () {
        var url = window.location + "";
        var h = url.split("//");
        var x = h[1].split("/");
        return h[0] + "//" + window.location.host + "/" + x[1] + "/";
    }();


    var MemberService = {

        postDesList: "",
        allPostList: null,
        memberPostList: null,

        init: function () {
            MemberService.initTable();
            MemberService.refresh();
            MemberService.refreshPost();
        },
        initTable: function () {
            function fnFormatDetails(oTable, nTr) {
                var aData = oTable.fnGetData(nTr);
                var sOut = '<table>';
                sOut += '<tr><td>其他信息</td><td> </td></tr>';
                sOut += '<tr><td>用户创建日期:</td><td>' + aData[3] + '</td></tr>';
                sOut += '<tr><td>用户状态:</td><td>' + aData[4] + '</td></tr>';
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
            var oTable = $('#datatable').dataTable({
                "aoColumnDefs": [
                    {
                        "bSortable": false,
                        "aTargets": [0]
                    }
                ],
                "aaSorting": [
                    [1, 'asc']
                ],
                "aLengthMenu": [
                    [5, 15, 20, -1],
                    [5, 15, 20, "All"]
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
        showMember: function (e) {
            var id = (e[0].id).split("show")[1];
            window.location.href = basePath + "member/" + id + "/toShow.hopedo"
        },
        showUpdate: function (e) {
            MemberService.clearDialog();
            var id = (e[0].id).split("edit")[1];
            $("#postField").show();
            $("#updateMemberId").text(id);
            $("#updateMemberStatus").show();
            $("#updateMemberButton").show();
            $("#addMemberButton").hide();
            $.ajax({
                url: "base/" + id + "/member.hopedo",
                contentType: 'application/json',
                type: "GET",
                success: function (data) {
                    var status = data.returnState;
                    if (status == "OK") {
                        toast.success(data.returnMsg);
                        var member = (data.returnData.member);
                        var postList = data.returnData.postList;
                        MemberService.memberPostList = "";
                        for (var i = 0; i < postList.length; i++) {
                            MemberService.memberPostList += (postList[i][1] + ",");
                        }
                        $("#memberName").val(member.name);
                        $("#memberUsername").val(member.username);
                        $("#memberPassword").attr("placeholder", "不修改则留空");
                        $("#confirmPassword").attr("placeholder", "不修改则留空");
                        $("#updateMemberStatus").val(member.status);
                        MemberService.initSelect2();
                        $("#addMemberModal").modal();
                    } else {
                        toast.error(data.returnMsg);
                    }
                }
            })
        },
        showAdd: function () {
            MemberService.clearDialog();
            $("#postField").hide();
            $("#addMemberButton").show();
            $("#updateMemberStatus").hide();
            $("#updateMemberButton").hide();
            $("#addMemberModal").modal();
        },
        clearDialog: function () {
            $("#memberName").val(undefined);
            $("#memberUsername").val(undefined);
            $("#memberPassword").val(undefined);
            $("#confirmPassword").val(undefined);
            $("#memberPosts").children().remove("option");
            $("#memberPosts").multiSelect("deselect_all");
        },
        refresh: function () {
            var table = $("#datatable").dataTable();
            //clear form
            MemberService.clearDialog();
            $.ajax({
                url: "base/member.hopedo",
                contentType: 'application/json',
                type: "GET",
                async: false,
                success: function (data) {
                    var status = data.returnState;
                    if (status == "OK") {
                        toast.success(data.returnMsg);
                        table.fnClearTable();
                        var list = eval(data.returnData.memberList);
                        for (var i = 0; i < list.length; i++) {
                            var line1 = '<span class="row-details row-details-close"></span><span hidden = "hidden">'
                                + list[i].info
                                + '</span>';
                            var line2 = list[i].name;
                            var line3 = list[i].username;
                            var line4 = list[i].date;
                            var line5 = list[i].status;
                            var line6 = '<a class="show" id ="show'
                                + list[i].memberId
                                + '"><button class="btn btn-xs blue" id="toMember"> <i class="icon-search">' +
                                ' <span style="font-family: Microsoft Yahei;">查看详细信息</span></i> </button></a>';
                            var line7 = '<a class="edit" id="edit'
                                + list[i].memberId
                                + '"><button class="btn btn-xs green"> <i class="icon-edit"> ' +
                                '<span style="font-family: Microsoft Yahei;">编辑基本信息</span></i> </button></a>';
                            table.fnAddData([line1,
                                line2, line3,
                                line4, line5,
                                line6, line7]);
                        }
                    } else {
                        toast.error(data.returnMsg);
                    }
                }
            })
        },
        showDelete: function () {
        },
        updateMember: function () {
            var confirm_password = $("#confirmPassword").val();
            var data = {
                name: $("#memberName").val(),
                username: $("#memberUsername").val(),
                password: $("#memberPassword").val(),
                status: $("#updateMemberStatus").val(),
                postId: JSON.stringify($("#memberPosts").val())
            }
            var validateError =
                data.name == undefined ||
                data.username == undefined ||
                (data.password != null && data.password != confirm_password);
            if (validateError) {
                toast.error("请输入合法数据");
                return;
            }
            console.log(data)
            $.ajax({
                url: "base/" + $("#updateMemberId").text() + "/member.hopedo",
                contentType: 'application/json',
                data: JSON.stringify(data),
                type: "PUT",
                success: function (data) {
                    var status = data.returnState;
                    if (status == "OK") {
                        toast.success(data.returnMsg);
                        $("#addMemberModal").modal("hide");
                        MemberService.refresh();
                    } else {
                        toast.error(data.returnMsg);
                    }
                }
            });
        },
        deleteMember: function () {
        },
        initSelect2: function () {
            /**
             * 在list产生之后再执行
             */
            $("#memberPosts").children().remove("option");

            if (MemberService.allPostList == undefined) {
                console.log("no post");
            } else {
                if (MemberService.memberPostList == undefined) {
                    //说明添加
                    for (var i = 0; i < MemberService.allPostList.length; i++) {
                        $('#memberPosts').append(
                            "<option value='" + MemberService.allPostList[i].postId + "'>"
                            + MemberService.allPostList[i].des + "</option>"
                        );
                        MemberService.postDesList += MemberService.allPostList[i].des + ",";
                    }
                } else {
                    //说明更新
                    var memberPost = MemberService.memberPostList;

                    for (var i = 0; i < MemberService.allPostList.length; i++) {
                        var allPost = MemberService.allPostList[i];
                        var selected = "";
                        //长串使用indexOf来校验短串
                        if (memberPost.indexOf(allPost.des) != -1) {
                            selected = "selected = 'selected'";
                        }
                        $("#memberPosts").append(
                            "<option value='" + allPost.postId + "' " + selected + ">" + allPost.des + "</option>"
                        )
                    }


                }
            }
            $('#memberPosts').multiSelect({
                placeholder: "请选择该用户所具有的权限",
                allowClear: true,
                selectableHeader: "<input type='text' class='form-control search-input' autocomplete='off' placeholder='搜索职位...'>",
                selectionHeader: "<input type='text' class='form-control search-input' autocomplete='off' placeholder='搜索职位...'>",
                afterInit: function (ms) {
                    var that = this,
                        $selectableSearch = that.$selectableUl.prev(),
                        $selectionSearch = that.$selectionUl.prev(),
                        selectableSearchString = '#' + that.$container.attr('id') + ' .ms-elem-selectable:not(.ms-selected)',
                        selectionSearchString = '#' + that.$container.attr('id') + ' .ms-elem-selection.ms-selected';

                    that.qs1 = $selectableSearch.quicksearch(selectableSearchString)
                        .on('keydown', function (e) {
                            if (e.which === 40) {
                                that.$selectableUl.focus();
                                return false;
                            }
                        });

                    that.qs2 = $selectionSearch.quicksearch(selectionSearchString)
                        .on('keydown', function (e) {
                            if (e.which == 40) {
                                that.$selectionUl.focus();
                                return false;
                            }
                        });
                },
                afterSelect: function () {
                    this.qs1.cache();
                    this.qs2.cache();
                },
                afterDeselect: function () {
                    this.qs1.cache();
                    this.qs2.cache();
                }
            });
        },
        refreshPost: function () {
            /**
             * 产生List
             */
            MemberService.clearDialog();
            MemberService.postDesList = "";
            $.ajax({
                url: "base/post.hopedo",
                contentType: 'application/json',
                type: "GET",
                success: function (data) {
                    var status = data.returnState;
                    if (status == "OK") {
                        toast.success("职位刷新成功");
                        var postList = (data.returnData.postList);
                        MemberService.allPostList = postList;
                        /**/
                        MemberService.initSelect2();
                    } else {
                        toast.error(data.returnMsg);
                    }
                }
            })
        },
        addMember: function () {
            var confirm_password = $("#confirmPassword").val();
            var data = {
                name: $("#memberName").val(),
                username: $("#memberUsername").val(),
                password: $("#memberPassword").val(),
                postId: JSON.stringify($("#memberPosts").val())
            }
            console.log(data);
            var validateError =
                data.name == undefined ||
                data.username == undefined ||
                data.password == undefined ||
                data.password != confirm_password;
            if (validateError) {
                toast.error("请输入合法数据");
                return;
            }
            $.ajax({
                url: "base/member.hopedo",
                contentType: 'application/json',
                data: JSON.stringify(data),
                type: "POST",
                success: function (data) {
                    var status = data.returnState;
                    if (status == "OK") {
                        toast.success(data.returnMsg);
                        $("#addMemberModal").modal("hide");
                        MemberService.refresh();
                        MemberService.clearDialog();
                    } else {
                        toast.error(data.returnMsg);
                    }
                }
            });
        }
    }
    var handleEvent = function () {
        $("#refreshTableButton").on("click", function () {
            MemberService.refresh();
        });

        $("#datatable").on("click", "a.edit", function () {
            MemberService.showUpdate($(this));
        });

        $("#datatable").on("click", "a.show", function () {
            MemberService.showMember($(this));
        });

        $("#showAddMemberButton").on("click", function () {
            MemberService.showAdd();
        });

        $("#addMemberButton").on("click", function () {
            MemberService.addMember();
        });
        $("#updateMemberButton").on("click", function () {
            MemberService.updateMember();
        })
    }


    return {
        // main function to initiate the module
        init: function () {
            if (!jQuery().dataTable) {
                return;
            }
            MemberService.init();
            handleEvent();
        }

    };
}();