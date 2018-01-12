/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.taskmanager.htmlutils;

import java.io.File;

/**
 *
 * @author Ricardoc
 */
public class Configs {
  
  private static String xmlFile = "db.xml";
  
  public static File getXmlDbFile() throws Exception {
    File f;
    f = new File(Configs.xmlFile);
    return f;
  }
}
