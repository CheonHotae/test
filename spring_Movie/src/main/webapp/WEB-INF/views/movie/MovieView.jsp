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
                        <h1 class="h3 mb-0 text-gray-800">영화 상세정보 페이지-movie/MovieView.jsp</h1>
                        
                    </div>
					<div class="row">
					
						<div class="row">
						<div class="col-xl-4 col-lg-5">
							<div class="card shadow mb-4">
								<div class="card-body" >
									<img alt="img-fluid" src="${mvInfo.mvposter }" style="width: 100%; height: 100%; object-fit:cover; ">
								</div>
							
							</div>
						</div>
						
						<div class="col-xl-8 col-lg-7">
							<div class="card shadow mb-4">
								<div class="card-header py-3 d-flex flex-row align-items-center justify-content-between">
									<h6 class="m-0 font-weight-bold text-gery-900">${mvInfo.mvname }</h6>
								
								</div>
							
							<div class="card-body text-gray-900">
								
								<div class="font-weight-bold">
									추천 : ${mvInfo.goodRecommend } & 비추천 : ${mvInfo.badRecommend } <br>
									예매율 : ${mvInfo.reservationRatio }
								</div>
							
								<div class="font-weight-bold">
									감독 : ${mvInfo.mvpd }
								</div>
								<div class="font-weight-bold">
									배우 : ${mvInfo.mvactor }
								</div>
								<div class="font-weight-bold">
									장르 : ${mvInfo.mvgenre }
								</div>
								<div class="font-weight-bold">
									기본 : ${mvInfo.mvage } 시간 : ${mvInfo.mvopen } 
								</div>
								<div class="font-weight-bold">
									개봉일 : ${mvInfo.mvopen } 
									<a class="btn-sm btn-danger" href="movieReservationPage?mvcode=${mvInfo.mvcode }">예매하기</a>
									
								</div>
							</div>
							</div>
						
						</div>
							
				
				<!-- 관람평 목록 시작 -->			
					
				 
			   
                        <!-- Earnings (Monthly) Card Example -->
                       <c:forEach items="${reviewList }" var="review">
                        <div class="col-xl-4 col-md-6 mb-4">
                            <div class="card border-left-primary shadow h-100 py-2">
                                <div class="card-body">
                                    <div class="row no-gutters align-items-center">
                                    	<div class="col-aoto mr-3">
                                    		<img style="width: 80px;" class="img-fluid"   alt="" src="${pageContext.request.contextPath }/resources/mprofileUpLoad/${review.mprofile}">
                                    	</div>
                                    
                                        <div class="col mr-2">
                                            <div class="text-xs font-weight-bold text-primary text-uppercase mb-1">
                                             작성자 :   ${review.rvmid }</div>
                                            <div class="h5 mb-0 font-weight-bold text-gray-800">${review.rvcomment }</div>
                                        	
                                        	<div class="text-xs text-uppercase mb-1 font=weight-bold text-gray-800">${review.rvdate }</div>
                                        </div>
                                        <div class="col-auto">
                                            
                                            <c:choose>
                                            <c:when test="${review.rvrecommend == 1  }">
                                            <i class="fas fa-calendar fa-2x text-gray-300"></i>
                                            
                                            </c:when>
                                            
                                            <c:otherwise>
                                            <i class="fas fa-calendar fa-2x text-gray-300"></i>
                                            </c:otherwise>
                                            </c:choose>
                                        </div>
                                    </div>
                                </div>
                            </div>  
                            
                           </div>
                           </c:forEach>
                    
                            
				
							
						
						
						</div>
					
					
					</div>
                    <!-- Content Row -->
 						
                    <!-- Content Row -->
						
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

</body>

</html>