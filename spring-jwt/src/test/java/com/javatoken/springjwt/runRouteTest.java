package com.javatoken.springjwt;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@RunWith(Cucumber.class)
@CucumberOptions(features ="src/test/resources", plugin = {"pretty"},
        glue = "com.testing")
public class runRouteTest {
}
