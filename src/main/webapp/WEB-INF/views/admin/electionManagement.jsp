<%--
  Created by IntelliJ IDEA.
  User: BOMI
  Date: 2019-05-16
  Time: 오전 11:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:url var="R" value="/" />
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <%--<script type="text/javascript" src="https://cdn.jsdelivr.net/jquery/latest/jquery.min.js"></script>--%>
    <%--<script type="text/javascript" src="https://cdn.jsdelivr.net/momentjs/latest/moment.min.js"></script>--%>
    <%--<script type="text/javascript" src="https://cdn.jsdelivr.net/npm/daterangepicker/daterangepicker.min.js"></script>--%>
    <%--<link rel="stylesheet" type="text/css" href="https://cdn.jsdelivr.net/npm/daterangepicker/daterangepicker.css" />--%>
        <%--<script type="text/javascript" src="/path/to/jquery.js"></script>--%>
        <%--<script type="text/javascript" src="/path/to/moment.js"></script>--%>
        <%--<script type="text/javascript" src="/path/to/bootstrap/js/transition.js"></script>--%>
        <%--<script type="text/javascript" src="/path/to/bootstrap/js/collapse.js"></script>--%>
        <%--<script type="text/javascript" src="/path/to/bootstrap/dist/bootstrap.min.js"></script>--%>
        <%--<script type="text/javascript" src="/path/to/bootstrap-datetimepicker.min.js"></script>--%>

    <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.24.0/locale/ko.js"></script>


        <!-- 합쳐지고 최소화된 최신 CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">

        <!-- 부가적인 테마 -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">

        <!-- 합쳐지고 최소화된 최신 자바스크립트 -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>

     <script src="http://code.jquery.com/jquery-1.10.2.js"></script>


    <link rel="stylesheet" type="text/css" href="${R}resources/bootstrap/css/datepicker3.css" />
    <script type="text/javascript" src="${R}resources/bootstrap/js/bootstrap-datepicker.js"></script>
    <script type="text/javascript" src="${R}resources/bootstrap/js/bootstrap-datepicker.kr.js"></script>

    <link rel="stylesheet" type="text/css" href="${R}assets/css/main.css" />
    <link rel="stylesheet" type="text/css" href="${R}resources/bootstrap/css/electionManagement.css"/>
    <title>Title</title>
</head>
<body>
<!-- Header -->
<%@include file="/WEB-INF/include/menu.jsp"%>

