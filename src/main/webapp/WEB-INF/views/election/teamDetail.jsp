<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2019-06-03
  Time: 오후 5:28
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
    <link rel="stylesheet" href="${R}assets/css/main.css" />
</head>
<body class="homepage is-preload">
<div id="page-wrapper">

    <!-- Header -->
    <%@include file="/WEB-INF/include/menu.jsp"%>

    <!-- Features -->

    <!-- Banner -->
        <section id="banner">
            <div class="container">
                <p><strong>${teamDetail.name} 팀</strong></p>
            </div>
        </section>

        <!-- Main -->
        <section id="main">
            <div class="container">
                <div class="row">

                    <!-- Content -->
                    <div id="content" class="col-8 col-12-medium">
                        <!-- Post -->
                        <article class="box post">
                            <header>
<%--                                <h2><a href="#">--%>
<%--                                     <strong></strong>--%>
<%--                                    </a>--%>
<%--                                </h2>--%>
                            </header>
                            <label>팀 사진</label>
                            <a href="#" class="image featured" style="width: 60%"><img src="${teamDetail.teamPhotoUrl}" alt="" /></a>
                            <h3>공약</h3>
                            <p>
                                <a href="#" class="image featured"><img src="${teamDetail.pledge}" alt="" /></a>

                            </p>

                            <ul class="actions">
                                <li><a href="/realVote/${electionType}" class="button icon fa-file">투표창으로</a></li>
                            </ul>
                        </article>
                    </div>

                    <!-- Sidebar -->
                    <div id="sidebar" class="col-4 col-12-medium">

                        <!-- Excerpts -->
                        <section>
                            <ul class="divided">
                                <li>

                                    <!-- Excerpt -->
                                    <article class="box excerpt">
                                        <header>
                                            <span class="date">정후보: ${teamDetail.candidate1idx} ${teamDetail.name1}</span>
                                            <h3><a href="#"></a></h3>
                                        </header>
                                        <a href="#" class="image featured"><img src="${teamImage.profileUrl1}" alt="" /></a>
                                    </article>

                                </li>
                                <li>

                                    <!-- Excerpt -->
                                    <article class="box excerpt">
                                        <header>
                                            <span class="date">부후보: ${teamDetail.candidate2idx} ${teamDetail.name2}</span>

                                        </header>
                                        <a href="#" class="image featured"><img src="${teamImage.profileUrl2}" alt="" /></a>
                                    </article>

                                </li>
                            </ul>
                        </section>

                        <!-- Highlights -->

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