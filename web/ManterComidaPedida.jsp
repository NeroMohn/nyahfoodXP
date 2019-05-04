<%-- 
    Document   : ManterComidaPedida
    Created on : 23/10/2018, 18:34:21
    Author     : Yukas
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>



<!DOCTYPE html>
<html>
    <head>
        <title>NyahFood</title>
        <!--Cep automático-->



        <link href="css/bootstrap.css" rel='stylesheet' type='text/css' />
        <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
        <script src="js/jquery.min.js"></script>
        <!-- Custom Theme files -->
        <link href="css/style.css" rel="stylesheet" type="text/css" media="all" />
        <!-- Custom Theme files -->
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
        <!--webfont-->
        <link href='//fonts.googleapis.com/css?family=Source+Sans+Pro:200,300,400,600,700,900,200italic,300italic,400italic,600italic,700italic,900italic' rel='stylesheet' type='text/css'>
        <link href='//fonts.googleapis.com/css?family=Lobster+Two:400,400italic,700,700italic' rel='stylesheet' type='text/css'>
        <!--Animation-->
        <script src="js/wow.min.js"></script>
        <link href="css/animate.css" rel='stylesheet' type='text/css' />
        <script>
            new WOW().init();
        </script>
        <script type="text/javascript" src="js/move-top.js"></script>
        <script type="text/javascript" src="js/easing.js"></script>
        <script type="text/javascript">
            jQuery(document).ready(function ($) {
                $(".scroll").click(function (event) {
                    event.preventDefault();
                    $('html,body').animate({scrollTop: $(this.hash).offset().top}, 1200);
                });
            });
        </script>
        <script src="js/simpleCart.min.js"></script>	

        <script src="jquery-3.2.1.min.js"></script>
        <script>
            $(function () {
                $("#header").load("Header.jsp");

            });
        </script>
    </head>
    <body>
        <!-- header-section-starts -->


        <% if (session.getAttribute("tipo") == "1") { %>
        <div id="header"></div>


        <!-- header-section-ends -->
        <!-- content-section-starts -->
        <div class="content">
            <div class="main">
                <div class="container">
                    <div class="register">

                        <div class="special-offers-section-head text-center dotted-line"> <div class="special-offers-section" > <h1>${operacao} Comida Pedida</h1></br> </div></div>

                        <form action ="ManterComidaPedidaController?acao=confirmarOperacao&operacao=${operacao}"  method = "post" name="ManterComidaPedida">
                            <table>
                                <tr>

                                    <td><input type="hidden" name="txtIdComidaPedida" value="${comida.id}" <c:if test="${operacao != 'Incluir'}"> readonly</c:if>></td>
                                    </tr>
                                    <tr>
                                        <td>Quantidade:</td>
                                        <td><input type="text" name="txtQuantidade" value="${comidaPedida.quantidade}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                                    </tr>
                                   <!--  <tr>
                                        <td>Total:</td>
                                        <td><input type="text" name="txtTotal" value="${comidaPedida.total}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                                    </tr>
                                    <tr>-->
                                        <td>Comida:</td>
                                        <td>
                                            <select name="optComida" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                                     
                                                <option value="${comida.id}"> ${comida.nome}</option>
                          
                                        </select>
                                    </td>
                  
                            </table>

                            <td><input type="submit" name="btnConfirmar" value="Confirmar"></td>

                        </form>



                    </div>
                </div>
            </div>
        </div>
       
<!-- content-section-ends -->
<!-- footer-section-starts -->

<!-- footer-section-ends -->
<script type="text/javascript">
                            $(document).ready(function () {
                                /*
                                 var defaults = {
                                 containerID: 'toTop', // fading element id
                                 containerHoverID: 'toTopHover', // fading element hover id
                                 scrollSpeed: 1200,
                                 easingType: 'linear' 
                                 };
                                 */

                                $().UItoTop({easingType: 'easeOutQuart'});

                            });
</script>
<a href="#" id="toTop" style="display: block;"> <span id="toTopHover" style="opacity: 1;"> </span></a>
<% }%>

</body>
</html>