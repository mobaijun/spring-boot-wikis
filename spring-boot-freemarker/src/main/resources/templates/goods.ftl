<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>商品列表</title>
</head>
<body>
<div>商品列表：</div>
<#list goodsList as item>
    ${item.name}--${item.price}--${item.pic}
</#list>
</body>
</html>