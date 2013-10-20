<%-- 
    Document   : index
    Created on : 2013-10-10, 13:02:15
    Author     : galbanie
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/natif/base.css" rel="stylesheet" type="text/css">
        <link href="css/natif/style.css" rel="stylesheet" type="text/css">
        <link href="css/natif/menu.css" rel="stylesheet" type="text/css">
        <link href="css/ui-darkness/jquery-ui-1.10.3.custom.css" rel="stylesheet" type="text/css">
        
        <script src="js/jquery-1.9.1.js" type="text/javascript" ></script>
        <script src="js/jquery-ui-1.10.3.custom.js" type="text/javascript" ></script>
        
        <script src="js/fonction_gs.js" type="text/javascript" ></script>
        <script src="js/chess.js" type="text/javascript" ></script>
        <!--[if lt IE 9]>
        <script src="//html5shim.googlecode.com/svn/trunk/html5.js"></script>
        <![endif]-->
        <script type="text/javascript">
            function re(){
                //refresh();
            }
        </script>
        <style>
            
        </style>
        <title>Echequier</title>
    </head>
    <body onload="setInterval('re()', 1000);">
        <header>
            <nav id="cssmenu">
                <ul>
                    <li><a href="${pageContext.servletContext.contextPath}/">Echec</a></li>
                    <c:if test="${empty sessionScope.joueur}" >
                        <li><a href="${pageContext.servletContext.contextPath}/inscrire">Inscription</a></li>
                    </c:if>
                    <li><a href="${pageContext.servletContext.contextPath}/regles">Règles</a></li>
                </ul>
                
                <ul id="ulLogin">
                    <c:choose >
                         <c:when test="${empty sessionScope.joueur}" >
                             <li id="liForm">
                                <form name="formLogin" id="formLogin" method="POST" action="${pageContext.servletContext.contextPath}/connecter" style="display: none;">
                                    <input type="text" name="username" placeholder="Identifiant" title="Entrer votre identifiant dans ce champs." />
                                    <input type="password" name="password" placeholder="Mot de passe" title="Entrer votre mot de passe dans ce champs." />
                                    <input type="submit" value="Connexion" />
                                </form>
                            </li>
                            <li ><a href="#" id="seConnecter">Connexion</a></li>
                        </c:when>
                        <c:otherwise>
                        <li ><a href="${pageContext.servletContext.contextPath}/${sessionScope.joueur.identifiant}" id="identifiantMenu"><c:out value="${sessionScope.joueur.identifiant}" /></a></li>
                        <li ><a href="${pageContext.servletContext.contextPath}/deconnexion" id="">deconnexion</a></li>
                        </c:otherwise>
                    </c:choose>
                </ul>
            </nav>
        </header>
        
        <section id="sidebarGauche">
            <aside id="parties">
                <h4>Parties</h4>
                <a href="#" id="btnSP" class="btnS" title="Rechercher une partie en cours."></a>
                <input type="search" id="searchBarP" style="display: none;" />
                <ol id="listePartie">
                    <li><a href="#">galbanie vs yanis</a></li>
                </ol>
            </aside>

            <aside id="connectes">
                <h4>Connectés</h4>
                <a href="#" id="btnSC" class="btnS" title="Rechercher un joueur libre."></a>
                <input type="search" id="searchBarC"  style="display: none;"/>
                <ol id="listeConnecte" onload="">
                    <!--li><a href="#">galbanie</a></li>
                    <li><a href="#">yanis</a></li-->
                    <%--c:forEach var="joueur" items="${applicationScope.connectes}">
                        <li><a href="#">${joueur.identifiant}</a></li>
                    </c:forEach--%>
                </ol>
            </aside>
        </section>
        
        
        <section id="main">
            <c:choose >
                <c:when test="${empty requestScope.section}" >
                    <jsp:include page="jsp/home.jsp" />
                </c:when>
                <c:otherwise><jsp:include page="jsp/${requestScope.section}.jsp" /></c:otherwise>
            </c:choose>
        </section>
        
        <c:if test="${!empty sessionScope.joueur}" >
            <section id="sidebarDroit">
                <aside id="demande">
                    <h4>Mes demandes</h4>
                    <ol id="listeDemande">
                        <li><a href="#">galbanie vs yanis</a></li>
                    </ol>
                </aside>

                <aside id="recu">
                    <h4>Demandes reçues</h4>
                    <ol id="listeRecu" onload="">
                        <!--li><a href="#">galbanie</a></li>
                        <li><a href="#">yanis</a></li-->
                        <%--c:forEach var="joueur" items="${applicationScope.connectes}">
                            <li><a href="#">${joueur.identifiant}</a></li>
                        </c:forEach--%>
                    </ol>
                </aside>
            </section>
        </c:if>
        
        <footer id="piedPage">
            
        </footer>
        
    </body>
</html>
