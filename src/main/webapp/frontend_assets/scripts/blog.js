var FrontBlog = function () {

    var basePath = function () {
        var url = window.location + "";
        var h = url.split("//");
        var x = h[1].split("/");
        return h[0] + "//" + window.location.host + "/" + x[1] + "/";
    }();


    var ShowBlogService = {
        refreshBlog: function () {
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
                url: basePath + "/blog/" + blogId + ".hopedo",
                data: (blogId),
                contentType: 'application/json',
                type: "GET",
                success: function (data) {
                    var status = data.returnState;
                    if (status == "OK") {
                        toast.success(data.returnMsg);
                        var blogItem = data.returnData.blog;
                        var blogInfo = eval("(" + blogItem.info + ")");
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
    }

    var handleEvent = function () {
        $("#refreshBlogItemButton").on("click", function () {
            ShowBlogService.refreshBlog();
        });
    }

    return {
        init: function () {
            handleEvent();
            ShowBlogService.refreshBlog();
        }
    }

}();