<%--
  Created by IntelliJ IDEA.
  User: minsub
  Date: 2019-06-03
  Time: 오후 5:07
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

    <!-- Banner -->
    <section id="banner">
        <div class="container">
            <c:if test="${electionType==1}">
                <p><strong>${election.name}대 총 학생회장 선거</strong></p>
            </c:if>
            <c:if test="${electionType==2}">
                <p><strong>${election.name}대 학부대표 선거</strong></p>
            </c:if>
            <c:if test="${electionType==3}">
                <p><strong>전공대표 선거</strong></p>
            </c:if>
        </div>
    </section>

    <!-- Main -->
    <section id="main">
        <div class="container" style="margin-left: 20%;margin-right: auto;">
            <div class="row">
                <c:forEach items="${teamList}" var="team">
                <!-- Content -->
                <div id="content" class="col-8 col-12-medium">

                    <!-- Post -->
                    <article class="box post">
                        <header>
                            <h2><a href="#"><strong>${team.name} 팀</strong></a></h2>
                        </header>
                        <a href="#" class="image featured"><img src="images/pic05.jpg" alt="" /> 팀 메인 사진</a>

                        <p>${team.name} 팀 입니다</p>
                        <ul class="actions">
                            <li><a href="/teamDetail/${electionType}/${team.idx}" class="button icon fa-vcard" >더보기</a></li>
                            <li>
                                <form name="vote_form" method="post" >
                                    <input type="hidden" id="studentidx" name="studentidx" value="201432005">
                                    <input type="hidden" id="electionidx" name="electionidx" value="${election.idx}">
                                    <input type="hidden"  id="teamidx" name="teamidx" value="${team.idx}">
                                    <input type="hidden"  id="abandonment" name="abandonment" value="0">
                                    <button type="button" onclick="voteCheck(this.form)" class="button icon fa-file">투표</button>
                                </form>
                            </li>
                        </ul>
                    </article>
                </div>
                </c:forEach>

            </div>
            <br/><br/><br/><br/>
            <div id="goAbandonment" style="margin-left: 55%">
                <form name="abandonment" method="post" >
                    <input type="hidden"  id="studentidx0" name="studentidx" value="201432005">
                    <input type="hidden"  id="electionidx0" name="electionidx" value="${election.idx}">
                    <input type="hidden"  id="abandonment0" name="abandonment" value="1">
                    <button type="button" onclick="abandonmentCheck()" class="button icon fa-balance-scale">기권</button>
                </form>
            </div>
        </div>
    </section>

    <!-- Footer -->
   <%@include file="/WEB-INF/include/footer.jsp"%>

</div>


<script type="text/javascript">
    function voteCheck(this_form) {
        if (confirm('이 후보를 투표하시겠습니까?') == true) {
            $(function(){//투표
                $.ajax({
                    url : "/goForVote",
                    type : "POST",
                    contentType : "application/json",
                    data : JSON.stringify({
                        studentidx : $("#studentidx").val(),
                        electionidx : $("#electionidx").val(),
                        teamidx : $(this_form.teamidx).val(),
                        abandonment : $("#abandonment").val()
                    }),
                    success : function(result) {
                        alert(result);
                    },
                })
            })
            return true//확인
        }
        else{   //취소
            return false;
        }
    }


    function abandonmentCheck() {
        if (confirm('정말 기권하시겠습니까') == true) {
            $(function(){
                $.ajax({
                    url : "/goForVote",
                    type : "POST",
                    contentType : "application/json",
                    data : JSON.stringify({
                        studentidx : $("#studentidx0").val(),
                        electionidx : $("#electionidx0").val(),
                        abandonment : $("#abandonment0").val()
                    }),
                    success : function(result) {
                        alert(result);
                    },
                })
            })
            return true//확인
        }
        else{   //취소
            return false;
        }
    }
</script>



<!-- Scripts -->
<script src="${R}assets/js/jquery.min.js"></script>
<script src="${R}assets/js/jquery.dropotron.min.js"></script>
<script src="${R}assets/js/browser.min.js"></script>
<script src="${R}assets/js/breakpoints.min.js"></script>
<script src="${R}assets/js/util.js"></script>
<script src="${R}assets/js/main.js"></script>

<script type="text/javascript" src="http://code.jquery.com/jquery-latest.js"></script>
<script type="text/javascript" src="http://code.jquery.com/jquery-latest.min.js"></script>

</body>
</html>
