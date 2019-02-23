package com.melk.spring;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.text.DecimalFormat;
import java.util.Date;
import java.util.Map;

import org.joda.time.DateTime;
import org.joda.time.LocalDateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;
import javax.servlet.ServletContext;

import com.ghasemkiani.util.icu.PersianCalendar;
import com.ibm.icu.util.Calendar;
import com.melk.spring.model.Cabinet;
import com.melk.spring.model.Case;
import com.melk.spring.model.CaseSide;
import com.melk.spring.model.KindCase;
import com.melk.spring.model.KindRequest;
import com.melk.spring.model.Kitchen;
import com.melk.spring.model.Nama;
import com.melk.spring.model.News;
import com.melk.spring.model.Person;
import com.melk.spring.model.Roof;
import com.melk.spring.model.Service;
import com.melk.spring.model.State;
import com.melk.spring.model.SystemG;
import com.melk.spring.model.SystemS;
import com.melk.spring.model.Users;
import com.melk.spring.model.Windows;
import com.melk.spring.service.StateService;
import com.melk.spring.service.SystemGService;
import com.melk.spring.service.SystemSService;
import com.melk.spring.service.UsersService;
import com.melk.spring.service.WindowsService;
import com.melk.spring.service.CabinetService;
import com.melk.spring.service.CaseService;
import com.melk.spring.service.CaseSideService;
import com.melk.spring.service.KindCaseService;
import com.melk.spring.service.KindRequestService;
import com.melk.spring.service.KitchenService;
import com.melk.spring.service.NamaService;
import com.melk.spring.service.RoofService;
import com.melk.spring.service.ServiceService;

@Controller
@EnableCaching

@RequestMapping(value = "/addfile")
public class AddFileController {

    private StateService stateService;

    private KindCaseService kindCaseService;

    private KindRequestService kindRequestService;

    private NamaService namaService;

    private CaseSideService caseSideService;

    private RoofService roofService;

    private KitchenService kitchenService;

    private CabinetService cabinetService;

    private WindowsService windowsService;

    private ServiceService serviceService;

    private SystemGService systemGService;

    private SystemSService systemSService;

    private CaseService caseService;

    private UsersService usersService;

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
    @Qualifier(value = "NamaService")
    public void setNamaService(NamaService ps) {
	this.namaService = ps;
    }

    @Autowired(required = true)
    @Qualifier(value = "CaseSideService")
    public void setCaseSideService(CaseSideService ps) {
	this.caseSideService = ps;
    }

    @Autowired(required = true)
    @Qualifier(value = "RoofService")
    public void setRoofService(RoofService ps) {
	this.roofService = ps;
    }

    @Autowired(required = true)
    @Qualifier(value = "KitchenService")
    public void setKitchenService(KitchenService ps) {
	this.kitchenService = ps;
    }

    @Autowired(required = true)
    @Qualifier(value = "CabinetService")
    public void setCabinetService(CabinetService ps) {
	this.cabinetService = ps;
    }

    @Autowired(required = true)
    @Qualifier(value = "WindowsService")
    public void setWindowsService(WindowsService ps) {
	this.windowsService = ps;
    }

    @Autowired(required = true)
    @Qualifier(value = "ServiceService")
    public void setServiceService(ServiceService ps) {
	this.serviceService = ps;
    }

    @Autowired(required = true)
    @Qualifier(value = "SystemGService")
    public void setSystemGService(SystemGService ps) {
	this.systemGService = ps;
    }

    @Autowired(required = true)
    @Qualifier(value = "SystemSService")
    public void setSystemSService(SystemSService ps) {
	this.systemSService = ps;
    }

    @Autowired(required = true)
    @Qualifier(value = "CaseService")
    public void setCaseService(CaseService ps) {
	this.caseService = ps;
    }

    @Autowired(required = true)
    @Qualifier(value = "UsersService")
    public void setUsersService(UsersService ps) {
	this.usersService = ps;
    }

    private String Title = "خريد خانه، خريد آپارتمان، خريد ويلا";
    private String Description = "با سپردن ملک خود در سایت ملک بان 24، ملک خود را در معرض دید هزاران مشتری بالقوه بازار مسکن و خرید و فروش ملک قرار دهید";
    private String keywords = "سپردن ملک، آگهی ملک، آگهی خرید خانه، آگهی اجاره آپارتمان، آگهی خرید ویلا، سپردن آگهی ملک";

    private static final Logger logger = LoggerFactory.getLogger(AddFileController.class);

