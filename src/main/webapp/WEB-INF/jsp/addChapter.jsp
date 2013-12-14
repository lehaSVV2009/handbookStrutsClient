<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html" %>
<%@ taglib prefix="bean" uri="http://struts.apache.org/tags-bean" %>
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
    <link rel="stylesheet" type="text/css" media="screen"
          href="web-resources/bootstrap/css/bootstrap.min.css"/>
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

        <html:form method="POST" action="/addChapter">

            <html:text property="title"/>
            <br/>
            <html:textarea property="text" />

            <br/>
            <html:submit>
                <bean:message key="label.add_chapter.submit"/>
            </html:submit>

            <html:reset>
                <bean:message key="label.add_chapter.reset"/>
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