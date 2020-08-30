<%@page language="java"%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<acme:form readonly="true">

	<acme:form-panel code="administrator.dashboard.form.label.totals">
		<acme:form-integer code="administrator.dashboard.form.label.totalNotices" path="totalNumberOfNotices" />
		<acme:form-integer code="administrator.dashboard.form.label.totalTechRecords" path="totalNumberOfTechRecords" />
		<acme:form-integer code="administrator.dashboard.form.label.totalToolRecords" path="totalNumberOfToolRecords" />
	</acme:form-panel>


</acme:form>

