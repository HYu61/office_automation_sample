<%@ page contentType="text/html;charset=UTF-8" language="java" %>

</section>
</div>
<style>
    /* demo page styles */
    body { min-height: 2300px; }

    .content-header b,
    .admin-form .panel.heading-border:before,
    .admin-form .panel .heading-border:before {
        transition: all 0.7s ease;
    }
    /* responsive demo styles */
    @media (max-width: 800px) {
        .admin-form .panel-body { padding: 18px 12px; }
    }
</style>

<style>
    .ui-datepicker select.ui-datepicker-month,
    .ui-datepicker select.ui-datepicker-year {
        width: 48%;
        margin-top: 0;
        margin-bottom: 0;

        line-height: 25px;
        text-indent: 3px;

        color: #888;
        border-color: #DDD;
        background-color: #FDFDFD;

        -webkit-appearance: none; /*Optionally disable dropdown arrow*/
    }
</style>
<script src="/vendor/jquery/jquery-1.11.1.min.js"></script>
<script src="/vendor/jquery/jquery_ui/jquery-ui.min.js"></script>
<script src="/assets/admin-tools/admin-forms/js/jquery.validate.min.js"></script>
<script src="/assets/admin-tools/admin-forms/js/additional-methods.min.js"></script>
<script src="/assets/admin-tools/admin-forms/js/jquery-ui-datepicker.min.js"></script>
<script src="/assets/js/utility/utility.js"></script>
<script src="/assets/js/demo/demo.js"></script>
<script src="/assets/js/main.js"></script>
<script type="text/javascript" src="/js/pages.js"></script>

//
<script type="text/javascript" src="/js/reimbursementFormDetailList.js"></script>
<script language="JavaScript">

    //Only the HR can access the dept and employee CRUD panel
    $(function () {
        if(!"${sessionScope.employee.dept.name}".includes("HR")){
            document.getElementById("HR").style.visibility = 'hidden'
        }
    })

    /***
     * Get all value of the selected elements
     * @returns {string} all value of the selected elements
     */
    function getSelect() {
        var id = document.getElementsByName('multi');
        var idList = new Array();
        for(let i = 0; i < id.length; i++){
            if(id[i].checked)
                idList.push(id[i].value);
        }
        if(idList.length>0){
            return idList.toString();
        }
    }

    function validateReimForm() {

        const regex = /^\d+(?:\.?\d{0,2})$/;

        if (document.getElementById("businessPurpose").value == "") {
            alert("Business Purpose must be filled out");
            return false;
        }
        if(!regex.test(document.getElementById("totalMoney").value)) {
            alert('Please input the correct format for cost!');
            return  false
        }
    }

    function validateDeptForm() {
        const regex = /^1\d{3}$/;
        if(!regex.test(document.getElementById("id").value)){
            alert("Id must be 4 digit and begin with 1")
            return  false;
        }
        if (document.getElementById("name").value == "") {
            alert("Name must be filled out");
            return false;
        }
        if (document.getElementById("address").value == "") {
            alert("Address must be filled out");
            return false;
        }
    }

    function validateEmpForm() {
        const snRegex = /^((DM)|(GM)|(SF)|(AUD)|(GM_ASST))\d{4}$/;
        const caSinRegex = /^9\d{8}$/;
        if(!snRegex.test(document.getElementById("sn").value)){
            alert("sn must be 4 digit and begin with the position")
            return  false;
        }
        if (document.getElementById("name").value == "") {
            alert("Name must be filled out");
            return false;
        }
        if (!caSinRegex.test(document.getElementById("caSin").value)) {
            alert("caSin must be 9 digits and start with 9");
            return false;
        }
    }
</script>
</body>
</html>


