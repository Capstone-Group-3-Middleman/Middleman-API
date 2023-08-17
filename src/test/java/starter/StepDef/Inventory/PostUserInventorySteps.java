package starter.StepDef.Inventory;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.Middleman.InventoriesAPI;
import starter.Middleman.MiddlemanResponses;
import starter.Utils.Constants;

import java.io.File;

import static org.hamcrest.CoreMatchers.equalTo;

public class PostUserInventorySteps {

    @Steps
    InventoriesAPI inventoriesAPI;

    @Given("Login inventory with {string} token")
    public void loginInventoryWithToken(String token) {
        if(token.equals("without")){
            inventoriesAPI.getUserInventoryWithoutToken();
        } else if (token.equals("invalid")){
            inventoriesAPI.getUserInventoryInvalidToken();
        } else if (token.equals("user")) {
            inventoriesAPI.getUserInventoryValidToken();
        } else if (token.equals("admin")) {
            inventoriesAPI.getAdminInventoryValidToken();
        }
    }

    @And("Send post request inventory")
    public void sendPostRequestInventory() {
        SerenityRest.when()
                .post(InventoriesAPI.POST_USERS_INVENTORY);
    }

    @When("Users Post inventory with JSON file {string}")
    public void usersPostInventoryWithJSONFile(String jsonName) {
        File json = new File(Constants.REQ_BODY_INVENTORY + "" + jsonName + "");
        inventoriesAPI.setUserInventoryValidToken(json);
    }

    @And("Send post request inventorys")
    public void sendPostRequestInventorys() {
        SerenityRest.when()
                .post(InventoriesAPI.POST_USERS_INVENTORY);
    }

    @And("Validate response inventory with JSON Schema {string}")
    public void validateResponseInventoryWithJSONSchema(String jsonSchName) {
        File jsonSchema = new File(Constants.JSON_SCHEMA_INVENTORY + ""+jsonSchName+"");
        SerenityRest.and()
                .assertThat()
                .body(JsonSchemaValidator.matchesJsonSchema(jsonSchema));
    }


    @And("Validate get response inventory with JSON Schema {string}")
    public void validateGetResponseInventoryWithJSONSchema(String jsonSchName) {
        File jsonSchema = new File(Constants.JSON_SCHEMA_INVENTORY + ""+jsonSchName+"");
        SerenityRest.and()
                .assertThat()
                .body(JsonSchemaValidator.matchesJsonSchema(jsonSchema));
    }

    @And("Response body should display inventory success message {string}")
    public void responseBodyShouldDisplayInventorySuccessMessage(String message) {
        SerenityRest.and()
                .body(MiddlemanResponses.INVENTORY_SUCCESS_MESSAGE, equalTo(message));
    }
}
