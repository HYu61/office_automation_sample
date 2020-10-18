$(document).ready(function () {
    builderIndex();
    calculateMoney();
    setRemove();
	if ($("#reimbursementFormDetailList").children("div").size() == 1) {
		$("#reimbursementFormDetailList").find("button").attr("disabled", true);
	}
    $("#addItemButton").click(
        function () {
            $("#reimbursementFormDetailList").children("div").last().after($("#reimbursementFormDetailList").children("div").first().clone());
            setRemove();
            $("#reimbursementFormDetailList").find("button").attr("disabled", false);
            builderIndex();
            $(".money").change(
                function () {
                    calculateMoney();
                }
            );
            calculateMoney();
        }
    );
    $(".money").change(
        function () {
            calculateMoney();
        }
    );
});// JavaScript Document

function builderIndex() {
    $.each($("#reimbursementFormDetailList").children(), function (i, val) {
        $("#reimbursementFormDetailList").children("div").eq(i).children().eq(0).find("select").attr("name", "reimbursementFormDetailList[" + i + "].cateOfExpense");
        $("#reimbursementFormDetailList").children("div").eq(i).children().eq(1).find("input").attr("name", "reimbursementFormDetailList[" + i + "].amount");
        $("#reimbursementFormDetailList").children("div").eq(i).children().eq(2).find("input").attr("name", "reimbursementFormDetailList[" + i + "].description");

    });
}

function calculateMoney() {
    var totalMoney = 0;
    $.each($(".money"), function (i, val) {
        totalMoney += parseFloat($(".money").eq(i).val());
    });
    $("#totalMoney").attr("value", totalMoney);
}

function setRemove() {
    $("#reimbursementFormDetailList").children("div").find("button").click(
        function () {
            $(this).parent().parent().remove();
            if ($("#reimbursementFormDetailList").children("div").size() == 1) {
                $("#reimbursementFormDetailList").find("button").attr("disabled", true);
            }
            builderIndex();
            calculateMoney();
        }
    );

}