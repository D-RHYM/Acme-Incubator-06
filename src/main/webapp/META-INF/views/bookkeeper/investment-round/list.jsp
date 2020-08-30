<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<acme:list>
	<acme:list-column code="bookkeeper.investmentRound.list.label.title" path="title"/>
	<acme:list-column code="bookkeeper.investmentRound.form.label.ticker" path="ticker"/>
	<acme:list-column code="bookkeeper.investmentRound.form.label.amount" path="amount"/>
</acme:list>