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


    <!-- 합쳐지고 최소화된 최신 CSS -->
    <%-- 이거 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">--%>

    <!-- 부가적인 테마 -->
    <%--이거<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">--%>

    <%--이거<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>--%>

    <!-- 합쳐지고 최소화된 최신 자바스크립트 -->
    <%--<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>--%>
    <%--이거<script src="http://netdna.bootstrapcdn.com/bootstrap/3.0.3/js/bootstrap.min.js"></script>--%>


    <%--<script src="http://code.jquery.com/jquery-1.10.2.js"></script>--%>
    <%--이거<script src="http://code.jquery.com/jquery-3.2.1.js"></script>--%>


    <%--이거<script type='text/javascript' src='//code.jquery.com/jquery-1.8.3.js'></script>--%>
    <%--<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.5.0/css/bootstrap-datepicker3.min.css">--%>
    <%--이거<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datetimepicker/4.17.47/css/bootstrap-datetimepicker.css">--%>
    <%--<script type='text/javascript' src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.5.0/js/bootstrap-datepicker.min.js"></script>--%>
    <%--<script src="/js/bootstrap-datepicker.kr.js" charset="UTF-8"></script>--%>


    <%--<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.24.0"></script>--%>
    <%--<script type="text/javascript" src="${R}resources/bootstrap/js/moment.js"/>--%>
    <%--이거<script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.18.0/moment.min.js"></script>--%>
    <%--이거<script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datetimepicker/4.17.47/js/bootstrap-datetimepicker.min.js"></script>--%>


    <%--이거<link rel="stylesheet" type="text/css" href="${R}resources/bootstrap/css/datepicker3.css" />&ndash;%&gt;--%>
    <%--<script type="text/javascript" src="${R}resources/bootstrap/js/bootstrap-datepicker.js"></script>--%>
    <%--<script type="text/javascript" src="${R}resources/bootstrap/js/bootstrap-datepicker.kr.js"></script>이거까지--%>

    <link rel="stylesheet" type="text/css" href="${R}assets/css/main.css" />
    <link rel="stylesheet" type="text/css" href="${R}resources/bootstrap/css/electionManagement.css"/>

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.18.0/moment.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.18.0/locale/ko.js"></script>
    ​<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

    <script src="${R}resources/bootstrap/js/bootstrap-datetimepicker.js"></script>
    <link rel="stylesheet" type="text/css" href="${R}resources/bootstrap/css/datetimepickerstyle.css" />

    <title>Title</title>
</head>
<body>
<!-- Header -->
<%@include file="/WEB-INF/include/menu.jsp"%>

<!--<div class="container">-->
    <div class="date-management">
        <h2><input type="text" class="generation" value="${general.name}"/>회 총학생회 대표 선거</h2>
        <div class="variety"><span>후보자 등록 기간</span></div>
        <!--<input type="text" class="datetimes" name="generalDateTime" />-->
        <div class="container">
            <div class='col-md-5'>
                <div class="form-group">
                    <div class='input-group date dateTimePicker' id="datepicker1">
                        <input type='text' class="form-control" value="${general.regStartDate}"/>
                        <span class="input-group-addon">
                    <span class="glyphicon glyphicon-calendar"></span>
                </span>
                    </div>
                </div>
            </div>
            <div class='col-md-5'>
                <div class="form-group">
                    <div class='input-group date dateTimePicker' id="datepicker2">
                        <input type='text' class="form-control" value="${general.regEndDate}"/>
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
                    <div class='input-group date dateTimePicker' id="datepicker3">
                        <input type='text' class="form-control" value="${general.voteStartDate}"/>
                        <span class="input-group-addon">
                    <span class="glyphicon glyphicon-calendar"></span>
                </span>
                    </div>
                </div>
            </div>
            <div class='col-md-5'>
                <div class="form-group">
                    <div class='input-group date dateTimePicker' id="datepicker4">
                        <input type='text' class="form-control" value="${general.voteEndDate}"/>
                        <span class="input-group-addon">
                    <span class="glyphicon glyphicon-calendar"></span>
                </span>
                    </div>
                </div>
            </div>
        </div>
        <button onclick='click(this)'>save</button>
    </div>
    <hr/>
    <div class="date-management" id="department">
        <h2><input type="text" class="generation" value="${department.name}"/>회 학부 대표 선거</h2>
        <div class="variety"><span>후보자 등록 기간</span></div>
        <!--<input type="text" class="datetimes" name="generalDateTime" />-->
        <div class="container">
            <div class='col-md-5'>
                <div class="form-group">
                    <div class='input-group date dateTimePicker' id="datepicker5">
                        <input type='text' class="form-control" value="${department.regStartDate}" />
                        <span class="input-group-addon">
                    <span class="glyphicon glyphicon-calendar"></span>
                </span>
                    </div>
                </div>
            </div>
            <div class='col-md-5'>
                <div class="form-group">
                    <div class='input-group date dateTimePicker' id="datepicker6">
                        <input type='text' class="form-control" value="${department.regEndDate}"/>
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
                    <div class='input-group date dateTimePicker' id="datepicker7">
                        <input type='text' class="form-control" value="${department.voteStartDate}"/>
                        <span class="input-group-addon">
                    <span class="glyphicon glyphicon-calendar"></span>
                </span>
                    </div>
                </div>
            </div>
            <div class='col-md-5'>
                <div class="form-group">
                    <div class='input-group date dateTimePicker' id="datepicker8">
                        <input type='text' class="form-control" value="${department.voteEndDate}"/>
                        <span class="input-group-addon">
                    <span class="glyphicon glyphicon-calendar"></span>
                </span>
                    </div>
                </div>
            </div>
        </div>
        <button onclick='click(this)'>save</button>
    </div>
<hr/>
<div class="date-management" id="major">
        <h2><input type="text" class="generation" value="${major.name}"/>회 전공 대표 선거</h2>
        <div class="variety"><span>후보자 등록 기간</span></div>
        <!--<input type="text" class="datetimes" name="generalDateTime" />-->
        <div class="container">
            <div class='col-md-5'>
                <div class="form-group">
                    <div class='input-group date regStart dateTimePicker' id="datepicker9">
                        <input type='text' class="form-control" value="${major.regStartDate}" />
                        <span class="input-group-addon">
                    <span class="glyphicon glyphicon-calendar"></span>
                </span>
                    </div>
                </div>
            </div>
            <div class='col-md-5'>
                <div class="form-group">
                    <div class='input-group date regEnd dateTimePicker' id="datepicker10">
                        <input type='text' class="form-control"value="${major.regEndDate}" />
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
                    <div class='input-group date voteStart dateTimePicker' id="datepicker11">
                        <input type='text' class="form-control" value="${major.voteStartDate}" />
                        <span class="input-group-addon">
                            <span class="glyphicon glyphicon-calendar"></span>
                        </span>
                    </div>
                </div>
            </div>
            <div class='col-md-5'>
                <div class="form-group">
                    <div class='input-group date voteEnd dateTimePicker' id="datepicker12">
                        <input type='text' class="form-control" value="${major.voteEndDate}" />
                        <span class="input-group-addon">
                            <span class="glyphicon glyphicon-calendar"></span>
                        </span>
                    </div>
                </div>
            </div>
        </div>
        <button onclick='click(this)'>save</button>
    </div>

</body>
<script src="../../../resources/bootstrap/js/election-management.js" type="text/javascript"></script>
</html>
