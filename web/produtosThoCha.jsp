<%-- 
    Document   : produtosThoChaa
    Created on : 26/11/2015, 18:42:41
    Author     : charl
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">

        <link rel="shortcut icon" href="imagens/iconThoCha.ico" type="image/x-icon"/>
        <link href="css/styleP3.css" type="text/css" rel="stylesheet" /> 

        <title>ThoCha</title>

    </head>

    <body>
        <section id="sectionUserP3">
            
            <figure>
                <img src="imagens/ThoCha Logo.png" id="logoThoChaP3" alt="thochaLogo"/>
            </figure>

            <div id="userP3" >
                <label id="nomeUserP3"> <%= request.getSession().getAttribute("userLogin")%> </label>
                <div id="divConfiguracaoP3">
                    <label id="labelOpcaoP3" onclick="window.location = 'configuracao.jsp'" >Configuração</label>
                    <br>
                    <label id="labelSairP3" onclick="window.location = 'index.jsp'" >Sair</label>
                </div>
            </div>

            <div id="clearP3" ></div>
        </section>

        <section id="sectionProdutosP3">
            <figure>
                <a id="linkLogoP3" class="linkP3" href="calendario.jsp"><img src="imagens/iconCalendar.png" id="iconCalendarEventP3" alt="iconCalendar" /></a>
                <a id="linkCalendarP3" class="linkP3" href="calendario.jsp"><img src="imagens/CalendarEvent Logo.png" id="logoCalendarEventP3" alt="/index.html"/></a>
            </figure>
        </section>
    </body>
</html>
