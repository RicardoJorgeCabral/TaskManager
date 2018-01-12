/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.taskmanager.dao;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;
import org.taskmanager.model.TaskType;

/**
 *
 * @author Ricardoc
 */
public class XMLDAO {
  private File xmlFile;
  private Document doc;
  
  public XMLDAO(File xmlFile) throws Exception {
    
    this.xmlFile = xmlFile;
    if ( (this.xmlFile.exists()) && !(this.xmlFile.isDirectory()) ) {            
      SAXReader reader = new SAXReader();
      this.doc = reader.read( this.xmlFile );
    }
    else {
      throw new Exception("Bad XML file!");
    }
    
  } 
  
  public static void createDbFile(String file) throws Exception {
    BufferedWriter writer = null;
    try {
      File f;
      f = new File(file);
      if ( (!f.isDirectory()) & (!f.exists()) ) {
        f.createNewFile();
        writer = new BufferedWriter(new FileWriter(f));
        writer.write("<?xml version=\"1.0\"?>");      
        writer.write("<data>");
        writer.write("<tasktypes>");
        writer.write("</tasktypes>");
        writer.write("<tasks>");
        writer.write("</tasks>");
        writer.write("<tasklogtimes>");
        writer.write("</tasklogtimes>");
        writer.write("</data>");        
      }
      else
        throw new Exception("File already exists!!");
    } 
    catch (Exception ex) {
      throw ex;
    }
    finally {
      try {
        if ( writer != null)
          writer.close( );
      }
      catch ( IOException e) {}
    }    
  }
  
  /*
  ================ T A S K    T Y P E S ==================
  */
  
  public void saveTaskType(TaskType t) throws Exception {
    Element node = this.doc.getRootElement().element("tasktypes");
    Element newNode = node.addElement("tasktype");
    
    newNode.addAttribute("id", t.getId().toString());
    newNode.addElement("description").addText(t.getDescription());
    if ( (t.getNotes()!=null) && (t.getNotes().length()>0) )
      newNode.addElement("notes").addText(t.getNotes());    
  }
  
  public TaskType getTaskType(Integer id) throws Exception {
    TaskType t = null;
    
    Element nodes = this.doc.getRootElement().element("tasktypes");
    Iterator itr = nodes.elementIterator();
    
    boolean found = false;
    
    while (itr.hasNext() && !found) {
      Node node = (Node) itr.next();
      if ( id.equals(node.valueOf("@id"))) {
        found = true;
        t = new TaskType();
        t.setId(new Integer(node.valueOf("@id")));
        t.setDescription(node.selectSingleNode("description").getText());
        Node aNode = node.selectSingleNode("notes");
        if (aNode != null) t.setNotes(aNode.getText());
      }
    }
    return t;
  }
  
  public boolean removeTaskType(Integer id) throws Exception {
    Element nodes = this.doc.getRootElement().element("tasktypes");
    Iterator itr = nodes.elementIterator();

    boolean found = false;
        
    while (itr.hasNext() && !found) {
      Node node = (Node) itr.next();                          
      if ( id.equals(new Integer(node.valueOf("@id")))) {
        found = true;
        node.detach();
      }
    }
    
    return found;
  }
  
  public ArrayList<TaskType> getTaskTypes() throws Exception {
    ArrayList<TaskType> res = new ArrayList<TaskType>();
    Element nodes = this.doc.getRootElement().element("tasktypes");
    
    Iterator itr = nodes.elementIterator();
    
    while (itr.hasNext()) {
      Node node = (Node) itr.next();                        
      TaskType t = new TaskType();
      
      Integer nodeId = new Integer(node.valueOf("@id"));
      t.setId(nodeId);
      t.setDescription(node.selectSingleNode("description").getText());
      Node aNode = node.selectSingleNode("notes");
      if (aNode != null) t.setNotes(aNode.getText());       
      
      res.add(t);
    }
    
    return res;
  }
    
  public void writeXMLFile() throws Exception {    
    OutputFormat format = OutputFormat.createPrettyPrint();
    XMLWriter writer;      
    //writer = new XMLWriter( System.out, format );
    writer = new XMLWriter( new FileWriter(this.xmlFile) );
    writer.write( this.doc );
    writer.flush();
    writer.close();  
  }
  
}