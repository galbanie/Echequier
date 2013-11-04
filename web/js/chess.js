/* 
 * Auteur : galbanie
 */

var syncConnectes = '';

function refresh(){
        
    $.ajax({
        type: 'POST',
        url: '/Echequier/refresh',
        //dataType: 'JSON',
        success: function(data, textStatus, jqXHR) {
            
            // on transforme la chaine json en objet javascript
            var reponse = eval('('+data+')');
            
            // on transmet les listes dans des variables
            var connectes = reponse.connectes;
            
            // liste des connectés
            $('#listeConnecte').ready(function(){ 
                //console.log(syncConnectes+' ---- '+reponse.syncConnectes);
                if(syncConnectes !== reponse.syncConnectes){
                    syncConnectes = reponse.syncConnectes;
                    if(connectes !== null){
                        var content = '';
                        for(var i = 0; i< connectes.length; i++){
                            var classeCss = '';
                            if(connectes[i].isPartie === 'true') classeCss = 'enPartie';
                            content += '<li><a id="j-'+connectes[i].id+'" class="'+classeCss+'" href="'
                                    +reponse.contextPath+'/jouer/?contre='+connectes[i].identifiant+'" title="Parties ['+connectes[i].nombrePartieJouees
                                    +'] | Victoires ['+connectes[i].victoire+'] | D&eacute;faites ['+connectes[i].defaite
                                    +'] | Nulles ['+connectes[i].nulle+'] | Points ['+connectes[i].points+']">'
                                    +connectes[i].identifiant+'</a></li>';
                        }
                        $('#listeConnecte').html(content);
                    }
                }
                
            });
            // liste des parties en cours
            $('#listePartie').ready(function(){
                
            });
        },
        error: function(jqXHR, textStatus, errorThrown) {
            console.log(textStatus+"--->"+errorThrown);
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
    if(/^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/.test(element.value)){
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
    
    if(element.value === document.inputs['password'].value){
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
    
    // verification du formulaire d'inscription
    $('#formSignIn').submit(function(){
        var result = false;
        var inputs = $('#formSignIn input');
        for(var i = 0; i < inputs.length; i++){
            if(inputs[i].type === 'text' || inputs[i].type === 'password') result = check[inputs[i].name](inputs[i]) && result;
        }
        return result;
    });
    
    $(document).bind('contextmenu',function(event){
        /*$('#contextmenuConnectes').css({'top':event.pageY+'px', 'left': event.pageX+'px'}).show();
        event.preventDefault();
        console.log( event.target);*/
    });
    $(document).bind('click',function(){
        //$('#contextmenuConnectes').hide();
    });
    
    
});