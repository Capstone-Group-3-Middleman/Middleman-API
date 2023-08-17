package starter.StepDef.Carts;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.Middleman.CartsAPI;
import starter.Middleman.MiddlemanResponses;
import starter.Utils.Constants;

import java.io.File;

import static org.hamcrest.CoreMatchers.equalTo;

public class DeleteCartsSteps {

    @Steps
    CartsAPI cartsAPI;
    @Given("DELETE Cart with {string} token and {string} id product")
    public void deleteCartWithTokenAndIdProduct(String token, String id) {
        if (token.equals("valid") && id.equals("valid")) {
            String param = "5";
            cartsAPI.deleteCart(param);
        } else if (token.equals("valid") && id.equals("invalid")) {
            String param = "xyz";
            cartsAPI.deleteCart(param);
        } else if (token.equals("invalid") && id.equals("valid")) {
            String param = "5";
            cartsAPI.deleteCartInvalidToken(param);
        } else if (token.equals("invalid") && id.equals("invalid")) {
            String param = "xyz";
            cartsAPI.deleteCartInvalidToken(param);
        }
    }

    @When("Send DELETE Cart")
    public void sendDELETECart() {
        SerenityRest.when()
                .delete(CartsAPI.DELETE_CARTS);
    }

    @And("Response body should display delete cart error message {string}")
    public void responseBodyShouldDisplayDeleteCartErrorMessage(String errorMsg) {
        SerenityRest.and()
                .body(MiddlemanResponses.DELETE_CART_ERROR_MESSAGE, equalTo(errorMsg));
    }

    @And("Validate delete cart with JSON Schema {string}")
    public void validateDeleteCartWithJSONSchema(String jsonSchName) {
        File jsonSchema = new File(Constants.JSON_SCHEMA_DELETE_CART + ""+jsonSchName+"");
        SerenityRest.and()
                .assertThat()
                .body(JsonSchemaValidator.matchesJsonSchema(jsonSchema));
    }
}
