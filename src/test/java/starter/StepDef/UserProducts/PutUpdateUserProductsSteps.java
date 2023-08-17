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

public class PutUpdateUserProductsSteps {

    @Steps
    UserProductsAPI userProductsAPI;

    @Given("PUT Update User Product with valid token and valid id {string}")
    public void putUpdateUserProductWithValidTokenAndValidId(String id) {
        File json = new File(Constants.REQ_BODY_UPDATE_USER_PRODUCTS + "UpdateUserProduct.json");
        userProductsAPI.putUpdateUserProduct(id,json);
    }

    @When("Send PUT Update User Product")
    public void sendPUTUpdateUserProduct() {
        SerenityRest.when()
                .put(UserProductsAPI.PUT_UPDATE_USER_PRODUCTS);
    }

    @And("Response body should display update user product success message {string}")
    public void responseBodyShouldDisplayUpdateUserProductSuccessMessage(String message) {
        SerenityRest.and()
                .body(MiddlemanResponses.UPDATE_USER_PRODUCT_MESSAGE, equalTo(message));
    }

    @And("Validate update user product with JSON Schema {string}")
    public void validateUpdateUserProductWithJSONSchema(String jsonSchName) {
        File jsonSchema = new File(Constants.JSON_SCHEMA_UPDATE_USER_PRODUCTS + ""+jsonSchName+"");
        SerenityRest.and()
                .assertThat()
                .body(JsonSchemaValidator.matchesJsonSchema(jsonSchema));
    }

    @Given("PUT Update User Product with invalid token and valid id {string}")
    public void putUpdateUserProductWithInvalidTokenAndValidId(String id) {
        File json = new File(Constants.REQ_BODY_UPDATE_USER_PRODUCTS + "UpdateUserProduct.json");
        userProductsAPI.putUpdateUserProductInvalidToken(id, json);
    }

    @And("Response body should display update user product error message {string}")
    public void responseBodyShouldDisplayUpdateUserProductErrorMessage(String errorMsg) {
        SerenityRest.and()
                .body(MiddlemanResponses.UPDATE_USER_PRODUCT_ERROR_MESSAGE, equalTo(errorMsg));
    }

    @Given("PUT Update User Product with valid token and invalid id {string}")
    public void putUpdateUserProductWithValidTokenAndInvalidId(String id) {
        File json = new File(Constants.REQ_BODY_UPDATE_USER_PRODUCTS + "UpdateUserProduct.json");
        userProductsAPI.putUpdateUserProduct(id, json);
    }

    @Given("PUT Update User Product with valid token and JSON file {string}")
    public void putUpdateUserProductWithValidTokenAndJSONFile(String jsonName) {
        File json = new File(Constants.REQ_BODY_UPDATE_USER_PRODUCTS + ""+jsonName+"");
        String id = "23";
        userProductsAPI.putUpdateUserProduct(id, json);
    }

    @Given("PUT Update User Product with valid token and JSON {string}")
    public void putUpdateUserProductWithValidTokenAndJSON(String jsonName) {
        File json = new File(Constants.REQ_BODY_UPDATE_USER_PRODUCTS + ""+jsonName+"");
        String id = "23";
        userProductsAPI.putUpdateUserProductEmptyImage(id, json);
    }
}
