<%--
  Created by IntelliJ IDEA.
  User: safordog
  Date: 02.10.18
  Time: 15:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Apartment</title>
    <link rel="stylesheet" type="text/css" href="/styles/styles.css">
  </head>
  <body>
  <fieldset>
    <div id="logo">
      <u>Apartment's database</u><br><br>
    </div>
    <div id="content">
    <form action="/apartmentsByParameters" method="post">
      <p>choose area of the city:<br><select size="1" name="area">
        <option></option>
        <option value="'Golosiivskyi'">Golosiivskyi</option>
        <option value="'Shevchenkivskyi'">Shevchenkivskyi</option>
        <option value="'Desnianskyi'">Desnianskyi</option>
        <option value="'Obolonskyi'">Obolonskyi</option>
      </select>
      </p>
      <p>input square:<br><input type="number" name="square" min="0.0" max="500.0" step="0.1" value=0.0 placeholder="square"/></p>
      <p>input number of a rooms:<br><input type="number" name="room" min="0" max="10" step="1" value=0 placeholder="number of rooms"/></p>
      <p>input price:<br><input type="number" name="price" min="0" max="10000000" step="10" value=0 placeholder="price"/></p>
      <br><input type="submit" name="find" value="find"/>
      || <input type="submit" name="all" value="get all" formaction="/all" formmethod="get"/>
    </form>
    </div>
  </fieldset>
  </body>
</html>