    @RequestMapping(method = RequestMethod.GET)
    public String listFirstLoad(ModelMap model) {
	/*
	 * //Case Model Add model.addAttribute("case", new Case());
	 */

	Case caseObj = new Case();
	model.put("caseSave", caseObj);

	// Adding page title,Description,keywords
	model.addAttribute("pageTitle", Title);
	model.addAttribute("pageDescription", Description);
	model.addAttribute("pageKeywords", keywords);

	// State List
	model.addAttribute("listState", this.stateService.listState());

	// KindCase List
	model.addAttribute("listkindCase", this.kindCaseService.listKindCase());

	// KindRequest List
	model.addAttribute("listkindRequest", this.kindRequestService.listKindRequest());

	// Nama List
	model.addAttribute("listNama", this.namaService.listNama());

	// CaseSide List
	model.addAttribute("listcaseSide", this.caseSideService.listCaseSide());

	// Roof List
	model.addAttribute("listRoof", this.roofService.listRoof());

	// Kitchen List
	model.addAttribute("listKitchen", this.kitchenService.listKitchen());

	// Kitchen List
	model.addAttribute("listCabinet", this.cabinetService.listCabinet());

	// Windows List
	model.addAttribute("listWindows", this.windowsService.listWindows());

	// Windows List
	model.addAttribute("listService", this.serviceService.listService());

	// SystemG List
	model.addAttribute("listSystemG", this.systemGService.listSystemG());

	// SystemS List
	model.addAttribute("listSystemS", this.systemSService.listSystemS());

	return "addfile";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String addFileinDb(Model model, @ModelAttribute("caseSave") Case caseObj,
	    @RequestParam("file") MultipartFile[] files) {

	Date dt = new Date();

	// create IntDayOn
	DateTime dtOrg = new DateTime(dt);
	DateTime dtPlusOne = dtOrg.plusDays(30);
	int day = dtPlusOne.getDayOfYear() + ((dtPlusOne.getYear() - 2000) * 365);

	// persian date
	PersianCalendar persianCalendar1 = new PersianCalendar(new Date());
	String year = String.valueOf(persianCalendar1.get(Calendar.YEAR));
	String month = String.valueOf(persianCalendar1.get(Calendar.MONTH) + 1);
	String day_month = String.valueOf(persianCalendar1.get(Calendar.DAY_OF_MONTH));

	String dateIn = year + "/" + month + "/" + day_month;

	// create caseID
	int MSISDNLast6 = 0;
	double id = this.caseService.getCaseMax() + 1;

	if (caseObj.getUsers().getMobile().length() > 6) {
	    MSISDNLast6 = Integer.parseInt(caseObj.getUsers().getMobile().substring(6));
	} else {
	    if (caseObj.getUsers().getMobile().length() > 0)
		MSISDNLast6 = Integer.parseInt(caseObj.getUsers().getMobile());
	}

	String FileNameSave = (String.valueOf(MSISDNLast6).toString() + (Integer) Double.valueOf(id).intValue()).trim();
	double idFile = Double.parseDouble(FileNameSave);

	caseObj.setId(id);
	caseObj.setIdCase(idFile);
	caseObj.setDateIn(dateIn);
	caseObj.setIntDayOn(day);
	caseObj.setPoint(1);
	caseObj.setViews(1);
	caseObj.setVisitorCount(0);
	caseObj.setCountPoint(1);

	if (caseObj.getCity().getIdCity() == 0) {
	    caseObj.setCity(null);
	}

	if (caseObj.getArea().getIdArea() == 0) {
	    caseObj.setArea(null);
	}

	if (caseObj.getRange().getIdRange() == 0) {
	    caseObj.setRange(null);
	}

	caseObj.getUsers().setIdAgency("0000");
	caseObj.setIdAgency("0000");

	// Save Image to file
	SaveImage(FileNameSave, files, caseObj);

	// saving Case and new User
	if (this.caseService.SaveCase(caseObj)) {

	    logger.info("File Saved successfully with:" + FileNameSave);

	}

	model.addAttribute("notification", FileNameSave);
	return "redirect:SaveSuccessfully";

    }

    @RequestMapping(value = { "/AddFile", "/mobilesoftware/AddFile1" })
    public ModelAndView redirectRequest(@RequestParam Map<String, String> pathVariables, Model map)
	    throws UnsupportedEncodingException {

	RedirectView red;
	red = new RedirectView("/addfile", true);

	red.setStatusCode(HttpStatus.MOVED_PERMANENTLY);
	return new ModelAndView(red);
    }

    private void SaveImage(String idFile, @RequestParam("file") MultipartFile[] files, Case caseObj) {

	String WebPath = "http://melkban24.ir/resources/Files/";
	// String WebPath = "http://melkban24.ir/resources/Files/";

	String[] URL = { "", "", "", "", "", "", "", "", "" };

	String message = "";
	for (int i = 0; i < files.length; i++) {
	    MultipartFile file = files[i];

	    if (file.getSize() == 0)
		continue;

	    String name = GetFileURL(idFile, i + 1);

	    try {

		URL[i] = WebPath.concat(name);
		byte[] bytes = file.getBytes();

		// Creating the directory to store file
		String rootPath = System.getProperty("catalina.base");
		;
		File dir = new File(rootPath + File.separator + "webapps" + File.separator + "ROOT" + File.separator
			+ "resources" + File.separator + "Files");

		// if (!dir.exists())
		// dir.mkdirs();

		// Create the file on server
		File serverFile = new File(dir.getAbsolutePath() + File.separator + name);

		BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile));
		stream.write(bytes);
		stream.close();

		logger.info("Server File Location Saved=" + serverFile.getAbsolutePath());

	    } catch (Exception e) {
		logger.info("Server File Error=" + e.getMessage());
	    }

	}
	// return message;

	caseObj.setPic1(URL[0]);
	caseObj.setPic2(URL[1]);
	caseObj.setPic3(URL[2]);
	caseObj.setPic4(URL[3]);
	caseObj.setPic5(URL[4]);
	caseObj.setPic6(URL[5]);
	caseObj.setPic7(URL[6]);
	caseObj.setPic8(URL[7]);
	caseObj.setPic9(URL[8]);

    }

    public String GetFileURL(String fileID, int number) {
	// "AdminAdver1" + idFile + ".jpg"
	String name = "AdminAdver";
	String extension = ".jpg";

	return name + String.valueOf(number) + fileID + extension;

    }

}
