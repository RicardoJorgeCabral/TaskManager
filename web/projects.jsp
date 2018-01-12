<%-- 
    Document   : projects
    Created on : 12/jan/2018, 17:27:04
    Author     : Ricardoc
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="org.taskmanager.model.Project"%>
<%@page import="org.taskmanager.dao.XMLDAO"%>
<%@page import="org.taskmanager.htmlutils.HtmlUtils"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<title>W3.CSS Template</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" type="text/css" href="css/w3.css">
<link rel="stylesheet" type="text/css" href="css/w3-theme-black.css">
<link rel="stylesheet" type="text/css" href="css/Roboto.css">
<link rel="stylesheet" type="text/css" href="css/font-awesome.min.css">
<style>
html,body,h1,h2,h3,h4,h5,h6 {font-family: "Roboto", sans-serif;}
.w3-sidebar {
  z-index: 3;
  width: 250px;
  top: 43px;
  bottom: 0;
  height: inherit;
}
</style>
<body>

<!-- Navbar -->
<% out.print(HtmlUtils.getNavBar()); %>

<!-- Sidebar -->

<nav class="w3-sidebar w3-bar-block w3-collapse w3-large w3-theme-l5 w3-animate-left" id="mySidebar">
  <a href="javascript:void(0)" onclick="w3_close()" class="w3-right w3-xlarge w3-padding-large w3-hover-black w3-hide-large" title="Close Menu">
    <i class="fa fa-remove"></i>
  </a>
  <h4 class="w3-bar-item"><b>Menu</b></h4>
  <a class="w3-bar-item w3-button w3-hover-black" href="projects.jsp">List of projects</a>
  <a class="w3-bar-item w3-button w3-hover-black" href="new_project.jsp">Add project</a>
  <a class="w3-bar-item w3-button w3-hover-black" href="index.jsp">Back</a>  
</nav>

<!-- Overlay effect when opening sidebar on small screens -->
<div class="w3-overlay w3-hide-large" onclick="w3_close()" style="cursor:pointer" title="close side menu" id="myOverlay"></div>

<!-- Main content: shift it to the right by 250 pixels when the sidebar is visible -->
<div class="w3-main" style="margin-left:250px">

  <div class="w3-row w3-padding-64">
    <div class="w3-twothird w3-container">
      <h1 class="w3-text-teal">Projects</h1>
      <h2><b>List of projects</b></h2>
      <table cellpadding="3">
        <tr class="w3-theme-l1"><td>&nbsp;</td><td>Id</td><td>Description</td><td>Notes</td></tr>
      <%
        XMLDAO db = new XMLDAO();
        ArrayList<Project> list = db.getProjects();
        for (Project p : list) {
          out.print("<tr><td>&nbsp;</td><td>" + p.getId().toString() + "</td><td>" + p.getDescription() + "</td><td>" + p.getNotes() + "</td></tr>");
        }
        %>      
      </table>
    </div>
  </div>


  <!-- Pagination -->
  <!--
  <div class="w3-center w3-padding-32">
    <div class="w3-bar">
      <a class="w3-button w3-black" href="#">1</a>
      <a class="w3-button w3-hover-black" href="#">2</a>
      <a class="w3-button w3-hover-black" href="#">3</a>
      <a class="w3-button w3-hover-black" href="#">4</a>
      <a class="w3-button w3-hover-black" href="#">5</a>
      <a class="w3-button w3-hover-black" href="#">»</a>
    </div>
  </div>
  -->
  
<% out.print(HtmlUtils.getFooter()); %>

<!-- END MAIN -->
</div>

<script>
// Get the Sidebar
var mySidebar = document.getElementById("mySidebar");

// Get the DIV with overlay effect
var overlayBg = document.getElementById("myOverlay");

// Toggle between showing and hiding the sidebar, and add overlay effect
function w3_open() {
    if (mySidebar.style.display === 'block') {
        mySidebar.style.display = 'none';
        overlayBg.style.display = "none";
    } else {
        mySidebar.style.display = 'block';
        overlayBg.style.display = "block";
    }
}

// Close the sidebar with the close button
function w3_close() {
    mySidebar.style.display = "none";
    overlayBg.style.display = "none";
}
</script>

</body>
</html>

