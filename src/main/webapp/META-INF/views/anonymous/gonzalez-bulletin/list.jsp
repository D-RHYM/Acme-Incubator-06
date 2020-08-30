<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<acme:list readonly="true">
	<acme:list-column code="anonymous.gonzalez-bulletin.list.label.moment" path="moment" width="20%" />
	<acme:list-column code="anonymous.gonzalez-bulletin.list.label.screenshot" path="screenshot" width="20%" />
	<acme:list-column code="anonymous.gonzalez-bulletin.list.label.video" path="video" width="20%" />
	<acme:list-column code="anonymous.gonzalez-bulletin.list.label.commentary" path="commentary" width="40%" />
</acme:list>