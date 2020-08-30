<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<acme:form>
	<acme:form-hidden path="investId"/>
	<acme:form-textbox code="investor.application.form.label.ticker" path="ticker" />
	
	<jstl:if test="${command != 'create'}">
		<acme:form-moment code="investor.application.form.label.moment" path="moment" readonly="true" />
		<acme:form-select code="investor.application.form.label.status" path="status">
			<jstl:forEach var="status" items="<%=acme.entities.applications.Status.values()%>">
				<acme:form-option code="investor.application.form.label.status.${status.name().toLowerCase()}" value="${status.name()}"
					selected="${(requestScope['status'] == status) ? 'true' : 'false'}" />
			</jstl:forEach>
		</acme:form-select>
		<jstl:if test="${status == 'REJECTED'}">
			<acme:form-textarea code="investor.application.form.label.justification" path="justification" />
		</jstl:if>
	</jstl:if>
	
	<acme:form-textarea code="investor.application.form.label.statement" path="statement" />
	<acme:form-money code="investor.application.form.label.moneyOffer" path="moneyOffer" />

	<acme:form-submit test="${command == 'create'}" code="investor.application.form.button.create" action="/investor/application/create?investId=${investId}" />

	<acme:form-return code="investor.application.form.button.return" />
</acme:form>