/**
 * 
 */
/**
 * 
 */
 
 
 function checkEmptyField(fieldId) {
 
 	alert('checkEmptyField '+fieldId);
 	
 }
 
 function validate() {
				var x=document.getElementById('uname').value;
				var y=document.getElementById('upass').value;
				
				console.log('value of x '+x);
				console.log('value of y '+y);

				if(x =="") {
					//alert('Username cannot be blank');	
					document.getElementById("nameErr").innerHTML="Username cannot be blank";
					return false;
				}		
				
				if(y =="") {
					//alert('Password cannot be blank');	return false
					document.getElementById("passErr").innerHTML="Password cannot be blank";
					return false;
				}			
				return true;
			}	
 
 function clearTheForm() {
				document.getElementById('uname').value="";
				document.getElementById('upass').value="";
				
}

function clearNameErrMsg() {
				document.getElementById('nameErr').innerHTML="";

}
			
function clearPassErrMsg() {
				document.getElementById('passErr').innerHTML="";

}
function ValidateEmail()
{
         var mailformat = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;
         var mail=document.getElementById('uemail').value;
         if(mail.match(mailformat))
               {
				   //alert('Valid Email');
                  return true;
               }
        else
             {
                  document.getElementById("emailErr").innerHTML="Invalid Email";
					return false;
             }
             
}
function dobValidate() {


        var today = new Date();
        var nowyear = today.getFullYear();
        var nowmonth = today.getMonth();
        var nowday = today.getDate();
        var b = document.getElementById('udob').value;



        var birth = new Date(b);

        var birthyear = birth.getFullYear();
        var birthmonth = birth.getMonth();
        var birthday = birth.getDate();

        var age = nowyear - birthyear;
        var age_month = nowmonth - birthmonth;
        var age_day = nowday - birthday;


        if (age > 100) {
           // alert("Age cannot be more than 100 Years.Please enter correct age")
           document.getElementById("dobErr").innerHTML="Age cannot be more than 100 Years.Please enter correct age";
            return false;
        }
        if (age_month < 0 || (age_month == 0 && age_day < 0)) {
            age = parseInt(age) - 1;


        }
        if ((age == 18 && age_month <= 0 && age_day <= 0) || age < 18) {
            //alert("Age should be more than 18 years.Please enter a valid Date of Birth");
                       document.getElementById("dobErr").innerHTML="Age should be more than 18 years.Please enter a valid Date of Birth";
            return false;
        }
        return true;
    }
    
function CheckPassword() 
{ 
var decimal=  /^(?=.*\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[^a-zA-Z0-9])(?!.*\s).{8,15}$/;
var pass=document.getElementById('upass').value;
    if(pass.match(decimal)) 
       { 
          //alert('Correct, try another...')
          return true;
       }
    else
       { 
          //alert('Wrong...!')
          document.getElementById("passErr").innerHTML="Invalid password type";
          return false;
       }
} 

