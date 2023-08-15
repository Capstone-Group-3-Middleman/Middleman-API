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

public class GetListCartsSteps {

    @Steps
    CartsAPI cartsAPI;

    @Given("GET List Cart with {string} token and {string} path")
    public void getListCartWithTokenAndPath(String token, String path) {
        if (token.equals("valid") && path.equals("valid")) {
            String param = "carts";
            cartsAPI.getListCart(param);
        } else if (token.equals("invalid") && path.equals("valid")) {
            String param = "carts";
            cartsAPI.getListCartInvalidToken(param);
        } else if (token.equals("valid") && path.equals("invalid")) {
            String param = "cartsxyz";
            cartsAPI.getListCart(param);
        } else if (token.equals("invalid") && path.equals("invalid")) {
            String param = "cartsxyz";
            cartsAPI.getListCartInvalidToken(param);
        }
    }

    @When("Send GET List Cart")
    public void sendGETListCart() {
        SerenityRest.when()
                .get(CartsAPI.GET_LIST_CARTS);
    }


    @And("Response body should display list cart error message {string}")
    public void responseBodyShouldDisplayListCartErrorMessage(String errorMsg) {
        SerenityRest.and()
                .body(MiddlemanResponses.LIST_CART_ERROR_MESSAGE, equalTo(errorMsg));
    }

    @And("Validate list cart with JSON Schema {string}")
    public void validateListCartWithJSONSchema(String jsonSchName) {
        File jsonSchema = new File(Constants.JSON_SCHEMA_LIST_CART + ""+jsonSchName+"");
        SerenityRest.and()
                .assertThat()
                .body(JsonSchemaValidator.matchesJsonSchema(jsonSchema));
    }
}
