<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 9/21/2022
  Time: 6:24 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <span>Calculator</span>
    <form method="post" action="/save">
      <input name="a" id="a"  type="number">
      <input name="b" id="b" type="number">
      <button name="button" value="add">+</button>
      <button name="button" value="sub">-</button>
      <button name="button" value="multi">X</button>
      <button name="button" value="divide">/</button>
    </form>
  <span>${result}</span>


  </body>
<script>

</script>
</html>
