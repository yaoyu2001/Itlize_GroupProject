package com.itlize.resourcemanagement.entity;

import javax.persistence.*;

@Entity
@Table(name = "resource_column")
public class ResourceColumn {
  public enum  ColumnType {
    number, text, formula;
  }
  @Id
  @GeneratedValue (strategy = GenerationType.IDENTITY)
  private int columnId;

  @Column(name = "resource_column_name")
  private String columnName;

  @Column(name = "resource_column_value")
  private String columnValue;

  @Column(name = "resource_column_type")
  private ColumnType columnType;

  @ManyToOne(cascade= {CascadeType.PERSIST, CascadeType.MERGE,
          CascadeType.DETACH, CascadeType.REFRESH})
  @JoinColumn(name="resource_id")
  private Resource resource;


  @ManyToOne(cascade= {CascadeType.PERSIST, CascadeType.MERGE,
          CascadeType.DETACH, CascadeType.REFRESH})
  @JoinColumn(name="project_id")
  private Project project;

  public ResourceColumn() {
  }

  public ResourceColumn(String columnName, String columnValue,
                        ColumnType columnType, Resource resource, Project project) {
    this.columnName = columnName;
    this.columnValue = columnValue;
    this.columnType = columnType;
    this.resource = resource;
    this.project = project;
  }

  public int getColumnId() {
    return columnId;
  }

  public void setColumnId(int columnId) {
    this.columnId = columnId;
  }

  public String getColumnName() {
    return columnName;
  }

  public void setColumnName(String columnName) {
    this.columnName = columnName;
  }

  public String getColumnValue() {
    return columnValue;
  }

  public void setColumnValue(String columnValue) {
    this.columnValue = columnValue;
  }

  public ColumnType getColumnType() {
    return columnType;
  }

  public void setColumnType(ColumnType columnType) {
    this.columnType = columnType;
  }

  public Resource getResource() {
    return resource;
  }

  public void setResource(Resource resource) {
    this.resource = resource;
  }

  public Project getProject() {
    return project;
  }

  public void setProject(Project project) {
    this.project = project;
  }
}
