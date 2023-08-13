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

public class PutUpdateUserSteps {

    @Steps
    MiddlemanAPI middlemanAPI;
    @Given("PUT Update User with {string} token and {string} data")
    public void putUpdateUserWithTokenAndData(String token, String data) {
        if(token.equals("valid") && data.equals("valid")){
            File json = new File(Constants.REQ_BODY_UPDATE + "UpdateUser.json");
            middlemanAPI.putUpdateUser(json);
        } else if (token.equals("invalid") && data.equals("valid")) {
            File json = new File(Constants.REQ_BODY_UPDATE + "UpdateUser.json");
            middlemanAPI.putUpdateUserInvalidToken(json);
        }
    }

    @When("Send PUT Update User")
    public void sendPUTUpdateUser() {
        SerenityRest.when()
                .put(MiddlemanAPI.PUT_UPDATE_USER);
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
}
