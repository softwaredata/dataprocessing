<%@ page contentType="text/html; charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="https://unpkg.com/bootstrap/dist/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://unpkg.com/bootstrap-vue@latest/dist/bootstrap-vue.css">
    <script src="https://unpkg.com/babel-polyfill@latest/dist/polyfill.min.js"></script>
    <script src="https://unpkg.com/bootstrap-vue@latest/dist/bootstrap-vue.js"></script>
    <script src="https://unpkg.com/axios/dist/axios.min.js"></script>
    <script src="https://unpkg.com/vue"></script>
    <script src="login.js"></script>
    <title>성공회대 투표 시스템</title>
</head>
<body>
<form name="frm" action="login" method="post">
    <div id="app">
        <b-container>
            <b-jumbotron header="SKHU VOTE">
                <p class="lead">성공회대학교 투표 서비스</p>
            </b-jumbotron>

            <b-form-group horizontal :label-cols="3" description="학번을 입력하세요" label="ID(학번)">
                <b-form-input v-model.trim="userId" name="id"></b-form-input>
            </b-form-group>
            <b-form-group horizontal :label-cols="3" description="비밀번호를 입력하세요." label="Password">
                <input type="password" name="password" v-model.trim="password" class="form-control">
            </b-form-group>

            <b-alert variant="danger" :show="showAlert">{{ errMsg }}</b-alert>
            <b-btn variant="primary" @click="jssubmit">Login</b-btn>

            <div class="pull-right">
                <br/>
                <b-btn variant="outline-primary" @click="singUp">회원가입</b-btn>
                <b-btn variant="outline-primary" @click="findPass">비밀번호찾기</b-btn>
            </div>
        </b-container>
    </div>
</form>
</body>
</html>
