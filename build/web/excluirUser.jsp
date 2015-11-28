<%-- 
    Document   : excluirUser
    Created on : 28/11/2015, 05:17:09
    Author     : charl
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">

        <link rel="shortcut icon" href="imagens/iconThoCha.ico" type="image/x-icon"/>
        <link href="css/styleP6.css" type="text/css" rel="stylesheet" /> 

        <title>Excluir</title>

    </head>
    <body>

        <figure>
            <img src="imagens/ThoCha Logo.png" id="logoThoChaP6"/>
        </figure>

        <section id="sectionLoginP6">
            <form method="post" action="<%= request.getContextPath()%>/ControleUsuarios?action=excluirUser">
                <input type="email" name="loginP6" id="nameLoginP6" value="<%= request.getSession().getAttribute("opcaoEmail")%>" required="required"/>
                <input type="password" name="senhaP6" id="passwordSenhaP6" placeholder="Informe sua Senha" autocomplete="off" required="required"/>
                
                <input type="button" onclick="window.location = 'produtosThoCha.jsp'" value="Voltar" id="voltarP6" class="botaoP6"/>
                <input type="submit" value="Excluir" id="botaoEntrarP6" class="botaoP6"/>
            </form>
            <div id="clearP1"></div>
        </section>

    </body>
</html>
