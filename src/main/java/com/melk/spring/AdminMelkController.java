package com.melk.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.melk.spring.model.Know;
import com.melk.spring.service.KnowService;

@Controller
public class AdminMelkController {

    private KnowService knowService;

    @Autowired(required = true)
    @Qualifier(value = "KnowService")
    public void setKnowService(KnowService ps) {
	this.knowService = ps;
    }

    // Add
    @RequestMapping(value = "/adminMelk/{idAdmin}", method = RequestMethod.GET)
    public String adminNews(ModelMap model, @PathVariable("idAdmin") String idAdmin) {

	if (!idAdmin.equals("PHM"))
	    return "error";

	Know newsObj = new Know();

	model.put("melkSave", newsObj);

	return "adminMelk";
    }

    // Update
    @RequestMapping(value = "/adminMelk/{IDknow}/{idAdmin}", method = RequestMethod.GET)
    public String adminNews(ModelMap model, @PathVariable("IDknow") String IDknow,
	    @PathVariable("idAdmin") String idAdmin) {
	Know newsObj = null;

	if (!idAdmin.equals("PHM"))
	    return "error";

	if (!IDknow.isEmpty()) {

	    double idKnown = Double.parseDouble(IDknow);
	    newsObj = this.knowService.getKnowByID(idKnown);

	}

	model.put("melkSave", newsObj);

	return "adminMelk";
    }

    @RequestMapping(value = "/addMelk", method = RequestMethod.POST)
    public String addadmin(@ModelAttribute("knowSave") Know knowObj) {

	if (knowObj.getIdKnow() == 0) {
	    knowObj.setSubjectKnow(knowObj.getSubjectKnow());
	    knowService.SaveMelk(knowObj);

	} else if (knowObj.getIdKnow() != 0) {
	    knowObj.setSubjectKnow(knowObj.getSubjectKnow());
	    knowService.UpdateMelk(knowObj);

	}

	return "redirect:home";
    }

    @RequestMapping(value = "/delMelk", method = RequestMethod.POST)
    public String DeleteAdmin(@ModelAttribute("knowSave") Know knowObj) {

	if (knowObj.getIdKnow() != 0) {

	    knowService.DeleteMelk(knowObj);

	}

	return "redirect:home";
    }

}
