package starter.StepDef.AdminProducts;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.Middleman.AdminProductsAPI;

public class DeleteAdminProductsSteps {

    @Steps
    AdminProductsAPI adminProductsAPI;

    @Given("DELETE Admin Product with valid token and valid id {string}")
    public void deleteAdminProductWithValidTokenAndValidId(String id) {
        adminProductsAPI.deleteAdminProduct(id);
    }

    @When("Send DELETE Admin Product")
    public void sendDELETEAdminProduct() {
        SerenityRest.when()
                .delete(AdminProductsAPI.DELETE_ADMIN_PRODUCTS);
    }
}
