<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page import="pers.hyu.oa.global.infoenum.StatusEnum" %>
<jsp:include page="top.jsp"/>
<section id="content" class="table-layout animated fadeIn">
    <div class="tray tray-center">
        <div class="content-header">
            <h2> Pending Form List </h2>
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
                                       onclick="javascript:window.location.href='/form/displayPendingForms';"></i>
                                </button>
                                <c:if test="${pendingFormList.pages > 0}">
                                    <button type="button" class="btn btn-default light">
                                        <i class="fa fa-trash"
                                           onclick="javascript:window.location.href='/form/removeMulti?formIds='+ getSelect();"></i>
                                    </button>
                                </c:if>
                            </div>
                        </div>
                        <div class="col-xs-12 col-md-9 text-right">
                            <div class="btn-group">
                                <button type="button" class="btn btn-default light">
                                    <i class="fa fa-chevron-left"
                                       onclick="javascript:window.location.href='/form/displayPendingForms?pageNum=${pendingFormList.pageNum - 1}';"></i>
                                </button>
                                <c:if test="${pendingFormList.pages > 0}">
                                    <button type="button" class="btn btn-default light">
                                        <span>${pendingFormList.pageNum}/${pendingFormList.pages}</span>
                                    </button>
                                </c:if>
                                <button type="button" class="btn btn-default light">
                                    <i class="fa fa-chevron-right"
                                       onclick="javascript:window.location.href='/form/displayPendingForms?pageNum=${pendingFormList.pageNum + 1}';"></i>
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
                            <th class="text-center">Created Time</th>
                            <th>Operation</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${pendingFormList.list}" var="form" varStatus="idx">
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
                                <td>

                                    <c:if test="${form.status == StatusEnum.CREATED.status || form.status==StatusEnum.ROLLED_BACK.status}">
                                        <a href="/form/toEditForm?formId=${form.id}">Edit</a>
                                        <a href="/form/submit?formId=${form.id}">Submit</a>
                                    </c:if>
                                    <c:if test="${form.status == StatusEnum.SUBMITTED.status || form.status==StatusEnum.RECHECK.status}">
                                        <a href="/form/toAudit?formId=${form.id}">Audit</a>
                                    </c:if>
                                    <c:if test="${form.status == StatusEnum.APPROVED.status}">
                                        <a href="/form/toAudit?formId=${form.id}">Pay</a>
                                    </c:if>

                                    <a href="/form/showFormDetail?formId=${form.id}">Detail</a>

                                    <c:if test="${form.status == StatusEnum.CREATED.status}">
                                        <a href="/form/remove?formId=${form.id}">Remove</a>
                                    </c:if>
                                </td>
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
