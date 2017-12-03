function checkDate(){

    var idate = document.getElementById("dob");
        resultDiv = document.getElementById("dateError");
        dateReg = /^(?:(?:31(\/|-|\.)(?:0?[13578]|1[02]))\1|(?:(?:29|30)(\/|-|\.)(?:0?[1,3-9]|1[0-2])\2))(?:(?:1[6-9]|[2-9]\d)?\d{2})$|^(?:29(\/|-|\.)0?2\3(?:(?:(?:1[6-9]|[2-9]\d)?(?:0[48]|[2468][048]|[13579][26])|(?:(?:16|[2468][048]|[3579][26])00))))$|^(?:0?[1-9]|1\d|2[0-8])(\/|-|\.)(?:(?:0?[1-9])|(?:1[0-2]))\4(?:(?:1[6-9]|[2-9]\d)?\d{2})$/;

    if(dateReg.test(idate.value)){
        if(isFutureDate(idate.value)){
            resultDiv.innerHTML = "Entered date is a future date";
            resultDiv.style.color = "red";
        } else {
            resultDiv.innerHTML = "It's a valid date";
            resultDiv.style.color = "green";
        }
    } else {
        resultDiv.innerHTML = "Invalid date!";
        resultDiv.style.color = "red";
    }
}
function checkfn() {
	var a = document.getElementById("fn");
	var pan="[a-z]";
	if(a.value.match(pan))   
	{   
		return true;
	}  
	else  
	{   
		var resultDiv = document.getElementById("fnameError");
		resultDiv.innerHTML = "Invalid Name!";
        resultDiv.style.color = "red";
	}  
	
}
function verifyPanId() {
	var s = document.getElementById("panId");
	var resultDiv = document.getElementById("panError");
	var pan="[A-Z]{5}[0-9]{4}[A-Z]{1}";	
	if(s.value.match(pan))   {
		resultDiv.innerHTML = "";
        
		
	} else{
		resultDiv.innerHTML = "Enter a valid PAN";
        resultDiv.style.color = "red";
	}
}
function isFutureDate(idate){
    var today = new Date().getTime(),
        idate = idate.split("/");

    idate = new Date(idate[2], idate[1] - 1, idate[0]).getTime();
    return (today - idate) < 0 ? true : false;
}
