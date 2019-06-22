<%--
  Created by IntelliJ IDEA.
  User: minsub
  Date: 2019-05-12
  Time: 오후 11:38
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
    <link rel="stylesheet" type="text/css" href="https://cdn.rawgit.com/innks/NanumSquareRound/master/nanumsquareround.min.css">
    <link rel="stylesheet" href="//cdn.rawgit.com/hiun/NanumSquare/master/nanumsquare.css">
</head>
<body class="homepage is-preload">
<div id="page-wrapper">

    <!-- Header -->
    <%@include file="/WEB-INF/include/menu.jsp"%>

    <!-- Features -->
    <section id="features">
        <div class="container">

            <header>
                <h2 style="font-family: 'Nanum Square',sans-serif;"> <strong>투표하실 선거를 선택해주세요!</strong></h2>
            </header>
            <div class="row aln-center">
                <div class="col-4 col-6-medium col-12-small" style="font-family: 'NanumSquareRound',sans-serif;">
                    <c:if test="${user.type==0}">
                    <!-- Feature -->
                    <section>
                        <a href="realVote/1" class="image featured"><img src="images/pic01.jpg" alt="" /></a>
                        <header>
                            <h3>총학생회</h3>
                        </header>
                        <p>이것은 <strong>총학생회 선거입니다.</strong> <br/>학교의 총학생회를 뽑아주세요</p>
                    </section>

                </div>
                <div class="col-4 col-6-medium col-12-small" style="font-family: 'NanumSquareRound',sans-serif;">

                    <!-- Feature -->
                    <section>
                        <a href="realVote/2" class="image featured"><img src="images/pic02.jpg" alt="" /></a>
                        <header>
                            <h3>학부대표</h3>
                        </header>
                        <p>이것은 <strong>학표대표 선거입니다.</strong> <br/>자신의 학부의 학부대표를 뽑아주세요</p>
                    </section>

                </div>
                <div class="col-4 col-6-medium col-12-small" style="font-family: 'NanumSquareRound',sans-serif;">

                    <!-- Feature -->
                    <section>
                        <a href="realVote/3" class="image featured"><img src="images/pic03.jpg" alt="" /></a>
                        <header>
                            <h3>전공대표</h3>
                        </header>
                        <p>이것은 <strong>전공대표 선거입니다.</strong> <br/>자신의 전공의 전공대표를 뽑아주세요</p>
                    </section>
                    </c:if>

                    <c:if test="${user.type==1}">
                    <!-- Feature -->
                    <section>
                        <a href="admin/electionManagement/1" class="image featured"><img src="images/pic01.jpg" alt="" /></a>
                        <header>
                            <h3>총학생회</h3>
                        </header>
                        <p>이것은 <strong>총학생회 선거입니다.</strong> <br/>학교의 총학생회를 뽑아주세요</p>
                    </section>

                </div>
                <div class="col-4 col-6-medium col-12-small" style="font-family: 'NanumSquareRound',sans-serif;">

                    <!-- Feature -->
                    <section>
                        <a href="admin/electionManagement/2" class="image featured"><img src="images/pic02.jpg" alt="" /></a>
                        <header>
                            <h3>학부대표</h3>
                        </header>
                        <p>이것은 <strong>학표대표 선거입니다.</strong> <br/>자신의 학부의 학부대표를 뽑아주세요</p>
                    </section>

                </div>
                <div class="col-4 col-6-medium col-12-small" style="font-family: 'NanumSquareRound',sans-serif;">

                    <!-- Feature -->
                    <section>
                        <a href="admin/electionManagement/3" class="image featured"><img src="images/pic03.jpg" alt="" /></a>
                        <header>
                            <h3>전공대표</h3>
                        </header>
                        <p>이것은 <strong>전공대표 선거입니다.</strong> <br/>자신의 전공의 전공대표를 뽑아주세요</p>
                    </section>
                    </c:if>

                </div>
            </div>
        </div>
    </section>


    <!-- Footer -->
    <%@include file="/WEB-INF/include/footer.jsp"%>

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
