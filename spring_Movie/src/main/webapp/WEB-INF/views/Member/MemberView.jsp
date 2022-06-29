<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
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

<body>

	<%@ include file="../includes/TopBar.jsp"%>
	<div class="row">
		<%@ include file="../includes/SideBar.jsp"%>
		<div class="col-xl-4">
			<!-- Profile picture card-->
			<div class="card mb-4 mb-xl-0">
				<div class="card-header">프로필 이미지</div>
				<div class="card-body text-center">
					<!-- Profile picture image-->
					<img class="img-account-profile rounded-circle mb-2"
						src="${pageContext.request.contextPath }/resources/mprofileUpLoad/${sessionScope.myprofile}"
						alt="">
					<!-- Profile picture help block-->
				
				</div>
			</div>
		</div>
		<div class="col-xl-6">
			<!-- Account details card-->
			<div class="card mb-4">
				<div class="card-header">내정보</div>
				<div class="card-body">

					<!-- Form Group (username)-->
					<div class="mb-3">
						<label class="small mb-1" for="inputUsername">my 아이디 </label> <input
							class="form-control" id="inputUsername" type="text"
							placeholder="Enter your username" value="${sessionScope.myid }" readonly="readonly">
					</div>
					<!-- Form Row-->
					<div class="row gx-3 mb-3">
						<!-- Form Group (first name)-->
						<div class="col-md-6">
							<label class="small mb-1" for="inputFirstName">my 비밀번호</label> <input
								class="form-control" id="inputFirstName" type="text"
								placeholder="Enter your first name"
								value="${sessionScope.mypw }" readonly="readonly">
						</div>
						<!-- Form Group (last name)-->

					</div>
					<!-- Form Row        -->
					<div class="row gx-3 mb-3">
						<!-- Form Group (organization name)-->
						<div class="col-md-6">
							<label class="small mb-1" for="inputOrgName">my 이름</label> <input
								class="form-control" id="inputOrgName" type="text"
								placeholder="Enter your organization name"
								value="${sessionScope.myname }" readonly="readonly">
						</div>
						<!-- Form Group (location)-->

					</div>
					<!-- Form Group (email address)-->
					<div class="mb-3">
						<label class="small mb-1" for="inputEmailAddress">my 주소</label> <input
							class="form-control" id="inputEmailAddress" type="email"
							placeholder="Enter your email address"
							value="${sessionScope.myaddress }" readonly="readonly">
					</div>
					<!-- Form Row-->
					<div class="row gx-3 mb-3">
						<!-- Form Group (phone number)-->

						<!-- Form Group (birthday)-->
						<div class="col-md-6">
							<label class="small mb-1" for="inputBirthday">my 생일</label> <input
								class="form-control" id="inputBirthday" type="text"
								name="birthday" placeholder="Enter your birthday"
								value="${sessionScope.mybirth }" readonly="readonly">
						</div>

						<div class="col-md-6">
							<label class="small mb-1" for="inputBirthday">my 이메일</label> <input
								class="form-control" id="inputBirthday" type="text"
								name="birthday" placeholder="Enter your birthday"
								value="${sessionScope.myemail }" readonly="readonly">
						</div>
					</div>
					<!-- Save changes button-->


				</div>
			</div>
		</div>
	</div>

</body>
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

</html>