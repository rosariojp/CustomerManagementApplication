<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>

<div class="container">
	<div>
		<a type="button" class="btn btn-primary btn-md" href="/add-customer">Add Customer</a>
	</div>
	<br>
	<div class="panel panel-primary">
		<div class="panel-heading">
			<h3>List of Customers</h3>
		</div>
		<div class="panel-body">
			<table class="table table-striped">
				<thead>
					<tr>
						<th width="10%">ID</th>
						<th width="20%">First Name</th>
						<th width="20%">Last Name</th>
						<th width="25%">Email</th>
						<th width="25%"></th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${customers}" var="customer">
						<tr>
							<td>${customer.id}</td>
							<td>${customer.firstName}</td>
							<td>${customer.lastName}</td>
							<td>${customer.email}</td>
							<td>
								<a type="button" class="btn btn-danger" href="/view-customer?id=${customer.id}">View</a>
								<a type="button" class="btn btn-success" href="/update-customer?id=${customer.id}">Update</a>
								<a type="button" class="btn btn-warning" href="/delete-customer?id=${customer.id}">Delete</a>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</div>

<%@ include file="common/footer.jspf"%>