<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%> 
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<acme:form>
	<acme:form-textbox code="anonymous.caceres-bulletin.form.label.author" path="author" placeholder="David"/>
	<acme:form-integer code="anonymous.caceres-bulletin.form.label.age" path="age" placeholder="20"/>
	<acme:form-url code="anonymous.caceres-bulletin.form.label.url" path="url" placeholder="https://youtube.com/" />

	
	<acme:form-submit code="anonymous.caceres-bulletin.form.button.create" action="/anonymous/caceres-bulletin/create"/>
	<acme:form-return code="anonymous.caceres-bulletin.form.button.return"/>
</acme:form>