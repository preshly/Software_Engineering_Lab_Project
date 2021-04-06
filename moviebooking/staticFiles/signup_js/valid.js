


function confirmPassword() {  
   var p1 = document.getElementById("p1").value;  
   var p2 = document.getElementById("p2").value; 
   if(p1!=p2) {  
      document.getElementById("message").innerHTML = "Password does not match";  
      return false;  
   }  
}  