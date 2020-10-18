<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<jsp:include page="top.jsp"/>

<section id="content" class="table-layout animated fadeIn">
    <div class="tray tray-center">
        <div class="content-header">
            <h2> Update Reimbursement Form </h2>
            <p class="lead"></p>
        </div>
        <div class="admin-form theme-primary mw1000 center-block" style="padding-bottom: 175px;">
            <div class="panel heading-border">
                <form:form id="admin-form" name="addForm" action="/form/editForm" modelAttribute="reimbursementForm">
                    <form:hidden path="id"/>
                    <div class="panel-body bg-light">
                        <div class="section-divider mt20 mb40">
                            <span> Basic Info </span>
                        </div>
                        <div class="section">
                            <label for="businessPurpose" class="field prepend-icon">
                                <form:input path="businessPurpose" cssClass="gui-input" placeholder="Businedd Purpose..."/>
                                <label for="businessPurpose" class="field-icon">
                                    <i class="fa fa-lock"></i>
                                </label>
                            </label>
                        </div>
                        <div class="section-divider mt20 mb40">
                            <span> Expense Detail </span>
                        </div>
                        <div class="section row" id="reimbursementFormDetailList">
                            <c:forEach items="${reimbursementForm.reimbursementFormDetailList}" varStatus="idx">
                            <div>
                                <div class="col-md-3">
                                    <label for="reimbursementFormDetailList[${idx.index}].cateOfExpense" class="field prepend-icon">
                                        <form:hidden path="reimbursementFormDetailList[${idx.index}].id"/>
                                        <form:hidden path="reimbursementFormDetailList[${idx.index}].reimbursementFormId"/>
                                        <form:select path="reimbursementFormDetailList[${idx.index}].cateOfExpense" cssClass="gui-input" placeholder="Cate of Expense..." items="${expenseItemList}" itemLabel="cate"/>
                                    </label>
                                </div>
                                <div class="col-md-3">
                                    <label for="reimbursementFormDetailList[${idx.index}].amount" class="field prepend-icon">
                                        <form:input path="reimbursementFormDetailList[${idx.index}].amount" cssClass="gui-input money" placeholder="Cost..."/>
                                        <label for="reimbursementFormDetailList[${idx.index}].amount" class="field-icon">
                                            <i class="fa fa-lock"></i>
                                        </label>
                                    </label>
                                </div>
                                <div class="col-md-5">
                                    <label for="reimbursementFormDetailList[${idx.index}].description" class="field prepend-icon">
                                        <form:input path="reimbursementFormDetailList[${idx.index}].description" cssClass="gui-input" placeholder="Description..." />
                                        <label for="reimbursementFormDetailList[${idx.index}].description" class="field-icon">
                                            <i class="fa fa-lock"></i>
                                        </label>
                                    </label>
                                </div>
                                <div class="col-md-1" style="text-align:right;">
                                    <button type="button" class="button" > X </button>
                                </div>
                            </div>
                            </c:forEach>
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
                            <button type="submit" class="button"> Save </button>
                            <button type="button" class="button" onclick="javascript:window.history.go(-1);"> Back </button>
                        </div>
                    </div>
                </form:form>
            </div>
        </div>
    </div>
</section>


<jsp:include page="bottom.jsp"/>