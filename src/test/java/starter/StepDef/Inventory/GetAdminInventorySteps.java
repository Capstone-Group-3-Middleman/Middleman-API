package starter.StepDef.Inventory;

import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.Middleman.InventoriesAPI;

public class GetAdminInventorySteps {

    @Steps
    InventoriesAPI inventoriesAPI;

    @When("Send get request inventory admin")
    public void sendGetRequestInventoryAdmin() {
        SerenityRest.when()
                .get(InventoriesAPI.POST_ADMIN_INVENTORY);
    }

    @When("Admin update invalid inventory parameter {string}")
    public void adminUpdateInValidInventoryParameter(String path) {
        inventoriesAPI.getAdminInventory(path);
    }

    @When("Admin update invalid inventory id {string}")
    public void adminUpdateInValidInventoryId(String id) {
        inventoriesAPI.getAdminInventory(id);
    }

    @And("Send get request inventory admins")
    public void sendGetRequestInventoryAdmins() {
        SerenityRest.when()
                .get(InventoriesAPI.POST_ADMIN_INVENTORY_PATH);
    }

    @When("Admin update invalid inventory parameters {string}")
    public void adminUpdateInvalidInventoryParameters(String id) {
        inventoriesAPI.getInvalidTokenInventory(id);
    }

    @When("Admin update invalids inventory parameters {string}")
    public void adminUpdateInvalidsInventoryParameters(String id) {
        inventoriesAPI.getWithoutTokenInventory(id);
    }
}
