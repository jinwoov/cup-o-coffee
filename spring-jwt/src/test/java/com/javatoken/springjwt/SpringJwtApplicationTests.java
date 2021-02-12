package com.javatoken.springjwt;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;

@RunWith(Cucumber.class)
@CucumberOptions(features ="src/test/resources", plugin = {"pretty"})
@SpringBootTest
class SpringJwtApplicationTests {


}
