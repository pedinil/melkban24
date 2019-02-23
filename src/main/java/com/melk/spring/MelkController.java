package com.melk.spring;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.melk.spring.model.Case;
import com.melk.spring.model.Know;
import com.melk.spring.model.News;
import com.melk.spring.service.CaseService;
import com.melk.spring.service.KnowService;

@Controller
public class MelkController {

    private KnowService knowService;

    private CaseService caseService;

    @Autowired(required = true)
    @Qualifier(value = "KnowService")
    public void setKnowService(KnowService ps) {
	this.knowService = ps;
    }

    @Autowired(required = true)
    @Qualifier(value = "CaseService")
    public void setCaseService(CaseService ps) {
	this.caseService = ps;
    }

    private String Title = "دانستنی های ملک در ملکبان 24";
    private String Description = "دانستنی های ملک در زمینه قیمت مسکن،اجاره اپارتمان،قیمت اپارتمان،اجاره خانه و خرید خانه را در بخش دانستنی ملکبان 24 در سایت melkban24.ir بخوانید.";
    private String keywords = "دانستنی ملک بان،دانستنی melkban24،دانستنی قیمت مسکن،دانستنی اجاره اپارتمان،دانستنی اجاره خانه، دانستنی خرید خانه";

    @RequestMapping(value = "/melk/{idKnown}/{title}")
    public String getNewsById(@PathVariable("idKnown") double idKnown, @PathVariable("title") String title,
	    Model model) {

	Know know = this.knowService.getKnowByID(idKnown);

	if (know != null) {
	    Title = know.getSubjectKnow();

	    if (know.getBodyKnow().length() > 200) {
		Description = know.getBodyKnow().substring(0, 200).replaceAll("\\<.*?>", "");
	    } else {
		Description = know.getBodyKnow();
	    }

	    keywords = know.getSubjectKnow();

	}

	// Adding page title,Description,keywords
	model.addAttribute("pageTitle", Title);
	model.addAttribute("pageDescription", Description);
	model.addAttribute("pageKeywords", keywords);

	// set Melk
	model.addAttribute("know", know);

	// Know ListRelated
	model.addAttribute("listKnowRandom", this.knowService.listKnowRandom());
	model.addAttribute("KnowRand", new Know());

	// case List
	model.addAttribute("caseSale", new Case());
	model.addAttribute("listSaleCase", this.caseService.listSaleCase());

	return "melk";
    }

    @RequestMapping(value = { "/melk", "/melk/{pageNumber}" }, method = RequestMethod.GET)
    public String listNews(Model model, @PathVariable Map<String, String> pathVariables)
	    throws UnsupportedEncodingException {
	int pageNO = 0;

	Title = "دانستنیهای ملک";
	Description = "دانستنیهای ملک و مسکن درملک بان 24، برگزیده ای از مقالات و تمام دانستنیها ملک و مسکن، دانستنیهای مفید بازار ملک و مسکن، دانستنیها خرید خانه و اجاره آپارتمان";
	keywords = "دانستنیها ملک، دانستنیها بازار مسکن، دانستنیها خرید خانه و اجاره آپارتمان، مقالات مسکن";

	// check it is Number or not redirect
	if (pathVariables.containsKey("pageNumber")) {
	    String id = pathVariables.get("pageNumber");
	    if (isNumeric(id)) {

		int idKnow = Integer.parseInt(id);
		Know know = this.knowService.getKnowByID(idKnow);
		String url = know.getURL().trim();
		String KnowUrL = URLEncoder.encode(url, "UTF-8");

		return "redirect:/melk/" + id + "/" + KnowUrL;

	    }

	}

	// getPageNo
	pageNO = getPageNo(pathVariables);

	// Adding pageNO to title
	if (pageNO != 0) {
	    Title = Title + "- صفحه " + pageNO;
	}

	// Adding page title,Description,keywords
	model.addAttribute("pageTitle", Title);
	model.addAttribute("pageDescription", Description);
	model.addAttribute("pageKeywords", keywords);

	// news getPageNumber
	int pagecount = this.knowService.getMelkCount();

	int current = pageNO;
	int begin = Math.max(1, current - 5);
	int end = Math.min(begin + 9, pagecount + 1);

	model.addAttribute("beginIndex", begin);
	model.addAttribute("endIndex", end);
	model.addAttribute("currentIndex", current);

	// Know List
	model.addAttribute("listKnow", this.knowService.listKnow(pageNO));
	model.addAttribute("Know", new Know());

	return "melkList";
    }

