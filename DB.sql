DROP DATABASE IF EXISTS resources_manager_project;
Create DATABASE resources_manager_project;
Use resources_manager_project;
CREATE TABLE User(
                     user_id int NOT NULL Auto_increment primary key ,
                     user_name char(50) NOT NULL Unique,
                     password char(50)NOT NULL,
                     role ENUM('admin', 'customer'),
                     Time DATETIME  default CURRENT_TIMESTAMP,
                     main_image varchar (500) default NULL,
                     email varchar(50),
                     Firstname varchar(50) NOT NULL ,
                     Lastname varchar(50) NOT NULL
);
CREATE TABLE projects(
                         project_id int NOT NULL Auto_increment primary key ,
                         project_name char(50) DEFAULT NULL,
                         create_time DATETIME  default CURRENT_TIMESTAMP,
                         update_time DATETIME  default CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP
);
CREATE TABLE Resources(
                          Resource_code int(6) NOT NULL Auto_increment UNIQUE primary key ,
                          resource_name char(50) NOT NULL UNIQUE,
                          editable Boolean Default False,
                          item_id char(50),
                          create_time DATETIME  default CURRENT_TIMESTAMP,
                          update_time DATETIME  default CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP
);
CREATE TABLE user_projects(
                              ID int NOT NULL AUTO_INCREMENT primary key,
                              user_id int NOT NULL,
                              project_id int NOT NULL,
                              FOREIGN KEY (user_id) references user(user_id),
                              FOREIGN KEY (project_id) references projects(project_id)
);
CREATE TABLE project_resources(
                                  id int NOT NULL AUTO_INCREMENT primary key,
                                  project_id int NOT NULL,
                                  Resource_code int(6) NOT NULL,
                                  FOREIGN KEY (project_id) references projects(project_id),
                                  FOREIGN KEY (Resource_code) references Resources(Resource_code)
)