package starter.StepDef.Authentications;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.Middleman.AuthenticationsAPI;
import starter.Middleman.MiddlemanResponses;
import starter.Utils.Constants;

import java.io.File;

import static org.hamcrest.CoreMatchers.equalTo;

public class PostRegisterUserSteps {

    @Steps
    AuthenticationsAPI authenticationsAPI;

    @Given("POST Register user with JSON file {string}")
    public void postRegisterUserWithJSONFile(String jsonName) {
        File json = new File(Constants.REQ_BODY_REGISTER + ""+jsonName+"");
        authenticationsAPI.postRegisterUser(json);
    }

    @When("Send POST Register user")
    public void sendPOSTRegisterUser() {
        SerenityRest.when()
                .post(AuthenticationsAPI.POST_REGISTER_USER);
    }

    @And("Response body should display register message {string}")
    public void responseBodyShouldDisplayRegisterMessage(String message) {
        SerenityRest.and()
                .body(MiddlemanResponses.REG_SUCCESS_MESSAGE, equalTo(message));
    }

    @And("Validate register user with JSON Schema {string}")
    public void validateRegisterUserWithJSONSchema(String jsonSchName) {
        File jsonSchema = new File(Constants.JSON_SCHEMA_REGISTER + ""+jsonSchName+"");
        SerenityRest.and()
                .assertThat()
                .body(JsonSchemaValidator.matchesJsonSchema(jsonSchema));
    }

    @And("Response body should display register error message {string}")
    public void responseBodyShouldDisplayRegisterErrorMessage(String errorMsg) {
        SerenityRest.and()
                .body(MiddlemanResponses.REG_ERROR_MESSAGE, equalTo(errorMsg));
    }

    @When("Send POST Register user with invalid path")
    public void sendPOSTRegisterUserWithInvalidPath() {
        SerenityRest.when()
                .post(AuthenticationsAPI.POST_REGISTER_USER_INVALID_PATH);
    }
}
