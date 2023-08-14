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

public class PostCreateUserProductsSteps {

    @Steps
    UserProductsAPI userProductsAPI;

    @Given("POST Create new user product with valid token and JSON file {string}")
    public void postCreateNewUserProductWithValidTokenAndJSONFile(String jsonName) {
        File json = new File(Constants.REQ_BODY_CREATE_USER_PRODUCTS + ""+jsonName+"");
        userProductsAPI.postCreateUserProduct(json);
    }

    @When("Send POST Create User Product")
    public void sendPOSTCreateUserProduct() {
        SerenityRest.when()
                .post(UserProductsAPI.POST_CREATE_USER_PRODUCTS);
    }

    @And("Response body should display create user product message {string}")
    public void responseBodyShouldDisplayCreateUserProductMessage(String message) {
        SerenityRest.and()
                .body(MiddlemanResponses.CREATE_USER_PRODUCT_MESSAGE, equalTo(message));
    }

    @And("Validate create user product with JSON Schema {string}")
    public void validateCreateUserProductWithJSONSchema(String jsonSchName) {
        File jsonSchema = new File(Constants.JSON_SCHEMA_CREATE_USER_PRODUCTS + ""+jsonSchName+"");
        SerenityRest.and()
                .assertThat()
                .body(JsonSchemaValidator.matchesJsonSchema(jsonSchema));
    }

    @Given("POST Create new user product with invalid token and JSON file {string}")
    public void postCreateNewUserProductWithInvalidTokenAndJSONFile(String jsonName) {
        File json = new File(Constants.REQ_BODY_CREATE_USER_PRODUCTS + ""+jsonName+"");
        userProductsAPI.postCreateUserProductInvalidToken(json);
    }

    @And("Response body should display create user product error message {string}")
    public void responseBodyShouldDisplayCreateUserProductErrorMessage(String errorMsg) {
        SerenityRest.and()
                .body(MiddlemanResponses.CREATE_USER_PRODUCT_ERROR_MESSAGE, equalTo(errorMsg));
    }

    @Given("POST Create new user product with valid token and request body product_image is empty")
    public void postCreateNewUserProductWithValidTokenAndRequestBodyProduct_imageIsEmpty() {
        File json = new File(Constants.REQ_BODY_CREATE_USER_PRODUCTS + "EmptyImageCreateProd.json");
        userProductsAPI.postCreateUserProductEmptyImage(json);
    }
}
