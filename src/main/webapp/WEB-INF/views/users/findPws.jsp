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
    <script type="text/javascript" src="http://code.jquery.com/jquery-latest.js"></script>
    <script type="text/javascript" src="http://code.jquery.com/jquery-latest.min.js"></script>
    <title>비밀번호찾기</title>
</head>
<body>
<div class="container">
    <div class="info">
        <h2>비밀번호찾기</h2>
    </div>
</div>
<div class="form">
    <div class="login-form">
        <p>
            <label>ID</label>
            <input class="w3-input" type="text" id="id" name="id" required>
        </p>
        <p>
            <label>Email</label>
            <input class="w3-input" type="email" id="email" name="email" required>
        </p>
        <button type="button" id=findBtn class="btn btn-primary">비밀번호찾기</button>
        <a href="login" class="btn btn-">로그인으로</a>
        <br /> <br /> <br />
        </p>
    </div>
</div>

<script>
    $(function(){
        $("#findBtn").click(function(){
            $.ajax({
                url : "find_pws",
                type : "POST",
                contentType : "application/json",
                data : JSON.stringify({
                    id : $("#id").val(),
                    email : $("#email").val()
                }),
                success : function(result) {
                    alert(result);
                },
            })
        });
    })
</script>

</body>

</html>
