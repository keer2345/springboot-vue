# Backend
## PostgreSQL
- [PostgreSQL Tutorial](https://www.postgresqltutorial.com/)
- [Youtube](https://youtu.be/qw--VYLpxG4)

``` sql
CREATE USER springboot WITH PASSWORD '123456';
create database springboot_vue OWNER springboot  ;;
GRANT ALL PRIVILEGES ON DATABASE springboot_vue TO springboot;
GRANT ALL PRIVILEGES ON all tables in schema public TO springboot;
```

`application.properties`:
```properties
spring.datasource.url= jdbc:postgresql://localhost:5432/springboot_vue
spring.datasource.username= springboot
spring.datasource.password= 123456

spring.jpa.properties.hibernate.jdbc.lob.non_contextual_creation= true
spring.jpa.properties.hibernate.dialect= org.hibernate.dialect.PostgreSQLDialect

spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true

# Hibernate ddl auto (create, create-drop, validate, update)
spring.jpa.hibernate.ddl-auto= update
```

## Spring Boot
Create Spring boot project with grade and java, dependencies in web, jpa and postgresql.

`build.gradle`:
```
// ...
dependencies {
	implementation 'org.springframework.boot:spring-boot-starter-data-jpa'
	implementation 'org.springframework.boot:spring-boot-starter-web'
	runtimeOnly 'org.postgresql:postgresql'
	testImplementation 'org.springframework.boot:spring-boot-starter-test'
}

// ...
```
# Frontend
## Vue Environment

**Install Vue:**
``` sh
npm install -g @vue/cli-init
vue --version
```

**Create Vue Project:**
``` sh
vue create frontend

cd frontend
yarn serve
``` 
