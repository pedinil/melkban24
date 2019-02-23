package com.melk.spring;

import java.io.UnsupportedEncodingException;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.melk.spring.model.Case;
import com.melk.spring.model.KindCase;
import com.melk.spring.model.KindRequest;
import com.melk.spring.model.Know;
import com.melk.spring.model.News;
import com.melk.spring.model.State;
import com.melk.spring.service.NewsService;
import com.melk.spring.service.StateService;
import com.melk.spring.service.CaseService;
import com.melk.spring.service.KindCaseService;
import com.melk.spring.service.KindRequestService;
import com.melk.spring.service.KnowService;

@Controller
@EnableCaching
public class HomeController {

    private NewsService newsService;

    private StateService stateService;

    private KindCaseService kindCaseService;

    private KindRequestService kindRequestService;

    private KnowService KnowService;

    private CaseService caseService;

    @Autowired(required = true)
    @Qualifier(value = "StateService")
    public void setStateService(StateService ps) {
	this.stateService = ps;
    }

    @Autowired(required = true)
    @Qualifier(value = "KindCaseService")
    public void setKindCaseService(KindCaseService ps) {
	this.kindCaseService = ps;
    }

    @Autowired(required = true)
    @Qualifier(value = "KindRequestService")
    public void setKindRequestService(KindRequestService ps) {
	this.kindRequestService = ps;
    }

    @Autowired(required = true)
    @Qualifier(value = "NewsService")
    public void setNewsService(NewsService ps) {
	this.newsService = ps;
    }

    @Autowired(required = true)
    @Qualifier(value = "KnowService")
    public void setKnowService(KnowService ps) {
	this.KnowService = ps;
    }

    @Autowired(required = true)
    @Qualifier(value = "CaseService")
    public void setCaseService(CaseService ps) {
	this.caseService = ps;
    }

    private String Title = "خرید خانه,اجاره آپارتمان,خرید ويلا, خرید و فروش آپارتمان";
    private String Description = "تخصص ما فعالیت در حوزه خرید خانه,اجاره ملك , اجاره آپارتمان , خرید ویلا در شمال,اجاره ویلا در شما ل , خريد و فروش آپارتمان در تهران و سراسر ایران می باشد";
    private String keywords = "خرید ویلا در شمال, اجاره آپارتمان , خرید خانه , خريد خانه در تهران , قیمت خانه";

    @RequestMapping(value = { "/home", "/" }, method = RequestMethod.GET)
    public String listFirstLoad(Model model) {

	// Adding page title,Description,keywords
	model.addAttribute("pageTitle", Title);
	model.addAttribute("pageDescription", Description);
	model.addAttribute("pageKeywords", keywords);

	// State List
	model.addAttribute("state", new State());
	model.addAttribute("listState", this.stateService.listState());

	// KindCase List
	model.addAttribute("kindCase", new KindCase());
	model.addAttribute("listkindCase", this.kindCaseService.listKindCase());

	// KindRequest List
	model.addAttribute("kindRequest", new KindRequest());
	model.addAttribute("listkindRequest", this.kindRequestService.listKindRequest());

	// News List
	model.addAttribute("news", new News());
	model.addAttribute("listNews", this.newsService.listNewsWithMaxNo(5));

	// Know List
	model.addAttribute("know", new Know());
	model.addAttribute("listKnow", this.KnowService.listKnowRandom());

	// case List
	model.addAttribute("caseSale", new Case());
	model.addAttribute("listSaleCase", this.caseService.listSaleCase());

	return "index";
    }

    @RequestMapping(value = { "/default", "/Default", "/mobilesoftware/Default", "/mobilesoftware/melkban24default",
	    "/Admin", "/MelkOffer", "/Projects", "/Best", "/LaodAdver", "/MelkPrice", "/MelkPicResize" })
    public ModelAndView redirectRequest(@RequestParam Map<String, String> pathVariables, Model map)
	    throws UnsupportedEncodingException {

	RedirectView red;
	red = new RedirectView("/home", true);

	red.setStatusCode(HttpStatus.MOVED_PERMANENTLY);
	return new ModelAndView(red);
    }

    @RequestMapping(value = { "/blog" })
    public String redirectblog() throws UnsupportedEncodingException {

	return "redirect:http://melkban24.ir/blog";
    }

}
