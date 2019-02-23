package com.melk.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.melk.spring.model.GuideBuy;
import com.melk.spring.service.CityService;
import com.melk.spring.service.GuideService;
import com.melk.spring.service.KindRequestService;

@Controller
public class AdminGuideController {

    private KindRequestService kindRequestService;

    private CityService cityService;

    private GuideService guideService;

    @Autowired(required = true)
    @Qualifier(value = "KindRequestService")
    public void setKindRequestService(KindRequestService ps) {
	this.kindRequestService = ps;
    }

    @Autowired(required = true)
    @Qualifier(value = "CityService")
    public void setCityService(CityService ps) {
	this.cityService = ps;
    }

    @Autowired(required = true)
    @Qualifier(value = "GuideService")
    public void setGuideService(GuideService ps) {
	this.guideService = ps;
    }

    @RequestMapping(value = "/adminGuide/{idAdmin}", method = RequestMethod.GET)
    public String adminNews(ModelMap model, @PathVariable("idAdmin") String idAdmin) {

	if (!idAdmin.equals("PHM"))
	    return "error";

	// KindRequest List
	model.addAttribute("listkindRequest", this.kindRequestService.listKindRequest());

	// listCity List
	model.addAttribute("listCity", this.cityService.listCity());

	GuideBuy guideBuyObj = new GuideBuy();

	model.put("guideSave", guideBuyObj);

	return "adminGuide";
    }

    @RequestMapping(value = "/addGuide", method = RequestMethod.POST)
    public String addadmin(@ModelAttribute("guideSave") GuideBuy guideBuyObj) {

	guideService.SaveGuide(guideBuyObj);

	return "redirect:home";
    }

}
