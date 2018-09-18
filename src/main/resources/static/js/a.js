//$(document).ready(function(e) {  
//    alert('test!');  
//});


function aa(){
	 $.get("http://localhost:8080/ha",function(data,status){
		    alert("Data: " + data + "\nStatus: " + status);
		  });
}
