<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<acme:form readonly="${command != 'create'}">
	<acme:form-hidden path="discussionForumId" />
	<acme:form-textbox code="authenticated.message.form.label.title" path="title" />
	<jstl:if test="${command != 'create'}">
		<acme:form-moment code="authenticated.message.form.label.moment" path="moment" />
		<acme:form-textbox code="authenticated.message.form.label.creator" path="creator.userAccount.username" />
	</jstl:if>
	<acme:form-textarea code="authenticated.message.form.label.body" path="body" />
	<acme:form-textbox code="authenticated.message.form.label.tags" path="tags" />
<jstl:if test="${command == 'create'}">
		<acme:form-checkbox code="authenticated.message.form.label.confirm" path="confirm" />
	</jstl:if>

	<acme:form-submit test="${command == 'create'}" code="authenticated.message.form.button.create" action="create" />
	<acme:form-return code="authenticated.message.form.button.return" />
</acme:form>