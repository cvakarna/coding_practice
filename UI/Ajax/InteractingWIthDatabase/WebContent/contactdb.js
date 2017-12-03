
var XMLHttpRequestObject = false;
if(window.XMLHttpRequest){
XMLHttpRequestObject=new XMLHttpRequest();
}else if(window.ActiveXObject){
XMLHttpRequestObject=new AciveXObject("Microsoft.XmlHTTP");
}

function contactServer(){
	
if(XMLHttpRequestObject){
var obj= document.getElementById("message");

XMLHttpRequestObject.open("GET", "/getData", true);
XMLHttpRequestObject.onreadystatechange=function(){
	
	if(XMLHttpRequestObject.readyState==4 && XMLHttpRequestObject.status==200){
			
		obj.innerHTML=XMLHttpRequestObject.responseText;
		
	}
}
console.log("after connection");
XMLHttpRequestObject.send();
console.log("end");

}



}