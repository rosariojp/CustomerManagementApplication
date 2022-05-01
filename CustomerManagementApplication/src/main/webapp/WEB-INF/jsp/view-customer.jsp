<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>

<div class="container">
	<div class="row">
		<div class="col-md-6 col-md-offset-3 ">
			<div class="panel panel-primary">
				<div class="panel-heading">View Customer</div>
				<div class="panel-body">
					<form:form method="post" modelAttribute="customer">
						<form:hidden path="id" />
						<fieldset class="form-group">
							<form:label path="firstName">First Name</form:label>
							<form:label path="firstName" class="form-control"><c:out value="${customer.firstName}"></c:out></form:label>
						</fieldset>
						<fieldset class="form-group">
							<form:label path="lastName">Last Name</form:label>
							<form:label path="lastName" class="form-control"><c:out value="${customer.lastName}"></c:out></form:label>
						</fieldset>
						<fieldset class="form-group">
							<form:label path="email">Email</form:label>
							<form:label path="email" class="form-control"><c:out value="${customer.email}"></c:out></form:label>
							<form:errors path="email" cssClass="text-warning" />
						</fieldset>
					</form:form>
					<button type="submit" class="btn btn-success" disabled>Save</button>
				</div>
			</div>
		</div>
	</div>
</div>

<%@ include file="common/footer.jspf"%>