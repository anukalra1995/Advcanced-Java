function valideditform(){
	
	var empname = document.forms["EditForm"]["empname"].value;
	var emploc = document.forms["EditForm"]["emploc"].value;
	var empmail = document.forms["EditForm"]["empmail"].value;
	
	
	if( empname="" || emploc =="" || empmail == ""){
		alert("Please fill the details");
	}
	
	if(empname.length >0 && emploc.length >0 && empmail.length>0 ){
		if(empname.length>100 && emploc.length>500 && empmail.length>100){
			alert("Maximum length of Name, Location and Mail Exceeded");
			window.location.replace("Edit");
		}else if(empname.length>100 || emploc.length>500 || empmail.length>100){
			alert("Maximum length of Name, Location or Mail Exceeded");
			window.location.replace("Edit");
		}
		
	}
}