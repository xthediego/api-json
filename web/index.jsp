<%-- 
    Document   : index
    Created on : 17/10/2022, 21:18:39
    Author     : lglui
--%>

<%@page import= "apis.api_cliente" %>  <!--aqui se llaman a la api cliente para poder utilizarlo aqui -->
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
<%
    api_cliente api__c =new api_cliente();
    System.out.println(api_c.get());
%>
    </body>
</html>
