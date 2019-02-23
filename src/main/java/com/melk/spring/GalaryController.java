package com.melk.spring;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
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

import com.melk.spring.model.Galary;
import com.melk.spring.service.GalaryService;

@Controller
public class GalaryController {

    private String Title = "خريد خانه، خريد آپارتمان، خريد ويلا";
    private String Description = "خريد خانه، خريد آپارتمان، خريد ويلا";
    private String keywords = "خريد خانه، خريد آپارتمان، خريد ويلا";

    private GalaryService galaryService;

    @Autowired(required = true)
    @Qualifier(value = "GalaryService")
    public void setGalaryService(GalaryService ps) {
	this.galaryService = ps;
    }

    @RequestMapping(value = "/gallery/{name}")
    public String galary(Model model, @PathVariable("name") String name) {

	int galarytype = getGalarytype(name);

	// Adding page title,Description,keywords
	model.addAttribute("pageTitle", getGalaryTitle(galarytype));
	model.addAttribute("pageDescription", getGalaryDesc(galarytype));
	model.addAttribute("pageKeywords", keywords);

	// Galary listGalary
	model.addAttribute("titleHeader", name);
	model.addAttribute("galary", new Galary());
	model.addAttribute("galaryList", this.galaryService.listGalary(galarytype));

	return "galary";
    }

    @RequestMapping(value = "/Gallery", method = RequestMethod.GET)
    public ModelAndView Oldgalary(Model model, @RequestParam Map<String, String> pathVariables)
	    throws UnsupportedEncodingException {

	int IdKindGallery = 0;
	String KindGalaryname = "";

	if (pathVariables.containsKey("IdKindGallery")) {

	    IdKindGallery = Integer.parseInt(pathVariables.get("IdKindGallery"));
	    KindGalaryname = getGalaryString(IdKindGallery);

	}
	String url = KindGalaryname.trim();
	String newUrL = URLEncoder.encode(url, "UTF-8");

	RedirectView red = new RedirectView("/gallery/" + newUrL, true);
	red.setStatusCode(HttpStatus.MOVED_PERMANENTLY);
	return new ModelAndView(red);
    }

    private int getGalarytype(String name) {
	int returnValu = 0;

	if (name.contains("آشپزخانه")) {
	    returnValu = 1;

	} else if (name.contains("نشیمن")) {
	    returnValu = 2;

	} else if (name.contains("خواب")) {
	    returnValu = 3;

	} else if (name.contains("داخلی")) {
	    returnValu = 4;

	} else if (name.contains("بهداشتی")) {
	    returnValu = 5;

	} else if (name.contains("مشاعات")) {
	    returnValu = 6;

	} else if (name.contains("نمای")) {
	    returnValu = 7;

	} else if (name.contains("لابی")) {
	    returnValu = 8;
	}

	return returnValu;

    }

    private String getGalaryString(int KindGalaryname) {

	switch (KindGalaryname) {
	case 1:
	    return "طراحی-آشپزخانه";
	case 2:
	    return "طراحی-اتاق-نشیمن";
	case 3:
	    return "طراحی-اتاق-خواب";
	case 4:
	    return "طراحی-داخلی";
	case 5:
	    return "سرویس-بهداشتی";
	case 6:
	    return "حیاط-و-مشاعات";
	case 7:
	    return "نمای-ساختمان";
	case 8:
	    return "طراحی-لابی";

	default:
	    return "";

	}

    }

    private String getGalaryDesc(int KindGalaryname) {

	switch (KindGalaryname) {
	case 1:
	    return "در سایت melkban24.ir می توانید جدیدترین عکس های دکوراسیون اشپزخانه و آشپزخانه مدرن را در بخش طراحی آشپزخانه مشاهده نمایید.";
	case 2:
	    return "طراحی اتاق نشیمن، ایده های طراحی اتاق نشیمن، عکس های طراحی اتاق نشیمن";
	case 3:
	    return "طراحی اتاق خواب، ایده های طراحی اتاق خواب، اتاق خواب کودک، اتاق خواب بزرگسال، عکس های طراحی اتاق خواب";
	case 4:
	    return "طراحی داخلی، ایده های ناب طراحی داخلی، طراحی مدرن داخل منزل، عکس های طراحی داخلی";
	case 5:
	    return "طراحی سرویس بهداشتی، ایده های طراحی سرویس بهداشتی، عکس های طراحی سرویس بهداشتی";
	case 6:
	    return "طراحی حیاط و مشاعات، ایده های طراحی حیاط باغ و ویلا، فضاسازی حیاط و مشاعات";
	case 7:
	    return "طراحی نمای ساختمان، ایده های طراحی نمای ساختمان، نمای کلاسیک، نمای ترکیبی، نمای مدرن، عکس های طراحی نمای ساختمان";
	case 8:
	    return " طراحی لابی، ایده های طراحی لابی، لابی های لوکس، عکس های طراحی لابی";

	default:
	    return "";

	}

    }

    private String getGalaryTitle(int KindGalaryname) {

	switch (KindGalaryname) {
	case 1:
	    return "طراحی دکوراسیون اشپزخانه|آشپزخانه مدرن|طرح اشپزخانه در ملک بان";
	case 2:
	    return "طراحی اتاق نشیمن، ایده های طراحی اتاق نشیمن";
	case 3:
	    return "طراحی اتاق خواب، ایده های طراحی اتاق خواب، اتاق خواب کودک";
	case 4:
	    return "طراحی داخلی، ایده های ناب طراحی داخلی";
	case 5:
	    return "طراحی سرویس بهداشتی";
	case 6:
	    return "طراحی حیاط و مشاعات، ";
	case 7:
	    return "طراحی نمای ساختمان، ایده های طراحی نمای ساختمان، ";
	case 8:
	    return " طراحی لابی";

	default:
	    return "";

	}

    }

}
