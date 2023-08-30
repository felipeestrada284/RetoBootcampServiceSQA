package com.fakestoreapi.stepDefinitions;

import com.fakestoreapi.questions.BuildDataUser;
import com.fakestoreapi.questions.DeleteDataResponse;
import com.fakestoreapi.tasks.DeleteUserTask;
import com.fakestoreapi.utils.Data;
import io.cucumber.java.Before;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import net.thucydides.core.util.EnvironmentVariables;

import java.util.Map;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.*;

public class DeleteUserStepDef {
    Map<String, String> data = Data.extractTo().get(0);

    private EnvironmentVariables environmentVariables;
    Actor user = Actor.named("user");

    @Before
    public void setUpBaseUrl(){
        String theRestApiBaseUrl = environmentVariables.optionalProperty("restapi.baseurl")
                .orElse("https://fakestoreapi.com");

        user.whoCan(CallAnApi.at(theRestApiBaseUrl));

    }

    @When("I consume the service and send the user ID")
    public void iConsumeTheServiceAndSendTheUserID() {
        user.attemptsTo(DeleteUserTask.on());
    }

    @Then("I can validate the data in the service response")
    public void iCanValidateTheDataInTheServiceResponse() {
        //String x = DeleteDataResponse.was().answeredBy(user).getPhone();

        user.should(
                seeThat(
                        "The response is not null:",
                        res -> SerenityRest.lastResponse(),
                        notNullValue()
                ),
                seeThat(
                        "The phone response was",
                        res -> DeleteDataResponse.was().answeredBy(user).getPhone(),
                        equalTo(data.get("phone"))
                )
        );
    }
}
