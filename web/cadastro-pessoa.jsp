<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html lang="pt-br">

<head>
    <title>Cadastro - Cliente</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta charset="UTF-8">

    <script src="https://code.jquery.com/jquery-3.2.1.min.js" integrity="sha256-hwg4gsxgFZhOsEEamdOYGBf13FyQuiTwlAQgxVSNgt4="
        crossorigin="anonymous"></script>

    <script type="text/javascript">

        $(document).ready(function () {

            function limpa_formulário_cep() {
                // Limpa valores do formulário de cep.
                $("#rua").val("");
                $("#bairro").val("");
                $("#cidade").val("");
                $("#uf").val("");
                // $("#ibge").val("");
            }

            //Quando o campo cep perde o foco.
            $("#cep").blur(function () {

                //Nova variável "cep" somente com dígitos.
                var cep = $(this).val().replace(/\D/g, '');

                //Verifica se campo cep possui valor informado.
                if (cep != "") {

                    //Expressão regular para validar o CEP.
                    var validacep = /^[0-9]{8}$/;

                    //Valida o formato do CEP.
                    if (validacep.test(cep)) {

                        //Preenche os campos com "..." enquanto consulta webservice.
                        $("#rua").val("...");
                        $("#bairro").val("...");
                        $("#cidade").val("...");
                        $("#uf").val("...");
                        //$("#ibge").val("...");

                        //Consulta o webservice viacep.com.br/
                        $.getJSON("https://viacep.com.br/ws/" + cep + "/json/?callback=?", function (dados) {

                            if (!("erro" in dados)) {
                                //Atualiza os campos com os valores da consulta.
                                $("#rua").val(dados.logradouro);
                                $("#bairro").val(dados.bairro);
                                $("#cidade").val(dados.localidade);
                                $("#uf").val(dados.uf);
                                //$("#ibge").val(dados.ibge);
                            }
                            else {
                                //CEP pesquisado não foi encontrado.
                                limpa_formulário_cep();
                                alert("CEP não encontrado.");
                            }
                        });
                    }
                    else {
                        //cep é inválido.
                        //limpa_formulário_cep();
                        alert("Formato de CEP inválido.");
                    }
                }
                else {
                    //cep sem valor, limpa formulário.
                    limpa_formulário_cep();
                }
            });
        });

    </script>


</head>


<body>
    <div id="cadastro">
        <form action="" method="post">
            <label for="nome">Nome</label>
            <input type="text" name="nome" class="formulario"><br>
            <label for="CPF">CPF </label>
            <input type="text" name="CPF" id="" class="formulario"><br>
            <label for="emailPessoa">Email </label>
            <input type="email" name="emailPessoa" id=""><br>
            <label for="senha">Senha </label>
            <input type="password" name="senha" id=""><br>
            <label for="senhaConf"> Confirmação de Senha </label>
            <input type="password" name="senhaConf" id=""><br>

            <label for="cep">CEP</label>
            <input type="text" name="cep" id="cep" class="formulario"><br>
            <label for="logradouro">Logradouro</label>
            <input type="text" name="logradouro" id="rua" value="" class="formulario"><br>
            <label for="bairro">Bairro</label>
            <input type="text" name="bairro" id="bairro" value=""><br>
            <label for="cidade">Cidade</label>
            <input type="text" name="cidade" id="cidade" value="" id=""><br>
            <label for="UF">UF</label>
            <input type="text" name="UF" id="uf" value="" id="uf"><br>
            <input type="submit" name="enviar" value="Concluir" id="submit">
            <input type="reset" value="Refazer">
        </form>
        <a href="menu.html"><button>Voltar</button></a>
    </div>

</body>

</html>
