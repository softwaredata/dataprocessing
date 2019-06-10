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
                                <h2><a href="#">
                                     <strong>팀별 강조할 말 한문장</strong>
                                    </a>
                                </h2>
                            </header>
                            <a href="#" class="image featured"><img src="images/pic04.jpg" alt="" />후보팀 사진</a>
                            <h3>공약</h3>
                            <p>Phasellus laoreet massa id justo mattis pharetra. Fusce suscipit
                                ligula vel quam viverra sit amet mollis tortor congue. Sed quis mauris
                                sit amet magna accumsan tristique. Curabitur leo nibh, rutrum eu malesuada
                                in, tristique at erat lorem ipsum dolor sit amet lorem ipsum sed consequat
                                magna tempus veroeros lorem sed tempus aliquam lorem ipsum veroeros
                                consequat magna tempus lorem ipsum consequat Phasellus laoreet massa id
                                justo mattis pharetra. Fusce suscipit ligula vel quam viverra sit amet
                                mollis tortor congue. Sed quis mauris sit amet magna accumsan tristique.
                                Curabitur leo nibh, rutrum eu malesuada in tristique.</p>

                            <ul class="actions">
                                <li><a href="#image_url" class="button icon fa-file" onclick="window.open(this.href,'팝업창','width=800,height=700');return false" >추천서</a></li>
                                <li><a href="#image_url" class="button icon fa-file" onclick="window.open(this.href,'팝업창','width=800,height=700');return false">운동본부원 명단</a></li>
                                <li><a href="#image_url" class="button icon fa-file" onclick="window.open(this.href,'팝업창','width=800,height=700');return false">선거 서약서</a></li>
                            </ul>

                            <ul class="actions">
                                <li><a href="/election/${vote}" class="button icon fa-file">투표창으로</a></li>
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
                                        <a href="#" class="image featured"><img src="images/pic04.jpg" alt="" /> 정후보 사진</a>
                                        <p> 정후보 간단한 소개? 넣을까 말까</p>
                                    </article>

                                </li>
                                <li>

                                    <!-- Excerpt -->
                                    <article class="box excerpt">
                                        <header>
                                            <span class="date">부후보: ${teamDetail.candidate2idx} ${teamDetail.name2}</span>

                                        </header>
                                        <a href="#" class="image featured"><img src="images/pic04.jpg" alt="" /> 부후보 사진</a>
                                        <p>부후보 간단한 소개? 넣을까 말까</p>
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
    <section id="footer">
        <div class="container">
            <header>
                <h2><strong>MyPage</strong></h2>
            </header>
            <div class="row">
                <div class="col-6 col-12-medium">
                    <section>
                        <form method="post" action="#">
                            <div class="row gtr-50">
                                <div class="col-6 col-12-small">
                                    <input name="name" placeholder="Name" type="text" />
                                </div>
                                <div class="col-6 col-12-small">
                                    <input name="email" placeholder="test@mail_name.com" type="text" vlaue=""/>
                                </div>
                                <div class="col-12">
                                    <textarea name="message" placeholder="시스템에 대한 건의 사항 있으면 메일로 보내주세요"></textarea>
                                </div>
                                <div class="col-12">
                                    <br/>
                                    <a href="#" class="form-button-submit button icon fa-envelope">Send Message</a>
                                </div>
                            </div>
                        </form>
                    </section>
                </div>
                <div class="col-6 col-12-medium">
                    <section>
                        <p>투표를 하기전에 내 정보가 정확한지 확인해 주세요!</p>
                        <div class="row">
                            <div class="col-6 col-12-small">
                                <ul class="icons">
                                    <li class="icon fa-home">
                                        이름 : 홍길동<br />
                                    </li>
                                    <li class="icon fa-twitter">
                                        <a href="#">학과 : ------------ </a>
                                    </li>
                                    <li class="icon fa-phone">
                                        전화번호 : 010-0000-0000
                                    </li>

                                </ul>
                            </div>
                            <div class="col-6 col-12-small">
                                <ul class="icons">

                                    <li class="icon fa-dribbble">
                                        <a href="#">학번 : 20-------</a>
                                    </li>

                                    <li class="icon fa-envelope">
                                        <a href="#">이메일 : <br/> MyEmail@ email.com</a>
                                    </li>
                                </ul>
                            </div>
                            <div class="col-12">
                                <a href="#" class="form-button-submit button ">내 정보수정하러가기</a>
                            </div>
                        </div>
                    </section>
                </div>
            </div>
        </div>
        <div id="copyright" class="container">
            <ul class="links">
                <li>&copy; pepero</li><li>Design: <a href="http://html5up.net">HTML5 UP</a></li>
            </ul>
        </div>
    </section>

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