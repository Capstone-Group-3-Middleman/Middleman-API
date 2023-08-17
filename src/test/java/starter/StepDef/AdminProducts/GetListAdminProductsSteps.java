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

public class GetListAdminProductsSteps {

    @Steps
    AdminProductsAPI adminProductsAPI;

    @Given("GET List Admin Product with valid path and valid token")
    public void getListAdminProductWithValidPathAndValidToken() {
        String param = "products";
        adminProductsAPI.getListAdminProduct(param);
    }

    @When("Send GET List Admin Product")
    public void sendGETListAdminProduct() {
        SerenityRest.when()
                .get(AdminProductsAPI.LIST_ADMIN_PRODUCTS);
    }

    @And("Response body should display admin product message {string}")
    public void responseBodyShouldDisplayAdminProductMessage(String message) {
        SerenityRest.and()
                .body(MiddlemanResponses.LIST_ADMIN_PRODUCTS_MESSAGE, equalTo(message));
    }

    @And("Validate admin product with JSON Schema {string}")
    public void validateAdminProductWithJSONSchema(String jsonSchName) {
        File jsonSchema = new File(Constants.JSON_SCHEMA_LIST_ADMIN_PRODUCTS + ""+jsonSchName+"");
        SerenityRest.and()
                .assertThat()
                .body(JsonSchemaValidator.matchesJsonSchema(jsonSchema));
    }
}
