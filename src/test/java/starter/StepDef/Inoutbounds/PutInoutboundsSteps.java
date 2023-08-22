package starter.StepDef.Inoutbounds;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.Middleman.InoutboundsAPI;
import starter.Utils.Constants;

import java.io.File;

public class PutInoutboundsSteps {

    @Steps
    InoutboundsAPI inoutbounds;

    @And("Send put request inoutbounds")
    public void sendPutRequestInoutbounds() {
        SerenityRest.when()
                .put(InoutboundsAPI.PUT_INOUTBOUND);
    }

    @When("Update valid product id {string} inoutbounds and send with JSON file {string}")
    public void updateValidProductIdInoutboundsAndSendWithJSONFile(String id, String jsonName) {
        File json = new File(Constants.REQ_BODY_INOUTBOUNDS + "" + jsonName + "");
        inoutbounds.updateQtyInoutboundsQTY(json, id);
    }

    @And("Validate put response inoutbounds with JSON Schema {string}")
    public void validatePutResponseInoutboundsWithJSONSchema(String jsonSchName) {
        File jsonSchema = new File(Constants.JSON_SCHEMA_INOUTBOUNDS + ""+jsonSchName+"");
        SerenityRest.and()
                .assertThat()
                .body(JsonSchemaValidator.matchesJsonSchema(jsonSchema));
    }

    @When("Put product id {string} inoutbounds")
    public void putProductIdInoutbounds(String path) {
        inoutbounds.putInoutboundsWithoutToken(path);
    }

    @When("Update valid product id {string} inoutbounds")
    public void updateValidProductIdInoutbounds(String path) {
        inoutbounds.putInoutboundsInvalidToken(path);
    }


    @Given("Admin update valid product id {string} inoutbounds and send with JSON file {string}")
    public void adminUpdateValidProductIdInoutboundsAndSendWithJSONFile(String id, String jsonName) {
        File json = new File(Constants.REQ_BODY_INOUTBOUNDS + "" + jsonName + "");
        inoutbounds.adminUpdateQtyInoutboundsQTY(json, id);
    }
}
