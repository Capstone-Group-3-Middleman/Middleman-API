package starter.StepDef.Authentications;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.Middleman.MiddlemanAPI;
import starter.Middleman.MiddlemanResponses;
import starter.Utils.Constants;

import java.io.File;

import static org.hamcrest.CoreMatchers.equalTo;

public class PostLoginUserSteps {

    @Steps
    MiddlemanAPI middlemanAPI;
    @Given("POST Login with JSON file {string}")
    public void postLoginWithJSONFile(String jsonName) {
        File json = new File(Constants.REQ_BODY_LOGIN + ""+jsonName+"");
        middlemanAPI.postLoginUser(json);
    }

    @When("Send POST Login")
    public void sendPOSTLogin() {
        SerenityRest.when()
                .post(MiddlemanAPI.POST_LOGIN_USER);
    }

    @And("Response body should display login message {string}")
    public void responseBodyShouldDisplayLoginMessage(String message) {
        SerenityRest.and()
                .body(MiddlemanResponses.LOGIN_SUCCESS_MESSAGE, equalTo(message));
    }

    @And("Validate login with JSON Schema {string}")
    public void validateLoginWithJSONSchema(String jsonSchName) {
        File jsonSchema = new File(Constants.JSON_SCHEMA_LOGIN + ""+jsonSchName+"");
        SerenityRest.and()
                .assertThat()
                .body(JsonSchemaValidator.matchesJsonSchema(jsonSchema));
    }

    @And("Response body should display login error message {string}")
    public void responseBodyShouldDisplayLoginErrorMessage(String errorMsg) {
        SerenityRest.and()
                .body(MiddlemanResponses.LOGIN_ERROR_MESSAGE, equalTo(errorMsg));
    }
}
