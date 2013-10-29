/* 
 * Auteur : galbanie
 */

/*var oXHR = creationXHR();

function refresh(){
    function processStateChange(){
        if (oXHR.readyState === 4){ //complété
            if (oXHR.status === 200) { //réponse OK
                
            }
        }
    }
    
    oXHR.open('POST','/Echequier/refresh');
    oXHR.send(null);
}*/

function refresh(){
        /*$('#listeConnecte').load('/Echequier/ #listeConnecte').fadeIn("slow");
        $('#listePartie').load('/Echequier/ #listePartie').fadeIn("slow");*/
    $.ajax({
        type: 'POST',
        url: '/Echequier/refresh',
        //dataType: 'JSON',
        success: function(data, textStatus, jqXHR) {
            //alert(textStatus+" = "+data+"   "+data.connectes);
            //alert(data.connectes);
            var reponse = $.parseJSON(data);
            //var connectes = reponse.connectes;
            //alert(data.connectes[0].id);
            $('#listeConnecte').ready(function(){
                //alert(reponse.connectes);
                if(reponse.connectes !== null){
                    var content = '';
                    for(var connecte in reponse.connectes){
                        content += '<li><a href="#">'+connecte.identifiant+'</a></li>'
                    }
                    //alert(content);
                    $('#listeConnecte').html(content);
                }
            });
            
            $('#listePartie').ready(function(){
                
            });
        },
        error: function(jqXHR, textStatus, errorThrown) {
            alert(textStatus+"--->"+errorThrown);
        }
    });
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

check['email'] = function(element){
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

check['confirm'] = function(element){
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
    $('#formSignIn').submit(function(){
        var result = false;
        var inputs = $('#formLogin input');
        $.ajax({
            type: 'POST',
            url: '/Echequier/inscrire',
            timeout: 3000,
            data: {username : inputs[0].value, method : 'ajax'},
            success: function(data, textStatus, jqXHR) {
                alert(textStatus);
                if(data.test("Member")){
                    alert('deja existant');
                }
                else{
                    alert(data);
                }
            },
            error: function(jqXHR, textStatus, errorThrown) {
                alert(textStatus+' --- > '+errorThrown);
            }
        });
        for(var i = 0; i < inputs.length; i++){
            if(inputs[i].type === 'text' || inputs[i].type === 'password') result = check[inputs[i].name](inputs[i]) && result;
        }
        return result;
    });
    
    
    
});