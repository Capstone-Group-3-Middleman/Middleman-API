package starter.StepDef.UserProducts;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.Middleman.MiddlemanResponses;
import starter.Middleman.UserProductsAPI;
import starter.Utils.Constants;

import java.io.File;

import static org.hamcrest.CoreMatchers.equalTo;

public class GetSearchProductsSteps {

    @Steps
    UserProductsAPI userProductsAPI;

    @Given("GET Search product with {string} token and {string} parameter product name {string}")
    public void getSearchProductWithTokenAndParameterProductName(String token, String param, String prodName) {
        if (token.equals("valid") && param.equals("valid")) {
            userProductsAPI.getSearchUserProducts(prodName);
        } else if (token.equals("invalid") && param.equals("valid")) {
            userProductsAPI.getSearchUserProductsInvalidToken(prodName);
        } else if (token.equals("valid") && param.equals("invalid")) {
            userProductsAPI.getSearchUserProducts(prodName);
        } else if (token.equals("invalid") && param.equals("invalid")) {
            userProductsAPI.getSearchUserProductsInvalidToken(prodName);
        }
    }

    @When("Send GET Search product")
    public void sendGETSearchProduct() {
        SerenityRest.when()
                .get(UserProductsAPI.GET_SEARCH_USER_PRODUCTS);
    }

    @And("Response body should display search user product name {string}")
    public void responseBodyShouldDisplaySearchUserProductName(String prodName) {
        SerenityRest.and()
                .body(MiddlemanResponses.SEARCH_USER_PRODUCT_NAME, equalTo(prodName));
    }

    @And("Validate search user product with JSON Schema {string}")
    public void validateSearchUserProductWithJSONSchema(String jsonSchName) {
        File jsonSchema = new File(Constants.JSON_SCHEMA_SEARCH_USER_PRODUCTS + ""+jsonSchName+"");
        SerenityRest.and()
                .assertThat()
                .body(JsonSchemaValidator.matchesJsonSchema(jsonSchema));
    }

    @And("Response body should display search user product error message {string}")
    public void responseBodyShouldDisplaySearchUserProductErrorMessage(String errorMsg) {
        SerenityRest.and()
                .body(MiddlemanResponses.SEARCH_USER_PRODUCT_ERROR_MESSAGE, equalTo(errorMsg));
    }
}
