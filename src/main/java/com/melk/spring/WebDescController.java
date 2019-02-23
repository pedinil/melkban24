package com.melk.spring;





import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.melk.spring.model.Dynamic;
import com.melk.spring.service.DynamicService;






@Controller
public class WebDescController {

	private DynamicService dynamicService;
	

	
	
	@Autowired(required=true)
	@Qualifier(value="DynamicService")
	public void setDynamicService(DynamicService ps){
		this.dynamicService = ps;
	}
	
	
	
	
	private String Title = "خريد خانه، خريد آپارتمان، خريد ويلا";
	private String Description = "خريد خانه، خريد آپارتمان، خريد ويلا";
	private String keywords = "خريد خانه، خريد آپارتمان، خريد ويلا";
	
	

	
	
	@RequestMapping(value = "/dynamice")
	 public String getNewsById(Model model) {
	
		
		
	
		
		// Adding page title,Description,keywords
		model.addAttribute("pageTitle", Title);
		model.addAttribute("pageDescription",Description );
		model.addAttribute("pageKeywords", keywords);

	
		
		// Know listDynamic
		//model.addAttribute("dynamic",this.dynamicService.listDynamic(Id));
	
		

		
		
		return "webdesc";
	}
	
	
	
	@RequestMapping(value = "/melkcooperation")
	 public String melkcooperation(Model model) {
	
		
	
		
	

	
		 model.addAttribute("headerTitle","");
		
		 Dynamic dynamic=this.dynamicService.listDynamic(12);
		 
		 // listDynamic
		 model.addAttribute("dynamic",dynamic);
	
		//Setting Title,Desc,keyword
		 SettingTitle(model,dynamic);
	

		
		
		return "webdesc";
	}
	
	
	@RequestMapping(value = {"/connectus","/ConnectUs","/mobilesoftware/MobileSoftwareConnect"})
	 public String ConnectUs(Model model) {
	
		
		Title="ارتباط با ما";
		
		

	
		 model.addAttribute("headerTitle","ارتباط با ما");
		 
		 Dynamic dynamic=this.dynamicService.listDynamic(5);
		
		 // listDynamic
		 model.addAttribute("dynamic",dynamic);
		 
		//Setting Title,Desc,keyword
		 SettingTitle(model,dynamic);
	
		

		
		
		return "webdesc";
	}
	
	@RequestMapping(value = {"/melkhelp","/MelkHelp"})
	 public String MelkHelp(Model model) {
	
		
		Title="راهنماي سپردن ملک";
		
		

	
		 model.addAttribute("headerTitle","راهنماي سپردن ملک");
		
		 
		 Dynamic dynamic=this.dynamicService.listDynamic(4);
		 
		 // listDynamic
		 model.addAttribute("dynamic",dynamic);
	
		 
		//Setting Title,Desc,keyword
		 SettingTitle(model,dynamic);

		
		
		return "webdesc";
	}
	
	
	@RequestMapping(value = {"/melklows","/MelkLows","/mobilesoftware/MelkLaws"})
	 public String MelkLows(Model model) {
	
		
		Title="قوانین و مقررات";
		
	
	
		 model.addAttribute("headerTitle","قوانین و مقررات");
		
		 
		 Dynamic dynamic=this.dynamicService.listDynamic(10);
		 
		 // listDynamic
		 model.addAttribute("dynamic",dynamic);
	
		
		//Setting Title,Desc,keyword
		 SettingTitle(model,dynamic);

		
		
		return "webdesc";
	}
	
	
	@RequestMapping(value = {"/melksearchhelp","/MelkSearchHelp"})
	 public String MelkSearchHelp(Model model) {
		
		
		Title="راهنمای جستجوی ملک";
		
		
	
		 model.addAttribute("headerTitle","راهنمای جستجوی ملک");
		
		 
		 Dynamic dynamic=this.dynamicService.listDynamic(11);
		 
		 // listDynamic
		 model.addAttribute("dynamic",dynamic);
	
		//Setting Title,Desc,keyword
		 SettingTitle(model,dynamic);

		
		
		return "webdesc";
	
	}
	
	
	
	@RequestMapping(value = {"/melksite","/MelkSite"})
	 public String MelkSite(Model model) {
		
		
		Title="بخشهای مختلف سایت";
	
		 model.addAttribute("headerTitle","بخشهای مختلف سایت");
		 
		 Dynamic dynamic=this.dynamicService.listDynamic(11);
		
		 // listDynamic
		 model.addAttribute("dynamic",dynamic);
	
		
		//Setting Title,Desc,keyword
		 SettingTitle(model,dynamic);
		
		
		return "webdesc";
	
	}
	
	
	@RequestMapping(value = {"/about","/About"})
	 public String About(Model model) {
		
		
		Title="درباره ما";
		
		 model.addAttribute("headerTitle","درباره ما");
		 
		 Dynamic dynamic=this.dynamicService.listDynamic(1);
		
		 // listDynamic
		 model.addAttribute("dynamic",dynamic);
	
		//Setting Title,Desc,keyword
		 SettingTitle(model,dynamic);
		

		
		
		return "webdesc";
	
	}
	
	@RequestMapping(value = {"/aboutdpd","/AboutDpd","/mobilesoftware/AboutDpd"})
	 public String AboutDpd(Model model) {
		
		
		Title="درباره دي پي دي";
		
		
		 model.addAttribute("headerTitle","درباره دي پي دي");
	
		 
		 Dynamic dynamic=this.dynamicService.listDynamic(3);
	
		 // listDynamic
		 model.addAttribute("dynamic",dynamic);
	
		//Setting Title,Desc,keyword
		 SettingTitle(model,dynamic);

		
		
		return "webdesc";
	
	}
	
	
	@RequestMapping(value = {"/vision","/Vision"})
	 public String Vision(Model model) {
		
		
		Title="چشم انداز ما";
		
		 model.addAttribute("headerTitle","چشم انداز ما");
		
		
		 
		 Dynamic dynamic=this.dynamicService.listDynamic(7);
	
		 // listDynamic
		 model.addAttribute("dynamic",dynamic);
	
		//Setting Title,Desc,keyword
		 SettingTitle(model,dynamic);

		
		
		return "webdesc";
	
	}
	
	@RequestMapping(value = {"/mission","/Mission"})
	 public String Mission(Model model) {
		
		
		Title="ماموریت ما";
		
		
		 model.addAttribute("headerTitle","ماموریت ما");

		 
		 Dynamic dynamic=this.dynamicService.listDynamic(8);
		 
		 // listDynamic
		 model.addAttribute("dynamic",dynamic);
	
		//Setting Title,Desc,keyword
		 SettingTitle(model,dynamic);

		
		
		return "webdesc";
	
	}
	
	
	private void SettingTitle(Model model,Dynamic dynamic)
	{
		
		// Adding page title,Description,keywords
		model.addAttribute("pageTitle", Title);
		if (dynamic.getBody().length()>150)
		{
		model.addAttribute("pageDescription", dynamic.getBody().substring(0,200).replaceAll("\\<.*?>",""));
		}
		model.addAttribute("pageKeywords", keywords);

	}
	
	
}
