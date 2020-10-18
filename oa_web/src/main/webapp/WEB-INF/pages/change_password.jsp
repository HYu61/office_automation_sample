<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="top.jsp"/>

<section id="content" class="table-layout animated fadeIn">
    <div class="tray tray-center">
        <div class="content-header">
            <h2> Rest Password </h2>
            <p class="lead"></p>
        </div>
        <div class="admin-form theme-primary mw1000 center-block" style="padding-bottom: 175px;">
            <div class="panel heading-border">
                <form method="post" action="changePassword" id="admin-form">
                    <div class="panel-body bg-light">
                        <div class="section-divider mt20 mb40">
                            <span> Basic Info </span>
                            <p style="color: red">${requestScope.errMsg}</p>

                        </div>
                        <div class="section row">
                            <div class="col-md-6">
                                <label for="oldPass" class="field prepend-icon">
                                    <input type="password" name="oldPass" id="oldPass" class="gui-input" placeholder="old password...">
                                    <label for="oldPass" class="field-icon">
                                        <i class="fa fa-lock"></i>
                                    </label>
                                </label>
                            </div>
                        </div>
                        <div class="section row">
                            <div class="col-md-6">
                                <label for="newPass" class="field prepend-icon">
                                    <input type="password" name="newPass" id="newPass" class="gui-input" placeholder="New Password...">
                                    <label for="newPass" class="field-icon">
                                        <i class="fa fa-lock"></i>
                                    </label>
                                </label>
                            </div>
                            <div class="col-md-6">
                                <label for="reNewPass" class="field prepend-icon">
                                    <input type="password" name="reNewPass" id="reNewPass" class="gui-input" placeholder="repeat the password...">
                                    <label for="reNewPass" class="field-icon">
                                        <i class="fa fa-lock"></i>
                                    </label>
                                </label>
                            </div>
                        </div>
                        <div class="panel-footer text-right">
                            <button type="submit" class="button"> Reset </button>
                            <button type="button" class="button" onclick="javascript:window.history.go(-1);"> Cancel </button>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</section>

<jsp:include page="bottom.jsp"/>