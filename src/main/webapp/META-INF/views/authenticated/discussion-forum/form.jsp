<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<acme:form>
	<acme:form-hidden path="investId"/>
	<jstl:if test="${command == 'create' || command == 'show'}">
		<acme:form-textbox code="authenticated.discussion-forum.form.label.investmentRound.title" path="investmentRound.title" readonly = "true"/>
		<acme:form-textbox code="authenticated.discussion-forum.form.label.creator" path="creator.userAccount.username" readonly = "true"/>
	</jstl:if>


	<acme:form-submit test="${command == 'show' }" code="authenticated.discussion-forum.form.button.add-participant" action="/authenticated/participant/create?discussionForumId=${id}"
		method="get" />
	<acme:form-submit test="${command == 'show'}" code="authenticated.discussion-forum.form.button.list-participants" action="/authenticated/participant/list?id=${id}"
		method="get" />
	<acme:form-submit test="${command == 'show'}" code="authenticated.discussion-forum.form.button.add-message"
		action="/authenticated/message/create?discussionForumId=${id}" method="get" />
	
	<acme:form-submit test="${command == 'show'}" code="authenticated.discussion-forum.form.button.list-messages" action="/authenticated/message/list?id=${id}"
		method="get" />
			<acme:form-submit test="${command != 'create'}" code="authenticated.discussion-forum.form.button.delete"
		action="delete" />
			<acme:form-submit test="${command == 'create'}" code="authenticated.discussion-forum.form.button.create"
		action="create" />
	<acme:form-return code="authenticated.discussion-forum.form.button.return" />
</acme:form>