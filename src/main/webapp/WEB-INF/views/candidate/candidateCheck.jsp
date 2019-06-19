<%--
  Created by IntelliJ IDEA.
  User: minsub
  Date: 2019-06-19
  Time: 오후 5:43
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
    <link rel="stylesheet" href="${R}resources/candidate.css" />
</head>
<body class="homepage is-preload">
<div id="page-wrapper">

    <!-- Header -->
    <%@include file="/WEB-INF/include/menu.jsp"%>

    <!-- Features -->

    <!-- Banner -->
    <section id="banner">
        <div class="container">
            <p><strong>입후보등록 신청 확인</strong></p>
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

                    </article>
                    <div class="container">
                        <ul class="responsive-table">
                            <li class="table-header">
                                <div class="col col-1">Job Id</div>
                                <div class="col col-2">Customer Name</div>
                                <div class="col col-3">Amount Due</div>
                                <div class="col col-4">Payment Status</div>
                            </li>
                            <li class="table-row">
                                <div class="col col-1" data-label="Job Id">42235</div>
                                <div class="col col-2" data-label="Customer Name">John Doe</div>
                                <div class="col col-3" data-label="Amount">$350</div>
                                <div class="col col-4" data-label="Payment Status">Pending</div>
                            </li>
                            <li class="table-row">
                                <div class="col col-1" data-label="Job Id">42442</div>
                                <div class="col col-2" data-label="Customer Name">Jennifer Smith</div>
                                <div class="col col-3" data-label="Amount">$220</div>
                                <div class="col col-4" data-label="Payment Status">Pending</div>
                            </li>
                            <li class="table-row">
                                <div class="col col-1" data-label="Job Id">42257</div>
                                <div class="col col-2" data-label="Customer Name">John Smith</div>
                                <div class="col col-3" data-label="Amount">$341</div>
                                <div class="col col-4" data-label="Payment Status">Pending</div>
                            </li>
                            <li class="table-row">
                                <div class="col col-1" data-label="Job Id">42311</div>
                                <div class="col col-2" data-label="Customer Name">John Carpenter</div>
                                <div class="col col-3" data-label="Amount">$115</div>
                                <div class="col col-4" data-label="Payment Status">Pending</div>
                            </li>
                        </ul>
                    </div>


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