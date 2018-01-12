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
public class Project {
  private Integer id;
  private String description;
  private String notes;

  public Project() {
    this.id = null;
    this.description = null;
    this.notes = null;
  }

  public Project(Integer id, String description, String notes) {
    this.id = id;
    this.description = description;
    this.notes = notes;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getNotes() {
    return notes;
  }

  public void setNotes(String notes) {
    this.notes = notes;
  }
  
  
}
