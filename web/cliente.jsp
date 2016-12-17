<%@ page import="java.util.List" %>
<%@ page import="model.Cliente" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <script>
        function confirmar(parametroI) {
            if (window.confirm("Are you sure?")) {
                location.href = "cliente?i=" + parametroI;
            }
        }
    </script>
</head>
<body>
<div>
    <%
        Object msg = request.getAttribute("msg");
        if (msg != null) {
            String msgStr = (String) msg;
            out.println(msg);
        }

    %>

</div>
<form method="post" action="cliente">
    E-mail:
    <input type="text" value="" name="email"/>
    <input type="submit" value="save"/>
</form>
<%
    List<Cliente> lista = (List<Cliente>) request.getAttribute("lista");
    int i = 0;
    for (Cliente c : lista) {

%>

<%=c.getEmail() //o sinal de igual substitui o out.print method e n precisa de ponto e vírgula.
%>

| <a href="javascript:confirmar(<%=i%>)">Excluir</a><br/>

<% i++;
}
%>
</body>
</html>