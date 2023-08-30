package com.fakestoreapi.stepDefinitions;

import com.fakestoreapi.questions.ServerResponse;
import com.fakestoreapi.tasks.PutUserTask;
import com.fakestoreapi.utils.Data;
import io.cucumber.java.Before;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import net.thucydides.core.util.EnvironmentVariables;

import java.util.Map;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.equalTo;

public class PutUserStepDef {

    Map<String, String> data = Data.extractTo().get(0);

    private EnvironmentVariables environmentVariables;
    Actor user = Actor.named("user");

    @Before
    public void setUpBaseUrl(){
        String theRestApiBaseUrl = environmentVariables.optionalProperty("restapi.baseurl")
                .orElse("https://fakestoreapi.com");

        user.whoCan(CallAnApi.at(theRestApiBaseUrl));

    }

    @When("I consume the service and I send the information to update the user")
    public void iConsumeTheServiceAndISendTheInformationToUpdateTheUser() {
        user.attemptsTo(PutUserTask.on());
    }

    @Then("I can validate the service response code")
    public void iCanValidateTheServiceResponseCode() {
        user.should(
                seeThat(
                        "The response code was: ",
                        ServerResponse.was(),
                        equalTo(Integer.parseInt(data.get("status")))
                )
        );
    }


}
