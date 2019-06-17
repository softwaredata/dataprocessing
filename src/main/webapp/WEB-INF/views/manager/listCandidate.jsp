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
</head>
<body>

<!-- Header -->
<%@include file="/WEB-INF/include/menu.jsp"%>

<div class="container">
    <h3>후보자 승인 신청 목록</h3>

    <table class="table table-bordered mt5">
        <thead>
          <tr>
              <th>팀 이름</th>
              <th>후보자 학번1</th>
              <th>후보자 학번2</th>
              <th>공약</th>
              <th>승인</th>
              <th>거절</th>
          </tr>
        </thead>
        <tbody>
        <c:forEach var="selectCandidates" items="${ selectCandidate }">
            <tr>
                <td>${ selectCandidates.name }</td>
                <td>${ selectCandidates.candidate1Idx }</td>
                <td>${ selectCandidates.candidate2Idx }</td>
                <td>${ selectCandidates.pledge }</td>

                <td>
                <button type="submit" class="btn btn-primary">
                    <span class="glyphicon glyphicon-ok"></span> 저장
                </button>
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
