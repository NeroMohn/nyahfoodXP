
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>NyahFood</title>
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
			jQuery(document).ready(function($) {
				$(".scroll").click(function(event){		
					event.preventDefault();
					$('html,body').animate({scrollTop:$(this.hash).offset().top},1200);
				});
			});
		</script>
<script src="js/simpleCart.min.js"> </script>	
</head>
<body>
    <!-- header-section-starts -->
	<div class="header">
		<div class="container">
			<div class="top-header">
				<div class="logo">
					<a href="index.jsp"><h1>NyahFood</h1></a>
				</div>
				<div class="queries">
					<p>Duvidas? Ligue para n�s, � gr�tis!<span>0800-0000-7777 </span><label>(11AM � 11PM) </label> </p>  
                                       
				</div>

				<div class="clearfix"></div>
			</div>
		</div>
		<div class="menu-bar">
			<div class="container">
				<div class="top-menu">
					<ul>
                                                
						<li class="active"><a href="index.jsp">Inicio</a></li>|
                                                 <li><a href="Relatorio.jsp">Relatorio</a></li>
						
                                               
                                                <% if (session.getAttribute("tipo") == "1") { %>
                                                    <li><a href="PesquisaLojaController">Restaurantes</a></li>
                                                    <li><a href="PesquisaPedidoCliente.jsp">Historico</a></li>
                                                    <li><a href="PesquisaCompraCliente.jsp">Acompanhar Pedido</a></li>
                                                
                                                   
                                            <% } %>
                                                     <% if (session.getAttribute("tipo") == "2") { %>
                                                    <li><a href="ManterComidaController?acao=prepararOperacao&operacao=Incluir">Cadastrar Comida</a></li>
                                                   <li><a href="PesquisaComidaLojaController">Seus Cadastros</a></li>
                                                    <li><a href="PesquisaComidaPedida.jsp">Pedidos</a></li>
                                            <% } %>
                                                 <% if (session.getAttribute("tipo") == "3") { %>
                                                    <li><a href="AdminLogado.jsp">ADMINISTRADOR</a></li>
                                                   
                                                    
                                            <% } %>
                                                
                                                
						<div class="clearfix"></div>
					</ul>
				</div>
				<div class="login-section">
					<ul>                      
                                              <% if (session.getAttribute("tipo") == null) { %>
                                               <li><a  href="LoginLojaController?acao=preparar">Login Loja</a></li>
                                            <% } else {%>
                                               
                                            <% } %>
                                                
                                         
                                              <% if (session.getAttribute("tipo") == null) { %>
                                               <li><a href="LoginClienteController?acao=preparar">Login Cliente</a></li>
                                               <li><a href="CadastroLojaController?acao=prepararOperacao&operacao=Incluir">Registrar Loja</a> </li>
                                                <li><a href="CadastroClienteController?acao=prepararOperacao&operacao=Incluir">Registrar Cliente</a> </li>
                                            <% } else {%>
                                               
                                            <% } %>
                                       
                                   
                                               |
                                           
                                           
                                            
                                            <% if (session.getAttribute("tipo") == null) { %>
                                            
                                            <% } else {%>
                                                <li id="BemVindo">Bem-Vindo <%=session.getAttribute("login")%></li>
                                                <li ><a href="LogoutController" id="Logout">Deslogar</a></li>
                                            <% } %>
                                        
                                         
                                   
                                            
                                            <div class="clearfix"></div>
					</ul>
				</div>
				<div class="clearfix"></div>
			</div>
		</div>
		
				

</body>
</html>