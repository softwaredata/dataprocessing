<%--
  Created by IntelliJ IDEA.
  User: minsub
  Date: 2019-05-12
  Time: 오후 11:38
  To change this template use File | Settings | File Templates.
--%>
    <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <c:url var="R" value="/" />

    <section id="header">
    <div class="container" style="padding-top: 200px;padding-bottom: 80px;">

    <!-- Logo -->
    <h1 id="logo"><a href="/main">SKHU VOTE</a></h1>
    <p>성공회대학교 투표 시스템</p>

    <!-- Nav -->
    <nav id="nav">
    <ul>
        <li><a class="icon fa-cog" href="/mypage"><span>MYPAGE</span></a></li>
        <li><a class="icon fa-retweet" href="/candiRegister"><span>입후보등록</span></a></li>
        <li><a class="icon fa-retweet" href="/candidateCheck"><span>입후보신청현황</span></a></li>
        <li><a class="icon fa-retweet" href="#"><span>입후보관리</span></a></li>
        <li><a class="icon fa-sitemap" href="/login"><span>logout</span></a></li>
    </ul>
    </nav>

    </div>
    </section>
