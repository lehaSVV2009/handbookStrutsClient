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

<div class="row">

    <div class="span6 offset4 well">
        <a href="/openChapter" class="btn btn-default">На главную</a>
    </div>

</div>


</body>
</html>