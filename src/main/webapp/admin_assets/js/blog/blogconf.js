var BlogTable = function () {

    var basePath = function () {
        var url = window.location + "";
        var h = url.split("//");
        var x = h[1].split("/");
        return h[0] + "//" + window.location.host + "/" + x[1] + "/";
    }();


    var BlogService = {
        initTable: function () {
            function fnFormatDetails(oTable, nTr) {
                var aData = oTable.fnGetData(nTr);
                var sOut = '<table>';
                sOut += '<tr><td>其他信息</td><td> </td></tr>';
                sOut += '<tr><td>博客创建日期:</td><td>' + aData[3] + '</td></tr>';
                sOut += '<tr><td>博客状态:</td><td>' + aData[4] + '</td></tr>';
                var info = aData[0].split("{")[1].split("}")[0];
                var infos = info.split(",");
                for (var i = 0; i < infos.length; i++) {
                    var keys = infos[i].split("=");
                    sOut += '<tr><td>' + keys[0] + ':</td><td>' + keys[1]
                    + '</td></tr>';
                }
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
                    [5, 15, 20, "All"] // change
                    // per
                    // page
                    // values
                    // here
                ],
                // set the initial value
                "iDisplayLength": 10
            });
            jQuery('#datatable_wrapper .dataTables_filter input').addClass(
                "form-control input-small"); // modify table search input
            jQuery('#datatable_wrapper .dataTables_length select').addClass(
                "form-control input-small"); // modify table per page
            jQuery('#datatable_wrapper .dataTables_length select').select2(); // initialize
            $('#datatable').on(
                'click',
                ' tbody td .row-details',
                function () {
                    var nTr = $(this).parents('tr')[0];
                    if (oTable.fnIsOpen(nTr)) {
                        /* This row is already open - close it */
                        $(this).addClass("row-details-close").removeClass(
                            "row-details-open");
                        oTable.fnClose(nTr);
                    } else {
                        /* Open this row */
                        $(this).addClass("row-details-open").removeClass(
                            "row-details-close");
                        oTable.fnOpen(nTr, fnFormatDetails(oTable, nTr),
                            'details');
                    }
                });
        },
        deleteBlog: function (e) {

            var $this = e;
            var id = ($this[0].id).split("delete")[1];

            $.ajax({
                url: basePath + "blog/" + id + ".hopedo",
                contentType: 'application/json',
                type: "DELETE",
                async: false,
                success: function (data) {
                    var status = data.returnState;
                    if (status == "OK") {
                        toast.success(data.returnMsg);
                        $("#reload").trigger("click");
                    } else {
                        toast.error(data.returnMsg);
                    }

                }
            })
        },
        deployBlog: function (e) {
            var $this = e;
            var id = ($this[0].id).split("deploy")[1];
            $.ajax({
                url: basePath + "blog/" + id + "/deployBlog.hopedo",
                contentType: 'application/json',
                type: "PUT",
                async: false,
                success: function (data) {
                    var status = data.returnState;
                    if (status == "OK") {
                        toast.success(data.returnMsg);
                        $("#reload").trigger("click");
                    } else {
                        toast.error(data.returnMsg);
                    }

                }
            })
        },
        reloadTable: function () {
            var table = $("#datatable").dataTable();
            $.ajax({
                url: basePath + "blog.hopedo",
                contentType: 'application/json',
                type: "GET",
                async: false,
                success: function (data) {
                    var status = data.returnState;
                    if (status == "OK") {
                        toast.success(data.returnMsg);
                        table.fnClearTable();
                        var list = eval(data.returnData.blogList);
                        for (var i = 0; i < list.length; i++) {
                            var line1 = '<span class="row-details row-details-close"></span><span hidden = "hidden">'
                                + list[i].info
                                + '</span>';
                            var line2 = list[i].title;
                            var line3 = '<a href="/'
                                + list[i].blogId
                                + '/content.hopedo">点击进入博客</a>'
                            var line4 = list[i].date;
                            var line5 = list[i].status;
                            var line6 = '<a class="edit" href="blog/'
                                + list[i].blogId
                                + '/toUpdateBlog.hopedo"><button class="btn btn-xs blue" id="editBlog"> <i class="icon-edit"> <span style="font-family: Microsoft Yahei;"> 编辑博客 </span></i> </button></a>'
                            var line6_1 = '<a class="deploy" id="deploy'
                                + list[i].blogId
                                + '"><button class="btn btn-xs green" id="changeBlog"> <i class="icon-ok"> <span style="font-family: Microsoft Yahei;"> 发布博客 </span></i> </button></a>'
                            var line7 = '<a class="delete" id="delete'
                                + list[i].blogId
                                + '"><button class="btn btn-xs red" id="deleteBlog"> <i class="icon-trash"> <span style="font-family: Microsoft Yahei;">删除博客</span></i> </button></a>';
                            table.fnAddData([line1,
                                line2, line3,
                                line4, line5,
                                line6 + line6_1, line7]);
                        }
                    } else {
                        toast.error(data.returnMsg);
                    }
                }
            })
        }
    }


    var handleEvent = function () {
        $("#datatable").on("click", "a.delete", function () {
            BlogService.deleteBlog($(this));
        });
        $("#datatable").on("click", "a.deploy", function () {
            BlogService.deployBlog($(this));
        });

        $("#reload").on("click", function () {
            BlogService.reloadTable();
        });

    }

    return {
        // main function to initiate the module
        init: function () {
            if (!jQuery().dataTable) {
                return;
            } else {
                BlogService.initTable();
                BlogService.reloadTable();
                handleEvent();
            }
        }
    };
}();