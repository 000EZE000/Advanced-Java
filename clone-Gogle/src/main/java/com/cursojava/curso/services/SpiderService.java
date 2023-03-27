package com.cursojava.curso.services;


import com.cursojava.curso.entities.WebPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.*;
import java.util.stream.Collectors;

import static org.hibernate.internal.util.StringHelper.isBlank;

@Service
public class SpiderService {

    @Autowired
    private SaveServices saveServices;
    @Autowired
    private SearchServices searchServices;

    public void indexPages(){
        List<WebPage> linkOfDataBase = searchServices.getLinkToindex();
        linkOfDataBase.forEach(link->{
            indexPage(link);
        });

    }

    public void  indexPage(WebPage webPage){
        String url  = webPage.getUrl();
        String html = getWebContent(url);
        if(isBlank(html)) return;
        try {
            String domain = getDomain(url);
            saveLink(domain,html);
            indexAndSavePage(webPage,html);
        }catch (Exception e){
          System.out.println(e.getMessage() + " ERRORRR");
        }

    }

    private String getDomain(String url) {
        String[] urlPart = url.split("/");
        return  urlPart[0] +"//"+ urlPart[2];
    }

    public void saveLink(String domain, String html) throws Exception{
        List<String> links = getLink(html, domain);
        links.stream().filter(link -> searchServices.isNotExist(link))
                .map(link-> new WebPage(link))
                .forEach(link->{
                    saveServices.save(link);
 

        });
    }
    private List<String> cleanLink(List<String> links, String domain){
        String[] excludeExtension = new String[] {"ccs" ,"json", "js" , "jpg", "png", "woff2"};
        List<String> listExclude = Arrays.asList(excludeExtension);
        List<String> cleanLink =  links.stream()
                 .filter(link-> listExclude.stream().noneMatch(link::endsWith))
                 .map(link -> link.startsWith("/")? (domain + link) : link)
                 .collect(Collectors.toList());
        List<String> uniqueLink = new ArrayList<>();
        uniqueLink.addAll(new HashSet<>(cleanLink));
        return  uniqueLink;
    }
    public List<String> getLink(String html ,String domain){
        List<String> listLink = new ArrayList<>();
        String[] arrayHref = html.split("href=\"");
        List<String> listHref = Arrays.asList(arrayHref);

        if(listHref.size() < 1) return listLink;

        listHref.forEach(element->{
            String[] links = element.split("\"");

            listLink.add(links[0]);
        });


        return cleanLink(listLink , domain);
    }
    public void indexAndSavePage(WebPage webPage, String html){


        String description = getDescriptionOfHtml(html);


        String title = getTitleOfHtml(html);


        webPage.setDescription(description);
  

        webPage.setTitle(title);

        saveServices.save(webPage);
    }
    public static String  getTitleOfHtml(String html){
        String[] pageArray = html.split("<title>");
        if(pageArray.length == 1) return "fail";
        String secondElem = pageArray[1].split("</title>")[0];
        return secondElem;
    }
    public static String  getDescriptionOfHtml(String html){
    

        String[] pageArray = html.split("<meta name=\"description\" content=\"");

        if(pageArray.length  == 1) return "fail";
 
        String secondElem = pageArray[1].split("\">")[0];
 
        return secondElem;
    }
    private static String getWebContent(String link) {
        try{
            URL url = new URL(link);
            HttpURLConnection connect = (HttpURLConnection) url.openConnection();
            // String encoding = connect.getContentEncoding();
            InputStream input = connect.getInputStream();
            //download webs
            return new BufferedReader(new InputStreamReader(input))
                                    .lines().collect(Collectors.joining());

            }catch(IOException ex){
          System.out.println(ex.getMessage() + " ERROR EN GETWEBCONTENT");
            return "";
        }

    }
}


