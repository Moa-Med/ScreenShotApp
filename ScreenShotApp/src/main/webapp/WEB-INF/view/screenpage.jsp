<!DOCTYPE html >
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta http-equiv="Pragma" content="no-cache">
<meta http-equiv="Cache-Control" content="no-cache">
<meta http-equiv="Expires" content="sat, 01 Dec 2001 00:00:00 GMT">
<title>ScreenShot Application</title>
<link href="static/css/bootstrap.min.css" rel="stylesheet">
<link href="static/css/style.css" rel="stylesheet">

<body>

<div role="navigation">
		<div class="navbar navbar-inverse">
			<div class="navbar-collapse collapse">
				<ul class="nav navbar-nav">
					<li><a href="/snapshot">SNAPSHOT</a></li>
					<li><a href="/snaps">SNAPS</a></li>
				</ul>
			</div>
		</div>
	</div>
    
  <c:choose>
  <c:when test="${mode=='MODE_SNAPS'}">
    
     <div class="container" id="homediv">
				<div class="jumbotron text-center">
					<h2>URLS AND SNAPS</h2>
					
				</div>
			</div>
    </c:when>
    </c:choose>
  
<c:choose>
<c:when test="${mode=='MODE_DONE'}">
    		<div class="container" id="homediv">
				<div class="jumbotron text-center">
					<h2>Screen Shot done !</h2>
					<h4>Click SNAPS for Urls </h4>
					<h4>Click SNAPSHOT for new screenshot </h4>
				</div>
				</div>
	</c:when>
</c:choose>

 <c:choose>
<c:when test="${mode=='MODE_ERROR'}">
    		<div class="container" id="homediv">
				<div class="jumbotron text-center">
					<h2>Invalid Url</h2>
				</div>
				</div>
	</c:when>
</c:choose>
    
    
<c:choose>
<c:when test="${mode=='MODE_HOME'}">
    <div class="container" id="homediv">
				<div class="jumbotron text-center">
					<h2>Screen Shot your Urls's images in one click</h2>
						<h4>screenshot as a service</h4>
				</div>
			</div>
	</c:when>
</c:choose>
			
	<c:choose>
<c:when test="${mode=='MODE_URL'}">

 <div class="container" id="homediv">
				<div class="jumbotron text-center">
					<h2>Screen Shot your Urls's images in one click</h2>
						<h4>screenshot as a service</h4>
				</div>
			</div>
			
	<div class="container text-center">
				<h3>URL</h3>
				<hr>
				<form class="form-horizontal" method="POST" action="save-url">
					
					<div class="form-group">
						<label class="control-label col-md-3">URLS</label>
						<div class="col-md-7">
							<input type="text" class="form-control" placeholder="https://www.exemple.com" name="urls"
								value="${url.urls}" />
						</div>
					</div>
					<div class="form-group ">
						<input type="submit" class="btn btn-primary" value="ScreenShot" />
					</div>
				</form>
			</div>
		</c:when>	
</c:choose>

<c:choose>
<c:when test="${mode=='MODE_SNAPS' }">
			<div class="container text-center" id="tasksDiv">
				<hr>
				<div class="table-responsive">
					<table class="table table-striped table-bordered">
						<thead>
							<tr>
								<th>Id</th>
								<th>Urls</th>
								<th>Source Images</th>
								<th>Delete</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="url" items="${urls}">
								<tr>
									<td>${url.id}</td>
									<td>${url.urls}</td>
									<td>${url.filename}</td>
									<td><a href="/delete-url?id=${url.id }"><span
											class="glyphicon glyphicon-trash"></span></a></td>
									</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</c:when>
</c:choose>

<!-- Optional JavaScript -->
	<!-- jQuery first, then Popper.js, then Bootstrap JS -->
	<script src="static/js/jquery-1.11.1.min.js"></script>
	<script src="static/js/bootstrap.min.js"></script>
</body>
</html>
