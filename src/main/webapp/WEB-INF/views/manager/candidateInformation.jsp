<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<c:url var="R" value="/" />
<html>
<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
    <link rel="stylesheet" href="assets/css/main.css" />
    <%--<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">--%>
    <link href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet" media="screen"> <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <script src="${R}res/common.js"></script>
    <link rel="stylesheet" href="${R}res/common.css">
    <link rel="stylesheet" href="${R}res/table.css">
    <link rel="stylesheet" href="${R}res/profile.css">

    <link href="//netdna.bootstrapcdn.com/twitter-bootstrap/2.3.2/css/bootstrap-combined.min.css" rel="stylesheet" id="bootstrap-css">
    <script src="//netdna.bootstrapcdn.com/twitter-bootstrap/2.3.2/js/bootstrap.min.js"></script>
    <script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
</head>
<body class="homepage is-preload">
<div id="page-wrapper">
<%@include file="/WEB-INF/include/menu.jsp"%>

<section id="banner">
    <div class="container">
        <p><strong>팀 정보</strong></p>
    </div>
</section>

<div class="container">
    <div class="container">
    <div class="row">
        <div class="col-sm-2 col-md-2">
            <img src="${team.profileUrl}"
                 alt="" class="img-rounded img-responsive" />
        </div>
        <div class="col-sm-4 col-md-4">
            <blockquote>
                <p>정 후보</p> <small><cite title="Source Title">학번 : ${team.idx}  </cite></small>
            </blockquote>
            <p> <i class="glyphicon glyphicon-envelope"></i> ${candidate.email}
                <br
                /> <i class="glyphicon glyphicon-globe"></i> ${candidate.department}
                <br /> <i class="glyphicon glyphicon-gift"></i> ${candidate.name}</p>
        </div>
        <div class="col-sm-2 col-md-2">
        <img src="${teamSub.profileUrl}"
             alt="" class="img-rounded img-responsive" />
    </div>
        <div class="col-sm-2 col-md-4">
            <blockquote>
                <p>부후보</p> <small><cite title="Source Title">학번 : ${teamSub.idx} </cite></small>
            </blockquote>
            <p> <i class="glyphicon glyphicon-envelope"></i> ${subCandidate.email}
                <br
                /> <i class="glyphicon glyphicon-globe"></i> ${subCandidate.department}
                <br /> <i class="glyphicon glyphicon-gift"></i>${subCandidate.name}</p>
        </div>

        <div class="col-sm-2 col-md-2">
            <img src="${picture.pledge}"
                 alt="" class="img-rounded img-responsive" />
        </div>
        <div class="col-sm-2 col-md-4">
            <blockquote>
                <p>공약</p> <small><cite title="Source Title"> </cite></small>
            </blockquote>
        </div>


        <div class="col-sm-2 col-md-2">
            <img src="${picture.teamPhotoUrl}"
                 alt="" class="img-rounded img-responsive" />
        </div>
        <div class="col-sm-2 col-md-4">
            <blockquote>
                <p>팀사진</p> <small><cite title="Source Title"></cite></small>
            </blockquote>
        </div>

        <div class="col-sm-2 col-md-2">
            <img src="${picture.teamPhotoUrl}"
                 alt="" class="img-rounded img-responsive" />
        </div>
        <div class="col-sm-2 col-md-4">
            <blockquote>
                <p>팀사진</p> <small><cite title="Source Title"></cite></small>
            </blockquote>
        </div>


        <div class="col-sm-2 col-md-2">
            <img src="${picture.oathPhotoUrl}"
                 alt="" class="img-rounded img-responsive" />
        </div>
        <div class="col-sm-2 col-md-4">
            <blockquote>
                <p>서약서</p> <small><cite title="Source Title"></cite></small>
            </blockquote>
        </div>

        <div class="col-sm-2 col-md-2">
            <img src="${picture.reccoPhotoUrl}"
                 alt="" class="img-rounded img-responsive" />
        </div>
        <div class="col-sm-2 col-md-4">
            <blockquote>
                <p>추천서</p> <small><cite title="Source Title"></cite></small>
            </blockquote>
        </div>

        <div class="col-sm-2 col-md-2">
            <img src="${picture.electioneeringFileUrl}"
                 alt="" class="img-rounded img-responsive" />
        </div>
        <div class="col-sm-2 col-md-4">
            <blockquote>
                <p>운동본부원</p> <small><cite title="Source Title"></cite></small>
            </blockquote>
        </div>



        <div class="col-sm-2 col-md-2">
            <img src="${picture.candidate1CertiUrl}"
                 alt="" class="img-rounded img-responsive" />
        </div>
        <div class="col-sm-2 col-md-4">
            <blockquote>
                <p>정후보 재학증명서</p> <small><cite title="Source Title"></cite></small>
            </blockquote>
        </div>


        <div class="col-sm-2 col-md-2">
            <img src="${picture.candidate2CertiUrl}"
                 alt="" class="img-rounded img-responsive" />
        </div>
        <div class="col-sm-2 col-md-4">
            <blockquote>
                <p>부후보재학증명서</p> <small><cite title="Source Title"></cite></small>
            </blockquote>
        </div>


    </div>

    </div>
</div>

<link rel="stylesheet" href="${R}res/table.css">
<!-- Scripts -->
<script src="${R}assets/js/jquery.min.js"></script>
<script src="${R}assets/js/jquery.dropotron.min.js"></script>
<script src="${R}assets/js/browser.min.js"></script>
<script src="${R}assets/js/breakpoints.min.js"></script>
<script src="${R}assets/js/util.js"></script>
<script src="${R}assets/js/main.js"></script>
</body>
</html>
