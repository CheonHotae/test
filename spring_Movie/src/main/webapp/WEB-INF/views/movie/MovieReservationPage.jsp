<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">


<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>SB Admin 2 - Dashboard</title>

    <!-- Custom fonts for this template-->
    <link href="${pageContext.request.contextPath }/resources/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
    <link
        href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
        rel="stylesheet">

    <!-- Custom styles for this template-->
    <link href="${pageContext.request.contextPath }/resources/css/sb-admin-2.min.css" rel="stylesheet">

</head>
<style>
.scTimeBtn{
border: 1px solid black;
}
</style>


<body id="page-top">

    <!-- Page Wrapper -->
    <div id="wrapper">

        <!-- Sidebar -->
       <%@ include file ="../includes/SideBar.jsp" %>
        <!-- End of Sidebar -->

        <!-- Content Wrapper -->
        <div id="content-wrapper" class="d-flex flex-column">

            <!-- Main Content -->
            <div id="content">

                <!-- Topbar -->
                <%@ include file ="../includes/TopBar.jsp" %>
                <!-- End of Topbar -->

                <!-- Begin Page Content -->
                <div class="container-fluid">

                    <!-- Page Heading -->
                    <div class="d-sm-flex align-items-center justify-content-between mb-4">
                        <h1 class="h3 mb-0 text-gray-800">영화예매 페이지-MovieReservationPage.jsp</h1>
                        
                    </div>
						
                    <!-- 영화, 극장, 날짜 및 시간 , 상영관 선택 -->
 						<div class="row text-gray-900 text-lg">
 							<div  class="col-3 "   style="overflow:scroll; width:700px; height:300px;" >
 								<div class="h3 mb-0 text-gray-800">
 								영화 
 								</div>
 								<div class="card-body" id="mvList">
 								<c:forEach items="${reMvList}" var="mvList">
 								
 								<div  id="${mvList.mvcode}" onclick="mvSelect(this,'${mvList.mvcode}' ,'${mvList.mvposter }' )">${mvList.mvname }</div><br>
 								</c:forEach>
 								</div>
 							</div>
 							<div class="col-3" style="overflow:scroll; width:700px; height:300px;">
 								극장
 								<div class="card-body listArea text-gray-900" id="thList">
 									
 								</div>
 							</div>
 							<div class="col-3" style="overflow:scroll; width:700px; height:300px;">
 								날짜 
 								<div class="card-body listArea text-gray-900" id="scDateList">
 								</div>
 							</div>
 							<div class="col-3 ">
 								상영관 및 시간
 								
 								<div class="card-body listArea text-gray-900" id="scRoomTime"></div>
 								
 								
 							</div>
 						</div>
                    <!-- 선택 항목 확인 -->
						<div class="row text-gray-900 text-lg">
							<div class="col-3 bg-gradient-success">
								<div class="card mb-2">
									<div class="card-body">
										<img class="img-fluid" alt="" src=" " id="viewSelMvposter">
										<div class="p-2 font-weight-bold text-lg" id="viewSelMvname"></div>
									</div>
								</div>
								
							</div>
							<div class="col-3 bg-gradient-light">																
								 <div class="p-2 font-weight-bold text-lg " id="selThname" ></div>
								  <div class="p-2 font-weight-bold text-lg " id="selScdate" ></div>
								  <div class="p-2 font-weight-bold text-lg " id="selRoomTime" ></div>
								   <div class="p-2 font-weight-bold text-lg " id="selroom" ></div>
								   <div class="p-2 font-weight-bold text-lg " id="viewnum" ></div>
								  
							</div>
							<div class="col-3 " >
								인원 선택
								<div id="selbutton"> 
									<button class="btn btn-sm font-weight-bold ml-1 my-2 mr-1 scTimeBtn px-3 py-2" onclick="peopleSelect(this)">1</button>
									<button class="btn btn-sm font-weight-bold ml-1 my-2 mr-1 scTimeBtn px-3 py-2" onclick="peopleSelect(this)">2</button>
									<button class="btn btn-sm font-weight-bold ml-1 my-2 mr-1 scTimeBtn px-3 py-2" onclick="peopleSelect(this)">3</button>
									<button class="btn btn-sm font-weight-bold ml-1 my-2 mr-1 scTimeBtn px-3 py-2" onclick="peopleSelect(this)">4</button>
									<button class="btn btn-sm font-weight-bold ml-1 my-2 mr-1 scTimeBtn px-3 py-2" onclick="peopleSelect(this)">5</button>
									
								</div>
							</div>
							
							
							<div class="col-3 ">
								<div class="card-body bg-gradient-light">
									<form action="movieReservation" method="post" onsubmit="return reservationFormCheck();">
										<input type="text" name="remid" id="remid" value="${sessionScope.loginId}" >
										<input type="text" name="rescthcode" id="rescthcode" placeholder="극장코드">
										<input type="text" name="rescroom" id="rescroom" placeholder="상영관">
										<input type="text" name="rescdate" id="rescdate" placeholder="날짜및시간">
										<input type="text" name="reamount" id="reamount" placeholder="인원수">
										<input class="btn-sm btn-danger" type="submit" value="예매하기">
										
										
									
									</form>
								
								</div>
							</div>
						</div>
                    <!-- Content Row -->
                  
                </div>
                <!-- /.container-fluid -->

            </div>
            <!-- End of Main Content -->

            <!-- Footer -->
          
            <!-- End of Footer -->

        </div>
        <!-- End of Content Wrapper -->

    </div>
    <!-- End of Page Wrapper -->

    <!-- Scroll to Top Button-->
    <a class="scroll-to-top rounded" href="#page-top">
        <i class="fas fa-angle-up"></i>
    </a>

   

    <!-- Bootstrap core JavaScript-->
    <script src="${pageContext.request.contextPath }/resources/vendor/jquery/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath }/resources/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

    <!-- Core plugin JavaScript-->
    <script src="${pageContext.request.contextPath }/resources/vendor/jquery-easing/jquery.easing.min.js"></script>

    <!-- Custom scripts for all pages-->
    <script src="${pageContext.request.contextPath }/resources/js/sb-admin-2.min.js"></script>

