package com.ssa.controller;


import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
@ComponentScan(basePackages="com.ssa")
public class WebsiteController {
	

	
@RequestMapping("/")   //This is the home page
    public ModelAndView home(HttpServletRequest request, ModelAndView mv) {
        if(request.getParameter("name") != null){
            mv.addObject("name", request.getParameter("name"));
        }
        mv.setViewName("home");
        return mv;
    }	


@RequestMapping("/about")
    public ModelAndView about(HttpServletRequest request, ModelAndView mv) {
     /*   if(request.getParameter("name") != null){
            mv.addObject("name", request.getParameter("name"));
        }*/
        mv.setViewName("about");
        return mv;
    }	
	
@RequestMapping("/help")
public ModelAndView help(HttpServletRequest request, ModelAndView mv) {
    if(request.getParameter("id") != null){
    	
    	HashMap<Integer, String> helpdesc = new HashMap<Integer, String>();
    	
    	helpdesc.put(1,"Spring Help");
    	helpdesc.put(2, "Maven Help");
    	helpdesc.put(3, "MVC Controller Help");
    	helpdesc.put(4, "JavaScript Help");
    	helpdesc.put(5, "Java Help");
    	
    
  
    	
   mv.addObject("id",request.getParameter("id"));
	int mKey = Integer.parseInt(request.getParameter("id"));
   mv.addObject("desc",helpdesc.get(mKey));
   

    	
        }
    mv.setViewName("help");
    return mv;
}




}
