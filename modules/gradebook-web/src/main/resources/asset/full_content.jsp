<%@ include file="/init.jsp"%>
<%
AssetRenderer<?> assetRenderer = (AssetRenderer<?>)request.getAttribute(WebKeys.ASSET_R
String viewEntryURL = assetRenderer.getURLView(liferayPortletResponse, WindowState.MAXI
Assignment assignment = (Assignment)request.getAttribute("assignment");
%>
<aui:a cssClass="title-link" href="<%= viewEntryURL %>">
<h3 class="title"><%= HtmlUtil.escape(assignment.getTitle(locale)) %></h3>
</aui:a>
<div class="autofit-col autofit-col-expand">
<%= HtmlUtil.escape(assignment.getDescription()) %>
</div>