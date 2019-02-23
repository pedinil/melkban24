package com.melk.spring;

import org.springframework.cache.annotation.EnableCaching;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@EnableCaching

public class AddAgentControl {

    @RequestMapping(value = "/addagent")
    public String addAgent(ModelMap model) {
	return "addAgent";

    }
}
