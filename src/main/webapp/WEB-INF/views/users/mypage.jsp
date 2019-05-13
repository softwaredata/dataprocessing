<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0"/ -->
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>mypage</title>
<!-- Bootstrap -->
<link href="resources/bootstrap/css/bootstrap.css" rel="stylesheet"
	type="text/css" />
<link rel="stylesheet" href="resources/bootstrap/css/mypage.css">
<!-- jQuery (부트스트랩의 자바스크립트 플러그인을 위해 필요한) -->
<script src="${R}https://code.jquery.com/jquery.js"></script>
<!-- 모든 합쳐진 플러그인을 포함하거나 (아래) 필요한 각각의 파일들을 포함하세요 -->
<script src="${R}resources/bootstrap/js/bootstrap.min.js"></script>
<!-- Respond.js 으로 IE8 에서 반응형 기능을 활성화하세요 (https://github.com/scottjehl/Respond) -->
<script src="${R}resources/bootstrap/js/respond.js"></script>
</head>
<body>


	<!--// 헤더 들어가는 부분 -->
	<!-- 모달창 -->
	<div class="modal fade" id="defaultModal">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">×</button>
					<h4 class="modal-title">알림</h4>
				</div>
				<div class="modal-body">
					<p class="modal-contents"></p>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">닫기</button>
				</div>
			</div>
			<!-- /.modal-content -->
		</div>
		<!-- /.modal-dialog -->
	</div>
	<!-- /.modal -->
	<!--// 모달창 -->
	<hr />
	<!-- 본문 들어가는 부분 -->


	<div id="container">
		<form class="form-horizontal" role="form" method="post"
			action="javascript:alert( 'success!' );">

			<fieldset>
				<div class="form-group" id="divId">
					<!-- 나중에 못 바꾸게 하기~ -->
					<div class='kickass_field'>
						<input maxlength='30' required='required' type="text"
							class="form-control onlyAlphabetAndNumber" id="id"
							data-rule-required="true">
						<lable for="inputId"> 아이디 </lable>
					</div>
				</div>


				<div class="form-group" id="divPassword">
					<div class='kickass_field'>

						<input maxlength='30' required='required' type="password"
							class="form-control" id="password" name="excludeHangul"
							data-rule-required="true" placeholder="비밀번호 입력">
						<lable for="inputPassword"> 비밀번호 </lable>
					</div>
				</div>

				<div class="form-group" id="divPasswordCheck">
					<div class='kickass_field'>

						<input required='required' type="password" class="form-control"
							id="passwordCheck" data-rule-required="true"
							placeholder="비밀번호를 한번 더 입력해주세요" maxlength="30">
						<lable for="inputPasswordCheck"> 비밀번호확인 </lable>
					</div>
				</div>


				<div class="form-group" id="divName"><!-- value값 이름으로 하기  -->
					<div class='kickass_field'>
						<input required='required'
							type="text" class="form-control onlyHangul" id="name"
							data-rule-required="true" placeholder="한글만 입력 가능합니다."
							maxlength="15">
							<lable for="inputName"> 이름 </lable>
					</div>
				</div>

				<div class="form-group" id="divEmail">
					<!-- 학내 메일을 사용하기  -->
					<div class='kickass_field'>
						<input required='required' type="email" class="form-control" id="email"
							data-rule-required="true" placeholder="이메일" maxlength="40">
							
							<lable for="inputEmail">이메일 </lable>
					</div>
				</div>
				
				<div class="form-group" id="divPhoneNumber"><!-- value값 핸드폰 번호 불러오기 -->
				<div class='kickass_field'>
						<input required='required' type="tel" class="form-control onlyNumber" id="phoneNumber"
							data-rule-required="true" placeholder="-를 제외하고 숫자만 입력하세요."
							maxlength="11">
							<lable for="inputPhoneNumber">핸드폰 번호  </lable>
					</div>
				</div>
				<div class="form-group">
					<label for="inputMajor" class="col-lg-2 control-label">학과</label>
					<div class="col-lg-10">
						<select class="form-control" id="gender">
							<option value="M">남</option>
							<option value="F">여</option>
						</select>
					</div>
				</div>

				<div class="form-group">
					<div class="col-lg-offset-2 col-lg-10">
						<button type="submit" class="btn btn-default">Sign in</button>
					</div>
				</div>
			</fieldset>
		</form>
	</div>



	<script>
		$(function() {
			//모달을 전역변수로 선언
			var modalContents = $(".modal-contents");
			var modal = $("#defaultModal");

			$('.onlyAlphabetAndNumber').keyup(function(event) {
				if (!(event.keyCode >= 37 && event.keyCode <= 40)) {
					var inputVal = $(this).val();
					$(this).val($(this).val().replace(/[^_a-z0-9]/gi, '')); //_(underscore), 영어, 숫자만 가능
				}
			});

			$(".onlyHangul").keyup(function(event) {
				if (!(event.keyCode >= 37 && event.keyCode <= 40)) {
					var inputVal = $(this).val();
					$(this).val(inputVal.replace(/[a-z0-9]/gi, ''));
				}
			});

			$(".onlyNumber").keyup(function(event) {
				if (!(event.keyCode >= 37 && event.keyCode <= 40)) {
					var inputVal = $(this).val();
					$(this).val(inputVal.replace(/[^0-9]/gi, ''));
				}
			});

			//------- 검사하여 상태를 class에 적용
			$('#id').keyup(function(event) {

				var divId = $('#divId');

				if ($('#id').val() == "") {
					divId.removeClass("has-success");
					divId.addClass("has-error");
				} else {
					divId.removeClass("has-error");
					divId.addClass("has-success");
				}
			});

			$('#password').keyup(function(event) {

				var divPassword = $('#divPassword');

				if ($('#password').val() == "") {
					divPassword.removeClass("has-success");
					divPassword.addClass("has-error");
				} else {
					divPassword.removeClass("has-error");
					divPassword.addClass("has-success");
				}
			});

			$('#passwordCheck').keyup(function(event) {

				var passwordCheck = $('#passwordCheck').val();
				var password = $('#password').val();
				var divPasswordCheck = $('#divPasswordCheck');

				if ((passwordCheck == "") || (password != passwordCheck)) {
					divPasswordCheck.removeClass("has-success");
					divPasswordCheck.addClass("has-error");
				} else {
					divPasswordCheck.removeClass("has-error");
					divPasswordCheck.addClass("has-success");
				}
			});

			$('#name').keyup(function(event) {

				var divName = $('#divName');

				if ($.trim($('#name').val()) == "") {
					divName.removeClass("has-success");
					divName.addClass("has-error");
				} else {
					divName.removeClass("has-error");
					divName.addClass("has-success");
				}
			});

			$('#email').keyup(function(event) {

				var divEmail = $('#divEmail');

				if ($.trim($('#email').val()) == "") {
					divEmail.removeClass("has-success");
					divEmail.addClass("has-error");
				} else {
					divEmail.removeClass("has-error");
					divEmail.addClass("has-success");
				}
			});

			$('#phoneNumber').keyup(function(event) {

				var divPhoneNumber = $('#divPhoneNumber');

				if ($.trim($('#phoneNumber').val()) == "") {
					divPhoneNumber.removeClass("has-success");
					divPhoneNumber.addClass("has-error");
				} else {
					divPhoneNumber.removeClass("has-error");
					divPhoneNumber.addClass("has-success");
				}
			});

			//------- validation 검사
			$("form").submit(
					function(event) {

						var divId = $('#divId');
						var divPassword = $('#divPassword');
						var divPasswordCheck = $('#divPasswordCheck');
						var divName = $('#divName');
						var divEmail = $('#divEmail');
						var divPhoneNumber = $('#divPhoneNumber');

						//아이디 검사
						if ($('#id').val() == "") {
							modalContents.text("아이디를 입력하여 주시기 바랍니다.");
							modal.modal('show');

							divId.removeClass("has-success");
							divId.addClass("has-error");
							$('#id').focus();
							return false;
						} else {
							divId.removeClass("has-error");
							divId.addClass("has-success");
						}

						//패스워드 검사
						if ($('#password').val() == "") {
							modalContents.text("패스워드를 입력하여 주시기 바랍니다.");
							modal.modal('show');

							divPassword.removeClass("has-success");
							divPassword.addClass("has-error");
							$('#password').focus();
							return false;
						} else {
							divPassword.removeClass("has-error");
							divPassword.addClass("has-success");
						}

						//패스워드 확인
						if ($('#passwordCheck').val() == "") {
							modalContents.text("패스워드 확인을 입력하여 주시기 바랍니다.");
							modal.modal('show');

							divPasswordCheck.removeClass("has-success");
							divPasswordCheck.addClass("has-error");
							$('#passwordCheck').focus();
							return false;
						} else {
							divPasswordCheck.removeClass("has-error");
							divPasswordCheck.addClass("has-success");
						}

						//패스워드 비교
						if ($('#password').val() != $('#passwordCheck').val()
								|| $('#passwordCheck').val() == "") {
							modalContents.text("패스워드가 일치하지 않습니다.");
							modal.modal('show');

							divPasswordCheck.removeClass("has-success");
							divPasswordCheck.addClass("has-error");
							$('#passwordCheck').focus();
							return false;
						} else {
							divPasswordCheck.removeClass("has-error");
							divPasswordCheck.addClass("has-success");
						}

						//이름
						if ($('#name').val() == "") {
							modalContents.text("이름을 입력하여 주시기 바랍니다.");
							modal.modal('show');

							divName.removeClass("has-success");
							divName.addClass("has-error");
							$('#name').focus();
							return false;
						} else {
							divName.removeClass("has-error");
							divName.addClass("has-success");
						}

						//이메일
						if ($('#email').val() == "") {
							modalContents.text("이메일을 입력하여 주시기 바랍니다.");
							modal.modal('show');

							divEmail.removeClass("has-success");
							divEmail.addClass("has-error");
							$('#email').focus();
							return false;
						} else {
							divEmail.removeClass("has-error");
							divEmail.addClass("has-success");
						}

						//휴대폰 번호
						if ($('#phoneNumber').val() == "") {
							modalContents.text("휴대폰 번호를 입력하여 주시기 바랍니다.");
							modal.modal('show');

							divPhoneNumber.removeClass("has-success");
							divPhoneNumber.addClass("has-error");
							$('#phoneNumber').focus();
							return false;
						} else {
							divPhoneNumber.removeClass("has-error");
							divPhoneNumber.addClass("has-success");
						}

					});

		});
	</script>
	<!--// 본문 들어가는 부분 -->
	<hr />
	<!-- 푸터 들어가는 부분 -->

	<!--// 푸터 들어가는 부분 -->

</body>
</html>