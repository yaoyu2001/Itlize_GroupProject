package com.itlize.resourcemanagement.entity;
import javax.persistence.*;

import com.itlize.resourcemanagement.entity.Project;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Size;


@Entity
@Table(name = "project_column", uniqueConstraints = {@UniqueConstraint (columnNames = "project_column_name")})
public class ProjectColumn {

  enum  ProjectColumnType {
    number, text, formula;
  }
  @Id
  @GeneratedValue (strategy = GenerationType.IDENTITY)
  private long columnId;

  @Size (max=50)
  @Column(name = "project_column_name")
  private String columnName;

  @Enumerated (EnumType.STRING)
  @Column (name = "project_column_type")
  private ProjectColumnType projectColumnType;

  @Column(name = "formual_text")
  private String formulaText;

  @ManyToOne (cascade= {CascadeType.PERSIST, CascadeType.MERGE,
          CascadeType.DETACH, CascadeType.REFRESH})
  @JoinColumn (name = "project_id")
  private Project project;

  public long getColumnId() {
    return columnId;
  }

  public void setColumnId(long columnId) {
    this.columnId = columnId;
  }


  public String getColumnName() {
    return columnName;
  }

  public void setColumnName(String columnName) {
    this.columnName = columnName;
  }


  public String getFormulaText() {
    return formulaText;
  }

  public void setFormulaText(String formulaText) {
    this.formulaText = formulaText;
  }

  public ProjectColumnType getRole() {
    return projectColumnType;
  }

  public void setRole(ProjectColumnType projectColumnType) {
    this.projectColumnType = projectColumnType;
  }

}
