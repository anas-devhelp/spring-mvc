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
			<c:when test="${not empty domain.id}">
				Edit Domain - ${domain.label}
			</c:when>
			<c:otherwise>
				Add Domain
			</c:otherwise>
		</c:choose>
		
	</title>
	<jsp:include page="commonHeaderJsCss.jsp"></jsp:include>
</head>
<body class="fixed-sn white-skin">
	<jsp:include page="navigation.jsp"/>
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
                            <form:form method="POST" modelAttribute="domain">
                            	<c:if test="${not empty domain.id}">
									<form:input type="hidden" path="id" id="id" />
									<form:input type="hidden" path="status" id="status" />
								</c:if>
                                <p class="h5 text-center mb-4">
                                	<c:choose>
										<c:when test="${not empty domain.id}">
											Edit Domain - ${domain.label}(${domain.name})
										</c:when>
										<c:otherwise>
											Add Domain - New
										</c:otherwise>
									</c:choose>
                                </p>
                                <div class="md-form">
                                    <form:input path="name" id="name" />
                                    <label for="name">Name:</label>
                                    <form:errors path="name" cssClass="error" />
                                </div>
                                <div class="md-form">
                                    <form:input path="label" id="label" />
                                    <label for="label">Label</label>
                                    <form:errors path="label" cssClass="error" />
                                </div>

                                <div class="md-form">
                                    <form:input path="dateFormat" id="dateFormat" />
                                    <label for="dateFormat">Date format: </label>
                                    <form:errors path="dateFormat" cssClass="error" />
                                </div>
                                
								<div class="md-form">
                                    <form:input path="dateTimeFormat" id="dateTimeFormat" />
                                    <label for="dateTimeFormat">Date time format: </label>
                                    <form:errors path="dateTimeFormat" cssClass="error" />
                                </div>
                                
                                <div class="text-center mt-4">
                                	<c:choose>
	                                	<c:when test="${edit}">
											<button type="submit" class="btn btn-deep-orange">Update</button>
										</c:when>
										<c:otherwise>
											<button type="submit" class="btn btn-deep-orange">Register</button>
										</c:otherwise>
									</c:choose>	
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

	<%-- <h2>Domain Form</h2>
	<form:form method="POST" modelAttribute="domain">
		<c:if test="${not empty domain.id}">
			<form:input type="hidden" path="id" id="id" />
		</c:if>
		<table>
			<tr>
				<td><label for="name">Name: </label></td>
				<td><form:input path="name" id="name" /></td>
				<td><form:errors path="name" cssClass="error" /></td>
			</tr>
			<tr>
				<td><label for="label">Label: </label></td>
				<td><form:input path="label" id="label" /></td>
				<td><form:errors path="label" cssClass="error" /></td>
			</tr>
			<tr>
				<td><label for="dateFormat">Date format: </label></td>
				<td><form:input path="dateFormat" id="dateFormat" /></td>
				<td><form:errors path="dateFormat" cssClass="error" /></td>
			</tr>
			<tr>
				<td colspan="3"><c:choose>
					<c:when test="${edit}">
						<input type="submit" value="Update" />
					</c:when>
					<c:otherwise>
						<input type="submit" value="Register" />
					</c:otherwise>
				</c:choose></td>
			</tr>
		</table>
	</form:form>
 	<br/>
    <br/>
    Go back to <a href="<c:url value='/domain/list' />">List of All Domains</a> --%>
    <jsp:include page="commonFooterJsCss.jsp"/>
</body>
</html>