<!--<div class="container">-->

    <div class="date-management">
        <h2><input type="text" class="generation" name="general"/>회 총학생회 대표 선거</h2>
        <div class="variety"><span>후보자 등록 기간</span></div>
        <!--<input type="text" class="datetimes" name="generalDateTime" />-->
        <div class="container">
            <div class='col-md-5'>
                <div class="form-group">
                    <div class='input-group date start'>
                        <input type='text' class="form-control"/>
                        <span class="input-group-addon">
                    <span class="glyphicon glyphicon-calendar"></span>
                </span>
                    </div>
                </div>
            </div>
            <div class='col-md-5'>
                <div class="form-group">
                    <div class='input-group date end'>
                        <input type='text' class="form-control"/>
                        <span class="input-group-addon">
                    <span class="glyphicon glyphicon-calendar"></span>
                </span>
                    </div>
                </div>
            </div>
        </div>
        <div class="variety"><span>투표 기간</span></div>
       <!-- <input type="text" class="datetimes" name="generalDateTime" />-->
        <div class="container">
            <div class='col-md-5'>
                <div class="form-group">
                    <div class='input-group date start'>
                        <input type='text' class="form-control" />
                        <span class="input-group-addon">
                    <span class="glyphicon glyphicon-calendar"></span>
                </span>
                    </div>
                </div>
            </div>
            <div class='col-md-5'>
                <div class="form-group">
                    <div class='input-group date end'>
                        <input type='text' class="form-control" />
                        <span class="input-group-addon">
                    <span class="glyphicon glyphicon-calendar"></span>
                </span>
                    </div>
                </div>
            </div>
        </div>
        <button>save</button>
    </div>
    <hr/>
    <div class="date-management">
        <h2><input type="text" class="generation" name="college"/>회 학부 대표 선거</h2>
        <div class="variety"><span>후보자 등록 기간</span></div>
        <!--<input type="text" class="datetimes" name="generalDateTime" />-->
        <div class="container">
            <div class='col-md-5'>
                <div class="form-group">
                    <div class='input-group date start'>
                        <input type='text' class="form-control" />
                        <span class="input-group-addon">
                    <span class="glyphicon glyphicon-calendar"></span>
                </span>
                    </div>
                </div>
            </div>
            <div class='col-md-5'>
                <div class="form-group">
                    <div class='input-group date end'>
                        <input type='text' class="form-control" />
                        <span class="input-group-addon">
                    <span class="glyphicon glyphicon-calendar"></span>
                </span>
                    </div>
                </div>
            </div>
        </div>
        <div class="variety"><span>투표 기간</span></div>
        <!--<input type="text" class="datetimes" name="generalDateTime" />-->
        <div class="container">
            <div class='col-md-5'>
                <div class="form-group">
                    <div class='input-group date start'>
                        <input type='text' class="form-control" />
                        <span class="input-group-addon">
                    <span class="glyphicon glyphicon-calendar"></span>
                </span>
                    </div>
                </div>
            </div>
            <div class='col-md-5'>
                <div class="form-group">
                    <div class='input-group date end'>
                        <input type='text' class="form-control" />
                        <span class="input-group-addon">
                    <span class="glyphicon glyphicon-calendar"></span>
                </span>
                    </div>
                </div>
            </div>
        </div>
        <button>save</button>
    </div>
    <hr/>
    <div class="date-management">
        <h2><input type="text" class="generation" name="major"/>회 전공 대표 선거</h2>
        <div class="variety"><span>후보자 등록 기간</span></div>
        <!--<input type="text" class="datetimes" name="generalDateTime" />-->
        <div class="container">
            <div class='col-md-5'>
                <div class="form-group">
                    <div class='input-group date start'>
                        <input type='text' class="form-control" />
                        <span class="input-group-addon">
                    <span class="glyphicon glyphicon-calendar"></span>
                </span>
                    </div>
                </div>
            </div>
            <div class='col-md-5'>
                <div class="form-group">
                    <div class='input-group date end'>
                        <input type='text' class="form-control" />
                        <span class="input-group-addon">
                    <span class="glyphicon glyphicon-calendar"></span>
                </span>
                    </div>
                </div>
            </div>
        </div>
        <div class="variety"><span>투표 기간</span></div>
        <!--<input type="text" class="datetimes" name="generalDateTime" />-->
        <div class="container">
            <div class='col-md-5'>
                <div class="form-group">
                    <div class='input-group date start'>
                        <input type='text' class="form-control" />
                        <span class="input-group-addon">
                    <span class="glyphicon glyphicon-calendar"></span>
                </span>
                    </div>
                </div>
            </div>
            <div class='col-md-5'>
                <div class="form-group">
                    <div class='input-group date end'>
                        <input type='text' class="form-control" />
                        <span class="input-group-addon">
                    <span class="glyphicon glyphicon-calendar"></span>
                </span>
                    </div>
                </div>
            </div>
        </div>
        <button>save</button>
    </div>

<!--</div>-->
</body>
<script>
    // $(function() {
    //     $('.datetimes').daterangepicker({
    //         autoUpdateInput: false,
    //         timePicker: true,
    //         locale: {
    //             format: 'YYYY/MM/DD HH:mm',
    //             cancelLabel: 'Clear'
    //         }
    //     });
    //
    //     $('.datetimes').on('apply.daterangepicker', function(ev, picker) {
    //         $(this).val(picker.startDate.format('YYYY/MM/DD HH:mm')
    //             + ' - ' + picker.endDate.format('YYYY/MM/DD HH:mm'));
    //     });
    //
    //     $('.datetimes').on('cancel.daterangepicker', function(ev, picker) {
    //         $(this).val('');
    //     });
    // });

    $(function () {
        $('.start').datetimepicker();
        $('.end').datetimepicker({
            useCurrent: false //Important! See issue #1075
        });
        $(".start").on("dp.change", function (e) {
            $('#datetimepicker7').data("DateTimePicker").minDate(e.date);
        });
        $(".end").on("dp.change", function (e) {
            $('#datetimepicker6').data("DateTimePicker").maxDate(e.date);
        });
    });

    $(function(){
        $("button").click(function(){
            $.ajax({
                url : "electionManagement",
                type : "POST",
                data : {
                    general : $("#general").val(),
                    generalDateTime : $("#generalDateTime").val(),
                    college : $("#college").val(),
                    collegeDateTime : $("collegeDateTime").val(),
                    major : $("#major").val(),
                    majorDateTime : $("#majorDateTime").val()
                },
                success : function() {
                    alert("저장되었습니다.");
                }
            })
        });
    })
</script>
</html>
