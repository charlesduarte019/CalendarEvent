<%-- 
    Document   : configuracao
    Created on : 28/11/2015, 00:21:15
    Author     : charl
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="shortcut icon" href="imagens/iconThoCha.ico" type="image/x-icon"/>
        <link href="css/styleP5.css" type="text/css" rel="stylesheet" /> 
        
        <title>Opcao</title>
        
        <script>
            function mascara(o, f) {
                v_obj = o;
                v_fun = f;
                setTimeout("execMascara()", 1);
            }
            function execMascara() {
                v_obj.value = v_fun(v_obj.value);
            }
            function mudarEl(v) {
                v = v.replace(/\D/g, ""); //Remove tudo o que não é dígito
                v = v.replace(/^(\d{2})(\d)/g, "($1) $2"); //Coloca parênteses em volta dos dois primeiros dígitos
                v = v.replace(/(\d)(\d{4})$/, "$1-$2"); //Coloca hífen entre o quarto e o quinto dígitos
                return v;
            }
            window.onload = function () {
                document.getElementById('inputCelularP5').onkeyup = function () {
                    mascara(this, mudarEl);
                }
            }
        </script>
        
    </head>
    <body>
        <figure>
            <img src="imagens/ThoCha Logo.png" id="logoThoChaP5"/>
        </figure>

        <section id="sectionNewContaP5">
            <form method="post" action="<%= request.getContextPath()%>/ControleUsuarios?action=opcaoConfiguracao">
                <label id="nomeP5">Nome: </label>
                <input type="text" id="inputNomeP5" name="nome" value="<%= request.getSession().getAttribute("opcaoNome")%>" autocomplete="off"/>
                <label id="sobrenomeP5">Sobrenome: </label>
                <input type="text" id="inputSobrenomeP5" name="sobrenome" value="<%= request.getSession().getAttribute("opcaoSobrenome")%>" autocomplete="off"/>
                <label id="senhaP5">Senha Atual: </label>
                <input type="password" id="inputSenhaAtualP5" name="senhaAtual" autocomplete="off" required="required"/>
                <label id="newSenhaP5">Nova Senha: </label>
                <input type="password" id="inputNewSenhaP5" name="newSenha" autocomplete="off" />
                <label id="emailP5">Email: </label>
                <input type="text" id="inputEmailP5" name="email" value="<%= request.getSession().getAttribute("opcaoEmail")%>" autocomplete="off"/>
                <label id="dataP5">Data de Nascimento: </label>
                <input type="text" id="inputDataP5" name="dataUser" value="<%= request.getSession().getAttribute("opcaoData")%>" autocomplete="off"/>
                <label id="SexoP5">Sexo: </label>
                <input type="text" id="inputSexoP5" name="sexo" value="<%= request.getSession().getAttribute("opcaoSexo")%>" autocomplete="off"/>
                <label id="celularP5">Celular: </label>
                <input type="text" id="inputCelularP5" name="celular" maxlength="15" value="<%= request.getSession().getAttribute("opcaoCelular")%>" autocomplete="off"/>
                <br>

                <input type="button" onclick="window.location = 'produtosThoCha.jsp'" value="Voltar" id="voltarP5" class="botaoP5" />
                <input type="submit" value="Salvar" id="editarP5" class="botaoP5" />

            </form>

        </section>
    </body>
</html>
