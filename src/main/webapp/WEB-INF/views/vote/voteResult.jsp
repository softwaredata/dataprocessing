<%--
  Created by IntelliJ IDEA.
  User: xogns
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<c:url var="R" value="/" />
<!DOCTYPE HTML>
<html>
<head>
    <title>SKHU VOTE</title>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
    <link rel="stylesheet" href="assets/css/main.css" />
    <%--<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">--%>
    <link href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet" media="screen"> <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <script src="${R}res/common.js"></script>
    <link rel="stylesheet" href="${R}res/common.css">
    <link rel="stylesheet" href="${R}res/table.css">
    <link rel="stylesheet" href="${R}res/circle.css">
    <link rel="stylesheet" href="${R}res/circle.scss">

    <script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
    <link href="http://nethna.bootstrapcdn.com/bootstrap/2.3.2/css/bootstrap.min.css"
          rel="stylesheet">

    <script src="../../assets/js/ie-emulation-modes-warning.js"></script>
</head>
<body>

<!-- Header -->
<%@include file="/WEB-INF/include/menu.jsp"%>

<section id="banner">
    <div class="container">
        <p><strong>투표 결과</strong></p>
    </div>
</section>

<div class="container">
    
    <%--<div class="c100 p${abandonment} big  " style="float: right;" >--%>
        <%--<span>기권 ${abandonment}명</span>--%>
        <%--<div class="slice">--%>
            <%--<div class="bar"></div>--%>
            <%--<div class="fill"></div>--%>
        <%--</div>--%>
    <%--</div>--%>

    <%--<div class="c100 p${vote} big  " style="float: right; ">--%>
        <%--<span> 투표 ${vote}명</span>--%>
        <%--<div class="slice">--%>
            <%--<div class="bar"></div>--%>
            <%--<div class="fill"></div>--%>
        <%--</div>--%>
    <%--</div>--%>


    <!-- Jumbotron -->
        <c:if test="${endTime.voteEndDate <= now}">
    <div class="jumbotron">
        <h1>${image.name} 승리!</h1>
        <p class="lead"> <img src="${image.teamPhotoUrl}" width="800" height="200" ></p>
        <p><a class="btn btn-lg btn-success" href="#" role="button">치열한 경쟁 끝에 승리 하였습니다 축하드립니다</a></p>
    </div>

    <!-- Example row of columns -->
    <div class="row">
        <div class="col-lg-4">
            <p class="text-danger">

            <div class="c100 p${vote} big  " style="float: right; ">
                <span> 투표 ${vote}명</span>
                <div class="slice">
                    <div class="bar"></div>
                    <div class="fill"></div>
                </div>
            </div>
            </p>
        </div>

        <div class="col-lg-4">
            <p>
            <div class="c100 p${abandonment} big  " style="float: right;" >
                <span>기권 ${abandonment}명</span>
                <div class="slice">
                    <div class="bar"></div>
                    <div class="fill"></div>
                </div>
            </div>

            </p>

        </div>
        </c:if>

        <c:if test="${endTime.voteEndDate > now}">
            <div class="jumbotron">
                <h1>아직 투표 결과가 안나왔습니다!</h1>
                <p class="lead">아직 투표가 진행 중이니 기다려 주시기 바랍니다</p>
                <p><a class="btn btn-lg btn-success" href="#" role="button">끝나고 눌러주세여!</a></p>
            </div>
        </c:if>

    </div>

    <!-- Example row of columns -->

</div>

<!-- Scripts -->
<script src="${R}assets/js/jquery.min.js"></script>
<script src="${R}assets/js/jquery.dropotron.min.js"></script>
<script src="${R}assets/js/browser.min.js"></script>
<script src="${R}assets/js/breakpoints.min.js"></script>
<script src="${R}assets/js/util.js"></script>
<script src="${R}assets/js/main.js"></script>

<div id="piechart" style="width: 900px; height: 500px;"></div>

</body>
</html>