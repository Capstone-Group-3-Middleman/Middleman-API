package starter.StepDef.Inventory;

import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.Middleman.InventoriesAPI;
import starter.Middleman.MiddlemanResponses;
import starter.Utils.Constants;

import java.io.File;

import static org.hamcrest.CoreMatchers.equalTo;

public class PostAdminInventorySteps {

    @Steps
    InventoriesAPI inventoriesAPI;

    @And("Send post request inventory admin")
    public void sendPostRequestInventoryAdmin() {
        SerenityRest.when()
                .post(InventoriesAPI.POST_ADMIN_INVENTORY);
    }

    @When("Admin Post inventory with JSON file {string}")
    public void adminPostInventoryWithJSONFile(String jsonName) {
        File json = new File(Constants.REQ_BODY_INVENTORY + "" + jsonName + "");
        inventoriesAPI.setAdminInventoryValidToken(json);
    }

    @And("Response body should display inventory error message {string}")
    public void responseBodyShouldDisplayInventoryErrorMessage(String message) {
        SerenityRest.and()
                .body(MiddlemanResponses.INVENTORY_ERROR_MESSAGE, equalTo(message));
    }

    @And("Send post request inventory admins")
    public void sendPostRequestInventoryAdmins() {
        SerenityRest.when()
                .post(InventoriesAPI.POST_USERS_INVENTORYS);
    }

    @When("Send get request inventory user")
    public void sendGetRequestInventoryAUser() {
        SerenityRest.when()
                .get(InventoriesAPI.POST_USERS_INVENTORY);
    }
}
