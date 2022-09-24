<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
  <form action="/save">
    <p>Sandwich Condiments</p>
    <label>
      <span>Lettuce</span>
      <input type="checkbox" name="condiment" value="lettuce">
    </label>

    <label>
      <span>Tomato</span>
      <input type="checkbox" name="condiment" value="tomato">
    </label>

    <label>
      <span>mustard</span>
      <input type="checkbox" name="condiment" value="mustard">
    </label>
    <label>
      <span>sprout</span>
      <input type="checkbox" name="condiment" value="sprout">
    </label>

    <button type="submit">Submit</button>
  </form>
  <c:forEach var="c" items="${condiment}">
    <span>${c}</span>
  </c:forEach>


  </body>
</html>
