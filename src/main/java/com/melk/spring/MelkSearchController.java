package com.melk.spring;

import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.melk.spring.dao.AreaDAOImpl;
import com.melk.spring.model.Area;
import com.melk.spring.model.Cabinet;
import com.melk.spring.model.Case;
import com.melk.spring.model.CaseAdSearch;
import com.melk.spring.model.CaseSearch;
import com.melk.spring.model.City;
import com.melk.spring.model.GuideBuy;
import com.melk.spring.model.KindCase;
import com.melk.spring.model.KindRequest;
import com.melk.spring.model.Nama;
import com.melk.spring.model.Range;
import com.melk.spring.model.Roof;
import com.melk.spring.model.State;
import com.melk.spring.service.AreaService;
import com.melk.spring.service.CabinetService;
import com.melk.spring.service.CaseService;
import com.melk.spring.service.CityService;
import com.melk.spring.service.GuideService;
import com.melk.spring.service.KindCaseService;
import com.melk.spring.service.KindRequestService;
import com.melk.spring.service.NamaService;
import com.melk.spring.service.RangeService;
import com.melk.spring.service.RoofService;
import com.melk.spring.service.StateService;

@Controller
public class MelkSearchController {

    private CaseService caseService;

    private StateService stateService;

    private KindCaseService kindCaseService;

    private KindRequestService kindRequestService;

    private CityService cityService;

    private AreaService areaService;

    private RangeService rangeService;

    private NamaService namaService;

    private CabinetService cabinetService;

    private RoofService roofService;

    private GuideService guideService;

    @Autowired(required = true)
    @Qualifier(value = "CaseService")
    public void setCaseService(CaseService ps) {
	this.caseService = ps;
    }

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
    @Qualifier(value = "CityService")
    public void setCityService(CityService ps) {
	this.cityService = ps;
    }

    @Autowired(required = true)
    @Qualifier(value = "AreaService")
    public void setAreaService(AreaService ps) {
	this.areaService = ps;
    }

    @Autowired(required = true)
    @Qualifier(value = "RangeService")
    public void setRangeService(RangeService ps) {
	this.rangeService = ps;
    }

    @Autowired(required = true)
    @Qualifier(value = "NamaService")
    public void setNamaService(NamaService ps) {
	this.namaService = ps;
    }

    @Autowired(required = true)
    @Qualifier(value = "CabinetService")
    public void setCabinetService(CabinetService ps) {
	this.cabinetService = ps;
    }

    @Autowired(required = true)
    @Qualifier(value = "RoofService")
    public void setRoofService(RoofService ps) {
	this.roofService = ps;
    }

    @Autowired(required = true)
    @Qualifier(value = "GuideService")
    public void setGuideService(GuideService ps) {
	this.guideService = ps;
    }

    private String Title = "خريد خانه، خريد آپارتمان، خريد ويلا";
    private String Description = "خريد خانه، خريد آپارتمان، خريد ويلا";
    private String keywords = "خريد خانه، خريد آپارتمان، خريد ويلا";

    private static final Logger logger = LoggerFactory.getLogger(MelkSearchController.class);

    @ExceptionHandler(SQLException.class)
    @RequestMapping(value = { "/melksearch/{searchContent}/{pageNumber}", "/melksearch/{searchContent}" }, method = {
	    RequestMethod.GET, RequestMethod.POST })
    public String listFirstLoad(Model model, @PathVariable Map<String, String> pathVariables,
	    @ModelAttribute("caseAdSearch") CaseAdSearch caseAdSearch, HttpServletRequest request) {

	int pageNO = 0;

	if (request.getMethod().equals("GET")) {
	    model.addAttribute("methodRequest", "GET");

	} else if (request.getMethod().equals("POST")) {

	    model.addAttribute("methodRequest", "POST");
	}

	// load combo
	ComboFill(model);

	String searchContent = pathVariables.get("searchContent");

	// seting urlPath
	model.addAttribute("urlPath", searchContent);

	// h1
	if (!searchContent.isEmpty())
	    model.addAttribute("h1text", searchContent.replace("-", " ").replace("+", " ").trim());

	// نوع معامله-نوع ملک-استان-شهر-منطقه-محدوده
	// خرید-خانه-تهران-تهران-منطقه دو-سعادت آباد

	Case caseObj = SearchContent(searchContent);

	if (caseObj == null) {
	    return "redirect:error";
	}

	// requestType
	if (caseObj.getKindRequest() != null)
	    model.addAttribute("requestType", caseObj.getKindRequest().getIdKindRequest());

	// getPageNo
	pageNO = getPageNo(pathVariables);

	// Making dynamic title,Description,keywords
	if (caseObj != null) {

	    Title = searchContent.replace("-", " ").replace("+", " ").trim();
	    Description = makeDesc(caseObj);
	    keywords = makeKeywords(caseObj);
	}

	// adding page in title
	if (pageNO != 0) {
	    Title = Title + "- صفحه " + pageNO;
	}

	// Adding page title,Description,keywords
	model.addAttribute("pageTitle", Title);
	model.addAttribute("pageDescription", Description);
	model.addAttribute("pageKeywords", keywords);

	// Case getPageNumber
	int pagecount = this.caseService.getCaseSearchCount(caseObj, caseAdSearch);

	int current = pageNO;
	int begin = Math.max(1, current - 5);
	int end = Math.min(begin + 9, pagecount + 1);

	model.addAttribute("beginIndex", begin);
	model.addAttribute("endIndex", end);
	model.addAttribute("currentIndex", current);

	if (pageNO == 0) {

	    // Case getCaseSearchpage
	    model.addAttribute("Case", new CaseSearch());
	    model.addAttribute("listCase", this.caseService.getCaseSearch(caseObj, caseAdSearch, 1));

	} else {

	    // Case getCaseSearchpage
	    model.addAttribute("Case", new CaseSearch());
	    model.addAttribute("listCase", this.caseService.getCaseSearch(caseObj, caseAdSearch, pageNO));

	}

	if (caseObj.getCity() != null && caseObj.getKindRequest() != null) {
	    model.addAttribute("guideBuy", (GuideBuy) this.guideService.getGuideSearch(caseObj.getCity().getIdCity(),
		    caseObj.getKindRequest().getIdKindRequest()));
	}

	return "MelkSearch";
    }

