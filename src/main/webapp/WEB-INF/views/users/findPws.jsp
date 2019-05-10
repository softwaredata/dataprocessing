<%--
  Created by IntelliJ IDEA.
  User: minsub
  Date: 2019-05-10
  Time: 오후 9:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

    <link type="text/css" rel="stylesheet" href="https://unpkg.com/bootstrap/dist/css/bootstrap.min.css"/>
    <link type="text/css" rel="stylesheet" href="https://unpkg.com/bootstrap-vue@latest/dist/bootstrap-vue.css"/>

    <script src="http://code.jquery.com/jquery-latest.js"></script>
    <script>
        $(function(){
            $("#findBtn").click(function(){
                $.ajax({
                    url : "find_pws",
                    type : "POST",
                    data : {
                        id : $("#id").val(),
                        email : $("#email").val()
                    },
                    success : function(result) {
                        alert(result);
                    },
                })
            });
        })
    </script>
    <title>비밀번호 찾기</title>
</head>
<body>
<div class="w3-content w3-container w3-margin-top">
    <div class="w3-container w3-card-4">
        <div class="w3-center w3-large w3-margin-top">
            <h3>비밀번호 찾기</h3>
        </div>
            <div>
                <label>ID</label>
                <input class="w3-input" type="text" id="id" name="id" required>
                </p>
                <p>
                    <label>Email</label>
                    <input class="w3-input" type="text" id="email" name="email" required>
                </p>
                <p class="w3-center">
                    <button type="button" id=findBtn class="btn btn-primary">비밀번호찾기</button>
                    <a href="login" class="btn btn-">홈</a>
                </p>

            </div>
    </div>
</div>
</body>
</html>