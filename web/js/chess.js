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

// Section formulaire
var check = {};

check['username'] = function(element){
    if(/[a-zA-Z0-9]{5,14}/.test(element.value)){
        return true;
    }
    else{
        $(element).effect('bounce',{},500);
        return false;
    }
    
};

check['password'] = function(element){
    if(/[a-zA-Z0-9]{5,14}/.test(element.value)){
        return true;
    }
    else{
        $(element).effect('bounce',{},500);
        return false;
    } 
};


$(document).ready(function(){
    // on active les tooltips dans une fonction anonyme
     $(function() {
        $( document ).tooltip();
    });
    // show hide formulaire de connexion
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
    // verification du formulaire de connexion
    $('#formLogin').submit(function(){
        //var result = false;
        var inputs = $('#formLogin input');
        
        $.ajax({
            type: 'POST',
            url: '/Echequier/connecter',
            timeout: 3000,
            data: {username : inputs[0].value, password : inputs[1].value, method : 'ajax'},
            success: function(data, textStatus, jqXHR) {
                alert(data);
                if(data.test("Member")){
                    
                }
                else{
                    
                }
            },
            error: function(jqXHR, textStatus, errorThrown) {
                alert(errorThrown);
            }
        });
        
        /*for(var i = 0; i < inputs.length; i++){
            if(inputs[i].type === 'text' || inputs[i].type === 'password') result = check[inputs[i].name](inputs[i]) && result;
        }*/
        
        //return result;
    });
    
});