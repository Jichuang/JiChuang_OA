<%@ page language="java" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<head>
    <title>集创OA登录</title>
    <link rel="shortcut icon" href="favicon.ico"/>
    <%@include file="template/template_page_head.jsp" %>
    "/>
</head>
<body class="login">
<div class="logo">
    <img src="frontend_assets/img/logo.png" alt=""/>
</div>
<div class="content">
    <form class="login-form">
        <h3 class="form-title">请输入您的账号密码</h3>

        <div class="alert alert-error hide">
            <button class="close" data-dismiss="alert"></button>
            <span>请输入账号和密码</span>
        </div>
        <div class="form-group">
            <label class="control-label visible-ie8 visible-ie9">账号</label>

            <div class="input-icon">
                <i class="icon-user"></i> <input
                    class="form-control placeholder-no-fix" type="text"
                    autocomplete="off" placeholder="输入账号" name="username" id="username"/>
            </div>
        </div>
        <div class="form-group">
            <label class="control-label visible-ie8 visible-ie9">密码</label>

            <div class="input-icon">
                <i class="icon-lock"></i> <input
                    class="form-control placeholder-no-fix" type="password" id="password"
                    autocomplete="off" placeholder="输入密码" name="password"/>
            </div>
        </div>
        <div class="form-actions">
            <label class="checkbox"> <input type="checkbox"
                                            name="remember" value="1"/> 记住我一周
            </label>
            <button type="button" class="btn blue pull-right" id="loginButton">
                登录 <i class="m-icon-swapright m-icon-white"></i>
            </button>
        </div>
        <div class="forget-password">
            <h4>忘记密码?</h4>

            <p>
                不用担心，点击 <a href="javascript:;" id="forget-password">这里</a>
                通过邮箱重置您的密码.
            </p>
        </div>
        <div class="create-account">
            <p>
                还没有账号 ?&nbsp; <a href="javascript:;" id="register-btn">15秒快速注册</a>
            </p>
        </div>
    </form>
    <form class="forget-form">
        <h3>忘记密码 ?</h3>

        <p>请输入您的注册电邮以验证您的身份</p>

        <div class="form-group">
            <div class="input-icon">
                <i class="icon-envelope"></i> <input
                    class="form-control placeholder-no-fix" type="text"
                    autocomplete="off" placeholder="Email" name="email"/>
            </div>
        </div>
        <div class="form-actions">
            <button type="button" id="back-btn" class="btn">
                <i class="m-icon-swapleft"></i> 取消
            </button>
            <button type="button" class="btn blue pull-right">
                提交 <i class="m-icon-swapright m-icon-white"></i>
            </button>
        </div>
    </form>
    <form class="register-form">
        <h3>注册新账号</h3>

        <p>请输入您的基本信息</p>

        <div class="form-group">
            <label class="control-label visible-ie8 visible-ie9">姓名</label>

            <div class="input-icon">
                <i class="icon-font"></i> <input
                    class="form-control placeholder-no-fix" type="text"
                    placeholder="姓名" id="name"/>
            </div>
        </div>
        <div class="form-group">
            <label class="control-label visible-ie8 visible-ie9">性别</label> <select
                id="sex" id="" class="select2 form-control">
            <option value="MALE">男性</option>
            <option value="FEMALE">女性</option>
        </select>
        </div>
        <div class="form-group">
            <label class="control-label visible-ie8 visible-ie9">电话号码</label>

            <div class="input-icon">
                <i class="icon-phone"></i> <input
                    class="form-control placeholder-no-fix" type="text"
                    placeholder="电话号码" id="phone"/>
            </div>
        </div>
        <p>填写您的登录信息</p>

        <div class="form-group">
            <label class="control-label visible-ie8 visible-ie9">注册邮箱</label>

            <div class="input-icon">
                <i class="icon-user"></i> <input
                    class="form-control placeholder-no-fix" type="text"
                    autocomplete="off" placeholder="注册邮箱" id="_username"/>
            </div>
        </div>
        <div class="form-group">
            <label class="control-label visible-ie8 visible-ie9">密码</label>

            <div class="input-icon">
                <i class="icon-lock"></i> <input
                    class="form-control placeholder-no-fix" type="password"
                    autocomplete="off" id="_password" placeholder="密码"
                    name="password"/>
            </div>
        </div>
        <div class="form-group">
            <label class="control-label visible-ie8 visible-ie9">请再输入一遍密码</label>

            <div class="controls">
                <div class="input-icon">
                    <i class="icon-ok"></i> <input
                        class="form-control placeholder-no-fix" type="password"
                        autocomplete="off" placeholder="请再输入一遍密码" id="_rpassword"/>
                </div>
            </div>
        </div>
        <div class="form-group">
            <label> <input type="checkbox" name="tnc"/> 我同意 <a
                    href="#">服务条款</a> 和 <a href="#">隐私保护声明</a>
            </label>

            <div id="register_tnc_error"></div>
        </div>
        <div class="form-actions">
            <button id="register-back-btn" type="button" class="btn">
                <i class="m-icon-swapleft"></i> 后退
            </button>
            <button type="button"
                    class="btn blue pull-right" id="registerButton">
                确认信息并注册 <i class="m-icon-swapright m-icon-white"></i>
            </button>
        </div>
    </form>
</div>
<div class="copyright">2014 &copy; Hope6537 ChangChun University JiChuang Team.
</div>
<jsp:include page="template/template_page_javascript.jsp"/>
<script src="admin_assets/js/login.js"></script>
<script type="text/javascript">
    $(document).ready(function () {
        Login.init();
    });
</script>
</body>
</html>
