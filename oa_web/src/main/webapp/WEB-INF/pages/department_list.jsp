<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="/WEB-INF/pages/top.jsp"/>

<section id="content" class="table-layout animated fadeIn">
    <div class="tray tray-center">
        <div class="content-header">
            <h2> Department List </h2>
            <p style="color: red">${errMsg}</p>
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
                                       onclick="javascript:window.location.href='/dept/displayAll';"></i>
                                </button>
                                <button type="button" class="btn btn-default light">
                                    <i class="fa fa-trash"
                                       onclick="javascript:window.location.href='/dept/removeMulti?ids='+ getSelect();"></i>
                                </button>
                                <button type="button" class="btn btn-default light">
                                    <i class="fa fa-plus"

                                       onclick="javascript:window.location.href='/dept/toAdd';"></i>
                                </button>
                            </div>
                        </div>
                        <div class="col-xs-12 col-md-9 text-right">

                            <div class="btn-group">
                                <button type="button" class="btn btn-default light">
                                    <%--                                    --%>
                                    <i class="fa fa-chevron-left"
                                       onclick="javascript:window.location.href='/dept/displayAll?pageNum=${pageInfo.pageNum -1}';"></i>
                                </button>
                                <button class="btn btn-default light">
                                    <span>${pageInfo.pageNum}/${pageInfo.pages}</span>
                                </button>
                                <button type="button" class="btn btn-default light">
                                    <i class="fa fa-chevron-right"
                                       onclick="javascript:window.location.href='/dept/displayAll?pageNum=${pageInfo.pageNum +1}';"></i>
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
                            <th class="hidden-xs">Department ID</th>
                            <th class="hidden-xs">Department Name</th>
                            <th class="hidden-xs">Address</th>
                            <th>Operation</th>
                        </tr>
                        </thead>
                        <tbody>

                        <c:forEach var="dept" items="${requestScope.pageInfo.list}" varStatus="idx">
                            <tr class="message-unread">


                                <td class="hidden-xs">
                                    <label class="option block mn">
                                        <input type="checkbox" name="multi" value="${dept.id}">
                                        <span class="checkbox mn"></span>
                                    </label>
                                </td>
                                <td>${idx.index + 1}</td>
                                <td>${dept.id}</td>
                                <td>${dept.name}</td>
                                <td>${dept.address}</td>
                                <td>

                                    <a href="/dept/toEdit?id=${dept.id}">Edit</a>
                                    <a href="/dept/remove?id=${dept.id}">Remove</a>
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