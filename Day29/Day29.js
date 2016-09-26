

$(document).ready(function(){



var token = "xoxp-63743851541";



//var token= getSlackToken();


   
   
   
   
	$.ajax("https://slack.com/api/channels.list?",{
			method: "POST",
			data: {
				token: token
			}
			

}).then(function(result) {
  console.log(result);
  
  
  
  
	 for (var i=0; i < result.channels.length; i++) {
      // name is result[i].name
      var item = $("<tr><td><input type=\"radio\" class=\"radio2\" name=\"chatroom\" value=\"" + result.channels[i].name + "\">" + result.channels[i].name + "<br>" + "</td></tr>");

        
      $("#channels").append( item );
	  
	 }
	 
	
	
	 
	 $("button").click(function(){
		 
		 
		 var radio = $("input[name=chatroom]:checked").val();
		
		var msg = $("#textbox").val();
		
		// var token= getSlackToken();
		 $.ajax("https://slack.com/api/chat.postMessage?", {
			method: "POST" ,
			data:{
				token: token,
				channel: radio,
				text: msg,
				username: "Good Job"
				//icon_emoji: ":upside_down_face:"
			}
			

			
			}).then(function(result) {
			console.log(result);
			$("#textbox").val("");
	 		 
	  });
 
	 });
 
});

});






