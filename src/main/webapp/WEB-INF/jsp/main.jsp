<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html" %>
<%@ taglib prefix="bean" uri="http://struts.apache.org/tags-bean" %>
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

        <html:form action="/openChapter" method="GET">

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

            <br/>
            <html:submit>
                <bean:message key="label.open_chapter.submit"/>
            </html:submit>

        </html:form>

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