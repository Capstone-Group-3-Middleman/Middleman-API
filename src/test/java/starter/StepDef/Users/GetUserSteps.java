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

public class GetUserSteps {

    @Steps
    UsersAPI usersAPI;

    @Given("GET user with {string} path and {string} token")
    public void getUserWithPathAndToken(String path, String token) {
        if(path.equals("valid") && token.equals("valid")){
            String param = "users";
            usersAPI.getUser(param);
        } else if (path.equals("valid") && token.equals("invalid")) {
            String param = "users";
            usersAPI.getUserInvalidToken(param);
        } else if (path.equals("invalid") && token.equals("valid")) {
            String param = "xyz";
            usersAPI.getUser(param);
        } else if (path.equals("invalid") && token.equals("invalid")) {
            String param = "xyz";
            usersAPI.getUserInvalidToken(param);
        }
    }

    @When("Send GET user")
    public void sendGETUser() {
        SerenityRest.when()
                .get(UsersAPI.GET_USER);
    }

    @And("Response body should display user message {string}")
    public void responseBodyShouldDisplayUserMessage(String message) {
        SerenityRest.and()
                .body(MiddlemanResponses.USER_MESSAGE, equalTo(message));
    }

    @And("Validate user with JSON Schema {string}")
    public void validateListUserWithJSONSchema(String jsonSchName) {
        File jsonSchema = new File(Constants.JSON_SCHEMA_USER + ""+jsonSchName+"");
        SerenityRest.and()
                .assertThat()
                .body(JsonSchemaValidator.matchesJsonSchema(jsonSchema));
    }

    @And("Response body should display user error message {string}")
    public void responseBodyShouldDisplayListUserErrorMessage(String errorMsg) {
        SerenityRest.and()
                .body(MiddlemanResponses.USER_ERROR_MESSAGE, equalTo(errorMsg));
    }
}
