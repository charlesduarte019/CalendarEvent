<%-- 
    Document   : index
    Created on : 23/11/2015, 20:42:52
    Author     : charl
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">

        <link rel="shortcut icon" href="imagens/iconThoCha.ico" type="image/x-icon"/>
        <link href="css/styleP1.css" type="text/css" rel="stylesheet" /> 

        <title>ThoCha</title>

    </head>
    <body>

        <figure>
            <img src="imagens/ThoCha Logo.png" id="logoThoChaP1"/>
        </figure>

        <section id="sectionLoginP1">
            <form method="post" action="<%= request.getContextPath()%>/ControleUsuarios?action=login">
                <input type="email" name="login" id="nameLoginP1" placeholder="Informe seu email" autocomplete="off" required="required"/>
                <input type="password" name="senhaP1" id="passwordSenhaP1" placeholder="Informe sua Senha" autocomplete="off" required="required"/>
                <!--<label id="erroLoginP1" class="erroLoginP1" >O e-mail e a senha que você digitou não coincidem!</label>-->
                <div id="divBotaoP1"></div>
                <input type="submit" value="Entrar" id="botaoEntrarP1" onclick="erro()"/>
            </form>
            <div id="clearP1"></div>
        </section>

        <a href="novaConta.jsp" id="hrefNovaContaP1">Criar uma conta</a>

        <script>
            function erro() {
                if (<%= request.getSession().getAttribute("userErroM")%>) {
                    alert("O email e a senha que você digitou não coincidem!");
                }else{}
            }
        </script> 

    </body>
</html>
