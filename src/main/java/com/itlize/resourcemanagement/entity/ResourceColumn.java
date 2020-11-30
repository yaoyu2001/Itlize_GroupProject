package com.itlize.resourcemanagement.entity;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "resource_column")
public class ResourceColumn {

  @Id
  @GeneratedValue (strategy = GenerationType.IDENTITY)
  private long columnId;

  @Column(name = "resource_column_name")
  private String columnName;

  @Column(name = "resource_column_value")
  private String columnValue;

  @ManyToOne(cascade= {CascadeType.PERSIST, CascadeType.MERGE,
          CascadeType.DETACH, CascadeType.REFRESH})
  @JoinColumn(name="resources_id")
  private Resources resources;



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


  public String getColumnValue() {
    return columnValue;
  }

  public void setColumnValue(String columnValue) {
    this.columnValue = columnValue;
  }

}