<script type="text/javascript">
	var checkMsg = '${msg}';
	if(checkMsg.length > 0){
		alert(checkMsg);
	}
	
</script>

<script type="text/javascript">

	var loginCheck = '${sessionScope.loginId}';
	if(loginCheck.length == 0){
		alert("로그인 후 이용 가능합니다.")
		location.href="memberLoginForm";
	}
	

</script>
	
<script type="text/javascript">
	
	var selectReMvcode = ""; //선택한 영화 코드
	var selectReThcode = ""; //선택한 극장 코드
	var Redate = "";
	
	
	function mvSelect(selObj , selMvcode,selMvposter){
		selectReMvcode = selMvcode;
		$("#remid").val(loginCheck);
		//선택 내용 초기화
		
		$("#viewSelMvname").text("");
		
		$("#selThname").text("");
		
		$("#scDateList").html("");
		
		$("#selScdate").text("");
		
		$("#selRoomTime").text("");
		
		$("#mvList div").css("background-color","").css("color","");
		$(selObj).css("background-color","gold").css("color","white");
		console.log("선택 영화 코드 : " + selMvcode);
		/*극장 목록 조회 및 출력 */
		
		var output = "";
		$.ajax({
			type: "get",
			url : "getThList",
			data : {"mvcode" : selMvcode},
			dataType : "json",
			async : false,
			success : function(thList){
				console.log(thList)
				
				for(var i = 0; i < thList.length; i++){
					console.log(thList[i].thname);
					output += "<div class=\"p-2 font-weight-bold text-lg\" onclick=\"thSelect(this,'"+ thList[i].thcode +"')\">"+thList[i].thname+"</div>"
				}
			}
			
		});
		$("#thList").html(output);

		console.log("선택 영화 제목 : " + $(selObj).text());
		console.log("선택 영화 포스터 : " + selMvposter);
		
		//선택 내용 출력
		$("#viewSelMvposter").attr("src",selMvposter);
		$("#viewSelMvname").text($(selObj).text());
		
		
		
	
	}
	function thSelect(selObj,selThcode){
		selectReThcode = selThcode;
		$("#selScdate").text("");
		$("#selRoomTime").text("");
		
		//극장목록 css 변경
		$("#thList div").css("background-color","").css("color","");
		$(selObj).css("background-color","gold").css("color","white");
		
		//예매가능한 날짜 목록 조회 및 출력
		var output = "";
		$.ajax({
			type : "get",
			url : "getScDateList",
			data : {"mvcode" : selectReMvcode , "thcode" : selThcode},
			dataType : "json",
			async : false,
			success : function(scDateList){
				console.log(scDateList);
				
				for(var i = 0; i < scDateList.length; i++){
					console.log(scDateList[i].scroom)
					output += "<div class=\"p-2 font-weight-bold text-lg\" onclick=\"seldate(this,'"+ scDateList[i].scdate +"')\">"+scDateList[i].scdate+"</div>"
				}
			}
			
			
			
			
		});
		
		$("#scDateList").html(output);
		
		
		
		//선택 내용 출력
		console.log("선택한 극장 코드 : " + selThcode );
		console.log("선택 극장 이름 : " + $(selObj).text());
		$("#selThname").text("극장 : " + $(selObj).text());
		
		$("#rescthcode").val(selThcode);
	}
	
	
	
	function seldate(selObj,selScDate){
		//날짜목록 css 변경
		$("#scDateList div").css("background-color","").css("color","");
		$(selObj).css("background-color","gold").css("color","white");
		
		$("#selScdate").text("");
		$("#selRoomTime").text("");
		
		var output = "";
		
		$.ajax({
			type : "get",
			url : "getScRoomTimeList",
			data : {"mvcode" : selectReMvcode , "thcode" : selectReThcode , "scdate" : selScDate},
			dataType : "json",
			async : false,
			success : function(scRoomTimeList){
				console.log(scRoomTimeList);
				var scRoom = ""; //상영관 비교를 위해 선언한 변수
				for(var i = 0; i < scRoomTimeList.length; i++){
					console.log(scRoomTimeList[i].scroom)
					if( scRoom != scRoomTimeList[i].scroom){
						
						if(i !=0){
							output += "<hr class=\"my-1\">";	
						}
					output += "<div class=\"p-2 font-weight-bold text-lg\" onclick=\"selTime(this,'"+ scRoomTimeList[i].scdate +",'"+scRoomTimeList[i].scdate+"')\">"+scRoomTimeList[i].scroom+ "</div>"
					scRoom = scRoomTimeList[i].scroom;
					}
				output +="<button  class=\"btn btn-sm font-weight-bold ml-1 my-2 mr-1 scTimeBtn\" onclick=\"scRoomTimeSelect(this,'"+scRoomTimeList[i].scroom+"')\">"+scRoomTimeList[i].scdate+"</button>"
					
				}
			}
			
			
			
			
		});
		
		$("#scRoomTime").html(output);
		
		
		
		$("#selScdate").text("날짜 : " + $(selObj).text());
		Redate = $(selObj).text();
		
	}
	
		function scRoomTimeSelect(selObj,selRoom,seldate){
			
			
			//상영관 및 시간 css 변경
			$("#scRoomTime button").css("background-color","").css("color","");
			$(selObj).css("background-color","gold").css("color","white");
			
			$("#selRoomTime").text("예약시간  : " + $(selObj).text());
			$("#selroom").text("상영관 : " + selRoom);
			
			$("#rescroom").val(selRoom);
			$("#rescdate").val(Redate + " " + $(selObj).text());
			
			
		}
		
		function peopleSelect(selObj){
			//인원선택  css
			$("#selbutton button").css("background-color","").css("color","");
			$(selObj).css("background-color","red").css("color","white");
			
			$("#viewnum").text("인원 : " + $(selObj).text());
			
			$("#reamount").val($(selObj).text());
			
		}
		
		function reservationFormCheck(){
			console.log("호출")
			
			var rescthcode = $("#rescthcode").val();
			var rescroom = $("#rescroom").val();
			var rescdate = $("#rescdate").val();
			var reamount = $("#reamount").val();
			
			console.log(rescthcode);
			if(rescthcode.length == 0){
				alert("극장을 선택해주세요");
				return false;
			}
			if(rescroom.length == 0){
				alert("상영관을 선택해주세요");
				return false;
			}
			if(rescdate.length == 0){
				alert("날짜를 선택해세요");
				return false;
			}
			if(reamount.val().length == 0){
				alert("인원수를 선택해주세요");
				return false;
			} 
			
			/*
			if(selectReMvCode.length == 0){
				console.log("영화")
				alert("영화를 선택해주세요");
				
				return false;
			}
			*/
			return false;
		}
		
</script>

<script type="text/javascript">

	var checkMvCode = '${param.mvcode}';
	console.log(checkMvCode);
	if(checkMvCode.length > 0 ){
		$("#" + checkMvCode).click();
	}

</script>

</body>

</html>