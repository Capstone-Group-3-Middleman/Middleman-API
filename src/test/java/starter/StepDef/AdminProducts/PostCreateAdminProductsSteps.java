package starter.StepDef.AdminProducts;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.Middleman.AdminProductsAPI;
import starter.Middleman.MiddlemanResponses;
import starter.Utils.Constants;

import java.io.File;

import static org.hamcrest.CoreMatchers.equalTo;

public class PostCreateAdminProductsSteps {

    @Steps
    AdminProductsAPI adminProductsAPI;
    @Given("POST Create new admin product with valid token and JSON file {string}")
    public void postCreateNewAdminProductWithValidTokenAndJSONFile(String jsonName) {
        File json = new File(Constants.REQ_BODY_CREATE_ADMIN_PRODUCTS + ""+jsonName+"");
        adminProductsAPI.postCreateAdminProduct(json);
    }

    @When("Send POST Create admin Product")
    public void sendPOSTCreateAdminProduct() {
        SerenityRest.when()
                .post(AdminProductsAPI.CREATE_ADMIN_PRODUCTS);
    }

    @And("Response body should display create admin product message {string}")
    public void responseBodyShouldDisplayCreateAdminProductMessage(String message) {
        SerenityRest.and()
                .body(MiddlemanResponses.CREATE_ADMIN_PRODUCTS_MESSAGE, equalTo(message));
    }

    @And("Validate create admin product with JSON Schema {string}")
    public void validateCreateAdminProductWithJSONSchema(String jsonSchName) {
        File jsonSchema = new File(Constants.JSON_SCHEMA_CREATE_ADMIN_PRODUCTS + ""+jsonSchName+"");
        SerenityRest.and()
                .assertThat()
                .body(JsonSchemaValidator.matchesJsonSchema(jsonSchema));
    }
}
