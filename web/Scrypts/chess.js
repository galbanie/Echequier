/* 
 * Auteur : galbanie
 */

var oXHR = creationXHR();

function refresh(){
    function processStateChange(){
        if (oXHR.readyState === 4){ //complété
            if (oXHR.status === 200) { //réponse OK
                
            }
        }
    }
    
    oXHR.open('POST','/Echequier/refresh');
    oXHR.send(null);
}

$(document).ready(function(){
    // show hide fromulaire de connexion
    $('#seConnecter').click(function(){
        if($('#formLogin').css('display') === 'none'){
            $('#seConnecter').html('Annuler');
            $('#formLogin').fadeIn('slow');
        }
        else if($('#formLogin').css('display') === 'inline-block'){
            $('#seConnecter').html('Connexion');
            $('#formLogin').fadeOut('slow');
        }
    });
    
    // show hide barre de recherche partie
    $('#btnSP').click(function(){
        if($('#searchBarP').css('display') === 'none'){
            $('#searchBarP').fadeIn('slow');
        }
        else{
            $('#searchBarP').fadeOut('slow');
        }
    });
    // show hide barre de recherche Connecte
    $('#btnSC').click(function(){
        if($('#searchBarC').css('display') === 'none'){
            $('#searchBarC').fadeIn('slow');
        }
        else{
            $('#searchBarC').fadeOut('slow');
        }
    });
    
    
    
});