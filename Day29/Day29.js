
$(document).ready(function(){


var token = getSlackToken();

   
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
		
		  $.ajax("https://slack.com/api/chat.postMessage?", {
			
			method: "POST" ,
			data:{
				token: token,
				channel: radio,
				text: msg,
				username: "Message Sent",
				icon_emoji: ":robot_face:"
			}
			

			
			}).then(function(result) {
			console.log(result);
			$("#textbox").val("");
		    $("img").addClass("spin");
			
	 		 
	  });
 
	 });
 
});

});






