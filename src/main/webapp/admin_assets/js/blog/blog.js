var Blog = function () {

    var newDes;
    var editDes;


    var BlogService = {

        newDes: function () {
            if (!($("#content")[0] == undefined)) {
                if (CKEDITOR.instances['content']) {
                    CKEDITOR.instances['content'].destroy();
                }
                return CKEDITOR.replace('content');
            }

        }(),
        editDes: function () {
            if (!($("#_content")[0] == undefined)) {
                if (CKEDITOR.instances['_content']) {
                    CKEDITOR.instances['_content'].destroy();
                }
                return CKEDITOR.replace('_content');
            }
        }(),
        addBlog: function () {
            var data = {
                title: $("#title").val(),
                content: newDes.getData(),
                info: ""
            }
            data.info = JSON.stringify({
                blogTag: $("#blogTags").val(),
                blogType: $("#blogType").val()
            })
            $.ajax({
                url: basePath + "blog.hopedo",
                data: JSON.stringify(data),
                contentType: 'application/json',
                type: "POST",
                success: function (data) {
                    var status = data.returnState;
                    if (status == "OK") {
                        toast.success(data.returnMsg);
                        $("#addBlogButton").hide();
                        setTimeout(function () {
                            window.location.href = basePath + "/blog/conf.hopedo";
                        }, 1000)
                    } else {
                        toast.success(data.returnMsg)
                    }
                }
            });
        },
        updateBlog: function () {
            var _title = $("#_title").val();
            var _content = editDes.getData();
            var _tags = $("#_tags").val();
            var _type = $("#_type").val();
            var data = {
                blogId: parseInt($("#_blogId").val(), 10),
                title: _title,
                content: _content,
                info: ""
            };
            data.info = JSON.stringify({
                blogTag: _tags,
                blogType: _type
            })
            $.ajax({
                url: basePath + "blog.hopedo",
                contentType: 'application/json',
                type: "PUT",
                data: JSON.stringify(data),
                async: false,
                success: function (data) {
                    var status = data.returnState;
                    if (status == "OK") {
                        $("#updateBlogButton").hide();
                        toast.success(data.returnMsg);
                        setTimeout(function () {
                                window.location.href = basePath + "blog/conf.hopedo";
                            }
                            , 1000);
                    } else {
                        toast.error(data.returnMsg);
                    }
                }
            })
        },
        reloadBlog: function () {
            var editBlogId = $("#isEdit").text();
            if (editBlogId == 0 || editBlogId == undefined) {
                return;
            }
            $.ajax({
                url: basePath + "blog/" + editBlogId + ".hopedo",
                contentType: 'application/json',
                type: "GET",
                async: false,
                success: function (data) {
                    var status = data.returnState;
                    if (status == "OK") {
                        toast.success(data.returnMsg);
                        var editBlog = data.returnData.blog;
                        $("#_blogId").val(editBlog.blogId);
                        $("#_title").val(editBlog.title);
                        editDes.setData(editBlog.content);
                        var info = eval("(" + editBlog.info + ")");
                        $("#_tags").val(info.blogTag);
                        $("#_type").val(info.blogType);
                    } else {
                        toast.error(data.returnMsg);
                    }
                }
            });
        },
        image2Text: function (path, des) {
            des.insertHtml("<img src='" + path + "'>");
        },
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
                error: function (data, status, e) {
                    toast.error(e);
                }

            })
        }
    }

    var handleEvent = function () {
        $("#updateBlogButton").click(function () {
            BlogService.updateBlog();
        });
        $("#updateImageButton").on("click", function () {
            BlogService.uploadImage("image", "image", $("#images"));
        });
        $("#_updateImageButton").on("click", function () {
            BlogService.uploadImage("_image", "image", $("#_images"));
        });
        $("#reloadEditBlog").on("click", function () {
            BlogService.reloadBlog();
        });
        $("#addBlogButton").on("click", function () {
            BlogService.addBlog();
        });
        $("ul li .insertImage").live("click", function () {
            var path = $(this).parent().first().children(".imagePath").text();
            BlogService.image2Text(path, newDes);
            BlogService.image2Text(path, editDes);
        });
    }


    return {
        init: function () {
            newDes = BlogService.newDes;
            editDes = BlogService.editDes;
            BlogService.reloadBlog();
            handleEvent();
        }
    }

}();