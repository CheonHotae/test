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
					<div class="d-sm-flex align-items-center justify-content-between mb-4">
                        <h1 class="h3 mb-0 text-gray-800">지금예매 가능한 영화</h1>
                    </div>
					
                    <!-- Page Heading -->
                    <div class="row">
							
                        <!-- Earnings (Monthly) Card Example -->
                        <c:forEach items="${selectReMovie }" var="selectReMovie">
                        <div class="col-xl-3 col-md-6 mb-4">
                            <div class="card border-left-primary shadow h-100 py-2">
                                <div class="card-body">
                                    <div class="row no-gutters align-items-center">
                                        <div class="col mr-2">
                                            <div class="text-xs font-weight-bold text-primary text-uppercase mb-1">
                                               <img alt="" src="${selectReMovie.mvposter }" style="width: 100px; height: 100px;"> </div>
                                            <div class="h5 mb-0 font-weight-bold text-gray-800">${selectReMovie.mvname }</div>
                                        </div>
                                        <div class="col-auto">
                                            ${selectReMovie.mvopen } <br>
                                          
                                            
                                            
                                            <a href="${pageContext.request.contextPath }/movieView?mvcode=${selectReMovie.mvcode }">상세보기</a>
                                            
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
					</c:forEach>
                     
                    <!-- Content Row -->
						
                    <!-- Content Row -->
                  </div>
                </div>
                
                
                <div class="container-fluid">
					<div class="d-sm-flex align-items-center justify-content-between mb-4">
                        <h1 class="h3 mb-0 text-gray-800">검색어가 포함된 영화</h1>
                    </div>
					
                    <!-- Page Heading -->
                    <div class="row">
							
                        <!-- Earnings (Monthly) Card Example -->
                        <c:forEach items="${searchMovie }" var="searchMovie">
                        <div class="col-xl-3 col-md-6 mb-4">
                            <div class="card border-left-primary shadow h-100 py-2">
                                <div class="card-body">
                                    <div class="row no-gutters align-items-center">
                                        <div class="col mr-2">
                                            <div class="text-xs font-weight-bold text-primary text-uppercase mb-1">
                                               <img alt="" src="${searchMovie.mvposter }" style="width: 100px; height: 100px;"> </div>
                                            <div class="h5 mb-0 font-weight-bold text-gray-800">${searchMovie.mvname }</div>
                                        </div>
                                        <div class="col-auto">
                                            ${searchMovie.mvopen }
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
					</c:forEach>
                     
                    <!-- Content Row -->
						
                    <!-- Content Row -->
                  </div>
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
	$("#logoutModel").modal('show')
</script>



</body>

</html>