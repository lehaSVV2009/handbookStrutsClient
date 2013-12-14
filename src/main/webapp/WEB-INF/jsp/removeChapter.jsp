<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html" %>
<%@ taglib prefix="bean" uri="http://struts.apache.org/tags-bean" %>
<%@ page import="com.kadet.handbook.client.util.Messages" %>
<%@ page import="com.kadet.handbook.entity.Chapter" %>
<%@ page import="java.util.List" %>
<%--
  Created by IntelliJ IDEA.
  User: Кадет
  Date: 26.10.13
  Time: 1:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
    <%--
        <link rel="stylesheet" type="text/css" media="screen"
              href="../../web-resources/bootstrap/css/bootstrap.min.css"/>
    --%>

</head>
<body>

<%if (request.getAttribute("removeSuccess") != null && (Boolean) request.getAttribute("removeSuccess")) { %>
<div class="row">
    <div class="span 6 offset4 well control-group success">
        Удаление успешно!
    </div>
</div>
<%}%>

<div class="row">

    <div class="span6 offset4 well">

        <html:form method="POST" action="/removeChapter">

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

            <html:submit>
                <bean:message key="label.remove_chapter.submit"/>
            </html:submit>

        </html:form>
    </div>

</div>


<%--

<div class="row">

    <div class="span6 offset4 well">
        <form action="/removeChapter" method="POST" role="form">
            <%List<Chapter> chapters = (List<Chapter>) request.getAttribute("chapters");%>
            <%if (chapters != null) {%>

            <select name="removeChapter.id" multiple class="form-control">
                <%for (Chapter chapter : chapters) {%>
                <option value="<%=chapter.getId()%>">
                    <%=chapter.getTitle()%>
                </option>
                <%}%>
            </select>

            <%}%>
            <br>
            <input type="submit" value="<%=Messages.REMOVE_CHAPTER_BUTTON_TEXT%>" class="btn btn-primary"/>
        </form>
    </div>

</div>
--%>

<div class="row">

    <div class="span6 offset4 well">
        <a href="/openChapter" class="btn btn-default">На главную</a>
    </div>

</div>


</body>
</html>