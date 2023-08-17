package starter.StepDef.Carts;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.Middleman.CartsAPI;
import starter.Utils.Constants;

import java.io.File;

public class PutCartsSteps {

    @Steps
    CartsAPI cartsAPI;

    @Given("Put Cart with {string} token")
    public void putCartWithToken(String token) {
        if (token.equals("valid")) {
            cartsAPI.postCartWithTokenUser();
        } else if (token.equals("invalid")) {
            cartsAPI.postCartWithTokenInvalid();
        } else if (token.equals("admin")) {
            cartsAPI.postCartWithTokenAdmin();
        } else if (token.equals("without")) {
            cartsAPI.postCartWithoutToken();
        }
    }

    @When("Send put cart")
    public void sendPutCart() {
        SerenityRest.when()
                .put(CartsAPI.POST_CARTS);
    }

    @When("Send put carts")
    public void sendPutCarts() {
        SerenityRest.when()
                .put(CartsAPI.POST_CARTS_INVALID);
    }
//
//    @When("Send put cart with token {string} and path {string}")
//    public void sendPutCartWithPath(String token, String path) {
////        if (id.equals("invalid")) {
////            SerenityRest.when()
////                    .put(CartsAPI.POST_CARTS_PATH);
////            String param = "@";
////            cartsAPI.putInvalidPath(param);
//        if (token.equals("valid") && path.equals("invalid")) {
//            String param = "cart/@";
//            cartsAPI.putInvalidPath(param);
//        }
//    }

    @Given("Put Cart with {string} token and path {string}")
    public void putCartWithTokenAndPath(String id, String jsonName) {
            File json = new File(Constants.REQ_BODY_INOUTBOUNDS + "" + jsonName + "");
            cartsAPI.putInvalidPath(json, id);
        }

    @When("Send put cart string")
    public void sendPutCartString() {
        SerenityRest.when()
                .put(CartsAPI.POST_CARTS_PATH);
    }

    @When("Update invalid product id {string} carts and send with JSON file {string}")
    public void updateInvalidProductIdCartsAndSendWithJSONFile(String id, String jsonName) {
        File json = new File(Constants.REQ_BODY_CARTS + "" + jsonName + "");
        cartsAPI.putInvalidPath(json, id);
    }
}

