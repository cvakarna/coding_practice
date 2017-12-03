
var dateAndTime=new Date();

	document.getElementById("day").innerHTML=getDate(dateAndTime.getDay());

	var timeIn24Hours=dateAndTime.getHours();

    document.getElementById("time").innerHTML=getTime(timeIn24Hours)+' : '+dateAndTime.getMinutes()+" : "+dateAndTime.getSeconds()

    
	function getDate(daysInNUmber){
		var day=["Sunday","Monday","Tuesday","Wednesday","Thrusday","Friday","Saturday"];
		return day[daysInNUmber];
	}

	function getTime(timeIn24Hours){
		return timeIn24Hours > 12 ? (timeIn24Hours-12):timeIn24Hours;
	}