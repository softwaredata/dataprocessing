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
    <div class="container">

    <!-- Logo -->
    <h1 id="logo"><a href="/main">SKHU VOTE</a></h1>
    <p>성공회대학교 투표 시스템</p>

    <!-- Nav -->
    <nav id="nav">
    <ul>
        <li><a class="icon fa-home" href="/main"><span>HOME</span></a></li>
        <li>
            <a href="#" class="icon fa-bar-chart-o"><span>Dropdown</span></a>
            <ul>
                <li><a href="#">menu1</a></li>
                <li><a href="#">menu2</a></li>
                <li><a href="#">menu3</a></li>
                <li>
                    <a href="#">DropDown2</a>
                    <ul>
                        <li><a href="#">menu1</a></li>
                        <li><a href="#">menu2</a></li>
                        <li><a href="#">menu3</a></li>
                    </ul>
                </li>
            </ul>
        </li>
        <li><a class="icon fa-cog" href="#"><span>menu1</span></a></li>
        <li><a class="icon fa-retweet" href="#"><span>menu2</span></a></li>
        <li><a class="icon fa-sitemap" href="/login"><span>login/logout?</span></a></li>
    </ul>
    </nav>

    </div>
    </section>
