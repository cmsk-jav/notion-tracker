package dev.sk.notionclient.controller;

import dev.sk.notionclient.service.NotionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Controller
public class ViewController {

    @Autowired
    NotionService notionService;


    @RequestMapping("/")
    public String main()throws Exception{
        return "index.html";
    }

    @RequestMapping("/view-data")
    public String viewData(Model model){
        model.addAttribute("viewData",true);
        model.addAttribute("notionlist", notionService.getNotionList());
        return "index.html";
    }



}
