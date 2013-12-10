<%@ page import="com.kadet.handbook.client.util.Messages" %>
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
    <%--<link rel="stylesheet" type="text/css" media="screen"
          href="../../web-resources/bootstrap/css/bootstrap.min.css"/>
--%>
</head>
<body>


<%if (request.getAttribute("addSuccess") != null && (Boolean) request.getAttribute("addSuccess")) { %>
<div class="row">
    <div class="span 6 offset4 well control-group success">
        Добавление успешно!
    </div>
</div>
<%}%>

<div class="row">

    <div class="span6 offset4 well">
        <form action="/addChapter" method="POST" role="form">
            <input type="text" name="addChapter.title" class="input-large" placeholder="Название главы"/>
            <br>
            <textarea name="addChapter.text" class="input-large" rows="20" placeholder="Текст"></textarea>
            <br>
            <input type="submit" value="<%=Messages.ADD_CHAPTER_BUTTON_TEXT%>" class="btn btn-primary"/>
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