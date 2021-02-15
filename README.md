# Hello-World

## Deployed Website

*[Deployed Here](https://cup-o-tea.herokuapp.com/helloworld)*  

## Endpoints:
- `/hello`: need authentication and jwt, use POSTMAN with jwtoken `GET` route
    - application type is json
    ```json
    {
        "username": "jin",
        "password": "jin"
    } 
    ```
    - Header should include Authentication with `Bearer <jwtoken>` provided by authenticate.
    
- `/authenticate`: route that will generate token with correct credential `POST` route
    - application type is json 
    ``` json
    {
        "username": "jin",
        "password": "jin"
    }
    ```
- `/helloworld`: because why not?


## Error to Denote
``` xml
<maven.compiler.source>1.8</maven.compiler.source> 
<maven.compiler.target>1.8</maven.compiler.target>

// this was causing an error during the build step add this uder properties tag

```
[source](https://stackoverflow.com/questions/42525139/maven-build-compilation-error-failed-to-execute-goal-org-apache-maven-plugins)
