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

public class GetSearchAdminProductsSteps {

    @Steps
    AdminProductsAPI adminProductsAPI;

    @Given("GET Search admin product with valid parameter product name {string}")
    public void getSearchAdminProductWithValidTokenAndValidParameterProductName(String prodName) {
        adminProductsAPI.getSearchAdminProduct(prodName);
    }

    @When("Send GET Search admin product")
    public void sendGETSearchAdminProduct() {
        SerenityRest.when()
                .get(AdminProductsAPI.SEARCH_ADMIN_PRODUCTS);
    }

    @And("Response body should display search admin product name {string}")
    public void responseBodyShouldDisplaySearchAdminProductName(String prodName) {
        SerenityRest.and()
                .body(MiddlemanResponses.SEARCH_ADMIN_PRODUCTS_NAME, equalTo(prodName));
    }

    @And("Validate search admin product with JSON Schema {string}")
    public void validateSearchAdminProductWithJSONSchema(String jsonSchName) {
        File jsonSchema = new File(Constants.JSON_SCHEMA_SEARCH_ADMIN_PRODUCTS + ""+jsonSchName+"");
        SerenityRest.and()
                .assertThat()
                .body(JsonSchemaValidator.matchesJsonSchema(jsonSchema));
    }
}
