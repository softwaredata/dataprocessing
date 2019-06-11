<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Write something else you want</title>
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
</head>
<body>
<div class="container">
    <%@include file="/WEB-INF/include/header.jsp"%>
    <table class="table table-bordered">
        <thead>
        <h2> 입후보 등록 </h2>
        </thead>
        <tbody>
        <form action="write_ok.jsp" method="post" encType="multiplart/form-data">
           <table border="1">
            <tr>
                <th>회장 후보 학번 </th>
                <td><input type="text" name="subject" class="form-control"/></td>
                <th>부회장 후보 학번</th>
                <td><input type="text" name="subject" class="form-control"/></td>
            </tr>



            <tr>
                <th>내용: </th>
                <td><textarea colspan="20" rows="10" placeholder="내용을 입력하세요. " name="content" class="form-control"></textarea></td>
            </tr>
            <tr>
                <th>첨부파일: </th>
                <td><input type="text" placeholder="파일을 선택하세요. " name="filename" class="form-control"/></td>
            </tr>
           </table>
                <td colspan="2">
                    <input type="button"  value="등록" onclick="sendData()" class="pull-right"/>
                    <input type="button" value="reset" class="pull-left"/>
                    <input type="button" value="글 목록으로... " class="pull-right" onclick="javascript:location.href='list.jsp'"/>
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
