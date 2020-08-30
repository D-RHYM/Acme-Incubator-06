  
<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<acme:form>
	<acme:form-url code="bookkeeper.investmentRound.form.label.ticker" path="ticker"/>
	<acme:form-url code="bookkeeper.investmentRound.form.label.moment" path="moment"/>
	<acme:form-url code="bookkeeper.investmentRound.form.label.round" path="round"/>
	<acme:form-url code="bookkeeper.investmentRound.form.label.title" path="title"/>
	<acme:form-url code="bookkeeper.investmentRound.form.label.description" path="description"/>
	<acme:form-url code="bookkeeper.investmentRound.form.label.amount" path="amount"/>
	<acme:form-url code="bookkeeper.investmentRound.form.label.link" path="link"/>
	
	<a href=/acme-incubator/bookkeeper/activity/list?id=${id}>
		<acme:message code="bookkeeper.investmentRound.activity.list"/>
	</a>
	
		<br>
		<br>
			<jstl:choose>
		<jstl:when test="${accountingRecordId != null}">
			<acme:form-submit code="bookkeeper.investmentRound.form.button.show-accounting-record" action="/bookkeeper/accounting-record/show?id=${accountingRecordId}" method="get" />
		</jstl:when>
		<jstl:otherwise>
			<acme:form-submit code="bookkeeper.investmentRound.form.button.create-accounting-record" action="/bookkeeper/accounting-record/create?investId=${id}" method="get" />
		</jstl:otherwise>
	</jstl:choose>
	<acme:form-submit code="bookkeeper.investmentRound.form.button.list-accounting-record" action="/authenticated/accounting-record/list?id=${id}" method="get" />

		<acme:form-submit test="${command == 'show'}"
		code="authenticated.investmentRound.form.button.create-forum" action="/authenticated/discussion-forum/create?investId=${id}" method="get" />
		<acme:form-return code="bookkeeper.investmentRound.form.button.return"/>
</acme:form>