/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.taskmanager.model;

import java.util.Date;

/**
 *
 * @author Ricardoc
 */
public class Task {
  private Integer id;
  private TaskType type;
  private String description;
  private Date startDate;
  private Date endDate;
  private String notes;

  public Task(Integer id, TaskType type, String description, Date startDate, Date endDate, String notes) {
    this.id = id;
    this.type = type;
    this.description = description;
    this.startDate = startDate;
    this.endDate = endDate;
    this.notes = notes;
  }
  
  public Task() {
    this.id=null;
    this.description=null;
    this.startDate=null;
    this.endDate=null;
    this.notes=null;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) throws Exception {
    if (id>0)
      this.id = id;
    else
      throw new Exception("Bad value for task Id.");
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) throws Exception {
    if ( (description != null) && (description.length()>0) )
      this.description = description;
    else 
      throw new Exception("Bad value for task description.");
  }

  public Date getStartDate() {
    return startDate;
  }

  public void setStartDate(Date startDate) {
    this.startDate = startDate;
  }

  public Date getEndDate() {
    return endDate;
  }

  public void setEndDate(Date endDate) {
    this.endDate = endDate;
  }

  public String getNotes() {
    return notes;
  }

  public void setNotes(String notes) {
    this.notes = notes;
  }

  public TaskType getType() {
    return type;
  }

  public void setType(TaskType type) {
    this.type = type;
  }
  
  
  
  
}
