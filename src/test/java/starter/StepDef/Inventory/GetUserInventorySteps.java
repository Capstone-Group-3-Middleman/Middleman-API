package starter.StepDef.Inventory;

import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.Middleman.InventoriesAPI;

public class GetUserInventorySteps {

    @Steps
    InventoriesAPI inventoriesAPI;

    @And("Send get request inventory users")
    public void sendGetRequestInventoryUsers() {
        SerenityRest.when()
                .get(InventoriesAPI.POST_USERS_INVENTORY_PATH);
    }

    @When("User update invalid inventory id {string}")
    public void userUpdateInvalidInventoryId(String id) {
        inventoriesAPI.getUserInventory(id);
    }

    @When("User update invalid inventory parameter {string}")
    public void userUpdateInvalidInventoryParameter(String id) {
    inventoriesAPI.getUserInventory(id);
    }
}
