package com.cursojava.curso.controllers;


import com.cursojava.curso.entities.WebPage;
import com.cursojava.curso.services.SearchServices;
import com.cursojava.curso.services.SpiderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api")
public class SearchController {
    @Autowired
    SearchServices searchServices;
    @Autowired
    SpiderService spiderService;


    @GetMapping("search")
    public List<WebPage> search(@RequestParam Map<WebPage, String> param){
        String query = param.get("query");
      return searchServices.search(query);
    }
    @GetMapping("test")
    public void spider(){
      spiderService.indexPages();
    }
}
