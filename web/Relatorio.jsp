<%-- 
    Document   : 400
    Created on : 29/11/2018, 03:10:50
    Author     : rodri
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div>
            <a href="RelatorioClienteID.jsp">Relatorio Digita</a>
        </div>
        <div>
            <a href="RelatorioLojaCozinha.jsp">Relatorio Select</a>
        </div>
        <div>
            <form action="ReportTestee" method="post">
                <input type ="submit" name="btnReport" value="Testee">

            </form>
        </div>
        <div>
            <form action="RelatorioAdministrador" method="post">
                <input type ="submit" name="btnReport" value="RelatorioAdministrador">

            </form>
        </div>
        <div>
            <form action="RelatorioCliente" method="post">
                <input type ="submit" name="btnReport" value="RelatorioCliente">

            </form>
        </div>
        <div>
            <form action="RelatorioClienteCidade" method="post">
                <input type ="submit" name="btnReport" value="RelatorioClienteCidade">

            </form>
        </div>
        <div>
            <form action="RelatorioLoja" method="post">
                <input type ="submit" name="btnReport" value="RelatorioLoja">

            </form>
        </div>
        <div>
            <form action="RelatorioTipoCozinha" method="post">
                <input type ="submit" name="btnReport" value="RelatorioTipoCozinha">

            </form>
        </div>
    </body>
</html>
