<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div>ๅๅๅ่กจ:</div>
<c:forEach var="item" items="${goodsList}">
    ${item.name}--${item.price}--${item.pic}
</c:forEach>
</body>
</html>
