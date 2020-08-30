<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<acme:form>

	<acme:form-hidden path="investmentId" />
	<acme:form-hidden path="finalMode" />
	
	<acme:form-url code="entrepreneur.activity.form.label.title" path="title" placeholder=" "/>
	<acme:form-url code="entrepreneur.activity.form.label.moment" path="moment" readonly="true"/>
	<acme:form-url code="entrepreneur.activity.form.label.deadline" path="deadline" placeholder="yyyy/mm/dd hh:mm"/>
	<acme:form-url code="entrepreneur.activity.form.label.budget" path="budget" placeholder="EUR 14"/>
	
	<acme:form-submit test="${command == 'show' && finalMode == false}" code="entrepreneur.activity.form.button.update" action="/entrepreneur/activity/update" />
	<acme:form-submit test="${command == 'show' && finalMode == false}" code="entrepreneur.activity.form.button.delete" action="/entrepreneur/activity/delete" />
	<acme:form-submit test="${command == 'create'}" code="entrepreneur.activity.form.button.create" action="/entrepreneur/activity/create" />
	<acme:form-submit test="${command == 'update' && finalMode == false}" code="entrepreneur.activity.form.button.update" action="/entrepreneur/activity/update" />
	<acme:form-submit test="${command == 'delete' && finalMode == false}" code="entrepreneur.activity.form.button.delete" action="/entrepreneur/activity/delete" />
	
	<acme:form-return code="entrepreneur.activity.form.button.return"/>
</acme:form>