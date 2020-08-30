<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<acme:form readonly="true">
	<acme:form-textbox code="anonymous.techRecord.form.label.title" path="title" />
	<acme:form-textbox code="anonymous.techRecord.form.label.activitySector" path="activitySector" />
	<acme:form-textbox code="anonymous.techRecord.form.label.inventorName" path="inventorName" />
	<acme:form-textarea code="anonymous.techRecord.form.label.description" path="description" />
	<acme:form-url code="anonymous.techRecord.form.label.webSite" path="webSite" />
	<acme:form-textbox code="anonymous.techRecord.form.label.email" path="email" />
	<acme:form-textbox code="anonymous.techRecord.form.label.stars" path="stars" />
	<acme:form-checkbox code="anonymous.techRecord.form.label.open" path="open" />
	
	<acme:form-return code="anonymous.techRecord.form.button.return" />
</acme:form>