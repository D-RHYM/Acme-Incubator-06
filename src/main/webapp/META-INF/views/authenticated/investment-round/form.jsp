<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<acme:form readonly="true">

    <acme:form-textbox code="authenticated.investmentRound.form.label.title" path="title" />
    <acme:form-textbox code="authenticated.investmentRound.form.label.ticker" path="ticker" />
    <acme:form-moment  code="authenticated.investmentRound.form.label.moment" path="moment" />
    <acme:form-textbox code="authenticated.investmentRound.form.label.round" path="round" />
    <acme:form-textarea code="authenticated.investmentRound.form.label.description" path="description" />
    <acme:form-money code="authenticated.investmentRound.form.label.amount" path="amount" />
    <acme:form-textbox code="authenticated.investmentRound.form.label.link" path="link" />
    
    <a href=/acme-incubator/authenticated/activity/list?id=${id}>
    	<acme:message code="authenticated.investmentRound.activity.list"/>
    </a>
    
	<br>
	<br>
		
	<acme:form-submit test="${command == 'show'}" code="authenticated.investmentRound.form.button.create-forum" action="/authenticated/discussion-forum/create?investId=${id}" method="get" />
		<acme:form-submit test="${command == 'show'}" code="authenticated.investmentRound.form.button.list-accounting-record"
		action="/authenticated/accounting-record/list?id=${id}" method="get" />	
		
		
	<acme:form-return code="authenticated.investmentRound.form.button.return" />
</acme:form>