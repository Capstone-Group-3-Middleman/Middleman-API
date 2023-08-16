package starter.StepDef.Inoutbounds;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.Middleman.InoutboundsAPI;
import starter.Utils.Constants;

import java.io.File;

public class GetInoutboundsSteps {

    @Steps
    InoutboundsAPI inoutbounds;

    @And("Send get request inoutbounds")
    public void sendGetRequestInoutbounds() {
        SerenityRest.when()
                .get(InoutboundsAPI.GET_LIST_INOUTBOUNDS);
    }

    @Given("Admin get login inoutbounds with {string} path and {string} token")
    public void adminGetLoginInoutboundsWithPathAndToken(String path, String token) {
        if (token.equals("admin") && (path.equals("invalid"))){
            String param = "xs";
            inoutbounds.getCartInoutboundsAdminWithPath(param);
        }
    }

    @And("Validate get response inoutbounds with JSON Schema {string}")
    public void validateGetResponseInoutboundsWithJSONSchema(String jsonSchName) {
        File jsonSchema = new File(Constants.JSON_SCHEMA_INOUTBOUNDS + ""+jsonSchName+"");
        SerenityRest.and()
                .assertThat()
                .body(JsonSchemaValidator.matchesJsonSchema(jsonSchema));
    }

    @When("Send get request inoutbounds invalid path")
    public void sendGetRequestInoutboundsInvalidPath() {
        SerenityRest.when()
                .get(InoutboundsAPI.GET_INVALID_INOUTBOUNDS);
    }
}
