<%--
  Created by IntelliJ IDEA.
  User: Bora
  Date: 22.7.2019
  Time: 10:33
  To change this template use File | Settings | File Templates.
--%>
<%@page import="User.UserDao"%>
<jsp:useBean id="obj" class="User.UserEntity">
</jsp:useBean>
<jsp:setProperty property="*" name="obj"/>

<%
    int i=UserDao.register(obj);
    if(i>0)
        out.print("You are successfully registered");
%>
