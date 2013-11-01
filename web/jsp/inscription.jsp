<%-- 
    Document   : inscription
    Created on : 2013-10-18, 19:59:30
    Author     : galbanie
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<article id="inscription">
    <h3>Inscription</h3>
    <form id="formSignIn" method="POST" action="${pageContext.servletContext.contextPath}/inscrire">
        <input type="hidden" name="secureSignIn" value="inscription" />
        <div>
            <label>Identifiant : </label>
            <input type="text" name="username" title="Votre pseudonyme Ex : JeanJean" />
        </div>
        
        <div>
            <label>Email : </label>
            <input type="text" name="email" title="Une addresse mail valide" />
        </div>
        
        <div>
            <label>Mot de passe : </label>
            <input type="password" name="password" title="Plus de 8 caractères" />
        </div>
        
        <div>
            <label>Confirmer : </label>
            <input type="password" name="confirm" title="Par sécurité rentrer le à nouveau" />
        </div>
        
        <div>
            <input type="submit" value="S'inscrire" />
            <input type="reset" value="Retablir" />
        </div>
    </form>
</article>
