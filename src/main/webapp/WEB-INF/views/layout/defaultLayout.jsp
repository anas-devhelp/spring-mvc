<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<jsp:include page="head.jsp"></jsp:include>
</head>
<body>
	<jsp:include page="../common/navigation.jsp"/>
	<!--Main layout-->
	<br><br><br><br>
	<main>
        <div class="container">
        	<jsp:include page="${view}.jsp"></jsp:include>
        </div>
    </main>    
	<!--Main layout-->
	<jsp:include page="../common/commonFooterJsCss.jsp"/>
	 <script type="text/javascript">
     $(document).ready(function () {
         $('.mdb-select').material_select();
     });
     </script>
</body>
</html>