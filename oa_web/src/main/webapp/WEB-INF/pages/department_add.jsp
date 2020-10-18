
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="top.jsp"/>
<section id="content" class="table-layout animated fadeIn">
    <div class="tray tray-center">
        <div class="content-header">
            <h2> Add Department </h2>
            <p class="lead"></p>
        </div>

        <div class="admin-form theme-primary mw1000 center-block" style="padding-bottom: 175px;">
            <div class="panel heading-border">
                <form id="admin-form" name="addForm" action="/dept/add" method="post" onsubmit="return validateDeptForm()">
                    <div class="panel-body bg-light">
                        <div class="section-divider mt20 mb40">
                            <span> Department Information </span>
                            <p style="color: red">${requestScope.errMsg}</p>
                        </div>
                        <div class="section row">
                            <div class="col-md-6">
                                <label for="id" class="field prepend-icon">
                                    <input id="id" name="id" class="gui-input" placeholder="Dept Id..." type="text" value=""/>
                                    <label for="id" class="field-icon">
                                        <i class="fa fa-user"></i>
                                    </label>
                                </label>
                            </div>
                            <div class="col-md-6">
                                <label for="name" class="field prepend-icon">
                                    <input id="name" name="name" class="gui-input" placeholder="Dept Name..." type="text" value=""/>
                                    <label for="name" class="field-icon">
                                        <i class="fa fa-user"></i>
                                    </label>
                                </label>
                            </div>
                        </div>
                        <div class="section">
                            <label for="address" class="field prepend-icon">
                                <input id="address" name="address" class="gui-input" placeholder="Dept Address..." type="text" value=""/>
                                <label for="address" class="field-icon">
                                    <i class="fa fa-lock"></i>
                                </label>
                            </label>
                        </div>
                        <div class="panel-footer text-right">
                            <button type="submit" class="button"> Save </button>
                            <button type="button" class="button" onclick="javascript:window.history.go(-1);"> Cancel </button>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</section>

<jsp:include page="bottom.jsp"/>