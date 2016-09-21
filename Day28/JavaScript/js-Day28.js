$(document).ready(function(){
	
	var displayNum = Number($("input").val());
	
	
	
	
	$("#add").click(function() {
    
	console.log(displayNum);
	
	
	displayNum ++;
	console.log("increment button"); 
	if (displayNum > 8){
		
		 $("#input").addClass("above8");
	}
	else{
		$("#input").removeClass("above8");
	}
	$("#input").val(displayNum);
	
	});
	
	$("#sub").click(function() {
    
	console.log(displayNum);
	displayNum --;
	if (displayNum > 8){
		
		 $("#input").addClass("above8");
	}
	else{
		$("#input").removeClass("above8");
	}
	$("#input").val(displayNum);
		
	});
	
	$("#res").click(function() {
    
	console.log(displayNum);
	displayNum = 0;
	$("#input").removeClass("above8");
	$("#input").val(displayNum);
	
	});
	
});
	
	
		
	
