<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<acme:form readonly="true">
	<acme:form-textbox code="authenticated.techRecords.form.label.title" path="title" />
	<acme:form-textbox code="authenticated.techRecords.form.label.activitySector" path="activitySector" />
	<acme:form-textbox code="authenticated.techRecords.form.label.inventorName" path="inventorName" />
	<acme:form-textarea code="authenticated.techRecords.form.label.description" path="description" />
	<acme:form-url code="authenticated.techRecords.form.label.webSite" path="webSite" />
	<acme:form-textbox code="authenticated.techRecords.form.label.email" path="email" />
	<acme:form-textbox code="authenticated.techRecords.form.label.stars" path="stars" />
	<acme:form-checkbox code="authenticated.techRecord.form.label.open" path="open" />
	
	<acme:form-return code="authenticated.techRecords.form.button.return" />
</acme:form>