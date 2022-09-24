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

    <input name="a" id="a"  type="number">
    <input name="b" id="b" type="number">
    <a href="" id="add" onclick="add()">Add</a>
    <span>${result}</span>


  </body>
<script>

  function add() {
    let a = document.getElementById("a").value;
    let b = document.getElementById("b").value;
    console.log(a)
    document.getElementById("add").href = "/add/" + a + "/" + b;
  }
</script>
</html>
