<%-- 
    Document   : novaConta
    Created on : 23/11/2015, 21:07:17
    Author     : charl
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">

        <link rel="shortcut icon" href="imagens/iconThoCha.ico" type="image/x-icon"/>
        <link href="css/styleP2.css" type="text/css" rel="stylesheet" /> 

        <title>ThoCha</title>

        <script>
            function idP2(el) {
                return document.getElementById(el);
            }

            function idValueP2(el) {
                return document.getElementById(el).value;
            }
        </script>

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
                idP2('celularP2').onkeyup = function () {
                    mascara(this, mudarEl);
                }
            }
        </script>

        <script>
            function campoVazio(el) {
                var nomeValue = idValueP2(el);
                if (el !== "passwordSenhaP2") {
                    if (nomeValue === "") {
                        idP2(el).style.boxShadow = "0px 0px 20px red";
                    } else {
                        idP2(el).style.boxShadow = "none";
                    }
                } else {
                    if (nomeValue === "") {
                        idP2(el).style.boxShadow = "0px 0px 20px red";
                    }
                }
            }
        </script>

        <script>
            function confirmarSenha() {
                var senhaValue1 = idValueP2("passwordSenhaP2");
                var senhaValue2 = idValueP2("passwordConfirmeSenhaP2");

                if (senhaValue1 !== senhaValue2) {
                    idP2("passwordSenhaP2").style.boxShadow = "0px 0px 20px black";
                    idP2("passwordConfirmeSenhaP2").style.boxShadow = "0px 0px 20px black";
                    idP2("passwordSenhaP2");
                } else {
                    idP2("passwordSenhaP2").style.boxShadow = "none";
                    idP2("passwordConfirmeSenhaP2").style.boxShadow = "none";
                }

            }
        </script>

        <script>
        </script>

    </head>
    <body>

        <figure>
            <img src="imagens/ThoCha Logo.png" id="logoThoChaP2"/>
        </figure>

        <section id="sectionNewContaP2">
            <form method="post" action="<%= request.getContextPath()%>/ControleUsuarios?action=cadastrar">

                <label for="nomeP2">Nome</label>
                <div id="clearP2"></div>
                <input type="text" name="nome"  id="nomeP2" placeholder="Nome" maxlength="25" autocomplete="off" onblur="campoVazio('nomeP2')" required="required"/>
                <input type="text" name="sobrenome" id="sobrenomeP2" placeholder="Sobrenome" maxlength="25" autocomplete="off" onblur="campoVazio('sobrenomeP2')" required="required"/>
                <div id="clearP2"></div>

                <label for="emailP2">Email</label>
                <input type="email" name="email" id="emailP2" autocomplete="off" maxlength="50" onblur="campoVazio('emailP2')" required="required"/>

                <label for="passwordSenhaP2">Senha</label>
                <div id="clearP2"></div>
                <input type="password" name="senha" id="passwordSenhaP2" maxlength="25" placeholder="Digita uma senha" autocomplete="off" onblur="campoVazio('passwordSenhaP2')" required="required" />
                <input type="password" name="confirmeSenha" id="passwordConfirmeSenhaP2" maxlength="25" placeholder="Confirme a senha" autocomplete="off" onblur="confirmarSenha()" required="required"/>
                <div id="clearP2"></div>

                <label for="diaP2">Data de Nascimento</label>
                <div id="clearP2"></div>
                <input type="text" name="dia" id="diaP2" placeholder="Dia" maxlength="2" autocomplete="off" onblur="campoVazio('diaP2')"required="required"/>
                <input type="text" name="mes" id="mesP2" list="mesesP2" placeholder="Mês" maxlength="9" autocomplete="off" onblur="campoVazio('mesP2')" required="required"/>
                <datalist id="mesesP2">
                    <option value="Janeiro"></option>
                    <option value="Fevereiro"></option>
                    <option value="Março"></option>
                    <option value="Abril"></option>
                    <option value="Maio"></option>
                    <option value="Junho"></option>
                    <option value="Julho"></option>
                    <option value="Agosto"></option>
                    <option value="Setembro"></option>
                    <option value="Outubro"></option>
                    <option value="Novembro"></option>
                    <option value="Dezembro"></option>
                </datalist>
                <input type="text" name="ano" id="anoP2" placeholder="Ano" maxlength="4" autocomplete="off" onblur="campoVazio('anoP2')" required="required"/>
                <div id="clearP2"></div>

                <label for="selectSexoP2">Sexo</label>
                <input type="text" name="sexo" id="selectSexoP2" list="sexoP2" placeholder="Sou do sexo..." maxlength="10" autocomplete="off" onblur="campoVazio('selectSexoP2')" required="required"/>
                <datalist id="sexoP2">
                    <option value="Masculino">1</option>
                    <option value="Feminino">2</option>
                    <option value="Outros">3</option>
                </datalist>

                <label for="celularP2">Celular</label>
                <input type="text" name="celular" id="celularP2" maxlength="15" placeholder="XX XXXXX-XXXX" autocomplete="off" onblur="campoVazio('celularP2')" required="required"/>

                <input type="button" onclick="window.location = 'index.jsp'" value="Voltar" id="voltarP2" class="botaoP2" />
                <input type="submit" value="Entrar" id="entrarP2" class="botaoP2" />

            </form>

        </section>

    </body>
</html>
