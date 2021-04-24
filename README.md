**[Spring Boot + Vue.js + PostgreSQL: CRUD example](https://bezkoder.com/spring-boot-vue-js-postgresql/#Spring_Boot_Vuejs_PostgreSQL_CRUD_example)**

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

- https://bezkoder.com/vue-js-crud-app/

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
**Add modules:**
``` sh
yarn add vue-router
yarn add axios
```

**Before:**

```
> tree -I "node_modules" frontend
frontend
├── README.md
├── babel.config.js
├── package.json
├── public
│   ├── favicon.ico
│   └── index.html
├── src
│   ├── App.vue
│   ├── assets
│   │   └── logo.png
│   ├── components
│   │   └── HelloWorld.vue
│   └── main.js
└── yarn.lock
```

**After:**

```
> tree -I "node_modules" frontend
frontend
├── README.md
├── babel.config.js
├── package.json
├── public
│   ├── favicon.ico
│   └── index.html
├── src
│   ├── App.vue
│   ├── assets
│   │   └── logo.png
│   ├── components
│   │   ├── AddTutorial.vue
│   │   ├── HelloWorld.vue
│   │   ├── Tutorial.vue
│   │   └── TutorialsList.vue
│   ├── http-common.js
│   ├── main.js
│   ├── router.js
│   └── services
│       └── TutorialDataService.js
├── vue.config.js
└── yarn.lock
```

- **package.json** contains 3 main modules: `vue`, `vue-router`, `axios`.
– There are 3 components: `TutorialsList`, `Tutorial`, `AddTutorial`.
– **router.js** defines routes for each component.
– **http-common.js** initializes axios with HTTP base Url and headers.
– TutorialDataService has methods for sending HTTP requests to the Apis.
– **vue.config.js** configures port for this Vue Client.

# Other Materials
- [Full Stack Java development with Spring Boot and VueJS](https://www.danvega.dev/blog/2021/01/22/full-stack-java-vue/)
- [Vue + Spring Boot 项目实战（一）：项目简介](https://blog.csdn.net/Neuf_Soleil/article/details/88925013)
- [超详细！4小时开发一个SpringBoot+vue前后端分离博客项目！！](https://juejin.cn/post/6844903823966732302)
