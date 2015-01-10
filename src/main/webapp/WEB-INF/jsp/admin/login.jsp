<%@ page language="java" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<head>
    <title>集创OA登录</title>
    <link rel="shortcut icon" href="favicon.ico"/>
    <jsp:include page="template/template_page_head.jsp"/>
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
        <button type="button"  class="btn blue pull-right" id="loginButton">
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
<div class="form-group">
<label class="control-label visible-ie8 visible-ie9">国家</label> <select
        id="country" id="select2_sample4" class="select2 form-control">
<option value=""></option>
<option value="AF">Afghanistan</option>
<option value="AL">Albania</option>
<option value="DZ">Algeria</option>
<option value="AS">American Samoa</option>
<option value="AD">Andorra</option>
<option value="AO">Angola</option>
<option value="AI">Anguilla</option>
<option value="AQ">Antarctica</option>
<option value="AR">Argentina</option>
<option value="AM">Armenia</option>
<option value="AW">Aruba</option>
<option value="AU">Australia</option>
<option value="AT">Austria</option>
<option value="AZ">Azerbaijan</option>
<option value="BS">Bahamas</option>
<option value="BH">Bahrain</option>
<option value="BD">Bangladesh</option>
<option value="BB">Barbados</option>
<option value="BY">Belarus</option>
<option value="BE">Belgium</option>
<option value="BZ">Belize</option>
<option value="BJ">Benin</option>
<option value="BM">Bermuda</option>
<option value="BT">Bhutan</option>
<option value="BO">Bolivia</option>
<option value="BA">Bosnia and Herzegowina</option>
<option value="BW">Botswana</option>
<option value="BV">Bouvet Island</option>
<option value="BR">Brazil</option>
<option value="IO">British Indian Ocean Territory</option>
<option value="BN">Brunei Darussalam</option>
<option value="BG">Bulgaria</option>
<option value="BF">Burkina Faso</option>
<option value="BI">Burundi</option>
<option value="KH">Cambodia</option>
<option value="CM">Cameroon</option>
<option value="CA">Canada</option>
<option value="CV">Cape Verde</option>
<option value="KY">Cayman Islands</option>
<option value="CF">Central African Republic</option>
<option value="TD">Chad</option>
<option value="CL">Chile</option>
<option selected="selected" value="CN">中国</option>
<option value="CX">Christmas Island</option>
<option value="CC">Cocos (Keeling) Islands</option>
<option value="CO">Colombia</option>
<option value="KM">Comoros</option>
<option value="CG">Congo</option>
<option value="CD">Congo, the Democratic Republic of the</option>
<option value="CK">Cook Islands</option>
<option value="CR">Costa Rica</option>
<option value="CI">Cote d'Ivoire</option>
<option value="HR">Croatia (Hrvatska)</option>
<option value="CU">Cuba</option>
<option value="CY">Cyprus</option>
<option value="CZ">Czech Republic</option>
<option value="DK">Denmark</option>
<option value="DJ">Djibouti</option>
<option value="DM">Dominica</option>
<option value="DO">Dominican Republic</option>
<option value="EC">Ecuador</option>
<option value="EG">Egypt</option>
<option value="SV">El Salvador</option>
<option value="GQ">Equatorial Guinea</option>
<option value="ER">Eritrea</option>
<option value="EE">Estonia</option>
<option value="ET">Ethiopia</option>
<option value="FK">Falkland Islands (Malvinas)</option>
<option value="FO">Faroe Islands</option>
<option value="FJ">Fiji</option>
<option value="FI">Finland</option>
<option value="FR">France</option>
<option value="GF">French Guiana</option>
<option value="PF">French Polynesia</option>
<option value="TF">French Southern Territories</option>
<option value="GA">Gabon</option>
<option value="GM">Gambia</option>
<option value="GE">Georgia</option>
<option value="DE">Germany</option>
<option value="GH">Ghana</option>
<option value="GI">Gibraltar</option>
<option value="GR">Greece</option>
<option value="GL">Greenland</option>
<option value="GD">Grenada</option>
<option value="GP">Guadeloupe</option>
<option value="GU">Guam</option>
<option value="GT">Guatemala</option>
<option value="GN">Guinea</option>
<option value="GW">Guinea-Bissau</option>
<option value="GY">Guyana</option>
<option value="HT">Haiti</option>
<option value="HM">Heard and Mc Donald Islands</option>
<option value="VA">Holy See (Vatican City State)</option>
<option value="HN">Honduras</option>
<option value="HK">Hong Kong</option>
<option value="HU">Hungary</option>
<option value="IS">Iceland</option>
<option value="IN">India</option>
<option value="ID">Indonesia</option>
<option value="IR">Iran (Islamic Republic of)</option>
<option value="IQ">Iraq</option>
<option value="IE">Ireland</option>
<option value="IL">Israel</option>
<option value="IT">Italy</option>
<option value="JM">Jamaica</option>
<option value="JP">日本</option>
<option value="JO">Jordan</option>
<option value="KZ">Kazakhstan</option>
<option value="KE">Kenya</option>
<option value="KI">Kiribati</option>
<option value="KP">Korea, Democratic People's Republic of</option>
<option value="KR">Korea, Republic of</option>
<option value="KW">Kuwait</option>
<option value="KG">Kyrgyzstan</option>
<option value="LA">Lao People's Democratic Republic</option>
<option value="LV">Latvia</option>
<option value="LB">Lebanon</option>
<option value="LS">Lesotho</option>
<option value="LR">Liberia</option>
<option value="LY">Libyan Arab Jamahiriya</option>
<option value="LI">Liechtenstein</option>
<option value="LT">Lithuania</option>
<option value="LU">Luxembourg</option>
<option value="MO">Macau</option>
<option value="MK">Macedonia, The Former Yugoslav Republic
    of
