<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>

<div class="container">
	<div class="panel panel-primary">
		<div class="panel-heading">Error</div>
		<div class="panel-body">
			Failed URL: ${url}
    		Exception:  ${exception.message}
		</div>
	</div>
</div>

<%@ include file="common/footer.jspf"%>