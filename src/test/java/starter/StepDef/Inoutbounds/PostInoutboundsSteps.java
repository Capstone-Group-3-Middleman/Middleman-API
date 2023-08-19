package starter.StepDef.Inoutbounds;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.Middleman.InoutboundsAPI;
import starter.Middleman.MiddlemanResponses;
import starter.Utils.Constants;

import java.io.File;

import static org.hamcrest.CoreMatchers.equalTo;

public class PostInoutboundsSteps {

    @Steps
    InoutboundsAPI inoutbounds;

    @Given("Login inoutbounds with {string} token")
    public void postAuthToken(String token) {
        if(token.equals("user")){
            inoutbounds.getUserInoutbounds();
        } else if (token.equals("admin")){
            inoutbounds.getAdminInoutbounds();
        } else if (token.equals("invalid")) {
            inoutbounds.getInoutboundsInvalidToken();
        } else if (token.equals("without")) {
            inoutbounds.getUserInoutboundsWithoutToken();
        }
    }

    @When("{string} post inoutbounds with JSON file {string}")
    public void postInoutboundsWithJSONFile(String role, String jsonName) {
        if (role.equals("User")) {
            File json = new File(Constants.REQ_BODY_INOUTBOUNDS + "" + jsonName + "");
            inoutbounds.postCreateInounboundsUser(json);
        } else if (role.equals("Admin")){
            File json = new File(Constants.REQ_BODY_INOUTBOUNDS + "" + jsonName + "");
            inoutbounds.postCreateInounboundsAdmin(json);
        }
    }


    @When("Send post request inoutbounds")
    public void sendPostRequestInoutbounds() {
        SerenityRest.when()
                .post(InoutboundsAPI.POST_INOUTBOUNDS);
    }

    @And("Response body should display inoutbounds error message {string}")
    public void responseBodyShouldDisplayInoutboundsErrorMessage(String message) {
        SerenityRest.and()
                .body(MiddlemanResponses.INOUBOUNDS_ERROR_MESSAGE, equalTo(message));
    }

    @And("Validate response inoutbounds with JSON Schema {string}")
    public void validateResponseInoutboundsWithJSONSchema(String jsonSchName) {
        File jsonSchema = new File(Constants.JSON_SCHEMA_INOUTBOUNDS + ""+jsonSchName+"");
        SerenityRest.and()
                .assertThat()
                .body(JsonSchemaValidator.matchesJsonSchema(jsonSchema));
    }

    @And("Response body should display inoutbounds message {string}")
    public void responseBodyShouldDisplayInoutboundsMessage(String message) {
        SerenityRest.and()
                .body(MiddlemanResponses.INOUBOUNDS_SUCCESS_MESSAGE, equalTo(message));
    }
}
