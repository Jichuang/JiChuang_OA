<%@ page language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!-- BEGIN STYLE CUSTOMIZER -->
<div class="theme-panel hidden-xs hidden-sm">
    <div class="toggler"></div>
    <div class="toggler-close"></div>
    <div class="theme-options">
        <div class="theme-option theme-colors clearfix">
            <span>主题颜色</span>
            <ul>
                <li class="color-black current color-default" data-style="default"></li>
                <li class="color-blue" data-style="blue"></li>
                <li class="color-brown" data-style="brown"></li>
                <li class="color-purple" data-style="purple"></li>
                <li class="color-grey" data-style="grey"></li>
                <li class="color-white color-light" data-style="light"></li>
            </ul>
        </div>
        <div class="theme-option">
            <span>布局</span> <select
                class="layout-option form-control input-small">
            <option value="fluid" selected="selected">平铺</option>
            <option value="boxed">箱型</option>
        </select>
        </div>
        <div class="theme-option">
            <span>顶部菜单栏</span> <select
                class="header-option form-control input-small">
            <option value="fixed" selected="selected">修正置顶</option>
            <option value="default">默认置顶</option>
        </select>
        </div>
        <div class="theme-option">
            <span>侧边栏</span> <select
                class="sidebar-option form-control input-small">
            <option value="fixed">修正下拉框</option>
            <option value="default" selected="selected">默认跟随页面</option>
        </select>
        </div>
        <div class="theme-option">
            <span>底部栏目</span> <select
                class="footer-option form-control input-small">
            <option value="fixed" selected="selected">修正在菜单下方</option>
            <option value="default">默认设置</option>
        </select>
        </div>
    </div>
</div>
<!-- END BEGIN STYLE CUSTOMIZER -->