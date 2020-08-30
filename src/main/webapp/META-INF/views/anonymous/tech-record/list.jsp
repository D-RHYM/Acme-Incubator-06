<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<acme:list>
	<acme:list-column code="anonymous.techRecord.list.label.title" path="title" width="34%" />
	<acme:list-column code="anonymous.techRecord.list.label.activitySector" path="activitySector" width="33%" />
	<acme:list-column code="anonymous.techRecord.list.label.stars" path="stars" width="33%" />
</acme:list>