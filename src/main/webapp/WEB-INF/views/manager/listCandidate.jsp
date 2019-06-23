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
    <link rel="stylesheet" href="${R}resources/table.css">
</head>
<style>
    @import url(//fonts.googleapis.com/earlyaccess/jejugothic.css);

    th{
        color: black;
    }
</style>
<body>

<!-- Header -->
<%@include file="/WEB-INF/include/menu.jsp"%>

<section id="banner">
    <div class="container">
        <p style="font-family:'Jeju Gothic', sans-serif;">입후보 등록 현황</p>
    </div>
</section>

<div class="container">
    <h3 style="font-family:'Jeju Gothic', sans-serif;">후보자 승인 신청 목록</h3>

    <table class="responsive-table">
        <thead class="table-header">
          <tr style="font-family:'NanumSquareRound',sans-serif;">
              <th>팀 이름</th>
              <th>정후보</th>
              <th>부후보</th>
              <th>승인</th>
              <th>거절</th>
          </tr>
        </thead>
        <tbody style="font-family:'NanumSquareRound',sans-serif;">
        <c:forEach var="selectCandidates" items="${ selectCandidate }">
            <tr data-url="team?idx=${ selectCandidates.idx }&candidate1Idx=${selectCandidates.candidate1Idx}&candidate2Idx=${selectCandidates.candidate2Idx}" class="table-row">
                <td class="col col-1">${ selectCandidates.name }</td>
                <td class="col col-2">${ selectCandidates.candidate1Idx }</td>
                <td class="col col-3">${ selectCandidates.candidate2Idx }</td>

                <td>
                <a href="update?idx=${ selectCandidates.idx }" class="btn btn-primary" data-confirm-update>
                    <i class="glyphicon glyphicon-ok"></i> 승인
                </a>
                </td>

                <td>
                 <a href="delete?idx=${ selectCandidates.idx }" class="btn btn-danger" data-confirm-delete>
                    <i class="glyphicon glyphicon-remove"></i> 삭제
                 </a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

<!-- Scripts -->
<script src="${R}assets/js/jquery.min.js"></script>
<script src="${R}assets/js/jquery.dropotron.min.js"></script>
<script src="${R}assets/js/browser.min.js"></script>
<script src="${R}assets/js/breakpoints.min.js"></script>
<script src="${R}assets/js/util.js"></script>
<script src="${R}assets/js/main.js"></script>


</body>
</html>
