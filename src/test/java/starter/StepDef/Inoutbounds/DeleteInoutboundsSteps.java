package starter.StepDef.Inoutbounds;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.Middleman.InoutboundsAPI;


public class DeleteInoutboundsSteps {

    @Steps
    InoutboundsAPI inoutbounds;

    @And("Send delete request inoutbounds")
    public void sendDeleteRequestInoutbounds() {
        SerenityRest.when()
                .delete(InoutboundsAPI.DELETE_INOUTBOUND);
    }

    @When("User delete valid product id {string} inoutbounds")
    public void userDeleteValidProductIdInoutbounds(String path) {
        inoutbounds.deleteProductInoutboundsUser(path);
    }

    @Given("User delete inoutbounds with {string} path and {string} token")
    public void userDeleteInoutboundsWithPathAndToken(String path, String token) {
        if (path.equals("valid") && token.equals("valid")) {
            String param = "inoutbounds";
            inoutbounds.getUserInoutbounds();
        } else if (path.equals("valid") && token.equals("invalid")) {
            String param = "inoutbounds";
            inoutbounds.getInoutboundsInvalidToken();
        } else if (path.equals("valid") && token.equals("without")) {
            String param = "inoutbounds";
            inoutbounds.getUserInoutboundsWithoutToken();
        }
    }


    @When("Delete invalid product id {string} inoutbounds")
    public void deleteInvalidProductIdInoutbounds(String path) {
        inoutbounds.deleteInoutboundsWithoutToken(path);
    }

    @When("Admin delete valid product id {string} inoutbounds")
    public void deleteValidProductIdAdminInoutbounds(String path) {
        inoutbounds.deleteProductInoutboundsAdmin(path);
    }

    @When("Delete invalid product id {string} Inoutbounds")
    public void deleteInvalidProductIdIoutbounds(String path) {
        inoutbounds.deleteProductInoutboundsInvalid(path);
    }
}
