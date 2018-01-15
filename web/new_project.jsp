<%-- 
    Document   : new_project
    Created on : 15/jan/2018, 16:10:25
    Author     : Ricardoc
--%>

<%@page import="java.util.Map"%>
<%@page import="org.taskmanager.htmlutils.HtmlUtils"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  
<% out.print(HtmlUtils.getHtmlHeaders()); %>

<body>

<%
String errorf1 = null;
if (request.getParameter("errorf1")!=null) errorf1=request.getParameter("errorf1");
%>

<!-- Navbar -->
<% out.print(HtmlUtils.getNavBar()); %>

<!-- Sidebar -->
<!--
<nav class="w3-sidebar w3-bar-block w3-collapse w3-large w3-theme-l5 w3-animate-left" id="mySidebar">
  <a href="javascript:void(0)" onclick="w3_close()" class="w3-right w3-xlarge w3-padding-large w3-hover-black w3-hide-large" title="Close Menu">
    <i class="fa fa-remove"></i>
  </a>
  <h4 class="w3-bar-item"><b>Menu</b></h4>
  <a class="w3-bar-item w3-button w3-hover-black" href="#">Link</a>
  <a class="w3-bar-item w3-button w3-hover-black" href="#">Link</a>
  <a class="w3-bar-item w3-button w3-hover-black" href="#">Link</a>
  <a class="w3-bar-item w3-button w3-hover-black" href="#">Link</a>
</nav>
-->
<!-- Overlay effect when opening sidebar on small screens -->
<div class="w3-overlay w3-hide-large" onclick="w3_close()" style="cursor:pointer" title="close side menu" id="myOverlay"></div>

<!-- Main content: shift it to the right by 250 pixels when the sidebar is visible -->
<!-- <div class="w3-main" style="margin-left:250px"> -->
<div class="w3-main">
  <form id="form1" action="SaveProjectServlet" method="POST">
  <input type="hidden" name="id" value="0" />
  
  <div class="w3-row w3-padding-64">
    <div class="w3-twothird w3-container">
      <h1 class="w3-text-teal">New Project</h1>
      <table>
        <tr>
          <td valign="top">Project:</td>
          <td><input type="text" name="description" value="" size="95" /><div class="w3-red"><% if (errorf1 != null) out.print(errorf1); %></div></td>
        </tr>
        <tr>
          <td valign="top">Notes:</td>
          <td><textarea name="notes" rows="6" cols="100">
            </textarea></td>
        </tr>
        <tr>
          <td colspan="2">
            <a class="w3-bar-item w3-button w3-theme-l1" href="javascript:{}" onclick="document.getElementById('form1').submit(); return false;">Save</a>
            <a class="w3-bar-item w3-button w3-theme-l1" href="javascript:{}" onclick="window.location.href='projects.jsp'; return false;">Back</a>
          </td>
        </tr>
      </table>
    </div>
  </div>

  </form>

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

