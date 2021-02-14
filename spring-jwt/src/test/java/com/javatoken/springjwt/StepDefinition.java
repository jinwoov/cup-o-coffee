package com.javatoken.springjwt;

import com.github.tomakehurst.wiremock.WireMockServer;
import io.cucumber.java.Status;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import static org.apache.http.client.methods.RequestBuilder.options;
import static org.junit.Assert.*;


public class StepDefinition {
    public String path;
    public int SC;

    @Given("Request route is {string}")
    public void request_Route(String route){
        this.path = route;
    }

    @When("the client calls for /{string} request")
    public void the_website_issues_Get(String rq) throws Throwable {
        WireMockServer wireMockServer = new WireMockServer(options().*);
        HttpGet request = new HttpGet("http://localhost:8080/" + rq);
        final CloseableHttpClient httpClient = HttpClients.createDefault();
        try (CloseableHttpResponse response = httpClient.execute(request)) {
            SC = response.getStatusLine().getStatusCode();
        }
    }

    @Then("I should be given with {string}")
    public void i_should_get(String expected) {
        assertEquals(expected, Integer.toString(SC));
    }
}
