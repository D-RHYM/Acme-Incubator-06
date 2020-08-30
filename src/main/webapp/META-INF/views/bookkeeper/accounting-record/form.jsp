<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<acme:form readonly="${status == 'PUBLISHED'}">
	<acme:form-hidden path="investId" />
	<jstl:if test="${command != 'create'}">
		<acme:form-moment code="bookkeeper.accounting-record.form.label.creationMoment" path="creationMoment" readonly="true" />
	</jstl:if>
	<acme:form-textbox code="bookkeeper.accounting-record.form.label.title" path="title" />
	<acme:form-select code="bookkeeper.accounting-record.form.label.status" path="status">
		<jstl:forEach var="status" items="<%=acme.entities.accountingRecord.AccountingRecordStatus.values()%>">
			<acme:form-option code="bookkeeper.accounting-record.form.label.status.${status.name().toLowerCase()}" value="${status.name()}"
				selected="${(requestScope['status'] == status) ? 'true' : 'false'}" />
		</jstl:forEach>
	</acme:form-select>
	<acme:form-textarea code="bookkeeper.accounting-record.form.label.body" path="body" />

	<acme:form-submit test="${command == 'create'}" code="bookkeeper.accounting-record.form.button.create" action="/bookkeeper/accounting-record/create?investId=${investId}" />
	<acme:form-submit test="${(command == 'show' && status == 'DRAFT') || command == 'update'}" code="bookkeeper.accounting-record.form.button.update"
		action="update" />
	<acme:form-submit test="${(command == 'show') || command == 'update'}" code="bookkeeper.accounting-record.form.button.show-investment-round"
		action="/bookkeeper/investment-round/show?id=${requestScope['investmentRound.id']}" method="get" />
	<acme:form-return code="bookkeeper.accounting-record.form.button.return" />
</acme:form>