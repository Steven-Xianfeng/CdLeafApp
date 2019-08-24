package com.cdleaf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TemplateController implements StockController{



    @RequestMapping(value = "/hello")
    public String hello(Model model){

        model.addAttribute("name", " FreeMarker");

        System.out.println(" ===============================================================  ");
        System.out.println(this.getClass());

        return "hello";

    }


}
