/* 
 * Auteur : galbanie
 */

var syncConnectes = '';
var syncDemandes = '';
var syncParties = '';
var contextPath = '';
var pathServeur = '';

function getTagImagePiece(type,color,id,classe){
    
    var strImg = '<img id="'+id+'" class="'+classe+'" src="Ressources/';
    
    /* 
     * J'aurais pu faire aucun switch si 
     * j'avais renommer le nom des fichiers images comme suit :
     * Ex : Nom actuel = 8.gif Renommer = ChevalierBLACK.gif
     */
    //console.log(type + contextPath);
    switch (type){
        case 'Roi': strImg += (color === 'BLACK')?'10':'5';
        break;
        case 'Reine': strImg += (color === 'BLACK')?'11':'4';
        break;
        case 'Chevalier': strImg += (color === 'BLACK')?'8':'2';
        break;
        case 'Fou': strImg += (color === 'BLACK')?'9':'3';
        break;
        case 'Tour': strImg += (color === 'BLACK')?'7':'1';
        break;
        case 'Pion': strImg += (color === 'BLACK')?'12':'6';
        break;
    }
    
    strImg += '.gif" alt="'+type+' '+color+'" width="70" height="70" />';
    
    return strImg;
}

function showPartie(partie){
    //console.log(partie);
    var joueurNoir = partie.joueurNoir;
    var joueurBlanc = partie.joueurBlanc;
    
    var plateau = partie.chess.plateau;
    var capturesBlack = partie.chess.capturesBlack;
    var capturesWhite = partie.chess.capturesWhite;
    
    $('plateau').ready(function(){
       // background en or pour celui des deux joueurs qui detient le focus.
       if(joueurNoir.focus === 'true') $('#plateau-droit-joueur-haut-info').ready().addClass('focus');
       else $('#plateau-droit-joueur-bas-info').ready().addClass('focus');
       
       // on insere les information sur le joueur du haut
       $('#identifiant-joueur-haut').ready().html(joueurNoir.joueur.identifiant);
       $('#classement-joueur-haut').ready().html('#1');
       $('#points-joueur-haut').ready().html(joueurNoir.joueur.points+' points');
       $('#victoire-joueur-haut').ready().html(joueurNoir.joueur.victoire);
       $('#nulle-joueur-haut').ready().html(joueurNoir.joueur.nulle);
       $('#defaite-joueur-haut').ready().html(joueurNoir.joueur.defaite);
       // on insere les information sur le joueur du bas
       $('#identifiant-joueur-bas').ready().html(joueurBlanc.joueur.identifiant);
       $('#classement-joueur-bas').ready().html('#1');
       $('#points-joueur-bas').ready().html(joueurBlanc.joueur.points+' points');
       $('#victoire-joueur-bas').ready().html(joueurBlanc.joueur.victoire);
       $('#nulle-joueur-bas').ready().html(joueurBlanc.joueur.nulle);
       $('#defaite-joueur-bas').ready().html(joueurBlanc.joueur.defaite);
       
       // on remplit les capturés black
       
       // on remplit les capturés black
       
       // on remplit le plateau 
       for(var i = 0; i < plateau.length; i++){
           
           var position = plateau[i].position;
           var piece = plateau[i].piece;
           
           if(piece !== ""){
               var idtd = '#l'+position.ligne+'c'+position.colonne;
               
               $(idtd).ready().html(getTagImagePiece(piece.type,piece.color,'',''));
           }
           
       } 
       
    });
}

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
            
            var demandes = reponse.demandes;
            
            var parties = reponse.parties;
            
            if(contextPath !== reponse.contextPath) contextPath = reponse.contextPath;
            if(pathServeur !== reponse.pathServeur) pathServeur = reponse.pathServeur;
            
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
                                    +reponse.contextPath+'/demander?qui='+connectes[i].identifiant+'" title="Parties ['+connectes[i].nombrePartieJouees
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
                //console.log(parties);
                if(syncParties !== reponse.syncParties){
                    syncParties = reponse.syncParties;
                    //console.log(parties);
                    if(parties !== null){
                        var content = '';
                        for(var i = 0; i< parties.length; i++){
                            showPartie(parties[i]);
                            content += '<li><a id="p-'+parties[i].id+'" class="" href="'
                                    +reponse.contextPath+'/regarder?partie='+parties[i].id+'">'
                                    +parties[i].joueurNoir.joueur.identifiant+' vs '+parties[i].joueurBlanc.joueur.identifiant
                                    +'</a></li>';
                        }
                        $('#listePartie').html(content);
                    }
                }
            });
            
            // liste des demandes en cours
            $('#listeDemande').ready(function(){
                if(syncDemandes !== reponse.syncDemandes){
                    syncDemandes = reponse.syncDemandes;
                    
                    if(demandes !== null){
                        var content = '';
                        for(var i = 0; i< demandes.length; i++){
                            // si le joueur est l'emetteur de la demande
                            if(reponse.joueur === demandes[i].emetteur){
                                content += '<li><a class="demandeur" href="'
                                    +reponse.contextPath+'/demander?qui='+demandes[i].receveur+'&action=annuler" >'
                                    +demandes[i].receveur+' (A)</a></li>';
                            }
                            // sinon si il est le receveur de la demande
                            else if(reponse.joueur === demandes[i].receveur){
                                $('#dialog-demande-identifiant').ready().html(demandes[i].emetteur);
                                $('#dialog-demande').ready().dialog( "open" );
                                content += '<li><a class="receveur" href="'
                                    +reponse.contextPath+'/jouer?avec='+demandes[i].emetteur+'" >'
                                    +demandes[i].emetteur+' (C)</a></li>';
                            }
                            
                        }
                        $('#listeDemande').html(content);
                    }
                }
            });
            
            /*if(syncDemandes !== reponse.syncDemandes){
                for(var i = 0; i< demandes.length; i++){
                    
                }
            }*/
            
        },
        error: function(jqXHR, textStatus, errorThrown) {
            console.log(textStatus+"--->"+errorThrown);
        }
    });
}

/*function redirigeAuto(context){
    if(window.location.href.indexOf('jouer?a=') > -1){
        alert('ok co 0');
    }
    else if(window.location.href.indexOf('connecter') > -1 || window.location.href.indexOf('deconnexion') > -1){
        window.location.href = context;
        alert('ok co 1');
    }
    else alert('ok co else '+window.location.href);
}*/

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
    
    $(function() {
        $( "#dialog-demande" ).dialog({
          autoOpen: false,
          show: {
            effect: "blind",
            duration: 1000
          },
          hide: {
            effect: "explode",
            duration: 1000
          }
        });
    });
    
    $(function(){
        //redirigeAuto(pathServeur+contextPath);
    });
    
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