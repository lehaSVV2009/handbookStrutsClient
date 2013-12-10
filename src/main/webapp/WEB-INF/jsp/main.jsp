<%@ page import="com.kadet.handbook.client.util.Messages" %>
<%@ page import="com.kadet.handbook.entity.Chapter" %>
<%@ page import="java.util.List" %>
<%--
  Created by IntelliJ IDEA.
  User: Кадет
  Date: 23.10.13
  Time: 0:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>

    <%--<link rel="stylesheet" type="text/css" media="screen"
          href="../../web-resources/bootstrap/css/bootstrap.min.css"/>
    <script src="../../web-resources/bootstrap/js/bootstrap.min.js"></script>
    <script src="../../web-resources/bootstrap/js/jquery.min.js"></script>
--%>

</head>
<body>


<br>


<div class="row">

    <div class="span3 well">

        <form action="/openChapter" method="GET" role="form">
            <%List<Chapter> chapters = (List<Chapter>) request.getAttribute("chapters");%>
            <%if (chapters != null) {%>

            <select name="chapterId" multiple class="form-control">
                <%for (Chapter chapter : chapters) {%>
                <option value="<%=chapter.getId()%>">
                    <%=chapter.getTitle()%>
                </option>
                <%}%>
            </select>

            <%}%>

            <input type="submit" value="<%=Messages.OPEN_CHAPTER_BUTTON_TEXT%>" class="btn btn-primary"/>
        </form>

    </div>

    <div class="span6 well" itemscope itemtype="http://schema.org/Book">
        <%String title = (String) request.getAttribute("title");%>
        <%String text = (String) request.getAttribute("text");%>

        <%if (title != null && text != null) {%>
        <h2>
            <b>
                <span itemprop="name">
                    <%=title%>
                </span>
            </b>
        </h2>
        <br>
        <span itemprop="text">
            <%=text%>
        </span>
        <%}%>
    </div>

    <div class="span3 well">

        <div class="row">
            <div class="span2 well">
                <a href="/goToAddChapter" class="btn btn-default">Добавление</a>
            </div>
        </div>
        <div class="row">
            <div class="span2 well">
                <a href="/goToRemoveChapter" class="btn btn-default">Удаление</a>
            </div>
        </div>
        <div class="row">
            <div class="span2 well">
                <a href="/goToEditChapter" class="btn btn-default">Редактирование</a>
            </div>
        </div>

    </div>

</div>


<br>
<br>


</body>
</html>