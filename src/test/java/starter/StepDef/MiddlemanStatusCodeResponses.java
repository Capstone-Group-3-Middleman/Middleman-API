package starter.StepDef;

import io.cucumber.java.en.Then;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;

public class MiddlemanStatusCodeResponses {

    @Then("Status code should be {int} OK")
    public void statusCodeShouldBeOK(int statusCode) {
        SerenityRest.then()
                .statusCode(statusCode);
    }

    @Then("Status code should be {int} Created")
    public void statusCodeShouldBeCreated(int statusCode) {
        SerenityRest.then()
                .statusCode(statusCode);
    }

    @Then("Status code should be {int} No Content")
    public void statusCodeShouldBeNoContent(int statusCode) {
        SerenityRest.then()
                .statusCode(statusCode);
    }

    @Then("Status code should be {int} Unauthorized")
    public void statusCodeShouldBeUnauthorized(int statusCode) {
        SerenityRest.then()
                .statusCode(statusCode);
    }

    @Then("Status code should be {int} Bad Request")
    public void statusCodeShouldBeBadRequest(int statusCode) {
        SerenityRest.then()
                .statusCode(statusCode);
    }

    @Then("Status code should be {int} Not Found")
    public void statusCodeShouldBeNotFound(int statusCode) {
        SerenityRest.then()
                .statusCode(statusCode);
    }

    @Then("Status code should be {int} Internal Server Error")
    public void statusCodeShouldBeInternalServereError(int statusCode) {
        SerenityRest.then()
                .statusCode(statusCode);
    }
}