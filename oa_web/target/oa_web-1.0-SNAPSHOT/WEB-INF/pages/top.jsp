<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

<head>
    <!-- Meta, title, CSS, favicons, etc. -->
    <meta charset="utf-8">

    <title> OA Sample--Welcome to use the Office Automation System </title>

    <link rel="stylesheet" type="text/css" href="/assets/skin/default_skin/css/theme.css">
    <link rel="stylesheet" type="text/css" href="/assets/admin-tools/admin-forms/css/admin-forms.css">
    <link rel="shortcut icon" href="/assets/img/favicon.ico">
</head>

<body class="admin-validation-page" data-spy="scroll" data-target="#nav-spy" data-offset="200">
<div id="main">
    <header class="navbar navbar-fixed-top navbar-shadow">
        <div class="navbar-branding">
            <a class="navbar-brand" href="dashboard.html">
                <b>HY</b>OA Sample
            </a>
            <span id="toggle_sidemenu_l" class="ad ad-lines"></span>
        </div>
        <ul class="nav navbar-nav navbar-right">
            <li class="dropdown menu-merge">
                <a href="#" class="dropdown-toggle fw600 p15" data-toggle="dropdown">
                    <img src="/assets/img/avatars/5.jpg" alt="avatar" class="mw30 br64">
                    <span class="hidden-xs pl15"> "${sessionScope.employee.name}" </span>
                    <span class="caret caret-tp hidden-xs"></span>
                </a>
                <ul class="dropdown-menu list-group dropdown-persist w250" role="menu">
                    <li class="list-group-item">
                        <a href="/personalInfo" class="animated animated-short fadeInUp">
                            <span class="fa fa-user"></span> Profile
                            <span class="label label-warning"></span>
                        </a>
                    </li>
                    <li class="list-group-item">
                        <a href="/toChangePassword" class="animated animated-short fadeInUp">
                            <span class="fa fa-gear"></span> Set Password </a>
                    </li>
                    <li class="dropdown-footer">
                        <a href="/logout" class="">
                            <span class="fa fa-power-off pr5"></span> Logout </a>
                    </li>
                </ul>
            </li>
        </ul>
    </header>
    <aside id="sidebar_left" class="nano nano-light affix">
        <div class="sidebar-left-content nano-content">
            <header class="sidebar-header">
                <div class="sidebar-widget author-widget">
                    <div class="media">
                        <a class="media-left" href="#">
                            <img src="assets/img/avatars/3.jpg" class="img-responsive">
                        </a>
                        <div class="media-body">
                            <div class="media-author">"${sessionScope.employee.name} --- ${sessionScope.employee.position}"</div>
                            <div class="media-links">
                                <a href="/logout">Logout</a>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="sidebar-widget search-widget hidden">
                    <div class="input-group">
                        <span class="input-group-addon">
                            <i class="fa fa-search"></i>
                        </span>
                        <input type="text" id="sidebar-search" class="form-control" placeholder="Search...">
                    </div>
                </div>
            </header>
            <ul class="nav sidebar-menu">
                <li class="sidebar-label pt20">Reimbursement Form Management</li>
                <li>
                    <a href="/form/displayPendingForms">
                        <span class="glyphicon glyphicon-book"></span>
                        <span class="sidebar-title">Pending Forms</span>
                        <span class="sidebar-title-tray">
                <span class="label label-xs bg-primary">New</span>
              </span>
                    </a>
                </li>
                <li class="active">
                    <a href="/form/displayPersonalForms">
                        <span class="glyphicon glyphicon-home"></span>
                        <span class="sidebar-title">Personal Forms</span>
                    </a>
                </li>
                <li>
                    <a href="/form/toAdd">
                        <span class="fa fa-calendar"></span>
                        <span class="sidebar-title">Create the Form</span>
                    </a>
                </li>
                <div id="HR">
                <li class="sidebar-label pt15">Dept & EE Information</li>
                <li>
                    <a class="accordion-toggle" href="#">
                        <span class="glyphicon glyphicon-check"></span>
                        <span class="sidebar-title">Employees Management</span>
                        <span class="caret"></span>
                    </a>
                    <ul class="nav sub-nav">
                        <li>
                            <a href="/emp/displayAll">
                                <span class="glyphicon glyphicon-calendar"></span> Employee List </a>
                        </li>
                        <li class="active">
                            <a href="/emp/toAdd">
                                <span class="glyphicon glyphicon-check"></span> Add the Employee </a>
                        </li>
                    </ul>
                </li>
                <li>
                    <a class="accordion-toggle" href="#">
                        <span class="fa fa-columns"></span>
                        <span class="sidebar-title">Department Management</span>
                        <span class="caret"></span>
                    </a>
                    <ul class="nav sub-nav">
                        <li>
                            <a href="/dept/displayAll">
                                <span class="glyphicon glyphicon-calendar"></span> Department List </a>
                        </li>
                        <li class="active">
                            <a href="/dept/toAdd">
                                <span class="glyphicon glyphicon-check"></span> Add the department </a>
                        </li>
                    </ul>
                </li>
                </div>
            </ul>
            <div class="sidebar-toggle-mini">
                <a href="#">
                    <span class="fa fa-sign-out"></span>
                </a>
            </div>
        </div>
    </aside>
    <section id="content_wrapper">