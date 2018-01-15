
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import org.taskmanager.dao.XMLDAO;
import org.taskmanager.model.TaskType;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Ricardoc
 */
public class AppTests {
  
  private static final String file = "db.xml";

  private static void deleteDBFile() {
    try {
      File f;
      f = new File(AppTests.file);
      if(f.delete()){
        System.out.println(f.getName() + " is deleted!");
      }
      else{
        System.out.println("Delete operation is failed.");
      }
    }
    catch (Exception ex) {
      printError(ex);
    }
  }
  
  private static void createFile() {
    BufferedWriter writer = null;
    try {
      File f;
      f = new File(AppTests.file);
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
        System.out.println(f.getName() + " is created!");
      }
      else
        System.out.println(f.getName() + " already exists!");
    } catch (Exception ex) {
      printError(ex);
    }
    finally {
      try {
        if ( writer != null)
          writer.close( );
      }
      catch ( IOException e) {}
    }
  }
  
  private static void test1() {
    try {
      XMLDAO db;
      db = new XMLDAO();
      TaskType t = new TaskType();
      t.setId(2);
      t.setDescription("Test 2");      
      db.saveTaskType(t);
      db.writeXMLFile();
    } catch (Exception ex) {
      printError(ex);
    }      
  }
  
  private static void test2() {
    try {
      XMLDAO db;
      db = new XMLDAO();
      db.removeTaskType(2);
      db.writeXMLFile();
    }
    catch (Exception ex) {
      printError(ex);
    }
  }
  
  private static void printError(Exception e) {
    System.out.println("Error:\n" + e.getMessage() );
    e.printStackTrace();
  }
    
  public static void main(String[] args) throws Exception {
    deleteDBFile();
    createFile();
    
    
  }  
}