</option>
<option value="MG">Madagascar</option>
<option value="MW">Malawi</option>
<option value="MY">Malaysia</option>
<option value="MV">Maldives</option>
<option value="ML">Mali</option>
<option value="MT">Malta</option>
<option value="MH">Marshall Islands</option>
<option value="MQ">Martinique</option>
<option value="MR">Mauritania</option>
<option value="MU">Mauritius</option>
<option value="YT">Mayotte</option>
<option value="MX">Mexico</option>
<option value="FM">Micronesia, Federated States of</option>
<option value="MD">Moldova, Republic of</option>
<option value="MC">Monaco</option>
<option value="MN">Mongolia</option>
<option value="MS">Montserrat</option>
<option value="MA">Morocco</option>
<option value="MZ">Mozambique</option>
<option value="MM">Myanmar</option>
<option value="NA">Namibia</option>
<option value="NR">Nauru</option>
<option value="NP">Nepal</option>
<option value="NL">Netherlands</option>
<option value="AN">Netherlands Antilles</option>
<option value="NC">New Caledonia</option>
<option value="NZ">New Zealand</option>
<option value="NI">Nicaragua</option>
<option value="NE">Niger</option>
<option value="NG">Nigeria</option>
<option value="NU">Niue</option>
<option value="NF">Norfolk Island</option>
<option value="MP">Northern Mariana Islands</option>
<option value="NO">Norway</option>
<option value="OM">Oman</option>
<option value="PK">Pakistan</option>
<option value="PW">Palau</option>
<option value="PA">Panama</option>
<option value="PG">Papua New Guinea</option>
<option value="PY">Paraguay</option>
<option value="PE">Peru</option>
<option value="PH">Philippines</option>
<option value="PN">Pitcairn</option>
<option value="PL">Poland</option>
<option value="PT">Portugal</option>
<option value="PR">Puerto Rico</option>
<option value="QA">Qatar</option>
<option value="RE">Reunion</option>
<option value="RO">Romania</option>
<option value="RU">Russian Federation</option>
<option value="RW">Rwanda</option>
<option value="KN">Saint Kitts and Nevis</option>
<option value="LC">Saint LUCIA</option>
<option value="VC">Saint Vincent and the Grenadines</option>
<option value="WS">Samoa</option>
<option value="SM">San Marino</option>
<option value="ST">Sao Tome and Principe</option>
<option value="SA">Saudi Arabia</option>
<option value="SN">Senegal</option>
<option value="SC">Seychelles</option>
<option value="SL">Sierra Leone</option>
<option value="SG">Singapore</option>
<option value="SK">Slovakia (Slovak Republic)</option>
<option value="SI">Slovenia</option>
<option value="SB">Solomon Islands</option>
<option value="SO">Somalia</option>
<option value="ZA">South Africa</option>
<option value="GS">South Georgia and the South Sandwich
    Islands
</option>
<option value="ES">Spain</option>
<option value="LK">Sri Lanka</option>
<option value="SH">St. Helena</option>
<option value="PM">St. Pierre and Miquelon</option>
<option value="SD">Sudan</option>
<option value="SR">Suriname</option>
<option value="SJ">Svalbard and Jan Mayen Islands</option>
<option value="SZ">Swaziland</option>
<option value="SE">Sweden</option>
<option value="CH">Switzerland</option>
<option value="SY">Syrian Arab Republic</option>
<option value="TW">中國台灣</option>
<option value="TJ">Tajikistan</option>
<option value="TZ">Tanzania, United Republic of</option>
<option value="TH">Thailand</option>
<option value="TG">Togo</option>
<option value="TK">Tokelau</option>
<option value="TO">Tonga</option>
<option value="TT">Trinidad and Tobago</option>
<option value="TN">Tunisia</option>
<option value="TR">Turkey</option>
<option value="TM">Turkmenistan</option>
<option value="TC">Turks and Caicos Islands</option>
<option value="TV">Tuvalu</option>
<option value="UG">Uganda</option>
<option value="UA">Ukraine</option>
<option value="AE">United Arab Emirates</option>
<option value="GB">United Kingdom</option>
<option value="US">United States</option>
<option value="UM">United States Minor Outlying Islands</option>
<option value="UY">Uruguay</option>
<option value="UZ">Uzbekistan</option>
<option value="VU">Vanuatu</option>
<option value="VE">Venezuela</option>
<option value="VN">Viet Nam</option>
<option value="VG">Virgin Islands (British)</option>
<option value="VI">Virgin Islands (U.S.)</option>
<option value="WF">Wallis and Futuna Islands</option>
<option value="EH">Western Sahara</option>
<option value="YE">Yemen</option>
<option value="ZM">Zambia</option>
<option value="ZW">Zimbabwe</option>
</select>
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
    <button type="button"  id="register-submit-btn"
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
