angular.module("AppMode", [])
.controller("AppCtrl",[function(){
	/* This is also known as a controller  */ 
	var self = this;
	 self.about = "AppMod";
	 
	 
		 
	  
	 	 
		 
	 
	  self.student = 
	 
	 
{"id":110,"firstname":"Gary","lastname":"Gould","gpa":2.5,"sat":1100,"majorid":null, vis: true};



	
	 
self.hideStudent = function(parm){
   for(var std of self.students){
             if (std.id == parm){
				 
				 std.vis= false;
			 }
			 
			 }
		
		 }
	 

	 self.resetStudent = function(){
		 for (var std of self.students){
			 
			 std.vis = true;
		
		 }
	 };
	 
	
	 
	 
	 
}]); //End controller