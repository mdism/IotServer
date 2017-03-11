<%-- 
    Document   : Register
    Created on : Mar 11, 2017, 11:14:21 PM
    Author     : mdism
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Register</title>
    </head>
    <body>
        <h1>Please Register</h1>
        <form method="get" action="ServerAPI">
            Name : <br><input type="text" name="name" value="" width="20%"/><br>
            Company : <br><input type="text" name="company" value="" width="20%"/><br>
            Mobile : <br><input type="text" name="mobile" value="" width="20%"/><br>
            Email : <br><input type="text" name="email" value="" width="20%"/><br>
            Password : <br><input type="password" name="password" value="" width="20%"/><br>
            Address : <br><input type="text" name="address" value="" width="20%"/><br>
            Device id : <br><input type="text" name="deviceid" value="" width="20%"/><br><br>
            <input type="submit" value="Register" />
        
    </body>
</html>
