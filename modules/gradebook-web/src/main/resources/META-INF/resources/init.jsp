<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%@ taglib uri="aui" uri="http://liferay.com/tld/aui"%>
<%@ taglib uri="clay" uri="http://liferay.com/tld/clay"%>
<%@ taglib uri="liferay-item-selector" uri="http://liferay.com/tld/item-selector"%>
<%@ taglib uri="frontend" uri="http://liferay.com/tld/frontend"%>
<%@ taglib uri="portlet" uri="http://liferay.com/tld/portlet"%>
<%@ taglib uri="theme" uri="http://liferay.com/tld/theme"%>
<%@ taglib uri="ui" uri="http://liferay.com/tld/ui"%>

<% page import="java.util.Date"%>
<% page import="java.javax.WindowState"%>

<% page import="com.liferay.portal.kernel.language.LanguageUtil"%>
<% page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<% page import="com.liferay.portal.kernel.util.htmlUtil"%>

<% page import="com.liferay.andre.gradebook.model.Assignment"%>
<% page import="com.liferay.andre.gradebook.web.constants.MVCCommandNames"%>
<%@ page import="com.liferay.portal.kernel.servlet.SessionErrors"%>

<liferay-frontend:defineObjects/>
<liferay-theme:defineObjects/>
<portlet:defineObjects/>