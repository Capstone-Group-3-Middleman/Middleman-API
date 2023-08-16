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

public class DeleteUserProductsSteps {

    @Steps
    UserProductsAPI userProductsAPI;
    @Given("DELETE User Product with {string} token and {string} id {string}")
    public void deleteUserProductWithTokenAndId(String token, String id, String prodID) {
        if (token.equals("valid") && id.equals("valid")) {
            userProductsAPI.deleteUserProducts(prodID);
        } else if (token.equals("valid") && id.equals("invalid")) {
            userProductsAPI.deleteUserProducts(prodID);
        } else if (token.equals("invalid") && id.equals("valid")) {
            userProductsAPI.deleteUserProductsInvalidToken(prodID);
        } else if (token.equals("invalid") && id.equals("invalid")) {
            userProductsAPI.deleteUserProductsInvalidToken(prodID);
        }
    }

    @When("Send DELETE User Product")
    public void sendDELETEUserProduct() {
        SerenityRest.when()
                .delete(UserProductsAPI.DELETE_USER_PRODUCTS);
    }

    @And("Response body should display delete user product error message {string}")
    public void responseBodyShouldDisplayDeleteUserProductErrorMessage(String errorMsg) {
        SerenityRest.and()
                .body(MiddlemanResponses.DELETE_USER_PRODUCT_ERROR_MESSAGE, equalTo(errorMsg));
    }

    @And("Validate delete user product with JSON Schema {string}")
    public void validateDeleteUserProductWithJSONSchema(String jsonSchName) {
        File jsonSchema = new File(Constants.JSON_SCHEMA_DELETE_USER_PRODUCTS + ""+jsonSchName+"");
        SerenityRest.and()
                .assertThat()
                .body(JsonSchemaValidator.matchesJsonSchema(jsonSchema));
    }
}
