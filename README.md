# crmmodel

# Software Requirements
  - maven 3.0.5
  - redis 3.0.7
  - mysql 5.67  - java 8
  - Liquibase
  - MySql
  - Swagger
  - Jackson
  - 

# setup build and run
1. clone the repository into your local machine.
    -  git@github.com:shardaprasad001/crmmodel.git

2. configure .properties file
    - database-username = ${database_username}
    - database-password = ${database_password}

3. Build the project.
    - mvn clean install -Denvironment=${environment}

4. Run the project.
    - mvn spring-boot:run -Denvironment=${environment}
    - run on tomcat server and set the environment variable.# crmmodel