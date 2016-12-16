<%@ page import="java.util.List" %>
<%@ page import="model.Cliente" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head><body>
<div>
    <%
        Object msg = request.getAttribute("msg");
        if (msg!=null){
            String msgStr = (String)msg;
            out.println(msg);
        }
    %>
</div>
<form method="post" action="cliente">
    E-mail:
    <input type="text" value="" name="email" />
    <input type="submit" value="save" />
</form>
<%
    List<Cliente> lista = (List<Cliente>)request.getAttribute("lista");
    for (Cliente c : lista){
        out.println(c.getEmail() + "<br/>");
    }
%>
</body>
</html>