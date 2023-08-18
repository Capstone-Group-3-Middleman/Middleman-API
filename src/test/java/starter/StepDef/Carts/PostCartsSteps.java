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

public class PostCartsSteps {

    @Steps
    CartsAPI cartsAPI;

    @Given("Post Cart with {string} token")
    public void postCartWithTokenAndPath(String token) {
        if (token.equals("valid")) {
            cartsAPI.postCartWithTokenUser();
        } else if (token.equals("invalid")) {
            cartsAPI.postCartWithTokenInvalid();
        } else if (token.equals("admin")){
            cartsAPI.postCartWithTokenAdmin();
        } else if (token.equals("without")){
            cartsAPI.postCartWithoutToken();
        }
    }

    @When("Send post List Cart")
    public void sendPostListCart() {
        SerenityRest.when()
                .post(CartsAPI.POST_CARTS);
    }

    @And("Response body should display message {string}")
    public void responseBodyShouldDisplayMessage(String msg) {
        SerenityRest.and()
                .body(MiddlemanResponses.POST_CART_MESSAGE, equalTo(msg));
    }

    @When("User post cart with JSON file {string}")
    public void userPostCartWithJSONFile(String jsonName) {
        File json = new File(Constants.REQ_BODY_CARTS + "" + jsonName + "");
        cartsAPI.postCart(json);
    }

    @And("Validate cart with JSON Schema {string}")
    public void validateCartWithJSONSchema(String jsonSchName) {
        File jsonSchema = new File(Constants.JSON_SCHEMA_POST_CART + ""+jsonSchName+"");
        SerenityRest.and()
                .assertThat()
                .body(JsonSchemaValidator.matchesJsonSchema(jsonSchema));
    }

    @When("Admin post cart with JSON file {string}")
    public void adminPostCartWithJSONFile(String jsonName) {
        File json = new File(Constants.REQ_BODY_CARTS + "" + jsonName + "");
        cartsAPI.postCartAdmin(json);
    }

    @Given("Post Cart with {string} token and {string} path")
    public void postCartWithTokenAndPath(String token, String path) {
        if (token.equals("admin") && path.equals("invalid")) {
            String param = "cartsss";
            cartsAPI.postCartAdmisn(param);
        }
    }

    @And("Send post List Carts")
    public void sendPostListCarts() {
        SerenityRest.when()
                .post(CartsAPI.POST_CARTS_INVALID);
    }
}
