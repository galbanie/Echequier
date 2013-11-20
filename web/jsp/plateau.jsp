<%-- 
    Document   : plateau
    Created on : 2013-10-18, 20:00:29
    Author     : galbanie
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<article id="plateau">
    <div id="plateau-chess">
        <table>
            <tr>
                <th></th>
                <th>a</th>
                <th>b</th>
                <th>c</th>
                <th>d</th>
                <th>e</th>
                <th>f</th>
                <th>g</th>
                <th>h</th>
            </tr>
            <tr id="l8">
                <th>8</th>
                <td id="l8c1" class="position-fonce"></td>
                <td id="l8c2" class="position-clair"></td>
                <td id="l8c3" class="position-fonce"></td>
                <td id="l8c4" class="position-clair"></td>
                <td id="l8c5" class="position-fonce"></td>
                <td id="l8c6" class="position-clair"></td>
                <td id="l8c7" class="position-fonce"></td>
                <td id="l8c8" class="position-clair"></td>
                <th>8</th>
            </tr>
            <tr id="l7">
                <th>7</th>
                <td id="l7c1" class="position-clair"></td>
                <td id="l7c2" class="position-fonce"></td>
                <td id="l7c3" class="position-clair"></td>
                <td id="l7c4" class="position-fonce"></td>
                <td id="l7c5" class="position-clair"></td>
                <td id="l7c6" class="position-fonce"></td>
                <td id="l7c7" class="position-clair"></td>
                <td id="l7c8" class="position-fonce"></td>
                <th>7</th>
            </tr>
            <tr id="l6">
                <th>6</th>
                <td id="l6c1" class="position-fonce"></td>
                <td id="l6c2" class="position-clair"></td>
                <td id="l6c3" class="position-fonce"></td>
                <td id="l6c4" class="position-clair"></td>
                <td id="l6c5" class="position-fonce"></td>
                <td id="l6c6" class="position-clair"></td>
                <td id="l6c7" class="position-fonce"></td>
                <td id="l6c8" class="position-clair"></td>
                <th>6</th>
            </tr>
            <tr id="l5">
                <th>5</th>
                <td id="l5c1" class="position-clair"></td>
                <td id="l5c2" class="position-fonce"></td>
                <td id="l5c3" class="position-clair"></td>
                <td id="l5c4" class="position-fonce"></td>
                <td id="l5c5" class="position-clair"></td>
                <td id="l5c6" class="position-fonce"></td>
                <td id="l5c7" class="position-clair"></td>
                <td id="l5c8" class="position-fonce"></td>
                <th>5</th>
            </tr>
            <tr id="l4">
                <th>4</th>
                <td id="l4c1" class="position-fonce"></td>
                <td id="l4c2" class="position-clair"></td>
                <td id="l4c3" class="position-fonce"></td>
                <td id="l4c4" class="position-clair"></td>
                <td id="l4c5" class="position-fonce"></td>
                <td id="l4c6" class="position-clair"></td>
                <td id="l4c7" class="position-fonce"></td>
                <td id="l4c8" class="position-clair"></td>
                <th>4</th>
            </tr>
            <tr id="l3">
                <th>3</th>
                <td id="l3c1" class="position-clair"></td>
                <td id="l3c2" class="position-fonce"></td>
                <td id="l3c3" class="position-clair"></td>
                <td id="l3c4" class="position-fonce"></td>
                <td id="l3c5" class="position-clair"></td>
                <td id="l3c6" class="position-fonce"></td>
                <td id="l3c7" class="position-clair"></td>
                <td id="l3c8" class="position-fonce"></td>
                <th>3</th>
            </tr>
            <tr id="l2">
                <th>2</th>
                <td id="l2c1" class="position-fonce"></td>
                <td id="l2c2" class="position-clair"></td>
                <td id="l2c3" class="position-fonce"></td>
                <td id="l2c4" class="position-clair"></td>
                <td id="l2c5" class="position-fonce"></td>
                <td id="l2c6" class="position-clair"></td>
                <td id="l2c7" class="position-fonce"></td>
                <td id="l2c8" class="position-clair"></td>
                <th>2</th>
            </tr>
            <tr id="l1">
                <th>1</th>
                <td id="l1c1" class="position-clair"></td>
                <td id="l1c2" class="position-fonce"></td>
                <td id="l1c3" class="position-clair"></td>
                <td id="l1c4" class="position-fonce"></td>
                <td id="l1c5" class="position-clair"></td>
                <td id="l1c6" class="position-fonce"></td>
                <td id="l1c7" class="position-clair"></td>
                <td id="l1c8" class="position-fonce"></td>
                <th>1</th>
            </tr>
            <tr>
                <th></th>
                <th>a</th>
                <th>b</th>
                <th>c</th>
                <th>d</th>
                <th>e</th>
                <th>f</th>
                <th>g</th>
                <th>h</th>
            </tr>
        </table>
    </div>
    
    <div id="plateau-droit">
        <div id="plateau-droit-joueur-haut">
            <div id="plateau-droit-joueur-haut-info">
                <table border>
                    <tr>
                        <td id="identifiant-joueur-haut" colspan="2"></td>
                        <td id="classement-joueur-haut"></td>
                    </tr>
                    <tr>
                        <td id="points-joueur-haut" colspan="3"></td>
                    </tr>
                    <tr>
                        <td id="victoire-joueur-haut" class="victoire"></td>
                        <td id="nulle-joueur-haut" class="nulle"></td>
                        <td id="defaite-joueur-haut" class="defaite"></td>
                    </tr>
                </table>
            </div>
            <table id="pion-capturer-haut">
                <caption>Les capturés</caption>
                <tr>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                </tr>
                <tr>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                </tr>
                <tr>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                </tr>
                <tr>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                </tr>
            </table>
        </div>
        <hr style="width: 70%; margin: 18px auto;"/>
        <div id="plateau-droit-joueur-bas">
            <table id="pion-capturer-bas">
                <caption align="bottom" >Les capturés</caption>
                <tr>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                </tr>
                <tr>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                </tr>
                <tr>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                </tr>
                <tr>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                </tr>
            </table>
            <div id="plateau-droit-joueur-bas-info">
                <table border>
                    <tr>
                        <td id="identifiant-joueur-bas" colspan="2"></td>
                        <td id="classement-joueur-bas"></td>
                    </tr>
                    <tr>
                        <td id="points-joueur-bas" colspan="3"></td>
                    </tr>
                    <tr>
                        <td id="victoire-joueur-bas" class="victoire"></td>
                        <td id="nulle-joueur-bas" class="nulle"></td>
                        <td id="defaite-joueur-bas" class="defaite"></td>
                    </tr>
                </table>
            </div>
        </div>
    </div>
    
</article>
