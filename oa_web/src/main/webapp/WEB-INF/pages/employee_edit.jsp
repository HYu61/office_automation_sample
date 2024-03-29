<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="top.jsp"/>
<section id="content" class="table-layout animated fadeIn">
    <div class="tray tray-center">
        <div class="content-header">
            <h2> Edit the Information of the Employee </h2>
            <p style="color: red">${requestScope.errMsg}</p>
            <p class="lead"></p>
        </div>
        <div class="admin-form theme-primary mw1000 center-block" style="padding-bottom: 175px;">
            <div class="panel heading-border">
                <%--@elvariable id="employee" type=""--%>
                <form:form action="/emp/edit" modelAttribute="employee" id="admin-form" name="addForm" onsubmit="return validateEmpForm()">
                    <form:hidden path="password"/>
                    <div class="panel-body bg-light">
                        <div class="section-divider mt20 mb40">
                            <span> Information </span>
                        </div>
                        <div class="section row">
                            <div class="col-md-6">
                                <label for="sn" class="field prepend-icon">
                                    <form:input path="sn" cssClass="gui-input" placeholder="SN..." readonly="true"/>
                                    <label for="sn" class="field-icon">
                                        <i class="fa fa-user"></i>
                                    </label>
                                </label>
                            </div>
                            <div class="col-md-6">
                                <label for="name" class="field prepend-icon">
                                    <form:input path="name" class="gui-input" placeholder="Name..."/>
                                    <label for="name" class="field-icon">
                                        <i class="fa fa-user"></i>
                                    </label>
                                </label>
                            </div>
                        </div>
                        <div class="section row">
                            <div class="col-md-6">
                                <label for="caSin" class="field prepend-icon">
                                    <form:input path="caSin" class="gui-input" placeholder="SIN..."/>
                                    <label for="name" class="field-icon">
                                        <i class="fa fa-user"></i>
                                    </label>
                                </label>
                            </div>
                        </div>
                        <div class="section row">
                            <div class="col-md-6">
                                <label for="deptId" class="field select">
                                    <form:select path="deptId" items="${deptList}" itemLabel="name" itemValue="id"
                                                 cssClass="gui-input" placeholder="Dept..."/>
                                    <i class="arrow double"></i>
                                </label>
                            </div>
                            <div class="col-md-6">
                                <label for="position" class="field select">
                                    <form:select path="position" items="${positionList}" itemLabel="position" cssClass="gui-input" placeholder="Position..."/>
                                    <i class="arrow double"></i>
                                </label>
                            </div>
                        </div>
                        <div class="panel-footer text-right">
                            <button type="submit" class="button"> Save</button>
                            <button type="button" class="button" onclick="javascript:window.history.go(-1);"> Cancel
                            </button>
                        </div>
                    </div>
                </form:form>
            </div>
        </div>
    </div>
</section>

<jsp:include page="bottom.jsp"/>