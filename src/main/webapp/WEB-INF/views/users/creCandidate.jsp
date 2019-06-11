<%--
  Created by IntelliJ IDEA.
  User: audgp
  Date: 2019-06-09
  Time: 오후 5:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<c:url var="R" value="/" />
<html>
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://bootswatch.com/4/litera/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="https://cdn.jsdelivr.net/gh/moonspam/NanumSquare@1.0/nanumsquare.css">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="${R}res/css/header.css">
    <script src="http://code.jquery.com/jquery-latest.min.js" type="text/javascript"></script>
    <link rel="stylesheet" href="resources/bootstrap/css/createCandidate.css">
    <link rel="stylesheet" href="${R}res/css/board.css">
    <title>입후보 등록 페이지 </title>
</head>
<body>
<div id="jb-content">
    <div id="boardWrite"style="max-width: 800px;">
        <h3>&nbsp;&nbsp;문의 내용</h3>
        <hr>
        <form method="post">
            <table class="table table-bordered" align="center" style="margin-top: 40px; font-size: 17px; text-align: center; width: 80%">
                <tr>
                    <td style="background-color: #4582EC; color: white; width: 100px; padding-top: 18px"><strong>이름</strong></td>
                    <td colspan="3" style="text-align: left; padding-left: 25px; padding-top: 18px">
                        <span>${ board.userName }</span>
                    </td>
                </tr>
                <tr>
                    <td style="background-color: #4582EC; color: white; padding-top: 18px"><strong>제목</strong></td>
                    <td colspan="3" style="text-align: left; padding-left: 25px; padding-top: 18px">
                        <span>${ board.title }</span>
                    </td>
                </tr>
                <tr>
                    <td style="background-color: #4582EC; color: white; height: 400px; padding-top: 190px"><strong>내용</strong></td>
                    <td colspan="3" style="text-align: left; padding: 40px;">
                        <span>${ board.content }</span>
                    </td>
                </tr>
            </table>

            <div class="form-group" align="center" style="margin-top: 40px">
                <a href="board" class="btn btn-outline-primary">목록으로</a>
                <c:if test="${ user.id == board.userId }">
                    &nbsp;&nbsp;<a href="board_question_edit?boardId=${ board.boardId }" class="btn btn-primary">수정하기</a>
                    &nbsp;&nbsp;<a href="questionDelete?id=${ board.boardId }" class="btn btn-danger" data-confirm-delete>삭제하기</a>
                </c:if>

            </div>
        </form>
    </div>
</div>
</div>
</body>
</html>
