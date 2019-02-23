package com.melk.spring;

import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URLEncoder;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;
import org.springframework.web.util.UriUtils;

import com.melk.spring.model.News;
import com.melk.spring.service.NewsService;



@Controller
public class NewsController {

	private NewsService newsService;
	
	
	@Autowired(required=true)
	@Qualifier(value="NewsService")
	public void setNewsService(NewsService ps){
		this.newsService = ps;
	}
	
	
	private String Title = "خريد خانه، خريد آپارتمان، خريد ويلا";
	private String Description = "خريد خانه، خريد آپارتمان، خريد ويلا";
	private String keywords = "خريد خانه، خريد آپارتمان، خريد ويلا";
	
	
	@RequestMapping(value = "/news/json", method = RequestMethod.GET)
	public  ResponseEntity<List<News>> getListCity() {
	
		List<News> f=this.newsService.listNews(5);
		
		  return new ResponseEntity<List<News>>(f, HttpStatus.OK);
	}
	
	
	@RequestMapping(value = "/news/{idNews}/{messageNews}")
	 public String getNewsById(@PathVariable("idNews") double idNews,@PathVariable("messageNews") String messageNews,Model model) {
	
		News news=this.newsService.getNewsByID(idNews);
		
		if (news!=null)
		{
			Title=news.getSubjectNews();
			
			if (news.getBodyNews().length()>200)
			{
			Description=news.getBodyNews().substring(0,200).replaceAll("\\<.*?>","");
			}else
			{
				
				Description=news.getBodyNews();
			}
			
			keywords=news.getSubjectNews();

		}
		
		
		
		// Adding page title,Description,keywords
		model.addAttribute("pageTitle", Title);
		model.addAttribute("pageDescription",Description );
		model.addAttribute("pageKeywords", keywords);
		
		//set news
		model.addAttribute("news", news);
		
		//set last 3 news
		model.addAttribute("newLast", new News());
		model.addAttribute("listNewsLast", this.newsService.listNewsWithMaxNo(3));
		
		return "news";
	}
	
	
	
	@RequestMapping(value = {"/news","/news/{pageNumber}"},method = RequestMethod.GET)
	 public String listNews(Model model,@PathVariable Map<String, String> pathVariables) throws UnsupportedEncodingException 
		{
		int pageNO = 0;
			
		
		 Title = "اخبار مسکن";
		 Description = "آخرین و به روزترین اخبار مسکن، اخبار بازار مسکن، اخبار مسکن مهر، جدیدترین اخبار مسکن در سایت ملک بان 24";
		 keywords = "اخبار مسکن، اخبار مسکن مهر، اخبار بازار مسکن، جدیدترین اخبار مسکن";
		 
		 
		
		   //check it is Number or not redirect 
		   if (pathVariables.containsKey("pageNumber"))
		   {
			   String id = pathVariables.get("pageNumber");
			   if (isNumeric(id))
			   {
				   
				 
				News news=this.newsService.getNewsByID(Double.parseDouble(id));
				String url= news.getURL().trim();
		 		String newUrL = URLEncoder.encode(url, "UTF-8");
				   
				   return "redirect:/news/"+id+ "/"+newUrL;
				   
			   }
		   
		   }
		
			
			// getPageNo
			pageNO = getPageNo(pathVariables);
			
			if (pageNO!=0)
			{
				Title=Title + "- صفحه "+pageNO;
			}
			
			// Adding page title,Description,keywords
			model.addAttribute("pageTitle", Title);
			model.addAttribute("pageDescription",Description );
			model.addAttribute("pageKeywords", keywords);
			
			
			// news getPageNumber
			int pagecount = this.newsService.getNewsCount();

			int current = pageNO;
			int begin = Math.max(1, current - 5);
			int end = Math.min(begin + 9, pagecount+1);

			model.addAttribute("beginIndex", begin);
			model.addAttribute("endIndex", end);
			model.addAttribute("currentIndex", current);
			
			//set last 3 news
			model.addAttribute("news", new News());
			model.addAttribute("listNewsLast", this.newsService.listNews(pageNO));
			
			
			return "newsList";
		}
	
	
	
	@RequestMapping(value = {"/newssearch/{SearchKeyword}"},method = RequestMethod.GET)
	 public String newssearch(Model model,@PathVariable("SearchKeyword") String SearchKeyword) 
		{
		int pageNO = 0;
			
		
		 Title = "اخبار مسکن";
		 Description = "آخرین و به روزترین اخبار مسکن، اخبار بازار مسکن، اخبار مسکن مهر، جدیدترین اخبار مسکن در سایت ملک بان 24";
		 keywords = "اخبار مسکن، اخبار مسکن مهر، اخبار بازار مسکن، جدیدترین اخبار مسکن";
		 
		 
		
		
		
			
			// Adding page title,Description,keywords
			model.addAttribute("pageTitle", Title);
			model.addAttribute("pageDescription",Description );
			model.addAttribute("pageKeywords", keywords);
			
			String finalSearchKeyword=SearchKeyword.replace("-"," ").replace("+", " ").trim();
			
			//set last 3 news
			model.addAttribute("news", new News());
			model.addAttribute("listNewsLast", this.newsService.listNewsSearch(finalSearchKeyword));
			
			
			return "newsListSearch";
		}
	
	
	@RequestMapping(value = {"/News","/mobilesoftware/News"},method = RequestMethod.GET)
	 public ModelAndView redirectRequest (@RequestParam Map<String, String> pathVariables,Model map) throws UnsupportedEncodingException
	 {
		String IdNews="";
		 RedirectView red;
		News news=null;
		 if (pathVariables.containsKey("IdNews")) {
			 
			 IdNews =pathVariables.get("IdNews");
			 news=this.newsService.getNewsByID(Double.parseDouble(IdNews));
			    
		}
		 	if (news==null)
		 	{
		 		red= new RedirectView("/news" ,true);
		 	}else
		 	{
		 		String url= news.getURL().trim();
		 		String newUrL = URLEncoder.encode(url, "UTF-8");
		 		
		 		 red = new RedirectView("/news/"+IdNews+"/"+newUrL ,true);
		 	}
		 	
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
	
	
	
	public  boolean isNumeric(String str)
	{
	    for (char c : str.toCharArray())
	    {
	        if (!Character.isDigit(c)) return false;
	    }
	    return true;
	}
}
