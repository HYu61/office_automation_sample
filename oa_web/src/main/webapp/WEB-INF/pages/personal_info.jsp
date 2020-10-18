<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="top.jsp"/>

<section id="content" class="table-layout animated fadeIn">
    <div class="tray tray-center">
        <div class="content-header">
            <h2> Personal Information </h2>
            <p class="lead"></p>
        </div>
        <div class="admin-form theme-primary mw1000 center-block" style="padding-bottom: 175px;">
            <div class="panel heading-border">
                <div class="panel-body bg-light">
                    <div class="section-divider mt20 mb40">
                        <span> Basic Info </span>
                    </div>
                    <div class="section row">
                        <div class="col-md-2">SN</div>
                        <div class="col-md-4">${sessionScope.employee.sn}</div>
                        <div class="col-md-2">Name</div>
                        <div class="col-md-4">${sessionScope.employee.name}</div>
                    </div>
                    <div class="section row">
                        <div class="col-md-2">Dept</div>
                        <div class="col-md-4">${sessionScope.employee.dept.name}</div>
                        <div class="col-md-2">Position</div>
                        <div class="col-md-4">${sessionScope.employee.position}</div>
                    </div>
                    <div class="section row">
                        <div class="col-md-2">SIN</div>
                        <div class="col-md-4">${sessionScope.employee.caSin}</div>
                    </div>
                    <div class="panel-footer text-right">
                        <button type="button" class="button" onclick="javascript:window.history.go(-1);"> Back </button>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>

<jsp:include page="bottom.jsp"/>