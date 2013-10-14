<%-- 
    Document   : index
    Created on : 2013-10-10, 13:02:15
    Author     : galbanie
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="Styles/base.css" rel="stylesheet" type="text/css">
        <link href="Styles/style.css" rel="stylesheet" type="text/css">
        <link href="Styles/menu.css" rel="stylesheet" type="text/css">
        <script src="Scrypts/jquery-1.10.2.js" type="text/javascript" ></script>
        <script src="Scrypts/fonction_gs.js" type="text/javascript" ></script>
        <script src="Scrypts/chess.js" type="text/javascript" ></script>
        <!--[if lt IE 9]>
        <script src="//html5shim.googlecode.com/svn/trunk/html5.js"></script>
        <![endif]-->
        <title>Echequier</title>
    </head>
    <body>
        <header>
            <nav id="cssmenu">
                <ul>
                    <li><a>Echec</a></li>
                    <li><a>Inscription</a></li>
                    <li><a>Règles</a></li>
                </ul>
                
                <ul id="ulLogin">
                    <li id="liForm">
                        <form name="formLogin" id="formLogin" method="POST" action="" style="display: none;">
                            <input type="text" name="username" placeholder="Identifiant" />
                            <input type="password" name="password" placeholder="Mot de passe" />
                            <input type="submit" value="Connexion" />
                        </form>
                    </li>
                    <li ><a href="#" id="seConnecter">Connexion</a></li>
                    
                </ul>
            </nav>
        </header>
        
        <section id="sidebar">
            <aside id="parties">
                <h4>Parties</h4>
                <a href="#" id="btnSP" class="btnS"></a>
                <input type="search" id="searchBarP" style="display: none;" />
                <ol id="listePartie">
                    <li><a href="#">galbanie vs yanis</a></li>
                </ol>
            </aside>

            <aside id="connectes">
                <h4>Connectés</h4>
                <a href="#" id="btnSC" class="btnS"></a>
                <input type="search" id="searchBarC"  style="display: none;"/>
                <ol id="listeConnecte">
                    <li><a href="#">galbanie</a></li>
                    <li><a href="#">yanis</a></li>
                </ol>
            </aside>
        </section>
        
        
        <section id="main">
            
        </section>
        
        <footer id="piedPage">
            
        </footer>
        
    </body>
</html>
