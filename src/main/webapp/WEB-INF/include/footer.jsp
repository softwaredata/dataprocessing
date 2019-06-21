<%--
  Created by IntelliJ IDEA.
  User: minsub
  Date: 2019-06-18
  Time: 오후 9:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:url var="R" value="/" />
<section id="footer">
    <div class="container">
        <header>
            <h2><strong></strong></h2>
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
                                <li class="icon fa-bandcamp">
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
                            <a href="/mypage" class="form-button-submit button ">내 정보수정하러가기</a>
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