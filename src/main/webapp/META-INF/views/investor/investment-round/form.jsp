<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<acme:form>
	<acme:form-url code="investor.investmentRound.form.label.ticker" path="ticker"/>
	<acme:form-url code="investor.investmentRound.form.label.moment" path="moment"/>
	<acme:form-url code="investor.investmentRound.form.label.round" path="round"/>
	<acme:form-url code="investor.investmentRound.form.label.title" path="title"/>
	<acme:form-url code="investor.investmentRound.form.label.description" path="description"/>
	<acme:form-url code="investor.investmentRound.form.label.amount" path="amount"/>
	<acme:form-url code="investor.investmentRound.form.label.link" path="link"/>
	
	<jstl:if test="${totalApps == 0}">
		<acme:form-return code="investor.application.create" action="/investor/application/create?investId=${id}"/>
	</jstl:if>
	<jstl:if test="${totalApps != 0}">
		<acme:message code="investor.application.exist"/>
	</jstl:if>
	
	<acme:form-return code="investor.investmentRound.form.button.return"/>
</acme:form>