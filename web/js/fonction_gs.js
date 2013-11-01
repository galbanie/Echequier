/* 
 * Auteur : galbanie
 */


// fonction générique de création d'un objet XMLHttpRequest
function creationXHR(){
    var resultat = null;
    try{// test pour les navigateurs : Mozilla, OPera ...
        resultat = new XMLHttpRequest();
    }catch (Error){
        try{// test pour les navigateurs Internet Explorer > 5.0
            resultat = new ActiveXObject("Msxml2.XMLHTTP");
        }catch (Error){
            try{// test pour les navigateurs Internet Explorer 5.0
                resultat = new ActiveXObject("Microsoft.XMLHTTP");
            }catch (Error){
                resultat = null;
            }
        }
    }
    return resultat;
}

// fonction générique d'ajout d'évènement à un élémént DOM
function addEvent(element, event, func) {
    if (element.addEventListener) { // Si notre élément possède la méthode addEventListener()
        element.addEventListener(event, func, false);
    } else { // Si notre élément ne possède pas la méthode addEventListener()
        element.attachEvent('on' + event, func);
    } 
}

// fonction pour verifier la validé de la date.
function checkDate(element){
    var date = element.value;
    //ex : jj/mm/aaaa
    //var format = /^(\d{1,2}\/){2}\d{4}$/;
    //ex : aaaa-mm-jj
    var format = /^\d{4}[\/\-](0?[1-9]|1[012])[\/\-](0?[1-9]|[12][0-9]|3[01])$/;
    if(!format.test(date)){
        return false;
    }
    else{
        var date_temp = date.split('-');
        date_temp[1] -=1;        // On rectifie le mois !!!
        var ma_date = new Date();
        ma_date.setFullYear(date_temp[0]);
        ma_date.setMonth(date_temp[1]);
        ma_date.setDate(date_temp[2]);
        if(ma_date.getFullYear()==date_temp[0] && ma_date.getMonth()==date_temp[1] && ma_date.getDate()==date_temp[2]){
            return true;
        }
        else{
            return false;
        }
    }
}
    
function createCookie(name,value,days) {
    if (days) {
            var date = new Date();
            date.setTime(date.getTime()+(days*24*60*60*1000));
            var expires = "; expires="+date.toGMTString();
    }
    else var expires = "";
    document.cookie = name+"="+value+expires+"; path=/";
}

function readCookie(name) {
	var nameEQ = name + "=";
	var ca = document.cookie.split(';');
	for(var i=0;i < ca.length;i++) {
		var c = ca[i];
		while (c.charAt(0)==' ') c = c.substring(1,c.length);
		if (c.indexOf(nameEQ) == 0) return c.substring(nameEQ.length,c.length);
	}
	return null;
}

function eraseCookie(name) {
	createCookie(name,"",-1);
}