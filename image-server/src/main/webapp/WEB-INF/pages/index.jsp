<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
    @author: guohaozhao (guohaozhao116008@sohu-inc.com)
    @since: 13-5-8 10:40
 --%>
<%@ page contentType="text/html;charset=GBK" language="java" session="false" %>
<html>
<head>
    <title>image-server</title>
</head>
<body>

<h1>

    IMAGE SERVER

</h1>

<body>
<form method="post" name="fileUpload" enctype="multipart/form-data" action="/uploadFile">
    <input type="file" name="myfiles"/><br>
    <input type="file" name="myfiles"/><br>
    <input type="file" name="myfiles"/><br>
    <input type="submit" name="submit" value="Ìá½»">
</form>
</body>


</body>
</html>