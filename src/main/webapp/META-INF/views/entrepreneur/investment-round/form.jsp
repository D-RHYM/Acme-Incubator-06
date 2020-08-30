  
<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<acme:form>
	<acme:form-textbox code="entrepreneur.investmentRound.form.label.ticker" path="ticker" placeholder="XXX-YY-NNNNNN"/>
	<acme:form-url code="entrepreneur.investmentRound.form.label.moment" path="moment" readonly="true"/>
	<acme:form-url code="entrepreneur.investmentRound.form.label.round" path="round" placeholder="SEED, ANGEL, SERIES-A, SERIES-B, SERIES-C, BRIDGE"/>
	<acme:form-url code="entrepreneur.investmentRound.form.label.title" path="title" placeholder=" "/>
	<acme:form-url code="entrepreneur.investmentRound.form.label.description" path="description" placeholder=" "/>
	<acme:form-url code="entrepreneur.investmentRound.form.label.amount" path="amount" placeholder="1 EUR"/>
	<acme:form-url code="entrepreneur.investmentRound.form.label.link" path="link"/>
	<jstl:if test="${command !='create'}">
		<acme:form-url code="entrepreneur.investmentRound.form.label.finalMode" path="finalMode" readonly="true"/>
	</jstl:if>
		
	<acme:form-submit test="${command != 'create'}" code="entrepreneur.investmentRound.activity.list"
	action="/entrepreneur/activity/list?id=${id}" method="get" />

	
	<jstl:if test="${command != 'create' && finalMode == false}">
		<acme:form-return code="entrepreneur.activity.form.button.create-activity"
			action="/entrepreneur/activity/create?investmentId=${id}" />
	</jstl:if>
		
	<acme:form-submit test="${command == 'show' && finalMode == false}" code="entrepreneur.investmentRound.form.button.update" action="/entrepreneur/investment-round/update"/>
	<acme:form-submit test="${command == 'show'}" code="entrepreneur.investmentRound.form.button.delete" action="/entrepreneur/investment-round/delete"/>
	<acme:form-submit test="${command == 'create'}" code="entrepreneur.investmentRound.form.button.create" action="/entrepreneur/investment-round/create"/>
	<acme:form-submit test="${command == 'update' && finalMode == false}" code="entrepreneur.investmentRound.form.button.update" action="/entrepreneur/investment-round/update"/>
	<acme:form-submit test="${command == 'delete'}" code="entrepreneur.investmentRound.form.button.delete" action="/entrepreneur/investment-round/delete"/>
		
	
	<acme:form-submit test="${command == 'show'}" code="authenticated.investmentRound.form.button.list-accounting-record"
		action="/authenticated/accounting-record/list?id=${id}" method="get" />	
		<acme:form-submit test="${command == 'show'}"
		code="authenticated.investmentRound.form.button.create-forum" action="/authenticated/discussion-forum/create?investId=${id}" method="get" />
		<acme:form-return code="entrepreneur.investmentRound.form.button.return"/>
</acme:form>