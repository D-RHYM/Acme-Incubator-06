
<%--
- list.jsp
-
- Copyright (c) 2019 Rafael Corchuelo.
-
- In keeping with the traditional purpose of furthering education and research, it is
- the policy of the copyright owner to permit non-commercial use and redistribution of
- this software. It has been tested carefully, but it is not guaranteed for any particular
- purposes.  The copyright owner does not message-thread any warranties or representations, nor do
- they accept any liabilities with respect to them.
--%>

<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<acme:list>
	<acme:list-column code="authenticated.discussion-forum.list.label.investmentRound.ticker" path="investmentRound.ticker" width="10%" />
	<acme:list-column code="authenticated.discussion-forum.list.label.investmentRound.title" path="investmentRound.title" width="10%" />
	<acme:list-column code="authenticated.discussion-forum.list.label.creator" path="creator.userAccount.username" width="10%" />
	<acme:list-column code="authenticated.discussion-forum.list.label.investmentRound.description" path="investmentRound.description" width="70%" />
</acme:list>


