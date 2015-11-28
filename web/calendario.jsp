<%-- 
    Document   : calendario
    Created on : 26/11/2015, 17:40:31
    Author     : charl
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <title>CalendarEvent</title>

        <link rel="shortcut icon" href="imagens/iconCalendar.ico" type="image/x-icon"/>
        <link href="css/styleP4.css" type="text/css" rel="stylesheet" /> 
    </head>

    <body>
        <section id="sectionUserP4">
            <figure>
                <img src="imagens/CalendarEvent Logo.png" id="logoCalendarP4">
            </figure>

            <div id="userP4">
                <label id="nomeUserP4"> <%= request.getSession().getAttribute("userLogin")%> </label>
                <div id="divConfiguracaoP4">
                    <label id="labelOpcaoP4" onclick="window.location = 'configuracao.jsp'" >Configuração</label>
                    <br>
                    <label id="labelEcluirP4" onclick="window.location = 'excluirUser.jsp'" >Excluir conta</label>
                    <br>
                    <label id="labelSairP4" onclick="window.location = 'index.jsp'" >Sair</label>
                </div>
            </div>

            <div id="clearP4" ></div>

            <section id="sectionCalendarP4">
                <form>
                    <label>Titulo</label>
                    <input type="text" id="inputTituloP4" />
                    <label>Categoria</label>
                    <input type="text" id="inputCategoriaP4" />
                    <label>Data</label>
                    <input type="date" id="inputDataP4" />
                    <label>Descrição</label>
                    <input type="text" id="inputDescicaoP4" />

                    <input type="button" onclick="window.location = 'produtosThoCha.jsp'" value="Voltar" id="voltarP4" class="botaoP4" />
                    <input type="submit" value="Adicionar" id="entrarP4" class="botaoP4" />
                </form>
            </section>

        </section>



    </body>
</html>
