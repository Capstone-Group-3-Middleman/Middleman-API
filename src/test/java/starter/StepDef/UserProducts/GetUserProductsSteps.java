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

public class GetUserProductsSteps {

    @Steps
    UserProductsAPI userProductsAPI;
    @Given("GET List User Product with {string} path and {string} token")
    public void getListUserProductWithPathAndToken(String path, String token) {
        if (path.equals("valid") && token.equals("valid")) {
            String param = "products";
            userProductsAPI.getListUserProducts(param);
        } else if (path.equals("invalid") && token.equals("valid")) {
            String param = "xyz";
            userProductsAPI.getListUserProducts(param);
        } else if (path.equals("valid") && token.equals("invalid")) {
            String param = "products";
            userProductsAPI.getListUserProductsInvalidToken(param);
        } else if (path.equals("invalid") && token.equals("invalid")) {
            String param = "xyz";
            userProductsAPI.getListUserProductsInvalidToken(param);
        }
    }

    @When("Send GET List User Product")
    public void sendGETListUserProduct() {
        SerenityRest.when()
                .get(UserProductsAPI.GET_LIST_USER_PRODUCTS);
    }

    @And("Response body should display user product message {string}")
    public void responseBodyShouldDisplayUserProductMessage(String message) {
        SerenityRest.and()
                .body(MiddlemanResponses.LIST_USER_PRODUCT_MESSAGE, equalTo(message));
    }

    @And("Validate user product with JSON Schema {string}")
    public void validateUserProductWithJSONSchema(String jsonSchName) {
        File jsonSchema = new File(Constants.JSON_SCHEMA_GET_USER_PRODUCTS + ""+jsonSchName+"");
        SerenityRest.and()
                .assertThat()
                .body(JsonSchemaValidator.matchesJsonSchema(jsonSchema));
    }

    @And("Response body should display user product error message {string}")
    public void responseBodyShouldDisplayUserProductErrorMessage(String errorMsg) {
        SerenityRest.and()
                .body(MiddlemanResponses.LIST_USER_PRODUCT_ERROR_MESSAGE, equalTo(errorMsg));
    }
}
