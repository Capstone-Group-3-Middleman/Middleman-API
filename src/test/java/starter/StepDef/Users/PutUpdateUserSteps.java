package starter.StepDef.Users;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.Middleman.MiddlemanResponses;
import starter.Middleman.UsersAPI;
import starter.Utils.Constants;

import java.io.File;

import static org.hamcrest.CoreMatchers.equalTo;

public class PutUpdateUserSteps {

    @Steps
    UsersAPI usersAPI;
    @Given("PUT Update User with {string} token and {string} data")
    public void putUpdateUserWithTokenAndData(String token, String data) {
        if(token.equals("valid") && data.equals("valid")){
            File json = new File(Constants.REQ_BODY_UPDATE + "UpdateUser.json");
            usersAPI.putUpdateUser(json);
        } else if (token.equals("invalid") && data.equals("valid")) {
            File json = new File(Constants.REQ_BODY_UPDATE + "UpdateUser.json");
           usersAPI.putUpdateUserInvalidToken(json);
        }
    }

    @When("Send PUT Update User")
    public void sendPUTUpdateUser() {
        SerenityRest.when()
                .put(UsersAPI.PUT_UPDATE_USER);
    }

    @And("Response body should display update user message {string}")
    public void responseBodyShouldDisplayUpdateUserMessage(String message) {
        SerenityRest.and()
                .body(MiddlemanResponses.UPDATE_USER_MESSAGE, equalTo(message));
    }

    @And("Validate update user with JSON Schema {string}")
    public void validateUpdateUserWithJSONSchema(String jsonSchName) {
        File jsonSchema = new File(Constants.JSON_SCHEMA_UPDATE_USER + ""+jsonSchName+"");
        SerenityRest.and()
                .assertThat()
                .body(JsonSchemaValidator.matchesJsonSchema(jsonSchema));
    }

    @Given("PUT Update User with valid token and JSON file {string}")
    public void putUpdateUserWithValidTokenAndJSONFile(String jsonName) {
        File json = new File(Constants.REQ_BODY_UPDATE + ""+jsonName+"");
        usersAPI.putUpdateUser(json);
    }

    @And("Response body should display update user error message {string}")
    public void responseBodyShouldDisplayUpdateUserErrorMessage(String errorMsg) {
        SerenityRest.and()
                .body(MiddlemanResponses.UPDATE_USER_ERROR_MESSAGE, equalTo(errorMsg));
    }
}
