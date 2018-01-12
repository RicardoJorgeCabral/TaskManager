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
public class TaskLogTime {

  private Task task;
  private Date date;
  private Float time;
  private String notes;

  public TaskLogTime() {
    this.task = null;
    this.date = null;
    this.time = null;
    this.notes = null;
  }

  public TaskLogTime(Task task, Date date, Float time, String notes) {
    this.task = task;
    this.date = date;
    this.time = time;
    this.notes = notes;
  }

  public Task getTask() {
    return task;
  }

  public void setTask(Task task) {
    this.task = task;
  }

  public Date getDate() {
    return date;
  }

  public void setDate(Date date) {
    this.date = date;
  }

  public Float getTime() {
    return time;
  }

  public void setTime(Float time) {
    this.time = time;
  }

  public String getNotes() {
    return notes;
  }

  public void setNotes(String notes) {
    this.notes = notes;
  }
  
  
  
  
}
