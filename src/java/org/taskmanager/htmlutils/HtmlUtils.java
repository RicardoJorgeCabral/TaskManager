/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.taskmanager.htmlutils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Ricardoc
 */
public class HtmlUtils {
  
  private static Map<Integer,String[]> getArticles() {
    Map<Integer,String[]> articles = new HashMap();
    String[] article = new String[2];
    
    article = new String[2];
    article[0] = "Log Times";
    article[1] = "logtimes.jsp";
    articles.put(1,article);
    
    article = new String[2];
    article[0] = "Projects";
    article[1] = "projects.jsp";
    articles.put(2,article);
    
    article = new String[2];
    article[0] = "Tasks";
    article[1] = "tasks.jsp";
    articles.put(3,article);

    article = new String[2];
    article[0] = "Task Types";
    article[1] = "tasktypes.jsp";
    articles.put(4,article);

    return articles;
  }
  
  public static String getNavBar() {
    String res = "<div class=\"w3-top\">";
    res += "<div class=\"w3-bar w3-theme w3-top w3-left-align w3-large\">";
    res += "<a class=\"w3-bar-item w3-button w3-right w3-hide-large w3-hover-white w3-large w3-theme-l1\" href=\"javascript:void(0)\" onclick=\"w3_open()\"><i class=\"fa fa-bars\"></i></a>";
    res += "<a href=\"index.jsp\" class=\"w3-bar-item w3-button w3-theme-l1\">Home</a>";
    Map<Integer,String[]> articles = HtmlUtils.getArticles();
    for (Integer k : articles.keySet() ) {
      String[] article = articles.get(k);
      res += "<a href=\"" + article[1] + "\" class=\"w3-bar-item w3-button w3-hide-small w3-hover-white\">" + article[0] +"</a>";
    }
    res += "</div>";
    res += "</div>";
    
    return res;
  }
  
  public static String getHtmlHeaders() {
    String res = "<title>Task Manager</title>";
    res += "<meta charset=\"UTF-8\">";
    res += "<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">";
    res += "<link rel=\"stylesheet\" type=\"text/css\" href=\"css/w3.css\">";
    res += "<link rel=\"stylesheet\" type=\"text/css\" href=\"css/w3-theme-black.css\">";
    res += "<link rel=\"stylesheet\" type=\"text/css\" href=\"css/Roboto.css\">";
    res += "<link rel=\"stylesheet\" type=\"text/css\" href=\"css/font-awesome.min.css\">";
    res += "<style>";
    res += "html,body,h1,h2,h3,h4,h5,h6 {font-family: \"Roboto\", sans-serif;} ";
    res += ".w3-sidebar {";
    res += "z-index: 3;";
    res += "width: 250px;";
    res += "top: 43px;";
    res += "bottom: 0;";
    res += "height: inherit;";
    res += "} </style>";
    return res;
  }
  
  public static String getFooter() {
    String msgFooter = new String();
    Date date = new Date();
    SimpleDateFormat dt1 = new SimpleDateFormat("yyyy/MM/dd '-' hh:mm a");
    msgFooter+=dt1.format(date);
    
    String res = "<footer id=\"myFooter\">";
    res += "<div class=\"w3-container w3-theme-l2 w3-padding-32\">";
    res += "<h4>"+msgFooter+"</h4>";
    res += "</div>";

    res += "<div class=\"w3-container w3-theme-l1\">";
    res += "<p>Powered by <a href=\"https://www.w3schools.com/w3css/default.asp\" target=\"_blank\">w3.css</a></p>";
    res += "</div>";
    res += "</footer>";
    
    return res;
  }
}
