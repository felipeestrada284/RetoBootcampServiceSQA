package com.fakestoreapi.stepDefinitions;

import com.fakestoreapi.questions.ServerResponse;
import com.fakestoreapi.tasks.PostUserTask;
import com.fakestoreapi.utils.Data;
import io.cucumber.java.Before;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import net.thucydides.core.util.EnvironmentVariables;

import java.util.Map;

import static org.hamcrest.Matchers.equalTo;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;

public class PostUserStepDef {
    Map<String, String> data = Data.extractTo().get(0);


    private EnvironmentVariables environmentVariables;
    Actor user = Actor.named("user");


    @Before
    public void setUpBaseUrl(){
        String theRestApiBaseUrl = environmentVariables.optionalProperty("restapi.baseurl")
                .orElse("https://fakestoreapi.com");

        user.whoCan(CallAnApi.at(theRestApiBaseUrl));
    }

    @When("I consume the service and I send the user information")
    public void iConsumeTheServiceAndISendTheUserInformation() {
        user.attemptsTo(PostUserTask.on());
    }

    @Then("I can validate the response service")
    public void iCanValidateTheResponseService() {

        user.should(
                seeThat(
                        "The response code was: ",
                        ServerResponse.was(),
                        equalTo(Integer.parseInt(data.get("status")))
                )
        );
    }


}
