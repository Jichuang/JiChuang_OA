var FrontTeam = function () {

    var basePath = function () {
        var url = window.location + "";
        var h = url.split("//");
        var x = h[1].split("/");
        return h[0] + "//" + window.location.host + "/" + x[1] + "/";
    }();
    var ProjectService = {
        initTeamList: function (teamList) {
            var team = "";
            for (var i = 0; i < teamList.length; i++) {
                var imagePath = teamList[i].image;
                var teamName = teamList[i].name;
                var teamDes = teamList[i].des;
                var teamTypeId = teamList[i].teamTypeId.teamTypeId;
                var str = '<div class="col-md-4 col-sm-6 mix  ' + teamTypeId + ' "> <div class="mix-inner"> ' +
                    '<img class="img-responsive" src="' + imagePath + '" alt=""> ' +
                    '<div class="mix-details"> <h4>' + teamName + '</h4> ' +
                    '<p>' + teamDes + '</p> ' +
                    '<a class="mix-link"><i class="icon-link"></i></a> ' +
                    '<a class="mix-preview fancybox-button" href="' + imagePath + '" title="' + teamName + '"' +
                    ' data-rel="fancybox-button">' +
                    '<i class="icon-search"></i></a> </div> </div> </div>';
                team += str;
            }
            $("#teamList").append(team);
            $('.mix-grid').mixitup();
        },
        initTeamTypeList: function (teamTypeList) {
            var type = "";
            for (var i = 0; i < teamTypeList.length; i++) {
                var teamTypeId = teamTypeList[i].teamTypeId;
                var teamTypeName = teamTypeList[i].name;
                var str = '<li class="filter" data-filter="' + teamTypeId + '">' + teamTypeName + '</li>';
                type += str;
            }
            $("#teamTypeList").append(type);
        },
        getTeamList: function () {
            $.ajax({
                url: basePath + "/team/getFront.hopedo",
                type: "GET",
                contentType: 'application/json',
                success: function (data) {
                    var status = data.returnState;
                    if (status == "OK") {
                        var teamList = data.returnData.teamList;
                        ProjectService.initTeamList(teamList);
                    } else {
                        toast.error(data.returnMsg);
                    }
                }
            });
        },
        getTeamType: function () {
            $.ajax({
                url: basePath + "/teamType.hopedo",
                type: "GET",
                contentType: 'application/json',
                success: function (data) {
                    var status = data.returnState;
                    if (status == "OK") {
                        var teamTypeList = data.returnData.teamTypeList;
                        ProjectService.initTeamTypeList(teamTypeList);
                    } else {
                        toast.error(data.returnMsg);
                    }
                }
            });
        }
    }

    var handleEvent = function () {

    }

    return {
        //main function to initiate the module
        init: function () {
            handleEvent();
            ProjectService.getTeamType();
            ProjectService.getTeamList();
        }
    };

}();