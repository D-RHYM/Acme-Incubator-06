<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<acme:form>
	<acme:form-textbox code="administrator.techRecords.form.label.title" path="title" />
	<acme:form-textbox code="administrator.techRecords.form.label.activitySector" path="activitySector" />
	<acme:form-textbox code="administrator.techRecords.form.label.inventorName" path="inventorName" />
	<acme:form-textarea code="administrator.techRecords.form.label.description" path="description" />
	<acme:form-url code="administrator.techRecords.form.label.webSite" path="webSite" />
	<acme:form-textbox code="administrator.techRecords.form.label.email" path="email" />
	<acme:form-textbox code="administrator.techRecords.form.label.stars" path="stars" />
	<acme:form-checkbox code="administrator.techRecord.form.label.open" path="open" />
	
	<acme:form-submit test="${command == 'show'}" code="administrator.techRecord.form.button.update" action="/administrator/tech-record/update" />
	<acme:form-submit test="${command == 'show'}" code="administrator.techRecord.form.button.delete" action="/administrator/tech-record/delete" />
	<acme:form-submit test="${command == 'create'}" code="administrator.techRecord.form.button.create" action="/administrator/tech-record/create" />
	<acme:form-submit test="${command == 'update'}" code="administrator.techRecord.form.button.update" action="/administrator/tech-record/update" />
	<acme:form-submit test="${command == 'delete'}" code="administrator.techRecord.form.button.delete" action="/administrator/tech-record/delete" />
	
	<acme:form-return code="administrator.techRecords.form.button.return" />
</acme:form>