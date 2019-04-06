<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>

<html lang="es">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<!-- Meta, title, CSS, favicons, etc. -->
<meta charset="utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1" />

<title>Intranet</title>

<!-- Bootstrap -->
<link href="https://colorlib.com/polygon/vendors/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet" />
<!-- Font Awesome -->
<link href="https://colorlib.com/polygon/vendors/font-awesome/css/font-awesome.min.css" rel="stylesheet">

<link href="resources/css/iCheck/skins/flat/green.css" rel="stylesheet">

<!-- Custom Theme Style -->
<link href="resources/css/custom.min.css" rel="stylesheet" />

<link href="resources/css/style.css" rel="stylesheet" />

<link href="resources/css/datatables.net-bs/dataTables.bootstrap.min.css" rel="stylesheet" />
<link href="resources/css/datatables.net-responsive-bs/responsive.bootstrap.min.css" rel="stylesheet" />
<link href="resources/css/animate.css" rel="stylesheet" />
<link href="resources/css/skspinner.css" rel="stylesheet" />

</head>

<body class="nav-md" >
	<div class="container body">
		<div class="main_container">
		
			<div class="col-md-3 left_col">
				<div class="left_col scroll-view">
				
					<div class="navbar nav_title" style="border: 0;">
						<a href="#" class="site_title"><i class="fa fa-bank"></i>
							<span>Intranet</span></a>
					</div>
			
					<div class="clearfix"></div>
			
					<!-- menu profile quick info -->
					<div class="profile clearfix">
						<div class="profile_pic">
							<img src="resources/images/profile.png" class="img-circle profile_img" />
						</div>
						<div class="profile_info">
							<span>Bienvenido</span>
							<h2>alumno</h2>
						</div>
						<div class="clearfix"></div>
					</div>
					<!-- /menu profile quick info -->
			
					<br />
			
					<!-- sidebar menu -->
					<div id="sidebar-menu" class="main_menu_side hidden-print main_menu">
						<div class="menu_section">
							<ul class="nav side-menu">
								<li class="active"><a><i class="fa fa-home"></i> Alumnos <span
										class="fa fa-chevron-down"></span></a>
									<ul class="nav child_menu" style="display: block;">
										<li class="current-page"><a href="/intranet/">Buscar alumno</a></li>
										<li><a href="/intranet/edit?id=0">Registrar alumno</a></li>
			
									</ul></li>								
							</ul>
						</div>
					</div>
					<!-- /sidebar menu -->
			
					<!-- /menu footer buttons -->
					<div class="sidebar-footer hidden-small">
						<a data-toggle="tooltip" data-placement="top" title="Twitter"
							href="#" target="_blank"> <span
							class="fa fa-twitter" aria-hidden="true"></span>
						</a> <a data-toggle="tooltip" data-placement="top" title="Facebook"
							href="#" target="_blank">
							<span class="fa fa-facebook" aria-hidden="true"></span>
						</a> <a data-toggle="tooltip" data-placement="top" title="Youtube"
							href="#"
							target="_blank"> <span class="fa fa-youtube-play"
							aria-hidden="true"></span>
						</a>
			
						<form id="logoutForm" action="#" method="post">
							<a data-toggle="tooltip" data-placement="top" title="Logout"									
								type="submit"> <span class="glyphicon glyphicon-off"
								aria-hidden="true"></span></a>
			
						</form>
					</div>
					<!-- /menu footer buttons -->
				</div>
			</div>

			<!-- top navigation -->
			<div class="top_nav">
				<div class="nav_menu">
					<nav>
						<div class="nav toggle">
							<a id="menu_toggle"><i class="fa fa-bars"></i></a>
						</div>
			
						<ul class="nav navbar-nav navbar-right">
							<li class=""><a href="javascript:;"
								class="user-profile dropdown-toggle" data-toggle="dropdown"
								aria-expanded="false"> 
									<img src="resources/images/img.png" alt="" /><span>Juan</span> <span class=" fa fa-angle-down"></span>
							</a>
								<ul class="dropdown-menu dropdown-usermenu pull-right">
									<li><a href="javascript:;"> Profile</a></li>
									<li><a href="javascript:;"> <span
											class="badge bg-red pull-right">50%</span> <span>Settings</span>
									</a></li>
									<li><a href="javascript:;">Help</a></li>
									<li><a> <i
											class="fa fa-sign-out pull-right"></i> Log Out
									</a></li>
			
								 	<li>
										<form id="logoutForm" action="#" style="display: none;" method="post">
											<a type="submit"> <i class="fa fa-sign-out pull-right"></i>
											</a>
										</form>
									</li>
								</ul></li>
			
							<li role="presentation" class="dropdown"><a href="javascript:;"
								class="dropdown-toggle info-number" data-toggle="dropdown"
								aria-expanded="false"> <i class="fa fa-envelope-o"></i> <span
									class="badge bg-green">6</span>
							</a>
								<ul id="menu1" class="dropdown-menu list-unstyled msg_list"
									role="menu">
									<li><a> <span class="image"><img
												src="resources/images/img.png" alt="Profile Image" /></span> <span> <span>John
													Smith</span> <span class="time">3 mins ago</span>
										</span> <span class="message"> Film festivals used to be
												do-or-die moments for movie makers. They were where... </span>
									</a></li>
									<li><a> <span class="image"><img
												src="resources/images/img.png" alt="Profile Image" /></span> <span> <span>John
													Smith</span> <span class="time">3 mins ago</span>
										</span> <span class="message"> Film festivals used to be
												do-or-die moments for movie makers. They were where... </span>
									</a></li>
									<li><a> <span class="image"><img
												src="resources/images/img.png" alt="Profile Image" /></span> <span> <span>John
													Smith</span> <span class="time">3 mins ago</span>
										</span> <span class="message"> Film festivals used to be
												do-or-die moments for movie makers. They were where... </span>
									</a></li>
									<li><a> <span class="image"><img
												src="resources/images/img.png" alt="Profile Image" /></span> <span> <span>John
													Smith</span> <span class="time">3 mins ago</span>
										</span> <span class="message"> Film festivals used to be
												do-or-die moments for movie makers. They were where... </span>
									</a></li>
									<li>
										<div class="text-center">
											<a> <strong>See All Alerts</strong> <i
												class="fa fa-angle-right"></i>
											</a>
										</div>
									</li>
								</ul></li>
						</ul>
					</nav>
				</div>
			</div>
			<!-- /top navigation -->

			<!-- page content -->
	 		 <div>
		 		 <div class="right_col" role="main">
		 		 	<div class="page-title">
						<div class="title_left">
							<h3>Alumnos</h3>
						</div>
					</div>
					<div class="clearfix"></div>
					<div class="row">
						<div class="col-md-12 col-sm-12 col-xs-12">
							<div class="x_panel">
								<div class="x_title">
									<div class="row">
										<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
											<h2>Buscar alumno</h2>
										</div>
									</div>
								</div>
								<div class="x_content">
									<div class="row">
										<div class="col-md-12 col-sm-12 col-xs-12">
											<form id="searchForm">
												<div class="well">
													<div class="row">
														<div class="col-md-3 col-sm-6 col-xs-12 minHeightField">
															<label>Nombres:</label>
															<input name="nombres" class="form-control" autocomplete="off"/>
														</div>
														<div class="col-md-3 col-sm-6 col-xs-12 minHeightField">
															<label>Apellido Pat:</label>
															<input name="apePaterno" class="form-control" autocomplete="off"/>
														</div>
														<div class="col-md-3 col-sm-6 col-xs-12 minHeightField">
															<label>Apellido Mat:</label>
															<input name="apeMaterno" class="form-control" autocomplete="off"/>
														</div>
														<div class="col-md-3 col-sm-6 col-xs-12 minHeightField">
															<label>DNI:</label>
															<input name="dni" class="form-control digits" autocomplete="off"/>
														</div>
														<div class="col-md-3 col-sm-6 col-xs-12 minHeightField">
															<label>Sexo:</label>
															<br/>
															<select class="form-control" name="sexo">
																<option value="">Seleccione</option>
																<option value="1">Hombre</option>
																<option value="0">Mujer</option>																
															</select>
														</div>
													</div>
													<div class="row">
														<div class="col-md-3 col-sm-6 col-xs-12 float-right">
															<input type="button" class="btn btn-primary float-right" id="searchBtn" value="Buscar"/>
															<a class="btn btn-primary" href="/intranet/edit?id=0" style="float: right"><i class="m-icon fa fa-save"></i>&nbsp;Agregar</a>
														</div>
													</div>	
												</div>
											</form>
											<div class="row">
												<div id="messages" class="col-md-12">
												</div>
											</div>
										</div>
									</div>
									<br/>
									<div class="clearfix"></div>
									<div id="listSearch">
									</div>
								</div>
							</div>
						</div>
					</div>	
		 		 </div>
	 		 </div>
			<!-- /page content -->

			<!-- footer content -->
			<footer>
				<div class="pull-right">
					    <a>JP</a>
				</div>
				<div class="clearfix"></div>
			</footer>
			<!-- /footer content -->
			
		</div>
	</div>

	<!-- jQuery -->
	<script src="resources/js/jquery.min.js"></script>
	<script src="resources/js/popper.min.js"></script>
	<!-- Bootstrap -->
	<script src="resources/js/bootstrap.min.js"></script>
	
	<!-- jQuery Smart Wizard -->
    <script src="resources/js/jquery.smartWizard.js"></script>
    
    <script src="resources/js/jquery.validate.min.js"></script>

	<!-- Custom Theme Scripts -->
	<script src="resources/js/iCheck/icheck.min.js"></script>
	<script src="resources/js/custom.min.js"></script>
	
	<script src="resources/js/datatables.net/jquery.dataTables.min.js"></script>
	<script src="resources/js/datatables.net-bs/dataTables.bootstrap.min.js"></script>
	<script src="resources/js/datatables.net-responsive/dataTables.responsive.min.js"></script>
	<script src="resources/js/datatables.net-responsive-bs/responsive.bootstrap.js"></script>
	
	<script src="resources/js/app.js"></script>
</body>
</html>
<script>

	$(document).ready(function(){
		$("#searchBtn").click(buscar)
		$("#searchBtn").click()
	})

	function buscar(){
		
		var dataForm = $("#searchForm").serialize()
		
		showSpinner("listSearch")
		
		$.get("search", dataForm, function(respuesta){
			$("#listSearch").html(respuesta)
		})
		
	}
	
</script>