# Spring boot SimpleBoard

Spring Boot에서 Hibernate와 Thymeleaf를 사용한 SimpleBoard예제

----------
* `_application.yml` 파일 이름을 `application.yml` 로 바꿔주세요.

* `application.yml` 파일에서  `datasource:`의 `url` `username` `password`  입력해주세요.

*  만약 MySQL사용이 힘들다면.</br>
`build.gradle` 파일의 `runtime('mysql:mysql-connector-java')` 부분을</br>
`runtime('com.h2database:h2')` 바꿔 주세요.</br>
그리고 `application.yml` 파일을</br>
```yml
spring:
  jpa:
    database: MYSQL
    show-sql: true
    hibernate:
      ddl-auto: update
    properties:
      hibernate:
        format_sql: true
```
이렇게 바꿔주세요.

* 이 프로젝트는 `Lombok` 를 사용합니다.</br>
[Lombok Eclipse install](https://projectlombok.org/setup/eclipse)</br>
[Lombok Intellij IDEA install](https://projectlombok.org/setup/intellij)</br>
[`Lombok`이란?](https://projectlombok.org/features/all)
