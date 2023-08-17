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

public class PutUpdateAdminProductsSteps {

    @Steps
    AdminProductsAPI adminProductsAPI;

    @Given("PUT Update Admin Product with valid token and valid id {string}")
    public void putUpdateAdminProductWithValidTokenAndValidId(String id) {
        File json = new File(Constants.REQ_BODY_UPDATE_ADMIN_PRODUCTS + "UpdateAdminProduct.json");
        adminProductsAPI.putUpdateAdminProduct(id, json);
    }

    @When("Send PUT Update Admin Product")
    public void sendPUTUpdateAdminProduct() {
        SerenityRest.when()
                .put(AdminProductsAPI.UPDATE_ADMIN_PRODUCTS);
    }

    @And("Response body should display update admin product success message {string}")
    public void responseBodyShouldDisplayUpdateAdminProductSuccessMessage(String message) {
        SerenityRest.and()
                .body(MiddlemanResponses.UPDATE_ADMIN_PRODUCTS_MESSAGE, equalTo(message));
    }

    @And("Validate update admin product with JSON Schema {string}")
    public void validateUpdateAdminProductWithJSONSchema(String jsonSchName) {
        File jsonSchema = new File(Constants.JSON_SCHEMA_UPDATE_ADMIN_PRODUCTS + ""+jsonSchName+"");
        SerenityRest.and()
                .assertThat()
                .body(JsonSchemaValidator.matchesJsonSchema(jsonSchema));
    }
}