    @RequestMapping(value = { "/melklistsearch/{SearchKeyword}" }, method = RequestMethod.GET)
    public String melksearch(Model model, @PathVariable("SearchKeyword") String SearchKeyword) {

	Title = "دانستنیهای ملک";
	Description = "دانستنیهای ملک و مسکن درملک بان 24، برگزیده ای از مقالات و تمام دانستنیها ملک و مسکن، دانستنیهای مفید بازار ملک و مسکن، دانستنیها خرید خانه و اجاره آپارتمان";
	keywords = "دانستنیها ملک، دانستنیها بازار مسکن، دانستنیها خرید خانه و اجاره آپارتمان، مقالات مسکن";

	// Adding page title,Description,keywords
	model.addAttribute("pageTitle", Title);
	model.addAttribute("pageDescription", Description);
	model.addAttribute("pageKeywords", keywords);

	String finalSearchKeyword = SearchKeyword.replace("-", " ").replace("+", " ").trim();

	// Know List
	model.addAttribute("listKnow", this.knowService.listKnowSearch(finalSearchKeyword));
	model.addAttribute("Know", new Know());

	return "melkListSearch";
    }

    @RequestMapping(value = { "/mobilesoftware/MobileMelk/{idKnown}/{title}", "/Melk/{idKnown}/{title}" })
    public ModelAndView redirectRequest(Model model, @PathVariable("idKnown") int idKnown,
	    @PathVariable("title") String title) throws UnsupportedEncodingException {

	/*
	 * String titleNew=title.trim().replace(" ", "-");
	 * 
	 * String newUrL = URLEncoder.encode(titleNew, "UTF-8");
	 * 
	 * RedirectView red = new RedirectView("/melk/"+idKnown +
	 * "/"+newUrL,true); red.setStatusCode(HttpStatus.MOVED_PERMANENTLY);
	 * return new ModelAndView(red);
	 */

	RedirectView red;
	Know know = null;
	if (idKnown != 0) {

	    know = this.knowService.getKnowByID(idKnown);

	}
	if (know == null) {
	    red = new RedirectView("/melk", true);
	} else {
	    String url = know.getURL().trim();
	    String knowUrL = URLEncoder.encode(url, "UTF-8");

	    red = new RedirectView("/melk/" + idKnown + "/" + knowUrL, true);
	}

	red.setStatusCode(HttpStatus.MOVED_PERMANENTLY);
	return new ModelAndView(red);

    }

    @RequestMapping(value = { "/Melk", "/mobilesoftware/MobileMelk" })
    public ModelAndView redirectRequest(@RequestParam Map<String, String> pathVariables, Model map)
	    throws UnsupportedEncodingException {

	RedirectView red;
	red = new RedirectView("/melk", true);

	red.setStatusCode(HttpStatus.MOVED_PERMANENTLY);
	return new ModelAndView(red);
    }

    private int getPageNo(Map<String, String> pathVariables) {
	int pageNO = 0;

	if (pathVariables.containsKey("pageNumber")) {

	    String pageStr = pathVariables.get("pageNumber");
	    if (pageStr.indexOf("-") > 0) {
		String[] pageStrArr = pageStr.split("-");
		pageNO = Integer.parseInt(pageStrArr[1]);
	    }
	}

	return pageNO;
    }

    public boolean isNumeric(String str) {
	for (char c : str.toCharArray()) {
	    if (!Character.isDigit(c))
		return false;
	}
	return true;
    }

}
