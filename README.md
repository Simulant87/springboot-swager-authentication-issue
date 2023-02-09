# About

this example project showing an authentication issue to the Swagger UI, when updating Spring Boot from 2.7.8 to 3.0.2.

## Instructions

start the application with:
```
./gradlew bootRun
```

open [http://localhost:8080/swagger-ui/index.html](http://localhost:8080/swagger-ui/index.html)

Observed behaviour: HTTP Status 403, access denied

Expected behaviour: Swagger UI loading.

While for [http://localhost:8080/actuator/health](http://localhost:8080/actuator/health) it works as expected.

The Security configuration is done in [SecurityConfigurer.kt](src/main/kotlin/com/example/config/SecurityConfigurer.kt).
