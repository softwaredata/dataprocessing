<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2019-06-20
  Time: 오전 12:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>입후보 등록</title>
    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

    <!-- Optional theme -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">

    <!-- Latest compiled and minified JavaScript -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
    <script src="${R}assets/js/jquery.min.js"></script>
    <script src="${R}assets/js/jquery.dropotron.min.js"></script>
    <script src="${R}assets/js/browser.min.js"></script>
    <script src="${R}assets/js/breakpoints.min.js"></script>
    <script src="${R}assets/js/util.js"></script>
    <script src="${R}assets/js/main.js"></script>
    <title>SKHU VOTE</title>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
    <link rel="stylesheet" href="assets/css/main.css" />
    <style type="text/css">
        @import url(http://fonts.googleapis.com/earlyaccess/hanna.css);
        @import url(http://fonts.googleapis.com/earlyaccess/jejugothic.css);
        body{
            background-color:white;
        }
        h2{
            font-family:'Jeju Gothic', serif;
        }
    </style>

</head>
<body>
<div id="page-wrapper">
    <%--heder--%>
    <%@include file="/WEB-INF/include/menu.jsp"%>

    <section id="features">
        <div class="container">
            <div class="row aln-center">
                <table class="table table-bordered">
                    <thead>
                    <h2 style="margin-bottom: 0px" > 입후보 등록 </h2>
                    </thead>

                    <tbody>
                    <form action="/register" id="candiRegist" name="candiRegist" method="post" encType="multiplart/form-data">
                        <tr>
                            <th>선거 종류 선택 </th>
                            <td colspan="4">
                                <select class="form-control" id="electionIdx" name="electionIdx" style="width:25%">
                                    <option value="1"
                                            <c:if test="${electionIdx == 1}">selected</c:if>>총학생회
                                    </option>
                                    <option value="2"
                                            <c:if test="${electionIdx == 2}">selected</c:if>>학부대표
                                    </option>
                                    <option value="3"
                                            <c:if test="${electionIdx == 3}">selected</c:if>>전공대표
                                    </option>
                                </select>
                            </td>
                        </tr>
                        <tr>
                            <th>팀이름: </th>
                            <td colspan="4"><input type="text" placeholder="팀이름을 입력하세요 " id="name" name="name" class="form-control"/></td>
                        </tr>
                        <tr>
                            <th>정후보 학번: </th>
                            <td><input type="text" id = "candidate1idx" name="candidate1idx" class="form-control"/></td>
                            <th>부후보 학번: </th>
                            <td><input type="text" id = "candidate2idx" name="candidate2idx" class="form-control"/></td>
                        </tr>
                        <tr>
                            <th>정후보사진: </th>
                            <td><input type="file" placeholder="파일을 선택하세요." id = "profileUrl1" name="profileUrl1" class="form-control" /></td>

                            <th>부후보사진: </th>
                            <td><input type="file" placeholder="파일을 선택하세요." id = "profileUrl2" name="profileUrl2"  class="form-control"  /></td>
                        </tr>
                        <tr>
                            <th>공약: </th>
                            <td colspan = '4'><input type="file" placeholder="파일을 선택하세요." id = "pledge" name="pledge" class="form-control" /></td>
                            <td colspan = '3'></td>
                        </tr>

                        <tr>
                            <th>추천서: </th>
                            <td><input type="file" placeholder="파일을 선택하세요. " name="reccoPhotoUrl" id= "reccoPhotoUrl" class="form-control"/></td>
                            <th>선거 운동 본부원 명단: </th>
                            <td><input type="file" placeholder="파일을 선택하세요. " name="electioneeringFileUrl" id= "electioneeringFileUrl" class="form-control"/></td>
                        </tr>

                        <tr>
                            <th>팀 사진: </th>
                            <td><input type="file" placeholder="파일을 선택하세요. " name="teamPhotoUrl" id="teamPhotoUrl" class="form-control"/></td>
                            <th>선거 서약서 사진: </th>
                            <td><input type="file" placeholder="파일을 선택하세요. " name="oathPhotoUrl" id="oathPhotoUrl" class="form-control"/></td>

                        </tr>
                        <tr>
                            <th>정후보 재학증명서: </th>
                            <td><input type="file" placeholder="파일을 선택하세요. " name="candidate1CertiUrl" id="candidate1CertiUrl" class="form-control"/></td>
                            <th>부후보 재학증명서: </th>
                            <td><input type="file" placeholder="파일을 선택하세요. " name="candidate2CertiUrl" id="candidate2CertiUrl" class="form-control"/></td>

                            <br>

                        </tr>

                        <td colspan="4">
<%--                            <button type="button" id ="createRegister" class="pull-right" style="margin-bottom: 30px">등록</button>--%>
                            <button type="button" onclick="candiRegister(candiRegist)" class="pull-right" style="margin-bottom: 10px">등록</button>

                        </td>
                    </form>
                    </tbody>
                </table>
            </div>
        </div>
    </section>
    <!-- Footer -->
    <%@include file="/WEB-INF/include/footer.jsp"%>

</div>
<script>

    function candiRegister(form){
        if (confirm('선거 후보 등록을 하시겠습니까?') == true) {
            form.submit();
        }
        else
            return false;
    }
    //
    // $(function(){
    //     $("#createRegister").click(function(){
    //         $.ajax({
    //             url : "register",
    //             type : "POST",
    //             contentType: 'application/json',
    //             data : JSON.stringify({
    //                 electionIdx : $("#electionIdx").val(),
    //                 name : $("#teamName").val(),
    //                 candidate1idx : $("#candidate1idx").val(),
    //                 candidate2idx : $("#candidate2idx").val(),
    //                 pledge : $("#pledge").val(),
    //                 reccoPhotoUrl : $("#reccoPhotoUrl").val(),
    //                 electioneeringFileUrl : $("#electioneeringFileUrl").val(),
    //                 teamPhotoUrl : $("#teamPhotoUrl").val(),
    //                 oathPhotoUrl : $("#oathPhotoUrl").val(),
    //                 candidate1CertiUrl : $("#candidate1CertiUrl").val(),
    //                 candidate2CertiUrl : $("#candidate2CertiUrl").val()
    //             }),
    //         })
    //     });
    // })
</script>
</body>
</html>