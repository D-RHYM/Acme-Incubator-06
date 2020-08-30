<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<acme:form>

	<acme:form-textarea code="administrator.customisation-parameters.form.label.spamWords" path="spamWords"/>
	<acme:form-textbox code="administrator.customisation-parameters.form.label.spamThreshold" path="spamThreshold" />
	<acme:form-textarea code="administrator.customisation-parameters.form.label.activitySectors" path="activitySectors" />
	
	<acme:form-submit test="${command == 'show' }" code="administrator.customisation-parameters.form.button.update"
		action="/administrator/customisation-parameters/update" />
	<acme:form-submit test="${command == 'update' }" code="administrator.customisation-parameters.form.button.update"
		action="/administrator/customisation-parameters/update" />

	<acme:form-return code="administrator.customisation-parameters.form.button.return" />

</acme:form>