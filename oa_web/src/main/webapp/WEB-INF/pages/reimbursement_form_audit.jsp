<%@ taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="pers.hyu.oa.global.infoenum.PositionEnum" %>
<%@ page import="pers.hyu.oa.global.infoenum.ProcessTypeEnum" %>
<jsp:include page="top.jsp"/>
<section id="content" class="table-layout animated fadeIn">
    <div class="tray tray-center">
        <div class="content-header">
            <h2> Audit Reimbursement Form </h2>
            <p class="lead"></p>
        </div>
        <div class="admin-form theme-primary mw1000 center-block" style="padding-bottom: 175px;">
            <div class="panel heading-border">
                <div class="panel-body bg-light">
                    <div class="section-divider mt20 mb40">
                        <span> Basic Info </span>
                    </div>
                    <div class="section row">
                        <div class="col-md-2">Business Purpose</div>
                        <div class="col-md-6">${form.businessPurpose}</div>
                    </div>
                    <div class="section row">
                        <div class="col-md-2">Applicant</div>
                        <div class="col-md-4">${form.applicant.name}</div>
                        <div class="col-md-2">Created Time</div>
                        <div class="col-md-4"><spring:eval expression="form.createTime"/></div>
                    </div>
                    <div class="section row">
                        <div class="col-md-2">Approver</div>
                        <div class="col-md-4">${form.approver.name}</div>
                        <div class="col-md-2">Status</div>
                        <div class="col-md-4">${form.status}</div>
                    </div>
                    <div class="section-divider mt20 mb40">
                        <span> Details of Expense </span>
                    </div>
                    <div class="section row">
                        <C:forEach items="${form.reimbursementFormDetailList}" var="item">
                        <div class="col-md-3">${item.cateOfExpense}</div>
                        <div class="col-md-3">${item.amount}</div>
                        <div class="col-md-5">${item.description}</div>
                        </C:forEach>
                    </div>
                    <div class="section row">
                        <div class="col-md-2">Total Cost</div>
                        <div class="col-md-6">${form.totalAmount}</div>
                    </div>
                    <div class="section-divider mt20 mb40">
                        <span> Process Record </span>
                    </div>
                    <div class="section row">
                    <c:forEach items="${recordList}" var="record">
                        <div class="col-md-1">${record.approver.name}</div>
                        <div class="col-md-3"><spring:eval expression="record.handleDate"/></div>
                        <div class="col-md-1">${record.processType}</div>
                        <div class="col-md-2">${record.result}</div>
                        <div class="col-md-5">Remark：${record.remark}</div>
                    </c:forEach>
                    </div>
                    <form:form id="admin-form" name="addForm" action="/form/audit" modelAttribute="record">
                        <form:hidden path="reimbursementFormId" />
                        <div class="panel-body bg-light">
                            <div class="section">
                                <label for="remark" class="field prepend-icon">
                                    <form:input path="remark" cssClass="gui-input" placeholder="Remark..."/>
                                    <label for="remark" class="field-icon">
                                        <i class="fa fa-lock"></i>
                                    </label>
                                </label>
                            </div>
                            <div class="panel-footer text-right">

                                <c:if test="${sessionScope.employee.position==PositionEnum.DM|| sessionScope.employee.position==PositionEnum.GM}">
                                <button type="submit" class="button" name="processType" value="${ProcessTypeEnum.PASS}" >${ProcessTypeEnum.PASS}</button>
                                <button type="submit" class="button" name="processType" value="${ProcessTypeEnum.RETURN}" >${ProcessTypeEnum.RETURN}</button>
                                <button type="submit" class="button" name="processType" value="${ProcessTypeEnum.REJECT}" >${ProcessTypeEnum.REJECT}</button>
                                </c:if>
                                <c:if test="${sessionScope.employee.position==PositionEnum.AUD}">
                                <button type="submit" class="button" name="processType" value="${ProcessTypeEnum.PAY}" >${ProcessTypeEnum.PAY}</button>
                                </c:if>
                                <button type="button" class="button" onclick="javascript:window.history.go(-1);"> Back </button>
                            </div>
                        </div>
                    </form:form>

                </div>
            </div>
        </div>
    </div>
</section>


<jsp:include page="bottom.jsp"/>
