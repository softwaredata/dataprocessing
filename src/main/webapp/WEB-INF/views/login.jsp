<%--
  Created by IntelliJ IDEA.
  User: BOMI
  Date: 2019-05-10
  Time: 오후 6:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"
		 pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta name="viewport"
		  content="width=device-width, initial-scale=1, shrink-to-fit=no">
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link href="resources/bootstrap/css/bootstrap.css" rel="stylesheet"
		  type="text/css" />
	<link rel="stylesheet" href="resources/bootstrap/css/login.css">
	<!-- jQuery (부트스트랩의 자바스크립트 플러그인을 위해 필요한) -->
	<script src="${R}https://code.jquery.com/jquery.js"></script>
	<!-- 모든 합쳐진 플러그인을 포함하거나 (아래) 필요한 각각의 파일들을 포함하세요 -->
	<script src="${R}resources/bootstrap/js/bootstrap.min.js"></script>
	<!-- Respond.js 으로 IE8 에서 반응형 기능을 활성화하세요 (https://github.com/scottjehl/Respond) -->
	<script src="${R}resources/bootstrap/js/respond.js"></script>
	<title>성공회대학교 투표 시스템</title>


	<script type="text/javascript" src="http://code.jquery.com/jquery-latest.js"></script>
	<script type="text/javascript" src="http://code.jquery.com/jquery-latest.min.js"></script>

</head>
<body>
<form name="frm" action="login" method="post">


	<div class="container">
		<div class="info">
			<h1>성공회대학교 </br> 투표 서비스</h1>
		</div>
	</div>
	<div class="form">
		<div class="thumbnail">
			<img
					src="images/vote.png" alt="" />
		</div>

		<form class="login-form">
			<input type="text" placeholder="username" />
			<input type="password" placeholder="password" />
			<button>login</button>
			<p class="message">
				<br />
				<a href="signUp"><span>회원가입 </span></a>
				<a href="findPws"><span>비밀번호찾기 </span></a>
				</br>
				<a href="mypage"><span>회원정보 수정 </span></a>
				<a href="main"><span>메인페이지 </span></a>
				<br /> <br /> <br />
			</p>
		</form>
	</div>


</form>

<script>
    $('.message a').click(function(){
        $('form').animate({height: "toggle", opacity: "toggle"}, "slow");
    });
</script>

</body>

</html>
