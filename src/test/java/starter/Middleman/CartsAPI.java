package starter.Middleman;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import starter.Utils.Constants;

public class CartsAPI {

    public static String GET_LIST_CARTS = Constants.BASE_URL + "/{path}";

    @Step
    public void getListCart(String path) {
        SerenityRest.given()
                .header("Authorization", "Bearer " + Constants.TOKEN_USER)
                .pathParam("path", path);
    }

    @Step
    public void getListCartInvalidToken(String path) {
        SerenityRest.given()
                .header("Authorization", "Bearer " + Constants.TOKEN_INVALID)
                .pathParam("path", path);
    }
}
