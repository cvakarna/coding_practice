
	var XMLHttpRequestObject = false;
		if(window.XMLHttpRequest){
		XMLHttpRequestObject=new XMLHttpRequest();
	}else if(window.ActiveXObject){
		XMLHttpRequestObject=new AciveXObject("Microsoft.XmlHTTP");
	}

function loadMessage(){

	if(XMLHttpRequestObject){
		var obj= document.getElementById("message");
		console.log("connection going to open");
		XMLHttpRequestObject.open("GET", "data.xml", true);
		console.log("connection opened");
		XMLHttpRequestObject.onreadystatechange=function(){
			console.log("onreadystatechange");
			if(XMLHttpRequestObject.readyState==1 )
				console.log(1);
			else if(XMLHttpRequestObject.readyState==2 )
				console.log(2);
			else if(XMLHttpRequestObject.readyState==3 )
				console.log(3);
			else if(XMLHttpRequestObject.readyState==4 )
				console.log(4);
			
			if(XMLHttpRequestObject.readyState==4 && XMLHttpRequestObject.status==200){
				console.log("status");
					
				var doc=XMLHttpRequestObject.responseText;
				obj.innerHTML="My favourite football player is "+doc;
				
			}
		}
		console.log("after connection");
		XMLHttpRequestObject.send(null);
		console.log("end");
		
	}

	
	
}