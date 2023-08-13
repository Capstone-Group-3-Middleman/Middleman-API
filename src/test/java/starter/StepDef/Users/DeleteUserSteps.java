package starter.StepDef.Users;

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

public class DeleteUserSteps {

    @Steps
    MiddlemanAPI middlemanAPI;

    @Given("DELETE User with valid token")
    public void deleteUserWithValidToken() {
        middlemanAPI.deleteUser();
    }

    @When("Send DELETE User")
    public void sendDELETEUser() {
        SerenityRest.when()
                .delete(MiddlemanAPI.DELETE_USER);
    }

    @And("Response body should display delete user message {string}")
    public void responseBodyShouldDisplayDeleteUserMessage(String message) {
        SerenityRest.and()
                .body(MiddlemanResponses.DELETE_USER_MESSAGE, equalTo(message));
    }

    @And("Validate delete user with JSON Schema {string}")
    public void validateDeleteUserWithJSONSchema(String jsonSchName) {
        File jsonSchema = new File(Constants.JSON_SCHEMA_DELETE + ""+jsonSchName+"");
        SerenityRest.and()
                .body(JsonSchemaValidator.matchesJsonSchema(jsonSchema));
    }

    @And("Response body should display delete user error message {string}")
    public void responseBodyShouldDisplayDeleteUserErrorMessage(String errorMsg) {
        SerenityRest.and()
                .body(MiddlemanResponses.DELETE_USER_ERROR_MESSAGE, equalTo(errorMsg));
    }

    @Given("DELETE User with invalid token")
    public void deleteUserWithInvalidToken() {
        middlemanAPI.deleteUserInvalidToken();
    }
}
