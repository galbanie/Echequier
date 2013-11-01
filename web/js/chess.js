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

/*function readCookie(name) {
	var nameEQ = name + "=";
	var ca = document.cookie.split(';');
	for(var i=0;i < ca.length;i++) {
		var c = ca[i];
		while (c.charAt(0)==' ') c = c.substring(1,c.length);
		if (c.indexOf(nameEQ) == 0) return c.substring(nameEQ.length,c.length);
	}
	return null;
}

function createCookie(name,value,days) {
    if (days) {
            var date = new Date();
            date.setTime(date.getTime()+(days*24*60*60*1000));
            var expires = "; expires="+date.toGMTString();
    }
    else var expires = "";
    document.cookie = name+"="+value+expires+"; path=/";
}*/

function refresh(){
        /*$('#listeConnecte').load('/Echequier/ #listeConnecte').fadeIn("slow");
        $('#listePartie').load('/Echequier/ #listePartie').fadeIn("slow");*/
    $.ajax({
        type: 'POST',
        url: '/Echequier/refresh',
        //dataType: 'JSON',
        success: function(data, textStatus, jqXHR) {
            //alert(data.connectes);
            var reponse = eval('('+data+')');
            var connectes = reponse.connectes;
            //console.log(connectes);
            
            $('#listeConnecte').ready(function(){
                //alert(reponse.connectes);
                //console.log(connectes);
                var cookieSyncConnectes = readCookie('syncConnectes');
                if(cookieSyncConnectes === null || cookieSyncConnectes !== reponse.syncConnectes){
                    createCookie('syncConnectes',reponse.syncConnectes);
                    if(connectes !== null){
                        var content = '';
                        for(var i = 0; i< connectes.length; i++){
                            //console.log(reponse.connectes[i]);
                            var classeCss = '';
                            if(connectes[i].isPartie === 'true') classeCss = 'enPartie';
                            content += '<li><a class="'+classeCss+'" href="#" title="Parties ['+connectes[i].nombrePartieJouees
                                    +'] | Victoires ['+connectes[i].victoire+'] | D&eacute;faites ['+connectes[i].defaite
                                    +'] | Nulles ['+connectes[i].nulle+'] | Points ['+connectes[i].points+']">'
                                    +connectes[i].identifiant+'</a></li>';
                        }
                        $('#listeConnecte').html(content);
                    }
                }
                
            });
            
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
        
        /*$(inputs[0]).change(function(){
           
           alert(this.value);
           
        });*/
        
        
        for(var i = 0; i < inputs.length; i++){
            if(inputs[i].type === 'text' || inputs[i].type === 'password') result = check[inputs[i].name](inputs[i]) && result;
        }
        return result;
    });
    
    
    
});