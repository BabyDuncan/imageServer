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
<form method="post" name="fileUpload" enctype="multipart/form-data" action="/imageserver/uploadFiles">
    <input type="file" name="myFiles"/><br>
    <input type="file" name="myFiles"/><br>
    <input type="file" name="myFiles"/><br>
    <input type="submit" name="submit" value="提交">
</form>
<hr/>
<form method="post" name="fileUpload" enctype="multipart/form-data" action="/imageserver/uploadFile">
    <input type="file" name="myFile"/><br>
    <input type="submit" name="submit" value="提交普通文件">
</form>
<form method="post" name="fileUpload" enctype="multipart/form-data" action="/imageserver/uploadAvatar">
    <input type="file" name="myFile"/><br>
    <input type="submit" name="submit" value="提交头像">
</form>
</body>


</body>
</html>