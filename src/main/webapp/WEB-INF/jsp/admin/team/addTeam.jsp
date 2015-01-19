<%@ page language="java" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <!-- head的include区 -->
    <%@include file="../template/template_page_head.jsp" %>
    <title>项目组维护</title>
    <!-- head的include区 结束  -->
</head>
<body class="page-header-fixed page-footer-fixed">

<jsp:include page="../template/template_page_header.jsp" flush="true"/>

<div class="page-container">

    <jsp:include page="../template/template_page_sidebar.jsp" flush="true"/>

    <!--========================页面开始处======================== -->
    <div class="page-content">
        <jsp:include page="../template/template_page_modal.jsp" flush="true"/>
        <jsp:include page="../template/template_page_style.jsp" flush="true"/>

        <div class="row">
            <div class="col-md-12">
                <h3 class="page-title">
                    创建新项目组
                    <small>Create New Team</small>
                </h3>
                <span hidden="hidden" id="isEdit"><%=request.getAttribute("isEdit")%></span>
                <span hidden="hidden" id="teamId"><%=request.getAttribute("teamId")%></span>
                <span hidden="hidden" id="oldTeamName"></span>
                <ul class="page-breadcrumb breadcrumb">
                    <li class="btn-group">
                        <button type="button" class="btn blue dropdown-toggle"
                                data-toggle="dropdown" data-hover="dropdown" data-delay="1000"
                                data-close-others="true">
                            <span>动作</span> <i class="icon-angle-down"></i>
                        </button>
                        <ul class="dropdown-menu pull-right" role="menu">
                            <li><a href="javascript:;" id="refreshTeam"><i
                                    class="icon-refresh"></i>刷新项目组信息</a></li>
                            <li id="deleteTeamLi"><a href="javascript:;" id="deleteTeam"><i
                                    class="icon-refresh"></i>删除当前项目组</a></li>
                        </ul>
                    </li>
                    <li><i class="icon-home"></i> <a href="page/index.hopedo">主页</a>
                        <i class="icon-angle-right"></i></li>
                    <li><a href="javascript:;">项目组维护</a></li>
                </ul>

            </div>
        </div>
        <!-- 页面内容头结束 -->
        <!-- 页面正文-->
        <div class="row">
            <div class="col-md-12" id="addArea">
                <div class="portlet box blue" id="boxColor">
                    <div class="portlet-title">
                        <div class="caption">
                            <i class="icon-globe"></i><span id="typeTitle"></span>
                        </div>
                        <div class="tools">
                            <a href="javascript:;" class="reload"></a> <a
                                href="javascript:;" class="remove"></a>
                        </div>
                    </div>
                    <div class="portlet-body">
                        <div class="form-body">
                            <div class="form-group">
                                <div class="portlet">
                                    <div class="portlet-title">
                                        <div class="caption"><i class="icon-bell"></i>项目组基本信息</div>
                                        <div class="tools">
                                            <a href="javascript:;" class="collapse"></a>
                                        </div>
                                    </div>
                                    <div class="portlet-body">
                                        <label>项目组名称</label>
                                        <input type="text" class="form-control input-lg" name="title" id="title"
                                               placeholder="输入项目组的名称...">
                                        <label>项目组描述&nbsp;
                                            <small>可以从Word文档中复制哦！</small>
                                        </label>
                                        <textarea class="form-control" name="newDes" 　id="newDes" rows="200"
                                                  cols="50"></textarea>
                                        <br/>
                                        <label>插入图片
                                            <small>上传后使用链接到编辑器提交链接来显示图片</small>
                                        </label>

                                        <div class="confirm-group">
                                            <ul class="breadcrumb" id="images">
                                                <li>
                                                    上传过的图片链接，点击插入或者点击编辑器中的插入按钮输入链接皆可插入图片
                                                </li>
                                                <br/>
                                            </ul>
                                        </div>
                                        <form id="uploadImageForm" enctype="multipart/form-data">
                                            <div class="form-group" style="margin-bottom: 50px;">
                                                <label class="col-md-3 control-label btn btn-primary"
                                                       id="updateImageButton">上传当前图片<br/>
                                                </label>

                                                <div class="col-md-9">
                                                    <input type="file" id="image" name="image">

                                                    <p class="help-block">在本地选择要上传的图片，点击提交图片按钮</p>
                                                </div>
                                            </div>
                                        </form>
                                        <label>项目组种类</label>
                                        <select class="form-control input-lg" id="teamType" name="teamType">
                                            <option value="1">1</option>
                                        </select>
                                    </div>
                                </div>
                            </div>
                            <div class="form-group col-md-8" style="padding-left: 0px;">
                                <div class="portlet" id="imageAndMember_ADD">
                                    <div class="portlet-title">
                                        <div class="caption"><i class="icon-bell"></i>项目组图片上传</div>
                                        <div class="tools">
                                            <a href="javascript:;" class="collapse"></a>
                                        </div>
                                    </div>
                                    <div class="portlet-body col-md-12" style="padding-left: 0px;">
                                        <div class="col-md-12" style="padding-left: 0px;">
                                            <div class="panel panel-success">
                                                <div class="panel-heading">
                                                    <h4 class="panel-title">上传注意事项</h4>
                                                </div>
                                                <div class="panel-body">
                                                    <ul>
                                                        <li>文件上传大小最大为5MB
                                                        </li>
                                                        <li>只能上传(<strong>JPG, GIF, PNG</strong>)格式的图片
                                                        </li>
                                                    </ul>
                                                </div>
                                            </div>
                                            <form id="fileupload" action="${basePath}/baseAjax/multiUpload.hopedo"
                                                  method="POST"
                                                  enctype="multipart/form-data">
                                                <div class="row fileupload-buttonbar">
                                                    <div class="col-lg-7">
                                                        <span class="btn green fileinput-button">
                                                        <i class="icon-plus"></i>
                                                        <span>添加文件</span>
                                                        <input type="file" name="files[]" multiple>
                                                        </span>
                                                        <button type="submit" class="btn blue start">
                                                            <i class="icon-upload"></i>
                                                            <span>开始上传</span>
                                                        </button>
                                                        <button type="reset" class="btn yellow cancel">
                                                            <i class="icon-ban-circle"></i>
                                                            <span>取消上传</span>
                                                        </button>
                                                        <input type="checkbox" class="toggle">
                                                        <span class="fileupload-loading"></span>
                                                    </div>
                                                    <div class="col-lg-5 fileupload-progress fade">
                                                        <div class="progress progress-striped active" role="progressbar"
                                                             aria-valuemin="0"
                                                             aria-valuemax="100">
                                                            <div class="progress-bar progress-bar-success"
                                                                 style="width:0%;"></div>
                                                        </div>
                                                        <div class="progress-extended">&nbsp;</div>
                                                    </div>
                                                </div>
                                                <table role="presentation" id="imageTable"
                                                       class="table table-striped clearfix">
                                                    <tbody class="files"></tbody>
                                                    <tbody class="completeFiles"></tbody>
                                                    <tbody class="oldFiles"></tbody>
                                                </table>
                                            </form>
                                        </div>

                                    </div>
                                </div>
                            </div>
                            <div class="form-group col-md-4">
                                <div class="portlet ">
                                    <div class="portlet">
                                        <div class="portlet-title">
                                            <div class="caption"><i class="icon-bell"></i>团队成员信息</div>
                                            <div class="tools">
                                                <a href="javascript:;" class="collapse"></a>
                                            </div>
                                        </div>
                                        <div class="portlet-body">
                                            <div>
                                                <p class="help-block">请输入待添加成员姓名</p>
                                                <input type="text"
                                                       id="memberNameQuery"
                                                       class="form-control input-large"
                                                       data-provide="typeahead"
                                                       data-items="4"
                                                       data-source="[&quot;Alabama&quot;,&quot; Support <support@demo.com> &quot;,&quot;Arizona&quot;,&quot;Arkansas&quot;,&quot;California&quot;,&quot;Colorado&quot;,&quot;Connecticut&quot;,&quot;Delaware&quot;,&quot;Florida&quot;,&quot;Georgia&quot;,&quot;Hawaii&quot;,&quot;Idaho&quot;,&quot;Illinois&quot;,&quot;Indiana&quot;,&quot;Iowa&quot;,&quot;Kansas&quot;,&quot;Kentucky&quot;,&quot;Louisiana&quot;,&quot;Maine&quot;,&quot;Maryland&quot;,&quot;Massachusetts&quot;,&quot;Michigan&quot;,&quot;Minnesota&quot;,&quot;Mississippi&quot;,&quot;Missouri&quot;,&quot;Montana&quot;,&quot;Nebraska&quot;,&quot;Nevada&quot;,&quot;New Hampshire&quot;,&quot;New Jersey&quot;,&quot;New Mexico&quot;,&quot;New York&quot;,&quot;North Dakota&quot;,&quot;North Carolina&quot;,&quot;Ohio&quot;,&quot;Oklahoma&quot;,&quot;Oregon&quot;,&quot;Pennsylvania&quot;,&quot;Rhode Island&quot;,&quot;South Carolina&quot;,&quot;South Dakota&quot;,&quot;Tennessee&quot;,&quot;Texas&quot;,&quot;Utah&quot;,&quot;Vermont&quot;,&quot;Virginia&quot;,&quot;Washington&quot;,&quot;West Virginia&quot;,&quot;Wisconsin&quot;,&quot;Wyoming&quot;]"/>
                                            </div>
                                            <br/>
                                            <div class="table-responsive">
                                                <table class="table table-striped table-bordered table-advance table-hover">
                                                    <thead>
                                                    <tr>
                                                        <th><i class="icon-briefcase"></i> 成员姓名</th>
                                                        <th class="hidden-xs"><i class="icon-user"></i> 成员邮箱</th>
                                                        <th><i class="icon-shopping-cart"></i> 状态</th>
                                                        <th>动作</th>
                                                    </tr>
                                                    </thead>
                                                    <tbody id="memberTable">
                                                    </tbody>
                                                </table>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>

                        </div>
                        <button type="button" class="btn btn-block green" id="addTeamButton">创建新项目组</button>
                        <button type="button" id="updateTeamButton" class="btn btn-block red">提交修改</button>
                    </div>
                </div>
            </div>
            <!-- 页面正文结束-->
            <div id="deleteModal" class="modal fade" tabindex="-1">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true"></button>
                    <h4 class="modal-title">删除项目组</h4>
                </div>
                <div class="modal-body">
                    <p><font color="red"><h4>注意：您正在进行危险操作</h4></font></p>

                    <p>您确定您要删除这个项目组么？<br/>
                        它的一切数据、工程、图片、任务和成员关系将无法找回，您确定要这样做么？<br/>
                        如果您确实想要删除这个项目组，那么在下面的输入框中输入项目组的名称</p>
                    <input type="text" class="form-control" name="" id="deleteTeamName"/>
                </div>
                <div class="modal-footer">
                    <button type="button" data-dismiss="modal" class="btn btn-default">取消</button>
                    <button type="button" id="deleteTeamButton" class="btn red">确认删除项目组</button>
                </div>
            </div>
        </div>
        <!-- ======================== 页面结束处======================== -->
    </div>
    <%@include file="../template/template_page_footer.jsp" %>
    <%@include file="../template/template_page_javascript.jsp" %>
    <script src="admin_assets/plugins/jquery-file-upload/js/vendor/jquery.ui.widget.js"></script>
    <script src="admin_assets/plugins/jquery-file-upload/js/vendor/tmpl.min.js"></script>
    <script src="admin_assets/plugins/jquery-file-upload/js/vendor/load-image.min.js"></script>
    <script src="admin_assets/plugins/jquery-file-upload/js/vendor/canvas-to-blob.min.js"></script>
    <script src="admin_assets/plugins/jquery-file-upload/js/jquery.iframe-transport.js"></script>
    <script src="admin_assets/plugins/jquery-file-upload/js/jquery.fileupload.js"></script>
    <script src="admin_assets/plugins/jquery-file-upload/js/jquery.fileupload-process.js"></script>
    <script src="admin_assets/plugins/jquery-file-upload/js/jquery.fileupload-image.js"></script>
    <script src="admin_assets/plugins/jquery-file-upload/js/jquery.fileupload-audio.js"></script>
    <script src="admin_assets/plugins/jquery-file-upload/js/jquery.fileupload-video.js"></script>
    <script src="admin_assets/plugins/jquery-file-upload/js/jquery.fileupload-validate.js"></script>
    <script src="admin_assets/plugins/jquery-file-upload/js/jquery.fileupload-ui.js"></script>
    <script id="template-upload" type="text/x-tmpl">
      {% for (var i=0, file; file=o.files[i]; i++) { %}
          <tr class="template-upload fade">
              <td>
                  <span class="preview"></span>
              </td>
              <td>
                  <p class="name">{%=file.name%}</p>
                  {% if (file.error) { %}
                      <div><span class="label label-danger">Error</span> {%=file.error%}</div>
                  {% } %}
              </td>
              <td>
                  <p class="size">{%=o.formatFileSize(file.size)%}</p>
                  {% if (!o.files.error) { %}
                      <div class="progress progress-striped active" role="progressbar" aria-valuemin="0" aria-valuemax="100" aria-valuenow="0">
                      <div class="progress-bar progress-bar-success" style="width:0%;"></div>
                      </div>
                  {% } %}
              </td>
              <td>
                  {% if (!o.files.error && !i && !o.options.autoUpload) { %}
                      <button class="btn blue start">
                          <i class="icon-upload"></i>
                          <span>开始上传</span>
                      </button>
                  {% } %}
                  {% if (!i) { %}
                      <button class="btn red cancel">
                          <i class="icon-ban-circle"></i>
                          <span>取消上传</span>
                      </button>
                  {% } %}
              </td>
          </tr>
      {% } %}





























    </script>
    <script id="template-download" type="text/x-tmpl">
      {% for (var i=0, file; file=o.files[i]; i++) { %}
          <tr class="template-download fade">
              <td>
                  <span class="preview">
                      {% if (file.thumbnailUrl) { %}
                          <a href="{%=file.url%}" title="{%=file.name%}" download="{%=file.name%}" data-gallery><img src="{%=file.thumbnailUrl%}"></a>
                      {% } %}
                  </span>
              </td>
              <td>
                  <p class="name">
                      {% if (file.url) { %}
                          <a href="{%=file.url%}" title="{%=file.name%}" download="{%=file.name%}" {%=file.thumbnailUrl?'data-gallery':''%}>{%=file.name%}</a>
                      {% } else { %}
                          <span>{%=file.name%}</span>
                      {% } %}
                  </p>
                  {% if (file.error) { %}
                      <div><span class="label label-danger">Error</span> {%=file.error%}</div>
                  {% } %}
              </td>
              <td>
                  <span class="size">{%=o.formatFileSize(file.size)%}</span>
              </td>
              <td>
                  {% if (file.deleteUrl) { %}
                      <button class="btn red delete" data-type="{%=file.deleteType%}" data-url="{%=file.deleteUrl%}"{% if (file.deleteWithCredentials) { %} data-xhr-fields='{"withCredentials":true}'{% } %}>
                          <i class="icon-trash"></i>
                          <span>Delete</span>
                      </button>
                      <input type="checkbox" name="delete" value="1" class="toggle">
                  {% } else { %}
                      <button class="btn yellow cancel">
                          <i class="icon-ban-circle"></i>
                          <span>Cancel</span>

                  {% } %}
              </td>
          </tr>
      {% } %}
                      </button>




















    </script>
    <script type="text/javascript" src="admin_assets/js/team/team.js"></script>
    <script type="text/javascript">
        $(document).on("ready", function () {
            Team.init();
        });
    </script>
</body>
</html>

