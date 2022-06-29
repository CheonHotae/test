<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>SB Admin 2 - Dashboard</title>

<!-- Custom fonts for this template-->
<link
	href="${pageContext.request.contextPath }/resources/vendor/fontawesome-free/css/all.min.css"
	rel="stylesheet" type="text/css">
<link
	href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
	rel="stylesheet">

<!-- Custom styles for this template-->
<link
	href="${pageContext.request.contextPath }/resources/css/sb-admin-2.min.css"
	rel="stylesheet">

</head>

<body id="page-top">

	<!-- Page Wrapper -->
	<div id="wrapper">

		<!-- Sidebar -->
		<%@ include file="/WEB-INF/views/includes/SideBar.jsp"%>
		<!-- End of Sidebar -->

		<!-- Content Wrapper -->
		<div id="content-wrapper" class="d-flex flex-column">

			<!-- Main Content -->
			<div id="content">

				<!-- Topbar -->
				<%@ include file="/WEB-INF/views/includes/TopBar.jsp"%>
				<!-- End of Topbar -->

				<!-- Begin Page Content -->
				<div class="container-fluid">

					<!-- Page Heading -->
					<div
						class="d-sm-flex align-items-center justify-content-between mb-4">
						<h1 class="h3 mb-0 text-gray-800">회원가입 페이지-MemberJoinForm.jsp</h1>
						<a href="#"
							class="d-none d-sm-inline-block btn btn-sm btn-primary shadow-sm"><i
							class="fas fa-download fa-sm text-white-50"></i> Generate Report</a>
					</div>

					<!-- Content Row 회원가입 양식 시작-->
					<div class="row">
						<!-- <div class="col-lg-5 d-none d-lg-block bg-register-image"></div> -->
						<div class="col-lg-12 ml-auto mr=auto" style="background-color: white;">
							<div class="p-5">
								<div class="text-center">
									<h1 class="h4 text-gray-900 mb-4">★회원가입★</h1>
								</div>
								<form class="user" action="memberJoin" method="post" enctype="multipart/form-data" onsubmit="return joinFormCheck()">
									
									<div class="form-group row">
										<div class="col-sm-6 mb-3 mb-sm-0">
											<label for="inputMid">아이디</label>
											<input type="text" class="form-control form-control-user"
												id="inputMid" name="mid" placeholder="아이디입력.." >
												<span id="idCheckMgs"></span>
										</div>
										<div class="col-sm-6">
										<label for="inputName">이름</label>
											<input type="text" class="form-control form-control-user"
												id="inputName" name="mname" placeholder="이름입력.." >
										</div>
									</div>
									
									
									<div class="form-group">
									<div class="col-sm-9">
									<label for="inputMemail">이메일</label>
										<input type="email" class="form-control form-control-user"
											id="inputMemail" name="memail" placeholder="이메일 입력 ..">
									</div>
									</div>
									
									<div class="form-group row">
										<div class="col-sm-3">
											<label for="inputMid">생년월일</label>
											<input type="date" class="form-control form-control-user"
												id="inputMbirth" name="mbirth">
									</div>
									</div>
									
									<div class="form-group row">
									<!-- mb = margin-bottom / mt = margin-top -->
										<div class="col-sm-6 mb-3 mb-sm-0"> 
									<label for="inputMpw">비밀번호</label>
											<input type="password" class="form-control form-control-user"
												id="inputMpw" name="mpw" placeholder="비밀번호 입력.." >
										</div>
										
										<div class="form-group row">
										<div class="col-sm-6">
										<label for="inputMaddr">주소</label>
										<input type="button" name="maddress" class="h4 btn btn-primary btn-user btn-block" onclick="sample6_execDaumPostcode()" value="우편번호 찾기"><br>
										</div>
										<br>
										
										<div class="col-sm-6">
										<br>
										<input type="text" name="mpostcode" class="form-control form-control-user" id="sample6_postcode" placeholder="우편번호"><br>
										</div>
										<br>
										
										<div class="col-sm-6">
										<input type="text" name="maddr" class="form-control form-control-user" id="sample6_address" placeholder="주소" ><br>
										</div>
										<br>
										
										<div class="col-sm-6">
										<input type="text" name="mdetailAddress" class="form-control form-control-user" id="sample6_detailAddress" placeholder="상세주소">
										</div>
										<br>
										<div class="col-sm-6">
										<input type="text" name="mextraaddr" class="form-control form-control-user" id="sample6_extraAddress" placeholder="참고항목">
										</div>
										<br>
										
										</div>
										<div class="col-sm-9">
										<label for="inputMprofile">프로필이미지</label>
										<input type="file" name="mfile" style="height:48px;" class="form-control form-control-user" id="mprofile" placeholder="파일 선택">
										</div>
									</div>
									<button type="submit" class="h4 btn btn-primary btn-user btn-block">
										회원가입</button>
									<hr>
									
								</form>
								<hr>
								<div class="text-center">
									<a class="small" href="forgot-password.html">Forgot
										Password?</a>
								</div>
								<div class="text-center">
									<a class="small" href="login.html">Already have an account?
										Login!</a>
								</div>
							</div>
						</div>
					</div>


					<!-- Content Row -->

					<!-- Content Row -->

				</div>
				<!-- /.container-fluid -->

			</div>
			<!-- End of Main Content -->

			<!-- Footer -->
			<footer class="sticky-footer bg-white">
				<div class="container my-auto">
					<div class="copyright text-center my-auto">
						<span>Copyright &copy; Your Website 2021</span>
					</div>
				</div>
			</footer>
			<!-- End of Footer -->

		</div>
		<!-- End of Content Wrapper -->

	</div>
	<!-- End of Page Wrapper -->

	<!-- Scroll to Top Button-->
	<a class="scroll-to-top rounded" href="#page-top"> <i
		class="fas fa-angle-up"></i>
	</a>



	<!-- Bootstrap core JavaScript-->
	<script
		src="${pageContext.request.contextPath }/resources/vendor/jquery/jquery.min.js"></script>
	<script
		src="${pageContext.request.contextPath }/resources/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

	<!-- Core plugin JavaScript-->
	<script
		src="${pageContext.request.contextPath }/resources/vendor/jquery-easing/jquery.easing.min.js"></script>

	<!-- Custom scripts for all pages-->
	<script
		src="${pageContext.request.contextPath }/resources/js/sb-admin-2.min.js"></script>

	<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
	<script src="${pageContext.request.contextPath }/resources/MemberJs/daumPostCode.js"></script>
	
	<!-- 아이디 중복 확인  -->
	<script type="text/javascript">
	var inputIdCheck =  false;
	$(document).ready(function(){
		console.log("스크립트 확인!");
		$("#inputMid").focusout(function(){
			var inputId = $("#inputMid").val();
			console.log("inputId : " + inputId);
			
			if(inputId.length == 0 ){
				$("#idCheckMgs").text("아이디를 입력해주세요.").css("color","red")
				
			}else{
				
				//데이터만 넘겨주는 ajax 
				$.ajax({
					type : "get",
					url : "memberIdCheck",
					data : {"inputId" : inputId},
					success : function(result){
							console.log("result : " + result);
						
						if(result != inputId){
						$("#idCheckMgs").text("사용가능한 아이디 입니다.").css("color","gold")			
						inputIdCheck = true;
						}else{
						$("#idCheckMgs").text("이미 사용중인 아이디 입니다.").css("color","red")
						inputIdCheck = false;
						}
						
					}
					
				});
			}
			
		
		})
			
	
		
	});
	
	</script>
	
<script type="text/javascript">

	function joinFormCheck(){
		
		//아이디 입력 확인
		if(!inputIdCheck){
			alert("아이디를 입력해주세요!");
			$("#inputMid").focus();
			return false;
			}
		
		
		
		//비밀번호 입력 확인
		var inputPw = $("#inputPw").val();
		if(inputPw.length == 0){
			alert("비밀번호를 입력해주세요!");
			$("#inputMpw").focus();
			return false;
		}
		
		//이름 입력 확인 
		if($("#inputname").val().length ==0){
			alert("이름을 입력해주세요!");
			$("#inputMname").focus();
			return false;
		}
			
	}	
		
</script>	
</body>

</html>