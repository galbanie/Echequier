/* 
 * Auteur : galbanie
 */

var syncConnectes = '';
var syncDemandes = '';
var syncParties = '';
var contextPath = '';
var pathServeur = '';
var syncjeu = '';
var identifiantJoueur = '';
var pos = new Array();

/*$.urlParam = function(name){
    var results = new RegExp('[\\?&]' + name + '=([^&#]*)').exec(window.location.href);
    if (results===null){
       return null;
    }
    else{
       return results[1] || 0;
    }
};*/

function getTagImagePiece(type,color,id,classe){
    
    var strImg = '<img id="'+id+'" class="'+classe+''+color.toLowerCase()+'" src="Ressources/';
    //var strImg = '<img class="" src="Ressources/';
    
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
    
    $('#plateau').ready(function(){
       // background en or pour celui des deux joueurs qui detient le focus.
       if(joueurNoir.focus === 'true'){
           $('#plateau-droit-joueur-bas-info').ready().removeClass('focus');
           $('#plateau-droit-joueur-haut-info').ready().addClass('focus');
       }
       else{
           $('#plateau-droit-joueur-haut-info').ready().removeClass('focus');
           $('#plateau-droit-joueur-bas-info').ready().addClass('focus');
       }
       
       // on insere les information sur le joueur du haut
       $('#identifiant-joueur-haut').ready().html(joueurNoir.joueur.identifiant);
       $('#classement-joueur-haut').ready().html('#1');
       $('#points-joueur-haut').ready().html(joueurNoir.joueur.points+' points');
       $('#victoire-joueur-haut').ready().html(joueurNoir.joueur.victoire);
       $('#nulle-joueur-haut').ready().html(joueurNoir.joueur.nulle);
       $('#defaite-joueur-haut').ready().html(joueurNoir.joueur.defaite);
       // on insere les information sur le joueur du bas
       $('#identifiant-joueur-bas').ready().html(joueurBlanc.joueur.identifiant);
       $('#classement-joueur-bas').ready().html('#7');
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
           // on construit l'id des td devant contenir les images
           var selectorTd = '#l'+position.ligne+'c'+position.colonne;
               
           if(piece !== ""){
               // on place les images dans les td
               $(selectorTd).ready().html(getTagImagePiece(piece.type,piece.color,'',''));
               
               //console.log(identifiantJoueur);
               
               if(identifiantJoueur === partie.joueurNoir.joueur.identifiant && partie.joueurNoir.focus === 'true'){
                   $(selectorTd+' img.black').draggable({
                        helper: "original",
                        cursor: "move",
                        scope: "#plateau-chess-table",
                        revert: true,
                        containment: "#plateau-chess-table",
                        drag: function( event, ui ) {
                            
                        },
                        start: function( event, ui ) {
                            
                        }
                     });
               }
               else if(identifiantJoueur === partie.joueurBlanc.joueur.identifiant && partie.joueurBlanc.focus === 'true'){
                   $(selectorTd+' img.white').draggable({
                        helper: "original",
                        cursor: "move",
                        stack: '#plateau-chess-table',
                        revert: true,
                        containment: "#plateau-chess-table",
                        drag: function( event, ui ) {
                            
                        },
                        start: function( event, ui ) {
                            //console.log($(this));
                            //console.log(ui);
                        }
                     });
               }
                
               /*$(idtd+' img').draggable({
                  appendTo: "body",
                  helper: "original",
                  cursor: "crosshair",
                  scope: "#plateau",
                  drag: function( event, ui ) {

                  },
                  start: function( event, ui ) {

                  }
               });*/
               
           }
           else $(selectorTd).html('');
           
           $( selectorTd ).droppable({
              activeClass: false,
              hoverClass: "ui-state-hover",
              accept: selectorTd+">img",
              drop: function( event, ui ) {
                  //console.log($(this).children().attr('class').split(' ')+ '----->'+ $(ui.draggable).attr('class').split(' '));
                  //if($(this).children().length === 0 || $(this).children().attr('class').split(' ')[0] !== $(ui.draggable).attr('class').split(' ')[0]){
                      ui.draggable.appendTo($(this)).css({
                            left: '0px',
                            top:  '0px'
                        }).draggable({ /*containment: 'parent'*/ });
                  //}
                  /*ui.draggable.appendTo($(this)).css({
                        left: '0px',
                        top:  '0px'
                    }).draggable({ containment: 'parent' });*/
                  var idtdArr = $(this).attr('id');
                  var ligneDep = pos[0].charAt(1);
                  var colonneDep = pos[0].charAt(3);
                  var ligneArr = idtdArr.charAt(1);
                  var colonneArr = idtdArr.charAt(3);
                  pos = new Array();
                  console.log('ligne depart : '+ligneDep+';colonne depart : '+colonneDep);
                  console.log('ligne arrivee : '+ligneArr+';colonne arrivee : '+colonneArr);
                  console.log(pathServeur+contextPath+'/jouer?partie='+$.urlParam('partie'));
                  //if(pos[0] !== idtdArr){
                      $.post(pathServeur+contextPath+'/jouer',{
                          method : 'ajax',
                          partie : $.urlParam('partie'),
                          ligneDepart : ligneDep,
                          colonneDepart : colonneDep,
                          ligneArrivee : ligneArr,
                          colonneArrivee : colonneArr
                      });
                  //}

              },
              out: function( event, ui ) {
                  //console.log($(this).attr('id'));
                  pos.push($(this).attr('id'));
                  console.log(pos.length+'--->'+pos+'--->'+pos[0]);
              }
            });
           
       } 
       
       /*$( "#plateau-chess table td" ).droppable({
          activeClass: false,
          hoverClass: "ui-state-hover",
          accept: "#plateau-chess-table tr td>img",
          drop: function( event, ui ) {
              //console.log($(this).children().attr('class').split(' ')+ '----->'+ $(ui.draggable).attr('class').split(' '));
              //if($(this).children().length === 0 || $(this).children().attr('class').split(' ')[0] !== $(ui.draggable).attr('class').split(' ')[0]){
                  ui.draggable.appendTo($(this)).css({
                        left: '0px',
                        top:  '0px'
                    }).draggable({ /*containment: 'parent'*/ //});
              //}
              /*ui.draggable.appendTo($(this)).css({
                    left: '0px',
                    top:  '0px'
                }).draggable({ containment: 'parent' });*/
              /*var idtdArr = $(this).attr('id');
              var ligneDep = pos[0].charAt(1);
              var colonneDep = pos[0].charAt(3);
              var ligneArr = idtdArr.charAt(1);
              var colonneArr = idtdArr.charAt(3);
              pos = new Array();
              console.log('ligne depart : '+ligneDep+';colonne depart : '+colonneDep);
              console.log('ligne arrivee : '+ligneArr+';colonne arrivee : '+colonneArr);
              console.log(pathServeur+contextPath+'/jouer?partie='+$.urlParam('partie'));
              //if(pos[0] !== idtdArr){
                  $.post(pathServeur+contextPath+'/jouer',{
                      method : 'ajax',
                      partie : $.urlParam('partie'),
                      ligneDepart : ligneDep,
                      colonneDepart : colonneDep,
                      ligneArrivee : ligneArr,
                      colonneArrivee : colonneArr
                  });
              //}
              
          },
          out: function( event, ui ) {
              //console.log($(this).attr('id'));
              pos.push($(this).attr('id'));
              console.log(pos.length+'--->'+pos+'--->'+pos[0]);
          }
        });*/
        
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
            
            //var identifiantJoueur = '';
            
            identifiantJoueur = $('#identifiantJoueur').ready().text();
            
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
                            if(connectes[i].visible === 'true' && identifiantJoueur !== connectes[i].identifiant){
                                var classeCss = '';
                                if(connectes[i].isPartie === 'true') classeCss = 'enPartie';
                                content += '<li><a id="j-'+connectes[i].id+'" class="'+classeCss+'" href="'
                                        +reponse.contextPath+'/demander?qui='+connectes[i].identifiant+'" title="Parties ['+connectes[i].nombrePartieJouees
                                        +'] | Victoires ['+connectes[i].victoire+'] | D&eacute;faites ['+connectes[i].defaite
                                        +'] | Nulles ['+connectes[i].nulle+'] | Points ['+connectes[i].points+']">'
                                        +connectes[i].identifiant+'</a></li>';
                                
                            }
                            
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
                            //showPartie(parties[i]);
                            if(identifiantJoueur === parties[i].joueurNoir.joueur.identifiant || identifiantJoueur === parties[i].joueurBlanc.joueur.identifiant){
                                content += '<li><a id="p-'+parties[i].id+'" class="" href="'
                                    +reponse.contextPath+'/jouer?partie='+parties[i].id+'">'
                                    +parties[i].joueurNoir.joueur.identifiant+' vs '+parties[i].joueurBlanc.joueur.identifiant
                                    +'</a></li>';
                            }
                            else{
                                content += '<li><a id="p-'+parties[i].id+'" class="" href="'
                                    +reponse.contextPath+'/regarder?partie='+parties[i].id+'">'
                                    +parties[i].joueurNoir.joueur.identifiant+' vs '+parties[i].joueurBlanc.joueur.identifiant
                                    +'</a></li>';
                            }
                            
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
            
            $('#plateau').ready(function(){
                // on verifie si une partie est demander et on affiche celle ci
                if(location.href.toString().indexOf(contextPath+'/jouer') > -1 || location.href.toString().indexOf(contextPath+'/regarder') > -1 ){
                    //console.log("debug");
                    var idPartie = $.urlParam('partie');
                    
                    //console.log(identifiantJoueur);
                    if(idPartie !== null){
                         for(var i = 0; i< parties.length; i++){
                             if(idPartie === parties[i].id){
                                 if(parties[i].syncjeu !== syncjeu){
                                     syncjeu = parties[i].syncjeu;
                                     showPartie(parties[i]);

                                 }
                                 break;
                             }
                         }
                    }
                }
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
    
    $('#plateau').ready(function(){
        
        /*$( "#plateau-chess table td" ).droppable({
          activeClass: false,
          hoverClass: "ui-state-hover",
          accept: "#plateau-chess-table tr td>img",
          drop: function( event, ui ) {
              //console.log($(this).children().attr('class').split(' ')+ '----->'+ $(ui.draggable).attr('class').split(' '));
              //if($(this).children().length === 0 || $(this).children().attr('class').split(' ')[0] !== $(ui.draggable).attr('class').split(' ')[0]){
                  ui.draggable.appendTo($(this)).css({
                        left: '0px',
                        top:  '0px'
                    }).draggable({ /*containment: 'parent' });*/
              //}
              /*ui.draggable.appendTo($(this)).css({
                    left: '0px',
                    top:  '0px'
                }).draggable({ containment: 'parent' });*/
              /*var idtdArr = $(this).attr('id');
              var ligneDep = pos[0].charAt(1);
              var colonneDep = pos[0].charAt(3);
              var ligneArr = idtdArr.charAt(1);
              var colonneArr = idtdArr.charAt(3);
              pos = new Array();
              console.log('ligne depart : '+ligneDep+';colonne depart : '+colonneDep);
              console.log('ligne arrivee : '+ligneArr+';colonne arrivee : '+colonneArr);
              console.log(pathServeur+contextPath+'/jouer?partie='+$.urlParam('partie'));
              $.post(pathServeur+contextPath+'/jouer',{
                  method : 'ajax',
                  partie : $.urlParam('partie'),
                  ligneDepart : ligneDep,
                  colonneDepart : colonneDep,
                  ligneArrivee : ligneArr,
                  colonneArrivee : colonneArr
              });
          },
          out: function( event, ui ) {
              //console.log($(this).attr('id'));
              pos.push($(this).attr('id'));
              console.log(pos.length+'--->'+pos+'--->'+pos[0]);
          }
        });*/
        
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