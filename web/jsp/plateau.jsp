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
            <tr>
                <th>8</th>
                <td class="position-fonce"></td>
                <td class="position-clair"></td>
                <td class="position-fonce"></td>
                <td class="position-clair"></td>
                <td class="position-fonce"></td>
                <td class="position-clair"></td>
                <td class="position-fonce"></td>
                <td class="position-clair"></td>
                <th>8</th>
            </tr>
            <tr>
                <th>7</th>
                <td class="position-clair"></td>
                <td class="position-fonce"></td>
                <td class="position-clair"></td>
                <td class="position-fonce"></td>
                <td class="position-clair"></td>
                <td class="position-fonce"></td>
                <td class="position-clair"></td>
                <td class="position-fonce"></td>
                <th>7</th>
            </tr>
            <tr>
                <th>6</th>
                <td class="position-fonce"></td>
                <td class="position-clair"></td>
                <td class="position-fonce"></td>
                <td class="position-clair"></td>
                <td class="position-fonce"></td>
                <td class="position-clair"></td>
                <td class="position-fonce"></td>
                <td class="position-clair"></td>
                <th>6</th>
            </tr>
            <tr>
                <th>5</th>
                <td class="position-clair"></td>
                <td class="position-fonce"></td>
                <td class="position-clair"></td>
                <td class="position-fonce"></td>
                <td class="position-clair"></td>
                <td class="position-fonce"></td>
                <td class="position-clair"></td>
                <td class="position-fonce"></td>
                <th>5</th>
            </tr>
            <tr>
                <th>4</th>
                <td class="position-fonce"></td>
                <td class="position-clair"></td>
                <td class="position-fonce"></td>
                <td class="position-clair"></td>
                <td class="position-fonce"></td>
                <td class="position-clair"></td>
                <td class="position-fonce"></td>
                <td class="position-clair"></td>
                <th>4</th>
            </tr>
            <tr>
                <th>3</th>
                <td class="position-clair"></td>
                <td class="position-fonce"></td>
                <td class="position-clair"></td>
                <td class="position-fonce"></td>
                <td class="position-clair"></td>
                <td class="position-fonce"></td>
                <td class="position-clair"></td>
                <td class="position-fonce"></td>
                <th>3</th>
            </tr>
            <tr>
                <th>2</th>
                <td class="position-fonce"></td>
                <td class="position-clair"></td>
                <td class="position-fonce"></td>
                <td class="position-clair"></td>
                <td class="position-fonce"></td>
                <td class="position-clair"></td>
                <td class="position-fonce"></td>
                <td class="position-clair"></td>
                <th>2</th>
            </tr>
            <tr id="l-1">
                <th>1</th>
                <td class="position-clair"></td>
                <td class="position-fonce"></td>
                <td class="position-clair"></td>
                <td class="position-fonce"></td>
                <td class="position-clair"></td>
                <td class="position-fonce"></td>
                <td class="position-clair"></td>
                <td class="position-fonce"></td>
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
                        <td colspan="2">Username</td>
                        <td>#45</td>
                    </tr>
                    <tr>
                        <td colspan="3">14570 points</td>
                    </tr>
                    <tr>
                        <td>V</td>
                        <td>N</td>
                        <td>D</td>
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
                        <td colspan="2">Username</td>
                        <td>#45</td>
                    </tr>
                    <tr>
                        <td colspan="3">14570 points</td>
                    </tr>
                    <tr>
                        <td>V</td>
                        <td>N</td>
                        <td>D</td>
                    </tr>
                </table>
            </div>
        </div>
    </div>
    
</article>
