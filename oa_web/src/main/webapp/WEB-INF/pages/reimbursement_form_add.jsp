<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<jsp:include page="top.jsp"/>

<section id="content" class="table-layout animated fadeIn">
    <div class="tray tray-center">
        <div class="content-header">
            <h2> Create the Reimbursement Form </h2>
            <p class="lead"></p>
        </div>
        <div class="admin-form theme-primary mw1000 center-block" style="padding-bottom: 175px;">
            <div class="panel heading-border">
                <form:form id="admin-form" name="addForm" action="/form/add" modelAttribute="reimbursementForm" onsubmit="return validateReimForm()">
                    <div class="panel-body bg-light">
                        <div class="section-divider mt20 mb40">
                            <span> Basic Info </span>
                        </div>
                        <div class="section">
                            <label for="businessPurpose" class="field prepend-icon">
                                <form:input path="businessPurpose" cssClass="gui-input" placeholder="Business Purpose..."/>
                                <label for="businessPurpose" class="field-icon">
                                    <i class="fa fa-lock"></i>
                                </label>
                            </label>
                        </div>
                        <div class="section-divider mt20 mb40">
                            <span> Expense detail </span>
                        </div>
                        <div class="section row" id="reimbursementFormDetailList">
                            <div>
                                <div class="col-md-3">
                                    <label for="reimbursementFormDetailList[0].cateOfExpense" class="field prepend-icon">
                                        <form:select path="reimbursementFormDetailList[0].cateOfExpense" cssClass="gui-input" placeholder="cate of expense..." items="${expenseItemList}" itemLabel="cate"/>
                                    </label>
                                </div>
                                <div class="col-md-3">
                                    <label for="reimbursementFormDetailList[0].amount" class="field prepend-icon">
                                        <form:input path="reimbursementFormDetailList[0].amount" cssClass="gui-input money" placeholder="Cost..."/>
                                        <label for="reimbursementFormDetailList[0].amount" class="field-icon">
                                            <i class="fa fa-lock"></i>
                                        </label>
                                    </label>
                                </div>
                                <div class="col-md-5">
                                    <label for="reimbursementFormDetailList[0].description" class="field prepend-icon">
                                        <form:input path="reimbursementFormDetailList[0].description" cssClass="gui-input" placeholder="descroption..." />
                                        <label for="reimbursementFormDetailList[0].description" class="field-icon">
                                            <i class="fa fa-lock"></i>
                                        </label>
                                    </label>
                                </div>
                                <div class="col-md-1" style="text-align:right;">
                                    <button type="button" class="button"> X </button>
                                </div>
                            </div>
                        </div>
                        <div class="section row">
                            <div class="col-md-3">
                                <label for="totalMoney" class="field prepend-icon">
                                    <form:input id="totalMoney" path="totalAmount" cssClass="gui-input" placeholder="Total Cost..." readonly="true"/>
                                    <label for="totalMoney" class="field-icon">
                                        <i class="fa fa-user"></i>
                                    </label>
                                </label>
                            </div>
                            <div class="section" style="text-align:right;">
                                <div class="col-md-9">
                                    <button type="button" class="button" id="addItemButton"> + </button>
                                </div>
                            </div>
                        </div>
                        <div class="panel-footer text-right">
                            <button type="submit" class="button"> Create </button>
                            <button type="button" class="button" onclick="javascript:window.history.go(-1);"> Cancel </button>
                        </div>
                    </div>
                </form:form>
            </div>
        </div>
    </div>
</section>


<jsp:include page="bottom.jsp"/>