package com.melk.spring;






import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;







@Controller
public class NotificationController {

	
	
	private String Title = "خريد خانه، خريد آپارتمان، خريد ويلا";
	private String Description = "خريد خانه، خريد آپارتمان، خريد ويلا";
	private String keywords = "خريد خانه، خريد آپارتمان، خريد ويلا";
	
	

	
	
	@RequestMapping(value = "/SaveSuccessfully")
	 public String SaveSuccessfully(Model model,@RequestParam("notification") String notification ) {
	
		
		
	
		
		// Adding page title,Description,keywords
		model.addAttribute("pageTitle", Title);
		model.addAttribute("pageDescription",Description );
		model.addAttribute("pageKeywords", keywords);

	
		
		//notification
		model.addAttribute("notification",notification);
	
		

		
		
		return "SaveSuccessfully";
	}
	
	

	
	
	
}
