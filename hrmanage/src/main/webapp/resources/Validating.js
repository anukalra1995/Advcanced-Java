/**
 * 
 */

function validform(){
	 var user = document.forms["myForm"]["username"].value;
	 var pass= document.forms["myForm"]["password"].value;
	 
	 if(user == "" || pass==""){
		 alert("Please fill the details");
	 }
	 
	 if(user.length >0 && pass.length >0){
		 if(user.length<5 && pass.length < 5){
			alert("username and password should be atleast between 5 and 50 characters long");
			
		}else if(user.length<5 || pass.length < 5 ){
			alert("username or password should be atleast between 5 and 50 characters long");
		}
	 }
}
