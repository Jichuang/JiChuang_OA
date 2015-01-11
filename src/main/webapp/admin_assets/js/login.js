/**
 * Created by Zhaopeng-Rabook on 15-1-10.
 */
var Login = function () {

    function validateLoginMember(data) {
        if (data.username == "" || data.password == "") {
            return false;
        }
        return true;
    }

    function validateRegisterMember(data, rpassword) {
        if (data.username == "" || data.password == "" || rpassword != data.password || data.name == "") {
            return false;
        }
        return true;
    }

    var loginService = {
        login: function () {
            var member = {
                username: $("#username").val(),
                password: $("#password").val()
            }
            if (!validateLoginMember(member)) {
                toast.error("请输入登陆信息");
                return;
            }
            toast.info("正在登录中……");
            $.ajax({
                url: basePath + 'member/login.hopedo',
                type: 'POST',
                data: JSON.stringify(member),
                contentType: 'application/json',
                success: function (data) {
                    var status = data.returnState;
                    if (status == "OK") {
                        toast.success("登陆成功正在跳转");
                        setTimeout(function () {
                            window.location.href = basePath + "/page/index.hopedo";
                        }, 2000);

                    } else {
                        toast.error("登录失败，请确认用户名和密码");
                    }
                },
                error: function (data) {
                    toast.error(data);
                }
            });
        },
        register: function () {
            var member = {
                username: $("#_username").val(),
                password: $("#_password").val(),
                name: $("#name").val(),
                info: ""
            }
            if (!validateRegisterMember(member, $("#_rpassword").val())) {
                toast.error("请填写基本信息")
                return;
            }
            toast.info("正在注册中，请稍候……");
            member.info = {
                sex: $("#sex").val(),
                phone: $("#phone").val(),
                country: $("#country").val()

            }
            $.ajax({
                url: basePath + 'member/register.hopedo',
                type: 'POST',
                data: JSON.stringify(member),
                contentType: 'application/json',
                success: function (data) {
                    var status = data.returnState;
                    if (status == "OK") {
                        toast.success("注册成功");
                        setTimeout(function () {
                            window.location.href = basePath + "/page/login.hopedo";
                        }, 2000);
                    } else {
                        toast.error("登录失败，请确认用户名和密码");
                    }
                },
                error: function (data) {
                    toast.error(data);
                }
            });

        },
        forgetPassword: function () {

        }
    }

    var handleEvent = function () {

        $("#loginButton").on("click", loginService.login);
        $("#registerButton").on("click", loginService.register);
        jQuery('#forget-password').click(function () {
            jQuery('.login-form').hide();
            jQuery('.forget-form').show();
        });

        jQuery('#back-btn').click(function () {
            jQuery('.login-form').show();
            jQuery('.forget-form').hide();
        });

        jQuery('#register-btn').click(function () {
            jQuery('.login-form').hide();
            jQuery('.register-form').show();
        });

        jQuery('#register-back-btn').click(function () {
            jQuery('.login-form').show();
            jQuery('.register-form').hide();
        });
        $.backstretch([
            "admin_assets/img/bg/1.jpg",
            "admin_assets/img/bg/2.jpg",
            "admin_assets/img/bg/3.jpg",
            "admin_assets/img/bg/4.jpg"
        ], {
            fade: 1000,
            duration: 8000
        });

        $("#select2_sample4").select2({
            placeholder: '<i class="icon-map-marker"></i>&nbsp;Select a Country',
            allowClear: true,
            escapeMarkup: function (m) {
                return m;
            }
        });


        $('#select2_sample4').change(function () {
            $('.register-form').validate().element($(this)); //revalidate the chosen dropdown value and show error or success message for the input
        });
    }

    return{

        init: function () {
            handleEvent();
        }

    }


}();
