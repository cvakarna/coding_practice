

function loadfunc(){

	var empData={};
	empData["firstName"]=document.getElementById("firstName").value;
	empData["lastName"]=document.getElementById("lastName").value;
	empData["email"]=document.getElementById("email").value;
	
	var address={};
	address["street"]=document.getElementById("street").value;
	address["city"]=document.getElementById("city").value;
	address["state"]=document.getElementById("state").value;
	
	
	empData["address"]=address;
	empData["phone"]=document.getElementById("phone").value;
	
	var json=JSON.stringify(empData);
	var xhttp = new XMLHttpRequest();
	xhttp.open("POST", "toServlet", true);
	xhttp.setRequestHeader('Content-Type','application/x-www-form-urlencoded');
	xhttp.onreadystatechange = function() {
    if (xhttp.readyState == 4 && xhttp.status == 200) {
    	document.getElementById("response").innerHTML=xhttp.responseText;
    }
  };
  	xhttp.send("jsonObj="+json);
}


function loadEmployeeinfo(){
	
	  var xhttp = new XMLHttpRequest();
	  xhttp.open("GET", "getEmployeeDetails", true);
	  xhttp.onreadystatechange = function() {
		  if (xhttp.readyState == 4 && xhttp.status == 200) {
			  var jsonInString=JSON.parse(xhttp.responseText);
			  var response="<tr><td>s.no</td><td>Employee Name</td><td>Email</td><td>Phone</td>" +
			  		          "<td>Street</td><td>City</td><td>State</td></tr>"
			  var i;
			  var emp;
			  for(i=0;i<jsonInString.length;i++ ){
				  emp= jsonInString[i];
    			response += "<tr><td>"+i+"</td><td>"+emp.firstName+" "+emp.lastName+"</td><td>"+
    		              emp.email+"</td><td>"+emp.phone+"</td><td>"+emp.address.street+"</td><td>"+emp.address.city+
    		              "</td><td>"+emp.address.state+"</tr>";
    	}
    	document.getElementById("response").innerHTML=response;
    }
  };
  	xhttp.send(null);
}
