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
  private Project project;  
  private TaskType type;
  private String description;
  private Date startDate;
  private Date endDate;
  private Float workEffort; // percentagem de realização da tarefa
  private boolean done;
  private String notes;

  public Task(Integer id, Project project, TaskType type, String description, Date startDate, Date endDate, Float workEffort, boolean done, String notes) {
    this.id = id;
    this.project = project;
    this.type = type;
    this.description = description;
    this.startDate = startDate;
    this.endDate = endDate;
    this.workEffort = workEffort;
    this.done = done;
    this.notes = notes;
  }

  public Task() {
    this.id = null;
    this.project = null;
    this.type = null;
    this.description = null;
    this.startDate = null;
    this.endDate = null;
    this.workEffort = null;
    this.done = false;
    this.notes = null;
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

  public Project getProject() {
    return project;
  }

  public void setProject(Project project) {
    this.project = project;
  }

  public Float getWorkEffort() {
    return workEffort;
  }

  public void setWorkEffort(Float workEffort) {
    this.workEffort = workEffort;
  }

  public boolean isDone() {
    return done;
  }

  public void setDone(boolean done) {
    this.done = done;
  }
  
  
  
  
}
