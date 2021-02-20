# Hello-World


*[Deployed Here](https://cup-o-tea.herokuapp.com/helloworld)*  

[![Codefresh build status]( https://g.codefresh.io/api/badges/pipeline/jinfluenza/codefresh-pulumi%2FCup-o-tea?type=cf-1&key=eyJhbGciOiJIUzI1NiJ9.NjAxZGFhMWY0YmY4N2RkNmY2NzY1MzMy.RRKnJ1bIBk7UvZJxGw8We3oyv56h4yEIjBR41N4n-Ps)]( https://g.codefresh.io/pipelines/edit/new/builds?id=60253ae564db849ab4b14637&pipeline=Cup-o-tea&projects=codefresh-pulumi&projectId=602145fb5766b7bc4ad52e8a)  
  
[Swagger Endpoints](https://app.swaggerhub.com/apis-docs/jinwoov/jwtJava/1.0.0)  

## Endpoints:
- `/hello`: need authentication and jwt, use POSTMAN with jwtoken `/GET` route
    - application type is json
    - Header should include Authentication with `Bearer <jwtoken>` provided by authenticate.
    
- `/authenticate`: route that will generate token with correct credential `/POST` route
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
