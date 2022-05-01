<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>

<div class="container">
	<div class="row">
		<div class="col-md-6 col-md-offset-3 ">
			<div class="panel panel-primary">
				<div class="panel-heading">Add Customer</div>
				<div class="panel-body">
					<form:form method="post" modelAttribute="customer">
						<form:hidden path="id" />
						<fieldset class="form-group">
							<form:label path="firstName">First Name</form:label>
							<form:input path="firstName" type="text" class="form-control" required="required" />
							<form:errors path="firstName" cssClass="text-warning" />
						</fieldset>
						<fieldset class="form-group">
							<form:label path="lastName">Last Name</form:label>
							<form:input path="lastName" type="text" class="form-control" required="required" />
							<form:errors path="lastName" cssClass="text-warning" />
						</fieldset>
						<fieldset class="form-group">
							<form:label path="email">Email</form:label>
							<form:input path="email" type="text" class="form-control" required="required" />
							<form:errors path="email" cssClass="text-warning" />
						</fieldset>
						<button type="submit" class="btn btn-success">Save</button>
					</form:form>
				</div>
			</div>
		</div>
	</div>
</div>

<%@ include file="common/footer.jspf"%>