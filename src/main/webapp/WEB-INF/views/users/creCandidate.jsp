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
<div class="container">
    <%@include file="/WEB-INF/include/menu.jsp"%>
    <table class="table table-bordered">
        <thead>
        <h2 style="margin-bottom: 0px" > 입후보 등록 </h2>
        </thead>

        <tbody>
        <form action="write_ok.jsp" method="post" encType="multiplart/form-data">

            <tr>
                <th>정후보 학번: </th>
                <td><input type="text" id = "candidate1_idx" name="subject" class="form-control"/></td>
                <th>부후보 학번: </th>
                <td><input type="text" id = "candidate2_idx" name="subject" class="form-control"/></td>
            </tr>
            <tr>
                <th>팀이름: </th>
                <td colspan="4"><input type="text" placeholder="팀이름을 입력하세요 " id="name" name="name" class="form-control"/></td>
            </tr>



            <tr>
                <th>공약: </th>
                <td colspan = '4'><input type="file" placeholder="파일을 선택하세요." id = "pledge" placeholder="내용을 입력하세요. " name="pledge" class="form-control"/></td>
            </tr>

            <tr>
                <th>추천서: </th>
                <td><input type="file" placeholder="파일을 선택하세요. " name="recco_photo_url" id= "recco_photo_url" class="form-control"/></td>
                <th>선거 운동 본부원 명단: </th>
                <td><input type="file" placeholder="파일을 선택하세요. " name="electioneering_file_url" id= "electioneering_file_url" class="form-control"/></td>
            </tr>

            <tr>
                <th>팀 사진: </th>
                <td><input type="file" placeholder="파일을 선택하세요. " name="team_photo_url" id="team_photo_url" class="form-control"/></td>
                <th>선거 서약서 사진: </th>
                <td><input type="file" placeholder="파일을 선택하세요. " name="oath_photo_url" id="oath_photo_url" class="form-control"/></td>

            </tr>
            <tr>
                <th>정후보 재학증명서: </th>
                <td><input type="file" placeholder="파일을 선택하세요. " name="candidate1_certi_url" id="candidate1_certi_url" class="form-control"/></td>
                <th>부후보 재학증명서: </th>
                <td><input type="file" placeholder="파일을 선택하세요. " name="candidate2_certi_url" id="candidate2_certi_url" class="form-control"/></td>

            <br>

            </tr>
           </table>
                <td colspan="2">
                    <input type="submit"  value="등록" onclick="sendData()" class="pull-right" style="margin-bottom: 30px"/>
                    <!-- <a class="btn btn-default" onclick="sendData()"> 등록 </a>
                    <a class="btn btn-default" type="reset"> reset </a>
                    <a class="btn btn-default" onclick="javascript:location.href='list.jsp'">글 목록으로...</a> -->
                </td>
            </tr>

        </form>
        </tbody>
    </table>
</div>
</body>
</html>
