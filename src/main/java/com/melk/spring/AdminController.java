package com.melk.spring;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.ghasemkiani.util.icu.PersianCalendar;
import com.ibm.icu.util.Calendar;
import com.melk.spring.model.Case;
import com.melk.spring.model.News;
import com.melk.spring.model.Person;
import com.melk.spring.model.State;
import com.melk.spring.model.admin.CaseAdmin;
import com.melk.spring.service.CaseService;
import com.melk.spring.service.NewsService;

@Controller
public class AdminController {

    private NewsService newsService;

    private CaseService caseService;

    @Autowired(required = true)
    @Qualifier(value = "NewsService")
    public void setNewsService(NewsService ps) {
	this.newsService = ps;
    }

    @Autowired(required = true)
    @Qualifier(value = "CaseService")
    public void setCaseService(CaseService ps) {
	this.caseService = ps;
    }

    private static final Logger logger = LoggerFactory.getLogger(AdminController.class);

    // add
    @RequestMapping(value = "/adminNews/{idAdmin}", method = RequestMethod.GET)
    public String adminNews(ModelMap model, @PathVariable("idAdmin") String idAdmin) {

	if (!idAdmin.equals("PHM"))
	    return "error";

	// persian date
	PersianCalendar persianCalendar1 = new PersianCalendar(new Date());
	String year = String.valueOf(persianCalendar1.get(Calendar.YEAR));
	String month = String.valueOf(persianCalendar1.get(Calendar.MONTH) + 1);
	String day_month = String.valueOf(persianCalendar1.get(Calendar.DAY_OF_MONTH));

	String dateIn = year + "/" + month + "/" + day_month;

	News newsObj = new News();
	newsObj.setDateNews(dateIn);

	model.put("newsSave", newsObj);

	return "admin";
    }

    // update
    @RequestMapping(value = "/adminNews/{IDNews}/{idAdmin}", method = RequestMethod.GET)
    public String adminNews(ModelMap model, @PathVariable("IDNews") String IDNews,
	    @PathVariable("idAdmin") String idAdmin) {

	News newsObj = null;

	if (!idAdmin.equals("PHM"))
	    return "error";

	if (!IDNews.isEmpty()) {

	    double idNews = Double.parseDouble(IDNews);
	    newsObj = this.newsService.getNewsByID(idNews);

	}

	model.put("newsSave", newsObj);

	return "admin";
    }

    @RequestMapping(value = "/addNews", method = RequestMethod.POST)
    public String addadmin(@ModelAttribute("caseSave") News newsObj, @RequestParam("file") MultipartFile files) {

	double idNews = this.newsService.getNewsMax();

	if (newsObj.getIdNews() == null) {
	    newsObj.setSubjectNews(newsObj.getSubjectNews().trim());
	    newsObj.setIdNews(idNews + 1);
	    SaveImage(files, newsObj);
	    newsService.SaveNews(newsObj);
	} else {
	    newsObj.setSubjectNews(newsObj.getSubjectNews().trim());
	    newsService.UpdateNews(newsObj);
	}

	return "redirect:home";
    }

    @RequestMapping(value = "/delNews", method = RequestMethod.POST)
    public String DelNews(@ModelAttribute("caseSave") News newsObj) {

	if (newsObj.getIdNews() != null) {

	    newsService.DeleteNews(newsObj);
	}

	return "redirect:home";
    }

    @RequestMapping(value = "/case/json/{Count}", method = RequestMethod.GET)
    public ResponseEntity<List<CaseAdmin>> getListCase(Model model, @PathVariable("Count") int Count) {

	List<CaseAdmin> f = this.caseService.LastlistCase(Count);

	return new ResponseEntity<List<CaseAdmin>>(f, HttpStatus.OK);
    }

    @RequestMapping(value = "/listCase/{idAdmin}", method = RequestMethod.GET)
    public String listPersons(Model model, @PathVariable("idAdmin") String idAdmin) {

	if (!idAdmin.equals("PHM"))
	    return "error";

	return "adminAngular";
    }

    private void SaveImage(@RequestParam("file") MultipartFile files, News newsObj) {

	String WebPath = "http://melkban24.ir/resources/Files/";
	// String WebPath = "http://melkban24.ir/resources/Files/";

	if (files.getSize() == 0)
	    return;

	String name = GetFileURL(newsObj.getIdNews());

	try {

	    newsObj.setImageNews(WebPath.concat(name));

	    byte[] bytes = files.getBytes();

	    // Creating the directory to store file
	    String rootPath = System.getProperty("catalina.base");
	    File dir = new File(rootPath + File.separator + "webapps" + File.separator + "ROOT" + File.separator
		    + "resources" + File.separator + "Files");
	    /*
	     * if (!dir.exists()) dir.mkdirs();
	     */

	    // Create the file on server
	    File serverFile = new File(dir.getAbsolutePath() + File.separator + name);

	    BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile));
	    stream.write(bytes);
	    stream.close();

	    logger.info("Server File Location Saved=" + serverFile.getAbsolutePath());

	} catch (Exception e) {
	    logger.info("Server File Error=" + e.getMessage());
	}

	// return message;

    }

    public String GetFileURL(double No) {
	// "News" + number + ".jpg"
	String name = "News";
	String extension = ".jpg";

	return name + String.valueOf(Double.valueOf(No).intValue()) + extension;

    }

}
