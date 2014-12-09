var TeamTable = function () {

    var initTeamType = function () {

    }


    var initTable1 = function () {

        /* 格式化下拉栏菜单 */
        function fnFormatDetails(oTable, nTr) {
            var aData = oTable.fnGetData(nTr);
            var sOut = '<table>';
            sOut += '<tr><td>其他信息</td><td> </td></tr>';
            sOut += '<tr><td>项目组创建日期:</td><td>' + aData[3] + '</td></tr>';
            sOut += '<tr><td>项目组状态:</td><td>' + aData[4] + '</td></tr>';
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

    $("#reloadTeamTable").on("click", function () {
        handleReloadEvent();
    });

    var handleReloadEvent = function () {
        var table = $("#datatable").dataTable();
        $.ajax({
            url: "team.hopedo",
            dataType: "json",
            type: "GET",
            async: false,
            success: function (data) {
                var status = data.returnState;
                if (status == "OK") {
                    toast.success(data.returnMsg);
                    table.fnClearTable();
                    var list = eval(data.returnData.teamList);
                    for (var i = 0; i < list.length; i++) {
                        var line1 = '<span class="row-details row-details-close"></span><span hidden = "hidden">'
                            + list[i].info
                            + '</span>';
                        var line2 = list[i].name;
                        var line3 = '<a href="/'
                            + list[i].blogId
                            + '/content.hopedo">点击查看项目组详情</a>'
                        var line4 = list[i].date;
                        var line5 = list[i].status;
                        var line6 = list[i].teamTypeId.name;
                        var line7 = '<a class="delete" id="edit'
                            + list[i].teamId
                            + '"><button class="btn btn-xs red" id="deleteBlog"> <i class="icon-trash"> <span style="font-family: Microsoft Yahei;">编辑项目组信息</span></i> </button></a>';
                        table.fnAddData([ line1,
                            line2, line3,
                            line4, line5,
                            line6 , line7 ]);
                    }
                } else {
                    toast.error(data.returnMsg);
                }
            }
        })
    }

    var handle2EditTeam = function (e) {
        var id = (e[0].id).split("edit")[1];
        window.location.href = "../team/" + id + "/toUpdateTeam.hopedo";
    }


    var handleRefreshSingleBlogEvent = function () {
        var frontBlogItem = {
            title: $("#_title"),
            content: $("#content"),
            member: $("#member"),
            date: $("#date"),
            blogType: $("#blogType"),
            blogTags: $("#blogTags")
        }
        var
            blogId = $("#frontBlogItemId").text()

        $.ajax({
            url: "../blog/" + blogId + ".hopedo",
            data: (blogId),
            dataType: "json",
            type: "GET",
            success: function (data) {
                var status = data.returnState;
                if (status == "OK") {
                    toast.success(data.returnMsg);
                    var blogItem = data.returnData.blog;
                    var blogInfo = eval("(" + blogItem.info + ")");
                    console.log(blogInfo.blogTag);
                    frontBlogItem.title.text(blogItem.title);
                    frontBlogItem.member.text(blogItem.memberId.name);
                    frontBlogItem.date.text(blogItem.date);
                    frontBlogItem.blogType.text(blogInfo.blogType);
                    frontBlogItem.blogTags.text(blogInfo.blogTag);
                    frontBlogItem.content.text("").append(blogItem.content);
                } else {
                    toast.error(data.returnMsg);
                }
            }
        })
    }


    return {
        // main function to initiate the module
        init: function () {
            if (!jQuery().dataTable) {
                return;
            }
            initTable1();
            handleReloadEvent();

        },
        frontInit: function () {
            handleRefreshSingleBlogEvent();
        }

    };
}();