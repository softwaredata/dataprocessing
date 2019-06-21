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
</head>
<body class="homepage is-preload">
<div id="page-wrapper">

    <!-- Header -->
    <%@include file="/WEB-INF/include/menu.jsp"%>

    <!-- Features -->
    <section id="features">
        <div class="container">
            <header>
                <h2> <strong>투표하실 선거를 선택해주세요!</strong></h2>
            </header>
            <div class="row aln-center">
                <div class="col-4 col-6-medium col-12-small">

                    <!-- Feature -->
                    <section>
                        <a href="realVote/1" class="image featured"><img src="images/pic01.jpg" alt="" /></a>
                        <header>
                            <h3>총학생회</h3>
                        </header>
                        <p>이것은 <strong>총학생회 선거입니다.</strong> <br/>학교의 총학생회를 뽑아주세요</p>
                    </section>

                </div>
                <div class="col-4 col-6-medium col-12-small">

                    <!-- Feature -->
                    <section>
                        <a href="realVote/2" class="image featured"><img src="images/pic02.jpg" alt="" /></a>
                        <header>
                            <h3>학부대표</h3>
                        </header>
                        <p>이것은 <strong>학표대표 선거입니다.</strong> <br/>자신의 학부의 학부대표를 뽑아주세요</p>
                    </section>

                </div>
                <div class="col-4 col-6-medium col-12-small">

                    <!-- Feature -->
                    <section>
                        <a href="realVote/3" class="image featured"><img src="images/pic03.jpg" alt="" /></a>
                        <header>
                            <h3>전공대표</h3>
                        </header>
                        <p>이것은 <strong>전공대표 선거입니다.</strong> <br/>자신의 전공의 전공대표를 뽑아주세요</p>
                    </section>

                </div>
<%--                <div class="col-12">--%>
<%--                    <ul class="actions">--%>
<%--                        <li><a href="#" class="button icon fa-file">Tell Me More</a></li>--%>
<%--                    </ul>--%>
<%--                </div>--%>
            </div>
        </div>
    </section>

<%--    <!-- Banner -->--%>
<%--    <section id="banner">--%>
<%--        <div class="container">--%>
<%--            <p>Use this space for <strong>profound thoughts</strong>.<br />--%>
<%--                Or an enormous ad. Whatever.</p>--%>
<%--        </div>--%>
<%--    </section>--%>

<%--    <!-- Main -->--%>
<%--    <section id="main">--%>
<%--        <div class="container">--%>
<%--            <div class="row">--%>

<%--                <!-- Content -->--%>
<%--                <div id="content" class="col-8 col-12-medium">--%>

<%--                    <!-- Post -->--%>
<%--                    <article class="box post">--%>
<%--                        <header>--%>
<%--                            <h2><a href="#">I don’t want to say <strong>it’s the aliens</strong> ...<br />--%>
<%--                                but it’s the aliens.</a></h2>--%>
<%--                        </header>--%>
<%--                        <a href="#" class="image featured"><img src="images/pic04.jpg" alt="" /></a>--%>
<%--                        <h3>I mean isn't it possible?</h3>--%>
<%--                        <p>Phasellus laoreet massa id justo mattis pharetra. Fusce suscipit--%>
<%--                            ligula vel quam viverra sit amet mollis tortor congue. Sed quis mauris--%>
<%--                            sit amet magna accumsan tristique. Curabitur leo nibh, rutrum eu malesuada--%>
<%--                            in, tristique at erat lorem ipsum dolor sit amet lorem ipsum sed consequat--%>
<%--                            magna tempus veroeros lorem sed tempus aliquam lorem ipsum veroeros--%>
<%--                            consequat magna tempus lorem ipsum consequat Phasellus laoreet massa id--%>
<%--                            justo mattis pharetra. Fusce suscipit ligula vel quam viverra sit amet--%>
<%--                            mollis tortor congue. Sed quis mauris sit amet magna accumsan tristique.--%>
<%--                            Curabitur leo nibh, rutrum eu malesuada in tristique.</p>--%>
<%--                        <ul class="actions">--%>
<%--                            <li><a href="#" class="button icon fa-file">Continue Reading</a></li>--%>
<%--                        </ul>--%>
<%--                    </article>--%>

<%--                    <!-- Post -->--%>
<%--                    <article class="box post">--%>
<%--                        <header>--%>
<%--                            <h2><a href="#">By the way, many thanks to <strong>regularjane</strong>--%>
<%--                                for these awesome demo photos</a></h2>--%>
<%--                        </header>--%>
<%--                        <a href="#" class="image featured"><img src="images/pic05.jpg" alt="" /></a>--%>
<%--                        <h3>You should probably check out her work</h3>--%>
<%--                        <p>Phasellus laoreet massa id justo mattis pharetra. Fusce suscipit--%>
<%--                            ligula vel quam viverra sit amet mollis tortor congue. Sed quis mauris--%>
<%--                            sit amet magna accumsan tristique. Curabitur leo nibh, rutrum eu malesuada--%>
<%--                            in, tristique at erat lorem ipsum dolor sit amet lorem ipsum sed consequat--%>
<%--                            consequat magna tempus lorem ipsum consequat Phasellus laoreet massa id--%>
<%--                            in, tristique at erat lorem ipsum dolor sit amet lorem ipsum sed consequat--%>
<%--                            magna tempus veroeros lorem sed tempus aliquam lorem ipsum veroeros--%>
<%--                            consequat magna tempus lorem ipsum consequat Phasellus laoreet massa id--%>
<%--                            justo mattis pharetra. Fusce suscipit ligula vel quam viverra sit amet--%>
<%--                            mollis tortor congue. Sed quis mauris sit amet magna accumsan tristique.--%>
<%--                            Curabitur leo nibh, rutrum malesuada.</p>--%>
<%--                        <p>Erat lorem ipsum veroeros consequat magna tempus lorem ipsum consequat--%>
<%--                            Phasellus laoreet massa id justo mattis pharetra. Fusce suscipit ligula--%>
<%--                            vel quam viverra sit amet mollis tortor congue. Sed quis mauris sit amet--%>
<%--                            magna accumsan tristique. Curabitur leo nibh, rutrum eu malesuada in,--%>
<%--                            tristique at erat. Curabitur leo nibh, rutrum eu malesuada  in, tristique--%>
<%--                            at erat lorem ipsum dolor sit amet lorem ipsum sed consequat magna--%>
<%--                            tempus veroeros lorem sed tempus aliquam lorem ipsum veroeros consequat--%>
<%--                            magna tempus.</p>--%>
<%--                        <ul class="actions">--%>
<%--                            <li><a href="#" class="button icon fa-file">Continue Reading</a></li>--%>
<%--                        </ul>--%>
<%--                    </article>--%>

