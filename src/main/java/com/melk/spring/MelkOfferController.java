package com.melk.spring;


import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.melk.spring.model.Case;
import com.melk.spring.model.Know;
import com.melk.spring.service.CaseService;
import com.melk.spring.service.KnowService;

@Controller
public class MelkOfferController {

    private CaseService caseService;

    private KnowService KnowService;

    @Autowired(required = true)
    @Qualifier(value = "CaseService")
    public void setCaseService(CaseService ps) {
	this.caseService = ps;
    }

    @Autowired(required = true)
    @Qualifier(value = "KnowService")
    public void setKnowService(KnowService ps) {
	this.KnowService = ps;
    }

    private String Title = "خريد خانه، خريد آپارتمان، خريد ويلا";
    private String Description = "خريد خانه، خريد آپارتمان، خريد ويلا";
    private String keywords = "خريد خانه، خريد آپارتمان، خريد ويلا";

    @RequestMapping(value = "/melkoffer/{caseId}")
    public String listFirstLoad(@PathVariable("caseId") double caseId, Model model) {

	Case caseObj = (Case) this.caseService.getCaseDetail(caseId);

	// Making dynamic title,Description,keywords
	if (caseObj != null) {
	    Title = makeTitle(caseObj);
	    Description = makeDesc(caseObj);
	    keywords = makeKeywords(caseObj);
	} else {
	    // notification
	    String caseid = String.valueOf((Double.valueOf(caseId).longValue()));
	    model.addAttribute("CaseId", caseid);
	    return "NoCaseIdFound";
	}

	// seting urlPath
	model.addAttribute("urlPath", caseId);

	// Adding page title,Description,keywords
	model.addAttribute("pageTitle", Title);
	model.addAttribute("pageDescription", Description);
	model.addAttribute("pageKeywords", keywords);

	// lat,lag is null
	if (caseObj != null) {
	    if (caseObj.getLat() == null || caseObj.getLon() == null) {
		caseObj.setLat(0.0);
		caseObj.setLon(0.0);
	    }

	}

	// set CaseDetail
	model.addAttribute("Case", caseObj);

	// set listSimilarCase
	model.addAttribute("CaseSimilar", caseObj);
	model.addAttribute("listCaseSimilar", this.caseService.listSimilarCase(caseObj));

	// Know ListRelated
	model.addAttribute("listKnowRandom", this.KnowService.listKnowRandom());
	model.addAttribute("KnowRand", new Know());

	return "MelkOffer";
    }

    private String makeTitle(Case caseObj)

    {
	StringBuilder strBuild = new StringBuilder();

	strBuild.append(caseObj.getKindRequest().getNameKindRequest());

	if (caseObj.getKindCase() != null) {
	    String parts[] = caseObj.getKindCase().getNameKindCase().split(" ");
	    if (parts.length > 0) {
		strBuild.append(parts[0] + " در ");
	    } else {
		strBuild.append(caseObj.getKindCase().getNameKindCase() + " در ");
	    }
	}

	if (caseObj.getState() != null)
	    strBuild.append(caseObj.getState().getNameState() + " ");

	// if (caseObj.getCity()!=null)
	// strBuild.append(caseObj.getCity().getNameCity()+ " ");

	String caseid = String.valueOf(((Double) caseObj.getIdCase()).longValue());
	strBuild.append(" " + caseid);

	return strBuild.toString();

    }

    private String makeKeywords(Case caseObj)

    {
	StringBuilder strBuild = new StringBuilder();

	strBuild.append(caseObj.getKindRequest().getNameKindRequest() + ",");

	if (caseObj.getKindCase() != null)
	    strBuild.append(caseObj.getKindCase().getNameKindCase() + ",");

	if (caseObj.getState() != null)
	    strBuild.append(caseObj.getState().getNameState() + ",");

	if (caseObj.getCity() != null)
	    strBuild.append(caseObj.getCity().getNameCity());

	return strBuild.toString();

    }

    private String makeDesc(Case caseObj)

    {
	StringBuilder strBuild = new StringBuilder();

	strBuild.append(caseObj.getKindRequest().getNameKindRequest());

	if (caseObj.getKindCase() != null)
	    strBuild.append(" " + caseObj.getKindCase().getNameKindCase());

	if (caseObj.getState() != null)
	    strBuild.append(" در " + caseObj.getState().getNameState());

	if (caseObj.getCity() != null)
	    strBuild.append(" در " + caseObj.getCity().getNameCity());

	if (caseObj.getMetraj() != null)
	    strBuild.append(" با متراژ " + (int) caseObj.getMetraj().intValue());

	if (caseObj.getAge() != null)
	    strBuild.append(" با سن " + caseObj.getAge());

	if (caseObj.getArea() != null)
	    strBuild.append(" در  " + caseObj.getArea().getNameArea());

	if (caseObj.getRange() != null)
	    strBuild.append(" در محله  " + caseObj.getRange().getNameRange());

	if (caseObj.getCountBed() != null)
	    strBuild.append(" با تعداد خواب " + (int) caseObj.getCountBed().intValue());

	return strBuild.toString();

    }

    @RequestMapping(value = { "/ViewMelk", "/mobilesoftware/ViewMelk" })
    public ModelAndView redirectRequest(@RequestParam Map<String, String> pathVariables, Model map) {
	String IdCase = "";

	if (pathVariables.containsKey("IdCase")) {

	    IdCase = pathVariables.get("IdCase");

	}

	RedirectView red = new RedirectView("/melkoffer/" + IdCase, true);
	red.setStatusCode(HttpStatus.MOVED_PERMANENTLY);
	return new ModelAndView(red);
    }

}
