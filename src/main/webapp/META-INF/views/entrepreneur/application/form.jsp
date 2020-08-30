<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<acme:form>
	<acme:form-textbox code="entrepreneur.application.form.label.ticker" path="ticker" readonly="true"/>
	<acme:form-moment code="entrepreneur.application.form.label.moment" path="moment" readonly="true"/>
	<acme:form-textbox code="entrepreneur.application.form.label.statement" path="statement" readonly="true"/>
	<acme:form-money code="entrepreneur.application.form.label.moneyOffer" path="moneyOffer"/>
	
	<acme:form-select code="entrepreneur.application.form.label.status" path="status">
		<jstl:forEach var="status" items="<%=acme.entities.applications.Status.values()%>">
			<acme:form-option code="entrepreneur.application.form.label.status.${status.name().toLowerCase()}" value="${status.name()}"
				selected="${(requestScope['status'] == status) ? 'true' : 'false'}" />
		</jstl:forEach>
	</acme:form-select>
	
	<jstl:if test="${command == 'update' || status != 'ACCEPTED'}">
		<acme:form-textarea code="entrepreneur.application.form.label.justification" path="justification" />
	</jstl:if>
	
	<acme:form-submit test="${(command == 'show' && status == 'PENDING') || command == 'update'}" code="entrepreneur.application.form.button.update" action="update" />
	
	<acme:form-return code="entrepreneur.investmentRound.form.button.return" />	
</acme:form>