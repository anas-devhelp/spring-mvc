<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!--Grid row-->
<div class="row">
	<!--Grid column-->
	<div class="col-lg-12 col-md-12 mb-12">
		<!--Card-->
		<div class="card">
			<!--Card content-->
			<div class="card-body">
				<c:if test="${not empty entity}">
					Permissions of <strong><u>${entity.name}</u></strong> role
					<hr>
				</c:if>
				<c:forEach items="${entities}" var="loopedEntity">
					<form:form id="formEntity_${loopedEntity}" method="POST" modelAttribute="formEntity">
						<input name="roleId" type="hidden" value="${entity.id}">
						<input name="entityName" type="hidden" value="${loopedEntity}">
						<div class="row">
							<div class="col-lg-2 col-md-4 mb-4">
								<label>Entity: ${loopedEntity}</label>
							</div>
								<c:set var="checked" value="" />
								<spring:eval var="containsValue"
									expression="entity.permissionsMap.containsKey(loopedEntity)" />
								<c:set var="canCreateCheck" value="" />
								<c:set var="canReadCheck" value="" />
								<c:set var="canUpdateCheck" value="" />
								<c:set var="canDeleteCheck" value="" />
								<c:if test="${containsValue}">
									<spring:eval var="curPermission"
									expression="entity.permissionsMap.get(loopedEntity)" />
									<c:if test="${curPermission.canCreate == 1}">
										<c:set var="canCreateCheck" value="checked='checked'" />
									</c:if>	
									<c:if test="${curPermission.canRead == 1}">
										<c:set var="canReadCheck" value="checked='checked'" />
									</c:if>	
									<c:if test="${curPermission.canUpdate == 1}">
										<c:set var="canUpdateCheck" value="checked='checked'" />
									</c:if>	
									<c:if test="${curPermission.canDelete == 1}">
										<c:set var="canDeleteCheck" value="checked='checked'" />
									</c:if>	
								</c:if>
								<div class="col-lg-2 col-md-4 mb-4">
									<div class="switch">
										<label>Create
											<input type="checkbox" 
											name="canCreate" 
											value="1" 
											id="canCreate_${loopedEntity}" ${canCreateCheck}> <span
											class="lever"
											
											></span>
										</label>
									</div>
								</div>
								<div class="col-lg-2 col-md-4 mb-4">
									<div class="switch">
										<label>Read
											<input type="checkbox" 
											name="canRead" 
											value="1" 
											id="canRead_${loopedEntity}" ${canReadCheck}> <span
											class="lever"></span>
										</label>
									</div>
								</div>
								<div class="col-lg-2 col-md-4 mb-4">
									<div class="switch">
										<label>Update
											<input type="checkbox" 
											name="canUpdate" 
											value="1" 
											id="canUpdate_${loopedEntity}" ${canUpdateCheck}
											onchange="updateCheck('${loopedEntity}', 'update', this);"
											> <span
											class="lever"></span>
										</label>
									</div>
								</div>
								<div class="col-lg-2 col-md-4 mb-4">
									<div class="switch">
										<label>Delete
											<input type="checkbox" 
											name="canDelete" 
											value="1" 
											id="canDelete_${loopedEntity}" ${canDeleteCheck} 
											> <span
											class="lever"
											
											></span>
										</label>
									</div>
								</div>
							<div class="col-lg-2 col-md-4 mb-4">
								<button class="btn-save btn btn-primary btn-sm">Save</button>
							</div>
						</div>
					</form:form>	
				</c:forEach>
				<script type="text/javascript">
					function updateCheck(entity, action, checkbox){
						console.log(entity);
						console.log(action);
						if(action=="create"){
							if(checkbox.checked){
								document.getElementById("canRead_"+entity).checked=true;
								document.getElementById("canUpdate_"+entity).checked=true;
								document.getElementById("canDelete_"+entity).checked=true;
							}else{
								document.getElementById("canRead_"+entity).checked=false;
								document.getElementById("canUpdate_"+entity).checked=false;
								document.getElementById("canDelete_"+entity).checked=false;
							}
						}else if(action=="update"){
							if(checkbox.checked){
								document.getElementById("canRead_"+entity).checked=true;
							}
						}else if(action=="delete"){
							if(checkbox.checked){
								document.getElementById("canCreate_"+entity).checked=true;
								document.getElementById("canRead_"+entity).checked=true;
								document.getElementById("canUpdate_"+entity).checked=true;
							}else{
								document.getElementById("canCreate_"+entity).checked=false;
								document.getElementById("canRead_"+entity).checked=false;
								document.getElementById("canUpdate_"+entity).checked=false;
								
							}
						}
					}
				</script>
				<%-- <c:if test="${not empty entity}">
					Permissions of <strong><u>${entity.name}</u></strong> role
					<hr>
					<c:forEach items="${entities}" var="loopedEntity">
						<form:form method="POST" modelAttribute="entity">
							<div class="row">
								<div class="col-lg-2 col-md-4 mb-4">
									<label>Entity: ${loopedEntity}</label>
								</div>
								<c:forEach items="${permissionTypes}" var="permissionType">
									<div class="col-lg-2 col-md-4 mb-4">
										<c:set var="checked" value="" />
										<c:set var="permissionTypeFull"
											value="${permissionType}_${entity}" />
										<spring:eval var="containsValue"
											expression="entity.permissionsSet.contains(permissionTypeFull)" />
										<c:if test="${containsValue}">
											<c:set var="checked" value="checked='checked'" />
										</c:if>
										<div class="switch">
											<label>${permissionType}<input type="checkbox"
												id="${permissionType}_${entity}" ${checked}> <span
												class="lever"></span>
											</label>
										</div>
									</div>
								</c:forEach>
								<div class="col-lg-2 col-md-4 mb-4">
									<button class="btn-save btn btn-primary btn-sm">Save</button>
								</div>
							</div>
						</form:form>
					</c:forEach>
				</c:if> --%>
			</div>
		</div>
		<!--/.Card-->
	</div>
	<!--Grid column-->
</div>