    private Case SearchContent(String content) {
	Case caseObj = new Case();

	String arrayString[] = content.split("-");
	String KindRequestName = "";
	String CaseKindName = "";
	String StateName = "";
	String CityName = "";
	String AreaName = "";
	String RangeName = "";

	KindRequest kindRequest = null;
	KindCase kindCase = null;
	State state = null;
	City city = null;
	Area area = null;
	Range range = null;

	if (!content.contains("-")) {

	    logger.error("wrong search path " + content);

	    return null;
	}

	if (arrayString.length >= 1) {
	    KindRequestName = arrayString[0].replace("+", " ");
	}

	if (arrayString.length >= 2) {
	    CaseKindName = arrayString[1].replace("+", " ");
	}

	if (arrayString.length >= 3) {
	    StateName = arrayString[2].replace("+", " ");
	}

	if (arrayString.length >= 4) {
	    CityName = arrayString[3].replace("+", " ");
	}

	if (arrayString.length >= 5) {
	    AreaName = arrayString[4].replace("+", " ");
	}

	if (arrayString.length >= 6) {
	    RangeName = arrayString[5].replace("+", " ");
	}

	if (!KindRequestName.equals("")) {
	    kindRequest = this.kindRequestService.getKindRequestId(KindRequestName);
	    caseObj.setKindRequest(kindRequest);
	}

	if (!CaseKindName.equals("")) {
	    kindCase = this.kindCaseService.getKindCaseId(CaseKindName);
	    caseObj.setKindCase(kindCase);
	}

	if (!StateName.equals("")) {
	    state = this.stateService.getStateId(StateName);
	    caseObj.setState(state);
	}

	if (!CityName.equals("") && state != null) {
	    city = this.cityService.getCityId(CityName, state.getIdState());
	    caseObj.setCity(city);
	}

	if (!AreaName.equals("") && city != null) {
	    area = this.areaService.getAreaId(AreaName, city.getIdCity());
	    caseObj.setArea(area);
	}

	if (!RangeName.equals("") && area != null) {
	    range = this.rangeService.getRangeId(RangeName, area.getIdArea());
	    caseObj.setRange(range);

	}

	logger.info("  نوع معامله >" + KindRequestName + ", نوع ملک  >" + CaseKindName + ", استان >" + StateName
		+ ", شهر >" + CityName + ", منطقه >" + AreaName + ", محدوده >" + RangeName);

	return caseObj;

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

    private String makeTitle(Case caseObj)

    {
	StringBuilder strBuild = new StringBuilder();

	if (caseObj.getKindRequest() != null)
	    strBuild.append(caseObj.getKindRequest().getNameKindRequest());

	if (caseObj.getKindCase() != null) {
	    strBuild.append(caseObj.getKindCase().getNameKindCase() + "در");
	} else {
	    strBuild.append("خانه " + "در ");
	}

	if (caseObj.getState() != null)
	    strBuild.append(caseObj.getState().getNameState() + " ");

	if (caseObj.getCity() != null)
	    strBuild.append(caseObj.getCity().getNameCity() + " ");

	if (caseObj.getArea() != null)
	    strBuild.append(caseObj.getArea().getNameArea() + " ");

	if (caseObj.getRange() != null)
	    strBuild.append(caseObj.getRange().getNameRange());

	return strBuild.toString().trim();

    }

    private String makeKeywords(Case caseObj)

    {
	StringBuilder strBuild = new StringBuilder();

	if (caseObj.getKindRequest() != null)
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

	if (caseObj.getKindRequest() != null)
	    strBuild.append(caseObj.getKindRequest().getNameKindRequest());

	if (caseObj.getKindCase() != null) {
	    strBuild.append(" " + caseObj.getKindCase().getNameKindCase());
	} else {
	    strBuild.append(" خانه");
	}

	if (caseObj.getState() != null)
	    strBuild.append(" در " + caseObj.getState().getNameState());

	if (caseObj.getCity() != null)
	    strBuild.append(" در" + caseObj.getCity().getNameCity());

	if (caseObj.getArea() != null)
	    strBuild.append(" " + caseObj.getArea().getNameArea());

	if (caseObj.getRange() != null)
	    strBuild.append(" " + caseObj.getRange().getNameRange());

	strBuild.append(". جستجوی ملک مورد نظر شما ، خانه دلخواه خود را در ملک بان ۲۴ بیابید ");

	return strBuild.toString().trim();

    }

    private void ComboFill(Model model) {

	// Roof List
	model.addAttribute("listRoof", this.roofService.listRoof());

	// cabinet List
	model.addAttribute("listCabinet", this.cabinetService.listCabinet());

	// Nama List
	model.addAttribute("nama", new Nama());
	model.addAttribute("listNama", this.namaService.listNama());

    }

    @RequestMapping(value = { "/MelkSearch", "/SearchById", "/mobilesoftware/MelkSearch" })
    public ModelAndView redirectRequest(@RequestParam Map<String, String> pathVariables, Model map)
	    throws UnsupportedEncodingException {

	RedirectView red;
	red = new RedirectView("/home", true);

	red.setStatusCode(HttpStatus.MOVED_PERMANENTLY);
	return new ModelAndView(red);
    }

}
