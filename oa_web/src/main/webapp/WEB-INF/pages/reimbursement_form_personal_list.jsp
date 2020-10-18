<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="top.jsp"/>
<section id="content" class="table-layout animated fadeIn">
    <div class="tray tray-center">
        <div class="content-header">
            <h2> Personal Reimbursement Forms </h2>
            <p class="lead"></p>
        </div>
        <div class="admin-form theme-primary mw1000 center-block" style="padding-bottom: 175px;">
            <div class="panel  heading-border">
                <div class="panel-menu">
                    <div class="row">
                        <div class="hidden-xs hidden-sm col-md-3">
                            <div class="btn-group">
                                <button type="button" class="btn btn-default light">
                                    <i class="fa fa-refresh"
                                       onclick="javascript:window.location.href='/form/displayPersonalForms';"></i>
                                </button>

                                <button type="button" class="btn btn-default light">
                                    <i class="fa fa-plus" onclick="javascript:window.location.href='/form/toAdd';"></i>
                                </button>
                            </div>
                        </div>
                        <div class="col-xs-12 col-md-9 text-right">
                            <div class="btn-group">
                                <button type="button" class="btn btn-default light">
                                    <i class="fa fa-chevron-left"
                                       onclick="javascript:window.location.href='/form/displayPersonalForms?pageNum=${personalFormList.pageNum -1}';"></i>
                                </button>
                                <c:if test="${personalFormList.pages > 0}">
                                    <button type="button" class="btn btn-default light">
                                        <span>${personalFormList.pageNum}/${personalFormList.pages}</span>
                                    </button>
                                </c:if>
                                <button type="button" class="btn btn-default light">
                                    <i class="fa fa-chevron-right"
                                       onclick="javascript:window.location.href='/form/displayPersonalForms?pageNum=${personalFormList.pageNum +1}';"></i>
                                </button>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="panel-body pn">
                    <table id="message-table" class="table admin-form theme-warning tc-checkbox-1">
                        <thead>
                        <tr class="">
                            <th class="text-center hidden-xs">Select</th>
                            <th class="hidden-xs">No.</th>
                            <th class="hidden-xs">Business Purpose</th>
                            <th>Status</th>
                            <th class="hidden-xs">Applicant</th>
                            <th class="hidden-xs">Total Cost</th>
                            <th class="text-center">Create Time</th>
                            <th>Operation</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${personalFormList.list}" var="form" varStatus="idx">
                            <tr class="message-unread">
                                <td class="hidden-xs">
                                    <label class="option block mn">
                                        <input type="checkbox" name="multi" value="${form.id}">
                                        <span class="checkbox mn"></span>
                                    </label>
                                </td>
                                <td>${idx.index + 1}</td>
                                <td>${form.businessPurpose}</td>
                                <td class="hidden-xs">
                                    <span class="badge badge-warning mr10 fs11">${form.status}</span>
                                </td>
                                <td>${form.applicant.name}</td>
                                <td class="text-center fw600">${form.totalAmount}</td>
                                <td><spring:eval expression="form.createTime"/></td>
                                <td><a href="/form/showFormDetail?formId=${form.id}">Detail</a></td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>
</section>

<jsp:include page="bottom.jsp"/>
