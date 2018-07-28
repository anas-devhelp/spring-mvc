<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>
	<c:choose>
		<c:when test="${not empty role.id}">
			Edit Role - ${role.name}
		</c:when>
		<c:otherwise>
			Add Role
		</c:otherwise>
	</c:choose>
</title>
<jsp:include page="../common/commonHeaderJsCss.jsp"></jsp:include>
</head>
<body>
	<jsp:include page="../common/navigation.jsp"/>
	<!--Main layout-->
    <main>
        <div class="container-fluid">
            <!--Grid row-->
            <div class="row">
                <!--Grid column-->
                <!-- <div class="col-lg-4 col-md-12 mb-4">&nbsp;</div> -->
                <!--Grid column-->
                <div class="col-lg-12 col-md-12 mb-12">
                    <!--Card-->
                    <div class="card">
                        <!--Card content-->
                        <div class="card-body">
                            <!-- Register form -->
                            <form:form method="POST" modelAttribute="role">
                            	<c:if test="${not empty role.id}">
									<form:input type="hidden" path="id" id="id" />
									<form:input type="hidden" path="status" id="status" />
								</c:if>
                                <p class="h5 text-center mb-4">
                                	<c:choose>
										<c:when test="${not empty role.id}">
											Edit Role - ${role.name}
										</c:when>
										<c:otherwise>
											Add Role - New
										</c:otherwise>
									</c:choose>
                                </p>
                                <div class="md-form">
                                    <form:input path="name" id="name" />
                                    <label for="name">Name:</label>
                                    <form:errors path="name" cssClass="error" />
                                </div>

                                <div class="md-form">
                                    <form:input path="description" id="description" />
                                    <label for="description">Description: </label>
                                    <form:errors path="description" cssClass="error" />
                                </div>
                                
                                <div class="text-center mt-4">
	                                <button type="submit" class="btn btn-deep-orange">
	                                	<c:choose>
	                                		<c:when test="${edit}">
	                                			Update
	                                		</c:when>
	                                		<c:otherwise>
												Save
											</c:otherwise>
										</c:choose>	
									</button>		
                                </div>
                            </form:form>
                            <!-- Register form -->
                        </div>
                    </div>
                    <!--/.Card-->
                </div>
                <!--Grid column-->
               	<!--Grid column-->
                <!-- <div class="col-lg-4 col-md-12 mb-4">&nbsp;</div> -->
            </div>
        </div>
     </main>  
     <jsp:include page="../common/commonFooterJsCss.jsp"/>
</body>
</html>