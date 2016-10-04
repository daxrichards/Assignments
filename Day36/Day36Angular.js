angular.module("AppMode", [])
.controller("AppCtrl",[function(){
	/* This is also known as a controller  */ 
	var self = this;
	 self.about = "AppMod";
	 
	 
		 
	  
	 	 
		 
	 
	  self.students = [
	 
	 
{"id":110,"firstname":"Gary","lastname":"Gould","gpa":2.5,"sat":1100,"majorid":null, vis: true},
{"id":120,"firstname":"Adam","lastname":"Ant","gpa":3.2,"sat":1300,"majorid":null, vis: true},
{"id":130,"firstname":"Howard","lastname":"Hess","gpa":3.7,"sat":1600,"majorid":4, vis: true},
{"id":140,"firstname":"Charles","lastname":"Caldwell","gpa":2.1,"sat":900,"majorid":null, vis: true},
{"id":150,"firstname":"James","lastname":"Joyce","gpa":2.5,"sat":1100,"majorid":null, vis: true},
{"id":160,"firstname":"Doug","lastname":"Dumas","gpa":3.1,"sat":1350,"majorid":2, vis: true},
{"id":170,"firstname":"Kevin","lastname":"Kraft","gpa":2.7,"sat":1000,"majorid":null, vis: true},
{"id":180,"firstname":"Frank","lastname":"Fountain","gpa":2.5,"sat":1000,"majorid":null, vis: true},
{"id":190,"firstname":"Brian","lastname":"Biggs","gpa":2.3,"sat":950,"majorid":null, vis: true	}


	 ];
	 
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