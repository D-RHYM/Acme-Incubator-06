<%--
- menu.jsp
-
- Copyright (c) 2019 Rafael Corchuelo.
-
- In keeping with the traditional purpose of furthering education and research, it is
- the policy of the copyright owner to permit non-commercial use and redistribution of
- this software. It has been tested carefully, but it is not guaranteed for any particular
- purposes.  The copyright owner does not offer any warranties or representations, nor do
- they accept any liabilities with respect to them.
--%>

<%@page language="java" import="acme.framework.helpers.PrincipalHelper,acme.entities.roles.Provider,acme.entities.roles.Consumer"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<acme:menu-bar code="master.menu.home">
	<acme:menu-left>
		<acme:menu-option code="master.menu.anonymous" access="isAnonymous()">
      
      <acme:menu-suboption code="master.menu.anonymous.favourite-link" action="http://www.example.com/"/>

      <acme:menu-separator />
      <acme:menu-suboption code="master.menu.anonymous.david-favourite-link-1" action="https://www.youtube.com/"/>
			<acme:menu-suboption code="master.menu.anonymous.list-bulletin-1" action="/anonymous/caceres-bulletin/list" />
			<acme:menu-suboption code="master.menu.anonymous.create-bulletin-1" action="/anonymous/caceres-bulletin/create" />
      
			
			<acme:menu-separator />
			<acme:menu-suboption code="master.menu.anonymous.favourite-link-2" action="http://www.twitter.com/"/>
			<acme:menu-suboption code="master.menu.anonymous.list-bulletin-2" action="/anonymous/gonzalez-bulletin/list" />
			<acme:menu-suboption code="master.menu.anonymous.create-bulletin-2" action="/anonymous/gonzalez-bulletin/create" />
	
	<acme:menu-separator />
			<acme:menu-suboption code="master.menu.anonymous.list-notice" action="/anonymous/notice/list"/>	
	
	<acme:menu-separator />	
			<acme:menu-suboption code="master.menu.anonymous.list-techRecord" action="/anonymous/tech-record/list"/>
		
	<acme:menu-separator />
			<acme:menu-suboption code="master.menu.anonymous.list-tool-record" action="/anonymous/tool-record/list"/>
			
	</acme:menu-option>
		
		<acme:menu-option code="master.menu.authenticated" access="isAuthenticated()">
			<acme:menu-suboption code="master.menu.authenticated.list-notice" action="/authenticated/notice/list"/>
			<acme:menu-suboption code="master.menu.authenticated.list-techRecord" action="/authenticated/tech-record/list"/>
			<acme:menu-suboption code="master.menu.authenticated.list-overture" action="/authenticated/overture/list"/>
			<acme:menu-suboption code="master.menu.authenticated.list-inquirie" action="/authenticated/inquirie/list"/>
			<acme:menu-suboption code="master.menu.authenticated.list-challenge" action="/authenticated/challenge/list"/>
			<acme:menu-suboption code="master.menu.authenticated.list-tool-record" action="/authenticated/tool-record/list"/>
			<acme:menu-suboption code="master.menu.authenticated.list-investment-round" action="/authenticated/investment-round/list"/>
			<acme:menu-suboption code="master.menu.authenticated.list-my-discussion-forum" action="/authenticated/discussion-forum/list-mine" />
		</acme:menu-option>
		
		

		<acme:menu-option code="master.menu.administrator" access="hasRole('Administrator')">
		
		<acme:menu-suboption code="master.menu.administrator.dashboard" action="/administrator/dashboard/show" />
		<acme:menu-separator/>

			<acme:menu-suboption code="master.menu.administrator.list-customisation-parameters"
				action="/administrator/customisation-parameters/list" />
			<acme:menu-separator/>
			<acme:menu-suboption code="master.menu.administrator.list-bookkeeper-requests" action="/administrator/bookkeeper-request/list" />
			<acme:menu-separator/>
			<acme:menu-suboption code="master.menu.administrator.user-accounts" action="/administrator/user-account/list"/>
			<acme:menu-separator/>
			<acme:menu-suboption code="master.menu.administrator.create-notice" action="/administrator/notice/create"/>
			<acme:menu-suboption code="master.menu.administrator.list-notice" action="/administrator/notice/list"/>
			
			<acme:menu-separator/>
			<acme:menu-suboption code="master.menu.administrator.list-challenge" action="/administrator/challenge/list" />
			<acme:menu-suboption code="master.menu.administrator.create-challenge" action="/administrator/challenge/create" />
			
				<acme:menu-separator/>
			<acme:menu-suboption code="master.menu.administrator.list-tool-record" action="/administrator/tool-record/list" />
			<acme:menu-suboption code="master.menu.administrator.create-tool-record" action="/administrator/tool-record/create" />
	<acme:menu-separator/>
			<acme:menu-suboption code="master.menu.administrator.create-techRecord" action="/administrator/tech-record/create"/>
			<acme:menu-suboption code="master.menu.administrator.list-techRecord" action="/administrator/tech-record/list"/>
		<acme:menu-separator/>
			<acme:menu-suboption code="master.menu.administrator.create-overture" action="/administrator/overture/create"/>
			<acme:menu-suboption code="master.menu.administrator.list-overture" action="/administrator/overture/list"/>
			<acme:menu-separator/>
			<acme:menu-suboption code="master.menu.administrator.create-inquirie" action="/administrator/inquirie/create"/>
			<acme:menu-suboption code="master.menu.administrator.list-inquirie" action="/administrator/inquirie/list"/>
			<acme:menu-separator/>
			<acme:menu-suboption code="master.menu.administrator.shutdown" action="/master/shutdown"/>
		</acme:menu-option>

		<acme:menu-option code="master.menu.provider" access="hasRole('Provider')">
			<acme:menu-suboption code="master.menu.provider.favourite-link" action="http://www.example.com/"/>
		</acme:menu-option>

		<acme:menu-option code="master.menu.consumer" access="hasRole('Consumer')">
			<acme:menu-suboption code="master.menu.consumer.favourite-link" action="http://www.example.com/"/>
		</acme:menu-option>
		
		<acme:menu-option code="master.menu.investor" access="hasRole('Investor')">
			<acme:menu-suboption code="master.menu.investor.investementRound" action="/investor/investment-round/list"/>
			<acme:menu-suboption code="master.menu.investor.application" action="/investor/application/list_mine"/>
      	</acme:menu-option>
      	
		<acme:menu-option code="master.menu.entrepreneur" access="hasRole('Entrepreneur')">
			<acme:menu-suboption code="master.menu.entrepreneur.list-mine-application" action="/entrepreneur/application/list-mine"/>
			<acme:menu-suboption code="master.menu.entrepreneur.list-investment-round" action="/entrepreneur/investment-round/list_mine"/>
			<acme:menu-suboption code="master.menu.entrepreneur.create-investment-round" action="/entrepreneur/investment-round/create"/>
		</acme:menu-option>
		
			<acme:menu-option code="master.menu.bookkeeper" access="hasRole('Bookkeeper')">
			<acme:menu-suboption code="master.menu.bookkeeper.accounting-record.list" action="/bookkeeper/accounting-record/list" />
			<acme:menu-suboption code="master.menu.bookkeeper.list-investment-round" action="/bookkeeper/investment-round/list_mine"/>
			<acme:menu-suboption code="master.menu.bookkeeper.list-not-investment-round" action="/bookkeeper/investment-round/list_not_mine"/>
		</acme:menu-option>
		
	</acme:menu-left>

	<acme:menu-right>
		<acme:menu-option code="master.menu.sign-up" action="/anonymous/user-account/create" access="isAnonymous()"/>
		<acme:menu-option code="master.menu.sign-in" action="/master/sign-in" access="isAnonymous()"/>

		<acme:menu-option code="master.menu.user-account" access="isAuthenticated()">
		
		
			<acme:menu-suboption code="master.menu.user-account.bookkeeper-request" action="/authenticated/bookkeeper-request/create"
				access="!hasRole('Bookkeeper')" />
			<acme:menu-suboption code="master.menu.user-account.general-data" action="/authenticated/user-account/update"/>
			<acme:menu-suboption code="master.menu.user-account.become-provider" action="/authenticated/provider/create" access="!hasRole('Provider')"/>
			<acme:menu-suboption code="master.menu.user-account.provider" action="/authenticated/provider/update" access="hasRole('Provider')"/>
			<acme:menu-suboption code="master.menu.user-account.become-consumer" action="/authenticated/consumer/create" access="!hasRole('Consumer')"/>
			<acme:menu-suboption code="master.menu.user-account.consumer" action="/authenticated/consumer/update" access="hasRole('Consumer')"/>
			<acme:menu-suboption code="master.menu.user-account.become-entrepreneur" action="/authenticated/entrepreneur/create" access="!hasRole('Entrepreneur')"/>
			<acme:menu-suboption code="master.menu.user-account.entrepreneur" action="/authenticated/entrepreneur/update" access="hasRole('Entrepreneur')"/>
			<acme:menu-suboption code="master.menu.user-account.become-investor" action="/authenticated/investor/create" access="!hasRole('Investor')"/>
			<acme:menu-suboption code="master.menu.user-account.investor" action="/authenticated/investor/update" access="hasRole('Investor')"/>
		</acme:menu-option>

		<acme:menu-option code="master.menu.sign-out" action="/master/sign-out" access="isAuthenticated()"/>
	</acme:menu-right>
</acme:menu-bar>

