<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html" %>
<%@ taglib prefix="bean" uri="http://struts.apache.org/tags-bean" %>
<%@ page import="com.kadet.handbook.entity.Chapter" %>
<%@ page import="java.util.List" %>
<%@ page import="com.kadet.handbook.client.util.Messages" %>
<%--
  Created by IntelliJ IDEA.
  User: Кадет
  Date: 26.10.13
  Time: 1:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
    <%--<link rel="stylesheet" type="text/css" media="screen"
          href="../../web-resources/bootstrap/css/bootstrap.min.css"/>
--%>
</head>
<body>


<%if (request.getAttribute("editSuccess") != null && (Boolean) request.getAttribute("editSuccess")) { %>
<div class="row">
    <div class="span 6 offset4 well control-group success">
        Обновление успешно!
    </div>
</div>
<%}%>

<div class="row">

    <div class="span6 offset4 well">

        <html:form action="/editChapter" method="POST">
            <%List<Chapter> chapters = (List<Chapter>) request.getAttribute("chapters");%>
            <%if (chapters != null) {%>

            <html:select property="chapterId">
                <%for (Chapter chapter : chapters) {%>
                <html:option value="<%=chapter.getId().toString()%>">
                    <%=chapter.getTitle()%>
                </html:option>
                <%}%>
            </html:select>
            <%}%>

            <br>
            <html:text property="title"/>

            <br/>
            <html:textarea property="text"/>

            <br/>
            <html:submit>
                <bean:message key="label.edit_chapter.submit"></bean:message>
            </html:submit>

            <html:reset>
                <bean:message key="label.edit_chapter.reset"></bean:message>
            </html:reset>

        </html:form>

    </div>

</div>

<div class="row">
    <div class="span6 offset4 well">
        <a href="/openChapter" class="btn btn-default">На главную</a>
    </div>
</div>

</body>
</html>