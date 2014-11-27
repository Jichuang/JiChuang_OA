var TableAdvanced = function() {

	var initTable1 = function() {

		/* 格式化下拉栏菜单 */
		function fnFormatDetails(oTable, nTr) {
			var aData = oTable.fnGetData(nTr);
			var sOut = '<table>';
			sOut += '<tr><td>其他信息</td><td> </td></tr>';
			sOut += '<tr><td>博客创建日期:</td><td>' + aData[3] + '</td></tr>';
			sOut += '<tr><td>博客状态:</td><td>' + aData[4] + '</td></tr>';
			var info = $("table tbody tr .infos").text();
			info = info.substring(1, info.length - 1).trim();
			var infos = info.split(",");
			for (var i = 0; i < infos.length; i++) {
				var keys = infos[i].split("=");
				sOut += '<tr><td>' + keys[0] + ':</td><td>' + keys[1]
						+ '</td></tr>';
			}
			sOut += '</table>';

			return sOut;
		}

		/*
		 * 添加一个“显示细节”的破鸡巴按钮
		 */
		var nCloneTh = document.createElement('th');
		var nCloneTd = document.createElement('td');
		nCloneTd.innerHTML = '<span class="row-details row-details-close"></span>';

		$('#sample_1 thead tr').each(function() {
			this.insertBefore(nCloneTh, this.childNodes[0]);
		});

		$('#sample_1 tbody tr').each(function() {
			this.insertBefore(nCloneTd.cloneNode(true), this.childNodes[0]);
		});

		/*
		 * 列排序
		 */
		var oTable = $('#sample_1').dataTable({
			"aoColumnDefs" : [ {
				"bSortable" : false,
				"aTargets" : [ 0 ]
			} ],
			"aaSorting" : [ [ 1, 'asc' ] ],
			"aLengthMenu" : [ [ 5, 15, 20, -1 ], [ 5, 15, 20, "All" ] // change
			// per
			// page
			// values
			// here
			],
			// set the initial value
			"iDisplayLength" : 10,
		});

		jQuery('#sample_1_wrapper .dataTables_filter input').addClass(
				"form-control input-small"); // modify table search input
		jQuery('#sample_1_wrapper .dataTables_length select').addClass(
				"form-control input-small"); // modify table per page
		// dropdown
		jQuery('#sample_1_wrapper .dataTables_length select').select2(); // initialize
		// select2
		// dropdown

		/*
		 * Add event listener for opening and closing details Note that the
		 * indicator for showing which row is open is not controlled by
		 * DataTables, rather it is done here
		 */
		$('#sample_1').on(
				'click',
				' tbody td .row-details',
				function() {
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
	}

	return {
		// main function to initiate the module
		init : function() {
			if (!jQuery().dataTable) {
				return;
			}
			initTable1();
		}

	};

}();