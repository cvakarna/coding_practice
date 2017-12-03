function multiplyBy()  
{  
        num1 = document.getElementById("firstNumber").value;  
        num2 = document.getElementById("secondNumber").value;  
        document.getElementById("result").innerHTML = num1 * num2;  
}  
  
function divideBy()   
{   
        num1 = document.getElementById("firstNumber").value;  
        num2 = document.getElementById("secondNumber").value;  
document.getElementById("result").innerHTML = num1 / num2;  
}  

function validate(obj){

	if(obj.value.length==0){
		console.log("length");
			document.getElementById("error1").innerHTML = ""; 
			return;
}

	if(isNaN(obj.value) || (obj.value.trim()=="") ){
	document.getElementById("error1").innerHTML = "Enter a valid Number"; 
	; 
	}
}

