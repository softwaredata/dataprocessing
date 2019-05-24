<%--
  Created by IntelliJ IDEA.
  User: BOMI
  Date: 2019-05-16
  Time: 오전 11:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <script type="text/javascript" src="https://cdn.jsdelivr.net/jquery/latest/jquery.min.js"></script>
    <script type="text/javascript" src="https://cdn.jsdelivr.net/momentjs/latest/moment.min.js"></script>
    <script type="text/javascript" src="https://cdn.jsdelivr.net/npm/daterangepicker/daterangepicker.min.js"></script>
    <link rel="stylesheet" type="text/css" href="https://cdn.jsdelivr.net/npm/daterangepicker/daterangepicker.css" />
    <title>Title</title>
</head>
<body>
<div class="container">
    <div class="date-management">
        <input type="text" class="generation" name="general"/>회 총학생회 대표 선거
        <input type="text" class="datetimes" name="generalDate" />
    </div>
    <div class="date-management">
        <input type="text" class="generation" name="college"/>회 학부 대표 선거
        <input type="text" class="datetimes" name="collegeDate"/>
    </div>
    <div class="date-management">
        <input type="text" class="generation" name="major"/>회 전공 대표 선거
        <input type="text" class="datetimes" name="majorDate"/>
    </div>


</div>

</body>
<script>
    $(function() {
        $('.datetimes').daterangepicker({
            autoUpdateInput: false,
            timePicker: true,
            locale: {
                format: 'YYYY/MM/DD HH:mm',
                cancelLabel: 'Clear'
            }
        });

        $('.datetimes').on('apply.daterangepicker', function(ev, picker) {
            $(this).val(picker.startDate.format('YYYY/MM/DD HH:mm')
                + ' - ' + picker.endDate.format('YYYY/MM/DD HH:mm'));
        });

        $('.datetimes').on('cancel.daterangepicker', function(ev, picker) {
            $(this).val('');
        });
    });
</script>
</html>
