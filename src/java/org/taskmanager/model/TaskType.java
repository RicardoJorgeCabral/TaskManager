/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.taskmanager.model;

/**
 *
 * @author Ricardoc
 */
public class TaskType {
  private Integer id;
  private String description;
  private String notes;

  public TaskType() {
    this.id = null;
    this.description = null;
    this.notes = null;
  }

  public TaskType(Integer id, String description, String notes) {
    this.id = id;
    this.description = description;
    this.notes = notes;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) throws Exception {
    if ( (id!=null) && (id>0) )
      this.id = id;
    else
      throw new Exception("Bad value for TaskType id.");
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) throws Exception {
    if ( (description!=null) && (description.length()>0))
      this.description = description;
    else
      throw new Exception("Bad value for TaskType description.");
  }

  public String getNotes() {
    return notes;
  }

  public void setNotes(String notes) {
    this.notes = notes;
  }
  
  
  
}
