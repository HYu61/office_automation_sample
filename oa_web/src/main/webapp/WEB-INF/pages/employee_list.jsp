<%@ page import="pers.hyu.oa.global.infoenum.PositionEnum" %>
<%@ page import="pers.hyu.oa.entity.Employee" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<jsp:include page="top.jsp"/>

<section id="content" class="table-layout animated fadeIn">
    <div class="tray tray-center">
        <div class="content-header">
            <h2> Employee List </h2>
            <p style="color: red">${requestScope.errMsg}</p>
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
                                       onclick="javascript:window.location.href='/emp/displayAll';"></i>
                                </button>
                                <button type="button" class="btn btn-default light">
                                    <i class="fa fa-trash"
                                       onclick="javascript:window.location.href='/emp/removeMulti?sns='+ getSelect();"></i>
                                </button>
                                <button type="button" class="btn btn-default light">
                                    <i class="fa fa-plus" onclick="javascript:window.location.href='/emp/toAdd';"></i>
                                </button>
                            </div>
                        </div>
                        <div class="col-xs-12 col-md-9 text-right">
                            <div class="btn-group">
                                <button type="button" class="btn btn-default light">
                                    <%--                                    --%>
                                    <i class="fa fa-chevron-left"
                                       onclick="javascript:window.location.href='/emp/displayAll?pageNum=${pageInfo.pageNum -1}';"></i>
                                </button>
                                <button class="btn btn-default light">
                                    <span>${pageInfo.pageNum}/${pageInfo.pages}</span>
                                </button>
                                <button type="button" class="btn btn-default light">
                                    <i class="fa fa-chevron-right"
                                       onclick="javascript:window.location.href='/emp/displayAll?pageNum=${pageInfo.pageNum +1}';"></i>
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
                            <th class="hidden-xs">No</th>
                            <th class="hidden-xs">SN</th>
                            <th class="hidden-xs">Name</th>
                            <th class="hidden-xs">SIN</th>
                            <th class="hidden-xs">Dept</th>
                            <th class="hidden-xs">Position</th>
                            <th>Operation</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${pageInfo.list}" var="emp" varStatus="idx">
                        <tr class="message-unread">
                            <td class="hidden-xs">
                                <label class="option block mn">
                                    <input type="checkbox" name="multi" value="${emp.sn}">
                                    <span class="checkbox mn"></span>
                                </label>
                            </td>
                            <td>${idx.index+1}</td>
                            <td>${emp.sn}</td>
                            <td>${emp.name}</td>
                            <td>${emp.caSin}</td>
                            <td class="text-center fw600">${emp.dept.name}</td>
                            <td class="hidden-xs">
                                <span class="badge badge-warning mr10 fs11">${emp.position}</span>
                            </td>
                            <td>
                                <a href="/emp/toEdit?sn=${emp.sn}">Edit</a>
                                <a href="/emp/remove?sn=${emp.sn}">Remove</a>
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