<%--                </div>--%>

<%--                <!-- Sidebar -->--%>
<%--                <div id="sidebar" class="col-4 col-12-medium">--%>

<%--                    <!-- Excerpts -->--%>
<%--                    <section>--%>
<%--                        <ul class="divided">--%>
<%--                            <li>--%>

<%--                                <!-- Excerpt -->--%>
<%--                                <article class="box excerpt">--%>
<%--                                    <header>--%>
<%--                                        <span class="date">July 30</span>--%>
<%--                                        <h3><a href="#">Just another post</a></h3>--%>
<%--                                    </header>--%>
<%--                                    <p>Lorem ipsum dolor odio facilisis convallis. Etiam non nunc vel est--%>
<%--                                        suscipit convallis non id orci lorem ipsum sed magna consequat feugiat lorem dolore.</p>--%>
<%--                                </article>--%>

<%--                            </li>--%>
<%--                            <li>--%>

<%--                                <!-- Excerpt -->--%>
<%--                                <article class="box excerpt">--%>
<%--                                    <header>--%>
<%--                                        <span class="date">July 28</span>--%>
<%--                                        <h3><a href="#">And another post</a></h3>--%>
<%--                                    </header>--%>
<%--                                    <p>Lorem ipsum dolor odio facilisis convallis. Etiam non nunc vel est--%>
<%--                                        suscipit convallis non id orci lorem ipsum sed magna consequat feugiat lorem dolore.</p>--%>
<%--                                </article>--%>

<%--                            </li>--%>
<%--                            <li>--%>

<%--                                <!-- Excerpt -->--%>
<%--                                <article class="box excerpt">--%>
<%--                                    <header>--%>
<%--                                        <span class="date">July 24</span>--%>
<%--                                        <h3><a href="#">One more post</a></h3>--%>
<%--                                    </header>--%>
<%--                                    <p>Lorem ipsum dolor odio facilisis convallis. Etiam non nunc vel est--%>
<%--                                        suscipit convallis non id orci lorem ipsum sed magna consequat feugiat lorem dolore.</p>--%>
<%--                                </article>--%>

<%--                            </li>--%>
<%--                        </ul>--%>
<%--                    </section>--%>

<%--                    <!-- Highlights -->--%>
<%--                    <section>--%>
<%--                        <ul class="divided">--%>
<%--                            <li>--%>

<%--                                <!-- Highlight -->--%>
<%--                                <article class="box highlight">--%>
<%--                                    <header>--%>
<%--                                        <h3><a href="#">Something of note</a></h3>--%>
<%--                                    </header>--%>
<%--                                    <a href="#" class="image left"><img src="images/pic06.jpg" alt="" /></a>--%>
<%--                                    <p>Phasellus  sed laoreet massa id justo mattis pharetra. Fusce suscipit ligula vel quam--%>
<%--                                        viverra sit amet mollis tortor congue magna lorem ipsum dolor et quisque ut odio facilisis--%>
<%--                                        convallis. Etiam non nunc vel est suscipit convallis non id orci. Ut interdum tempus--%>
<%--                                        facilisis convallis. Etiam non nunc vel est suscipit convallis non id orci.</p>--%>
<%--                                    <ul class="actions">--%>
<%--                                        <li><a href="#" class="button icon fa-file">Learn More</a></li>--%>
<%--                                    </ul>--%>
<%--                                </article>--%>

<%--                            </li>--%>
<%--                            <li>--%>

<%--                                <!-- Highlight -->--%>
<%--                                <article class="box highlight">--%>
<%--                                    <header>--%>
<%--                                        <h3><a href="#">Something of less note</a></h3>--%>
<%--                                    </header>--%>
<%--                                    <a href="#" class="image left"><img src="images/pic07.jpg" alt="" /></a>--%>
<%--                                    <p>Phasellus  sed laoreet massa id justo mattis pharetra. Fusce suscipit ligula vel quam--%>
<%--                                        viverra sit amet mollis tortor congue magna lorem ipsum dolor et quisque ut odio facilisis--%>
<%--                                        convallis. Etiam non nunc vel est suscipit convallis non id orci. Ut interdum tempus--%>
<%--                                        facilisis convallis. Etiam non nunc vel est suscipit convallis non id orci.</p>--%>
<%--                                    <ul class="actions">--%>
<%--                                        <li><a href="#" class="button icon fa-file">Learn More</a></li>--%>
<%--                                    </ul>--%>
<%--                                </article>--%>

<%--                            </li>--%>
<%--                        </ul>--%>
<%--                    </section>--%>

<%--                </div>--%>

<%--            </div>--%>
<%--        </div>--%>
<%--    </section>--%>

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
