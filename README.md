Project structure:
```
.
├── pom.xml
└── src
    └── main
        ├── java
        │   └── app
        │       ├── model
        │       │   ├── Permission.java
        │       │   ├── Role.java
        │       │   └── User.java
        │       ├── persistence
        │       │   ├── Dao.java
        │       │   ├── role
        │       │   │   ├── InMemoryRoleDao.java
        │       │   │   └── RoleDao.java
        │       │   └── user
        │       │       ├── InMemoryUserDao.java
        │       │       └── UserDao.java
        │       ├── service
        │       │   ├── ModelConverter.java
        │       │   ├── role
        │       │   │   ├── RoleService.java
        │       │   │   └── RoleView.java
        │       │   └── user
        │       │       ├── UserService.java
        │       │       └── UserView.java
        │       ├── utils
        │       │   ├── DemoDataInitializer.java
        │       │   └── log
        │       │       ├── DummyCommandLineLogger.java
        │       │       └── Logger.java
        │       └── web
        │           ├── RoleServlet.java
        │           └── UserServlet.java
        └── webapp
            ├── index.jsp
            ├── roles.jsp
            ├── users.jsp
            └── WEB-INF
                └── web.xml
```